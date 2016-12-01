package pattern.Strategy;

/**
 * 正常
 *
 * Created with IDEA
 * User: li_zhf
 * Email: li_zhf@murongtech.com
 * Date: 2016/9/30.
 * Time: 14:12
 */
public class CashNormal implements CashStrategy{
    @Override
    public double getFeeResult(double money) {
        return money;
    }
}
