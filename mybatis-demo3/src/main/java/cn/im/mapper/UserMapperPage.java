package cn.im.mapper;

import cn.im.domain.User;
import com.github.pagehelper.PageRowBounds;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.session.RowBounds;

import java.util.List;

/**
 * Created by mybatis-demo
 * Author: hushuang
 * Date: 2017/11/9
 * Time: 下午1:48
 * Email: hd1611756908@163.com
 * Description : 测试分页查询
 */
public interface UserMapperPage {


    /**
     * 按页查询用户信息
     * @return
     */
    List<User> findPageUser();

    /**
     * Mapper接口方式的调用，推荐这种使用方式
     * 这种查询方式需要在xml配置文件中配置配置参数信息
     * @param pageNumKey : 当前页
     * @param pageSizeKey : 每页查询的数量
     * @return : 用户列表信息
     */
    List<User> findPageByNumAndSize(@Param("pageNumKey") int pageNumKey, @Param("pageSizeKey") int pageSizeKey);

    /**
     * 采用接口方式的配置RowBounds参数
     * PageRowBounds 是继承 RowBounds的子类，因为RowBounds没有提供查询数量总数，但是PageRowBounds可以获取到
     * @param rowBounds
     * @return
     */
    List<User> findPageByRowNum(RowBounds rowBounds);

}
