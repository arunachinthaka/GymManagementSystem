package Components;

import java.util.regex.Pattern;

public class phoneAndMailValidate {

    private static final String REGEX = "^(?:0|\\+94)?[7-9]{1}[0-9]{8}$";

    public static boolean isValid(String phoneNumber) {
        return Pattern.matches(REGEX, phoneNumber);
    }
    

    private static final Pattern EMAIL_PATTERN = Pattern.compile(
        "^[a-zA-Z0-9_.+-]+@[a-zA-Z0-9-]+\\.[a-zA-Z0-9-.]+$"
    );

    public static boolean isValidEmail(String email) {
    if(EMAIL_PATTERN.matcher(email).matches()){
        return true;
    }else if (email.equals("Null")||email.equals("null")){
         return true;
    }else{
        return false;
    }
    }
}
