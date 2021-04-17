# ILiveData
对LiveData进行封装。

## 引入依赖：
How to
To get a Git project into your build:

### 步骤1. Add the JitPack repository to your build file

	allprojects {
		repositories {
			...
			maven { url 'https://jitpack.io' }
		}
	}
### 步骤2. 加入ILiveData

	dependencies {
		implementation 'com.github.ming123aaa:ILiveData:1.6'
	}
### 步骤3.加入lifecycle的依赖：
             implementation 'androidx.lifecycle:lifecycle-extensions:2.2.0'
### 步骤4.代码混淆：
               -keep class com.Ohuang.ilivedata.*{*;}
               -keep class androidx.lifecycle.* { *; }
               -keep class androidx.arch.core.internal.*{*;}'
## 简单使用：
 ### MyLiveData的使用
 #### 发送数据：
 ```java
   // with(一个String类型的key,需要传递对象的类型)   setValue(需要传的对象)
  
   MyLiveData.getInstance().with("aa",String.class).setValue(string);
  
 // 如果在子线程请使用postValue
 
   MyLiveData.getInstance().with("aa",String.class).postValue(string);
  ```
   
 #### 接收数据:
  ```java
   //with(,)这两个参数与上面一致.  observe(类型为LifecycleOwner在Activity或Fragment里面直接this就行,观察者)
    MyLiveData.getInstance().with("aa",Person.class).observe(this, new Observer<Person>() {
            @Override
            public void onChanged(Person person) {
            //...执行接收数据后的操作

            }
        });
  ```
 ### LiveDataBus的使用与MyLiveData的使用相同   两者的区别,LiveDataBus没有粘性事件,MyLiveData自带粘性事件。

 ```java
 LiveDataBus.get().with("1",String.class).setValue("123");
 ```

 ###  HandlerLiveData的使用:
  HandlerLiveData和Handler使用差别不大.
 #### 发送数据：
 ```java
  //发送空消息 需要传入一个key和int类型的数据(Message.what)

  HandlerLiveData.getInstance().sendEmptyMessage();
 
  //发送Messge消息 需要传入一个key和Message
  HandlerLiveData.getInstance().sendMsg();
  ```
  #### 接收数据：
   参数一:String:key ,参数二：LifecycleOwner,参数三：HandlerLiveData.HandlerLiveDataListener()
   ```Java
   HandlerLiveData.getInstance().addListener("aa", this, new HandlerLiveData.HandlerLiveDataListener() {
            @Override
            public void HandlerMsg(Message message) {
               //...执行接收数据后的操作
            }
        });
```
  
  
