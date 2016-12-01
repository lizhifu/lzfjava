package pattern.Strategy.factory;


import pattern.Strategy.CashReturn;
import pattern.Strategy.CashStrategy;

/**
 * Created with IDEA
 * User: li_zhf
 * Email: li_zhf@murongtech.com
 * Date: 2016/9/30.
 * Time: 15:50
 */
public class CashReturnFactory implements CashFactory {
    @Override
    public CashStrategy createCashStrategy(double conditionMoney, double minusMoney) {
        return new CashReturn(conditionMoney,minusMoney);
    }
}
