package cn.sf.springboot_mysql_mybatis.dao;

import cn.sf.springboot_mysql_mybatis.entity.User;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Description:
 * Company: 顺丰科技有限公司国际业务科技部
 *
 * @Author: 01384657
 * Date: 2019/3/12 16:06
 */

@Repository
public interface UserDAO {

    int addUser(User user);

    List<User> getUsers();

    User getUserInfo(String name);
}
