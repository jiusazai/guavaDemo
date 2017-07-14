package Collect;

import static com.google.common.collect.Lists.newArrayList;

import com.alibaba.fastjson.JSON;
import com.google.common.base.Function;
import com.google.common.base.Joiner;
import com.google.common.base.Objects;
import com.google.common.base.Predicate;
import com.google.common.base.Supplier;
import com.google.common.collect.ArrayListMultimap;
import com.google.common.collect.FluentIterable;
import com.google.common.collect.HashBasedTable;
import com.google.common.collect.HashMultimap;
import com.google.common.collect.HashMultiset;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableList.Builder;
import com.google.common.collect.ImmutableListMultimap;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.ImmutableMultimap;
import com.google.common.collect.ImmutableSet;
import com.google.common.collect.Lists;
import com.google.common.collect.MapDifference;
import com.google.common.collect.Maps;
import com.google.common.collect.Multimap;
import com.google.common.collect.Multimaps;
import com.google.common.collect.Multiset;
import com.google.common.collect.Multisets;
import com.google.common.collect.SetMultimap;
import com.google.common.collect.Sets;
import com.google.common.collect.Table;
import com.google.common.collect.Tables;
import com.google.common.collect.TreeMultimap;
import com.google.common.primitives.Ints;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import static com.google.common.collect.Iterables.transform;
import static com.google.common.collect.Iterables.filter;

/**
 * Created by liuyang on 2017/7/4.
 */
public class guavaCollectUtils_ {

    public static void main(String[] args) {
        Person person1 = new Person("lilei", 50);
        Person person2 = new Person("hanmeimei", 40);
        ArrayList personList = newArrayList(person1, person2);
        // Iterables
//        iterablesUtils(personList);

        //Lists
        listsUtils();

        //Sets
//        setsUtils();

        //Maps
//        mapsUtils();

        //Multiset
//        multiSetsUtils();

        //MultiMap
//        multiMapUtils();

        //table
//        tableUtils();


    }

    private static void tableUtils() {
        rowColumnExchange();
    }

    private static void multiMapUtils() {
        //        根据规则将set分组成map
//        setToMap();
        //键值映射关系反转
//        valueMapKeyInverse();
        //value 变成valueList
//        mapToMulti();
    }

    private static void rowColumnExchange() {
        Table table = HashBasedTable.create();
        table.put(1, 1, "123");
        table.put(1, 2, "123");
        table.put(1, 2, "124");
        System.out.println(table);
        System.out.println(Tables.transpose(table));
    }

    private static void mapToMulti() {
        Map<String, Integer> map = ImmutableMap.of("a", 1, "b", 1, "c", 2);
        System.out.println(Multimaps.forMap(map));
    }

    private static void valueMapKeyInverse() {
        ArrayListMultimap<String, Integer> multimap = ArrayListMultimap.create();
        multimap.putAll("b", Ints.asList(2, 4, 6));
        multimap.putAll("a", Ints.asList(4, 2, 1));
        multimap.putAll("c", Ints.asList(2, 5, 3));
        TreeMultimap<Integer, String> inverse = Multimaps.invertFrom(multimap, TreeMultimap.<Integer, String>create());
        System.out.println(inverse);
    }

    private static void setToMap() {
        ImmutableSet digits = ImmutableSet
            .of("zero", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine");
        Function<String, Integer> lengthFunction = new Function<String, Integer>() {
            public Integer apply(String string) {
                return string.length();
            }
        };
        System.out.println(Multimaps.index(digits, lengthFunction));
    }

    private static void multiSetsUtils() {
        Multiset<String> multiset1 = HashMultiset.create();
        multiset1.add("a", 2);
        Multiset<String> multiset2 = HashMultiset.create();
        multiset2.add("a", 5);
        System.out.println(multiset1);
        System.out.println(multiset2);
        System.out.println(multiset1.containsAll(multiset2));
        System.out.println(Multisets.containsOccurrences(multiset1, multiset2));
        System.out.println(multiset2.removeAll(multiset1));
        System.out.println(multiset2.isEmpty());
    }

    private static void mapsUtils() {
        //属性作为key
//        mapsAddUniqIndex(personList);
        //对象作为key
//        objectAsKey(personList);
        //mapValue映射
//        mapTransform();
        //maps比较
//        mapDifference();
    }

    private static void mapDifference() {
        ImmutableMap map = ImmutableMap.of("1", 1,
            "2", 2,
            "3", 3,
            "4", 4);

        ImmutableMap map2 = ImmutableMap.of("1", 1,
            "2", 22,
            "3", 333,
            "5", 5);
        MapDifference difference = Maps.difference(map, map2);
        System.out.println(difference);
        System.out.println(difference.entriesDiffering());
        System.out.println(difference.entriesInCommon());
        System.out.println(difference.entriesOnlyOnLeft());
        System.out.println(difference.entriesOnlyOnRight());
    }

    private static void mapTransform() {
        ImmutableMap map = ImmutableMap.of("1", 1,
            "2", 2,
            "3", 3);

        Map mapR = Maps.transformEntries(map, new Maps.EntryTransformer<String, Integer, String>() {
            public String transformEntry(String key, Integer value) {
                return Objects.equal(value, 1) ? "yes" : "no";
            }
        });
        System.out.println(mapR);
    }

    private static void objectAsKey(ArrayList personList) {
        Map map = Maps.asMap(Sets.newHashSet(personList), new Function<Person, String>() {
            public String apply(Person p) {
                return p.getName();
            }
        });
        System.out.println(map);
    }

    private static void mapsAddUniqIndex(ArrayList personList) {
        ImmutableMap immutableMap = Maps.uniqueIndex(personList.iterator(), new Function<Person, String>() {
            public String apply(Person p) {
                return p.getName();
            }
        });

        System.out.println(immutableMap);
    }

    private static void setsUtils() {
        Set<String> wordsWithPrimeLength = ImmutableSet.of("one", "two", "three", "six", "seven", "eight");
        Set<String> primes = ImmutableSet.of("two", "three", "five", "seven");
        //并集
//        setsUnion(wordsWithPrimeLength, primes);
        //交集
//        setsIntersection(wordsWithPrimeLength, primes);
        //差集
//        setsDifference(wordsWithPrimeLength, primes);
        //元素只出现一次，并集减去交集
//        setsSymmetricDifference(wordsWithPrimeLength, primes);
        //集合的笛卡尔积
//        System.out.println(Sets.cartesianProduct(wordsWithPrimeLength, primes));
        //集合的所有子集
//        System.out.println(Sets.powerSet(wordsWithPrimeLength));
    }

    private static void setsSymmetricDifference(Set<String> wordsWithPrimeLength, Set<String> primes) {
        System.out.println(Sets.symmetricDifference(wordsWithPrimeLength, primes));
        System.out.println(Sets.symmetricDifference(primes, wordsWithPrimeLength));
    }

    private static void setsDifference(Set<String> wordsWithPrimeLength, Set<String> primes) {
        System.out.println(Sets.difference(wordsWithPrimeLength, primes));
        System.out.println(Sets.difference(primes, wordsWithPrimeLength));
    }

    private static void setsIntersection(Set<String> wordsWithPrimeLength, Set<String> primes) {
        System.out.println(Sets.intersection(wordsWithPrimeLength, primes));
        System.out.println(Sets.intersection(primes, wordsWithPrimeLength));
    }

    private static void setsUnion(Set<String> wordsWithPrimeLength, Set<String> primes) {
        System.out.println(Sets.union(wordsWithPrimeLength, primes));
        System.out.println(Sets.union(primes, wordsWithPrimeLength));
    }

    private static void listsUtils() {
//        listsPartition();

        listFilter();

//        listTransform();
    }

    private static void listTransform() {
        List<Person> people = newArrayList(new Person("bowen", 27),
            new Person("bob", 20),
            new Person("Katy", 18),
            new Person("Logon", 24));

        //映射
        List<String> names = newArrayList(transform(people, new Function<Person, String>() {

            public String apply(Person person) {
                return person.getName();
            }
        }));

    }

    private static void listFilter() {
        List<Person> people = newArrayList(new Person("bowen", 27),
            new Person("bob", 20),
            new Person("Katy", 18),
            new Person("Logon", 24));

        //过滤
        List<Person> oldPeople = newArrayList(filter(people, new Predicate<Person>() {
            public boolean apply(Person person) {
                return person.getAge() >= 20;
            }
        }));
        System.out.println(JSON.toJSONString(oldPeople));
    }

    private static void iterablesUtils(ArrayList personList) {
        //返回一个按条件过滤后的结果集
        fluentIterableFilter(personList);

        // 返回处理过的结果集
        fluentIterableTransform(personList);

        //无限循环
        fluentIterableCycle(personList);
    }

    private static void fluentIterableFilter(ArrayList personList) {
        Iterable<Person> personFilterByAge = FluentIterable.from(personList)
            .filter(new Predicate<Person>() {
                public boolean apply(Person input) {
                    return input.getAge() > 40;
                }
            });
        Iterator<Person> i = personFilterByAge.iterator();
        while (i.hasNext()) {
            System.out.println("年龄大于40的是：" + i.next().getName());
        }
    }

    private static void fluentIterableTransform(ArrayList personList) {
        List<String> transformedPersonList = FluentIterable.from(personList)
            .transform(new Function<Person, String>() {
                public String apply(Person input) {
                    return Joiner.on(':').join(input.getName(), input.getAge());
                }

            }).toList();
        Iterator transformedPersonListIterator = transformedPersonList.iterator();
        while (transformedPersonListIterator.hasNext()) {
            System.out.println("拼接起来的结果是：" + transformedPersonListIterator.next());
        }
    }

    private static void fluentIterableCycle(ArrayList personList) {
        Iterable<Person> personCycle = FluentIterable.from(personList).cycle();
        Iterator<Person> i2 = personCycle.iterator();
        while (i2.hasNext()) {
            System.out.println("cycle：" + i2.next().getName());
        }
    }

    private static void listsPartition() {
        List countUp = Ints.asList(1, 2, 3, 4, 5,6,7,8,9,10,11);
        List<List> parts = Lists.partition(countUp, 10);//{{1,2}, {3,4}, {5}}

        List fianlList=Lists.newArrayList();
        for (List part : parts) {
            fianlList.addAll(part);
        }

        System.out.println(parts);
        System.out.println(fianlList);
    }
}

class Person {

    private String name;
    private int age;

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}