package com.petscare.PetsCareBackendSpringBoot.ui;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class TestVisualizeAllRecords {
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

            WebElement btnAccessRecords = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[contains(text(), 'Access Records')]")));
            btnAccessRecords.click();

            WebElement tabViewHistory = wait.until(ExpectedConditions.elementToBeClickable(
                    By.xpath("//button[contains(., 'View History')]")
            ));
            tabViewHistory.click();

            WebElement petIdField = wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("patientId")));
            petIdField.sendKeys("6");

            WebElement btnSearch = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[contains(text(), 'Search')]")));
            btnSearch.click();

            System.out.println("PRUEBA EXITOSA. Visualización de registros");

        } catch (Exception e) {
            System.out.println("ERROR: Algo falló. Revisa los selectores.");
            e.printStackTrace();
        } finally {
            // driver.quit();
        }
    }
}
