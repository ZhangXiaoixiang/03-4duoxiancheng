package ThreadDemo;

/**
 * demo01
 * 最简单的修改线程名称的一个例子
 * @author 10905 2019/2/17
 * @version 1.0
 */
public class demo01 {
    public static void main(String[] args) {
        Thread thread = Thread.currentThread();
        System.out.println("当前线程是: "+thread.getName()+",线程的优先级:"+thread.getPriority());
        thread.setName("zxxThread");
        thread.setPriority(2);
        System.out.println("修改后的线程名称: "+thread.getName()+",修改优先级后是:"+thread.getPriority());
    }
}
