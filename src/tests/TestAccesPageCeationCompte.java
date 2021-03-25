package tests;

import static org.testng.Assert.assertEquals;

import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

import communs.Declaration_Variables_Globales;
import communs.OuvrirPage;
import communs.declaration_constante;
import modules.Logecriture;

public class TestAccesPageCeationCompte {
	
	OuvrirPage page1=new OuvrirPage();
	
  @Test (priority=1)
  public void AccesPageInscription() throws Throwable {

			System.out.println("testAccesPageOK -- Start");
			
			page1.OuvrirPageChrome();
			
			//Declaration_Variables_Globales.driver.get(declaration_constante.BaseURL);


			
			WebElement bouton = Declaration_Variables_Globales.driver.findElement(By.xpath("//*[@id='menu']/ul/li[4]/a"));
			WebElement list   = Declaration_Variables_Globales.driver.findElement(By.xpath("//*[@id='menu']/ul/li[4]/ul/li[6]"));
			Actions action    = new Actions(Declaration_Variables_Globales.driver);
			
			action.moveToElement(bouton).perform();
			list.click();
			String pageName3 = Declaration_Variables_Globales.driver.getTitle();
			System.out.println(pageName3);
			//assert.assertTrue(pageName3.equals("votre compte AT-MP"));
			 
			 
			 // cliquer sur le lien sur la page du compte AT-MP
			
			WebElement lien = Declaration_Variables_Globales.driver.findElement(By.xpath("//*[@id='main']/div/div[3]/div[2]/h3[2]/a"));
		    
			lien.click();
			
			
			
			String pageName2= Declaration_Variables_Globales.driver.getCurrentUrl();
			
			System.out.println(pageName2);
			
		   
			Declaration_Variables_Globales.driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
			Declaration_Variables_Globales.driver.manage().timeouts().pageLoadTimeout(100,TimeUnit.SECONDS);
			
		
			
			Set <String> ids = Declaration_Variables_Globales.driver.getWindowHandles();
			Iterator <String> it = ids.iterator();
			String parentPage =it.next();
		    String childPage = it.next();
		    Declaration_Variables_Globales.driver.switchTo().window(childPage);
		    Declaration_Variables_Globales.driver.findElement(By.xpath("//div[@class=\'header__tools col-xs-12 col-sm-5\']//div[@class='header__login header--button']")).click(); 

			
			
		    Declaration_Variables_Globales.driver.manage().deleteAllCookies();
			
		   WebElement creercompte=Declaration_Variables_Globales.driver.findElement(By.xpath("//a[@class='btn btn-ternary']"));
		   creercompte.click();
			  
		   String pageName4=Declaration_Variables_Globales.driver.getTitle(); 
		   System.out.println(pageName4);
	
		// Vérifier qu'on est dans la page de formulaire de creation compteATMP
			try {
				assertEquals(Declaration_Variables_Globales.driver.getTitle(),declaration_constante.TitrePageFormulaire);
					
				Logecriture.EcrireLogOK("on est dans la page creation d'un nouveau compte ATMP");
			} catch (Error e) {
				Logecriture.EcrireLogKO(e.toString());
			}
	
	
	
	
		}
	
  }

