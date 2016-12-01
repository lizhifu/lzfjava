package pattern.builder;

/**
 * Created by lzf on 2016/10/9.
 */
public class RobotBuilder implements PersonBuilder {
    private Person person = new Person();

    @Override
    public void buildHead() {
        person.setHead("Head");
    }

    @Override
    public void bulidBody() {
        person.setBody("Body");
    }

    @Override
    public void buildHands() {
        person.setHand("Hands");
    }

    @Override
    public void bubildLegs() {
        person.setLeg("Legs");
    }

    @Override
    public Person getPerson() {
        return person;
    }
}
