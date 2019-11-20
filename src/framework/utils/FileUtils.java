package framework.utils;

import java.io.File;

public class FileUtils {
    public static boolean isExistFile(String filepath) {
        File file = new File(filepath);
        return file.exists();
    }
}
