package com.controller;

import com.common.Model;
import org.xml.sax.helpers.DefaultHandler;

import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.File;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by sist on 2016-03-11.
 * 역할 - Model 클래스 모아서 관리함.
 */
public class WebApplicationContext extends DefaultHandler {
    private Map classMap=new HashMap();

    //생성자
    public WebApplicationContext(String path){
        try{
            SAXParserFactory saxParserFactory=SAXParserFactory.newInstance();
            SAXParser saxParser=saxParserFactory.newSAXParser();
            HandlerMapping handlerMapping=new HandlerMapping();

            saxParser.parse(new File(path),handlerMapping);

            classMap=handlerMapping.map;

        }catch (Exception ex){
            System.out.println("WebApplication 생성자 : " +ex.getMessage());
        }
    }

    //디비에 요청한 클래스를 획득
    public Model getBean(String id){
        //클래스 획득
        return (Model)classMap.get(id);
    }
}





























