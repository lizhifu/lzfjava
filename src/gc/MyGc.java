package gc;

/**
 * @author lizhifu
 * @date 2016/11/14 10:32
 */
public class MyGc {
    private static MyGc myGc = null ;

    @Override
    protected void finalize() throws Throwable {
        super.finalize();
        System.out.println("execute finalize()");
        MyGc.myGc = this;
    }

    public static void main(String[] args) throws Exception {
        myGc = new MyGc();

        myGc = null;
        System.gc();
        Thread.sleep(500);
        System.out.println(myGc == null);

        myGc = null;
        System.gc();
        Thread.sleep(500);
        System.out.println(myGc == null);
    }
}
