package cn.sf.springbootdemo.entity;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

/**
 * Description:
 * Company:
 *
 * @Author: 01384657
 * Date: 2019/3/15 9:47
 */
public interface UserRepository extends JpaRepository<User, Integer> {

    /**
     * 根据用户卡号查找用户
     * @param card user.cardId
     * @return User
     */
    User findByUserCardId(String card);

    /**
     * 根据用户名字和年龄查找用户
     * @param name 用户名
     * @param age 用户年龄
     * @return User
     */
    User findByUserNameAndUserAge(String name, int age);

    /**
     * 上方方法中，jpa通过解析方法名查询数据库，此外也可通过@Query注解来创建查询
     * @param name 用户名
     * @return User
     */
    @Query("from User u where u.userName=:name")
    List<User> findUser(@Param("name") String name);
}
