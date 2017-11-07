# DynamicDialog
多态窗体控件，包括Loading、常规、错误、正确、警告等等。


### 控件演示
![image](https://github.com/xiaoliang0227/DynamicDialog/blob/master/screen_record.gif)

### 下面介绍控件的属性及使用方式

###### gradle引入方法：
~~~
compile "com.github.xiaoliang0227:DynamicDialog:1.0.1"
~~~

###### DynamicDialogType 分为五种类型
- **LOADING** 加载中窗体
- **ERROR** 错误提示窗体
- **SUCCESS** 正确提示窗体
- **NORMAL** 常规文本消息展示窗体
- **WARNING** 警告窗体

###### 控件开放如下属性对窗体进行自定义
- **type** 设置窗体的类型：默认为NORMAL，类型分类如上
- **message** 窗体 消息内容
- **successIcon** 窗体成功提示图片资源
- **errorIcon** 窗体错误提示图片资源
- **warningIcon** 窗体警告提示图片资源
- **scale** 窗体长度按照屏幕宽度的缩放，默认为0.9f
- **gravity** 窗体显示的位置，默认为中间（Gravity.CENTER）

### 使用样例
###### 加载中窗体
~~~
DynamicDialog dialog = new DynamicDialog(this);
        dialog.setMessage("DynamicDailog 测试");
        dialog.setType(DynamicDialogType.LOADING);
        dialog.show();
        delayDismiss(dialog);
~~~

###### 错误提示窗体
~~~
DynamicDialog dialog = new DynamicDialog(this);
        dialog.setMessage("DynamicDailog 测试");
        dialog.setType(DynamicDialogType.ERROR);
        dialog.show();
        delayDismiss(dialog);
~~~

###### 正确提示窗体
~~~
DynamicDialog dialog = new DynamicDialog(this);
        dialog.setMessage("DynamicDailog 测试");
        dialog.setType(DynamicDialogType.SUCCESS);
        dialog.show();
        delayDismiss(dialog);
~~~

###### 常规文本消息展示窗体
~~~
DynamicDialog dialog = new DynamicDialog(this);
        dialog.setMessage("DynamicDailog 测试");
        dialog.show();
        delayDismiss(dialog);
~~~

###### 警告窗体
~~~
DynamicDialog dialog = new DynamicDialog(this);
        dialog.setMessage("DynamicDailog 测试");
        dialog.setType(DynamicDialogType.WARNING);
        dialog.show();
        delayDismiss(dialog);
~~~
