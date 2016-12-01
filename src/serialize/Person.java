package serialize;

import org.apache.commons.lang.builder.ToStringBuilder;

import java.io.Serializable;

/**
 * @author li_zhf
 * @Description: TODO
 * @date 2016/10/26 14:14
 */
public class Person implements Serializable {

    int id;
    String name;

    Person() {

    }

    @Override
    public String toString() {
        return new ToStringBuilder(this)
                .append("id", id)
                .append("name", name)
                .toString();
    }

    Person(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    //
//    public Info getInfo() {
//        return info;
//    }
//
//    public void setInfo(Info info) {
//        this.info = info;
//    }

    private static final long serialVersionUID = 6060084433700610514L;

    public static void main(String[] args) throws Exception {
        String filePath = "G:/Serial.txt";
        Person person = new Person();
        person.setId(1);
        person.setName("lzf");
        System.out.println(person.toString());
        Serial.serialize(person,filePath);

//        Person personNew = Serial.deSerialize(person,filePath);
//        System.out.println(personNew.toString());
    }
}
