package main;

import thread.MyRunnable;

import java.sql.Time;
import java.util.concurrent.*;

public class ExecutableMain {
    public static void main(String[] args){
        scheduledThreadPool();
    }
    
    
    public static void scheduledThreadPool (){ // threadleri schedule etmek uchun istifade olunur.
        ScheduledExecutorService ex = Executors.newScheduledThreadPool(1);
        
        ex.schedule(new MyRunnable(1),0, TimeUnit.SECONDS);
        ex.schedule(new MyRunnable(1),0,TimeUnit.SECONDS);
    }
    
    
    
    private static void cachedThreadPool(){ // threadlari idare etmek uchun cache qalan bosh threadden tekraren istifade uchundur.
        ExecutorService service1 = new ThreadPoolExecutor(10,15,10,TimeUnit.SECONDS,new ArrayBlockingQueue<Runnable>(20));
        ExecutorService service2 = Executors.newCachedThreadPool();
    }
    
    public static void fixedThreadPool() { // 5 deneden artiq threadi bashlatmir 5i bitenden sonra o birileri bashladir
        ExecutorService service =  Executors.newFixedThreadPool(5);
        
        for (int i=0; i<10;i++) {
            service.submit(new MyRunnable(i));
        }
        
        service.shutdown(); // executor servici bitirmek uchun istifade olunur
        
        try {
            service.awaitTermination(2, TimeUnit.SECONDS); // serviceden sonraki emeliyyati icra etmek uchun bir qeder gozluyur
        }
        catch (InterruptedException ie)
        {
            ie.printStackTrace();
        }
        System.out.println("executor service bitdikden sonraki emeliyyatlar");
    }
    
    public static void singleThreadExecutor() {  // bir-bir edir threadleri
        ExecutorService service =  Executors.newSingleThreadExecutor();
    
        Future f = service.submit(new MyRunnable(1));
        service.submit(new MyRunnable(2));
        service.submit(new MyRunnable(3));
        service.submit(new MyRunnable(4));
        service.submit(new MyRunnable(5));
        
        
    }
}
