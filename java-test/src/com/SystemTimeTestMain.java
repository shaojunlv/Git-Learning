package com;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by lawrence on 2017/1/6.
 */
public class SystemTimeTestMain {

    public static void main(String [] arg){
        long currentTime=System.currentTimeMillis();
        long temp=1483667789969L;
        Date nowData=new Date(currentTime);
        SimpleDateFormat simpleDateFormat=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String result=simpleDateFormat.format(nowData);
        System.out.print(result);
    }

}
