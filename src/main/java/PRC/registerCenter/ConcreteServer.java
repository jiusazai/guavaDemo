package PRC.registerCenter;

import java.util.HashMap;

/**
 * Created by jiusa on 2017/3/29.
 */
public class ConcreteServer implements Server {
    private HashMap<String,String> map;

    private  ConcreteRegiterCenter regiterCenter;


    @Override
    public void setRegiterCenter(ConcreteRegiterCenter newRegiterCenter) {
        regiterCenter=newRegiterCenter;
    }

    @Override
    public void update(HashMap<String, String> newMap) {
        regiterCenter.change(newMap);
    }
}
