import java.util.concurrent.Callable;

/**
 * Created by Administrator on 2017/6/10.
 */
public class MyCallable implements Callable {
    @Override
    public Object call() throws Exception {
        int a = 0;
        for (int i = 0; i < 3; i++) {
            System.out.println("aaa" + i);
        }
        return a;
    }
}
