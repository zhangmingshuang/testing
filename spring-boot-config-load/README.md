# SpringBoot配置加载测试
> 测试SpringBoot配置文件的加载规则

## [官方说明](https://docs.spring.io/spring-boot/docs/2.2.3.BUILD-SNAPSHOT/reference/html/spring-boot-features.html#boot-features-external-config-application-property-files)
#### 2.3. Application Property Files
SpringApplication loads properties from application.properties files in the following locations and adds them to the Spring Environment:
1. A /config subdirectory of the current directory  
2. The current directory  
3. A classpath /config package  
4. The classpath root  

The list is ordered by precedence (properties defined in locations higher in the list override those defined in lower locations).

在官方的说明文档给出的顺序中，是按优先级从高到低排序，在列表较高位置定义的属性会覆盖在较低位置定义的属性。

也就是说，属性的优先级与加载顺序的优先级相反。

所以，`属性优先级`从高到低次为：
1. file:./config/ (当前项目路径config目录下);
2. file:./ (当前项目路径下);
3. classpath:/config/ (类路径config目录下);
4. classpath:/ (类路径config下).

而`加载顺序`的优先级为：
1. classpath:/
2. classpath:/config/
3. file:./
4. file:./config/
> 祥见org.springframework.boot.context.config.ConfigFileApplicationListener#DEFAULT_SEARCH_LOCATIONS

从而实现了优先加载的配置文件属性会被后加载的配置文件属性覆盖。

`这里需要注意的是，属性优先级与配置加载优先级的区别！`

> ### 以下所有的优先级排序都是按高到低！！

## 属性优先级1&2测试
> A /config subdirectory of the current directory  
>与  The current directory  加载顺序测试
>
> 该测试主要是测试当前目录与当前目录下的config子目录的加载顺序
>
> Note:  当前目录特指运行时目录，System.getProperty("user.dir")下，也就是与jar包同级目录下

测试类[Config12Compenter](./src/main/java/com/test/configload/Config12Compenter.java)

在外部配置文件`application.properties`中（当前目录），配置了
```
file.12Config_1=与JAR同级目录
file.12Config_2=与JAR同级目录
```
，子目录配置文件`config/application.properties`中（当前目录下config子目录），配置了
`file.12Config_1=JAR目录下Config目录`。

`com.test.configload.Config12Compenter>>config>>12Config_1: JAR目录下Config目录,12Config_2: 与JAR同级目录`

可以明确从结果打印中看到配置`file.12Config_1`为`JAR目录下Config目录`，
也就是说当前目录下的配置文件被config子目录下配置文件重写。

结论： 在给定的当前目录下的配置文件中，会优先加载当前目录配置，然后再加载config下配置。

加载优先级：
1. file:./
2. file:./config/

属性优先级：
1. file:./config/  > A /config subdirectory of the current directory
2. file:./ > The current directory

## 属性优先级3&4测试
>  A classpath /config package   
> 与 The classpath root  加载顺序测试
>
> 该测试主要是测试classpath目录与classpath目录下config子目录的加载顺序
>
> Note:  classpath 编译后类目录


测试类[Config34Compenter](./src/main/java/com/test/configload/Config34Compenter.java)

在Classpath配置文件`application.properties`中，配置了
```
file.34Config_1=Classpath目录
file.34Config_2=Classpath目录
```
，子目录配置文件`config/application.properties`中（Classpath目录下config子目录），配置了
`file.34Config_1=Classpath目录下Config目录`。

`com.test.configload.Config34Compenter>>config>>34Config_1: Classpath目录下Config目录,34Config_2: Classpath目录`

可以明确从结果打印中看到配置`file.34Config_1`为`Classpath目录下Config目录`，
也就是说Classpath目录下的配置文件被config子目录下配置文件重写。

结论： 在Classpath目录下的配置文件中，会优先加载，然后再加载Classpath子目录config下配置。

加载优先级：
1. classpath:/
2. classpath:/config/

属性优先级：
1. classpath:./config/  > A classpath /config package   
2. classpath:./ > The classpath root

##  属性优先级1&2&3&4测试

测试类[Config1234Compenter](./src/main/java/com/test/configload/Config1234Compenter.java)


从上面的测试中，可以得出加载顺序为
1. classpath:/
2. classpath:/config/
3. file:./
4. file:./config/

所以，配置四个属性来校验加载的优先级。
在`Classpath下`的`application.properties`中配置
```
file.1234Config_1=Classpath目录
file.1234Config_2=Classpath目录
file.1234Config_3=Classpath目录
file.1234Config_4=Classpath目录
```
在`Classpath/config`下的`application.properties`中配置
```
file.1234Config_1=Classpath目录下Config目录
file.1234Config_2=Classpath目录下Config目录
file.1234Config_3=Classpath目录下Config目录
```
在`当前目录`下的`application.properties`中配置
```
file.1234Config_1=与JAR同级目录
file.1234Config_2=与JAR同级目录
```
在`当前目录下的config下`的`application.properties`中配置
`file.1234Config_1=JAR目录下Config目录`

可以看到，最终配置结果为：
`com.test.configload.Config1234Compenter>>config>>1234Config_1: JAR目录下Config目录,1234Config_2: 与JAR同级目录,1234Config_3: Classpath目录下Config目录,1234Config_4: Classpath目录`

结论：

所以，`属性优先级`从高到低次为：
1. file:./config/ (当前项目路径config目录下);
2. file:./ (当前项目路径下);
3. classpath:/config/ (类路径config目录下);
4. classpath:/ (类路径config下).

而`加载顺序`的优先级为：
1. classpath:/ > The classpath root
2. classpath:/config/ > A classpath /config package 
3. file:./ > The current directory
4. file:./config/ > A /config subdirectory of the current directory

## 相同目录下的properties与yml配置
测试类[YPConfigCompenter](./src/main/java/com/test/configload/YPConfigCompenter.java)

然后在application.yml中配置了
```
file:
  yml: yml
  prop: yml
```

在application.properties中配置了`file.prop=prop`

`com.test.configload.YPConfigCompenter>>config>>yml: yml,prop: prop`

可以明确的看到配置`file.prop`在系统中的值为`prop`。

结论： 在同一层级的配置文件中，`yml`配置被会优先加载，`properties`后被加载
，并且会覆盖`yml`中的配置信息。

加载优先级：
1. yml
2. properties

属性优先级：
1. properties
2. yml