package Utils;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileInputStream;
import java.io.IOException;

public class ReadData {

    private static final String TEST_DATA_PATH =
            System.getProperty("user.dir")
                    + "/src/test/TestData/TestData.xlsx";

    private static XSSFWorkbook workbook;
    private static XSSFSheet sheet;

    static {
        try {
            FileInputStream fileInputStream =
                    new FileInputStream(TEST_DATA_PATH);

            workbook = new XSSFWorkbook(fileInputStream);

            sheet = workbook.getSheet("Login Details");

            if (sheet == null) {
                throw new RuntimeException(
                        "Sheet 'Login Details' was not found in: "
                                + TEST_DATA_PATH
                );
            }

        } catch (Exception e) {
            throw new RuntimeException(
                    "Could not load test data from: " + TEST_DATA_PATH,
                    e
            );
        }
    }

    public ReadData() throws IOException {
    }

    public static String username =
            sheet.getRow(1).getCell(0).getStringCellValue();

    public static String password =
            sheet.getRow(1).getCell(1).getStringCellValue();
}
