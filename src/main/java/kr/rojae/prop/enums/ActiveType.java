package kr.rojae.prop.enums;

public enum ActiveType {
    enable, disable;

    public static boolean isEnable(String activeTypeString){
        return activeTypeString.equals(ActiveType.enable.name());
    }

    public static boolean isDisable(String activeTypeString){
        return activeTypeString.equals(ActiveType.disable.name());
    }
}
