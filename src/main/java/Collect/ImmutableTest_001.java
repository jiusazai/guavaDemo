package Collect;

import com.google.common.base.MoreObjects;
import java.util.Date;

/**
 * Created by liuyang on 2017/7/13.
 */
public class ImmutableTest_001 {

    public static void main(String[] args) {
        //返回对象的拷贝
        A a=new A();
        System.out.println(a);
//        a.getDate().setTime(123123123L);
        a.date.setTime(123123123L);
        System.out.println(a);

    }
     static class A{
        private final Date date;
        private A(){
            date=new Date();
        }
        public A getInstance(){
            return new A();
        }

        public Date getDate(){
            return date;
//            return new Date(date.getTime());
        }

        @Override
        public String toString() {
            return MoreObjects.toStringHelper(this)
                .add("date", date.clone())
                .toString();
        }
    }
}
