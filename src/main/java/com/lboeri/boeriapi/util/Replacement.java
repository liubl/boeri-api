package com.lboeri.boeriapi.util;

import org.apache.ibatis.scripting.xmltags.ExpressionEvaluator;
import org.jdom2.Document;
import org.jdom2.Element;
import org.jdom2.JDOMException;
import org.jdom2.input.SAXBuilder;

import java.io.IOException;
import java.io.StringReader;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class Replacement {
    private static ExpressionEvaluator evaluator = new ExpressionEvaluator();

    public static String buildSql(String type,String xml, Map<String, Object> hm) throws JDOMException, IOException {
        xml = "<sql><"+type+">" + xml + "</"+type+"></sql>";
        SAXBuilder jdomBuilder = new SAXBuilder();
        Document jdomDocument = jdomBuilder.build(new StringReader(xml));
        System.out.println(jdomDocument.getRootElement().getName());
        if(!"sql".equals(jdomDocument.getRootElement().getName())){
            System.out.println("非法的xml");
            return null;
        }

        String sql;
        Element select = jdomDocument.getRootElement();

        sql = analyseEl(select.getChildren(), hm);
        if(null != sql && !"".equals(sql)){
            return sql;
        }

        return null;
    }

    public static String buildSql(String xml, Map<String, Object> hm) throws JDOMException, IOException {
        xml = "<sql><select>" + xml + "</select></sql>";
        SAXBuilder jdomBuilder = new SAXBuilder();
        Document jdomDocument = jdomBuilder.build(new StringReader(xml));
        System.out.println(jdomDocument.getRootElement().getName());
        if(!"sql".equals(jdomDocument.getRootElement().getName())){
            System.out.println("非法的xml");
            return null;
        }

        String sql;
        Element select = jdomDocument.getRootElement();

        sql = analyseEl(select.getChildren(), hm);
        if(null != sql && !"".equals(sql)){
            return sql;
        }

        return null;
    }

    private static String analyseEl(List<Element> els, Map<String, Object> hm) {
        Element el = null;
        Element el2 = null;
        for (Iterator<Element> iter = els.iterator(); iter.hasNext();){
            el = iter.next();
            if("if".equals(el.getName())){
                String test = el.getAttributeValue("test");
                System.out.println("test="+test);
                if(!evaluator.evaluateBoolean(test, hm)){
                    continue;
                }

                String sql;

                sql = analyseEl(el.getChildren(), hm);
                if(null != sql && !"".equals(sql)){
                    return sql;
                }

            }else if("select".equals(el.getName())||"update".equals(el.getName())||"insert".equals(el.getName())||"delete".equals(el.getName())){
                List<Element> list = el.getChildren();
                for (Iterator<Element> iter2 = list.iterator(); iter2.hasNext();){
                    el2 = iter2.next();
                    if("if".equals(el2.getName())){
                        System.out.println("test="+el2.getAttributeValue("test"));
                        if(!evaluator.evaluateBoolean(el2.getAttributeValue("test"), hm)){
                            el.removeContent(el.indexOf(el2));
                        }
                    }
                }

                System.out.println(el.getValue());
                return el.getValue();
            }else{
                System.out.println("无有效配置.");
            }
        }

        return null;
    }
}
