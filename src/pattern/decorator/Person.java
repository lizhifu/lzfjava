package pattern.decorator;

/**
 * Created with IDEA
 * User: li_zhf
 * Email: li_zhf@murongtech.com
 * Date: 2016/10/1.
 * Time: 18:46
 */
public class Person {
    private String name;
    Person(){}

    Person(String name) {
        this.name = name;
    }
    public void show () {
        System.out.println(name + ": ");
    }

    public static void main(String[] args) {
        Person person = new Person("haha");

        Clothes tShirt = new TShirt();
        Clothes slipper = new Slipper();
        Clothes leatherShoes = new LeatherShoes();
        Clothes jean = new Jean();

        tShirt.decorator(person);
        slipper.decorator(tShirt);
        leatherShoes.decorator(slipper);
        jean.decorator(leatherShoes);
        jean.show();
    }
}
