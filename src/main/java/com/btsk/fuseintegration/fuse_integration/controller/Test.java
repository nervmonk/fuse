package com.btsk.fuseintegration.fuse_integration.controller;

import javax.crypto.Cipher;
import java.security.KeyFactory;
import java.security.PublicKey;
import java.security.spec.X509EncodedKeySpec;
import java.util.Base64;

public class Test {
    private static final String PUBLIC_KEY = "MIGfMA0GCSqGSIb3DQEBAQUAA4GNADCBiQKBgQC52vbKeR2iTPopPArfFi5DijWAUg7wOW6yw21Cz7geI9sfvdxtuRLC8bdFWP44Fota+VS8fm+UzeSXPnRa/XnAdJvxYELcO6W5M7WrKdzNkN6CVHzjBshyZwNvqd6cyDuD2et26kBz3yBaCyb6FPU0mNR6ERseLS8WYsF3gK1jTwIDAQAB";

    public static String encrypt(String text) throws Exception {
        X509EncodedKeySpec spec = new X509EncodedKeySpec(Base64.getMimeDecoder().decode(PUBLIC_KEY));
        KeyFactory keyFactory = KeyFactory.getInstance("RSA");
        PublicKey pkey = keyFactory.generatePublic(spec);
        Cipher cipher = Cipher.getInstance("RSA");
        cipher.init(Cipher.ENCRYPT_MODE, pkey);
        byte[] result = cipher.doFinal(text.getBytes());
        return Base64.getEncoder().encodeToString(result);
    }

    public static void main(String[] args) throws Exception {
        long unixTimestamp = System.currentTimeMillis();
        System.out.println(unixTimestamp);
        String beforeCode = "AGJPMSD9FLHCV2FJUIGCGH6IZRZI2LE9\n" +
                unixTimestamp + "\n" +
                "123456";
        System.out.println(encrypt(beforeCode));
    }
}
