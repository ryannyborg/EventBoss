package org.system.people;

public class PaymentInfo {
	//attributes
	String cardCompany;
	String cardType;
	long cardNumber;
	int securityCode;
	int expMonth;
	int expYear;
	
	public PaymentInfo(){
		this.cardCompany = "NULL";
		this.cardType = "NULL";
		this.cardNumber = -1;
		this.securityCode = -1;
		this.expMonth = -1;
		this.expYear = -1;
	}
	
	public PaymentInfo(String cardCompany, String cardType, long cardNumber, int securityCode, int expMonth,
			int expYear) {
		this.cardCompany = cardCompany;
		this.cardType = cardType;
		this.cardNumber = cardNumber;
		this.securityCode = securityCode;
		this.expMonth = expMonth;
		this.expYear = expYear;
	}

	public String getCardCompany() {
		return cardCompany;
	}
	public void setCardCompany(Object object) {
		this.cardCompany = object.toString();
	}
	public String getCardType() {
		return cardType;
	}
	public void setCardType(Object object) {
		this.cardType = object.toString();
	}
	public long getCardNumber() {
		return cardNumber;
	}
	public void setCardNumber(long cardNumber) {
		this.cardNumber = cardNumber;
	}
	public int getSecurityCode() {
		return securityCode;
	}
	public void setSecurityCode(int securityCode) {
		this.securityCode = securityCode;
	}
	public int getExpMonth() {
		return expMonth;
	}
	public void setExpMonth(int expMonth) {
		this.expMonth = expMonth;
	}
	public int getExpYear() {
		return expYear;
	}
	public void setExpYear(int expYear) {
		this.expYear = expYear;
	}

	
	
}
