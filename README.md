# Load Prop (Properties Loader Module)

## Goals
  1. For easy management of Propertyis by OS, it is managed externally, not internally

## History
### 2022.07.23
  - Maven Central Repository Upload (v0.1.0)
### 2022.08.20
  - Add yaml, yml file load function

## Demo
- https://github.com/rojae/load-prop-demo

## Maven (Maven Repo)
1. Add pom.xml
```xml
    <dependency>
        <groupId>io.github.rojae</groupId>
        <artifactId>load-prop</artifactId>
        <version>0.1.0</version>
    </dependency>
```

## No Maven Repo (Local)
- Local Packing to JAR

1. this project download

2. mvn package > load-prop-0.1.0.jar

3. WAS Project add classpath load-prop-0.1.0.jar

4. Add pom.xml
```xml
        <dependency>
            <groupId>io.github.rojae</groupId>
            <artifactId>load-prop</artifactId>
            <version>0.1.0</version>
            <scope>system</scope>
            <classifier>exec</classifier>
            <systemPath>${pom.basedir}/src/main/resources/libs/load-prop-0.1.0.jar</systemPath>
        </dependency>
```

## Usgae
- properties
```properties
# Properties Loader
prop.load.active=enable | disable
prop.load.console=enable | disable
prop.load.path={resource absolute path}
```

- Springboot Main
```java
// Springboot Main
@SpringBootApplication
public class Application extends LoadPropExecution {
    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }
}
```

- Server Start with properties log
```bash
  .   ____          _            __ _ _
 /\\ / ___'_ __ _ _(_)_ __  __ _ \ \ \ \
( ( )\___ | '_ | '_| | '_ \/ _` | \ \ \ \
 \\/  ___)| |_)| | | | | || (_| |  ) ) ) )
  '  |____| .__|_| |_|_| |_\__, | / / / /
 =========|_|==============|___/=/_/_/_/
 :: Spring Boot ::                (v2.4.0)

2022-08-20 18:06:02.387  INFO 40652 --- [           main] kr.rojae.prop.LoadPropExecution          : Starting LoadPropExecution using Java 11.0.9.1 on rojaeuicBookPro with PID 40652 (/Users/rojae/Documents/workbook/load-prop/target/classes started by rojae in /Users/rojae/Documents/workbook/load-prop)
2022-08-20 18:06:02.389  INFO 40652 --- [           main] kr.rojae.prop.LoadPropExecution          : No active profile set, falling back to default profiles: default
2022-08-20 18:06:03.298  INFO 40652 --- [           main] o.s.b.w.embedded.tomcat.TomcatWebServer  : Tomcat initialized with port(s): 8080 (http)
2022-08-20 18:06:03.312  INFO 40652 --- [           main] o.apache.catalina.core.StandardService   : Starting service [Tomcat]
2022-08-20 18:06:03.312  INFO 40652 --- [           main] org.apache.catalina.core.StandardEngine  : Starting Servlet engine: [Apache Tomcat/9.0.39]
2022-08-20 18:06:03.381  INFO 40652 --- [           main] o.a.c.c.C.[Tomcat].[localhost].[/]       : Initializing Spring embedded WebApplicationContext
2022-08-20 18:06:03.381  INFO 40652 --- [           main] w.s.c.ServletWebServerApplicationContext : Root WebApplicationContext: initialization completed in 940 ms
[2022-08-20 18:06:03] [정보     ] ---------------------------------------------------------- 
[2022-08-20 18:06:03] [정보     ] Properties File = /Users/rojae/Desktop/prop/config.properties 
[2022-08-20 18:06:03] [정보     ] ---------------------------------------------------------- 
[2022-08-20 18:06:03] [정보     ] config.password=password 
[2022-08-20 18:06:03] [정보     ] config.url=localhost 
[2022-08-20 18:06:03] [정보     ] config.user=rojae 
[2022-08-20 18:06:03] [정보     ] ---------------------------------------------------------- 
[2022-08-20 18:06:03] [정보     ] Properties File = /Users/rojae/Desktop/prop/api/api.properties 
[2022-08-20 18:06:03] [정보     ] ---------------------------------------------------------- 
[2022-08-20 18:06:03] [정보     ] api.delete=https://jsonplaceholder.typicode.com/posts/1 
[2022-08-20 18:06:03] [정보     ] api.put=https://jsonplaceholder.typicode.com/posts/1 
[2022-08-20 18:06:03] [정보     ] api.post=https://jsonplaceholder.typicode.com/posts 
[2022-08-20 18:06:03] [정보     ] api.get2=https://jsonplaceholder.typicode.com/comments 
[2022-08-20 18:06:03] [정보     ] api.get1=https://jsonplaceholder.typicode.com/posts 
[2022-08-20 18:06:03] [정보     ] api.patch=https://jsonplaceholder.typicode.com/posts/1 
[2022-08-20 18:06:03] [정보     ] ---------------------------------------------------------- 
[2022-08-20 18:06:03] [정보     ] Properties File = /Users/rojae/Desktop/prop/application.yml 
[2022-08-20 18:06:03] [정보     ] ---------------------------------------------------------- 
[2022-08-20 18:06:03] [정보     ] spring.datasource.password=password 
[2022-08-20 18:06:03] [정보     ] spring.datasource.url=jdbc:h2:dev 
[2022-08-20 18:06:03] [정보     ] spring.datasource.username=SA 
[2022-08-20 18:06:03] [정보     ] messenger.list=KAKAOTALK,SLACK,LINE,TELEGRAM 
```
