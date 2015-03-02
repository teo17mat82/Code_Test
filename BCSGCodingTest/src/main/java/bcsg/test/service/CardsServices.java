package bcsg.test.service;

import java.util.ArrayList;
import java.util.Collections;

import bcsg.test.model.Card;

public class CardsServices {
	
	private ArrayList<Card> cardsList=new ArrayList();
	
	public ArrayList<Card> getCardsList(){
		return cardsList;
	}
	
	public void fillCardsList(ArrayList<Card> a){
		cardsList=a;
	}
	
	public void setDescendingOrder(){
		Collections.sort(cardsList,Collections.reverseOrder());
	}
	
	public void printingDescendingOrderList(){
		
		setDescendingOrder();
		
		for(Card c:cardsList){
			System.out.println(c.getBankName()+" "+c.maskCardNumber());
		}
	}

}
