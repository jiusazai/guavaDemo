package Collect;

import com.google.common.base.MoreObjects;
import java.util.Date;

/**
 * Created by liuyang on 2017/7/13.
 */
public class ImmutableTest_002 {

    public static void main(String[] args) {
        //类不能被扩展
        A a=new A(new Date());
        System.out.println(a);
        B b=new B(new Date(),a);
        System.out.println(a);

    }
       static  class A{
        private final Date date;

        private A(Date someDay){
            date=new Date(someDay.getTime());
        }

        public A getInstance(Date someDay){
            return new A(someDay);
        }

        @Override
        public String toString() {
            return MoreObjects.toStringHelper(this)
                .add("date", date.clone())
                .toString();
        }
    }

    static class B extends A{
        A a;

        public B(Date someDay, A a) {
            super(someDay);
            this.a = a;
            a.date.setTime(123123123L);
        }


    }
}
