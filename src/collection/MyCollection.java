package collection;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author li_zhf
 * @Description: TODO
 * @date 2016/10/27 20:44
 */
public class MyCollection {
    public static void main(String[] args) {
        test();
    }

    public static void test() {
        List list = new ArrayList<>();
        Map map = new HashMap<>();
        Set set = new HashSet();

        ConcurrentHashMap cmap = new ConcurrentHashMap();

        map.put("1","test");
        map.put("2","test2");
        String tmp = null;
        
        System.out.println(map.entrySet());
        System.out.println(map.containsValue(tmp));
    }

}
