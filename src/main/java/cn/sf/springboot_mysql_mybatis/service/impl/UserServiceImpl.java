package cn.sf.springboot_mysql_mybatis.service.impl;

import cn.sf.springboot_mysql_mybatis.dao.UserDAO;
import cn.sf.springboot_mysql_mybatis.entity.User;
import cn.sf.springboot_mysql_mybatis.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Description:
 * Company: 顺丰科技有限公司国际业务科技部
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
