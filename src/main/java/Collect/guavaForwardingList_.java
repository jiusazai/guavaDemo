package Collect;

import com.google.common.collect.ForwardingIterator;
import com.google.common.collect.ForwardingList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

/**
 * Created by liuyang on 2017/7/6.
 */
public class guavaForwardingList_<E> extends ForwardingList<E> {
    final E defaultValue;
    final List<E> delegate;

    guavaForwardingList_(List<E> delegate, E defaultValue) {
        this.delegate = delegate;
        this.defaultValue = defaultValue;
    }

    @Override protected List delegate() {
        return delegate;
    }

    @Override public E get(int index) {
        E v = super.get(index);
        return (v == null ? defaultValue : v);
    }
    @Override public Iterator<E> iterator() {
        final Iterator<E> iter = super.iterator();
        return new ForwardingIterator<E>() {
            @Override protected Iterator<E> delegate() {
                return iter;
            }
            @Override public E next() {
                E v = super.next();
                return (v == null ? defaultValue : v);
            }
        };
    }
    public static void main(String[] args) {
        //装饰模式
        List<String> names = new guavaForwardingList_<String>(
            Arrays.asList("Alice", null, "Bob", "Carol", null),
            "UNKNOWN"
        );

        for (String name : names) {
            System.out.println(name);
        }
        // Alice
        // UNKNOWN
        // Bob
        // Carol
        // UNKNOWN

        System.out.println(names);
        // [Alice, null, Bob, Carol, null]
    }

}
