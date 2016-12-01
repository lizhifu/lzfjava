package pattern.factorymethod;


import pattern.factory.factory.Factory;
import pattern.factory.factory.IPhoneFactory;
import pattern.factory.product.Phone;

/**
 * Created with IDEA
 * User: li_zhf
 * Email: li_zhf@murongtech.com
 * Date: 2016/9/30.
 * Time: 10:37
 */
public class FactoryMethod {
    public static void main(String[] args) {
        Factory factory = new IPhoneFactory();
        Phone phone = factory.createPhone();
        phone.show();
    }
}


