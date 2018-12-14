* java中经常使用到的一些工具类
* 包括MD5加密，Base64图片上传，发送邮件，六大排序，二维码生成，Hibernate通用Dao等
* 还在继续扩充中...

>2018-12-14更新1.0.2版本兼容以前版本
>-------------------
>* 1.提供验证码生成类，支持字母和数字，并且可以自定义形式;
>>```java
>>//验证码生成--举个栗子
>>@Controller
>>public class TestVerifyCode{
>>    @RequestMapping("verify")
>>    public void getVerify(){
>>        VerifyUtils verify = new VerifyUtils();
>>        verify.setSize(150,35);  //设置图片的大小，默认150，30
>>        verify.setCodes("123456789");  //设置生成的随机字段，默认所有数字和大小写字母
>>        verify.getImage();  //调用这个方法获取验证码
>>        String text = verify.getText();  //获取验证码上的文本信息
>>        try {
>>            vc.output(bi, response.getOutputStream());  //向浏览器输出图片
>>        } catch (IOException e) {
>>            e.printStackTrace();
>>        }
>>    }
>>}
>>```
>* 2.优化文件上传方法被设置为私有的bug，目前可以正常使用;
>* 3.新增异常信息枚举类型ResultEnum，更加方便使用，易读;
>>```java
>>//异常信息枚举--举个栗子
>>public class TestEnum{
>>    public static void main(String[] args){
>>      System.out.println(ResultEnum.SUCCESS);  //获取枚举对象
>>      System.out.println(ResultEnum.SUCCESS.getCode());  //获取枚举错误码
>>      System.out.println(ResultEnum.SUCCESS.getMsg);  //获取枚举错误信息
>>    }
>>}
>>```
>* 4.优化公共返回集ResultCode的方法，提供setCodeAndMsg方法与异常信息枚举联合，更加便捷;
>>```java
>>//ResultCode与ResultEnum结合使用--举个栗子
>>public class TestResultByEnum{
>>    public static void main(String[] args){
>>      ResultEntity<String> result = new ResultEntity<>();
>>      result.setCodeAndMsg(ResultEnum.BUSINESS_ERROR);  //公共返回集结合枚举类型一起使用
>>      System.out.println(result);
>>    }
>>}
>>```
