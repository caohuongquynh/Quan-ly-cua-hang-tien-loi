package com.store.dao;

import com.store.model.Invoice;
import com.store.model.InvoiceDetail;
import com.store.util.DBConnection;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class InvoiceDAO {

    // Tạo hóa đơn mới và trả về ID
    public int createInvoice(Invoice invoice) {
        String sql = "INSERT INTO invoices(total, customer_id, employee_id) VALUES(?,?,?)";
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {

            ps.setDouble(1, invoice.getTotal());
            ps.setObject(2, invoice.getCustomerId() == 0 ? null : invoice.getCustomerId());
            ps.setInt(3, invoice.getEmployeeId());

            ps.executeUpdate();
            ResultSet rs = ps.getGeneratedKeys();
            if (rs.next()) {
                return rs.getInt(1);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return -1;
    }

    // Thêm chi tiết hóa đơn
    public void addInvoiceDetail(int invoiceId, InvoiceDetail detail) {
        String sql = "INSERT INTO invoice_details(invoice_id, product_id, quantity, price) VALUES(?,?,?,?)";
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setInt(1, invoiceId);
            ps.setInt(2, detail.getProductId());
            ps.setInt(3, detail.getQuantity());
            ps.setDouble(4, detail.getPrice());
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Cập nhật tồn kho sau khi bán
    public void updateProductQuantity(int productId, int soldQuantity) {
        String sql = "UPDATE products SET quantity = quantity - ? WHERE id = ?";
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setInt(1, soldQuantity);
            ps.setInt(2, productId);
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}