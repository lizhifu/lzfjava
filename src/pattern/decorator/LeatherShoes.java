package pattern.decorator;

/**
 * 皮鞋
 *
 * Created with IDEA
 * User: li_zhf
 * Email: li_zhf@murongtech.com
 * Date: 2016/10/2.
 * Time: 12:10
 */
public class LeatherShoes extends Clothes {
    @Override
    public void show() {
        super.show();
        System.out.println("皮鞋 ");
    }
}
