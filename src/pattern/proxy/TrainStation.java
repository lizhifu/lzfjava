package pattern.proxy;

/**
 * Created by lzf on 2016/10/9.
 */
public class TrainStation implements Ticket {
    @Override
    public void saleTicket() {
        System.out.println("卖出火车票");
    }
}
