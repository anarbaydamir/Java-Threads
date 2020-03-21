package thread;

public class MyRunnable implements Runnable {
    
    private int index;
    public MyRunnable(int index) {
        this.index=index;
    }
    @Override
    public void run(){
        System.out.println(index + ".Runnable will sleep in 3 seconds");
        
        try
        {
            Thread.sleep(3000);
        }
        catch (InterruptedException iex){
            iex.printStackTrace();
        }
        
        System.out.println("Runnable finished");
    }
}
