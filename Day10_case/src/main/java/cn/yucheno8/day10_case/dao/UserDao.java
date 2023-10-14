package cn.yucheno8.day10_case.dao;

import cn.yucheno8.day10_case.domain.User;

import java.util.List;
import java.util.Map;

/**
 * 用户操作的Dao
 */
public interface UserDao {
    public List<User> findAll();

    public User findUserByUsernameAndPassword(String username, String password);

    void add(User user);

    void delete(int id);

    User findById(int id);

    void update(User user);

    /**
     * 查询总记录数
     * @return
     */
    int findTotalCount(Map<String, String[]> condition);

    /**
     * 分页查询每页记录
     *
     * @param start
     * @param rows
     * @param condition
     * @return
     */
    List<User> findByPage(int start, int rows, Map<String, String[]> condition);
}
