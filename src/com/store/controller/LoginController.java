package com.store.controller;

import com.store.dao.EmployeeDAO;
import com.store.model.Employee;
import com.store.view.LoginView;
import com.store.view.MainView;

import javax.swing.*;
import java.awt.event.ActionEvent;

public class LoginController {
    private LoginView view;
    private EmployeeDAO employeeDAO;

    public LoginController(LoginView view) {
        this.view = view;
        this.employeeDAO = new EmployeeDAO();

        view.getBtnLogin().addActionListener(this::handleLogin);
    }

    private void handleLogin(ActionEvent e) {
        String username = view.getUsername().trim();
        String password = view.getPassword().trim();

        if (username.isEmpty() || password.isEmpty()) {
            JOptionPane.showMessageDialog(view, "Vui lòng nhập tên đăng nhập và mật khẩu!",
                    "Lỗi", JOptionPane.WARNING_MESSAGE);
            return;
        }

        Employee employee = employeeDAO.login(username, password);

        if (employee != null) {
            JOptionPane.showMessageDialog(view, "Đăng nhập thành công!\nXin chào: " + employee.getFullName(),
                    "Thành công", JOptionPane.INFORMATION_MESSAGE);

            view.dispose();
            new MainView(employee).setVisible(true);
        } else {
            JOptionPane.showMessageDialog(view, "Tên đăng nhập hoặc mật khẩu không đúng!",
                    "Đăng nhập thất bại", JOptionPane.ERROR_MESSAGE);
        }
    }
}