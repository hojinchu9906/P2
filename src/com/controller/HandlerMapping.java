package com.controller;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by sist on 2016-03-11.
 * 용도 -파싱역할
 */
public class HandlerMapping extends DefaultHandler {
    Map map=new HashMap();

    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {

    }
}
