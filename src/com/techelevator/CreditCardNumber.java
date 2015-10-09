package com.techelevator;

public class CreditCardNumber {

	public static final String TYPE_VISA = "VI";
	public static final String TYPE_MASTERCARD = "MC";
	public static final String TYPE_AMEX = "AX";
	public static final String TYPE_DISCOVER = "DS";
	private String validAccountNumber;
	private String cardType;

	private CreditCardNumber(String accountNumber) {
		
		cardType = accountNumber.substring(0, 2);
		validAccountNumber = accountNumber.substring(2);

	}
	
	public static CreditCardNumber valueOf(String accountNumber) {
		
		String ccType;
		int accNumLength = accountNumber.length();
		char firstDigitAccNumber = accountNumber.charAt(0);
		char secondDigitAccNumber = accountNumber.charAt(1);
		int valueOfFirstSixDigits = Integer.valueOf(accountNumber.substring(0, 6));
		int valueOfFirstFourDigits = Integer.valueOf(accountNumber.substring(0, 4));
		int valueOfFirstThreeDigits = Integer.valueOf(accountNumber.substring(0, 3));
		if (firstDigitAccNumber == '4' && (accNumLength == 16 || accNumLength == 13)) {
			ccType = TYPE_VISA;
		} else if (firstDigitAccNumber == '5' && secondDigitAccNumber > '0' && secondDigitAccNumber < '6' && accNumLength == 16) {
			ccType = TYPE_MASTERCARD;
		} else if (firstDigitAccNumber == '3' && (secondDigitAccNumber == '4' || secondDigitAccNumber == '7') && accNumLength == 15) {
			ccType = TYPE_AMEX;
		} else if ((valueOfFirstSixDigits >= 622126 && valueOfFirstSixDigits <= 622925) || (valueOfFirstFourDigits == 6011) || 
				(valueOfFirstThreeDigits >= 644 && valueOfFirstThreeDigits <= 659) && accNumLength == 16) {
			ccType = TYPE_DISCOVER;
		} else {
			return null;
		}
		return new CreditCardNumber(ccType + accountNumber);
	}

	/**
	 * @return the credit card type that this number belongs to (e.g. Visa, MasterCard, etc)
	 */
	public String getCardType() {
		
		return cardType;
	}

	/**
	 * @return the account number string that was used to create this CreditCardNumber object
	 */
	public String getAccountNumber() {
		
		return validAccountNumber;
	}

}
