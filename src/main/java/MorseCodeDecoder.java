import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class MorseCodeDecoder {
    private static final Map<String, String> MorseCode = new HashMap<String, String>(){{
        put(".-","A");
        put("-...","B");
        put("-.-.","C");
        put("-..","D");
        put(".","E");
        put("..-.","F");
        put("--.","G");
        put("....","H");
        put("..","I");
        put(".---","J");
        put("-.-","K");
        put(".-..","L");
        put("--","M");
        put("-.","N");
        put("---","O");
        put(".--.","P");
        put("--.-","Q");
        put(".-.","R");
        put("...","S");
        put("-","T");
        put("..-","U");
        put("...-","V");
        put(".--","W");
        put("-..-","X");
        put("-.--","Y");
        put("--..","Z");
    }};

    public static String decode(String morseCode) {
        return Stream.of(morseCode.trim().split("   "))
                .map(word -> Stream.of(word.split(" ")).map(letter -> MorseCode.get(letter)).collect(Collectors.joining()))
                .collect(Collectors.joining(" "));
    }
}
