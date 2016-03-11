package com.controller;

import com.common.Model;
import com.sun.deploy.nativesandbox.comm.Request;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by sist on 2016-03-11.
 * 프런트 컨트롤러 역할
 */
public class DispatcherServlet extends HttpServlet {
    private WebApplicationContext webApplicationContext;

    @Override
    public void init(ServletConfig config) throws ServletException {
        String path=config.getServletContext().getRealPath("/WEB-INF/applicationContext.xml");
        webApplicationContext=new WebApplicationContext(path);
    }

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try{
            //브라우저에서 요청(request-주소값 읽기)
            String cmd=req.getRequestURI();
            cmd=cmd.substring(req.getContextPath().length()+1,cmd.lastIndexOf('.'));

            //Model 클래스 가져와 디비에 요청함.
            Model model=webApplicationContext.getBean(cmd);
            System.out.println("model : " +model);

            String jsp=model.handlerRequest(req,resp);
            String tempJsp=jsp.substring(jsp.lastIndexOf('.')+1);

            if(tempJsp.startsWith("do")){
                resp.sendRedirect(jsp);
            }else {
                RequestDispatcher requestDispatcher=req.getRequestDispatcher(jsp);
                requestDispatcher.forward(req,resp);
            }

        }catch (Exception ex){
            System.out.println("service() : " +ex.getMessage());
        }
    }
}






























