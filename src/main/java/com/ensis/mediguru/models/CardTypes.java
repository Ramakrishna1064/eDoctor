package com.ensis.mediguru.models;

public class CardTypes {

	int paymenttypeid;
	String cardType;

	public CardTypes(int paymenttypeid, String cardType) {
		super();
		this.paymenttypeid = paymenttypeid;
		this.cardType = cardType;
	}

	public int getPaymenttypeid() {
		return paymenttypeid;
	}

	public void setPaymenttypeid(int paymenttypeid) {
		this.paymenttypeid = paymenttypeid;
	}

	public String getCardType() {
		return cardType;
	}

	public void setCardType(String cardType) {
		this.cardType = cardType;
	}

}
