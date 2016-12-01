package lzf;

import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.xmlbeans.soap.SOAPArrayType;

import java.math.BigDecimal;

/**
 * @author li_zhf
 * @Description: TODO
 * @date 2016/10/23 14:26
 */
public class Test1 {
    String name;
    int id;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this)
                .append("name", name)
                .append("id", id)
                .toString();
    }

    public static void main(String[] args) {

    }

    public static void test(Integer test) {
        test = new Integer(233);
    }
}
