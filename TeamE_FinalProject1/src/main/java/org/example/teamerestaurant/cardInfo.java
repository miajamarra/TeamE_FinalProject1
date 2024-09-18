package org.example.teamerestaurant;
import java.time.YearMonth;

public class cardInfo {

    public String returnNumberOutput(String cardNumber){
        if (validateCardNumber(cardNumber)) {
            return "Valid credit card number.";
        } else {
            return "Invalid credit card number";
        }
    }

    public static String returnExpirationOutput(int expYear, int expMonth){
        if (validateCardExpiration(expYear, expMonth)) {
            return "Valid credit card expiration date.";
        } else {
            return "Invalid or null credit card expiration date";
        }
    }

    public static String returnSecurityOutput(String securityInput){
        if (validateCardSecurityNum(securityInput)) {
            return "Valid credit card security number.";
        } else {
            return "Invalid credit card security number.";
        }
    }

//checking validity of input

    public static boolean validateCardSecurityNum(String securityInput){
        return securityInput != null && securityInput.matches("[0-9]+") && (securityInput.length() == 3);
    }


    public static boolean validateCardExpiration(int expYear, int expMonth){
        YearMonth currentMonthAndYear = YearMonth.now();

        YearMonth expirationYearMonth = YearMonth.of(expYear, expMonth);
        return expirationYearMonth.isAfter(currentMonthAndYear);
    }


    public static boolean validateCardNumber(String cardNumber){
        cardNumber = cardNumber.replaceAll("[^0-9]", "");
        if(!cardNumber.matches("[0-9]+") || cardNumber.length()<13 ||cardNumber.length()>19){
            return false;
        }
        int sum = 0;
        boolean alternate = false;
        for(int i = cardNumber.length() - 1; i >= 0; i--){
            int number = Integer.parseInt(cardNumber.substring(i, i + 1));
            if(alternate){
                number *= 2;
                if(number > 9){
                    number = (number%10) +1;
                }
            }
            sum += number;
            alternate = !alternate;
        }
        return (sum % 10 == 0);
    }
}