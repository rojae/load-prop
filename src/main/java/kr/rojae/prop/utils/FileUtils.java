package kr.rojae.prop.utils;

public class FileUtils {

    public static String getExtension(String fileName){
        int i = fileName.lastIndexOf('.');
        if (i > 0) {
            return fileName.substring(i+1);
        }
        return "";
    }
}
