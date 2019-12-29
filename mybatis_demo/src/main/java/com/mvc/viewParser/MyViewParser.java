package com.mvc.viewParser;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.View;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Map;

/**
 * Created by Brian in 18:01 2018/4/8
 */
// 默认bean 的id 为类的首字母小写
@Component
public class MyViewParser implements View {
    private static final String type = "text/html";
    /**
     * 告知spring容器，contextType
     *
     * @return
     */
    @Override
    public String getContentType() {
        return type;
    }

    @Override
    public void render(Map<String, ?> model, HttpServletRequest request, HttpServletResponse response) throws Exception {
        response.setContentType(type);
        response.getWriter().println("<h2>this is my viewParser </h2>");
    }
}