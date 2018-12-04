package cn.im;

import cn.im.domain.User;
import cn.im.mapper.UserMapperPage;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.github.pagehelper.PageRowBounds;
import org.apache.ibatis.session.RowBounds;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

/**
 * Created by mybatis-demo
 * Author: hushuang
 * Date: 2017/11/10
 * Time: 上午9:38
 * Email: hd1611756908@163.com
 * Description : 分页插件的测试类
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:applicationContext.xml"})
public class UserMapperPageTest {

    /**
     * 日志slf4j
     */
    private static final Logger LOG = LoggerFactory.getLogger(UserMapperPageTest.class);
    @Autowired
    private UserMapperPage userMapper;

    /**
     * 方式一
     * Mapper接口方式的调用
     * 采用PageHelper.startPage(1, 10);方式调用
     * 使用方式如下
     */
    @Test
    public void testStartPage(){
        /*
            startPage方法的第一个参数为页码，第二个参数为每页显示数量
            查询语句必须紧跟着PageHelper.startPage(2, 1)后面，否则会报错
         */
        PageHelper.startPage(1, 2);
        List<User> pageUser = userMapper.findPageUser();
        for (User user : pageUser) {
            LOG.info("========={}",user);
        }
        LOG.info("查询数量为count={},pageUser={}",pageUser.size(),pageUser);

    }


    /**
     * 方式二
     * Mapper接口方式的调用
     * 采用PageHelper.offsetPage(1, 10);方式调用
     * 使用方式如下
     */
    @Test
    public void testOffsetPag(){
        /*
            offsetPage方法的第一个参数为页码，第二个参数为每页显示数量
            查询语句必须紧跟着PageHelper.offsetPage(2, 1)后面
            注意offsetPage 方法的第一页数据的当前页为0不是1，这点和startPage不同
         */
        PageHelper.offsetPage(0,1);
        List<User> pageUser = userMapper.findPageUser();
        for (User user : pageUser) {
            LOG.info("========={}",user);
        }
        LOG.info("查询数量为count={},pageUser={}",pageUser.size(),pageUser);

    }


    /**
     * 方式三 参数方法调用
     * Mapper接口中存在类似于
     * List<User> findPageByNumAndSize(@Param("pageNumKey") int pageNumKey, @Param("pageSizeKey") int pageSizeKey);
     * 的方法，只需要在xml配置文件中配置supportMethodsArguments=true即可,
     * 官网说还需要配置<property name="params" value="pageNum=pageNumKey;pageSize=pageSizeKey;"/>,
     * 但是我这里测试了一下，配置和不配置都是可以的，如果配置，注意参数的问题，要对应上
     * 使用方式如下
     */
    @Test
    public void testParmerPage(){

        List<User> pageUser = userMapper.findPageByNumAndSize(2,2);
        for (User user : pageUser) {
            LOG.info("========={}",user);
        }
        LOG.info("查询数量为count={},pageUser={}",pageUser.size(),pageUser);

    }

    /**
     * 方式四  RowBounds方式分页
     * 使用方式如下
     * 注意：RowBounds 这种接口查询方式返回数据中没有总记录数，
     * 官网说可以通过PageRowBounds对象获取，但是我这里没有获取到不知道是因为什么原因
     * 所以我这里不建议使用
     */
    @Test
    public void testRowNumPage(){

        PageRowBounds rowBounds = new PageRowBounds(1,2);
        List<User> pageUser = userMapper.findPageByRowNum(rowBounds);
        for (User user : pageUser) {
            LOG.info("========={}",user);
        }
        LOG.info("查询数量为count={},pageUser={}",pageUser.size(),pageUser);

    }


    /**
     * 方式四  PageInfo方式
     * 这种方式不属于分页，是一种封装分页的方式，
     * 就是说，将已经分页查询之后的数据进行再一次的封装，这样会获取到非常全面的分页属性
     * 使用方式如下
     */
    @Test
    public void testPageInfo(){

        List<User> pageUser = userMapper.findPageByNumAndSize(1,2);
        PageInfo page = new PageInfo(pageUser);

        LOG.info("PageNum={}",page.getPageNum());
        LOG.info("PageSize={}",page.getPageSize());
        LOG.info("Total={}",page.getTotal());
        LOG.info("Users={}",page.getList());
        //…………
    }
}