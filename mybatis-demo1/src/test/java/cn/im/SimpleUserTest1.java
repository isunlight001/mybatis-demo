package cn.im;

import cn.im.domain.User;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.io.InputStream;
import java.util.Date;
import java.util.List;

/**
 * Created by mybatis-demo
 * Author: sunlight001
 * Date: 2017/11/9
 * Time: 上午11:39
 * Email: 903635811@qq.com
 * Description :采用SimpleUserMapper.xml名称空间方式调用接口
 */
public class SimpleUserTest1 {


    /**
     * 日志logback
     */
    private static final Logger LOG = LoggerFactory.getLogger(SimpleUserTest1.class);


    /**
     * 根据ID 删除用户信息
     */
    @Test
    public void testDeleteUserById(){

        //1.加载配置文件
        InputStream inputStream = SimpleUserTest.class.getClassLoader().getResourceAsStream("mybatis-config.xml");
        //2.创建sqlSessionFactory
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        //3.从sqlSessionFactory获取sqlSession会话
        SqlSession sqlSession = sqlSessionFactory.openSession();

        int i = sqlSession.delete("cn.im.mapper.SimpleUserMapper.deleteUserById", 1006);

        //提交
        sqlSession.commit();
        LOG.info("影响行数i={}",i);

    }


    /**
     * 更新用户信息
     */
    @Test
    public void testUpdateUser(){


        //1.加载配置文件
        InputStream inputStream = SimpleUserTest.class.getClassLoader().getResourceAsStream("mybatis-config.xml");
        //2.创建sqlSessionFactory
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        //3.从sqlSessionFactory获取sqlSession会话
        SqlSession sqlSession = sqlSessionFactory.openSession();

        User user = new User();
        user.setId(1000);
        user.setUsername("Tom");
        user.setAge(18);
        user.setGender(1);
        user.setEmail("tom@163.com");

        int i = sqlSession.update("cn.im.mapper.SimpleUserMapper.updateUser", user);
        //提交
        sqlSession.commit();
        LOG.info("影响行数i={}",i);
    }


    /**
     * 添加用户
     */
    @Test
    public void testAddUser(){

        //1.加载配置文件
        InputStream inputStream = SimpleUserTest.class.getClassLoader().getResourceAsStream("mybatis-config.xml");
        //2.创建sqlSessionFactory
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        //3.从sqlSessionFactory获取sqlSession会话
        SqlSession sqlSession = sqlSessionFactory.openSession();

        User user = new User();
        user.setUsername("Jim");
        user.setAge(18);
        user.setGender(1);
        user.setEmail("jim@163.com");
        user.setCreateTime(new Date());
        user.setUpdateTime(new Date());
        int i = sqlSession.insert("cn.im.mapper.SimpleUserMapper.addUser", user);
        //提交
        sqlSession.commit();
        LOG.info("影响行数i={}",i);

    }

    /**
     * 查询全部用户
     */
    @Test
    public void testFindUsers(){
        //1.加载配置文件
        InputStream inputStream = SimpleUserTest.class.getClassLoader().getResourceAsStream("mybatis-config.xml");
        //2.创建sqlSessionFactory
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        //3.从sqlSessionFactory获取sqlSession会话
        SqlSession sqlSession = sqlSessionFactory.openSession();

        List<User> users =  sqlSession.selectList("cn.im.mapper.SimpleUserMapper.findUsers");
        LOG.info("用户列表users={}",users);
    }

    /**
     * 通过用户ID查询用户信息
     */
    @Test
    public void testFindUserById(){

        //1.加载配置文件
        InputStream inputStream = SimpleUserTest.class.getClassLoader().getResourceAsStream("mybatis-config.xml");
        //2.创建sqlSessionFactory
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        //3.从sqlSessionFactory获取sqlSession会话
        SqlSession sqlSession = sqlSessionFactory.openSession();

        User user = sqlSession.selectOne("cn.im.mapper.SimpleUserMapper.findUserById",1004);
        //提交
        sqlSession.commit();
        LOG.info("用户信息User={}",user);
        sqlSession.close();
        try {
            inputStream.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
