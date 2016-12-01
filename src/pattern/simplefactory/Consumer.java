package pattern.simplefactory;

import pattern.factory.product.Phone;

/**
 * Created with IDEA
 * User: li_zhf
 * Email: li_zhf@murongtech.com
 * Date: 2016/9/29.
 * Time: 15:57
 */
public class Consumer {
    public static void main(String[] args) {
        Consumer consumer = new Consumer();
        Phone phone = consumer.buyPhone("iphone");
        phone.show();
    }

    Phone buyPhone(String name) {
        Phone phone = SimpleFactory.createPhone(name);
        return phone;
    }
}
