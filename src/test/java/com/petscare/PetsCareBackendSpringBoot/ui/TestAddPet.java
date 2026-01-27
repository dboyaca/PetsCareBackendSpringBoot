package com.petscare.PetsCareBackendSpringBoot.ui;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class TestAddPet {


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

            WebElement btnManagePatients = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[contains(text(), 'Manage Patients')]")));
            btnManagePatients.click();

            WebElement nameField = wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("name")));
            nameField.sendKeys("Ludwig");

            WebElement speciesField = driver.findElement(By.name("species"));
            speciesField.sendKeys("Dog");

            WebElement breedField = driver.findElement(By.name("breed"));
            breedField.sendKeys("Bulldog");

            WebElement ageField = driver.findElement(By.name("age"));
            ageField.sendKeys("3");

            WebElement weightField = driver.findElement(By.name("weight"));
            weightField.sendKeys("12.4");

            WebElement additionalInfoField = driver.findElement(By.name("additional_info"));
            additionalInfoField.sendKeys("No additional information");

            WebElement btnAddPet = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[contains(text(), 'Add Patient')]")));
            btnAddPet.click();

            String expectedText = "Patient registered succesfully!";

            WebElement successNotification = wait.until(ExpectedConditions.visibilityOfElementLocated(
                    By.xpath("//*[contains(text(), '" + expectedText + "')]")
            ));


            System.out.println("Mascota agregada correctamente");


        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            //driver.quit();
        }


    }

}