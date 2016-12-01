package pattern.builder;

/**
 * 建造者模式
 * Created by lzf on 2016/10/9.
 */
public class Constructer {
    private PersonBuilder personBuilder;

    Constructer( PersonBuilder personBuilder){
        this.personBuilder = personBuilder;
    }

    //定义建造流程
    public Person construct() {
        personBuilder.bubildLegs();
        personBuilder.buildHands();
        personBuilder.buildHead();
        personBuilder.bulidBody();
        return personBuilder.getPerson();
    }



    public static void main(String[] args) {
        Constructer constructer = new Constructer( new RobotBuilder() );
        Person person = constructer.construct();
        person.show();
    }
}
