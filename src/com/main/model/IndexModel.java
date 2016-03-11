package com.main.model;

import com.common.Model;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by sist on 2016-03-11.
 */
public class IndexModel implements Model {
    @Override
    public String handlerRequest(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) throws Exception {
        String stringPage=httpServletRequest.getParameter("page");
        if(stringPage==null){
            stringPage="1";
        }

        return "main/index.jsp";
    }
}





















































