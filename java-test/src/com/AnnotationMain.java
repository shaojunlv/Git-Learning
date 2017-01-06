package com;

import java.util.ArrayList;
import java.util.Collection;

/**
 * Created by lawrence on 2016/12/27.
 */
public class AnnotationMain {
    public static void main(String[] args) throws NoSuchMethodException {
        Collection<String> stringList=new ArrayList<String>();
        stringList.add("lv");
        stringList.add("shao");
        stringList.add("jun");
        String [] strings=stringList.toArray(new String[0]);
        System.out.print(strings[0]+strings[1]+strings[2]);
    }
}
