import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created by Administrator on 2017/6/10.
 */
public class ThreadTest {
    public static void main(String[] args) throws Exception {
        //线程池对象(2表示可以放2个线程）----但是不能超过int的上限
        ExecutorService executorService = Executors.newFixedThreadPool(2);
        MyRunnable myRunnable = new MyRunnable();
        Thread thread = new Thread(myRunnable);
        System.out.println("新建线程对象执行start");
        thread.start();
        System.out.println("从线程池中获取线程对象执行start");
//submit方法执行后，程序的结束是依靠线程池控制线程关闭，将用完的线程有回归到了线程池中
        executorService.submit(myRunnable);
//关闭线程池
        executorService.shutdown();
    }
}
