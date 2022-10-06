package Pac;

public class Multithread {
    public static void main(String[] args)
    {
        int n = 8;
        MultithreadingDemo object
        = new MultithreadingDemo();
        for (int i = 0; i < n; i++) {
           
            object.start();
        }
        System.out.println("Hello from main thread ");
       
    }
}
