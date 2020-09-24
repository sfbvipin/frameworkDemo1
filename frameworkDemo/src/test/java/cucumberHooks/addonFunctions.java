package cucumberHooks;

import java.io.IOException;
import java.util.*;
import javax.mail.*;
import javax.mail.internet.*;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;


public class addonFunctions {
    static XSSFWorkbook workbook;
    static XSSFSheet sheet;


    public static void SendMail()  {
        String to = "sohail.abbas@sofbang.com";
        String from = "sohail.abbas@sofbang.com";
        String host = "smtp.office365.com";
        String port = "25";
        Properties properties = System.getProperties();
        properties.setProperty("mail.smtp.host", host);
        properties.setProperty("mail.smtp.port", port);
        properties.setProperty("mail.smtp.auth", "true");
        properties.setProperty("mail.smtp.username", "sohail.abbas@sofbang.com");
        properties.setProperty("mail.smtp.password", "@Zindagi$July2020");

        Session session = Session.getDefaultInstance(properties);

        try{
            MimeMessage message = new MimeMessage(session);
            message.setFrom(new InternetAddress(from));
            message.addRecipient(Message.RecipientType.TO,
                    new InternetAddress(to));
            message.setSubject("This is the Subject Line!");
            message.setText("This is actual message");
            Transport.send(message);
            System.out.println("Sent message successfully....");

        }catch (MessagingException mex) {
            mex.printStackTrace();
        }

    }


    public static void ExcelUtils(String sheetName) throws IOException {
        String excelPath="src\\test\\resources\\TestData\\TestData.xlsx";
        workbook= new XSSFWorkbook(excelPath);
        sheet=workbook.getSheet(sheetName);
    }


    public static String getCellData(int rowNum, int ColNum) throws IOException {
        String value=sheet.getRow(rowNum).getCell(ColNum).getStringCellValue();
        DataFormatter formatter=new DataFormatter();
        formatter.formatCellValue(sheet.getRow(rowNum).getCell(ColNum));
        return value;
    }

    public static Integer getRowCount() throws IOException {
        int rowCount=sheet.getPhysicalNumberOfRows();
        System.out.println("SHARP detected total "+rowCount+" rows");
        return rowCount;
    }

    public static void compareString(String expectedValue, String actualValue) throws IOException {
        if (actualValue.equalsIgnoreCase(expectedValue)){
            System.out.println("Expected Value is :" + expectedValue);
            System.out.println("Actual Value is :" + actualValue);
            System.out.println("Expected Value and Actual Value is same");
        } else {
            System.out.println("Expected Value is :" + expectedValue);
            System.out.println("Actual Value is :" + actualValue);
            System.out.println("Expected Value and Actual Value is different");
        }
        assert actualValue.equalsIgnoreCase(expectedValue);
    }

    public static String validateResponse(String strTestCaseName) throws IOException {
        ExcelUtils("TestData");
        Integer intRowCount = addonFunctions.getRowCount();
        String strKeyMap = null;
        String strValueMap = null;
        String testCaseName = null;
        Integer i = 0;
        for(i=0;i<=intRowCount;i++) {
            testCaseName = cucumberHooks.addonFunctions.getCellData(i, 1);
            if (testCaseName.equalsIgnoreCase(strTestCaseName))
            {
                strKeyMap = cucumberHooks.addonFunctions.getCellData(i, 5);
                strValueMap = cucumberHooks.addonFunctions.getCellData(i, 6);
                break;
            }
        }
        String strValue = strKeyMap+":"+strValueMap;
        return strValue;
    }

}