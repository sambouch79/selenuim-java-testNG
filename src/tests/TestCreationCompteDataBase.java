package tests;

import static org.testng.Assert.assertEquals;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

import communs.Declaration_Variables_Globales;
import communs.OuvrirPage;

import communs.declaration_constante;
import modules.Logecriture;

public class TestCreationCompteDataBase {
	OuvrirPage page=new OuvrirPage();	
	
  @Test(priority=2)
  public void CreerComptedataBase() throws SQLException{
			String host="localhost";
			String port= "3306";
			
			try {
				page.OuvrirPageFormulaire(declaration_constante.BaseURLFormulaire);
			} catch (Exception e1) {
				System.out.println(e1.toString());
			}
			
			
			
			Connection con=DriverManager.getConnection("jdbc:mysql://"+ host +":"+ port +"/Demo?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC",  "root", "Samira1979+");
		
		
			
			Statement a=con.createStatement();
			ResultSet rs= a.executeQuery("select * from MaTable");  
			
			
			
			while(rs.next()) {
				
				try {
					page.OuvrirPageFormulaire(declaration_constante.BaseURLFormulaire);
				} catch (Exception e1) {
					System.out.println(e1.toString());
				}		
			
			String siret=rs.getString("Siret");
			String nom=rs.getString("nom");
			String prenom =rs.getString("prenom");
			String mail = rs.getString("Mail");
			String tel = rs.getString("telephone");
			
			Declaration_Variables_Globales .driver.findElement(By.xpath("//a[@id='cn-accept-cookie']")).click();
			Declaration_Variables_Globales .driver.findElement(By.xpath("//input[@id='txtSiret']")).sendKeys(siret);
			Declaration_Variables_Globales .driver.findElement(By.xpath("//input[@id='txtNom']")).sendKeys(nom);
			Declaration_Variables_Globales .driver.findElement(By.xpath("//input[@id='txtPrenom']")).sendKeys(prenom);
			Declaration_Variables_Globales .driver.findElement(By.xpath("//input[@id='txtTelephone']")).sendKeys(tel);
				// driver.findElement(By.xpath("//input[@id='TelephonePortable']")).sendKeys("");
			Declaration_Variables_Globales .driver.findElement(By.xpath("//input[@id='txtMel']")).sendKeys(mail);
			Declaration_Variables_Globales .driver.findElement(By.xpath("//input[@id='txtConfirmationMel']")).sendKeys(mail);

			Declaration_Variables_Globales .driver.findElement(By.xpath("//*[@id='validButtonInscription']")).click();

			String message=Declaration_Variables_Globales .driver.findElement(By.xpath("//*[@id=\'coordonneesADForm\']/div[3]/div/div")).getText();
		    
			
			 // Vérifier sur la page de apres confirmation le message d'erreur
		    try {
		      assertEquals(declaration_constante.messageErreur,message);
		      Logecriture.EcrireLogOK("le messag erreur s'affiche ");
		    } catch (Error e) {
		    	Logecriture.EcrireLogKO(e.toString());
			}	

		}
  }
}
