## 基础架构

### 简介
   项目采用组件化，除了有common和main组件外，按照功能划分各个业务组件。每个组件可以单独编译，多人开发可以独立负责自己的模块便于协作开发。

### 组件化架构
   ![Image 组件化架构]( https://github.com/JeffKuoCool/images/blob/master/%E7%BB%84%E4%BB%B6%E5%8C%96%E6%9E%B6%E6%9E%84.jpg )

   在项目根目录下的 gradle.properties 文件中添加配置是否独立编译开关：
   ![Image gradle添加开关]( https://github.com/JeffKuoCool/images/blob/master/open.jpg )

   之后在主项目 app 模块的 build.gradle 中添加各个业务组件配置是否根据开关，依赖我们的业务组件：
   ![Image app build.gradle]( https://github.com/JeffKuoCool/images/blob/master/app_gradle.jpg )

   最后，在我们所有业务组件的 build.gradle 中添加是否根据开关将该组件作为独立的 application 来编译。
   ![Image build.gradle]( https://github.com/JeffKuoCool/images/blob/master/moudle.jpg )

   ![Image build.gradle]( https://github.com/JeffKuoCool/images/blob/master/application.jpg )

### 路由


### TODO

- [x] 基础依赖
- [ ] 页面跳转
    + [x] ARouter
    + [x] EventBus
    + [ ] Scheme
- [x] 网络加载
    - [x] retrofit+okhttp3
- [ ] 公共控件
    + [ ] appbar
    + [ ] 弹框
    + [ ] 加载动画
- [ ] 图片框架
- [ ] bug收集
- [ ] 皮肤管理
- [ ] 权限判断
- [ ] 资源导入
    + [x] color
    + [x] drawable
    + [ ] dimens
    + [ ] styles

