## Streaming media

Là đa phương tiện truyền thông mà liên tục được nhận và hiển thị tới end-user khi đang được truyền/phát từ provider

VD: video streaming, media player, ...

## Message Broker là gì?

**Đặt vấn đề**: Trong một hệ thống phân tán, có rất nhiều thành phần ứng dụng giao tiếp với nhau, mà muốn các thành phần giao tiếp được với nhau thì phải biết nhau. Nhưng điều này sẽ gây rắc rối cho việc viết code. Một thành phần phải biết quá nhiều đâm ra khó maintain và debug.

**Giải pháp**:  Thay vì các liên kết trực tiếp, khiến các thành phần biết nhau thì sử dụng một liên kết trung gian qua một message broker.

Luồng như sau:
Producers chỉ việc đẩy message vào message broker
Consumers đăng ký nhận queue message mong muốn từ broker

## STOMP Over WebSocket Messaging Architecture

**Đặt vấn đề**: WebSocket là giao thức nhanh nhất nhưng vẫn chưa được hỗ trợ bởi tất cả trình duyệt. Vì thế ta cần tìm một giải pháp thay thế hoặc real-time solution.

STOMP là simple (or streaming) text-oriented messaging protocol được tạo ra với mục đích ban đầu dành cho các scripting languages như Ruby, Python và Perl để connect đến các enterprise message brokers. [Refer to](https://docs.spring.io/spring/docs/5.0.0.BUILD-SNAPSHOT/spring-framework-reference/html/websocket.html#websocket-stomp-overview)

*STOMP provides an interoperable wire format so that STOMP clients can communicate with any STOMP message broker to provide easy and widespread messaging interoperability among many languages, platforms and brokers.* [Refer to](https://stomp.github.io/)

STOMP là giao thức dựa trên khung (frame), các khung được mô hình hóa trên HTTP.

Clients có thể dùng các hàm SEND hoặc SUBSCRIBE để **gửi** hoặc **đăng ký** cho messages cùng với một "destination" header để mô tả message đó là gì và ai sẽ nhận được message này.

```SockJS``` hỗ trợ giao thức STOMP cho phép các scripting languages  giao tiếp với bất kỳ message broker nào. STOMP là lighweight và dễ dàng để implement cả client cũng như server. Nó định nghĩa các frames (để ánh xạ với các WebSocket frames) khác nhau dưới đây.

- **CONNECT**: This connects the client to the server
- **SUBSCRIBE**: This is used for listening to the given destination
- **UNSUBSCRIBE**: This is used to remove the existing subscription
- **SEND** (messages sent to the server): This frame sends a message to the destination
- **MESSAGE** (for messages send from the server): This conveys the messages from the subscriptions to the client
- **BEGIN**: This starts the transaction
- **COMMIT**: This commits the ongoing transaction
- **ABORT**: This rollbacks the ongoing transaction
- **DISCONNECT**: This disconnects the client from the server

## Spring STOMP support

Khi sử dụng Spring's STOMP support, ứng dụng Spring WebSocket đóng vai trò như là ```STOMP broker``` đến clients. Messages được định tuyến tại các *phương thức xử lý message* (các phương thức có annotation ```@MessageMapping```) trong ```@Controller``` để theo dõi những đăng ký và chuyển messages đến các users đã đăng ký. Bạn có thể cấu hình Spring để làm việc với một ```STOMP broker``` mong muốn (ví dụ: RabbitMQ, ActiveMQ) để chuyển phát các messages.

## SockJS

Thư viện ```SockJS``` cung cấp cross-browser JavaScript API để cho chép độ trễ thấp, giao tiếp cross-domain giữa browser và server. Nó nhằm để hỗ trợ các mục đích sau:

- Thay vì dùng ```WebSocket``` instance, ```SockJS``` instance được sử dụng
- Cung cấp các APIs gần với ```WebSocket``` API,  với cả server cũng như client APIS (*both for server as well as client-side APIs*)
- Hỗ trợ giao tiếp nhanh hơn
- JavaScript cho client side
- Cung cấp các giao thức được chọn để hỗ trợ giao tiếp cross-domain

Đoạn code sau cho chúng ta thấy cách enable thư viện ```SockJS``` hỗ trợ cho ```WebSocketConfigure```, ```AbstractWebSocketMessageBrokerConfigurer```

```
// WebSocket
@Override 
public void registerWebSocketHandlers(WebSocketHandlerRegistry  registry) { 
    registry.addHandler(myHandler(), "/myHandler_sockjs").setAllowedOrigins("*").withSockJS(); 
} 
```

```
// STOMP
@Override
public void registerStompEndpoints(StompEndpointRegistry registry) {
	registry.addEndpoint("/inbox").setAllowedOrigins("*").withSockJS();
}
```

