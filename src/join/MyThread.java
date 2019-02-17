package join;

/**
 * MyThread
 * 线程的强制运行 join
 * @author 10905 2019/2/17
 * @version 1.0
 */
public class MyThread implements Runnable{

    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            try {
//                增加线程执行的交替gailv
                Thread.sleep(100);

            } catch (InterruptedException e) {


            }
            System.out.println("线程: "+Thread.currentThread().getName()+",运行子线程  "+i);

        }


    }
    /**
     * 测试线程的强制运行
     */
    static class Test{
        public static void main(String[] args) throws InterruptedException {
            System.out.println("测试线程的强制运行");
            Thread thread=new Thread(new MyThread());
            thread.start();
            /**
             * 外面试main方法线程执行20的循环
             */
            for (int i = 0; i < 20; i++) {
                if (i==5){
                    try {
                        /**
                         * 阻塞主线程main方法的运行,子线程强制执行
                         */
                        System.out.println("-----主线程执行到4后,判断到5了,所以停下来,子线程强制执行-----");
                        thread.join();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                /**
                 * 主线程休眠,模拟实际情况(交替执行),也可以不管,但是不能设置太长,不然子线程和主线程交替执行后,还没有到5子线程已经执行完毕了,导致看不到强制执行子线程的效果
                 */
                Thread.sleep(100);
                System.out.println("线程: "+Thread.currentThread().getName()+",运行  "+i);

            }
        }
    }
}
