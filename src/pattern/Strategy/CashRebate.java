package pattern.Strategy;

/**
 * 打折
 *
 * Created with IDEA
 * User: li_zhf
 * Email: li_zhf@murongtech.com
 * Date: 2016/9/30.
 * Time: 14:12
 */
public class CashRebate implements CashStrategy {

    private double rebateRate;
    public CashRebate(double rebateRate) {
        this.rebateRate = rebateRate;
    }

    @Override
    public double getFeeResult(double money) {
        return money * rebateRate;
    }
}
