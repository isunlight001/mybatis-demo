package cn.im.mapper;

import cn.im.domain.User;

import java.util.List;

/**
 * Created by mybatis-demo
 * Author: sunlight001
 * Date: 2017/11/9
 * Time: 上午10:45
 * Email: 903635811@qq.com
 * Description : 创建操作数据库User表映射的接口类
 */
public interface SimpleUserMapper {
    /**
     * 添加一个用户
     * @param user
     * @return
     * @throws Exception
     */
    int addUser(User user) throws Exception;
    /**
     * 根据用户ID查询单个用户信息
     * @param userId
     * @return
     * @throws Exception
     */
    User findUserById(int userId) throws Exception;
    /**
     * 查询全部用户信息
     * @return
     * @throws Exception
     */
    List<User> findUsers() throws Exception;
    /**
     * 更新用户信息
     * @param user
     * @return
     * @throws Exception
     */
    int updateUser(User user) throws Exception;
    /**
     * 根据用户ID删除用户信息
     * @param userId
     * @return
     * @throws Exception
     */
    int deleteUserById(int userId) throws Exception;
}
