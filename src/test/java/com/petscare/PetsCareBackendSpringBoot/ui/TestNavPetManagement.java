package com.petscare.PetsCareBackendSpringBoot.ui;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;


public class TestNavPetManagement {

    public static void main(String[] args){

        WebDriver driver = new ChromeDriver();



        try{
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

            wait.until(ExpectedConditions.urlContains("/patients"));

            System.out.println("PRUEBA EXITOSA: Módulo de pacientes correctamente desplegado");




        } catch (Exception e) {
            e.printStackTrace();
        }finally{
            //driver.quit();
        }


    }

}
