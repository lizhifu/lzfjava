package thread;

/**
 * @author li_zhf
 * @Description: TODO
 * @date 2016/10/27 19:56
 */
public class TestThread {

    private static String status = "A";

    public static void main(String[] args) {

        new Thread(new Runnable() {
            @Override
            public void run() {
                int count = 10;
                for (int i = 0; i < count; ) {
                    synchronized (status) {
                        if (status.equals("A")) {
                            System.out.print("A");
                            status = "B";
                            i++;
                        }
                    }
                }
            }
        }).start();

        new Thread(new Runnable() {
            @Override
            public void run() {
                int count = 10;
                for (int i = 0; i < count; ) {
                    synchronized (status) {
                        if (status.equals("B")) {
                            System.out.print("B");
                            status = "C";
                            i++;
                        }
                    }
                }
            }
        }).start();

        new Thread(new Runnable() {
            @Override
            public void run() {
                int count = 10;
                for (int i = 0; i < count; ) {
                    synchronized (status) {
                        if (status.equals("C")) {
                            System.out.print("C");
                            status = "A";
                            i++;
                        }
                    }
                }
            }
        }).start();
    }
}