# Những vấn đề được đặt ra bởi Spring

Nền tảng Java phát triển nhanh chóng và mở rộng. Các ứng dụng diễn ra trên một phiên bản cụ thể nào đó. Các ứng dụng cần phải được nâng cấp để duy trì những tiêu chuẩn mới. Có nhiều ```class``` trong ứng dụng tương tác với nhau và tái sử dụng các API để đảm bảo ứng dụng chạy mượt. Tuy nhiên điều này dấn đến các vấn đề chung như: tính mở rộng, plumbing code, boilerplate code, và unit testing.

## Tính mở rộng (Scalabity)

Có nghĩa là ứng dụng mà chúng ta develop hôm nay có khả năng xử lý các nhu cầu sẽ có và phát triển mà không ảnh hướng đên sự làm việc của ứng dụng hôm sau. Scalabity của một ứng dụng là sự hỗ trợ và xử lý việc tăng tải làm việc để chỉnh sửa môi trường phát triển thay vì phải thay thế chúng.

## Plubming code

Trong nhiều trường hợp sẽ có những đoạn mã không thể nào bỏ qua, vì nếu không có thì ứng dụng sẽ không làm việc như yêu cầu, ví dụ như: để xử lý ngoại lệ trong Java ta cần bọc đoạn mã trong khối ```try ... catch``` hay thực hiện các giao diện CSDL (database transactions) ta cần sử dụng ```commit()``` và ```rollback()```

## Boilerplate code

Là đoạn mã lặp lại mà devs cần phải viết nhiều nơi với ít hoặc không có thay đổi để thực hiện tasks nào đó được gọi là ```Boilerplate code```. Ví dụ để thực thị mã JDBC, chúng ta cần thực hiện các bước: đăng ký ```Driver``` gọi method ```getConnection()``` trên ```DriverManager``` để lấy ```Connection``` và sau đó tạo ```Statement/Prepared Statement```.

## Unavoidable non-functional code

Khi phát triển ứng dụng devs tập trung vào business logic của ứng dụng. Tuy nhiên cùng với điều đó devs cũng phải nghĩ rằng làm sao để quản lý transactions, xử lý an toàn, an ninh trong ứng dụng. Quan sát rõ hơn thì ta thấy rằng vấn đề trên không phải những vấn đề cơ bản của ứng dụng những vẫn cần phải có.

## Unit testing of the application

Giả sử, chúng ta muốn test mã là lưu dữ liệu vào table trong database để chắc rằng đoạn mã được viết có hoạt động hay không. Mà ứng dụng chứa nhiều các class mà phụ thuộc lẫn nhau. Sự phụ thuộc (```dependency```) tồn tại giữa các class điều này dẫn đến khó để thực hiện test.

## POJO-based development

Spring không bắt buộc các class phải implementation hoặc extension từ framework, vì điều này dẫn đến việc kết dính và khó duy trì. Thay vào đó Spring khuyến khích viết các class dựa trên POJO tức là các class thông thường không có các phụ thuộc vào framework.

## Loose coupling through the dependency injection

*Coupling is the degree of knowledge one class has about the other class* Khi một class ít phụ thuộc vào một class khác, nó được gọi là ```loose coupled```. Loose coupling có thể đạt được bằng lập trình giao diện. Trong Spring Framework, ta giữ các phụ thuộc (dependencies) của class tách biệt code trong một file cấu hình.

## Declarative programming

Trong ```Declarative programming```, đoạn mã tuyên bố rằng nó sẽ thực hiện gì nhưng không biết sẽ thực hiện như thế nào.

## Boilerplate code reduction using aspects and templates

Mã ```Boilerplate``` là cần thiết không có nó, việc cung cấp transactions, security logging, v.v sẽ trở nên khó khăn. Framework đưa ra một giải pháp về viết một ```Aspect``` mà sẽ đối phó với những vấn đề ```cross-curring concerns``` trên mà không cần phải viết chúng cùng với mã business logic. 

Việc sử dụng ```Aspect``` giúp chúng ta giảm ```boilerplate code``` và devs vấn đạt được những điều mong muốn.

Template cho những yêu cầu khác nhau là một thứ được framework cung cấp. Các Template như ```JDBCTemplate```, HibernateTemplate được cung cấp bởi Spring để giảm ```boilerplate code```.

## Layered architecture

Không như Struts và Hibernate cung cấp các giải pháp web liên tục tương ứng, Spring có một phạm vi rộng các modules cho các vấn đề phát triển doanh nghiệp lớn. Kiến trúc phân tầng giúp devs chọn bất kỳ một hoặc nhiều modules để viết solutions cho ứng dụng của họ. Ví dụ chọn Web MVC module để xử lý web request mà không cần biết các modules có sắn khác trong framework.