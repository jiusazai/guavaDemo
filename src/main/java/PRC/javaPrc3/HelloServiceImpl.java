package PRC.javaPrc3;

/**
 * Created by jiusa on 2017/3/7.
 */
public class HelloServiceImpl implements HelloService {
    @Override
    public String sayHi(String name) {
        return "hi " + name;
    }
}
