package ac.at.fhcampuswien;

import org.junit.Test;
import org.junit.jupiter.api.DisplayName;

import static org.junit.jupiter.api.Assertions.*;

public class AppTest {
    private static final String VALID_PASSWORD_REGEX_LENGTH =  "^.{8,25}$";
    private static final String VALID_PASSWORD_REGEX_LETTERS =  "^(?=.*[a-z])(?=.*[A-Z])[a-zA-Z0-9]*$";
    private static final String VALID_PASSWORD_REGEX_NUMBERS =  "^(?=.*[0-9])[a-zA-Z0-9]*$";
    private static final String VALID_PASSWORD_REGEX_SYMBOLS =  ".*[()#$?!%/@].*";

    App a1 = new App();

    @Test
    @DisplayName("In this test case the password length is checked; max min 8 max 25 characters;")
    public void checkPasswordLength(){
        a1.setPassword("123456556655655678");
        boolean actual = a1.password.matches(VALID_PASSWORD_REGEX_LENGTH);

        assertTrue(actual);
    }

    @Test
    @DisplayName("In this test case the password is checked for upper and lower case letters;")
    public void checkPasswordLetters(){
        a1.setPassword("Aasdd2324esadd3");
        boolean actual = a1.password.matches(VALID_PASSWORD_REGEX_LETTERS);

        assertTrue(actual);
    }

    @Test
    @DisplayName("In this test case the password is checked for numbers;")
    public void checkPasswordNumbers(){
        a1.setPassword("nonumbera8ddedtothis");
        boolean actual = a1.password.matches(VALID_PASSWORD_REGEX_NUMBERS);

        assertTrue(actual);
    }

    @Test
    @DisplayName("In this test case the password is checked for specific symbols;")
    public void checkPasswordSymbols(){
        a1.setPassword("nonumbera!ddedtothis");
        boolean actual = a1.password.matches(VALID_PASSWORD_REGEX_SYMBOLS);

        assertTrue(actual);
    }

    @Test
    @DisplayName("In this test case the password is checked for increasing numbers;")
    public void checkIncreasingNumbers(){
        a1.setPassword("nonumbera!ddedtothis");
        boolean actual = true;
        int count = 0;

        for (int i = 0; i < a1.password.length(); i++) {
            if (Character.isDigit(a1.password.charAt(i))){
                for (int j = i + 1; j < a1.password.length(); j++) {
                    if (count < 2) {
                        if (Character.getNumericValue(a1.password.charAt(i)) == Character.getNumericValue(a1.password.charAt(j)) - 1) {
                            count++;
                            break;
                        }
                    }
                }
            }
        }
        assertTrue(count < 2);
    }

    @Test
    @DisplayName("In this test case the password is checked for consecutive numbers;")
    public void checkConsecutiveNumbers(){
        a1.setPassword("nonu12456777mbera!ddedtothis");
        boolean actual = true;
        int count = 0;

        for (int i = 0; i < a1.password.length(); i++) {
            if (Character.isDigit(a1.password.charAt(i))){
                for (int j = i + 1; j < a1.password.length(); j++) {
                    if (count < 3) {
                        if (Character.getNumericValue(a1.password.charAt(i)) == Character.getNumericValue(a1.password.charAt(j))) {
                            count++;
                            break;
                        }
                    }
                }
            }
        }
        assertTrue(count < 3);
    }
}