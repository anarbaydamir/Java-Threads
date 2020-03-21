package thread;

import java.util.ArrayList;
import java.util.List;

public class Base {

    public static List<String> list = new ArrayList<String>();
    
    private static volatile int a = 0;  // volatile butun cpularin bu value uchun ayrilan yaddash sahesinden xeberdar olmasi uchun istifade olunur
    
    public static int getA(){
        return a;
    }
    
    public static synchronized void incA(){
        a++;
    }
}
