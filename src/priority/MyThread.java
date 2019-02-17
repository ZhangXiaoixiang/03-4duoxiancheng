package priority;

/**
 * MyThread
 * 线程的优先级--调度的测试
 * @author 10905 2019/2/17
 * @version 1.0
 */
public class MyThread implements Runnable {
    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {
            System.out.println("线程: "+Thread.currentThread().getName()+"正在运行: +"+i);
        }
    }
    /**
     * 测试
     */
    static  class  Test{
        public static void main(String[] args) {
            //        使用构造方法指定名称
            Thread t1=new Thread(new MyThread(),"线程A");
            Thread t2=new Thread(new MyThread(),"线程B");
//        设置优先级,数值大就优先
            t1.setPriority(10);
            t2.setPriority(1);
            System.out.println("线程优先级对比---结果为线程A优先输出");
            t1.start();
            t2.start();
        }

    }
}
