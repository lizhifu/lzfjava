package pattern.builder;

/**
 * Created with IDEA
 * User: li_zhf
 * Email: li_zhf@murongtech.com
 * Date: 2016/10/10.
 * Time: 21:46
 */
public class Person {
    private String head;
    private String body;
    private String hand;
    private String leg;

    public String getHead() {
        return head;
    }

    public void setHead(String head) {
        this.head = head;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public String getHand() {
        return hand;
    }

    public void setHand(String hand) {
        this.hand = hand;
    }

    public String getLeg() {
        return leg;
    }

    public void setLeg(String leg) {
        this.leg = leg;
    }

    public void show() {
        System.out.println(head);
        System.out.println(body);
        System.out.println(hand);
        System.out.println(leg);
    }
}
