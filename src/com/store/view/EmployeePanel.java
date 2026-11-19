package com.store.view;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;

public class EmployeePanel extends JPanel {
    private JTable table;
    private DefaultTableModel model;
    private JTextField txtFullName, txtUsername, txtPassword;
    private JComboBox<String> cbRole;
    private JButton btnAdd, btnEdit, btnDelete;

    public EmployeePanel() {
        setLayout(new BorderLayout());

        // Table
        String[] cols = {"ID", "Họ tên", "Username", "Vai trò"};
        model = new DefaultTableModel(cols, 0);
        table = new JTable(model);

        // Form
        JPanel form = new JPanel(new GridLayout(4, 2, 10, 10));
        txtFullName = new JTextField();
        txtUsername = new JTextField();
        txtPassword = new JPasswordField();
        cbRole = new JComboBox<>(new String[]{"STAFF", "ADMIN"});

        form.add(new JLabel("Họ tên:"));
        form.add(txtFullName);
        form.add(new JLabel("Username:"));
        form.add(txtUsername);
        form.add(new JLabel("Mật khẩu:"));
        form.add(txtPassword);
        form.add(new JLabel("Vai trò:"));
        form.add(cbRole);

        // Buttons
        JPanel btnPanel = new JPanel();
        btnAdd = new JButton("➕ Thêm");
        btnEdit = new JButton("✏️ Sửa");
        btnDelete = new JButton("🗑️ Xóa");
        btnPanel.add(btnAdd);
        btnPanel.add(btnEdit);
        btnPanel.add(btnDelete);

        add(new JScrollPane(table), BorderLayout.CENTER);
        add(form, BorderLayout.NORTH);
        add(btnPanel, BorderLayout.SOUTH);
    }

    // Getter
    public JTable getTable() { return table; }
    public DefaultTableModel getModel() { return model; }
    public JTextField getTxtFullName() { return txtFullName; }
    public JTextField getTxtUsername() { return txtUsername; }
    public JTextField getTxtPassword() { return txtPassword; }
    public JComboBox<String> getCbRole() { return cbRole; }
    public JButton getBtnAdd() { return btnAdd; }
    public JButton getBtnEdit() { return btnEdit; }
    public JButton getBtnDelete() { return btnDelete; }
}