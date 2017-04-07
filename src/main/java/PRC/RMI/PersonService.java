package PRC.RMI;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;

/**
 * Created by jiusa on 2017/3/31.
 */
public interface PersonService extends Remote {

  public List<PersonEntity> GetList() throws RemoteException;

}
