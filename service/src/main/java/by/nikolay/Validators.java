package by.nikolay;

import com.sun.source.tree.PatternTree;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Validators {


    public static boolean isValidEmail(String email) {
        Pattern emailPatter = Pattern.compile("^[A-Z0-9._%+-]+@[A-Z0-9.-]+\\.[A-Z]{2,6}$", Pattern.CASE_INSENSITIVE);
        Matcher emailMatch = emailPatter.matcher(email);
        if (emailMatch.find()) {
            return true;
        }
        return false;
    }


    public static boolean isValidPassword(char[] password) {
//Minimum eight characters, at least one letter and one number:
        Pattern pattern = Pattern.compile("^(?=.*[A-Za-z])(?=.*\\d)[A-Za-z\\d]{8,}$");
        Matcher matcher = pattern.matcher(String.copyValueOf(password));
        if (matcher.find()) {
            return true;
        }
        return false;
    }
}
