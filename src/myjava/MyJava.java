package myjava;

/**
 * @author li_zhf
 * @Description: TODO
 * @date 2016/10/31 13:48
 */
public class MyJava {
    static int a;

    public static void main(String[] args) {
        int b = 0;
        JavaObject javaObject = new JavaObject(1);
        System.out.println("id:" + javaObject.getId());
        methodTwo(javaObject);
        System.out.println("id:" + javaObject.getId());
    }

    public void methodOne() {
        int c = 3;
        System.out.println(c);
    }

    public static void methodTwo(JavaObject javaObject) {
        javaObject.setId(2);
    }

    static class JavaObject {
        int id;

        public JavaObject(int id) {
            this.id = id;
        }

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }
    }
}
