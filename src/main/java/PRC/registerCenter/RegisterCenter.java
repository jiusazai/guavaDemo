package PRC.registerCenter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Created by jiusa on 2017/3/29.
 */
public abstract class RegisterCenter {
    private List<Client> list = new ArrayList<Client>();
    
    public void attach(Client observer){

        list.add(observer);
        System.out.println("Attached an observer");
    }
    
    public void detach(Client observer){

        list.remove(observer);
    }
    
    public void notifyObservers(HashMap<String,String> map){

        for(Client observer : list){
            observer.update(map);
        }
    }
}
