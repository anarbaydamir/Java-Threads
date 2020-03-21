package thread;

import java.util.UUID;

public class MyProducer implements Runnable {
    
    @Override
    public void run (){
        while (true) {
            Base.list.add(UUID.randomUUID().toString());
        }
    }
    
    //monitor,lock,synchronized ---- also there can be deadlock while using lock
    
    Object monitor1 = new Object();
    Object monitor2 = new Object();
    
    public void doIt1(){
        System.out.println("Do it 1 starting");
        
        synchronized (monitor1) {
            System.out.println("Do it 1");
        }
        
        System.out.println("Do it 1 ended");
    }
    
    public void doIt2(){
        System.out.println("Do it 2 starting");
        
        synchronized (monitor2) {
            System.out.println("Do it 2");
        }
        
        System.out.println("Do it 2 ended");
    }
    
    public void doIt3(){
        System.out.println("Do it 3 starting");
        
        synchronized (this) {
            System.out.println("Do it 3");
        }
        
        System.out.println("Do it 3 ended");
    }
}
