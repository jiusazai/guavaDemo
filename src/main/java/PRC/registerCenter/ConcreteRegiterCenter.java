package PRC.registerCenter;

import com.alibaba.fastjson.JSON;
import com.google.common.collect.MapDifference;
import com.google.common.collect.Maps;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by jiusa on 2017/3/29.
 */
public class ConcreteRegiterCenter extends RegisterCenter{

    private HashMap<String,String> map=Maps.newHashMap();

    public HashMap<String,String> getMap() {
        return map;
    }

    public void change(HashMap<String,String> newMap){
        unionMap(newMap);
        System.out.println("主题状态为：" + JSON.toJSONString(map));
        //状态发生改变，通知各个观察者
        this.notifyObservers(map);
    }

    private void unionMap(HashMap<String, String> newMap) {
        MapDifference mapDifference= Maps.difference(map,newMap);

        HashMap<String,String> mapSum= Maps.newHashMap();
        mapSum.putAll(mapDifference.entriesOnlyOnLeft());
        mapSum.putAll(mapDifference.entriesOnlyOnRight());

        Map map1=mapDifference.entriesDiffering();
        Object[] objects=map1.keySet().toArray();
        for (int i=0;i<objects.length;i++){
            mapSum.put((String) objects[i],newMap.get(objects[i]));
        }
        map=mapSum;
    }


}
