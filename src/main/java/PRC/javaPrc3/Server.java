package PRC.javaPrc3;

import java.io.IOException;

/**
 * Created by jiusa on 2017/3/7.
 */
public interface Server {
    public void stop();

    public void start() throws IOException;

    public void register(Class serviceInterface, Class impl);

    public boolean isRunning();

    public int getPort();
}
