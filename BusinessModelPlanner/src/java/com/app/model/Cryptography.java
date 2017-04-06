/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.app.model;

import com.nimbusds.jose.JOSEException;
import com.nimbusds.jose.JWSAlgorithm;
import com.nimbusds.jose.JWSHeader;
import com.nimbusds.jose.JWSObject;
import com.nimbusds.jose.JWSSigner;
import com.nimbusds.jose.JWSVerifier;
import com.nimbusds.jose.Payload;
import com.nimbusds.jose.crypto.MACSigner;
import com.nimbusds.jose.crypto.MACVerifier;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.util.Date;

/**
 *
 * @author Dell
 */
public class Cryptography {

    private static SecureRandom rand = new SecureRandom();
    // the sharesecret will keep changing and we will fail
    // to verify token. Each character is one byte. Need 32 bytes

    public static String hash(String message) {
        byte[] msgDigestBytes = null;
        String msgDigestStr = null;

        try {
            MessageDigest md = MessageDigest.getInstance("SHA-256");
            md.update(message.getBytes());
            msgDigestBytes = md.digest();

            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < msgDigestBytes.length; i++) {
                sb.append(Integer.toHexString(0xFF & msgDigestBytes[i])); // Convert to hex format
            }
            
            msgDigestStr = sb.toString();
        } catch (NoSuchAlgorithmException e) {

        }

        return msgDigestStr;
    }

    public static String generateRandString(int length) {
        String charSpace = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ1234567890"; // Character space
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < length; i++) {
            sb.append(charSpace.charAt(rand.nextInt(charSpace.length())));
        }

        return sb.toString();
    }

    public static String generateAccessToken(String email, String sharedSecret) throws JOSEException{
        // Generate random 256-bit (32-byte) shared secret
        //rand.nextBytes(sharedSecret);

        // Create HMAC signer
        JWSSigner signer = new MACSigner(sharedSecret);

        // Header to set the signing algorithm and the custom parameter, expiry date
        JWSHeader header = new JWSHeader.Builder(JWSAlgorithm.HS256)
                .contentType("text/plain")
                .customParam("exp", new Date().getTime() + (24 * 60 * 60 * 1000)) // Set the expiry date to issue time + 1 day
                .build();

        // Prepare JWS object with content payload. Can use email of user
        JWSObject jwsObject = new JWSObject(header, new Payload(email));

        // Apply the HMAC
        jwsObject.sign(signer);

        // To serialize to compact form, produces something like
        // eyJhbGciOiJIUzI1NiJ9.SGVsbG8sIHdvcmxkIQ.onO9Ihudz3WkiauDO2Uhyuz0Y18UASXlSc1eS0NkWyA
        return jwsObject.serialize();
    }

    public static String verifyAccessToken(String accessToken, String sharedSecret) throws Exception {
        JWSObject jwsObject = JWSObject.parse(accessToken);

        // Create HMAC verifier
        JWSVerifier verifier = new MACVerifier(sharedSecret);

        if (jwsObject.verify(verifier)) {
            JWSHeader header = jwsObject.getHeader();
            Object expiry = header.getCustomParam("exp");

            long expiryDateInMS = (long) expiry; // The return type is object but suppose to be the expiry date
            // in ms, so cast to long
            if (new Date().before(new Date(expiryDateInMS))) { // Check if token has expired
                return jwsObject.getPayload().toString(); // Extracts the payload, which is the email of the user
            }
        }

        return null;
    }
}
