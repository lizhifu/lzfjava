package pattern.Strategy.factory;


import pattern.Strategy.CashStrategy;

/**
 * Created with IDEA
 * User: li_zhf
 * Email: li_zhf@murongtech.com
 * Date: 2016/9/30.
 * Time: 14:32
 */
public interface CashFactory {
    public CashStrategy createCashStrategy(double i, double j);
}
