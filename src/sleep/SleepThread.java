package sleep;

/**
 * SleepThread
 * 线程的休眠
 * @author 10905 2019/2/17
 * @version 1.0
 */
public class SleepThread {
    /**
     * 休眠1秒线程类
     */
    static class Wait{
        public static  void bySec(int s){
            for (int i = 0; i < s; i++) {
                try {
                    System.out.println(i+1+"秒");
//                    休眠1秒
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

            }
        }
    }

    /**
     * 测试类
     * @param args
     */
    public static void main(String[] args) {
        System.out.println("等待...");
        Wait.bySec(5);
        System.out.println("线程开始");

    }
}
