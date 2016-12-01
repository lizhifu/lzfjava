package pattern.bridge;

/**
 * Created with IDEA
 * User: li_zhf
 * Email: li_zhf@murongtech.com
 * Date: 2016/10/1.
 * Time: 18:17
 */
public class Rectangle extends Shape{

    public Rectangle() {
        System.out.print("i am Rectangle, ");
    }
    @Override
    public void setColor(Color color) {
        this.color =color;
    }

    @Override
    public void drawColor() {
        color.draw();
    }
}
