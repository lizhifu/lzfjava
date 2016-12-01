package pattern.proxy;

/**
 * Created by lzf on 2016/10/9.
 */
public class TicketAgency implements Ticket {
    private TrainStation ticketAgency = new TrainStation();
    @Override
    public void saleTicket() {
        getFee();
        ticketAgency.saleTicket();
    }

    public void getFee() {
        System.out.println("收取5块手续费");
    }

    public static void main(String[] args) {
        TicketAgency ticketAgency = new TicketAgency();
        ticketAgency.saleTicket();
    }
}
