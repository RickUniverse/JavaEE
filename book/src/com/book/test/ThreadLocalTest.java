package com.book.test;

import java.util.Map;
import java.util.Random;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author lijichen
 * @date 2020/10/19 - 17:11
 */
public class ThreadLocalTest {


    public static class Task implements Runnable {

//        public static Map<String,Object> data = new ConcurrentHashMap<>();
        public static ThreadLocal<Object> data = new ThreadLocal<Object>();
        public static Random random = new Random();

        @Override
        public void run() {
            //生成一个随机数
            Integer i = random.nextInt(1000);

            //获取当前线程名
            String name = Thread.currentThread().getName();
            //将线程与生成的随机数关联起来
//            data.put(name,i);
            data.set(i);
            System.out.println("线程["+name+"]的随机数是：" + i);
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            //将OrderService类关联到线程中
            new OrderService().createOrder();

            //在当前线程要结束时，将数据取出来
//            Object o = data.get(name);
            /*
            * 会自动用当前线程取数据
            * */
            Object o = data.get();
            System.out.println("线程["+name+"]将要结束取出的的随机数是：" + o);
        }
    }

    public static void main(String[] args) {
        //启动三个线程
        for (int i = 0; i < 3; i++) {
            new Thread(new Task()).start();
        }
    }
}

class OrderService {
    public void createOrder() {
        String name = Thread.currentThread().getName();
        System.out.println("当前线程["+name+"]访问OrderSerice操作的数据是：" + ThreadLocalTest.Task.data.get());
        new OrderDao().saveOrder();
    }
}
class OrderDao {
    public void saveOrder() {
        String name = Thread.currentThread().getName();
        System.out.println("当前线程["+name+"]访问OrderDao操作的数据是：" + ThreadLocalTest.Task.data.get());
    }
}