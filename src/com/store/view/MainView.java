package com.store.view;

import com.store.model.Employee;
import javax.swing.*;
import java.awt.*;

public class MainView extends JFrame {
    private JPanel sidebar;
    private JPanel contentPanel;
    private CardLayout cardLayout;
    private Employee currentUser;

    private DashboardPanel dashboardPanel;
    private ProductPanel productPanel;
    private InvoicePanel invoicePanel;
    private CustomerPanel customerPanel;
    private EmployeePanel employeePanel;

    public MainView(Employee user) {
        this.currentUser = user;
        setTitle("Hệ Thống Quản Lý Cửa Hàng Tiện Lợi - " + user.getFullName());
        setSize(1200, 700);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        // Sidebar
        sidebar = new JPanel();
        sidebar.setLayout(new BoxLayout(sidebar, BoxLayout.Y_AXIS));
        sidebar.setBackground(new Color(33, 37, 41));
        sidebar.setPreferredSize(new Dimension(240, 0));

        addSidebarButton("🏠 Trang chủ", "dashboard");
        addSidebarButton("📦 Quản lý Sản phẩm", "product");
        addSidebarButton("🛒 Bán hàng", "invoice");
        addSidebarButton("👥 Khách hàng", "customer");
        addSidebarButton("👤 Nhân viên", "employee");
        addSidebarButton("🚪 Đăng xuất", null);

        // Content Panel
        cardLayout = new CardLayout();
        contentPanel = new JPanel(cardLayout);

        dashboardPanel = new DashboardPanel();
        productPanel = new ProductPanel();
        invoicePanel = new InvoicePanel();
        customerPanel = new CustomerPanel();
        employeePanel = new EmployeePanel();

        contentPanel.add(dashboardPanel, "dashboard");
        contentPanel.add(productPanel, "product");
        contentPanel.add(invoicePanel, "invoice");
        contentPanel.add(customerPanel, "customer");
        contentPanel.add(employeePanel, "employee");

        setLayout(new BorderLayout());
        add(sidebar, BorderLayout.WEST);
        add(contentPanel, BorderLayout.CENTER);

        showPanel("dashboard");
    }

    private void addSidebarButton(String text, String panelName) {
        JButton btn = new JButton(text);
        btn.setForeground(Color.WHITE);
        btn.setBackground(new Color(33, 37, 41));
        btn.setBorderPainted(false);
        btn.setFocusPainted(false);
        btn.setAlignmentX(Component.LEFT_ALIGNMENT);
        btn.setMaximumSize(new Dimension(240, 55));
        btn.setFont(new Font("Segoe UI", Font.PLAIN, 14));

        if (panelName != null) {
            btn.addActionListener(e -> showPanel(panelName));
        } else {
            btn.addActionListener(e -> {
                int confirm = JOptionPane.showConfirmDialog(this, "Bạn có muốn đăng xuất?", "Đăng xuất", JOptionPane.YES_NO_OPTION);
                if (confirm == JOptionPane.YES_OPTION) {
                    dispose();
                    new LoginView().setVisible(true);
                }
            });
        }
        sidebar.add(btn);
        sidebar.add(Box.createRigidArea(new Dimension(0, 5)));
    }

    private void showPanel(String name) {
        cardLayout.show(contentPanel, name);
    }
}