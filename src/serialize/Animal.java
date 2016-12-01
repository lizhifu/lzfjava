package serialize;

import javax.jws.soap.SOAPBinding;
import java.io.Serializable;

/**
 * @author li_zhf
 * @Description: TODO
 * @date 2016/10/26 14:17
 */
public class Animal implements Serializable {

    private static final long serialVersionUID = 6060084433700610514L;

    public static void main(String[] args) throws Exception {
        String filePath = "G:/Serial.txt";
        Animal animal = new Animal();

        Serial.serialize(animal,filePath);
        //Animal animal1 = Serial.deSerialize(animal,filePath);

        //System.out.println(animal1.toString());
    }
}
