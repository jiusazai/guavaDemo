package List;

import com.google.common.base.Function;
import com.google.common.base.Predicate;

import java.math.BigDecimal;
import java.util.Iterator;
import java.util.List;

import static com.google.common.collect.Iterables.filter;
import static com.google.common.collect.Iterables.transform;
import static com.google.common.collect.Lists.newArrayList;

/**
 * Created by jiusa on 2017/3/2.
 */
public class list {

    public static void main(String[] args) {
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

        //映射
        List<String> names=newArrayList(transform(people, new Function<Person, String>() {

            public String apply(Person person) {
                return person.getName();
            }
        }));

        BigDecimal a=new BigDecimal(1);
        BigDecimal b=new BigDecimal(3);

        System.out.println(a.divide(b,2,BigDecimal.ROUND_HALF_EVEN));


    }


    static class Person {
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

        private String name;
        private int age;

        public Person(String name, int age) {
            this.name = name;
            this.age = age;
        }
    }




}
