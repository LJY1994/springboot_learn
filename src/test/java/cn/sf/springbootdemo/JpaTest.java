package cn.sf.springbootdemo;

import cn.sf.springbootdemo.entity.User;
import cn.sf.springbootdemo.entity.UserRepository;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * Description:
 * Company:
 *
 * @Author: 01384657
 * Date: 2019/3/15 9:59
 */
@SpringBootTest
@RunWith(SpringRunner.class)
public class JpaTest {

    @Autowired
    private UserRepository userRepository;

    @Test
    public void test(){
        userRepository.save(new User("111","aa","1",11));
        userRepository.save(new User("222","bb","2",100));
        userRepository.save(new User("333","cc","3",22));
        userRepository.save(new User("444","dd","4",33));
        userRepository.save(new User("555","dd","5",44));

        Assert.assertEquals(5, userRepository.findAll().size());

        Assert.assertEquals(2, userRepository.findUser("dd").size());

        Assert.assertEquals("444", userRepository.findByUserCardId("444").getUserCardId());

        Assert.assertEquals("4", userRepository.findByUserNameAndUserAge("dd", 33).getUserDesc());

        userRepository.delete(userRepository.findByUserCardId("333"));

        Assert.assertEquals(4, userRepository.findAll().size());

        userRepository.deleteAll(userRepository.findUser("dd"));

        Assert.assertEquals(2, userRepository.findAll().size());
    }
}
