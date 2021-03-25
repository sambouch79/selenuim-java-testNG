package modules;


import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.xssf.usermodel.XSSFSheet;

public class ExcelTools {
	
	
	 public static String getCell (XSSFSheet feuille1 , int irow, int icol) {

	    	String retValue;
	    	retValue="";
	    	
	    	@SuppressWarnings("deprecation")
			CellType typecell=feuille1.getRow(irow).getCell(icol).getCellTypeEnum();	    	
	    		    	
	    	switch(typecell){
	    	case BLANK:
	    		retValue= "";
	    		break;
	    	case STRING:
	    		retValue= feuille1.getRow(irow).getCell(icol).getStringCellValue();
	    		break;
	    	case NUMERIC:
	    		Double d = feuille1.getRow(irow).getCell(icol).getNumericCellValue();
	    		int n=d.intValue();
	    		retValue= Integer.toString(n);
	    		break;
		    default: 
		    	retValue= "??";
		    }
	    	
	    	if (retValue.equals(new String("<VIDE>")))  {
	    		System.out.println("<VIDE> coverti en chaine vide");
	    		retValue="";
	    	}
	    	
	    	System.out.println("CellValue(" + irow + "," + icol + ") : " + retValue);
	    	return retValue;
	    	
	    }

}
