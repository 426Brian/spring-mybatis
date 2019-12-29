package com.mvcdemo.controller;

import com.mvcdemo.model.Course;
import com.mvcdemo.service.CourseService;
//import org.apache.commons.lang3.builder.ReflectionToStringBuilder;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.Servlet;
import javax.servlet.ServletRequest;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import java.util.Enumeration;
import java.util.Map;

/**
 * Created by Brian in 15:32 2018/1/2
 */
@Controller
@RequestMapping("/courses")
public class CourseController {

    private static Logger logger = LoggerFactory.getLogger(CourseController.class);

    @Autowired
    public CourseService courseService;

    @RequestMapping(value = "/view", method = RequestMethod.GET)
    public String viewCourse(@RequestParam("courseId") Integer courseId, Model model) {
        logger.info("In view ================= courseId = {}", courseId);

        Course course = new Course();
        model.addAttribute(course);

        return "mvcdemo/course";
    }

    @RequestMapping(value = "/view2/{courseId}")
    public String course(@PathVariable("courseId") Integer courseId, Map map) {
        logger.info("In view2 ================= courseId2 = {}", courseId);
        Course course = new Course();
        map.put("course", course);
        return "mvcdemo/course";
    }

    @RequestMapping(value = "/view3")
    public String course2(HttpServletRequest request) {
        Integer courseId = Integer.valueOf(request.getParameter("courseId"));
        logger.info("In view3 ================= courseId3 = {}", courseId);

        return "mvcdemo/course";
    }

    @RequestMapping(params = "m=a")
    public String course3(HttpServletRequest request) {
        Integer courseId = Integer.valueOf(request.getParameter("courseId"));
        logger.info("In view3 ================= courseId3 = {}", courseId);

        return "mvcdemo/course";
    }

    @RequestMapping(value = "/save")
    public String dosave(Course course, HttpServletRequest request) {
        course.setCourseId(56);
//        logger.info(ReflectionToStringBuilder.toString(course));

        Cookie[] cookies = request.getCookies();

        return "redirect:view2/" + course.getCourseId();
    }

    @RequestMapping(params = "m=bean")
    public ModelAndView model() {
        System.out.println("==== com ===");
        ModelAndView mv = new ModelAndView();

        mv.setViewName("mvcdemo/modelView");
        mv.addObject("name", "TOM");
        return mv;
    }

    @RequestMapping(params = "m=start")
    public String start() {
        courseService.test();

        return "courses/start";
    }

    @RequestMapping("/test")
    public String test() {
        return "courses/start";
    }
}
