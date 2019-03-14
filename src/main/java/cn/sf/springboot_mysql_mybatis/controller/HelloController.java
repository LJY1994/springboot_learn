package cn.sf.springboot_mysql_mybatis.controller;

import cn.sf.springboot_mysql_mybatis.entity.User;
import cn.sf.springboot_mysql_mybatis.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

/**
 * Description:
 * Company: 顺丰科技有限公司国际业务科技部
 *
 * @Author: 01384657
 * Date: 2019/3/12 16:05
 */
@RestController
@RequestMapping(value = "/users")
public class HelloController {

    @Autowired
    private UserService userService;

    @RequestMapping("/hello")
    public String index(){

        return "Hello visitor";
    }

    @RequestMapping(value = "/", method = RequestMethod.POST)
    public String addUser(@RequestAttribute User user){
        //用于创建
        //数据库返回状态值及意义不明确
        if(userService.addUser(user) > 0){
            return "Added";
        }

        return "False";
    }

    // TODO: 2019/3/14 modify userInfo 
    // TODO: 2019/3/14 delete record

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String getUsers(@RequestParam String name){

        User user = userService.getUserInfo(name);
        if(user != null){
            return user.toString();
        }

        return "No record";
    }

    @RequestMapping("/list")
    public ModelAndView view(){
        ModelAndView mv = new ModelAndView("home");
        mv.addObject("name","Authors Table");
        mv.addObject("users", userService.getUsers());
        return mv;
    }

}
