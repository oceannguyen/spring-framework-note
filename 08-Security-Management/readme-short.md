## Spring Security mechanism

```<http>``` element thực hiện những tasks sau:

- **Authentication**:  Có thể thực hiện qua cơ chế ```HttpBasicAuthentication``` hoặc qua cơ chế dựa trên form login.
- **Authorization**: Hỗ trợ thông qua ```<intercept-url>``` cấu hình trong ```<http>``` element. Mỗi ```<intercept-url>``` thì chứa thông tin về ```resource pattern``` cùng với ```roles``` cho phép người dùng truy cập vào tài nguyên. Những quyết định truy cập đó được ```taken``` bởi bean có tên là ```accessdecisionManager```. Spring có những access decision managers sau:

> AffirmativeBased

> ConsensusBased

> UnanimousBased

Những giá trị trên sẽ trả về một trong các quyết định sau: grant access, access denied, hoặc access abstain. Những thuộc tính sau định nghĩa ```where``` user sẽ ```visit```:

> default-target-url

> authentication-failure-url

Những giá trên trên được dùng bởi ```AuthenticationSuccesshandler``` hoặc ```AuthenticationFailureHandler``` inferfaces để di chuyển user đến resource:

- **Logout support**
- **Anonymous login support**
- **Remember me authentication**
- **Concurrent session management**
