package ThreadDemo;

/**
 * MyThread
 *
 * @author 10905 2019/2/17
 * @version 1.0
 */
public class MyThread extends Thread {
    @Override
    public void run() {
        for (int i = 0; i < 50; i++) {
            System.out.println("线程名称: "+Thread.currentThread().getName()+" : "+i);

        }
    }
}
/**
 * 测试线程
 */
 class Test{
    public static void main(String[] args) {
        System.out.println("线程交替执行--------");
        MyThread myThread=new MyThread();
        MyThread myThread2=new MyThread();
        /**
         * 启动线程的方式
         */
        myThread.start();
        myThread2.start();
        /**
         * run()方法执行的情况属于单线程,不是交替执行
         */
        System.out.println("run()方法执行的情况属于单线程,不是交替执行,从线程名称也可以看出来");
//        myThread.run();
//        myThread2.run();
    }
}
