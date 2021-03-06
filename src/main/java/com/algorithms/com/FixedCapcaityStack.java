package com.algorithms.com;

import java.util.Iterator;
import java.util.Spliterator;

/**
 * @ClassName: FixedCapcaityStack
 * @Description: TODO
 * @author: wql
 * @date: 2021/3/3  18:02
 */
public class FixedCapcaityStack<Item> implements Iterable<Item>{
    private Item[] store;//存放元素
    private int num;//存放元素个数
    private int full;

    public FixedCapcaityStack(int num) {
        this.num = 0;
        this.full=num;
        store=(Item[]) new Object[num];
    }

    public void resize(int num){
        Item[] item=(Item[]) new Object[num];
        for (int i=0;i<num;i++){
            item[i]=store[i];
        }
        full=num;
        store=item;
    }

    public void push(Item item){
        if (num==full){
            resize(2*full);
        }
        store[num++]=item;
    }

    public Item pop(){
        Item item=store[--num];
        store[num]=null;//避免元素游离
        if (num>0&&num==full/4){
            resize(full/2);
        }
        return item;

    }

    @Override
    public Iterator<Item> iterator() {
        return new ReerveArrayItrm();
    }
    class ReerveArrayItrm implements Iterator<Item>{

       private int i=num;
       public boolean hasNext(){
           return i>0;
       }
       public Item next(){
           return store[--num];
       }
       public void remove(){}
    }
}
