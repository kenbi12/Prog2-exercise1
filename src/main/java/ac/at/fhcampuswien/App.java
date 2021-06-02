package ac.at.fhcampuswien;//mit Imran Kambal gelöst!!!

public class App {
    private static final String VALID_PASSWORD_REGEX = "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[()#$?!%/@]).{8,25}$";
    public static boolean checkPassword(String password){
        boolean consecutive = true, increasing = true;
        int increase_count = 0, consecutive_count = 0;

        if(!password.matches(VALID_PASSWORD_REGEX))
            return false;
        else {
            for (int i = 0; i < password.length(); i++) {
                if (Character.isDigit(password.charAt(i))) {
                    for (int j = i + 1; j < password.length(); j++) {
                        if (increase_count < 2) {
                            if (Character.getNumericValue(password.charAt(i)) == Character.getNumericValue(password.charAt(j)) - 1) {
                                increase_count++;
                                break;
                            }
                        }
                        else {
                            increasing = false;
                            increase_count = 0;
                        }
                    }
                    if (Character.isDigit(password.charAt(i))){
                        for (int j = i + 1; j < password.length(); j++) {
                            if (consecutive_count < 3) {
                                if (Character.getNumericValue(password.charAt(i)) == Character.getNumericValue(password.charAt(j))) {
                                    consecutive_count++;
                                    break;
                                }
                            }
                            else {
                                consecutive = false;
                                consecutive_count = 0;
                            }

                        }
                    }
                }
            }
            return consecutive & increasing;
        }
    }
}