package pattern.factory.factory;


import pattern.factory.product.IPhone;
import pattern.factory.product.Phone;

/**
 * Created with IDEA
 * User: li_zhf
 * Email: li_zhf@murongtech.com
 * Date: 2016/9/30.
 * Time: 10:52
 */
public class IPhoneFactory implements Factory {

    @Override
    public Phone createPhone() {
        return new IPhone();
    }
}
