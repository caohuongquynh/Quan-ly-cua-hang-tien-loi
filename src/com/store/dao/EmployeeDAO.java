package com.store.dao;

import com.store.model.Employee;
import com.store.util.DBConnection;
import java.sql.*;

public class EmployeeDAO {

    public Employee login(String username, String password) {
        String sql = "SELECT * FROM employees WHERE username = ? AND password = ?";
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, username);
            ps.setString(2, password);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                return new Employee(
                        rs.getInt("id"),
                        rs.getString("username"),
                        rs.getString("password"),
                        rs.getString("role"),
                        rs.getString("full_name")
                );
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    // Có thể thêm getAll, add, update... nếu cần quản lý nhân viên
}