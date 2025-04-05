import java.util.Base64;
import java.util.HashMap;
import java.util.Random;

public class Codec {

    // Encodes a URL to a shortened URL.

    public static final String Base_URL = "http://tinyurl.com/";
    public static final String Alphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";
    public static final Integer CODE_LENGTH = 6;
    public static final Integer ALPHABET_LENGTH = Alphabet.length();
    private HashMap<String, String> map = new HashMap<>();
    Random random = new Random();


    public String encode(String longUrl) {
        // Extract BaseURL

        String coder = new String();
        coder = GenerateString();
        if(map.containsKey(coder)){
            coder = GenerateString();
        }
        map.put(coder, longUrl);

        return Base_URL +  coder; 
    }

    // Decodes a shortened URL to its original URL.
    public String decode(String shortUrl) {
        String code = shortUrl.replace(Base_URL, "");
        if(map.containsKey(code)){
            return map.get(code);
        }
        return null;
    }

    // Generate a random string of 6 characters

    public String GenerateString(){
        StringBuilder sb = new StringBuilder();
        Random random = new Random();
        for(int i = 0; i  < CODE_LENGTH; i++){
            int index = random.nextInt(ALPHABET_LENGTH);
            sb.append(Alphabet.charAt(index));
        }
        return sb.toString(); 
    }

    public static void main(String[] args){
        Codec codec = new Codec();
        String outputEncode = new String ();
        outputEncode = codec.encode("https://leetcode.com/problems/design-tinyurl");
        codec.decode("https://tinyurl.com/4e9iAk");
        System.out.println(outputEncode);
    }
}