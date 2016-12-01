package pattern.bridge;

/**
 * Created with IDEA
 * User: li_zhf
 * Email: li_zhf@murongtech.com
 * Date: 2016/10/1.
 * Time: 17:35
 */
public class Picture {
    public static void main(String[] args) {
        //可结合工厂模式生成抽象类
        Shape shape = new Rectangle();
        shape.setColor(new Blue());
        shape.drawColor();

        Shape shape1 = new Circle();
        shape1.setColor(new Red());
        shape1.drawColor();
    }
}
