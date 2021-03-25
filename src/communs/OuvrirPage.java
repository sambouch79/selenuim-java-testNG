package communs;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.chrome.ChromeDriver;

public class OuvrirPage {
	
	
	  public void OuvrirPageChrome() throws Exception {
			
			
			
			System.out.println("Lancer Chrome -- Start");
			System.setProperty("webdriver.chrome.driver", declaration_constante.ChromeWebDriverFile);
			Declaration_Variables_Globales.driver = new ChromeDriver();
			Declaration_Variables_Globales.driver.manage().timeouts().implicitlyWait(90, TimeUnit.SECONDS);
			Declaration_Variables_Globales.driver.manage().timeouts().pageLoadTimeout(90, TimeUnit.SECONDS);
			Declaration_Variables_Globales.driver.manage().window().maximize();
			
			Declaration_Variables_Globales.driver.get(declaration_constante.BaseURL);
			System.out.println("Lancer Chrome -- End");
		}
	
	
	
	
	public void OuvrirPageFormulaire(String BaseURLFormulaire) throws Exception  {
		
		System.setProperty("webdriver.chrome.driver", declaration_constante.ChromeWebDriverFile);
		Declaration_Variables_Globales.driver = new ChromeDriver();
		Declaration_Variables_Globales.driver.manage().timeouts().implicitlyWait(120, TimeUnit.SECONDS);
		Declaration_Variables_Globales.driver.manage().timeouts().pageLoadTimeout(120, TimeUnit.SECONDS);
		Declaration_Variables_Globales.driver.manage().window().maximize();
		
		Declaration_Variables_Globales.driver.get(BaseURLFormulaire);
		
		
	}

}
