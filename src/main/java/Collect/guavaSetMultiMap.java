package Collect;

import com.google.common.collect.TreeMultimap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

/**
 * Created by liuyang on 2017/7/4.
 */
public class guavaSetMultiMap {

    public static void main(String[] args) {
        TreeMultimap treeMultimap = TreeMultimap.create();
        treeMultimap.put("wyp", "hao");
        treeMultimap.put("wyp", "hao2");
        treeMultimap.put("wyp1", "hao");
        Set<Entry> entries1 = treeMultimap.entries();
        System.out.println(entries1);
    }
}
