package guavaErrorCase;

import com.google.common.collect.ImmutableMap;

/**
 * Created by liuyang on 2017/7/11.
 */
public class _001_initMap {

    public static void main(String[] args) {

        //error  of初始化最多接受5对KV
        initMapError();

        //solution
        ImmutableMap map = ImmutableMap.builder()
            .put("key1", "value1")
            .put("key2", "value2")
            .put("key3", "value3")
            .put("key4", "value4")
            .put("key5", "value5")
            .put("key6", "value6")
            .put("key7", "value7")
            .put("key8", "value8")
            .put("key9", "value9")
            .build();

    }

    private static void initMapError() {
//        ImmutableMap<String, String> myMap = ImmutableMap.of(
//            "key1", "value1",
//            "key2", "value2",
//            "key3", "value3",
//            "key4", "value4",
//            "key5", "value5",
//            "key6", "value6",
//            "key7", "value7",
//            "key8", "value8",
//            "key9", "value9"
//        );
    }
}
