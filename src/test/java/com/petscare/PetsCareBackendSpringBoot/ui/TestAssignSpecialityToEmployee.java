package com.petscare.PetsCareBackendSpringBoot.ui;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class TestAssignSpecialityToEmployee {
    public static void main(String[] args) {

        WebDriver driver = new ChromeDriver();

        try {

            //----------LOGIN PROCESS--------------
            driver.get("http://localhost:5173/login");
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
            WebElement userField = wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("email")));
            userField.sendKeys("dboyacap@gmail.com");
            WebElement pwField = driver.findElement(By.name("password"));
            pwField.sendKeys("dboyaca");
            WebElement btnIngresar = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[contains(text(), 'Sign In')]")));
            btnIngresar.click();

            //-------ENTERING TO THE MANAGE SPECIALITIES-----
            WebElement btnManageSpecialities = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[contains(text(), 'Manage Specialities')]")));
            btnManageSpecialities.click();


            //------- SELECTING THE ASSIGN TAB -------
            WebElement tabAssignSpeciality = wait.until(ExpectedConditions.elementToBeClickable(
                    By.xpath("//button[contains(., 'Assign')]")
            ));
            tabAssignSpeciality.click();

            WebElement employeeIdField = driver.findElement(By.name("empId"));
            employeeIdField.sendKeys("5");

            //------ SELECTING THE SPECIALITY TO UPDATE/DELETE FROM THE COMBOBOX-------
            WebElement comboTrigger = wait.until(ExpectedConditions.elementToBeClickable(
                    By.xpath("//label[text()='Speciality']/following-sibling::div")
            ));
            comboTrigger.click();

            String especialidadASeleccionar = "Veterinaria General";

            WebElement option = wait.until(ExpectedConditions.elementToBeClickable(
                    By.xpath("//li[@role='option'][contains(., '" + especialidadASeleccionar + "')]")));
            option.click();



            WebElement btnSaveChanges = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[contains(text(), 'Confirm Assignment')]")));
            btnSaveChanges.click();

            System.out.println("PRUEBA EXITOSA: Se le asignó al empleado la especialidad respectiva");


        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            //driver.quit();
        }
    }



}
