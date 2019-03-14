package cn.sf.springboot_mysql_mybatis.service;

import cn.sf.springboot_mysql_mybatis.entity.User;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Description:
 * Company:
 *
 * @Author: 01384657
 * Date: 2019/3/12 16:07
 */

@Service
public interface UserService {

    int addUser(User user);

    List<User> getUsers();

    User getUserInfo(String name);
}
