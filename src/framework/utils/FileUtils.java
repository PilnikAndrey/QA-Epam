package framework.utils;

import java.io.File;

public class FileUtils {
    public static boolean isExistFile(String path, String filename) {
        String filePath = String.format(path,filename);
        File file = new File(filePath);
        return file.exists();
    }
}
