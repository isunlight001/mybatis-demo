package cn.sunlight001.domain;

import lombok.Data;

import java.util.Date;
import java.util.HashMap;

/**
 * Created by mybatis-demo
 * Author: sunlight001
 * Date: 2017/11/9
 * Time: 上午10:11
 * Email: 903635811@qq.com
 * Description :创建映射数据库的实体对象
 */
@Data
public class User {
	HashMap m;
    //用户ID
    private Integer id;
    //用户名称
    private String username;
    //用户邮箱
    private String email;
    //用户年龄
    private int age;
    //用户性别
    private int gender;
    //创建时间
    private Date createTime;
    //更新时间
    private Date updateTime;

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", email='" + email + '\'' +
                ", age=" + age +
                ", gender=" + gender +
                ", createTime=" + createTime +
                ", updateTime=" + updateTime +
                '}';
    }
}
