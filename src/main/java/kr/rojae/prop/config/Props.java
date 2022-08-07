package kr.rojae.prop.config;

import kr.rojae.prop.enums.ActiveType;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class Props{
    @Value("${prop.load.active}")
    public ActiveType enable;

    @Value("${prop.load.console}")
    public String printLog;

    @Value("${prop.load.path}")
    public String path;

}
