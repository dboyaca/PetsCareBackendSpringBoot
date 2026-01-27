package com.petscare.PetsCareBackendSpringBoot.ui;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class TestListAllMedicalAppointments {
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

            //-------ENTERING TO THE MANAGE APPOINTMENTS OPTION-----
            WebElement btnManageAppointments = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[contains(text(), 'Manage Appointments')]")));
            btnManageAppointments.click();


            //------- SELECTING MY APPOINTMENTS TAB -------
            WebElement tabMyAppointments = wait.until(ExpectedConditions.elementToBeClickable(
                    By.xpath("//button[contains(., 'My Appointments')]")
            ));
            tabMyAppointments.click();

            //------ SELECTING THE PET WHOSE WE DESIRE TO SCHEDULE AN APPOINTMENT-------
            WebElement comboTriggerPet = wait.until(ExpectedConditions.elementToBeClickable(
                    By.xpath("//label[text()='Select Pet to View History']/following-sibling::div")
            ));
            comboTriggerPet.click();

            String petToSelect = "Ludwig (Bulldog)";

            WebElement option = wait.until(ExpectedConditions.elementToBeClickable(
                    By.xpath("//li[@role='option'][contains(., '" + petToSelect + "')]")));
            option.click();

            WebElement btnRefresh = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[contains(text(), 'Refresh')]")));
            btnRefresh.click();

            System.out.println("PRUEBA EXITOSA: Visualización de todas las citas medicas \n para el paciente seleccionado");


        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            //driver.quit();
        }
    }

}
