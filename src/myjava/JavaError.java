package myjava;

import java.util.ArrayList;
import java.util.List;

/**
 * @author li_zhf
 * @Description: TODO
 * @date 2016/10/31 18:46
 */
public class JavaError {

    private int stackLength = 1;

    public void sofTest () {
        try {
            sof();
        } catch (Exception e) {
            System.out.println(stackLength);
            return;
        }
    }

    public void sof() {
        stackLength++;
        sof();
    }

    public static void main(String[] args) {
        JavaError javaError = new JavaError();
        javaError.sofTest();
    }

    public void oomTest() {
        List<JavaError> list = new ArrayList<JavaError>();

        while(true){
            list.add(new JavaError());
        }
    }
}
