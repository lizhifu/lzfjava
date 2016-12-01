package javaexample;

/**
 * @author li_zhf
 * @Description: 常量池
 * @date 2016/11/1 11:20
 */
public class ConstantPool {
    public static void main(String[] args) {
        integerTest();
    }

    public static void integerTest() {
        Integer i1 = 1;
        Integer i2 = 1;
        System.out.println( i1 == i2);

        Integer i3 = 128;
        Integer i4 = 128;
        System.out.println( i3 == i4);
    }


    public static void stringTest() {
        String s1 = "test";
        String s2 = "test";
        System.out.println(s1 == s2);

        String s3 = new String("test");
        String s4 = new String("test");
        System.out.println(s3 == s4);
    }


    public static void internTest() {
        String s1 = new String("test");
        String s2 = s1.intern();
        String s3 = "test";
        System.out.println(s1 == s2);
        System.out.println(s2 == s3);
        System.out.println(s1 == s3);
    }
}
