package paginas;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class TelaCadastroPage {

    private WebDriver driver;

    public TelaCadastroPage(WebDriver driver) {
        this.driver = driver;
    }

    public TelaCadastroPage preencherCampoNome(String nome) {
        this.driver.findElement(By.cssSelector("input[name='user[first_name]']")).click();
        this.driver.findElement(By.cssSelector("input[name='user[first_name]']")).sendKeys(nome);
        return this;
    }

    public TelaCadastroPage preencherCampoSobrenome(String sobrenome) {
        this.driver.findElement(By.id("user[last_name]")).click();
        this.driver.findElement(By.id("user[last_name]")).sendKeys(sobrenome);
        return this;
    }

    public TelaCadastroPage preencherCampoEmail(String email) {
        this.driver.findElement(By.name("user[email]")).click();
        this.driver.findElement(By.name("user[email]")).sendKeys(email);
        return this;
    }

    public TelaCadastroPage preencherCampoSenha(String senha){
        this.driver.findElement(By.id("user[password]")).click();
        this.driver.findElement(By.id("user[password]")).sendKeys(senha);
        return this;
    }

    public TelaCadastroPage clicarNoCheckbox(){
        this.driver.findElement(By.id("user[terms]")).click();
        return this;
    }

}
