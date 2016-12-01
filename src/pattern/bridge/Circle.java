package pattern.bridge;

/**
 * Created with IDEA
 * User: li_zhf
 * Email: li_zhf@murongtech.com
 * Date: 2016/10/1.
 * Time: 18:04
 */
public class Circle  extends  Shape{

    public Circle() {
        System.out.print("i am Circle, ");
    }
    @Override
    public void setColor(Color color) {
        this.color = color;
    }

    @Override
    public void drawColor() {
        color.draw();
    }
}
