package pattern.bridge;

/**
 * Created with IDEA
 * User: li_zhf
 * Email: li_zhf@murongtech.com
 * Date: 2016/10/1.
 * Time: 17:36
 */
public abstract class Shape {
    Color color;
    public abstract void setColor(Color color);
    public abstract void drawColor();
}
