package pattern.singleton;

/**
 * 单例：懒汉，线程不安全
 *
 * Created with IDEA
 * User: li_zhf
 * Email: li_zhf@murongtech.com
 * Date: 2016/9/29.
 * Time: 16:44
 */
public class LazySingleton {
    private static LazySingleton instance;
    private LazySingleton() {}

    public static synchronized LazySingleton genInstance() {
        if ( null == instance ) {
            instance = new LazySingleton();
        }
        return instance;
    }
}
