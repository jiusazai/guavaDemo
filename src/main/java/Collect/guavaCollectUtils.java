package Collect;

import com.google.common.collect.HashMultiset;
import com.google.common.collect.Lists;
import com.google.common.collect.Multiset;
import java.util.Iterator;
import java.util.List;

/**
 * Created by liuyang on 2017/7/4.
 */
public class guavaCollectUtils {

    public static void main(String[] args) {
        Multiset<String> multiset = HashMultiset.create();
        multiset.add("qwe1");
        multiset.add("qwe2");
        multiset.add("qwe3");
        multiset.add("qwe4");
        multiset.add("qwe4");

        Iterator<String> iterator = multiset.iterator();
        iterator.
    }
}
