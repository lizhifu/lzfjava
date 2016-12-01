package lzf;

import serialize.Serial;

import java.io.Serializable;

/**
 * @author li_zhf
 * @Description: TODO
 * @date 2016/10/26 10:33
 */
public class Serial1 implements Serializable {

    private static final long serialVersionUID = 1420079854636793851L;

    public static void main(String[] args) throws Throwable {
//        String filePath1 = "G:/SerialNew.txt";
//        Serial1 serial1 = new Serial1();
//
//        Serial.serialize(serial1, filePath1);
//        Serial.deSerialize(serial1, filePath1);

        catchException();
    }

    public static void catchException() throws Throwable{
        try {
            throwException();
        } catch (Exception e) {
            System.out.println("------------------");
//            throw e;
          throw new Exception("hahahhha",e);
        }
    }
    public static void throwException() throws Exception{
        System.out.println("good");
        throw new Exception("this is a exception");
    }
}