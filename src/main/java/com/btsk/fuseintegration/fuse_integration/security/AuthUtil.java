package com.btsk.fuseintegration.fuse_integration.security;

import java.security.KeyFactory;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.spec.PKCS8EncodedKeySpec;
import java.security.spec.X509EncodedKeySpec;
import java.util.Base64;

import javax.crypto.Cipher;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class AuthUtil {
    private static final String PUBLIC_KEY = "";
    private static final String PRIVATE_KEY = "MIICdgIBADANBgkqhkiG9w0BAQEFAASCAmAwggJcAgEAAoGBALna9sp5HaJM+ik8Ct8WLkOKNYBSDvA5brLDbULPuB4j2x+93G25EsLxt0VY/jgWi1r5VLx+b5TN5Jc+dFr9ecB0m/FgQtw7pbkztasp3M2Q3oJUfOMGyHJnA2+p3pzIO4PZ63bqQHPfIFoLJvoU9TSY1HoRGx4tLxZiwXeArWNPAgMBAAECgYA+R2KVnJpSjarycF1QPjWIimK9OkIpO4Wdv6D4V3TiHK/L5ipcVj00OB1qzpR5pQxTkuNTOqcXXRsxl0sURoYqZVJTRSIM/mtbeYWcbK07jJ9s7XLADFL/Cju2Akr/C6utQA2WJg/E4EuSkDdiC7zeekbLfNuwR084b7DOmnIssQJBAMBq3BZhGZMErTH9S+OsdYvGRgBeNaDV7M9RrX8hRQc0VgtOuD1/zrMbq74ueJMCKh9409qKaDa/MabHprZ4TskCQQD3RP+FA6VY8v8+YeOo4ZkUV6S6/DafuBS3Ag+Xx4bvE5g3MHvQb4ZQpq4j0nFQiUYw+fFbv8fAVLxPCb9QIzVXAkBLXg/S3DmuMli8ieBdz0FDfGgS4NPUqbZWBkIU1604AzHov+6+d/84fJAqr/0eZ+yj4ynoIepr9zu1feI4+qqxAkEAkx2qKSmSJunskuEK4l/XBBNhHx8QINcU/A1t2ZAM6BFwbuWZxNmVwEZrNUTvxkrmSB1tTHk+D2Ba6WuTN8q64QJAP8N3SZ+7n9lQePd8y1NIVa3vAa5yzKS1OEpuMt9k92faIg+6gc9uiVjQOn5WM8CurRM4yyOg+6EGsZg8LluPrw==";

    private AuthUtil() {
    }

    public static String encrypt(String text) throws Exception {
        X509EncodedKeySpec spec = new X509EncodedKeySpec(Base64.getMimeDecoder().decode(PUBLIC_KEY));

        KeyFactory keyFactory = KeyFactory.getInstance("RSA");
        PublicKey pkey = keyFactory.generatePublic(spec);
        Cipher cipher = Cipher.getInstance("RSA");
        cipher.init(Cipher.ENCRYPT_MODE, pkey);
        byte[] result = cipher.doFinal(text.getBytes());
        return Base64.getEncoder().encodeToString(result);
    }

    public static boolean decrypt(String expectedText, String encryptedText) {
        PKCS8EncodedKeySpec spec = new PKCS8EncodedKeySpec(Base64.getMimeDecoder().decode(PRIVATE_KEY));

        try {
            KeyFactory keyFactory = KeyFactory.getInstance("RSA");
            PrivateKey privateKey = keyFactory.generatePrivate(spec);
            Cipher cipher = Cipher.getInstance("RSA");
            cipher.init(Cipher.DECRYPT_MODE, privateKey);
            byte[] encryptedData = Base64.getMimeDecoder().decode(encryptedText);
            byte[] decryptedData = cipher.doFinal(encryptedData);
            System.out.println("decryptedData " + new String(decryptedData));
            System.out.println("expectedText " + expectedText);

            return new String(decryptedData).equals(expectedText);
        } catch (Exception e) {
            log.info(e.getMessage());
            return false;
        }

    }
}
