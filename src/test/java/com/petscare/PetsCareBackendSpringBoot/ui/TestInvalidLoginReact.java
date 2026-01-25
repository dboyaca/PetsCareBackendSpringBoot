package com.petscare.PetsCareBackendSpringBoot.ui;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class TestInvalidLoginReact {
    public static void main(String[] args) {

        WebDriver driver = new ChromeDriver();

        try {
            // We proceed to go to our frontend path to test
            //vamos a la ruta del frontend a testear
            driver.get("http://localhost:5173/login");

            // We wait for the React components to load
            // Esperamos a que se carguen los componentes de react 5 segundos
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));

            // Interacting with our forms' inputs. In this case, the email field
            //Interactuando cuando nuestros camposo del formulario. En este caso, el email
            WebElement userField = wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("email")));
            userField.sendKeys("dboyacap@gmail.com");

            //Interacting with the password field, filling it out
            //
            WebElement pwField = driver.findElement(By.name("password"));
            pwField.sendKeys("dboyaca1"); //Incorrect password

            // 4. Clic on the button
            // Busca un botón que contenga el texto "Iniciar Sesión" (o como se llame en tu web)
            WebElement btnIngresar = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[contains(text(), 'Sign In')]")));
            btnIngresar.click();

            // 5. Validate
            // Cambia "/dashboard" por la ruta a la que te lleva tu login real
            wait.until(ExpectedConditions.urlContains("/login"));

            System.out.println("PRUEBA EXITOSA: Login incorrecto en React.");

        } catch (Exception e) {
            System.out.println("ERROR: Algo falló.");
            e.printStackTrace();
        } finally {
            driver.quit();
        }
    }
}
