package PRC.registerCenter;

import java.util.HashMap;

/**
 * Created by jiusa on 2017/3/29.
 */
public interface Server {
    void setRegiterCenter(ConcreteRegiterCenter regiterCenter);

    void update(HashMap<String, String> map);
}
