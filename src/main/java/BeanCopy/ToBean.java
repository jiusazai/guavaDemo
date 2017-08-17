package BeanCopy;

import com.alibaba.fastjson.JSON;
import com.google.common.base.MoreObjects;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

/**
 * Created by liuyang on 2017/8/15.
 */
public class ToBean {
    private String namE;
    private Integer age;
    private BigDecimal money;

    private Date time;
    private java.sql.Date sqlTime;
    private List<justBean> beans;

    public String getNamE() {
        return namE;
    }

    public void setNamE(String namE) {
        this.namE = namE;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public BigDecimal getMoney() {
        return money;
    }

    public void setMoney(BigDecimal money) {
        this.money = money;
    }

    public Date getTime() {
        return time;
    }

    public void setTime(Date time) {
        this.time = time;
    }

    public java.sql.Date getSqlTime() {
        return sqlTime;
    }


    public List<justBean> getBeans() {
        return beans;
    }

    public void setBeans(List<justBean> beans) {
        this.beans = beans;
    }

    @Override
    public String toString() {
        return MoreObjects.toStringHelper(this)
                .add("namE", namE)
                .add("age", age)
                .add("money", money)
                .add("time", time)
                .add("sqlTime", sqlTime)
                .add("beans", JSON.toJSONString(beans))
                .toString();
    }
}
