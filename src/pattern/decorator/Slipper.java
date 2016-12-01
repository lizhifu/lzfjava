package pattern.decorator;

/**
 * 拖鞋
 *
 * Created with IDEA
 * User: li_zhf
 * Email: li_zhf@murongtech.com
 * Date: 2016/10/2.
 * Time: 11:52
 */
public class Slipper extends Clothes{
    @Override
    public void show() {
        super.show();
        System.out.println("拖鞋 ");
    }
}
