package BeanCopy;

import com.alibaba.fastjson.JSON;
import com.google.common.base.MoreObjects;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

/**
 * Created by liuyang on 2017/8/15.
 */
public class FromBean {
    private String name;
    private Long age;
    private BigDecimal money;
    private Date time;
    private java.sql.Date sqlTime;
    private List<justBean> beans;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getAge() {
        return age;
    }

    public void setAge(Long age) {
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

    public void setSqlTime(java.sql.Date sqlTime) {
        this.sqlTime = sqlTime;
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
                .add("name", name)
                .add("age", age)
                .add("money", money)
                .add("time", time)
                .add("sqlTime", sqlTime)
                .add("beans", JSON.toJSONString(beans))
                .toString();
    }
}
