package init;

/**
 * @author lizhifu
 * @date 2016/11/14 15:39
 */
public class Init {
    static class Parent {

        static {
            A = 2;
        }
        public static int A = 1;
    }

    static class Child extends Parent {
        public static int B = A;
    }

    public static void main(String[] args) {

        System.out.println(Child.B);
    }
}
