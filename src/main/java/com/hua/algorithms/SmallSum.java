package com.hua.algorithms;

import java.util.concurrent.Phaser;
import java.util.concurrent.Semaphore;
import java.util.concurrent.locks.LockSupport;

/**
 * @author huazai
 * @date 2021/4/20 11:26
 */
public class SmallSum {
    static Thread t1 = null;
    static Thread t2 = null;


    public static void main(String[] args) {

        t1 = new Thread(() -> {
            for(int i=1;i<=10;i=i+2){
                System.out.println("单数" + i);
                LockSupport.unpark(t2);
                LockSupport.park();
            }

        });

        t2 = new Thread(() -> {
            for(int i=2;i<=10;i=i+2){
                LockSupport.park();
                System.out.println("双数" + i);
                LockSupport.unpark(t1);

            }

        });

        t1.start();
        t2.start();






//
//

//        new Thread(() -> {
//            while (i <=10){
//
//                if(i % 2 == 0){
//                    try {
//                        semaphore.acquire();
//                        System.out.println("双" + i);
//                        i++;
//                    } catch (InterruptedException e) {
//                        e.printStackTrace();
//                    } finally {
//                        semaphore.release();
//                    }
//                }
//            }
//
//        }).start();
//

    }






}
