package serialize;

import java.io.Serializable;

/**
 * @author li_zhf
 * @Description: TODO
 * @date 2016/10/26 14:45
 */
public class Info implements Serializable {
    int cardId;
    String aderss;

    Info(){}

    public Info(int cardId, String aderss) {
        this.cardId = cardId;
        this.aderss = aderss;
    }

    public int getCardId() {
        return cardId;
    }

    public void setCardId(int cardId) {
        this.cardId = cardId;
    }

    public String getAderss() {
        return aderss;
    }

    public void setAderss(String aderss) {
        this.aderss = aderss;
    }

    public static void main(String[] args) {

        Info info = new Info();
        info.setCardId(1);
        info.test(info);
        System.out.println(info.getCardId());

        String a = new String("22");
        System.out.println(a);
        info.test2(a);
        System.out.println(a);
    }

    public void test2(String data) {
        data = "33";
    }

    public  void test(Info info)
    {
         info.setCardId(2);
    }

//    /**
//     * 检查商户状态字
//     * @param txCd
//     * @param subTxCd
//     * @param dcPtyFlg
//     * @param stswNum
//     * @param errLpswDt
//     * @param errPpswDt
//     * @param acDt
//     * @return
//     */
//    public int checkTxnStsword(String txCd,String subTxCd,String dcPtyFlg,int stswNum,
//                               String errLpswDt,String errPpswDt,String acDt) {
//        if ( 0 == stswNum ) {
//            return 0;
//        }
//
//
//        for ( int i = 1 ; i < stswNum ; i++) {
//
//        }
//
//        return 0;
//    }

}

