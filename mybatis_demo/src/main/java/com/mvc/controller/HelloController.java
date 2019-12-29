package com.mvc.controller;

import com.mvc.pojo.Address;
import com.mvc.pojo.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;
import java.util.Map;

/**
 * Created by Brian in 19:43 2018/4/5
 */


@Controller
@RequestMapping("/hello")
@SessionAttributes(value = {"modelmap"})
public class HelloController {

    @RequestMapping("/in")
    public String hello(){
        return "mvc/hello";
    }

    @RequestMapping("/*/ant")
    public String antStyle(){
        System.out.println("come ant");

        return "mvc/hello";
    }

    /**
     * 访问的URL/值
     * 配置映射信息：需要映射信息的后面对应的位置加入占位符{}
     */
    @RequestMapping(value = "/get/{id}", method = RequestMethod.GET)
    public String testGet(@PathVariable(value = "id") Integer id){
        System.out.println("获取到的id："+ id);
        return "mvc/hello";
    }

    /**
     * 通过声明明确的请求方法来约束处理的请求类型
     */
    @RequestMapping(value="/deleteTest", method = RequestMethod.DELETE)
    public String subTest(){
        return "mvc/hello";
    }

    /**
     * @PathVariable 将请求URL 中的值绑定到参数id， 并传入方法形参
     */
    @RequestMapping(value = "pathVar/{id}")
    public String pathV(@PathVariable("id") Integer id){
            System.out.println("id == "+id);
        return "mvc/hello";
    }


    /**
     * @RequestParam (value="name_T") name_T 是指前端具体的元素的name 属性值
     */
    @RequestMapping(value = "/testparam")
    public String testParam(@RequestParam(value = "id") Integer a, @RequestParam(value = "name")String b){
        System.out.println(a+" == "+b);
        return "mvc/hello";
    }

    @RequestMapping("/pojo")
    public String pojo(User user){

        System.out.println(user.toString());
        return "mvc/pojo";
    }

    @RequestMapping("/testheader")
    public String testheader(@RequestHeader("Accept") String accept, @RequestHeader("User-Agent") String userAgent){
        System.out.println(accept);
        System.out.println("=======");
        System.out.println(userAgent);
        return "mvc/pojo";
    }

    @RequestMapping("/testCookie")
    public String testCookie(@CookieValue("JSESSIONID")String sesId){
        System.out.println("cookie == "+sesId);
        return "mvc/pojo";
    }

    @RequestMapping("/testmodelAndView")
    public ModelAndView testMandV(){
        ModelAndView mv = new ModelAndView();
        mv.setViewName("mvc/pojo");
        // ModelAndView 模型数据的值，放到request范围当中
        mv.addObject("name", "Tom");

        return mv;
    }

    @RequestMapping("/testMap")
    public String testMap(Map<String, Object> map){
        map.put("testMap", "teatMapValue");

        return "mvc/pojo";
    }

    @RequestMapping("/testModel")
    public String testMap(Model model){
        model.addAttribute("modelTest", "testModelValue");

        return "mvc/pojo";
    }

    @RequestMapping("/testModelMap")
    public String testMap(ModelMap modelmap){
        modelmap.addAttribute("modelmap", "modelmapValue");

        return "mvc/pojo";
    }
    @RequestMapping("/result")
    public String result(){

        return "mvc/result";
    }


    /**
     * 在任何请求方法之前执行 @ModelAttribute 标记的方法
     * 此方法可以向模型中添加数据
     * 随后请求方法的形参可以从请求范围当中查找模型中指定key
     * 对应的value 对象，传入请求方法中应用
     *
     *
     */

    @ModelAttribute
    public void putUser(Map<String, Object> map){
        User user = new User();
        Address address = new Address();
        address.setCity("Seattle");
        user.setAddress(address);
        user.setId(0);
        user.setName("Brian");
        map.put("user", user);

    }


    @RequestMapping("/attributeTest")
    public String attributeTest(){
        return "mvc/attributeTest";

    }

    @RequestMapping("/attributeTest2")
    public String attributeTest(User user){
        System.out.println(user.toString());
        return "mvc/attributeTest";

    }

    @RequestMapping("/resultToPo")
    public String resultToPo(){
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return "mvc/pojo";
    }

    @RequestMapping("/poToResult")
    public String poToResult(){
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return "mvc/result";
    }

    @RequestMapping("/testGlobal")
    public String testGlobal(){
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return "mvc/international";
    }

    @RequestMapping("/inajax")
    public String testAjaxIn(User user){
        System.out.println("ajax user == "+user);

        return "test/ajaxTest";
    }

    @ResponseBody
    @RequestMapping("/ajax")
    public void testAjax(@RequestBody List<User> users){
        System.out.println("ajax user == "+users);
    }


    @RequestMapping("/testServletAPI")
    public String testServletAPI(HttpServletRequest request, HttpServletResponse response){
        System.out.println("request == "+request+", response == "+response);
        return "mvc/result";
    }


}
