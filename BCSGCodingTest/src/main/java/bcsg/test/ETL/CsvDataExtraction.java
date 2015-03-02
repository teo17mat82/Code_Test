package bcsg.test.ETL;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

import bcsg.test.commons.CardEncription;
import bcsg.test.model.Card;

public class CsvDataExtraction extends DataExtraction {

	BufferedReader bruffer = null; 
	String line = "";
	String splitBy = ",";
	SimpleDateFormat formatter = new SimpleDateFormat("MMM-yyyy");
	
	@Override
	public ArrayList readInputFile(String uri) {
		
		ArrayList l=new ArrayList();  
		ClassLoader classLoader = getClass().getClassLoader();
		try {			  
				 bruffer = new BufferedReader(new FileReader(classLoader.getResource(uri).getFile()));  
				 while ((line = bruffer.readLine()) != null) {  
					   
					   String[] cardData = line.split(splitBy);   
					   //matching data
					   Card t=new Card();
					   t.setBankName(cardData[0]);
					   t.setNumber(cardData[1]);

					   if(cardData[0].equalsIgnoreCase("HSBC Canada"))
						   t.setEncriptionType(CardEncription.T1);
					   else if(cardData[0].equalsIgnoreCase("Royal Bank of  Canada"))
						   t.setEncriptionType(CardEncription.T2);
					   else if(cardData[0].equalsIgnoreCase("American Express"))
						   t.setEncriptionType(CardEncription.T3);
					   else
						   t.setEncriptionType(CardEncription.DEFAULT);
					   
					   try {
						t.setExpairingDate(formatter.parse(cardData[2]));
					   } catch (ParseException e) {
						   e.printStackTrace();
					   }
					   l.add(t);
				   }  
				  
				  } catch (FileNotFoundException e) {  
				   e.printStackTrace();  
				  } catch (IOException e) {  
				   e.printStackTrace();  
				  }
		 
		 return l;
	}

}
