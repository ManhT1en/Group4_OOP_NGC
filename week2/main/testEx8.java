package week2.main;

import week2.code2.ac.Ex8.Connection;
import week2.code2.ac.Ex8.ConnectionManager;

public class testEx8 {
    public static void main(String[] args) {
        Connection conn1 = ConnectionManager.getConnection();
        Connection conn2 = ConnectionManager.getConnection();
        Connection conn3 = ConnectionManager.getConnection();
        Connection conn4 = ConnectionManager.getConnection();
        Connection conn5 = ConnectionManager.getConnection();
        Connection conn6 = ConnectionManager.getConnection(); // trả về null

        if (conn1 != null) conn1.performAction();
        if (conn2 != null) conn2.performAction();
        if (conn3 != null) conn3.performAction();
        if (conn4 != null) conn4.performAction();
        if (conn5 != null) conn5.performAction();
        if (conn6 == null) System.out.println("Khong con ket noi ");

        ConnectionManager.releaseConnection(conn1);

        Connection conn7 = ConnectionManager.getConnection();
        if (conn7 != null) conn7.performAction();
    }
}
