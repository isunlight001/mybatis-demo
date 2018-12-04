package cn.im;

import cn.im.domain.User;
import cn.im.mapper.SimpleUserMapper;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.io.IOException;
import java.io.InputStream;
import java.util.Date;
import java.util.List;

/**
 * Created by mybatis-demo
 * Author: hushuang
 * Date: 2017/11/9
 * Time: 上午10:18
 * Email: hd1611756908@163.com
 * Description : 用户表的测试类,此测试类采用Mapper.class方式
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations="classpath:applicationContext.xml")
public class SimpleUserTest {


    /**
     * 日志logback
     */
    private static final Logger LOG = LoggerFactory.getLogger(SimpleUserTest.class);
    @Autowired
    private  SimpleUserMapper userMapper;

    /**
     * 测试连接数据库
     */
//    @Test
//    public void testConnection(){
//
//        //1.使用类加载器加载mybatis-config.xml文件或者采用官网提供的方法加载配置文件
//        InputStream inputStream = SimpleUserTest.class.getClassLoader().getResourceAsStream("mybatis-config.xml");
//        //2.创建sqlSessionFactory
//        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
//        //3.从sqlSessionFactory获取sqlSession会话
//        SqlSession sqlSession = sqlSessionFactory.openSession();
//        //4.打印数据库连接
//        LOG.info("数据库连接：====="+sqlSession.getConnection()+"");
//    }


    /**
     * 测试数据库的增删改查 ( CRUD )
     */


    /*
        插入一条用户信息
     */
    @Test
    public void testAddUser(){

        //1.加载配置文件
//        InputStream inputStream = SimpleUserTest.class.getClassLoader().getResourceAsStream("mybatis-config.xml");
//        //2.创建sqlSessionFactory
//        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
//        //3.从sqlSessionFactory获取sqlSession会话
//        SqlSession sqlSession = sqlSessionFactory.openSession();
//
//        SimpleUserMapper userMapper = sqlSession.getMapper(SimpleUserMapper.class);

        /*
            封装User对象参数
         */
        User user = new User();
        user.setUsername("蕾蕾");
        user.setAge(18);
        user.setGender(2);
        user.setEmail("leilei@163.com");
        user.setCreateTime(new Date());
        user.setUpdateTime(new Date());
        try {
            int i = userMapper.addUser(user);
            LOG.info("影响行数i={}",i);
            //提交 (注意如果不进行提交，数据库里面是没有数据的)
//            sqlSession.commit();
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
        }
    }


    /*
        查询一条用户信息
     */
    @Test
    public void testFindUserById(){

        //1.加载配置文件
//        InputStream inputStream = SimpleUserTest.class.getClassLoader().getResourceAsStream("mybatis-config.xml");
//        //2.创建sqlSessionFactory
//        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
//        //3.从sqlSessionFactory获取sqlSession会话
//        SqlSession sqlSession = sqlSessionFactory.openSession();
//
//        SimpleUserMapper userMapper = sqlSession.getMapper(SimpleUserMapper.class);


        try {
            User user = userMapper.findUserById(1000);
//            sqlSession.commit();
            LOG.info("用户信息User={}",user);
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
//            sqlSession.close();
//            try {
//                inputStream.close();
//            } catch (IOException e) {
//                e.printStackTrace();
//            }
        }
    }

    /*
        查询全部用户信息
     */
    @Test
    public void testFindUsers(){

        //1.加载配置文件
//        InputStream inputStream = SimpleUserTest.class.getClassLoader().getResourceAsStream("mybatis-config.xml");
//        //2.创建sqlSessionFactory
//        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
//        //3.从sqlSessionFactory获取sqlSession会话
//        SqlSession sqlSession = sqlSessionFactory.openSession();
//
//        SimpleUserMapper userMapper = sqlSession.getMapper(SimpleUserMapper.class);

        try {
            List<User> users = userMapper.findUsers();
            LOG.info("全部用户信息Users={}",users);
//            sqlSession.commit();
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
//            sqlSession.close();
//            try {
//                inputStream.close();
//            } catch (IOException e) {
//                e.printStackTrace();
//            }
        }
    }


    /*
        跟新用户信息
     */
    @Test
    public void testUpdateUser(){
        //1.加载配置文件
//        InputStream inputStream = SimpleUserTest.class.getClassLoader().getResourceAsStream("mybatis-config.xml");
//        //2.创建sqlSessionFactory
//        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
//        //3.从sqlSessionFactory获取sqlSession会话
//        SqlSession sqlSession = sqlSessionFactory.openSession();
//
//        SimpleUserMapper userMapper = sqlSession.getMapper(SimpleUserMapper.class);


        User user = new User();
        user.setId(1002);
        user.setUsername("Polly");

        try {
            int i = userMapper.updateUser(user);
            LOG.info("影响行数i={}",i);
//            sqlSession.commit();
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
//            sqlSession.close();
//            try {
//                inputStream.close();
//            } catch (IOException e) {
//                e.printStackTrace();
//            }
        }
    }

    /*
        删除用户
     */
    @Test
    public void testDeleteUserById(){

        //1.加载配置文件
//        InputStream inputStream = SimpleUserTest.class.getClassLoader().getResourceAsStream("mybatis-config.xml");
//        //2.创建sqlSessionFactory
//        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
//        //3.从sqlSessionFactory获取sqlSession会话
//        SqlSession sqlSession = sqlSessionFactory.openSession();
//
//        SimpleUserMapper userMapper = sqlSession.getMapper(SimpleUserMapper.class);

        try {
            int i = userMapper.deleteUserById(1002);
//            sqlSession.commit();
            LOG.info("影响行数i={}",i);
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
//            sqlSession.close();
//            try {
//                inputStream.close();
//            } catch (IOException e) {
//                e.printStackTrace();
//            }
        }
    }



}
