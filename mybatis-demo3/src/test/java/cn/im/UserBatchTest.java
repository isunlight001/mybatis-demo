package cn.im;

import cn.im.domain.User;
import cn.im.mapper.UserMapperBatch;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by mybatis-demo
 * Author: hushuang
 * Date: 2017/11/9
 * Time: 下午1:46
 * Email: hd1611756908@163.com
 * Description :
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:applicationContext.xml"})
public class UserBatchTest {

    private static final Logger LOG = LoggerFactory.getLogger(UserBatchTest.class);

    @Autowired
    private UserMapperBatch userMapper;


    /**
     * 批量删除
     */
    @Test
    public void testBatchDeleteUsersByIds(){
        List<Integer> ids = new ArrayList<Integer>();
        ids.add(1003);
        ids.add(1004);
        try {
            int i = userMapper.batchDeleteUsersByIds(ids);
            LOG.info("影响行数i={}",i);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * 批量查询
     */
    @Test
    public void testBatchFindUsers(){
        List<Integer> ids = new ArrayList<Integer>();
        ids.add(1000);
        ids.add(1001);
        ids.add(1002);
        try {
            List<User> users = userMapper.batchFindUsers(ids);
            LOG.info("用户数量count={},用户列表users={}",users.size(),users);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * 批量添加
     */
    @Test
    public void testBatchAddUsers(){

        List<User> users = new ArrayList<User>();
        User user1 = new User();
        user1.setUsername("polly1");
        user1.setEmail("polly1@163.com");
        user1.setAge(11);
        user1.setGender(1);
        user1.setCreateTime(new Date());
        user1.setUpdateTime(new Date());
        users.add(user1);

        User user2 = new User();
        user2.setUsername("like");
        user2.setEmail("like1@163.com");
        user2.setAge(13);
        user2.setGender(2);
        user2.setCreateTime(new Date());
        user2.setUpdateTime(new Date());
        users.add(user2);

        try {
            int i = userMapper.batchAddUsers(users);
            LOG.info("影响行数i={}",i);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * 批量更新用户信息
     */
    @Test
    public void testBatchUpdateUsers(){


        List<User> users = new ArrayList<User>();
        User user1 = new User();
        user1.setId(1003);
        user1.setUsername("小明");
        user1.setEmail("xaoming@163.com");
        user1.setAge(17);
        user1.setGender(1);
        user1.setCreateTime(new Date());
        user1.setUpdateTime(new Date());
        users.add(user1);

        User user2 = new User();
        user2.setId(1004);
        user2.setUsername("老王");
        user2.setEmail("laowang@163.com");
        user2.setAge(80);
        user2.setGender(1);
        user2.setCreateTime(new Date());
        user2.setUpdateTime(new Date());
        users.add(user2);

        try {
            int i = userMapper.batchUpdateUsers(users);
            LOG.info("影响行数i={}",i);
        } catch (Exception e) {
            e.printStackTrace();
        }


    }


}
