package kr.rojae.prop.enums;

import kr.rojae.prop.utils.FileUtils;

public enum ExtensionType {
    yml, yaml, properties;

    public static boolean isYml(String fileName){
        return FileUtils.getExtension(fileName).equals(ExtensionType.yml.name());
    }

    public static boolean isYaml(String fileName){
        return FileUtils.getExtension(fileName).equals(ExtensionType.yaml.name());
    }

    public static boolean isProperties(String fileName){
        return FileUtils.getExtension(fileName).equals(ExtensionType.properties.name());
    }

}
