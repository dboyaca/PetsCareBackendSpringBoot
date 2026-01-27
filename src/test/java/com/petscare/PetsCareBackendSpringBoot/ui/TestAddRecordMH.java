package com.petscare.PetsCareBackendSpringBoot.ui;


import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class TestAddRecordMH {
    public static void main(String[] args) {

        WebDriver driver = new ChromeDriver();

        try {
            driver.get("http://localhost:5173/login");
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));

            WebElement userField = wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("email")));
            userField.sendKeys("dboyacap@gmail.com");
            WebElement pwField = driver.findElement(By.name("password"));
            pwField.sendKeys("dboyaca");
            WebElement btnIngresar = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[contains(text(), 'Sign In')]")));
            btnIngresar.click();

            WebElement btnManagePatients = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[contains(text(), 'Access Records')]")));
            btnManagePatients.click();

            WebElement petIdField = wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("patientId")));
            petIdField.sendKeys("6");

            WebElement comboTrigger = wait.until(ExpectedConditions.elementToBeClickable(
                    By.xpath("//label[text()='Select Treatment']/following-sibling::div")
            ));
            comboTrigger.click();

            String tratamientoASeleccionar = "Antibiótico";

            WebElement opcion = wait.until(ExpectedConditions.elementToBeClickable(
                    By.xpath("//li[@role='option']//span[contains(text(), '" + tratamientoASeleccionar + "')]")
            ));

            opcion.click();

            WebElement dateField = wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("startDate")));
            dateField.sendKeys("01132026");
            dateField.sendKeys(Keys.TAB);
            dateField.sendKeys("1030");
            dateField.sendKeys(Keys.ARROW_UP);

            WebElement dateFieldEnd = wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("endDate")));
            dateFieldEnd.sendKeys("01212026");
            dateFieldEnd.sendKeys(Keys.TAB);
            dateFieldEnd.sendKeys("1030");
            dateFieldEnd.sendKeys(Keys.ARROW_UP);

            WebElement frequencyField = driver.findElement(By.name("frequencyHours"));
            frequencyField.sendKeys("8");

            WebElement quantityField = driver.findElement(By.name("quantity"));
            quantityField.sendKeys("24");

            WebElement observationsField = driver.findElement(By.name("observations"));
            observationsField.sendKeys("Mix it with wet food at the usual meal hours");

            WebElement btnAddRecord = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[contains(text(), 'Confirm Assignment')]")));
            btnAddRecord.click();

            System.out.println("PRUEBA EXITOSA. Registro agregado exitosamente");

        } catch (Exception e) {
            System.out.println("ERROR: Algo falló. Revisa los selectores.");
            e.printStackTrace();
        } finally {
            // driver.quit();
        }
    }


}
