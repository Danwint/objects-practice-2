package com.techelevator;

import static com.techelevator.CreditCardNumber.TYPE_AMEX;
import static com.techelevator.CreditCardNumber.TYPE_DISCOVER;
import static com.techelevator.CreditCardNumber.TYPE_MASTERCARD;
import static com.techelevator.CreditCardNumber.TYPE_VISA;
import static org.junit.Assert.*;

import org.junit.Test;

public class CreditCardNumberTest {

	@Test
	public void factory_method_returns_object_when_account_number_is_valid() {
		
		CreditCardNumber ccn = CreditCardNumber.valueOf("4111111111111111");
		assertNotNull("Account Number: 4111111111111111", ccn);
		
		ccn = CreditCardNumber.valueOf("371449635398431");
		assertNotNull("Account Number: 371449635398431", ccn);
		
		ccn = CreditCardNumber.valueOf("6011000990139424");
		assertNotNull("Account Number: 6011000990139424", ccn);
	}
	
	@Test
	public void contains_the_account_number() {
		
		CreditCardNumber ccn = CreditCardNumber.valueOf("4111111111111111");
		String accountNumber = ccn.getAccountNumber();
		assertEquals("4111111111111111", accountNumber);
		
		ccn = CreditCardNumber.valueOf("371449635398431");
		accountNumber = ccn.getAccountNumber();
		assertEquals("371449635398431", accountNumber);
		
		ccn = CreditCardNumber.valueOf("6011000990139424");
		accountNumber = ccn.getAccountNumber();
		assertEquals("6011000990139424", accountNumber);
	}
	
	@Test
	public void returns_visa_type_for_valid_visa_card_number() {
		
		CreditCardNumber ccn = CreditCardNumber.valueOf("4111111111111111");
		assertEquals("Visa Number 4111111111111111", TYPE_VISA, ccn.getCardType());
		
		ccn = CreditCardNumber.valueOf("4012888888881881");
		assertEquals("Visa Number 4012888888881881", TYPE_VISA, ccn.getCardType());
		
		ccn = CreditCardNumber.valueOf("4222222222222");
		assertEquals("Visa Number 4222222222222", TYPE_VISA, ccn.getCardType());
	}
	
	@Test
	public void returns_mastercard_type_for_valid_mastercard_card_number() {
		
		CreditCardNumber ccn = CreditCardNumber.valueOf("5555555555554444");
		assertEquals("Mastercard Number 5555555555554444", TYPE_MASTERCARD, ccn.getCardType());
		
		ccn = CreditCardNumber.valueOf("5105105105105100");
		assertEquals("Mastercard Number 5105105105105100", TYPE_MASTERCARD, ccn.getCardType());
	}
	
	@Test
	public void returns_american_express_type_for_valid_american_express_card_number() {
		
		CreditCardNumber ccn = CreditCardNumber.valueOf("378282246310005");
		assertEquals("American Express Number 378282246310005", TYPE_AMEX, ccn.getCardType());
		
		ccn = CreditCardNumber.valueOf("371449635398431");
		assertEquals("American Express Number 371449635398431", TYPE_AMEX, ccn.getCardType());
	}
	
	@Test
	public void returns_discover_card_type_for_valid_discover_card_number() {
		
		CreditCardNumber ccn = CreditCardNumber.valueOf("6011111111111117");
		assertEquals("Discover Number 6011111111111117", TYPE_DISCOVER, ccn.getCardType());
		
		ccn = CreditCardNumber.valueOf("6011000990139424");
		assertEquals("Discover Number 6011000990139424", TYPE_DISCOVER, ccn.getCardType());
	}
	
	@Test
	public void returns_null_for_invalid_length_visa_card_number() {
		
		CreditCardNumber ccn = CreditCardNumber.valueOf("41111111111111113");
		assertNull("Invalid 17 digit visa card number 41111111111111113", ccn);
		
		ccn = CreditCardNumber.valueOf("41111111111114");
		assertNull("Invalid 14 digit visa card number 41111111111114", ccn);
		
		ccn = CreditCardNumber.valueOf("411111111117");
		assertNull("Invalid 12 digit visa card number 411111111117", ccn);
	}
	
	@Test
	public void returns_null_for_invalid_length_mastercard_card_number() {
		
		CreditCardNumber ccn = CreditCardNumber.valueOf("55555555555544432");
		assertNull("Invalid 17 digit master card number 55555555555544432", ccn);
		
		ccn = CreditCardNumber.valueOf("510510510510515");
		assertNull("Invalid 15 digit master card number 510510510510515", ccn);
	}
	
	@Test
	public void returns_null_for_invalid_length_american_express_card_number() {
		
		CreditCardNumber ccn = CreditCardNumber.valueOf("37828224631003");
		assertNull("Invalid 14 digit american express card number 37828224631003", ccn);
		
		ccn = CreditCardNumber.valueOf("3714496353984314");
		assertNull("Invalid 16 digit american express card number 3714496353984314", ccn);
	}
	
	@Test
	public void returns_null_for_unknown_card_number_prefix() {
		
		CreditCardNumber ccn = CreditCardNumber.valueOf("30569309025904");
		assertNull("Credit card number with unknown prefix 30569309025904", ccn);
		
		ccn = CreditCardNumber.valueOf("5610591081018250");
		assertNull("Credit card number with unknown prefix 5610591081018250", ccn);
	}

	/*
	@Test
	public void factory_method_returns_null_when_account_number_does_not_pass_Luhn_check() {
		
		CreditCardNumber ccn = CreditCardNumber.valueOf("4111111111111112");
		assertNull("Account Number: 4111111111111112", ccn);
		
		ccn = CreditCardNumber.valueOf("371449625398431");
		assertNotNull("Account Number: 371449625398431", ccn);
		
		ccn = CreditCardNumber.valueOf("6011000980139424");
		assertNotNull("Account Number: 6011000980139424", ccn);
	}
	*/
}
