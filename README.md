

   - Repository: [Library Management Frontend](https://github.com/hnguyen04/library-management-frontend)
   - Công nghệ: ReactJS

2. **Backend**
   - Repository: [Library Management Backend](https://github.com/hnguyen04/library-management-backend)
   - Công nghệ: Java Spring Boot
   - Cơ sở dữ liệu: PostgreSQL

---

## Cài đặt
### Yêu cầu hệ thống:
- **Node.js** (v18 trở lên)
- **Java JDK** (17 trở lên)
- **PostgreSQL** (15 trở lên)

### Cài đặt Frontend:
1. Clone repository:
   ```bash
   git clone https://github.com/hnguyen04/library-management-frontend.git
   cd library-management-frontend

2. Cài đặt các gói phụ thuộc:
   ```bash
   yarn install
   ```
3. Tạo file `.env.local` và thêm đường dẫn backend (ví dụ):
   ```bash
   VITE_API_ENDPOINT=http://localhost:8080
   ```
4. Chạy ứng dụng:
   ```bash
   yarn dev
   ```
Ứng dụng sẽ chạy tại: http://localhost:5173/

### Cài đặt Backend:
1. Clone repository:
   ```bash
   git clone https://github.com/hnguyen04/library-management-backend.git
   cd library-management-backend
2. Chạy ứng dụng (recommend chạy trên IntelliJ IDEA)
  - Mở IntelliJ, chọn File > Open.
  - Dẫn đến thư mục dự án library-management-backend và mở.
  - Trong IntelliJ, tìm file LibraryBackendManagementApplication.java trong thư mục src/main/java.
  - Nhấn chuột phải và chọn Run 'LibraryBackendManagementApplication'.
  - Backend sẽ chạy tại: http://localhost:8080.

## Hướng dẫn sử dụng  
1. Mở trình duyệt và truy cập [http://localhost:5173](http://localhost:5173).  
2. Đăng nhập bằng tài khoản mẫu:  
   - **Admin:**  
     - **Username:** `admin`  
     - **Password:** `admin`  
3. Sử dụng các chức năng chính của hệ thống:  
   - **Quản lý sách:** Thêm, chỉnh sửa, xóa sách.
   - **Theo dõi độc giả:** Xem danh sách độc giả và lịch sử mượn sách.  
   - **Quản lý tài khoản:** Tạo và quản lý tài khoản nhân viên.
  
## Tài liệu tham khảo  
- [ReactJS Documentation](https://reactjs.org/docs/getting-started.html)  
- [Spring Boot Reference Guide](https://docs.spring.io/spring-boot/docs/current/reference/htmlsingle/)  
- [PostgreSQL Documentation](https://www.postgresql.org/docs/)  
