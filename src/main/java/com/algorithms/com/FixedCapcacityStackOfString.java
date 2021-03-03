package com.algorithms.com;

/**
 * @ClassName: FixedCapcacityStackOfString
 * @Description: 字符串栈
 * @author: wql
 * @date: 2021/3/3  17:46
 */
public class FixedCapcacityStackOfString {
    private String[] store;//存放位置
    private int n;//存储个数

    public FixedCapcacityStackOfString(int n) {
        this.n = 0;
        store=new String[n];
    }

    public boolean isEmpty(){
        return n==0;
    }

    public void push(String s){
        store[n++]=s;
    }

    public String pop(){
        return store[n--];
    }
}
