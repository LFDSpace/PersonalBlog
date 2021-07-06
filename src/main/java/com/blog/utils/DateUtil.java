package com.blog.utils;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.util.StringUtils;

//日期工具类
public class DateUtil {

   //日期对象转字符串
    public static String formatDate(Date date,String format){
        String result="";
        SimpleDateFormat sdf=new SimpleDateFormat(format);
        if(date!=null){
            result=sdf.format(date);
        }
        return result;
    }

 //字符串转日期对象
    public static Date formatString(String str,String format) throws Exception{
        if(StringUtils.isEmpty(str)){
            return null;
        }
        SimpleDateFormat sdf=new SimpleDateFormat(format);
        return sdf.parse(str);
    }

    public static String getCurrentDateStr()throws Exception{
        Date date=new Date();
        SimpleDateFormat sdf=new SimpleDateFormat("yyyyMMddhhmmss");
        return sdf.format(date);
    }

}
