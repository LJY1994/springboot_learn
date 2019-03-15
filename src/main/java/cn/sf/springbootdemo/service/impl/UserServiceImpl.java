package cn.sf.springbootdemo.service.impl;

import cn.sf.springbootdemo.dao.UserDAO;
import cn.sf.springbootdemo.entity.User;
import cn.sf.springbootdemo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Description:
 * Company:
 *
 * @Author: 01384657
 * Date: 2019/3/12 16:08
 */
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDAO userDAO;

    @Override
    public int addUser(User user) {
        if(user.getUserCardId() != null){
            if(user.getUserDesc() != null){
                if(user.getUserName() != null){
                    return userDAO.addUser(user);
                }
            }
        }

        return 0;
    }

    @Override
    public List<User> getUsers() {
        return userDAO.getUsers();
    }

    @Override
    public User getUserInfo(String name) {
        return userDAO.getUserInfo(name);
    }
}
