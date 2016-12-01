package pattern.Strategy.factory;


import pattern.Strategy.CashRebate;
import pattern.Strategy.CashStrategy;

/**
 * Created with IDEA
 * User: li_zhf
 * Email: li_zhf@murongtech.com
 * Date: 2016/9/30.
 * Time: 15:50
 */
public class CashRebateFactory implements CashFactory {
    @Override
    public CashStrategy createCashStrategy(double rebateRate, double j) {
        return new CashRebate(rebateRate);
    }
}
