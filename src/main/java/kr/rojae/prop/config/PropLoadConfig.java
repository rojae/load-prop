package kr.rojae.prop.config;

import kr.rojae.prop.enums.ConsoleType;
import kr.rojae.prop.loader.PropLoaderImpl;
import org.springframework.boot.autoconfigure.condition.ConditionalOnExpression;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;

import javax.annotation.PostConstruct;

@Configuration
@Order(1)
@ConditionalOnExpression(
        "'${prop.load.active}'=='enable' and !T(org.springframework.util.StringUtils).isEmpty('${prop.load.path:}')"
)
public class PropLoadConfig {

    private final Props props;

    public PropLoadConfig(Props props) {
        this.props = props;
    }

    @PostConstruct
    public void init() {
        PropLoaderImpl propLoader = new PropLoaderImpl(props.path, ConsoleType.isEnable(props.printLog));
        propLoader.run();
    }

}