# Hệ Thống Quản Lý Cửa Hàng Tiện Lợi (Convenience Store Management)

Một ứng dụng Desktop Application được xây dựng bằng **Java Swing** và mô hình **MVC (Model - View - Controller)** kết hợp cơ sở dữ liệu **MySQL** thông qua **JDBC**. Ứng dụng giúp quản lý toàn diện các hoạt động cơ bản của một cửa hàng tiện lợi như bán hàng, quản lý nhân viên, khách hàng và kho sản phẩm.

---

## 🌟 Các Tính Năng Chính (Features)

1. **🔒 Đăng Nhập & Phân Quyền**: Xác thực nhân viên/quản lý để truy cập vào hệ thống.
2. **🏠 Bảng Điều Khiển (Dashboard)**: Nơi hiển thị thông tin tổng quan, truy cập nhanh các chức năng.
3. **📦 Quản Lý Sản Phẩm (Product Management)**: Thêm, sửa, xóa, và tìm kiếm thông tin hàng hóa trong kho.
4. **🛒 Bán Hàng (Invoice/POS)**: Chức năng tính tiền, tạo hóa đơn mua hàng cho khách hàng.
5. **👥 Quản Lý Khách Hàng (Customer Management)**: Lưu trữ thông tin khách hàng thân thiết.
6. **👤 Quản Lý Nhân Viên (Employee Management)**: Theo dõi thông tin nhân viên (dành cho quản lý).

---

## 🛠️ Công Nghệ & Cấu Trúc (Technologies & Architecture)

Dự án được xây dựng dựa trên các công nghệ tiêu chuẩn của Java Desktop:
- **Ngôn ngữ**: Java (JDK 8 trở lên)
- **Giao diện (GUI)**: Java Swing
- **Kiến trúc**: MVC (Model - View - Controller)
- **Cơ sở dữ liệu**: MySQL
- **Kết nối DB**: JDBC (Java Database Connectivity)

### 📂 Cấu trúc thư mục (Project Structure)
Dự án được chia thành các package chuẩn theo mô hình MVC:
- `com.store.model`: Chứa các đối tượng dữ liệu (Product, Customer, Employee, Invoice, Category...)
- `com.store.view`: Chứa các giao diện hiển thị (DashboardPanel, LoginView, ProductPanel, InvoicePanel...)
- `com.store.controller`: Xử lý logic và kết nối giữa View và Model
- `com.store.dao`: Data Access Object - Chứa các truy vấn tương tác trực tiếp với cơ sở dữ liệu MySQL
- `com.store.util`: Chứa các class hỗ trợ (ví dụ: `DBConnection` để kết nối MySQL)

---

## 🚀 Hướng Dẫn Cài Đặt (Installation)

1. **Clone dự án về máy:**
   ```bash
   git clone https://github.com/ngocanh-dev2209/convenience-store-management.git
   ```

2. **Cấu hình Cơ sở dữ liệu (MySQL):**
   - Tạo một database mới trong MySQL.
   - Chạy script SQL (nếu có) để tạo các bảng cần thiết.
   - Cập nhật thông tin kết nối (Username, Password, Tên DB) trong file `com.store.util.DBConnection`.

3. **Chạy ứng dụng:**
   - Mở dự án bằng IDE (IntelliJ IDEA, Eclipse, hoặc NetBeans).
   - Đảm bảo đã import thư viện `mysql-connector-java.jar` vào project.
   - Chạy file `com.store.Main.java` để khởi động ứng dụng.

---

## 🤝 Đóng Góp (Contributing)
Mọi đóng góp để phát triển dự án đều được hoan nghênh. Xin vui lòng tạo Pull Request hoặc mở Issue nếu bạn tìm thấy lỗi.
