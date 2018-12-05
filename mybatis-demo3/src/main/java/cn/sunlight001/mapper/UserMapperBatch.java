package cn.sunlight001.mapper;

import java.util.List;

import cn.sunlight001.domain.User;

/**
 * Created by mybatis-demo
 * Author: sunlight001
 * Date: 2017/11/9
 * Time: 下午1:48
 * Email: 903635811@qq.com
 * Description : 测试各种批量操作
 */
public interface UserMapperBatch {


    /**
     * 批量插入用户
     * @param users
     * @return
     * @throws Exception
     */
    int batchAddUsers(List<User> users) throws Exception;


    /**
     * 批量更新用户信息
     * @param users
     * @return
     * @throws Exception
     */
    int batchUpdateUsers(List<User> users) throws Exception;

    /**
     * 根据ID批量查询用户信息
     * @param ids
     * @return
     * @throws Exception
     */
    List<User> batchFindUsers(List<Integer> ids) throws Exception;

    /**
     * 批量删除用户信息
     * @param ids
     * @return
     * @throws Exception
     */
    int batchDeleteUsersByIds(List<Integer> ids) throws Exception;

}
