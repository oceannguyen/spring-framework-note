##  A Messaging Architecture

Một ứng dụng WebSocket sẽ sử dụng một URL duy nhất để khởi tạo HTTP handshake. Tất cả các messages sau đó sẽ chia sẻ và tuân theo (flow)  cùng một kết nối TCP. Điều này mang đến một kiến trúc messaging, event-driven, asynchronous hoàn toàn khác biệt. 
*One that is much closer to traditional messaging applications* (e.g JMS, AMQP)

## WebSocket Fallback Options

*An important challenge to adoption is the lack of support for WebSocket in some browsers*

Như phần [introduction](https://docs.spring.io/spring/docs/5.0.0.BUILD-SNAPSHOT/spring-framework-reference/html/websocket.html#websocket-into-fallback-options) đã giải thích, WebSocket vẫn chưa được hỗ trợ bởi tất cả các trình duyệt và có thể bị ngăn chặn bởi 	*restrictive network proxies*. Đó là lý do tại sao Spring cung cấp các tùy chọn dự phòng để mô phỏng/giả lập (emulate) WebSocket API dựa trên *SockJS protocol*

## Sub-Protocol Support in WebSocket

Unlike HTTP, which is an application-level protocol, in the WebSocket protocol there is simply **not enough information** in an incoming message for a framework or container to know **how to route** it or **process** it. Therefore WebSocket is arguably too low level for anything but a very trivial application. It can be done, but it will likely **lead to creating a framework** on top. This is comparable to how most web applications today are written using a web framework rather than the Servlet API alone.

For this reason the WebSocket RFC defines the use of [sub-protocols](https://tools.ietf.org/html/rfc6455#section-1.9)

**The use of a sub-protocol is not required**, but even if not used, applications will still **need to choose a message format** that both the client and server can understand.  That format can be custom, framework-specific, or a standard messaging protocol.

The Spring Framework provides **support for using STOMP**— a simple, messaging protocol originally created for use in scripting languages with frames inspired by HTTP. STOMP is widely supported and well suited for use over WebSocket and over the web.

### WebSocket API

Như phần [introduction](https://docs.spring.io/spring/docs/5.0.0.BUILD-SNAPSHOT/spring-framework-reference/html/websocket.html#websocket-intro-sub-protocol) đã giải thích, việc sử dụng websocket trực tiếp là ở mức rất thấp cho các ứng dụng. Chỉ có một số ít các framework có thể thực hiện để thông dịch messages hoặc định tuyến chúng qua annotations. Đó là lý do tại sao các ứng dụng nên cân nhắc sử dụng sub-protocol và sự hỗ trợ STOMP qua WebSocket của Spring.

### Overview of SockJS

Mục đích của SockJS là để cho phép các ứng dụng sử dụng một WebSocket API nhưng *fall back* đến non-WebSocket khi nào cần thiết 	vào thời điểm runtime, mà không phải thay đổi source code.

SockJS bao gồm:
- SockJS protocol định nghĩa một form *narrated tests* có khả năng thực thi
- SockJS JavaScript client - một thư viện client được dùng cho browsers
- Triển khai máy chủ SockJS bao gồm một trong mô đun ```spring-websocket`` của Spring Framework
- As of 4.1 spring-websocket also provides a SockJS Java client
