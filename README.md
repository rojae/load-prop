# load Properties Module

- 목표 : OS별로 Propertis를 쉽게 관리하기 위해서 프로젝트 내부가 아닌 외부에서 관리하도록 함
- 추후 : Maven 업로드 계획

사용법
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