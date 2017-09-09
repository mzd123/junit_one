import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.type.TypeFactory;
import com.taobao.api.ApiException;
import com.taobao.api.DefaultTaobaoClient;
import com.taobao.api.TaobaoClient;
import com.taobao.api.request.AlibabaAliqinFcSmsNumSendRequest;
import com.taobao.api.response.AlibabaAliqinFcSmsNumSendResponse;
import org.junit.Test;

import java.io.IOException;
import java.io.StringWriter;
import java.io.Writer;
import java.util.*;
import java.util.function.BiConsumer;

/**
 * Created by Administrator on 2017/5/31.
 */
public class TestDriver {
    @Test
    public void doT() {
        Random r = new Random();
        int i = r.nextInt(10);
        //0到9之间的随机一个数，取不到10
        System.out.println(i);
        //必须要声明才能被使用，输出也是一种使用
        String str = null;
        System.out.println(str);
    }

    @Test
    public void D() {
        Calendar calendar = null;
        // 声明一个Calendar对象  
        calendar = new GregorianCalendar();
        // 通过子类为其实例化  
        System.out.println("年：" + calendar.
                get(Calendar.YEAR)); // 年  
        System.out.println("月：" + (calendar.
                get(Calendar.MONTH) + 1));// 月  
        System.out.println("日：" + calendar.
                get(Calendar.DAY_OF_MONTH));// 日  
        System.out.println("时：" + calendar.
                get(Calendar.HOUR_OF_DAY));// 时  
        System.out.println("分：" + calendar.
                get(Calendar.MINUTE));// 分  
        System.out.println("秒：" + calendar.
                get(Calendar.SECOND));// 秒  
        System.out.println("毫秒：" + calendar.
                get(Calendar.MILLISECOND));// 毫秒  
    }

    //========================================================发送短信=================================================================
    @Test
    public void dotest() {
        TaobaoClient client = new DefaultTaobaoClient("http://gw.api.taobao.com/router/rest", "23889400", "a1efec21347254f4bca2137a429ea0a1", "json");
        AlibabaAliqinFcSmsNumSendRequest req = new AlibabaAliqinFcSmsNumSendRequest();
        req.setSmsType("normal");
        req.setSmsParamString("{'code':'" + 1314 + "','product':'Tuesdayma军团','admin':'马周2'}");
        req.setRecNum("18222683671");
        req.setSmsFreeSignName("马周2");
        req.setSmsTemplateCode("SMS_69875242");
        try {
            AlibabaAliqinFcSmsNumSendResponse rsp = client.execute(req);
        } catch (ApiException e) {
            e.printStackTrace();
        }
    }

    //    @Test
//    public void doT2() {
//        String to = "tuesdayma@163.com";
//        String from = "707307313@qq.com";
//        String host = "smtp.163.com";
//        Properties properties = System.getProperties();
//        properties.setProperty("mail.smtp.host", host);
//        Session session = Session.getDefaultInstance(properties);
//        try {
//            MimeMessage message = new MimeMessage(session);
//            message.setFrom(new InternetAddress(from));
//            message.addRecipient(Message.RecipientType.TO, new InternetAddress(to));
//            message.setSubject("This is the Subject Line!");
//            message.setText("测试一下！");
//            Transport.send(message);
//            System.out.println("Sent message successfully....");
//        } catch (javax.mail.MessagingException e) {
//            e.printStackTrace();
//        }
//    }
//
//    @Test
//    public void sot() {
//        Properties props = new Properties();
//        // 开启debug调试  
//        props.setProperty("mail.debug", "true");
//        // 发送服务器需要身份验证  
//        props.setProperty("mail.smtp.auth", "true");
//        // 设置邮件服务器主机名  
//        props.setProperty("mail.host", "smtp.163.com");
//        // 发送邮件协议名称  
//        props.setProperty("mail.transport.protocol", "smtp");
//
//        // 设置环境信息  
//        Session session = Session.getInstance(props);
//
//        try {
//            // 创建邮件对象  
//            Message msg = new MimeMessage(session);
//            msg.setSubject("JavaMail测试");
//            // 设置邮件内容  
//            msg.setText("这是一封由JavaMail发送的邮件！");
//            // 设置发件人  
//            msg.setFrom(new InternetAddress("tuesdayma@163.com"));
//
//            Transport transport = session.getTransport();
//            // 连接邮件服务器  
//            transport.connect("tuesdayma@163.com", "mzd120934988");
//            // 发送邮件  
//            transport.sendMessage(msg, new Address[]{new InternetAddress("java_mail_002@163.com")});
//            // 关闭连接  
//            transport.close();
//        } catch (MessagingException e) {
//            e.printStackTrace();
//        }
//    }
//========================================================================反序列化===========================================================

    /**
     * json字符串反序列化成为Java对象
     *
     * @param json
     * @param clazz
     * @param <T>
     * @return
     */
    public static <T> T deserialize(String json, Class<T> clazz) {
        ObjectMapper objectMapper = new ObjectMapper();
        Object object = null;
        try {
            object = objectMapper.readValue(json, TypeFactory.rawClass(clazz));
        } catch (JsonParseException e) {
        } catch (JsonMappingException e) {
        } catch (IOException e) {
        }
        return (T) object;
    }

    @Test
    public void doTa() {
        String str = "{\"showapi_res_code\":0,\"showapi_res_error\":\"\",\"showapi_res_body\":{\"mailNo\":\"435997057797\",\"update\":1493783304201,\"updateStr\":\"2017-05-03 11:48:24\",\"ret_code\":0,\"flag\":true,\"dataSize\":9,\"status\":4,\"tel\":\"021-39777777\",\"expSpellName\":\"zhongtong\",\"data\":[{\"time\":\"2017-04-28 13:59:51\",\"context\":\"[椒江康平路分部] [台州市] [椒江康平路分部]的派件已签收 感谢使用中通快递,期待再次为您服务!\"},{\"time\":\"2017-04-28 13:54:26\",\"context\":\"[椒江康平路分部] [台州市] 快件已到达[椒江康平路分部],业务员汪凯正在第1次派件 电话:15857615435 请保持电话畅通、耐心等待\"},{\"time\":\"2017-04-28 11:53:12\",\"context\":\"[椒江] [台州市] 快件离开 [椒江]已发往[椒江康平路分部]\"},{\"time\":\"2017-04-28 11:51:10\",\"context\":\"[椒江] [台州市] 快件到达 [椒江]\"},{\"time\":\"2017-04-28 07:40:01\",\"context\":\"[台州中转部] [台州市] 快件离开 [台州中转部]已发往[椒江]\"},{\"time\":\"2017-04-27 23:17:10\",\"context\":\"[杭州中转部] [嘉兴市] 快件离开 [杭州中转部]已发往[台州中转部]\"},{\"time\":\"2017-04-27 23:15:43\",\"context\":\"[杭州中转部] [嘉兴市] 快件到达 [杭州中转部]\"},{\"time\":\"2017-04-27 20:28:08\",\"context\":\"[杭州城南区] [杭州市] 快件离开 [杭州城南区]已发往[台州中转部]\"},{\"time\":\"2017-04-27 20:23:48\",\"context\":\"[杭州城南区] [杭州市] [杭州城南区]的方海文已收件 电话:15381009209\"}],\"expTextName\":\"中通快递\"}}";
        User user = deserialize(str, User.class);
        System.out.println(user.toString());
    }

    /**
     * 将对象转换成为json字符串
     *
     * @param object
     * @return
     */
    public static String serialize(Object object) {
        ObjectMapper objectMapper = new ObjectMapper();
        Writer write = new StringWriter();
        try {
            objectMapper.writeValue(write, object);
        } catch (JsonGenerationException e) {
        } catch (JsonMappingException e) {
        } catch (IOException e) {
        }
        return write.toString();
    }

    @Test
    public void doTb() {
        List list = new ArrayList();
        Data data = new Data();
        data.setContext("aaa");
        data.setTime("11111");
        list.add(data);
        Data data2 = new Data();
        data2.setContext("bbb");
        data2.setTime("22222");
        list.add(data2);
        Body body = new Body();
        body.setData(list);
        body.setDataSize("1");
        body.setExpTextName("打发的说法");
        body.setUpdate("aadsfas");
        User user = new User();
        user.setShowapi_res_body(body);
        user.setShowapi_res_code(123);
        user.setShowapi_res_error("1qasdasd");
        String str = serialize(user);
        System.out.println(str);
    }


    @Test
    public void doTv() {
        String[] str = {"1", "2", "3", "4", "5", "6", "7", "8", "9"};
        List<String> lists = Arrays.asList(str);
        lists.forEach((list) -> System.out.print(list + ","));
        BiConsumer<Integer, String> b = (Integer x, String y) -> System.out.println(x + " : " + y);
        new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("Hello from thread");
            }
        }).start();
        new Thread(
                () -> System.out.println("Hello from thread")
        ).start();
    }

    //==========================================String不能将字符串倒过来，但是StringBuffer可以==============================
    @Test
    public void operate() {
        int i = 1234322131;
        System.out.println(System.currentTimeMillis());
        String str = String.valueOf(i);
        StringBuffer stringBuffer = new StringBuffer(str);
        stringBuffer.reverse();
        System.out.println(stringBuffer);
//        int s = str.length() / 2;
//        boolean isF = true;
//        for (int c = 0; c < s; c++) {
//            if (str.charAt(c) != str.charAt(str.length() - 1 - c)) {
//                isF = false;
//                break;
//            }
//        }
//        System.out.println(isF);
//        System.out.println(System.currentTimeMillis());
    }

    //计算一个字符串可以构建的最长的回文串
    @Test
    public void doTaaa() {
        String str = "abccccdd";
        //最长长度
        long k = 0;
        int i = str.length();
        List list = new ArrayList();
        Map map = new HashMap();
        for (int j = 0; j < i; j++) {
            if (!list.contains(str.charAt(j))) {
                list.add(str.charAt(j));
                //计算该字符出现了多少次
                Integer b = 1;
                for (int a = j + 1; a < i; a++) {
                    if (str.charAt(j) == str.charAt(a)) {
                        b = b + 1;
                    }
                }
                map.put(str.charAt(j), b);
            }
        }
        //还没计算只有一个元素的字符
        boolean isF = true;
        Set set = map.keySet();
        for (Object object : set) {
            int sum = Integer.valueOf(map.get(object).toString());
            if (sum % 2 != 0) {
                //只允许出现一个奇数
                if (isF) {
                    k++;
                    isF = false;
                }
                //如果是只出现一次，那就不能算
                if (sum != 1) {
                    k = k + (sum / 2) * 2;
                }
            } else if (sum % 2 == 0) {
                k = k + sum;
            }
        }
        System.out.println(k);
    }

    //计算一个字符串可以构建的最长的回文串
    @Test
    public void doTaaa2() {
        String str = "abccccdd";
        int i = str.length();
        char[] chars = new char[128];
        for (int a = 0; a < i; a++) {
            chars[str.charAt(a)]++;
        }
        boolean isF = true;
        int k = 0;
        for (int b = 0; b < 127; b++) {
            if (chars[b] > 0) {
                if (chars[b] % 2 != 0) {
                    //只允许出现一个奇数
                    if (isF) {
                        k++;
                        isF = false;
                    }
                    //如果是只出现一次，那就不能算
                    if (chars[b] != 1) {
                        k = k + (chars[b] / 2) * 2;
                    }
                } else if (chars[b] % 2 == 0) {
                    k = k + chars[b];
                }
            }
        }
    }

    //各位数相加，直到为一位数
    @Test
    public void doTq() {
        int a = 38;
        int b = 0;
        System.out.println(dogh(a, b));
    }

    private int dogh(int a, int b) {
        if (a / 10 != 0) {
            b = b + a / 10;
            a = a % 10;
            return dogh(a, b);
        } else {
            b = b + (a % 10);
            if (b / 10 == 0) {
                return b;
            }
            a = b;
            b = 0;
            return dogh(a, b);
        }
    }

    //两数组的交
    @Test
    public void dogg() {
        int nums1[] = {1, 2, 2, 1};
        int nums2[] = {2, 2};
        intersection(nums1, nums2);
    }

    public int[] intersection(int[] nums1, int[] nums2) {
        List list = new ArrayList();
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        int d = nums1.length > nums2.length ? nums1.length : nums2.length;
        int a = 0, c = 0;
        while (a < nums1.length && c < nums2.length) {
            if (nums1[a] > nums2[c]) {
                c++;
            } else if (nums1[a] < nums2[c]) {
                a++;
            } else {
                list.add(nums1[a]);
                a++;
                c++;
            }
        }
        int[] i = new int[list.size()];
        for (int v = 0; v < list.size(); v++) {
            i[v] = Integer.valueOf(list.get(v).toString());
            System.out.println(i[v]);
        }
        return i;
    }

    //判断是否为丑数
    @Test
    public void doTTT() {
        boolean isF = true;
        int i = 8;
        List list = new ArrayList();
        list = (doget(i, list));
        for (Object b : list) {
            Integer ii = (Integer) b;
            int a = ii;
            if ((a != 2) && (a != 3) && (a != 5)) {
                isF = false;
            }
            System.out.println(a);
        }
        System.out.println(isF);
    }

    public List doget(int i, List list) {
        if (i >= 2) {
            for (int j = 2; j <= Math.sqrt(i); j++) {
                if (i % j == 0) {
                    list.add(j);
                    i = i / j;
                    list = doget(i, list);
                    return list;
                }
            }
            list.add(i);
        }
        return list;
    }

    //==============================================是否为快乐数========================================================
    @Test
    public void fot() {
        int i = 2;
        System.out.println(isHappy(i));
    }

    private boolean isHappy(int i) {
        if (i > 0) {
            if (i == 1) {
                return true;
            }
            String string = String.valueOf(i);
            int b = 0;
            for (int a = 0; a < string.length(); a++) {
                int c = string.charAt(a) - 48;
                b = b + (int) Math.pow(c, 2);
            }
            return isHappy(b);
        }
        return false;
    }

    //======================================二分法================================================
    @Test
    public void f() {
        int[] i = {1, 2, 2, 4, 5, 5};
        System.out.println(dofffff(i, 6));
    }

    public int dofffff(int[] i, int c) {
        int a = (i.length - 1) / 2;
        while (a > 0 && a < i.length) {
            if (c == i[a]) {
                return a;
            }
            if (c > i[a]) {
                a = a + i.length / 2;
            } else {
                a = a / 2;
            }
        }
        return -1;
    }

    //=======================================给一个字符串集合，找出最长的字符串集合======================================
    public ArrayList<String> longestWords(String[] dictionary) {
        int i = 0;
        ArrayList<String> list = new ArrayList<String>();
        for (int a = 0; a < dictionary.length; a++) {
            if (dictionary[a].length() > i) {
                //将list集合清空
                list.clear();
                list.add(dictionary[a]);
                i = dictionary[a].length();
            } else if (dictionary[a].length() == i) {
                list.add(dictionary[a]);
            }
        }
        return list;
    }

    //============================================输出多少个岛屿==================================================
    @Test
    public void dooo() {
        int[][] i = {{1, 1, 1, 1, 1, 1}, {1, 0, 0, 0, 0, 1}, {1, 0, 1, 1, 0, 1}, {1, 0, 0, 0, 0, 1}, {1, 1, 1, 1, 1, 1}};
        int c = 0;
        boolean isF = true;
        for (int a = 0; a < i.length; a++) {
            for (int b = 0; b < i[0].length; b++) {
                if ((a == 0 || a == i.length) && (i[a][b] != 1)) {
                    isF = false;
                }
                if ((b == 0 || b == i[0].length) && i[a][b] != 1) {
                    isF = false;
                }
                if (i[a][b] == 1) {
                    c++;
                    if (a > 0 && (i[a - 1][b] == 1)) {
                        c--;
                    }
                    if (b > 0 && (i[a][b - 1] == 1)) {
                        c--;
                    }
                }
            }
        }
        if (isF) {
            c++;
        }
        System.out.println(c);
    }
}

