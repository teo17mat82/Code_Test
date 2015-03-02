package bcsg.test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import bcsg.test.ETL.CsvDataExtraction;
import bcsg.test.service.CardsServices;

public class CSV_Test {

	public static void main(String[] args) {
		
		ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
		
		CardsServices cardsServ = (CardsServices) context.getBean("CardsServices");
		CsvDataExtraction dataExtract=(CsvDataExtraction) context.getBean("CsvDataExtraction");
		String inputfile="file/mid-test.csv";
		
		
		cardsServ.fillCardsList(dataExtract.readInputFile(inputfile));
		
		cardsServ.printingDescendingOrderList();
		
	}

}
