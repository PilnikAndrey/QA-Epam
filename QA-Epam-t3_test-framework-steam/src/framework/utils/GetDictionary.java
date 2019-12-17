package framework.utils;

public class GetDictionary {
    public static String getDictionary() {
        String dictionary = null;
        if (ConfigReader.getProperty("lang").equals("ru")) {
            dictionary = "ru_dictionary";
        }
        if (ConfigReader.getProperty("lang").equals("en-US")) {
            dictionary = "en_dictionary";
        }
        return ConfigReader.getTestData(dictionary);
    }
}
