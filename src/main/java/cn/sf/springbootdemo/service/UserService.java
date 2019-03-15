package cn.sf.springbootdemo.service;

import cn.sf.springbootdemo.entity.User;
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
