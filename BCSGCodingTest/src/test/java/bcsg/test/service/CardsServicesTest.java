package bcsg.test.service;

import static org.junit.Assert.*;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

import org.junit.Test;

import bcsg.test.model.Card;

public class CardsServicesTest {
	private CardsServices c;
	private ArrayList list=new ArrayList();
	private SimpleDateFormat formatter = new SimpleDateFormat("MMM-yyyy");
	
	public void setUp() { 
		c=new CardsServices();
		Card a=new Card();
		Card b=new Card();
		
		a.setBankName("a");
		b.setBankName("b");
		
		try {
			a.setExpairingDate(formatter.parse("Oct-2000"));
			b.setExpairingDate(formatter.parse("Oct-2002"));
		   } catch (ParseException e) {
			   e.printStackTrace();
		   }
		list.add(a);
		list.add(b);
		
	   }

	
	@Test
	public void test() {
		setUp();
		
		assertEquals( 0, c.getCardsList().size());
		assertNotEquals(null,c.getCardsList());
		
	}
	
	@Test
	public void testOrder() {
		setUp();
		c.fillCardsList(list);
		
		assertNotEquals( 0, c.getCardsList().size());
		assertNotEquals(null,c.getCardsList());
		
		assertEquals("a", c.getCardsList().get(0).getBankName());
		assertEquals("b", c.getCardsList().get(1).getBankName());
		c.setDescendingOrder();
		assertEquals("b", c.getCardsList().get(0).getBankName());
		assertEquals("a", c.getCardsList().get(1).getBankName());
		
	}
	

}
