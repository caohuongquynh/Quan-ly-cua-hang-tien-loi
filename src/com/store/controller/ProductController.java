package com.store.controller;

import com.store.dao.CategoryDAO;
import com.store.dao.ProductDAO;
import com.store.model.Category;
import com.store.model.Product;
import com.store.view.ProductPanel;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionEvent;
import java.util.List;

public class ProductController {
    private ProductPanel view;
    private ProductDAO productDAO;
    private CategoryDAO categoryDAO;

    public ProductController(ProductPanel view) {
        this.view = view;
        this.productDAO = new ProductDAO();
        this.categoryDAO = new CategoryDAO();

        loadProducts();
        loadCategoriesIntoComboBox();

        // Gắn sự kiện
        view.getBtnAdd().addActionListener(this::addProduct);
        view.getBtnEdit().addActionListener(this::editProduct);
        view.getBtnDelete().addActionListener(this::deleteProduct);
        view.getBtnRefresh().addActionListener(e -> loadProducts());

        // Tìm kiếm realtime (khi gõ vào ô search)
        view.getTxtSearch().addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                searchProduct();
            }
        });
    }

    private void loadProducts() {
        List<Product> products = productDAO.getAll();
        view.loadProducts(products);
    }

    private void loadCategoriesIntoComboBox() {
        // Nếu muốn load danh mục động từ DB (tạm thời dùng hardcode như cũ)
        // List<Category> categories = categoryDAO.getAll();
        // Sau này có thể thay bằng code động
    }

    private void addProduct(ActionEvent e) {
        try {
            String name = view.getTxtName().getText().trim();
            if (name.isEmpty()) {
                JOptionPane.showMessageDialog(null, "Tên sản phẩm không được để trống!", "Lỗi", JOptionPane.WARNING_MESSAGE);
                return;
            }

            double price = Double.parseDouble(view.getTxtPrice().getText().trim());
            int quantity = Integer.parseInt(view.getTxtQuantity().getText().trim());
            int categoryId = view.getCbCategory().getSelectedIndex() + 1;

            Product p = new Product(0, name, price, quantity, categoryId);
            productDAO.add(p);

            JOptionPane.showMessageDialog(null, "Thêm sản phẩm thành công!", "Thành công", JOptionPane.INFORMATION_MESSAGE);
            loadProducts();
            clearForm();
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(null, "Giá và số lượng phải là số hợp lệ!", "Lỗi", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void editProduct(ActionEvent e) {
        int row = view.getTable().getSelectedRow();
        if (row == -1) {
            JOptionPane.showMessageDialog(null, "Vui lòng chọn sản phẩm cần sửa!", "Thông báo", JOptionPane.WARNING_MESSAGE);
            return;
        }

        try {
            int id = (int) view.getTableModel().getValueAt(row, 0);
            String name = view.getTxtName().getText().trim();
            double price = Double.parseDouble(view.getTxtPrice().getText().trim());
            int quantity = Integer.parseInt(view.getTxtQuantity().getText().trim());
            int categoryId = view.getCbCategory().getSelectedIndex() + 1;

            Product p = new Product(id, name, price, quantity, categoryId);
            productDAO.update(p);

            JOptionPane.showMessageDialog(null, "Cập nhật sản phẩm thành công!");
            loadProducts();
            clearForm();
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "Có lỗi khi cập nhật: " + ex.getMessage(), "Lỗi", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void deleteProduct(ActionEvent e) {
        int row = view.getTable().getSelectedRow();
        if (row == -1) {
            JOptionPane.showMessageDialog(null, "Vui lòng chọn sản phẩm cần xóa!", "Thông báo", JOptionPane.WARNING_MESSAGE);
            return;
        }

        int confirm = JOptionPane.showConfirmDialog(null,
                "Bạn có chắc chắn muốn xóa sản phẩm này?",
                "Xác nhận xóa", JOptionPane.YES_NO_OPTION);

        if (confirm == JOptionPane.YES_OPTION) {
            int id = (int) view.getTableModel().getValueAt(row, 0);
            productDAO.delete(id);
            JOptionPane.showMessageDialog(null, "Đã xóa sản phẩm thành công!");
            loadProducts();
        }
    }

    private void searchProduct() {
        String keyword = view.getTxtSearch().getText().trim();
        if (keyword.isEmpty()) {
            loadProducts();
            return;
        }
        List<Product> result = productDAO.search(keyword);
        view.loadProducts(result);
    }

    private void clearForm() {
        view.getTxtName().setText("");
        view.getTxtPrice().setText("");
        view.getTxtQuantity().setText("");
        view.getCbCategory().setSelectedIndex(0);
    }
}