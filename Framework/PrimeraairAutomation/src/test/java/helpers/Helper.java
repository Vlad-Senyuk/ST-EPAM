package helpers;

import java.util.Random;

public class Helper {
    private static String symbols = "qwertyuiopasdfghjklzxcvbnm1234567890";

    public static String getRandomString(int length){
        StringBuilder randomString = new StringBuilder();
        Random random = new Random();

        for (int i = 0; i < length; i++) {
            randomString.append(symbols.charAt(random.nextInt(symbols.length())));
        }

        return randomString.toString();
    }
}
