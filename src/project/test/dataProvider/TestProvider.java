package project.test.dataProvider;

import org.testng.annotations.DataProvider;

public class TestProvider {

    @DataProvider(name = "dataProviderForSteamTest")
    public static Object[][] providerStringAndExpectedLength() {
        return new Object[][]{
                {"actions", "max"},
                {"indi", "min"}
        };
    }
}
