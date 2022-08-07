# load Properties Module

- 목표 : OS별로 Propertis를 쉽게 관리하기 위해서 프로젝트 내부가 아닌 외부에서 관리하도록 함
- 추후 : Maven 업로드 계획

사용법
1. 모듈 프로젝트 jar packaging

2. 모듈 사용할 프로젝트 : pom.xml을 통해서 jar 라이브러리 추가
```xml
        <dependency>
            <groupId>kr.rojae</groupId>
            <artifactId>load-prop</artifactId>
            <version>1.0</version>
            <scope>system</scope>
            <classifier>exec</classifier>
            <systemPath>${pom.basedir}/src/main/resources/libs/load-prop-1.0.jar</systemPath>
        </dependency>
```

3. jar 추가 이후 소스 수정
```properties
# Properties Loader
prop.load.active=enable | disable
prop.load.console=enable | disable
prop.load.path={리소스 폴더 경로}
```

```java
// Springboot Main
@SpringBootApplication
public class Application extends LoadPropExecution {
    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }
}
```