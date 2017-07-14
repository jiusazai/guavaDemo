package Collect;

import com.google.common.collect.ArrayListMultimap;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableList.Builder;
import com.google.common.collect.Lists;
import com.google.common.collect.Multimap;
import com.google.common.primitives.Ints;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Created by liuyang on 2017/7/11.
 */
public class ImmutableVSunmodifiableList {

    public static void main(String[] args) {
        //jdk unmodifiableList
        //初始化一个不可变集，尝试改变它
//        initUnmodifiableList();
        //改变原视图，不可变集是否改变
//        changeList();




        //guava immutableList
        //初始化一个不可变集，尝试改变它
//        initImmutableList();
        //改变原视图，不可变集是否改变
//        changeList2();


        //初始化

//        List<Integer> list= Lists.newArrayList(1,2,3);

        ImmutableList<Integer> iList = ImmutableList.of(1, 2);
//        ImmutableList<Integer> iList2 = ImmutableList.copyOf(Ints.asList(1,2,3));
//        ImmutableList<Integer> iList3 = ImmutableList.copyOf(iList);

//        ImmutableList<Integer> iList4=ImmutableList.copyOf(list);
//        System.out.println(iList4);
//        list.add(4);
//        System.out.println(iList4);

        Builder<Integer> builder = ImmutableList.builder();
        builder.add(1,2,3,4,5);
        builder.add(2, 3);
        builder.addAll(iList);
        System.out.println(iList==builder.build());
        iList = builder.build();
        System.out.println(iList);


        //ArrayListMultimap

//        Multimap<String, Integer> multimap = ArrayListMultimap.create();
//        multimap.put("qwe",null);
//        multimap.put(null,1);
//        multimap.put(null,1);
//        System.out.println(multimap);

    }

    private static void changeList2() {
        List<String> list = new ArrayList();
        list.add("wyp");
        list.add("good");

        ImmutableList immutableList=ImmutableList.copyOf(list);
        System.out.println(immutableList);
        list.add("bad");
        System.out.println(immutableList);
    }

    private static void initImmutableList() {
        List<String> list = new ArrayList();
        list.add("wyp");
        list.add("good");

        ImmutableList immutableList=ImmutableList.copyOf(list);
        System.out.println(immutableList);
        immutableList.add("www");
    }

    private static void changeList() {
        List<String> list = new ArrayList();
        list.add("wyp");
        list.add("good");

        List unmodifiableList = Collections.unmodifiableList(list);
        System.out.println(unmodifiableList);
        list.add("bad");
        System.out.println(unmodifiableList);
    }

    private static void initUnmodifiableList() {
        List<String> list = new ArrayList();
        list.add("wyp");
        list.add("good");

        List unmodifiableList = Collections.unmodifiableList(list);
        System.out.println(unmodifiableList);//[wyp, good]
        unmodifiableList.add("add");
    }
}
