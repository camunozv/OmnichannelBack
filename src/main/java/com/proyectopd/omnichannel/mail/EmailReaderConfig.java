package com.proyectopd.omnichannel.mail;

import jakarta.mail.*;
import jakarta.mail.internet.InternetAddress;
import jakarta.mail.internet.MimeBodyPart;
import jakarta.mail.internet.MimeMessage;
import jakarta.mail.internet.MimeMultipart;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Properties;

/*
Am Besten verwenden wir IMAP, since it leaves our devives synchronized.
* */


public class EmailReaderConfig {

    public static void readEmails() {
        Properties props = new Properties();

        props.put("mail.store.protocol", "imaps"); // Use "imaps" for secure IMAP
        props.put("mail.imaps.host", "imap.gmail.com");
        props.put("mail.imaps.port", 993);
        props.put("mail.imaps.ssl.enable", "true"); // Enable SSL for IMAP

        Session session = Session.getDefaultInstance(props);

        try {
            // Connection
            Store store = session.getStore("imaps");
            store.connect("imap.gmail.com", "quejasomnichannel@gmail.com", "");

            // Inbox opening
            Folder inbox = store.getFolder("INBOX");
            inbox.open(Folder.READ_ONLY);

            // If we want to rapidly read our mails.
            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

            Message[] messages = inbox.getMessages();

            int i = 1;

            if (messages.length == 0) {
                System.out.println("There are no messages.");
            } else {
                for (Message message : messages) {

                    Multipart multiPart = (Multipart) message.getContent();

                    System.out.println("-----------MESSAGE No. " + i + "---------------");
                    System.out.println("Subject: " + message.getSubject());
                    System.out.println("From: " + InternetAddress.toString(message.getFrom()));
                    System.out.println("Sent Date: " + message.getSentDate());

                    for (int k = 0; k < multiPart.getCount(); k++) {
                        BodyPart bodyPart = multiPart.getBodyPart(k);
                        if (bodyPart.isMimeType("text/plain")) {
                            System.out.println("This is plain text");
                            System.out.println("---------------------------");
                            System.out.println((String) bodyPart.getContent());
                        } // with other conditions we can handle multiple content types.
                    }

                    i++;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        readEmails();
    }
}