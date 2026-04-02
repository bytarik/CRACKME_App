package com.byrootd.crackme_app;

public class NativeGate {


    public static int verifyAccess(String input) {

        if (input.length() != SecretVault.OBFUSCATED_KEY.length) {
            return 0;
        }


        try {
            for (int i = 0; i < input.length(); i++) {
                int originalChar = (int) input.charAt(i);


                int transformed = (originalChar ^ SecretVault.XOR_KEY) + SecretVault.SUB_VALUE;


                if (transformed != SecretVault.OBFUSCATED_KEY[i]) {
                    return 0;
                }
            }

            // Tüm karakterler doğruysa 1 döndür
            return 1;

        } catch (Exception e) {
            return 0;
        }
    }
}