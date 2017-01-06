package com;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by lawrence on 2017/1/6.hahha
 * test
 * 的开发局领导路径
 */
public class SystemTimeTestMain {

    public static void main(String [] arg){
        long currentTime=System.currentTimeMillis();
        long temp=1483667789969L;
        Date nowData=new Date(currentTime);
        Date nowData2=new Date(currentTime);
        SimpleDateFormat simpleDateFormat=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String result=simpleDateFormat.format(nowData);
        String result2=simpleDateFormat.format(nowData2);
        System.out.print(result);
        System.out.print(result2);
    }

}
