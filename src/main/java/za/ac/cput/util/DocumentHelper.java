package za.ac.cput.util;

import java.io.File;
import java.util.UUID;

public class DocumentHelper {
    public static boolean isNullOrEmpty(String s) {
        if (s == null || s.isEmpty()) {
            return true;

        }
        return false;
    }
    public static boolean isFileNullOrFilePathEmpty(File file){
        if (file==null||file.getPath().isEmpty()){
            return true;
        }
        return false;
    }
    public static String generateId(){
        return UUID.randomUUID().toString();
    }
}
