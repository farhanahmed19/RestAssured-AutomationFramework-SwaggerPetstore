package api.utilities;

import java.io.IOException;

import org.testng.annotations.DataProvider;

public class DataProviders {

    // DataProvider for providing all user data
    @DataProvider(name = "Data")
    public String[][] getAllData() throws IOException {
        String path = System.getProperty("user.dir") + "//testData//Userdata.xlsx";
        XLUtility xl = new XLUtility(path);

        int rownum = xl.getRowCount("Sheet1"); // Get valid row count
        int colcount = xl.getCellCount("Sheet1", 0); // Get number of columns

        String apidata[][] = new String[rownum][colcount];

        // Start data from row 1 to avoid header row
        for (int i = 1; i <= rownum; i++) {
            for (int j = 0; j < colcount; j++) {
                apidata[i - 1][j] = xl.getCellData("Sheet1", i, j); // Skip header
            }
        }
        return apidata;
    }

    // DataProvider for providing usernames only
    @DataProvider(name = "UserNames")
    public String[] getUserNames() throws IOException {
        String path = System.getProperty("user.dir") + "//testData//Userdata.xlsx";
        XLUtility xl = new XLUtility(path);

        int rownum = xl.getRowCount("Sheet1"); // Get valid row count

        String apidata[] = new String[rownum];
        // Start data from row 1 to avoid header row
        for (int i = 1; i <= rownum; i++) {
            apidata[i - 1] = xl.getCellData("Sheet1", i, 1); // Column for UserName
        }

        return apidata;
    }
}