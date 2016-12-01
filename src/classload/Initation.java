package classload;

/**
 * @author li_zhf
 * @Description: TODO
 * @date 2016/11/1 11:01
 */
public class Initation {
    public static void main(String[] args) {
        System.out.println(SubClass.i);
    }

    public static class SubClass extends SuperClass{
        static {
            System.out.println("subclass load");
        }
        public static int i = 1;
    }

    public static class SuperClass{
        static {
            System.out.println( "superclass load");
        }
    }
}
