package com.techelevator;

public class CreditCardNumber {

	public static final String TYPE_VISA = "VI";
	public static final String TYPE_MASTERCARD = "MC";
	public static final String TYPE_AMEX = "AX";
	public static final String TYPE_DISCOVER = "DS";

	private CreditCardNumber(String accountNumber) {
		
	}
	
	public static CreditCardNumber valueOf(String accountNumber) {
		return null;
	}

	/**
	 * @return the credit card type that this number belongs to (e.g. Visa, MasterCard, etc)
	 */
	public String getCardType() {
		return null;
	}

	/**
	 * @return the account number string that was used to create this CreditCardNumber object
	 */
	public String getAccountNumber() {
		return null;
	}

}
