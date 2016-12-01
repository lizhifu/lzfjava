package serialize;

import java.io.*;

/**
 * @author li_zhf
 * @Description: 序列化和反序列化
 * @date 2016/10/26 10:32
 */
public class Serial  {
    /**
     * 序列化
     * @throws Exception
     */
    public static <T> void  serialize(T t, String filePath) throws Exception {
        ObjectOutputStream  oo = new ObjectOutputStream(new FileOutputStream(new File(filePath)));
        oo.writeObject(t);
        oo.close();
        System.out.println("序列化完成");
    }

    /**
     * 反序列化
     * @throws Exception
     */
    public static <T>  T  deSerialize(T t,String filePath) throws Exception {
        ObjectInputStream ois = new ObjectInputStream(new FileInputStream(new File(filePath)));
        T serial = (T) ois.readObject();
        ois.close();
        System.out.println("反序列化完成");
        return serial;
    }
}
