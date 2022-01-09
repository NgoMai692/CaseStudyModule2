package regex;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegexPhoneNumber {

    private static final String PHONE_REGEX = "^[0][0-9]{9}$";
    private static final Pattern pattern =  Pattern.compile(PHONE_REGEX);

    public static boolean validate(String phoneNumber) {
        Matcher matcher = pattern.matcher(phoneNumber);
        return matcher.matches();
    }
}
