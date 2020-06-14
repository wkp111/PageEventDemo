# PageEvent [ ![Download](https://api.bintray.com/packages/wkp/maven/PageEvent/images/download.svg) ](https://bintray.com/wkp/maven/PageEvent/_latestVersion)
简易事件总线，解决Activity与Activity、Activity与Fragment之间的通信问题。
## Gradle集成
```groovy
dependencies{
      implementation 'com.wkp:PageEvent:1.0.2'
      // 依赖androidx库
      implementation 'androidx.appcompat:appcompat:1.1.0'
}

//如不愿意等待，请加上我的maven仓库地址
maven { url "https://dl.bintray.com/wkp/maven" }
```
Note：可能存在Jcenter还在审核阶段，这时会集成失败！注意SDK版本targetSdkVersion >= 28.
## 使用详解
### 原理讲解
1.<a href="https://github.com/wkp111/PageEventDemo/blob/master/pageevent/src/main/java/com/wkp/pageevent/inter/PageEvent.java">PageEvent.java</a></br>
事件发射器，实现该接口，具备事件发射能力。</br>
2.<a href="https://github.com/wkp111/PageEventDemo/blob/master/pageevent/src/main/java/com/wkp/pageevent/inter/PageEventListener.java">PageEventListener.java</a></br>
普通事件接收监听器，实现该接口，注册对应事件发射器页面的监听，即可接收对应发射器页面发射的普通事件信息。</br>
3.<a href="https://github.com/wkp111/PageEventDemo/blob/master/pageevent/src/main/java/com/wkp/pageevent/inter/PageStickEventListener.java">PageStickEventListener.java</a></br>
粘性事件接收监听器，实现该接口，注册对应事件发射器页面的监听，即可接收对应发射器页面发射的粘性事件信息；粘性事件可以被拦截，拦截的粘性事件会丢弃，不再继续分发。</br>
4.<a href="https://github.com/wkp111/PageEventDemo/blob/master/pageevent/src/main/java/com/wkp/pageevent/helper/EventHelper.java">EventHelper.java</a></br>
事件总线处理中心，主要管理事件监听器的注册及注销，事件发射器的事件发射及粘性事件的缓存。</br>
5.<a href="https://github.com/wkp111/PageEventDemo/tree/master/pageevent/src/main/java/com/wkp/pageevent/base">base Activity & Fragment</a></br>
当前主要扩展了Activity及Fragment的基类，方便页面之间事件通信的实现。</br>
#### Note：事件通信支持其他扩展，不限于Activity及Fragment，可自行探索！
### 代码示例
简易示例可参考<a href="https://github.com/wkp111/PageEventDemo/tree/master/app/src/main/java/com/wkp/pageeventdemo">Demo</a>
#### Note：还有其他复杂使用场景请自行探索！ 
## 寄语
欢迎大家使用，感觉好用请给个Star鼓励一下，谢谢！<br/>
大家如果有更好的意见或建议以及好的灵感，请邮箱作者，谢谢！<br/>
QQ邮箱：1535514884@qq.com<br/>
163邮箱：15889686524@163.com<br/>
Gmail邮箱：wkp15889686524@gmail.com<br/>

## 版本更新
* v1.0.2<br/>
切换适配androidx
* v1.0.1<br/>
新创建简易事件总线库
## License

   Copyright 2020 wkp

   Licensed under the Apache License, Version 2.0 (the "License");
   you may not use this file except in compliance with the License.
   You may obtain a copy of the License at

     http://www.apache.org/licenses/LICENSE-2.0

   Unless required by applicable law or agreed to in writing, software
   distributed under the License is distributed on an "AS IS" BASIS,
   WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
   See the License for the specific language governing permissions and
   limitations under the License.
