package pattern.factory.factory;


import pattern.factory.product.Phone;
import pattern.factory.product.SPhone;

/**
 * Created with IDEA
 * User: li_zhf
 * Email: li_zhf@murongtech.com
 * Date: 2016/9/30.
 * Time: 10:53
 */
public class SPhoneFactory implements Factory {
    @Override
    public Phone createPhone() {
        return new SPhone();
    }
}
