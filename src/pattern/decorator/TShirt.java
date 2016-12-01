package pattern.decorator;

/**
 * T恤
 *
 * Created with IDEA
 * User: li_zhf
 * Email: li_zhf@murongtech.com
 * Date: 2016/10/2.
 * Time: 11:48
 */
public class TShirt extends Clothes{
    @Override
    public void show() {
        super.show();
        System.out.println("T恤 ");
    }
}
