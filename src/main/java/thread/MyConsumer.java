package thread;

public class MyConsumer implements Runnable {
    
    private String name;
    
    public MyConsumer(String name) {
        this.name = name;
    }
    
    @Override
    public void run() {
//        while (true) {
//            int lastIndex = Base.list.size() - 1;
//            System.out.println(lastIndex);
//            if (lastIndex > -1) {
//                String s = Base.list.remove(lastIndex);
//                System.out.println(name + "= " + s);
//            }
//        }
    
        System.out.println("I am waiting");
    
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
        
        }
        Base.incA();
    }
}
