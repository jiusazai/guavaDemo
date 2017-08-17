package BeanCopy;

import com.google.common.collect.Lists;
import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.beanutils.PropertyUtils;
import org.springframework.cglib.beans.BeanCopier;

import java.lang.reflect.InvocationTargetException;
import java.math.BigDecimal;
import java.sql.Date;

/**
 * Created by liuyang on 2017/8/15.
 */
public class beanCopyTest {

    public static void main(String[] args) throws InvocationTargetException, IllegalAccessException, NoSuchMethodException {
        justBean justBean=new justBean();
        justBean.setId(1);
        justBean.setName("qwe");
        justBean justBean2=new justBean();
        justBean2.setId(2);
        justBean2.setName("qwe2");

        FromBean fromBean=new FromBean();
        fromBean.setBeans(Lists.newArrayList(justBean,justBean2));
        fromBean.setAge(11L);
        fromBean.setMoney(new BigDecimal(100));
        fromBean.setName("jiusa");
        fromBean.setSqlTime(new Date(111111111L));
        fromBean.setTime(new Date(111111111L));

        System.out.println(fromBean);
        ToBean toBean=new ToBean();
        //apache beanUtils
//        BeanUtils.copyProperties(toBean,fromBean);
//        System.out.println(toBean);
//        justBean2.setName("ewq3");
//        System.out.println(toBean);
        //PropertyUtils
//        PropertyUtils.copyProperties(toBean,fromBean);
//        System.out.println(toBean);
//        justBean2.setName("ewq3");
//        System.out.println(toBean);
        //spring beanUtils
//        org.springframework.beans.BeanUtils.copyProperties(fromBean,toBean);
//        System.out.println(toBean);
//        justBean2.setName("ewq3");
//        System.out.println(toBean);
        //beanCopier
        BeanCopier copier = BeanCopier.create(fromBean.getClass(), toBean.getClass(), false);
        copier.copy(fromBean, toBean, null);
        System.out.println(toBean);
        justBean2.setName("ewq3");
        System.out.println(toBean);
    }
}
