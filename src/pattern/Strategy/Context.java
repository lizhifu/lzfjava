package pattern.Strategy;


/**
 * Created with IDEA
 * User: li_zhf
 * Email: li_zhf@murongtech.com
 * Date: 2016/9/30.
 * Time: 13:48
 */
public class Context {
    private CashStrategy cashStrategy;

   Context ( CashStrategy cashStrategy) {
        this.cashStrategy = cashStrategy;
    }

    public double getResult(double money) {
        return cashStrategy.getFeeResult(money);
    }

    //和简单工厂结合,具体收费算法和客户隔离，只需认识类Context
//    Context (String type) {
//        switch (type) {
//            case "正常收费":
//                cashStrategy = new CashNormal();
//                break;
//            case "5折":
//                cashStrategy = new CashRebate(0.5);
//                break;
//            case "满100减5":
//                cashStrategy = new CashReturn(100,5);
//                break;
//            default:
//                cashStrategy = new CashNormal();
//        }
//    }

    public static void main(String[] args) {
//        Context context = new Context( new CashReturn(100, 5));
//        double money = context.getResult(108);
//        System.out.println( "费用：" + money );

//        Context context = new Context("5折");
//        double money = context.getResult(234);
//        System.out.println("费用：" + money);

        //Context context1 = new Context( new );

//        CashFactory cashFactory = new CashReturnFactory();
//        Context context =  new Context( cashFactory.createCashStrategy(100,5) );
//        double money = context.getResult(324);
//        System.out.println("费用：" + money);
    }
}
