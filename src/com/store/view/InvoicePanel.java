package com.store.view;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;

public class InvoicePanel extends JPanel {
    private JTable cartTable;
    private DefaultTableModel cartModel;
    private JTextField txtProductSearch, txtCustomerPhone;
    private JLabel lblTotal;
    private JButton btnAddToCart, btnRemoveFromCart, btnSaveInvoice, btnPrint;

    public InvoicePanel() {
        setLayout(new BorderLayout(10, 10));

        // Left - Cart
        JPanel left = new JPanel(new BorderLayout());
        txtProductSearch = new JTextField(15);
        left.add(new JLabel("Tìm sản phẩm:"), BorderLayout.NORTH);
        left.add(txtProductSearch, BorderLayout.NORTH);

        String[] cols = {"ID", "Tên SP", "SL", "Đơn giá", "Thành tiền"};
        cartModel = new DefaultTableModel(cols, 0);
        cartTable = new JTable(cartModel);
        left.add(new JScrollPane(cartTable), BorderLayout.CENTER);

        // Right - Info
        JPanel right = new JPanel(new GridLayout(6, 1, 8, 8));
        txtCustomerPhone = new JTextField();
        lblTotal = new JLabel("0 VNĐ", SwingConstants.RIGHT);
        lblTotal.setFont(new Font("Segoe UI", Font.BOLD, 22));

        right.add(new JLabel("SĐT khách hàng:"));
        right.add(txtCustomerPhone);
        right.add(new JLabel("TỔNG TIỀN:"));
        right.add(lblTotal);

        btnAddToCart = new JButton("➕ Thêm vào giỏ");
        btnRemoveFromCart = new JButton("🗑️ Xóa");
        btnSaveInvoice = new JButton("💾 Lưu hóa đơn");
        btnPrint = new JButton("🖨️ In hóa đơn");

        right.add(btnAddToCart);
        right.add(btnRemoveFromCart);
        right.add(btnSaveInvoice);
        right.add(btnPrint);

        add(left, BorderLayout.CENTER);
        add(right, BorderLayout.EAST);
    }

    public JTable getCartTable() { return cartTable; }
    public DefaultTableModel getCartModel() { return cartModel; }
    public JTextField getTxtProductSearch() { return txtProductSearch; }
    public JTextField getTxtCustomerPhone() { return txtCustomerPhone; }
    public JLabel getLblTotal() { return lblTotal; }
    public JButton getBtnAddToCart() { return btnAddToCart; }
    public JButton getBtnRemoveFromCart() { return btnRemoveFromCart; }
    public JButton getBtnSaveInvoice() { return btnSaveInvoice; }
    public JButton getBtnPrint() { return btnPrint; }
}