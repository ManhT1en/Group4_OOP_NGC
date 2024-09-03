package week2.code2.ac.Ex8;

public class ConnectionManager{
    private static final int MAX_CONNECTIONS = 5; // Kích thước mảng cố định
    private static Connection[] connections = new Connection[MAX_CONNECTIONS];
    private static boolean[] available = new boolean[MAX_CONNECTIONS];

    static{
        // Khởi tạo các kết nối và đánh dấu chúng là có sẵn
        for (int i = 0; i < MAX_CONNECTIONS; i++){
            connections[i] = Connection.createConnection();
            available[i] = true;
        }
    }

    private ConnectionManager() {} // Constructor riêng tư để ngăn không cho tạo đối tượng

    // Phương thức tĩnh để lấy một kết nối
    public static Connection getConnection(){
        for (int i = 0; i < MAX_CONNECTIONS; i++){
            if (available[i]) {
                available[i] = false; // Đánh dấu là đã sử dụng
                return connections[i];
            }
        }
        return null; 
    }

    public static void releaseConnection(Connection connection){
        for (int i = 0; i < MAX_CONNECTIONS; i++){
            if (connections[i] == connection) {
                available[i] = true; 
                return;
            }
        }
    }
}
