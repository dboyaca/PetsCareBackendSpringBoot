package com.petscare.PetsCareBackendSpringBoot.ui;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class TestScheduleMedicalAppointment {
    public static void main(String[] args) {

        WebDriver driver = new ChromeDriver();

        try {
            driver.get("http://localhost:5173/login");
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));

            // -------------- LOGIN PROCESS -------------------------
            WebElement userField = wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("email")));
            userField.sendKeys("dboyacap@gmail.com");
            WebElement pwField = driver.findElement(By.name("password"));
            pwField.sendKeys("dboyaca");
            WebElement btnIngresar = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[contains(text(), 'Sign In')]")));
            btnIngresar.click();

            //--------- HEADING TO MANAGE APPOINTMENTS MODULE -------
            WebElement btnManageAppointments = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[contains(text(), 'Manage Appointments')]")));
            btnManageAppointments.click();

            //------ SELECTING THE PATIENT FOR WHO SCHEDULING PROCESS WILL TAKE PLACE-------
            WebElement comboTriggerPatient = wait.until(ExpectedConditions.elementToBeClickable(
                    By.xpath("//label[text()='Patient']/following-sibling::div")
            ));
            comboTriggerPatient.click();

            String patientToSelect = "Ludwig (Bulldog)";

            WebElement option = wait.until(ExpectedConditions.elementToBeClickable(
                    By.xpath("//li[@role='option'][contains(., '" + patientToSelect + "')]")));
            option.click();

            //-------SELECTING THE SPECIALITY TO SCHEDULE MEDICAL APPOINTMENT -------------
            WebElement comboTriggerSpeciality = wait.until(ExpectedConditions.elementToBeClickable(
                    By.xpath("//label[contains(text(), 'Speciality')]/following-sibling::div")
            ));
            comboTriggerSpeciality.click();

            String specialityToSelect = "Dermatología Animal";

            WebElement optionSpec = wait.until(ExpectedConditions.elementToBeClickable(
                    By.xpath("//li[@role='option'][contains(text(), '" + specialityToSelect + "')]")
            ));
            optionSpec.click();

            // ------------- SELECTING THE SPECIALIST ------------------
            WebElement comboTriggerSpecialist= wait.until(ExpectedConditions.elementToBeClickable(
                    By.xpath("//label[text()='Specialist']/following-sibling::div")
            ));
            comboTriggerSpecialist.click();

            String specialistToSelect = "Laura Ramírez";

            WebElement optionSpecialist = wait.until(ExpectedConditions.elementToBeClickable(
                    By.xpath("//li[@role='option'][contains(., '" + specialistToSelect + "')]")
            ));
            optionSpecialist.click();


            WebElement dateField = wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("startHour")));
            dateField.sendKeys("02022026");
            dateField.sendKeys(Keys.TAB);
            dateField.sendKeys("0200");
            dateField.sendKeys(Keys.ARROW_DOWN);

            WebElement dateFieldEnd = wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("finalHour")));
            dateFieldEnd.sendKeys("02022026");
            dateFieldEnd.sendKeys(Keys.TAB);
            dateFieldEnd.sendKeys("0230");
            dateFieldEnd.sendKeys(Keys.ARROW_DOWN);

            WebElement btnConfirmAppointment = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[contains(text(), 'Confirm Appointment')]")));
            btnConfirmAppointment.click();

            System.out.println("PRUEBA EXITOSA. Cita agendada con éxito para Ludwig: \n 02/02/2026 2:00 a 2:30pm");

        } catch (Exception e) {
            System.out.println("ERROR: Algo falló. Revisa los selectores.");
            e.printStackTrace();
        } finally {
            // driver.quit();
        }
    }

}
