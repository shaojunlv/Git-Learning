package com;

/**
 * Created by lawrence on 2016/12/27.
 */
public class TestException {
    public void method1()throws CEException{
        throw new CEException("text exception");
    }

    public  void method2(String msg){
        if(msg==null){
            throw new NullPointerException("msg is null.");
        }
    }
    public void method3() throws CEException{
        method1();
    }

}
