# Kiến trúc Spring

Spring có 20 modules khác nhau có thể được tóm tắt trong 7 modules chính dưới đây:

<div align="center">
    <img src="spring-architecture.png" />
</div>

## Core modules

### Core

Spring Core module cung cấp các cách để tạo Spring beans và ```injecting``` các phụ thuộc(dependencies) vào beans. Nó cung cấp một phương tiện để cấu hình beans và cách để lấy (obtain) các beans đã cấu hình đó. Spring container sử dụng ```BeanFactory``` và ```ApplicationContext``` để phát triển một ứng dụng standalone.

### Beans

Beans module cung cấp ```BeanFactory``` cung cấp sự thay thế cho programmatic singletons. BeanFactory module được thiết kế dựa trên *factory pattern*.

### Context

Context module kế thừa các tính năng từ beans module và hỗ trợ các tính năng Java enterprise như EJB, JMX, loading tài nguyên, và basic remoting. Nó hỗ trợ tích hợp các thư viện cho việc caching, Java Mailing và template engines như Velocity

### SpEL

**Spring Expression Language** (SpEL) module hỗ trợ việc setting, getting các giá trị thuộc tính và cấu hình các collections sử dụng các toán tử logic và toán học.

