package kr.rojae.prop.enums;

public enum ConsoleType {
    enable, disable;

    public static boolean isEnable(String consoleTypeString){
        return consoleTypeString.equals(ConsoleType.enable.name());
    }

    public static boolean isDisable(String consoleTypeString){
        return consoleTypeString.equals(ConsoleType.disable.name());
    }
}
