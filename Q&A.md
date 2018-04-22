# Q&A

## #1 Phục vụ tài nguyên tĩnh với Spring

### 1. Mục đích

Bài viết này hướng dẫn cách để public và cache các tài nguyên tĩnh của bạn. Tài nguyên ở đây là các files.

### 2. ResourceHttpRequestHandler

**Spring 3.1** cung cấp *ResourceHandlerRegistry* để cấu hình các *ResourceHttpRequestHandlers* để phục vụ các tài nguyên tĩnh (/resources/static) từ classpath, hoặc WAR hay từ hệ thống file trên máy của bạn. Nói đơn giản là công URI ánh xạ đến các files trong hệ thống file của bạn.

### 2.1. Công bố một tài nguyên được lưu trong file WAR

Giả sử file bạn muốn public ở folder /resources theo cấu trúc project Spring.

```java
@Configuration
@EnableWebMvc
public class MvcConfig extends WebMvcConfigurerAdapter {
    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry
          .addResourceHandler("/resources/**")
          .addResourceLocations("/resources/"); 
    }
}
```

Hãy phân tích đoạn mã trên. Đầu tiên bạn cấu hình *enternal URL path* bằng việc khai báo thêm một resouce handler. Sau đó bạn sẽ ánh xạ *enternal URL path* đó với đường dẫn trỏ đến vị trí tài nguyên mà bạn muốn public.

Bạn có định nghĩa nhiều resource handler mà bạn muốn.

Bây giờ - bạn muốn trỏ đến file *myCSS.css* trong tài nguyên bạn public chẳng hạn. Bạn có thể trỏ đến như sau:

```html
<link href="<c:url value="/resources/myCss.css" />" rel="stylesheet">
```

### 2.2. Công bố một tài nguyên được lưu trong hệ thống file

giả sử bạn muốn công bố một tài nguyên được lưu tại thự mục */opt/files/* 

```java
@Override
public void addResourceHandlers(ResourceHandlerRegistry registry) {
    registry
      .addResourceHandler("/files/**")
      .addResourceLocations("file:/opt/files/");
 }
```

(Trên Window: tham số *addResourceLocations* cho ví dụ này có thể là *file:///C:/opt/files/*)

Bây giờ - bất cứ khi nào một request trùng với /files/** bạn có thể truy cập đến file đó từ hệ thống file của bạn, bởi vì đã config URL pattern ánh xạ đến vị trí trên ở đĩa.

