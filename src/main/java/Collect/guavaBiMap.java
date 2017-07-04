package Collect;

import com.google.common.collect.BiMap;
import com.google.common.collect.HashBiMap;

/**
 * Created by liuyang on 2017/7/4.
 */
public class guavaBiMap {

    public static void main(String[] args) {
//map KV反转
//        mapInverse();
//重复值插入
//        repeatValue();
//强行插入
//        forcePut();
//修改视图
//        mapInverseModify();

    }

    private static void mapInverseModify() {
        BiMap<Integer, String> logfileMap = HashBiMap.create();
        logfileMap.put(1, "a.log");
        logfileMap.put(2, "b.log");
        logfileMap.put(3, "c.log");
        System.out.println("logfileMap:" + logfileMap);
        BiMap<String, Integer> filelogMap = logfileMap.inverse();
        System.out.println("filelogMap:" + filelogMap);

        logfileMap.put(4, "d.log");

        System.out.println("logfileMap:" + logfileMap);
        System.out.println("filelogMap:" + filelogMap);
    }

    private static void forcePut() {
        BiMap<Integer, String> bimap = HashBiMap.create();
        bimap.put(1, "1");
        bimap.put(2, "2");
        bimap.put(10, "10");
        bimap.forcePut(11, "10");
    }

    private static void repeatValue() {
        BiMap<Integer, String> logfileMap = HashBiMap.create();
        logfileMap.put(1, "a.log");
        logfileMap.put(2, "b.log");
        logfileMap.put(3, "c.log");
        logfileMap.put(4, "d.log");
        logfileMap.put(5, "d.log");
    }

    private static void mapInverse() {
        BiMap<Integer, String> logfileMap = HashBiMap.create();
        logfileMap.put(1, "a.log");
        logfileMap.put(2, "b.log");
        logfileMap.put(3, "c.log");
        System.out.println("logfileMap:" + logfileMap);
        BiMap<String, Integer> filelogMap = logfileMap.inverse();
        System.out.println("filelogMap:" + filelogMap);
    }
}
