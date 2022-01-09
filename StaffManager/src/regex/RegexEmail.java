package regex;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegexEmail {

    private static final String EMAIL_REGEX = "^[a-z0-9]{4,}@[a-z]+\\.+com$";
    private static final Pattern pattern =Pattern.compile(EMAIL_REGEX);

    public static boolean validate(String email) {
        Matcher matcher = pattern.matcher(email);
        return matcher.matches();
    }
}
