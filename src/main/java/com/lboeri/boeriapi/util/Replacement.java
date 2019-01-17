package com.lboeri.boeriapi.util;

import org.apache.ibatis.scripting.xmltags.ExpressionEvaluator;
import org.jdom2.Document;
import org.jdom2.Element;
import org.jdom2.JDOMException;
import org.jdom2.input.SAXBuilder;

import java.io.IOException;
import java.io.StringReader;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class Replacement {
    private static ExpressionEvaluator evaluator = new ExpressionEvaluator();

    public static void main(String[] args) throws JDOMException, IOException {
        Map<String, Object> hm = new HashMap<>();
//        hm.put("name","aaaa");
        hm.put("gb", "gebian");
        hm.put("sfz", "sfz");
        hm.put("sex", 1);
        hm.put("birth", 2);


//        String xml = "<sql>" +
//                " <if test=\"gb == null \">" +
//                "    <select>" +
//                "       select a, b, c" +
//                "         from ac01_1" +
//                "        where aac002 = #{sfz}" +
//                "      <if test=\"name != null and name != ''\">" +
//                "         and aac003 = #{name}" +
//                "      </if>" +
//                "    </select>" +
//                " </if>" +
//                " <if test=\"gb != null \">" +
//                "    <if test=\"name != null\">" +
//                "       <select>" +
//                "          select a, b, c" +
//                "            from ac01_2" +
//                "           where aac001 = #{gb}" +
//                "             and aac003 = #{name}" +
//                "           <if test=\"sex == 1 or birth == 2\">" +
//                "             and aac004 = #{sex}" +
//                "           </if>" +
//                "       </select>" +
//                "    </if>" +
//                "    <if test=\"name == null\">" +
//                "       <select>" +
//                "           select a, b, c" +
//                "             from ac01_3" +
//                "            where aac001 = #{gb}" +
//                "           <if test=\"sex == 2 or birth == 1\">" +
//                "              and aac004 = #{sex}" +
//                "           </if>" +
//                "       </select>" +
//                "    </if>" +
//                " </if>" +
//                "</sql>";
        String xml = "<sql>" +
                " <update>update TBL_API_CONFIG " +

                "       <if test=\"sex == 2 or birth == 1\">" +
                "        apiname = #{apiname,jdbcType=VARCHAR}, " +
                "      </if> "+
                "apiip = #{apiip,jdbcType=VARCHAR},  "+
                "           where id = #{id,jdbcType=VARCHAR} " +
                "</update></sql>";
        Replacement to = new Replacement();
        String sql = to.buildSql(xml, hm);

        System.out.println("----- done. --------");
        System.out.println("取得的sql="+sql);
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

            }else if("select".equals(el.getName())||"update".equals(el.getName())){
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
