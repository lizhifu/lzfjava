package thread;

import pattern.state.Sleep;

/**
 * @author li_zhf
 * @Description: TODO
 * @date 2016/10/27 18:35
 */
public class Output implements Runnable {

    String id;

    static String status = "A";

    public Output() {
    }

    public Output(String id) {
        this.id = id;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    @Override
    public void run() {
        int i = 0;
        int count = 10;
        while( i < count) {
            synchronized (status) {
                if (status.equals(this.getId())) {
                    System.out.print(this.getId());
                    if ( "A".equals(this.getId())) {
                        status = "B";
                    } else if ( "B".equals(this.getId()) ) {
                        status = "C";
                    } else {
                        status = "A";
                    }
                    i++;
                }
            }
        }
    }

    public static void main(String[] args) {
        Output outputA = new Output("A");
        Output outputB = new Output("B");
        Output outputC = new Output("C");

        new Thread(outputA).start();
        new Thread(outputB).start();
        new Thread(outputC).start();
    }

}
