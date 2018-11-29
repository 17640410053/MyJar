package com.bilibili.yl.util;

import java.io.UnsupportedEncodingException;
import java.lang.reflect.Field;
import java.math.BigDecimal;
import java.sql.Date;
import java.sql.Timestamp;
import java.util.Calendar;
import java.util.Random;
import java.util.UUID;


/**
 * @author bilibili_教主
 * <p>
 * 实体对象工具类（生成随机对象）
 */
public class EntityUtils<T> {

    private Random random = new Random();
    private String[] mailSuffix = "@gmail.com,@yahoo.com,@msn.com,@hotmail.com,@aol.com,@ask.com,@live.com,@qq.com,@0355.net,@163.com,@163.net,@263.net,@3721.net,@yeah.net,@googlemail.com,@126.com,@sina.com,@sohu.com,@yahoo.com.cn".split(",");
    private String[] phonePrefix = "134,135,136,137,138,139,150,151,152,157,158,159,130,131,132,155,156,133,153".split(",");
    private String[] roles = "管理员,用户,企业,DBA,商家".split(",");
    //ip范围
    private int[][] range = {{607649792, 608174079},//36.56.0.0-36.63.255.255
            {1038614528, 1039007743},//61.232.0.0-61.237.255.255
            {1783627776, 1784676351},//106.80.0.0-106.95.255.255
            {2035023872, 2035154943},//121.76.0.0-121.77.255.255
            {2078801920, 2079064063},//123.232.0.0-123.235.255.255
            {-1950089216, -1948778497},//139.196.0.0-139.215.255.255
            {-1425539072, -1425014785},//171.8.0.0-171.15.255.255
            {-1236271104, -1235419137},//182.80.0.0-182.92.255.255
            {-770113536, -768606209},//210.25.0.0-210.47.255.255
            {-569376768, -564133889}, //222.16.0.0-222.95.255.255
    };

    /**
     * 随机生成实体类（适用于数据库添加随机对象做测试用）
     *
     * @param clazz 你需要随机生成的对象反射
     */
    public T RomEntity(Class<T> clazz) throws IllegalAccessException, InstantiationException {
        T t = clazz.newInstance();
        Field[] fields = clazz.getDeclaredFields();
        for (Field field : fields) {
            //获取具体值
            field.setAccessible(true);
            //其余情况更具类型复制
            String fieldClassName = field.getType().getSimpleName();
            if (fieldClassName.equalsIgnoreCase("String")) {
                isString(field, t);
            } else if (fieldClassName.equalsIgnoreCase("int") || fieldClassName.equalsIgnoreCase("Integer")) {
                isInteger(field, t);
            } else if (fieldClassName.equalsIgnoreCase("long")) {
                field.set(t, (long) random.nextInt(100000));
            } else if (fieldClassName.equalsIgnoreCase("boolean")) {
                field.set(t, random.nextBoolean());
            } else if (fieldClassName.equalsIgnoreCase("double")) {
                field.set(t, (double) Math.round((random.nextDouble() + random.nextInt(10000)) * 100) / 100);
            } else if (fieldClassName.equalsIgnoreCase("BigDecimal")) {
                field.set(t, new BigDecimal(random.nextInt(10000) + random.nextDouble()).setScale(random.nextInt(4), BigDecimal.ROUND_HALF_UP));
            } else if (fieldClassName.equalsIgnoreCase("float")) {
                field.set(t, (float) Math.round((random.nextFloat() + random.nextInt(10000)) * 100) / 100);
            } else if (fieldClassName.equalsIgnoreCase("date")) {
                isDate(field, t);
            } else if (fieldClassName.equalsIgnoreCase("Timestamp")) {
                field.set(t, new Timestamp(System.currentTimeMillis()));
            }
        }
        return t;
    }

    /**
     * 如果是String类型执行以下操作
     */
    private void isString(Field field, T t) throws IllegalAccessException {
        String fieldName = field.getName().toLowerCase();
        if (fieldName.contains("id")) {
            field.set(t, UUID.randomUUID().toString().toUpperCase().replace("-", ""));
        } else if (fieldName.contains("name")) {
            field.set(t, getRandomName(random.nextInt(2) + 2));
        } else if (fieldName.contains("mail")) {
            field.set(t, getStringRandom(random.nextInt(10) + 6) + mailSuffix[random.nextInt(mailSuffix.length)]);
        } else if (fieldName.contains("phone")) {
            field.set(t, getTel());
        } else if (fieldName.contains("image") || fieldName.contains("img")) {
            field.set(t, "default.png");
        } else if (fieldName.contains("pass") || fieldName.contains("pwd")) {
            field.set(t, MD5Utils.MD5Encode(getStringRandom(random.nextInt(16)), "utf-8"));
        } else if (fieldName.contains("address")) {
            field.set(t, "江苏·苏州");
        } else if (fieldName.contains("role")) {
            field.set(t, roles[random.nextInt(roles.length)]);
        } else if (fieldName.contains("ip")) {
            field.set(t, getRandomIp());
        } else {
            field.set(t, "hello world");
        }
    }

    /**
     * 如果是int以及包装类类型执行以下操作
     */
    private void isInteger(Field field, T t) throws IllegalAccessException {
        String fieldName = field.getName().toLowerCase();
        if (fieldName.contains("id")) {
            field.set(t, random.nextInt(80000) + 10001);
        } else if (fieldName.contains("age")) {
            field.set(t, random.nextInt(50) + 18);
        } else if (fieldName.contains("status") || fieldName.contains("state")) {
            field.set(t, random.nextInt(3));
        } else {
            field.set(t, random.nextInt(10000));
        }
    }

    /**
     * 如果是日期执行以下操作
     */
    private void isDate(Field field, T t) throws IllegalAccessException {
        String fieldName = field.getName().toLowerCase();
        if (fieldName.contains("birth")) {
            Calendar calendar = Calendar.getInstance();
            calendar.add(Calendar.YEAR, -random.nextInt(30) - 18);
            calendar.add(Calendar.DATE, -random.nextInt(365));
            field.set(t, new Date(calendar.getTime().getTime()));
        } else {
            field.set(t, new Date(System.currentTimeMillis()));
        }
    }

    /**
     * 自动生成中文名
     */
    public String getRandomName(int length) {
        StringBuilder ret = new StringBuilder();
        for (int i = 0; i < length; i++) {
            String str = null;
            int higPos, lowPos; // 定义高低位
            random = new Random();
            higPos = (176 + Math.abs(random.nextInt(39))); // 获取高位值
            lowPos = (161 + Math.abs(random.nextInt(93))); // 获取低位值
            byte[] b = new byte[2];
            b[0] = (new Integer(higPos).byteValue());
            b[1] = (new Integer(lowPos).byteValue());
            try {
                str = new String(b, "GBK"); // 转成中文
            } catch (UnsupportedEncodingException ex) {
                ex.printStackTrace();
            }
            ret.append(str);
        }
        return ret.toString();
    }

    /**
     * 生成随机字符串，字母数字组成
     */
    public String getStringRandom(int length) {
        StringBuilder val = new StringBuilder();
        random = new Random();

        //参数length，表示生成几位随机数
        for (int i = 0; i < length; i++) {
            String charOrNum = random.nextInt(2) % 2 == 0 ? "char" : "num";
            //输出字母还是数字
            if ("char".equalsIgnoreCase(charOrNum)) {
                //输出是大写字母还是小写字母
                int temp = random.nextInt(2) % 2 == 0 ? 65 : 97;
                val.append((char) (random.nextInt(26) + temp));
            } else {
                val.append(String.valueOf(random.nextInt(10)));
            }
        }
        return val.toString();
    }

    /**
     * 获取随机数字
     */
    public int getNum(int start, int end) {
        return (int) (Math.random() * (end - start + 1) + start);
    }

    /**
     * 随机生成手机号
     */
    private String getTel() {
        int index = getNum(0, phonePrefix.length - 1);
        String first = phonePrefix[index];
        String second = String.valueOf(getNum(1, 888) + 10000).substring(1);
        String third = String.valueOf(getNum(1, 9100) + 10000).substring(1);
        return first + second + third;
    }

    /**
     * 随机获取ip地址
     * */
    public String getRandomIp() {
        int index = random.nextInt(10);
        return num2ip(range[index][0] + random.nextInt(range[index][1] - range[index][0]));
    }

    public String num2ip(int ip) {
        int[] b = new int[4];
        b[0] = (ip >> 24) & 0xff;
        b[1] = (ip >> 16) & 0xff;
        b[2] = (ip >> 8) & 0xff;
        b[3] = ip & 0xff;
        return Integer.toString(b[0]) + "." + Integer.toString(b[1]) + "." + Integer.toString(b[2]) + "." + Integer.toString(b[3]);
    }
}
