package climb;

/**
 * ClimbTread
 * 爬山线程类
 *
 * @author 10905 2019/2/17
 * @version 1.0
 */
public class ClimbTread extends Thread {
    /**
     * 先定义线程资源
     */
//    爬山时间
    private int time;
    //    爬多少个100米
    private int num = 0;

    public ClimbTread(String name,int time, int num) {
        super(name);
        this.time = time;
        this.num = num / 100;
    }


    @Override
    public void run() {
        while (num > 0) {
            try {
                Thread.sleep(time);

            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName()+"爬完100米");
            num--;
        }
        System.out.println(Thread.currentThread().getName()+"-----------------------------------------到达终点!");
    }
    /**
     * 模拟多人爬山1000米---高并发基础
     */
    static  class Test{
        public static void main(String[] args) {
            ClimbTread climbTread=new ClimbTread("年轻人---",500,1000);
            ClimbTread climbTread2=new ClimbTread("老年人***",1500,1000);
            climbTread.start();
            climbTread2.start();
        }
    }
}
