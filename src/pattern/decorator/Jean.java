package pattern.decorator;

/**
 * Created with IDEA
 * User: li_zhf
 * Email: li_zhf@murongtech.com
 * Date: 2016/10/2.
 * Time: 12:14
 */
public class Jean extends Clothes{
    @Override
    public void show() {
        super.show();
        System.out.println("牛仔裤 ");
    }
}
