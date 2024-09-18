package org.example.teamrestaurant;
import org.example.teamerestaurant.cardInfo;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.IOException;

public class onlineOrderTest {
    @Test
    public void cardNumberIncorrect(){
        cardInfo cardNumber = new cardInfo();
        boolean result = Boolean.parseBoolean(cardNumber.returnNumberOutput("12342345345645"));
        Assertions.assertFalse(result);
    }

    @Test
    public void cardNumberCorrect(){
        cardInfo cardNumber = new cardInfo();
        String result = cardNumber.returnNumberOutput("4012-8888-8888-1881");
        Assertions.assertTrue(result.contains("Valid credit card number."));
        //need to go back and double check code, says is incorrect when it's not
    }

    @Test
    public void incorrectExpirationDate(){
        cardInfo expirationDate = new cardInfo();
        boolean result = Boolean.parseBoolean(expirationDate.returnExpirationOutput(22, 05));
        Assertions.assertFalse(result);
    }

    @Test
    public void correctExpirationDate(){
        cardInfo expirationDate = new cardInfo();
        String result = expirationDate.returnExpirationOutput(2025, 05);
        Assertions.assertTrue(result.contains("Valid credit card expiration date."));
    }
    @Test
    public void incorrectSecurity(){
        cardInfo securityNum = new cardInfo();
        boolean result = Boolean.parseBoolean((securityNum.returnSecurityOutput("14")));
        Assertions.assertFalse(result);
    }

    @Test
    public void correctSecurity(){
        cardInfo securityNum = new cardInfo();
        String result = securityNum.returnSecurityOutput("144");
        Assertions.assertTrue(result.contains("Valid credit card security number."));
    }


}
