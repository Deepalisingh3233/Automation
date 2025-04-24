package Clutch.Test;

import java.io.FileOutputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.List;

import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class GetDataExcel {

    public static void main(String[] args) throws InterruptedException, IOException {
        
        ChromeOptions options = new ChromeOptions();
        options.setExperimentalOption("useAutomationExtension", false);
        options.setExperimentalOption("excludeSwitches", new String[]{"enable-automation"});
        options.addArguments("--disable-blink-features=AutomationControlled");
        System.out.println("Current working directory: " + System.getProperty("user.dir"));
        WebDriver driver = new ChromeDriver(options);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        driver.get("https://clutch.co/us/developers/information-technology-industry");

        // Create a Workbook and a Sheet
        Workbook workbook = new XSSFWorkbook();
        Sheet sheet = workbook.createSheet("Company Data");

        // Create header row
        Row headerRow = sheet.createRow(0);
        headerRow.createCell(0).setCellValue("Company Name");
        headerRow.createCell(1).setCellValue("Min Project Size");
        headerRow.createCell(2).setCellValue("Hourly Rate");
        headerRow.createCell(3).setCellValue("Employee Count");
        headerRow.createCell(4).setCellValue("Location");
        headerRow.createCell(5).setCellValue("Description");
        headerRow.createCell(6).setCellValue("Services Provided");
        headerRow.createCell(7).setCellValue("URL");

        int count = 1; 
        int pagiCount = 2;

        // Go to Page 2
        String isEnabled = driver.findElement(By.xpath("//a[@title='Go to Next Page']")).getDomAttribute("disabled"); 
        
        while(isEnabled.equalsIgnoreCase("true")) {
            Thread.sleep(6000);
            List<WebElement> providerHighlights = driver.findElements(By.cssSelector(".provider-list-item"));
            for (WebElement element : providerHighlights) {
            	
            	if(pagiCount == 40) {
                	break;
                }
            	
                Row row = sheet.createRow(count);
                String companyName = element.findElement(By.className("provider__title")).getText();
                
                if(companyName == null || companyName.isEmpty() || companyName.isBlank()) {
                    Thread.sleep(5000);
                    String xpath = String.format("//a[@title='Go to Page %d']", pagiCount);
                    driver.findElement(By.xpath(xpath)).click();
                    pagiCount++;
                    break;
                }
                if(pagiCount == 40) {
                	break;
                }

                row.createCell(0).setCellValue(companyName);
                row.createCell(1).setCellValue(element.findElement(By.cssSelector("[class*='min-project-size']")).getText());
                row.createCell(2).setCellValue(element.findElement(By.cssSelector("[class*='hourly-rate']")).getText());
                row.createCell(3).setCellValue(element.findElement(By.cssSelector("[class*='employees-count']")).getText());
                row.createCell(4).setCellValue(element.findElement(By.cssSelector("[class*='location']")).getText());
                row.createCell(5).setCellValue(element.findElement(By.cssSelector("[class*='project-highlight-text']")).getText());

                StringBuilder services = new StringBuilder();
                element.findElements(By.cssSelector(".provider__services-list-item")).stream()
                    .filter(s -> s != null)
                    .map(s -> s.getText())
                    .filter(s -> s != null && !s.isBlank())
                    .forEach(s -> services.append(s).append(", "));
                row.createCell(6).setCellValue(services.toString());

                for (WebElement link : element.findElements(By.cssSelector(".provider__cta-container"))) {
                    link.findElements(By.cssSelector(".provider__cta-link")).stream()
                        .filter(s -> s != null)
                        .map(s -> s.getDomAttribute("href"))
                        .filter(href -> href != null && !href.isEmpty())
                        .forEach(s -> row.createCell(7).setCellValue(s));
                }

                count++;
            }
        }

        // Write the output to a file
        FileOutputStream fileOut = new FileOutputStream("CompanyData.xlsx");
        workbook.write(fileOut);
        

        // Close the workbook and driver
        workbook.close();
        driver.quit();
    }
}