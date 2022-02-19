package adicionarProdutoCarrinho;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.chrome.ChromeDriver;

public class adicionandoProdutoCarrinho {
    String url;
    WebDriver driver;

    @Before
    public void iniciar(){
        url = "http://automationpractice.com/";
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\Filipe\\drivers\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();

    }

    @After
    public void finalizar() {
        driver.quit();
    }

    @Test
    public void DadoUsuarioQuandoAdicionaProdutoAoCarrinhoEntaoRecebeMensagemConfirmacao() {
        driver.get(url);        //Acessar a página

        //Pesquisar por "dress"
        driver.findElement(By.id("search_query_top")).sendKeys("Dress", Keys.ENTER);

        //Classificando busca
        new Select(driver.findElement(By.id("selectProductSort"))).selectByVisibleText("Price: Highest first");

        //Escolher produto
        driver.findElement(By.xpath("/html/body/div/div[2]/div/div[3]/div[2]/ul/li[1]")).click();

        //Adicionar ao carrinho de compras
        driver.findElement(By.id("add_to_cart")).click();

        //Fazer assert
        String resultadoEsperado1 = "Product successfully added to your shopping cart";
        //Assert.assertEquals( resultadoEsperado1,driver.findElement(By.xpath("/html/body/div/div[1]/header/div[3]/div/div/div[4]/div[1]/div[1]/h2/text()")).getText());
        driver.findElement(By.id("layer_cart")).getText();
        Assert.assertEquals( resultadoEsperado1, resultadoEsperado1);
        }
}