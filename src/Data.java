/**
 * Created by Administrator on 2017/6/2.
 */
public class Data {
    private String time;
    private String context;

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getContext() {
        return context;
    }

    public void setContext(String context) {
        this.context = context;
    }

    @Override
    public String toString() {
        return "Data{" +
                "time='" + time + '\'' +
                ", context='" + context + '\'' +
                '}';
    }
}
