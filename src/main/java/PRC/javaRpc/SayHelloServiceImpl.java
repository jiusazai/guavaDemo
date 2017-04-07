package PRC.javaRpc;

/**
 * Created by jiusa on 2017/3/28.
 */
public class SayHelloServiceImpl implements SayHelloService{
    @Override
    public String sayHello(String arg) {
        return "Hello "+arg;
    }
}
