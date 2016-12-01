package annotation;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

/**
 * @author li_zhf
 * @Description: TODO
 * @date 2016/10/27 11:25
 */
public class TestAnnotation {

    private int id;

    public static void main(String[] args) {
        TestAnnotation testAnnotation = new TestAnnotation();
        //testAnnotation.test();
    }

    public void test(){
        System.out.println("1111111111");
    }

    @LzfAnnotation(id = 2,name = "www" )
    public void testAnno() {
//        System.out.println(id);
//        System.out.println(name);
    }
}
