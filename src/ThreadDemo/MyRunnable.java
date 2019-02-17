package ThreadDemo;

/**
 * MyRunnable
 *
 * @author 10905 2019/2/17
 * @version 1.0
 */
public class MyRunnable implements Runnable {
    @Override
    public void run() {
        for (int i = 0; i < 50; i++) {
            System.out.println("线程名称: " + Thread.currentThread().getName() + " : " + i);

        }
    }

    static class Test {
        public static void main(String[] args) {
            MyRunnable myRunnable = new MyRunnable();
            /**
             * 将目标对象传给线程
             */
            Thread thread=new Thread(myRunnable);
            thread.start();
        }



    }
}

