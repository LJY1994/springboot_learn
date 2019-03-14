package cn.sf.springboot_mysql_mybatis.controller;

import cn.sf.springboot_mysql_mybatis.entity.User;
import cn.sf.springboot_mysql_mybatis.service.UserService;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

/**
 * Description:
 * Company:
 *
 * @Author: 01384657
 * Date: 2019/3/12 16:05
 */
@RestController
@RequestMapping(value = "/users")
public class HelloController {

    @Autowired
    private UserService userService;

    @RequestMapping(value = "/hello", method = RequestMethod.GET)
    @ApiOperation(value = "欢迎页", notes = "d")
    public String index(){

        return "Hello visitor";
    }

    @RequestMapping(value = "/", method = RequestMethod.POST)
    @ApiOperation(value = "创建用户", notes = "输入用户属性字段")
    @ApiImplicitParam(name = "user", value = "用户详细实体user", required = true, dataType = "User")
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

    @ApiOperation(value = "查询用户", notes = "输入用户姓名")
    @ApiImplicitParam(name = "userName", value = "用户姓名",
            required = true, dataType = "String", paramType = "query")
    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String getUser(@RequestParam String userName){

        // Swagger2 测试获取不到数据, localhost:8080/?name= 则正常
        // Swagger2 默认Context-type是 application/json; 增加paramType = "query"
        System.out.println("name : " + userName);
        User user = userService.getUserInfo(userName);
        if(user != null){
            return user.toString();
        }

        return "No Record";
    }

    @ApiOperation(value = "列举用户")
    @RequestMapping(value = "/list", method = RequestMethod.GET)
    public ModelAndView view(){
        ModelAndView mv = new ModelAndView("home");
        mv.addObject("name","Authors Table");
        mv.addObject("users", userService.getUsers());
        return mv;
    }

}
