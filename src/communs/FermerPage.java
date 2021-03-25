package communs;



import org.testng.annotations.Test;

import communs.Declaration_Variables_Globales;

public class FermerPage {


	@Test( priority =5)
	public void CloseBrowser() throws Exception {
		System.out.println("CloseBrowser -- Start");
		Declaration_Variables_Globales.driver.quit();
		System.out.println("CloseBrowser -- End");
	
	
}
}