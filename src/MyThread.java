/**
 * Created by Administrator on 2017/6/10.
 */
public class MyThread extends Thread {
    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            System.out.println(Thread.currentThread().getName() + "----" + i);
        }
    }
}
