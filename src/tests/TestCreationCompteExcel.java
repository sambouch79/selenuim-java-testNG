package tests;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Iterator;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.NotFoundException;
import org.testng.annotations.Test;

import communs.Declaration_Variables_Globales;
import communs.OuvrirPage;
import communs.declaration_constante;

public class TestCreationCompteExcel {
	
	OuvrirPage page2=new OuvrirPage();	
	
  @Test(priority=3)
  public void CreerCompte_donneesExcel() throws IOException ,NotFoundException  {
		
			//page2.OuvrirPageFormulaire(declaration_constante.BaseURLFormulaire);
		
			FileInputStream fis = new FileInputStream(declaration_constante.DataExcelFile);
			XSSFWorkbook wb = new XSSFWorkbook(fis);
		
			// charger la feuille datafile
			
			XSSFSheet feuille1 = wb.getSheet("datafile");

						// Récupérer le nombre des lignes
						int nbreLignes = feuille1.getLastRowNum();
						System.out.println("lignes : " + nbreLignes);
			
						// Parcourir la feuille
						

						// On commence à la 2ème ligne. La première ligne étant le titre des colonnes
			
					
	

					//Iterator<Row> lignes = feuille1.iterator();
					//Row ligne1 = lignes.next();
					

					
					//Iterator<Cell> ce = ligne1.cellIterator();

					//int k = 0;
					
					//while (ce.hasNext()) {
						try {
							page2.OuvrirPageFormulaire(declaration_constante.BaseURLFormulaire);
						} catch (Exception e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					

						// On commence à la 2ème ligne. La première ligne étant le titre des colonnes
						int i = 1; 
					
							//page2.OuvrirPageFormulaire(declaration_constante.BaseURLFormulaire);

								//String donneeLigne = feuille1.getRow(i).getCell(0).getStringCellValue();
								
								String Siret = feuille1.getRow(i).getCell(1).getStringCellValue();
								
								String nom = feuille1.getRow(i).getCell(2).getStringCellValue();
								String prenom = feuille1.getRow(i).getCell(3).getStringCellValue();
								String Mail = feuille1.getRow(i).getCell(4).getStringCellValue();
								String telephone = feuille1.getRow(i).getCell(5).getStringCellValue();
								
								Declaration_Variables_Globales.driver.findElement(By.xpath("//a[@id='cn-accept-cookie']")).click();
								Declaration_Variables_Globales.driver.findElement(By.xpath("//input[@id='txtSiret']")).sendKeys(Siret);
								Declaration_Variables_Globales.driver.findElement(By.xpath("//input[@id='txtNom']")).sendKeys(nom);
								Declaration_Variables_Globales.driver.findElement(By.xpath("//input[@id='txtPrenom']")).sendKeys(prenom);
								Declaration_Variables_Globales.driver.findElement(By.xpath("//input[@id='txtTelephone']")).sendKeys(telephone);
								// driver.findElement(By.xpath("//input[@id='TelephonePortable']")).sendKeys("");
								Declaration_Variables_Globales.driver.findElement(By.xpath("//input[@id='txtMel']")).sendKeys(Mail);
								Declaration_Variables_Globales.driver.findElement(By.xpath("//input[@id='txtConfirmationMel']")).sendKeys(Mail);

								Declaration_Variables_Globales.driver.findElement(By.xpath("//*[@id='validButtonInscription']")).click();
								
								String message = Declaration_Variables_Globales.driver.findElement(By.xpath("//*[@id=\'coordonneesADForm\']/div[3]/div/div"))
										.getText();
								System.out.println(message);
							}
						
						
					
					
				

			

  

	
	
	
  

}