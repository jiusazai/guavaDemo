package PRC.registerCenter;

import com.alibaba.fastjson.JSON;

import java.util.HashMap;

/**
 * Created by jiusa on 2017/3/29.
 */
public class ConcreteClient implements Client {

    private HashMap<String,String> map;

    @Override
    public void update(HashMap<String,String> newMap) {
        map=newMap;
        System.out.println("clientStatus : "+ JSON.toJSONString(map));
    }
}
