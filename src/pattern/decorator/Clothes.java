package pattern.decorator;

/**
 * Created with IDEA
 * User: li_zhf
 * Email: li_zhf@murongtech.com
 * Date: 2016/10/2.
 * Time: 11:47
 */
public class Clothes extends Person{
    private Person person;
    public void decorator(Person person) {
        this.person = person;
    }

    public void show() {
        if ( person != null ) {
             person.show();
        }
    }

}
