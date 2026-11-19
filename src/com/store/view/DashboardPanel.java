package com.store.view;

import javax.swing.*;
import java.awt.*;

public class DashboardPanel extends JPanel {

    public DashboardPanel() {
        setLayout(new GridLayout(2, 2, 20, 20));
        setBorder(BorderFactory.createEmptyBorder(30, 30, 30, 30));
        setBackground(new Color(245, 245, 245));

        add(createCard("👋 Xin chào!", "Chúc bạn bán hàng tốt hôm nay!", new Color(52, 152, 219)));
        add(createCard("💰 Doanh thu hôm nay", "0 VNĐ", new Color(46, 204, 113)));
        add(createCard("📦 Tổng sản phẩm", "0", new Color(241, 196, 15)));
        add(createCard("⚠️ Sắp hết hàng", "0 sản phẩm", new Color(231, 76, 60)));
    }

    private JPanel createCard(String title, String value, Color color) {
        JPanel panel = new JPanel(new BorderLayout());
        panel.setBackground(Color.WHITE);
        panel.setBorder(BorderFactory.createLineBorder(color, 5));

        JLabel lblTitle = new JLabel(title, SwingConstants.CENTER);
        lblTitle.setFont(new Font("Segoe UI", Font.BOLD, 16));
        lblTitle.setForeground(color);
        panel.add(lblTitle, BorderLayout.NORTH);

        JLabel lblValue = new JLabel(value, SwingConstants.CENTER);
        lblValue.setFont(new Font("Segoe UI", Font.BOLD, 22));
        panel.add(lblValue, BorderLayout.CENTER);

        return panel;
    }
}