package status;

/**
 * MyThread
 *
 * @author 10905 2019/2/17
 * @version 1.0
 */
public class MyThread implements Runnable {
    @Override
    public void run() {

        try {
            System.out.println("线程T在运行...");
            Thread.sleep(500);
            System.out.println("线程在500毫秒后重新运行...");
        } catch (InterruptedException e) {
            e.printStackTrace();
            System.out.println("线程中断XXX");
        }
    }
    /**
     *测试
     */
    static class  Test{
        public static void main(String[] args) {
            MyThread myThread=new MyThread();
            Thread thread=new Thread(myThread);
            System.out.println("线程T为新建!");
            thread.start();
            System.out.println("线程T为就绪!");

        }
    }
}
