package week2.code2.ic;

public class Ex10 {
    @Override
    protected void finalize() throws Throwable {
        try {
            System.out.println("finalize method");
        } finally {
            super.finalize();
        }
    }

    public static void main(String[] args) {
        Ex10 mt = new Ex10();
        mt = null; // Đặt đối tượng thành null
        System.gc(); // Yêu cầu Garbage Collector dọn dẹp bộ nhớ
        System.out.println("end of method"); // In ra ngay lập tức
    }
}
