package com.store.controller;

import com.store.dao.InvoiceDAO;
import com.store.dao.ProductDAO;
import com.store.model.Invoice;
import com.store.model.InvoiceDetail;
import com.store.model.Product;
import com.store.view.InvoicePanel;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionEvent;
import java.util.ArrayList;
import java.util.List;

public class InvoiceController {
    private InvoicePanel view;
    private InvoiceDAO invoiceDAO;
    private ProductDAO productDAO;
    private List<InvoiceDetail> cart = new ArrayList<>(); // Giỏ hàng tạm

    public InvoiceController(InvoicePanel view) {
        this.view = view;
        this.invoiceDAO = new InvoiceDAO();
        this.productDAO = new ProductDAO();

        view.getBtnAddToCart().addActionListener(this::addToCart);
        view.getBtnRemoveFromCart().addActionListener(this::removeFromCart);
        view.getBtnSaveInvoice().addActionListener(this::saveInvoice);
        view.getBtnPrint().addActionListener(this::printInvoice);
    }

    private void addToCart(ActionEvent e) {
        // Hiện tại dùng search đơn giản - bạn có thể cải tiến bằng JDialog chọn sản phẩm
        String search = view.getTxtProductSearch().getText().trim();
        if (search.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Vui lòng nhập tên hoặc mã sản phẩm!");
            return;
        }

        List<Product> found = productDAO.search(search);
        if (found.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Không tìm thấy sản phẩm!");
            return;
        }

        // Lấy sản phẩm đầu tiên tìm được (có thể cải tiến thành chọn từ list)
        Product p = found.get(0);

        String qtyStr = JOptionPane.showInputDialog("Nhập số lượng cho " + p.getName() + ":");
        if (qtyStr == null || qtyStr.trim().isEmpty()) return;

        try {
            int qty = Integer.parseInt(qtyStr);
            if (qty <= 0 || qty > p.getQuantity()) {
                JOptionPane.showMessageDialog(null, "Số lượng không hợp lệ hoặc vượt tồn kho!");
                return;
            }

            double lineTotal = p.getPrice() * qty;
            InvoiceDetail detail = new InvoiceDetail(0, 0, p.getId(), qty, p.getPrice());
            cart.add(detail);

            // Thêm vào bảng giỏ
            ((DefaultTableModel) view.getCartModel()).addRow(new Object[]{
                    p.getId(), p.getName(), qty, p.getPrice(), lineTotal
            });

            updateTotal();
            view.getTxtProductSearch().setText(""); // Xóa ô tìm kiếm
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(null, "Số lượng phải là số nguyên!");
        }
    }

    private void removeFromCart(ActionEvent e) {
        int row = view.getCartTable().getSelectedRow();
        if (row == -1) {
            JOptionPane.showMessageDialog(null, "Chọn sản phẩm trong giỏ để xóa!");
            return;
        }
        cart.remove(row);
        ((DefaultTableModel) view.getCartModel()).removeRow(row);
        updateTotal();
    }

    private void updateTotal() {
        double total = 0;
        for (InvoiceDetail d : cart) {
            total += d.getPrice() * d.getQuantity();
        }
        view.getLblTotal().setText(String.format("%,.0f VNĐ", total));
    }

    private void saveInvoice(ActionEvent e) {
        if (cart.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Giỏ hàng đang trống!");
            return;
        }

        double total = 0;
        for (InvoiceDetail d : cart) total += d.getPrice() * d.getQuantity();

        // Giả sử employee_id = 1 (admin). Bạn có thể lấy từ session sau
        Invoice invoice = new Invoice(0, total, 0, 1); // customer_id tạm = 0

        int invoiceId = invoiceDAO.createInvoice(invoice);
        if (invoiceId > 0) {
            for (InvoiceDetail detail : cart) {
                detail.setInvoiceId(invoiceId);
                invoiceDAO.addInvoiceDetail(invoiceId, detail);
                // Giảm tồn kho
                invoiceDAO.updateProductQuantity(detail.getProductId(), detail.getQuantity());
            }

            JOptionPane.showMessageDialog(null, "Lưu hóa đơn thành công! ID: " + invoiceId);
            cart.clear();
            ((DefaultTableModel) view.getCartModel()).setRowCount(0);
            updateTotal();
        } else {
            JOptionPane.showMessageDialog(null, "Lưu hóa đơn thất bại!", "Lỗi", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void printInvoice(ActionEvent e) {
        JOptionPane.showMessageDialog(null, "Chức năng in hóa đơn đang được phát triển.\nBạn có thể dùng PrinterJob hoặc JasperReports sau.");
    }
}