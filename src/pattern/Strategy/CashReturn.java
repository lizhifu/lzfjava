package pattern.Strategy;

/**
 * 满减
 *
 * Created with IDEA
 * User: li_zhf
 * Email: li_zhf@murongtech.com
 * Date: 2016/9/30.
 * Time: 14:13
 */
public class CashReturn implements CashStrategy  {

    private double conditionMoney;
    private double minusMoney;
    public CashReturn (double conditionMoney, double minusMoney) {
        this.conditionMoney = conditionMoney;
        this.minusMoney = minusMoney;
    }
    @Override
    public double getFeeResult(double money) {
        if (money - conditionMoney > 0 ) {
            return money - minusMoney;
        }
        return  money;
    }
}
