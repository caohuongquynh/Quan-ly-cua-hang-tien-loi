package com.store;

import com.store.view.LoginView;

public class Main {
    public static void main(String[] args) {
        // Thiết lập giao diện đẹp hơn (Nimbus)
        try {
            javax.swing.UIManager.setLookAndFeel("javax.swing.plaf.nimbus.NimbusLookAndFeel");
        } catch (Exception e) {
            // Nếu Nimbus không có thì dùng giao diện mặc định
            e.printStackTrace();
        }

        // Khởi chạy chương trình từ màn hình đăng nhập
        new LoginView().setVisible(true);
    }
}