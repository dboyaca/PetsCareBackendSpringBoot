package com.petscare.PetsCareBackendSpringBoot.ui;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class TestUpdateSpeciality {

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

            WebElement btnManagePatients = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[contains(text(), 'Manage Specialities')]")));
            btnManagePatients.click();

            WebElement tabViewHistory = wait.until(ExpectedConditions.elementToBeClickable(
                    By.xpath("//button[contains(., 'Update / Delete')]")
            ));
            tabViewHistory.click();

            WebElement comboTrigger = wait.until(ExpectedConditions.elementToBeClickable(
                    By.xpath("//label[text()='Select Speciality to Edit']/following-sibling::div")
            ));
            comboTrigger.click();

            String tratamientoASeleccionar = "Nutricion Animal (ID: 104)";

            WebElement option = wait.until(ExpectedConditions.elementToBeClickable(
                    By.xpath("//li[@role='option']//span[contains(text(), '" + tratamientoASeleccionar + "')]")
            ));

            option.click();

            WebElement specialityNameField = wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("name")));
            specialityNameField.sendKeys("Nutricion Animal");

            WebElement chargeField = driver.findElement(By.name("charge_per_hour"));
            chargeField.sendKeys("72000");

            WebElement btnSaveChanges = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[contains(text(), 'Save Changes')]")));
            btnSaveChanges.click();

            System.out.println("PRUEBA EXITOSA: Especialidad odontología actualizada exitosamente");


        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            //driver.quit();
        }
    }
}
