/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.app.model;

/**
 *
 * @author Dell
 */
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.sun.mail.smtp.SMTPTransport;
import java.io.IOException;
import java.security.Security;
import java.util.Date;
import java.util.HashMap;
import java.util.Properties;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import okhttp3.FormBody;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

public class Email {

    private static final String username = "smubusinessmodelplanner"; // email without the part after @
    private static final String password = "!Q@W#E$R";

    public static void sendMail(String recipientEmail, String ccEmail, String title, String message) {
        Security.addProvider(new com.sun.net.ssl.internal.ssl.Provider());
        final String SSL_FACTORY = "javax.net.ssl.SSLSocketFactory";

        // Get a Properties object
        Properties props = System.getProperties();
        props.setProperty("mail.smtps.host", "smtp.gmail.com");
        props.setProperty("mail.smtp.socketFactory.class", SSL_FACTORY);
        props.setProperty("mail.smtp.socketFactory.fallback", "false");
        props.setProperty("mail.smtp.port", "465");
        props.setProperty("mail.smtp.socketFactory.port", "465");
        props.setProperty("mail.smtps.auth", "true");

        /*
         If set to false, the QUIT command is sent and the connection is immediately closed. If set 
         to true (the default), causes the transport to wait for the response to the QUIT command.

         ref :   http://java.sun.com/products/javamail/javadocs/com/sun/mail/smtp/package-summary.html
         http://forum.java.sun.com/thread.jspa?threadID=5205249
         smtpsend.java - demo program from javamail
         */
        props.put("mail.smtps.quitwait", "false");

        Session session = Session.getInstance(props,
                new javax.mail.Authenticator() {
                    @Override
                    protected PasswordAuthentication getPasswordAuthentication() {
                        return new PasswordAuthentication(username, password); // username need append @gmail.com?
                    }
                });

        try {
            // -- Create a new message --
            final MimeMessage msg = new MimeMessage(session);

            // -- Set the FROM and TO fields --
            msg.setFrom(new InternetAddress(username + "@gmail.com"));
            msg.setRecipients(Message.RecipientType.TO, InternetAddress.parse(recipientEmail, false));

            if (ccEmail.length() > 0) {
                msg.setRecipients(Message.RecipientType.CC, InternetAddress.parse(ccEmail, false));
            }

            msg.setSubject(title);
            msg.setText(message, "utf-8");
            msg.setSentDate(new Date());

            SMTPTransport t = (SMTPTransport) session.getTransport("smtps");
            t.connect("smtp.gmail.com", username, password);
            t.sendMessage(msg, msg.getAllRecipients());
            t.close();
        } catch (AddressException e) {
            // The exception thrown when a wrongly formatted address is encountered, sub-class of MessagingException
            //System.out.println("address wrongly formatted");
        } catch (MessagingException e) {
            // The base class for all exceptions thrown by the Messaging classes
        }
    }

    public static HashMap<String, String> getAccessToken() throws IOException {
        OkHttpClient client = new OkHttpClient();
        Gson gson = new GsonBuilder().create();

        String clientID = "50587841268-690hhsvf3hdb3cqvnl46qhpa5l3oaaco.apps.googleusercontent.com";
        String clientSecret = "i4lgS79RbqaXL5d3ES3rKDhH";
        String grantType;

        RequestBody formBody = new FormBody.Builder()
                .add("response_type", "token")
                .add("scope", "email")
                .add("client_id", clientID)
                .add("nounce", "ABCDE12345")
                .add("redirect_uri", "http://localhost").build();

        Request httpPost = new Request.Builder()
                .url("https://accounts.google.com/o/oauth2/v2/auth")
                .post(formBody)
                .build();

        HashMap<String, String> results = new HashMap<String, String>();
        Response response = client.newCall(httpPost).execute();

        if (response.message().equals("OK")) {
            String responseString = response.body().string();
            results = gson.fromJson(responseString, HashMap.class);
        }

        return results;
    }
}
