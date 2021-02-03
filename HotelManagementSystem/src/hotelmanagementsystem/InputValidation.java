package hotelmanagementsystem;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class InputValidation {
    
    public static boolean isWord(String input){
        return Pattern.matches("[a-zA-Z]+", input);
    }
}
