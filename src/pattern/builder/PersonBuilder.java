package pattern.builder;

/**
 * Created by lzf on 2016/10/9.
 */
public interface PersonBuilder {
    //定义建造人必须的要素
    public void buildHead();
    public void bulidBody();
    public void buildHands();
    public void bubildLegs();
    public Person getPerson();
}
