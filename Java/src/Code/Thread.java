//package ThreadPractice;
//
//import java.util.ArrayList;
//import java.util.List;
//import java.util.Map;
//import java.util.concurrent.Callable;
//import java.util.concurrent.ExecutorService;
//import java.util.concurrent.Executors;
//
//public class Thread {
//
//    public static void main(String[] args) {
//        A a=new A();
//        Thread thread1=new Thread(a);
//        thread1.setName("Thread....1");
//        thread1.start();
//        Executors.newSingleThreadExecutor();
//        ExecutorService executorService= Executors.newFixedThreadPool(10);
//        executorService.submit(new A());
//        executorService.shutdown();
////        executorService.submit(new D());
////        executorService.shutdown();
//        executorService.shutdownNow();
//
//        Map<Thread,StackTraceElement[]>map =Thread.getAllStackTraces();
//        for(Thread thread:map.keySet())
//        {
//            System.out.println(thread.getName()+" "+thread.getState());
//        }
//    }
//}
//
//class A implements Runnable
//{
//    public void run()
//    {
//        for(int i=0;i<1000;i++)
//        {
//            try
//            {
//                Thread.sleep(5000);
//            } catch (InterruptedException e) {
//                System.out.println("Something....");
//            }
////            System.out.println(Thread.currentThread());
////           List<?>list=new ArrayList<>();
//        }
//    }
//}
//class Person
//{
//
//}
//class D implements Callable<Person>
//{
//    public Person call()
//    {
//        return new Person();
//    }
//}