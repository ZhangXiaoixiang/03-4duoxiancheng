package synchronize;

/**
 * Site
 * 多线程抢票---线程安全的类
 *
 * @author 10905 2019/2/17
 * @version 1.0
 */
public class Site implements Runnable {
    /**
     * 定义共享的资源
     */
//    票的剩余数
    private int count = 150;

//    记录买到第几张

    private int num = 0;

//    基础售票是否完毕

    private boolean flag = false;

    @Override
    public void run() {
/**
 * 这里将方法抽取出去,并上锁
 */
        while (!flag) {
            sale();
        }
    }

    /**
     * 对方法进行上锁
     */
    public synchronized void sale() {
        if (count <= 0) {
            flag = true;
            return;
        }
        /**
         * 卖出去加1,剩余数减1
         */
        num++;
        count--;
        /**
         * 模拟延时
         */
        try {
            Thread.sleep(20);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        /**
         * 显示售票状态
         */
        System.out.println(Thread.currentThread().getName() + "  抢到第" + num + ",张票,剩余" + count + ",张票");
    }
    /**
     * 测试
     */
    static class Test{
        public static void main(String[] args) {
            System.out.println("同步方法--------------------");
            Site site=new Site();
            Thread thread1=new Thread(site,"张三");
            Thread thread2=new Thread(site,"李四");
            Thread thread3=new Thread(site,"黄牛");
            thread1.start();
            thread2.start();
            thread3.start();
        }
    }
}
