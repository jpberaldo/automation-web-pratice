package paginas;

import org.openqa.selenium.WebDriver;

import static org.openqa.selenium.By.linkText;

public class LoginPage {

    private WebDriver driver;

    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }

    public TelaCadastroPage clicarParaIrParaATelaDeCadastroDoUsuario() {
        this.driver.findElement(linkText("Create a new account")).click();
        return new TelaCadastroPage(driver);
    }
}
