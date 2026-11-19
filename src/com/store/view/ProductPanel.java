package com.store.view;

import com.store.model.Product;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.util.List;

public class ProductPanel extends JPanel {
    private JTable table;
    private DefaultTableModel tableModel;
    private JTextField txtSearch, txtName, txtPrice, txtQuantity;
    private JComboBox<String> cbCategory;
    private JButton btnAdd, btnEdit, btnDelete, btnRefresh;

    public ProductPanel() {
        setLayout(new BorderLayout(10, 10));
        setBorder(BorderFactory.createEmptyBorder(15, 15, 15, 15));

        // Top - Search
        JPanel top = new JPanel(new FlowLayout(FlowLayout.LEFT));
        txtSearch = new JTextField(20);
        btnRefresh = new JButton("🔄 Làm mới");
        top.add(new JLabel("Tìm kiếm:"));
        top.add(txtSearch);
        top.add(btnRefresh);

        // Table
        String[] cols = {"ID", "Tên sản phẩm", "Giá (VNĐ)", "Tồn kho", "Danh mục"};
        tableModel = new DefaultTableModel(cols, 0);
        table = new JTable(tableModel);
        table.setRowHeight(28);

        // Form
        JPanel form = new JPanel(new GridLayout(4, 2, 10, 10));
        txtName = new JTextField();
        txtPrice = new JTextField();
        txtQuantity = new JTextField();
        cbCategory = new JComboBox<>(new String[]{"Đồ uống", "Đồ ăn vặt", "Mỹ phẩm", "Khác"});

        form.add(new JLabel("Tên sản phẩm:")); form.add(txtName);
        form.add(new JLabel("Giá:")); form.add(txtPrice);
        form.add(new JLabel("Tồn kho:")); form.add(txtQuantity);
        form.add(new JLabel("Danh mục:")); form.add(cbCategory);

        // Buttons
        JPanel btnPanel = new JPanel();
        btnAdd = new JButton("➕ Thêm");
        btnEdit = new JButton("✏️ Sửa");
        btnDelete = new JButton("🗑️ Xóa");
        btnPanel.add(btnAdd);
        btnPanel.add(btnEdit);
        btnPanel.add(btnDelete);

        add(top, BorderLayout.NORTH);
        add(new JScrollPane(table), BorderLayout.CENTER);
        add(form, BorderLayout.SOUTH);
        add(btnPanel, BorderLayout.SOUTH);
    }

    public void loadProducts(List<Product> products) {
        tableModel.setRowCount(0);
        for (Product p : products) {
            tableModel.addRow(new Object[]{
                    p.getId(), p.getName(), p.getPrice(), p.getQuantity(), p.getCategoryId()
            });
        }
    }

    public JTable getTable() { return table; }
    public DefaultTableModel getTableModel() { return tableModel; }
    public JTextField getTxtSearch() { return txtSearch; }
    public JTextField getTxtName() { return txtName; }
    public JTextField getTxtPrice() { return txtPrice; }
    public JTextField getTxtQuantity() { return txtQuantity; }
    public JComboBox<String> getCbCategory() { return cbCategory; }
    public JButton getBtnAdd() { return btnAdd; }
    public JButton getBtnEdit() { return btnEdit; }
    public JButton getBtnDelete() { return btnDelete; }
    public JButton getBtnRefresh() { return btnRefresh; }
}