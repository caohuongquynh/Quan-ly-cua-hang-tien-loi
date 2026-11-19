package com.store.controller;

import com.store.dao.CustomerDAO;
import com.store.model.Customer;
import com.store.view.CustomerPanel;

import javax.swing.*;
import java.awt.event.ActionEvent;

public class CustomerController {
    private CustomerPanel view;
    private CustomerDAO dao;

    public CustomerController(CustomerPanel view) {
        this.view = view;
        this.dao = new CustomerDAO();

        view.getBtnAdd().addActionListener(this::addCustomer);
        view.getBtnEdit().addActionListener(this::editCustomer);
        view.getBtnDelete().addActionListener(this::deleteCustomer);
    }

    private void addCustomer(ActionEvent e) {
        String name = view.getTxtName().getText().trim();
        String phone = view.getTxtPhone().getText().trim();

        if (name.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Tên khách hàng không được để trống!");
            return;
        }

        Customer c = new Customer(0, name, phone, 0);
        dao.add(c);
        JOptionPane.showMessageDialog(null, "Thêm khách hàng thành công!");
        // Có thể load lại bảng nếu bạn thêm loadCustomers() vào view
    }

    private void editCustomer(ActionEvent e) {
        JOptionPane.showMessageDialog(null, "Chức năng sửa khách hàng sẽ được triển khai ở phiên bản sau.");
    }

    private void deleteCustomer(ActionEvent e) {
        JOptionPane.showMessageDialog(null, "Chức năng xóa khách hàng sẽ được triển khai ở phiên bản sau.");
    }
}