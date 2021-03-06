package Collect;

import com.google.common.collect.ClassToInstanceMap;
import com.google.common.collect.MutableClassToInstanceMap;

/**
 * Created by liuyang on 2017/7/4.
 */
public class _006_guavaClassToInstanceMap {

    public static void main(String[] args) {
        initClassToInstanceMap();

    }

    private static void initClassToInstanceMap() {
        ClassToInstanceMap<Number> numberDefaults = MutableClassToInstanceMap.create();
        numberDefaults.putInstance(Integer.class, Integer.valueOf(0));
        numberDefaults.putInstance(Float.class, Float.valueOf("2.1"));
        numberDefaults.putInstance(Double.class, Double.valueOf("3.2"));

        System.out.println(numberDefaults);
        System.out.println(numberDefaults.getInstance(Integer.class));
    }
}
