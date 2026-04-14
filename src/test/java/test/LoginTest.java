package test;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pages.LoginPage;

import static org.junit.jupiter.api.Assertions.*;

public class LoginTest {

        private WebDriver driver;
        private LoginPage loginPage;

        @BeforeEach
        void setUp() {
                WebDriverManager.chromedriver().setup();
                driver = new ChromeDriver();
                driver.manage().window().maximize();

                driver.get("https://www.saucedemo.com/");

                loginPage = new LoginPage(driver);
        }

        @AfterEach
        void tearDown() {
                if (driver != null) {
                        driver.quit();
                }
        }

        @Test
        void loginCorrecto() throws InterruptedException {
            // introduce un usuario válido
            loginPage.ingresarUsuario("standard_user");
            Thread.sleep(2000);

            // introduce una contraseña válida
            loginPage.ingresarPassword("secret_sauce");
            Thread.sleep(2000);

            // pulsa el botón de login
            loginPage.clickLogin();
            Thread.sleep(2000);

            // comprueba que la URL contiene la palabra "inventory"
            String urlActual = driver.getCurrentUrl();
            assertTrue(urlActual.contains("inventory"));
            Thread.sleep(2000);
        }

        @Test
        void loginIncorrecto() throws InterruptedException {
            // introduce un usuario válido
            loginPage.ingresarUsuario("usuario");
            Thread.sleep(2000);

            // introduce una contraseña válida
            loginPage.ingresarPassword("passincorrecta");
            Thread.sleep(2000);

            // pulsa el botón de login
            loginPage.clickLogin();
            Thread.sleep(2000);

            // Comprueba que la URL NO contiene la palabra "inventory"
            String urlActual = driver.getCurrentUrl();
            assertFalse(urlActual.contains("inventory"));
            Thread.sleep(2000);
        }

        @Test
        void loginCorrecto2() throws InterruptedException {
            loginPage.login("standard_user", "secret_sauce");
            String urlActual = driver.getCurrentUrl();
            assertTrue(urlActual.contains("inventory"));
            Thread.sleep(2000);
        }
}