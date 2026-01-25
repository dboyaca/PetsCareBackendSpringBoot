package com.petscare.PetsCareBackendSpringBoot.ui;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;


public class TestSignUp {
    public static void main(String[] args){
        WebDriver driver = new ChromeDriver();

        try{
            driver.get("http://localhost:5173/register");
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));

            WebElement firstNameField = driver.findElement(By.name("firstName"));
            firstNameField.sendKeys("Gladys");

            WebElement secondNameField = driver.findElement(By.name("secondName"));
            secondNameField.sendKeys("");

            WebElement firstLastNameField = driver.findElement(By.name("firstLastName"));
            firstLastNameField.sendKeys("Fuquen");

            WebElement secondLastNameField = driver.findElement(By.name("secondLastName"));
            secondLastNameField.sendKeys("Baquero");

            WebElement emailField = driver.findElement(By.name("email"));
            emailField.sendKeys("gladysfbaquero@gmail.com");

            WebElement passwordField = driver.findElement(By.name("password"));
            passwordField.sendKeys("gladysfbaquero");

            WebElement passwordConfirmField = driver.findElement(By.name("confirmPassword"));
            passwordConfirmField.sendKeys("gladysfbaquero");

            WebElement btnRegistrar = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[contains(text(), 'Sign Up')]")));
            btnRegistrar.click();


            wait.until(ExpectedConditions.urlContains("/login"));

            System.out.println("PRUEBA EXITOSA: Registro correcto");

        }catch(Exception e){
            System.out.println("ERROR. Something failed");
        }finally {
            driver.quit();
        }
    }

}
