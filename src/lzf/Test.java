package lzf;

import classload.Initation;
import org.apache.commons.lang.builder.ReflectionToStringBuilder;
import org.apache.xmlbeans.soap.SOAPArrayType;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by lzf on 2016/7/3.
 */
public class Test {
    private String name;
    private int id = 0;
    Test() {

    }

    Test(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public static void main(String[] args) {
        System.out.println(Test.class.getClassLoader());
        System.out.println(System.class.getClassLoader());
    }

    static class Lzf {
        private String name;

        private String age;

        public String getAge() {
            return age;
        }

        public void setAge(String age) {
            this.age = age;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        @Override
        public String toString() {
            return ReflectionToStringBuilder.toString(this);
        }
    }
}
