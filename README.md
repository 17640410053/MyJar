* java中经常使用到的一些工具类
* 包括MD5加密，Base64图片上传，发送邮件，六大排序，二维码生成，Hibernate通用Dao等
* 还在继续扩充中...

>2018-12-14更新1.0.2
>-------------------
>* 1.提供验证码生成类，支持汉字，字母，数字，自定义形式;
>* 2.优化文件上传方法被设置为私有的bug，目前可以正常使用;
>* 3.讲异常信息设置为枚举类型ResultEnum，更加方便使用，易读;
>```java
>public class TestEnum{
>    public static void main(String[] args){
>      System.out.println(ResultEnum.SUCCESS); //获取枚举对象
>      System.out.println(ResultEnum.SUCCESS.getCode()); //获取枚举错误码
>      System.out.println(ResultEnum.SUCCESS.getMsg); //获取枚举错误信息
>    }
>}
>```
>* 4.优化公共返回集ResultCode的方法，提供setCodeAndMsg方法与异常信息枚举联合，更加便捷;
>```java
>public class TestEnum{
>    public static void main(String[] args){
>      ResultEntity<String> result = new ResultEntity<>();
>      result.setCodeAndMsg(ResultEnum.BUSINESS_ERROR); //公共返回集结合枚举类型一起使用
>      System.out.println(result);
>    }
>}
>```
