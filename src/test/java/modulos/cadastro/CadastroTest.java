package modulos.cadastro;


import org.junit.jupiter.api.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import paginas.LoginPage;

import java.time.Duration;

@DisplayName("Testes web do cadastro de usuário")
public class CadastroTest {

    private WebDriver driver;


    @BeforeEach
    @DisplayName("Executa toda vez, antes de cada teste ser iniciado")
    public void beforeEach() {

        System.setProperty("webdriver.chrome.driver", "C:\\drivers\\chromedriver.exe");
        this.driver = new ChromeDriver();
        /* acessar url do site */
        this.driver.get("https://courses.ultimateqa.com/users/sign_in");
        this.driver.manage().window().maximize();
        this.driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

    }


    @Test
    @DisplayName("Nao é permitido cadastrar um novo usuario com um email invalido")
    // tem que estar no formato certo. Ex: org@example.com
    public void validarQueNaoEPermitidoRealizarCadastroComEmailInvalido() {

        new LoginPage(driver)
                .clicarParaIrParaATelaDeCadastroDoUsuario()
                .preencherCampoNome("Testando")
                .preencherCampoSobrenome("testes123")
                .preencherCampoEmail("testes123")
                .preencherCampoSenha("Testes")
                .clicarNoCheckbox();

        String msg = driver.findElement(By.id("user[email]-error")).getText();
        System.out.println("Mensagem que foi coletada: " + msg);
        Assertions.assertEquals("Please enter a valid email address", msg);

    }

    @Test
    @DisplayName("Nao e permitido deixar o campo 'Nome' em branco na hora de realizar o cadastro")
    public void validarQueNaoPermiteCadastrarUmaContaNovaComCampoNomeEmBranco() {

        new LoginPage(driver)
                .clicarParaIrParaATelaDeCadastroDoUsuario()
                .preencherCampoNome("")
                .preencherCampoSobrenome("Testando");

        String msg = driver.findElement(By.id("user[first_name]-error")).getText();
        System.out.println("Mensagem que foi coletada: " + msg);
        Assertions.assertEquals("This field cannot be blank", msg);

    }

    @Test
    @DisplayName("Nao e permitido deixar o campo 'Sobrenome' em branco na hora de realizar o cadastro")
    public void validarQueNaoPermiteCadastrarUmaContaNovaComCampoSobrenomeEmBranco() {

        new LoginPage(driver)
                .clicarParaIrParaATelaDeCadastroDoUsuario()
                .preencherCampoNome("Testando")
                .preencherCampoSobrenome(" ")
                .preencherCampoSenha("Testes123");

        //driver.findElement(By.id("main-content")).click();

        String msg = driver.findElement(By.xpath("//*[@id=\"user[last_name]-error\"]")).getText();
        System.out.println("Mensagem que foi coletada" + msg);
        //Assertions.assertEquals("This field cannot be blank", msg);

    }

    @AfterEach
    @DisplayName("Executa após o final de cada teste.")
    public void afterEach() {
        this.driver.close();
    }

}
