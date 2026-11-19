package com.store.view;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;

public class CustomerPanel extends JPanel {
    private JTable table;
    private DefaultTableModel model;
    private JTextField txtName, txtPhone;
    private JButton btnAdd, btnEdit, btnDelete;

    public CustomerPanel() {
        setLayout(new BorderLayout());

        String[] cols = {"ID", "Tên khách hàng", "SĐT", "Điểm tích lũy"};
        model = new DefaultTableModel(cols, 0);
        table = new JTable(model);

        JPanel form = new JPanel(new GridLayout(2, 2, 10, 10));
        txtName = new JTextField();
        txtPhone = new JTextField();
        form.add(new JLabel("Tên khách:")); form.add(txtName);
        form.add(new JLabel("SĐT:")); form.add(txtPhone);

        JPanel btnPanel = new JPanel();
        btnAdd = new JButton("Thêm");
        btnEdit = new JButton("Sửa");
        btnDelete = new JButton("Xóa");
        btnPanel.add(btnAdd);
        btnPanel.add(btnEdit);
        btnPanel.add(btnDelete);

        add(new JScrollPane(table), BorderLayout.CENTER);
        add(form, BorderLayout.NORTH);
        add(btnPanel, BorderLayout.SOUTH);
    }

    public JTable getTable() { return table; }
    public DefaultTableModel getModel() { return model; }
    public JTextField getTxtName() { return txtName; }
    public JTextField getTxtPhone() { return txtPhone; }
    public JButton getBtnAdd() { return btnAdd; }
    public JButton getBtnEdit() { return btnEdit; }
    public JButton getBtnDelete() { return btnDelete; }
}