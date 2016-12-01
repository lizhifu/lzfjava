package pattern.bridge;

/**
 * Created with IDEA
 * User: li_zhf
 * Email: li_zhf@murongtech.com
 * Date: 2016/10/1.
 * Time: 18:15
 */
public class Red implements Color {
    @Override
    public void draw() {
        System.out.println("draw red");
    }
}
