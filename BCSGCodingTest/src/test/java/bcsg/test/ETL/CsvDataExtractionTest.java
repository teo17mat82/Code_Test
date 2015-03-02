package bcsg.test.ETL;

import static org.junit.Assert.*;

import org.junit.Test;



public class CsvDataExtractionTest {

	@Test
	public void test() {
		CsvDataExtraction t = new CsvDataExtraction();
		
		// Tests
		assertNotEquals(null,t.readInputFile(""));
		
		assertNotEquals(null,t.readInputFile("file/mid-test.csv"));
		assertNotEquals(0,t.readInputFile("file/mid-test.csv"));
	}

}
