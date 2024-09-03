package week2.code2.ic;

public class Ex11 {

    @Override
    protected void finalize() throws Throwable {
        try {
            System.out.println("finalize method");
        } finally {
            super.finalize();
        }
    }

    public static void main(String[] args) {
        Ex11 mt = new Ex11();
        mt = null; // Đặt đối tượng thành null
        System.gc(); // Yêu cầu Garbage Collector dọn dẹp bộ nhớ
        try {
            // Đợi một thời gian để GC có thể thực thi finalize()
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("end of method"); // In ra sau khi chờ
    }
}
