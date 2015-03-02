package bcsg.test.model;

import java.util.Date;

import bcsg.test.commons.*;

public class Card implements Comparable<Card>{
	
	private String number;
	private Date expairingDate;
	private CardEncription encriptionType;
	private String bankName;
	
	
	public String getNumber() {
		return number;
	}
	public void setNumber(String number) {
		this.number = number;
	}
	public Date getExpairingDate() {
		return expairingDate;
	}
	public void setExpairingDate(Date expairingDate) {
		this.expairingDate = expairingDate;
	}
	public CardEncription getEncriptionType() {
		return encriptionType;
	}
	public void setEncriptionType(CardEncription encriptionType) {
		this.encriptionType = encriptionType;
	}
	public String getBankName() {
		return bankName;
	}
	public void setBankName(String bankName) {
		this.bankName = bankName;
	}
	
	public String maskCardNumber(){	
			String mask=this.getNumber();
			switch(this.getEncriptionType()){
				case T1:
					mask=mask.substring(0,2)+mask.substring(2).replaceAll("[0-9]", "X");
					break;
				case T2:
					mask=mask.substring(0,5)+mask.substring(5).replaceAll("[0-9]", "X");
					break;
				case T3:
					mask=mask.substring(0,15).replaceAll("[0-9]", "X")+mask.substring(15);
					break;
				case DEFAULT:
				default:
					mask=mask.replaceAll("[0-9]", "X");
					break;
								
			}
			return mask;
		}
	
	@Override
	public int compareTo(Card target) {
		return this.getExpairingDate().compareTo(target.getExpairingDate());
		
	}
	

}
