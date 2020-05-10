package com.java.renda;

import java.io.File;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.function.Supplier;

public class HelloWorld {

    public static void main(String[] args) throws ParseException {

        System.out.println("Hello 你好");

        Child child = new Child();
        child.eat();

        Parent parent = new Child();
        System.out.println(parent.num);
        System.out.println(parent.getNum());

        method(10.0); // correct term: double --> double
        method(20); // correct term: int --> double
        int a = 30;
        method(a); // correct term: int --> double

        System.out.println(parent.toString());
        System.out.println(child.toString());

        Date date1 = new Date();

        System.out.println(date1);

        DateFormat dateFormat = new SimpleDateFormat("yyyyMMdd");
        String s1;
        s1 = dateFormat.format(date1);
        final String s2 = "19951227";
        Date date2;
        date2 = dateFormat.parse(s2);
        System.out.println(date2);
        System.out.println(s1);
        long delta_milisecond = date1.getTime() - date2.getTime();
        System.out.println("Days Alive: " + delta_milisecond/1000/60/60/24);

        HashSet<String> hashSet = new HashSet<>();
        hashSet.add("a");
        hashSet.add("b");
        hashSet.add("c");
        for (Object aHashSet : hashSet) {
            String temp = aHashSet.toString();
            System.out.println(temp);
        }
        System.out.println(hashSet.size());

        // hashcode collision
        System.out.println("重地".hashCode());//1179395
        System.out.println("通话".hashCode());//1179395

        ArrayList<Person> list01 = new ArrayList<>();
        list01.add(new Person("abc", 1));
        list01.add(new Person("bca", 2));
        list01.add(new Person("def", 3));
        list01.add(new Person("cdd", 1));
        System.out.println(list01);
        Collections.sort(list01);
        System.out.println(list01);

        File f1 = new File("myFolder\\ccc");
        System.out.println(f1.getAbsolutePath());
        System.out.println("f1: "+f1.exists());
        System.out.println("f1: "+f1.mkdir());
        System.out.println("f1: "+f1.exists());

        int[] arr = {100,0,-50,880,99,33,-30};
/*      // Anonymous Inner Class
        int maxValue = getMax(new Supplier<Integer>() {
            @Override
            public Integer get() {
                int max = arr[0];
                for(int i:arr) {
                    if (i>max) { max=i; }
                }
                return max;
            }
        });*/
        // Lambda Funtional Interface
        int maxValue = getMax(()->{
            int max = arr[0];
            for (int i:arr) {
                if (i>max) { max=i;}
            }
            return max;
        });
        System.out.println("The max value is:"+maxValue);

        System.out.println("aBcD".toLowerCase().toUpperCase());
    }

    private static int getMax(Supplier<Integer> sup){
        return sup.get();
    }

    private static void method(double num) {
        System.out.println(num);
    }
}
