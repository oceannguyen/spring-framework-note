
E.x:  Mỗi khi user truy vấn data từ database, user cần phải đợi cho đến khi nhận được data từ database.  Điều này lãng phí thời gian.
-> Điều này có thể thực hiện bằng việc processing data bất đồng bộ, lúc đó  luồng chính sẽ tiếp tục tác vụ thay thế của nó để tiếp tục chạy tiếp theo luồng. Bất cứ khi nào có tín hiệu về việc nhận data từ luồng chính đó, nó sẽ thực hiện xử lý data đã có đến user.