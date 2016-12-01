package pattern.Strategy.factory;


import pattern.Strategy.CashNormal;
import pattern.Strategy.CashStrategy;

/**
 * Created with IDEA
 * User: li_zhf
 * Email: li_zhf@murongtech.com
 * Date: 2016/9/30.
 * Time: 15:45
 */
public class CashNormalFactory implements CashFactory{
    @Override
    public CashStrategy createCashStrategy(double i , double j) {
        return new CashNormal();
    }
}
