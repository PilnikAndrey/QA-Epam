package framework.utils;

import java.io.File;

public class ExistFile {
    public static boolean checkExistFile() {
        String filePath = "/home/ITRANSITION.CORP/a.pilnik/Downloads/steam_latest.deb";
        File file = new File(filePath);
        if (file.exists()) {
            return true;
        } else {
            return false;
        }
    }
}
