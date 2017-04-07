package PRC.registerCenter;

import com.alibaba.fastjson.JSON;
import com.google.common.collect.MapDifference;
import com.google.common.collect.Maps;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * Created by jiusa on 2017/3/29.
 */
public class test {

  public static void main(String[] args) {
    ConcreteRegiterCenter subject = new ConcreteRegiterCenter();
    //创建观察者对象
    Client observer = new ConcreteClient();
    Client observer2 = new ConcreteClient();
    //将观察者对象登记到主题对象上
    subject.attach(observer);
    subject.attach(observer2);

    Server server = new ConcreteServer();
    Server server2 = new ConcreteServer();
    server.setRegiterCenter(subject);
    server2.setRegiterCenter(subject);

    //改变主题对象的状态
    HashMap<String, String> map = Maps.newHashMap();
    map.put("activityService", "http://service.lianshang.com/activitycenter/activity_service_1.0.2");
//        map.put("activityService","http://service.lianshang.com/activitycenter/activity_service_1.0.0");
    map.put("userService", "http://service.lianshang.com/activitycenter/user_service_1.0.0");

    HashMap<String, String> map2 = Maps.newHashMap();
    map2.put("userService", "http://service.lianshang.com/activitycenter/user_service_1.0.2");
//        map2.put("userService2","http://service.lianshang.com/activitycenter/user_service_1.0.0");
    map2.put("userService2", "http://service.lianshang.com/activitycenter/user_service_1.0.2");
    map2.put("userServiceImpl", "http://service.lianshang.com/activitycenter/user_service_1.0.2");
    server.update(map);
    System.out.println("---------------------");
    server2.update(map2);


  }
}
