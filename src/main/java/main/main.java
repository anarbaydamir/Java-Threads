package main;

import sun.jvm.hotspot.runtime.Threads;
import thread.Base;
import thread.MyConsumer;
import thread.MyProducer;

public class main {
    public static void main (String[] args) throws Exception {
//        Thread p = new Thread(new MyProducer());
//        Thread p1 = new Thread(new MyProducer());
//        Thread m1 = new Thread(new MyConsumer("Anar"));
//        Thread m2 = new Thread(new MyConsumer("Misha"));
//        Thread m3 = new Thread(new MyConsumer("Elmir"));
//        Thread m4 = new Thread(new MyConsumer("Ataskishi"));
//        Thread m5 = new Thread(new MyConsumer("Baydamir"));
//
//        p.start();
//        p1.start();
//        m1.start();
//        m2.start();
//        m3.start();
//        m4.start();
//        m5.start();
    
        System.out.println("all threads are starting");
    
        Thread[] threads = new Thread[100];
        
        for(int i=0;i<100;i++) {
            threads[i] = new Thread(new MyConsumer("Test"));
        }
        
        for (int i=0;i<100;i++){
            threads[i].start();
        }
        
        Thread.sleep(5000);
        
        System.out.println(Base.getA()); //race condition yeni eyni anda eyni adam eyni deyeri goturur qarshini almaqchun syncronized istif olunur.
    }
}
