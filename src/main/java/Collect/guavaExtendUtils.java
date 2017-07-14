package Collect;

import com.google.common.base.Objects;
import com.google.common.collect.AbstractIterator;
import com.google.common.collect.Iterators;
import com.google.common.collect.Lists;
import com.google.common.collect.PeekingIterator;
import java.util.Iterator;
import java.util.List;

/**
 * Created by liuyang on 2017/7/6.
 */
public class guavaExtendUtils {

    public static void main(String[] args) {
        //Forwarding



        //PeekingIterator
//        filterRepeatElement();

        //AbstractIterator
        skipNullValue();
    }

    private static void skipNullValue() {
        List<String> source = Lists.newArrayList("q", "qq","", "qq",null, "qwe");
        Iterator<String> notNullIterator=skipNulls(source.iterator());
        while (notNullIterator.hasNext()){
            System.out.println(notNullIterator.next());
        }
    }

    public static Iterator<String> skipNulls(final Iterator<String> in) {
        return new AbstractIterator<String>() {
            protected String computeNext() {
                while (in.hasNext()) {
                    String s = in.next();
                    if (s != null&& !Objects.equal(s,"")) {
                        return s;
                    }
                }
                return endOfData();
            }
        };
    }

    private static void filterRepeatElement() {
        List<String> source = Lists.newArrayList("q", "qq", "qq", "qwe");
        List<String> result = Lists.newArrayList();
        PeekingIterator<String> iter = Iterators.peekingIterator(source.iterator());
        while (iter.hasNext()) {
            System.out.println(iter.peek());
            String current = iter.next();
            while (iter.hasNext() && iter.peek().equals(current)) {
                //跳过重复的元素
                iter.next();
            }
            result.add(current);
        }
        System.out.println(result);
    }
}
