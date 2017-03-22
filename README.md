# springboot-mybatis-demo
springboot集成mybatis，生成jar

# 生成war（转载http://wiselyman.iteye.com/blog/2145442）
Spring Boot由jar包转成war包

博客分类： spring-boot
spring boot 默认是以jar包形式启动web程序，在新建spring boot项目时候可以选择war包的启动方式。
 
建议在开发的时候建立以jar包启动的web项目，启动效率更快，此时如果想发布成war包形式部署，做如下操作：
1.修改pom.xml
将
Xml代码  收藏代码
<packaging>jar</packaging>  
 
修改成
Xml代码  收藏代码
<packaging>war</packaging>  
 
2.新增如下到pom.xml文件中
Xml代码  收藏代码
<dependency>  
        <groupId>org.springframework.boot</groupId>  
        <artifactId>spring-boot-starter-tomcat</artifactId>  
        <scope>provided</scope>  
    </dependency>  
 
3.新增ServletInitializer类
Java代码  收藏代码
import org.springframework.boot.builder.SpringApplicationBuilder;  
import org.springframework.boot.context.web.SpringBootServletInitializer;  
  
public class ServletInitializer extends SpringBootServletInitializer {  
  
    @Override  
    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {  
        return application.sources(Application.class);  
    }  
  
}  
