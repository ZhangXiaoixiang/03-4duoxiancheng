package Run;

/**
 * RunTread
 * 接力赛线程类
 *
 * @author 10905 2019/2/17
 * @version 1.0
 */
public class RunTread implements Runnable {
    /**
     * 定义线程类资源
     */
//    共跑1000mi
    private int meters = 1000;

    //    使用同步代码块的方式加锁
    @Override
    public void run() {
        while (true) {
            synchronized (this) {
                if (meters <= 100) {
                    break;
                }
                System.out.println(Thread.currentThread().getName()+"拿到接力棒---------");
                for (int i = 0; i < 100; i+=10) {
                    try {
                        /**
                         * 模拟耗时
                         */
                        Thread.sleep(1000);

                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println(Thread.currentThread().getName()+"跑了"+(i+10)+"米!");



                }
                //                    资源消耗100米
                meters-=100;
                break;
            }
        }

    }
    /**
     * 测试5人接力赛
     */
    static class Test{
        public static void main(String[] args) {
            RunTread runTread=new RunTread();
            for (int i = 0; i < 5; i++) {
               new Thread(runTread,(i+1)+"号选手").start();
            }

        }
    }
}
