package pattern.simplefactory;

import pattern.factory.product.IPhone;
import pattern.factory.product.Phone;
import pattern.factory.product.SPhone;

/**
 * 简单工厂方法
 *
 * Created with IDEA
 * User: li_zhf
 * Email: li_zhf@murongtech.com
 * Date: 2016/9/29.
 * Time: 15:05
 */
public class SimpleFactory {
    static Phone createPhone(String name) {
        Phone phone;
        switch (name) {
            case "iphone":
                phone = new IPhone();
                break;
            case "sphone":
                phone = new SPhone();
                break;
            default:
                phone = null;
                break;
        }
        return phone;
    }
}
