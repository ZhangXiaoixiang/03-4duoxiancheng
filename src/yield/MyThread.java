package yield;

/**
 * MyThread
 * 线程的礼让---不一定让,但是会有这种可能
 * @author 10905 2019/2/17
 * @version 1.0
 */
public class MyThread implements  Runnable{
    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            System.out.println("线程: "+Thread.currentThread().getName()+",运行  "+i);
            if (i==3){
                System.out.println("-------------线程礼让--------------");
                Thread.yield();
            }

        }
    }
    /**
     * 测试礼让
     */

    static  class  Test{
        public static void main(String[] args) {
            System.out.println("大多数是线程遇到3就相互礼让(不一定,只是一种可能)");
            Thread thread=new Thread(new MyThread(),"线程A");
            Thread thread2=new Thread(new MyThread(),"线程B");
           thread.start();
           thread2.start();
        }
    }
}
