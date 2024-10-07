package com.example;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import javax.net.ssl.HttpsURLConnection;

public class SecureHttpsConnection {
    public static void main(String[] args) {
        try {
            // URL del sito a cui connettersi
            URL url = new URL("https://www.google.com");
            HttpsURLConnection con = (HttpsURLConnection) url.openConnection();

            // Impostazioni di sicurezza predefinite saranno usate
            con.setSSLSocketFactory(HttpsURLConnection.getDefaultSSLSocketFactory());
            con.setHostnameVerifier(HttpsURLConnection.getDefaultHostnameVerifier());

            // Lettura dei dati dalla connessione
            try (BufferedReader br = new BufferedReader(new InputStreamReader(con.getInputStream()))) {
                String line;
                while ((line = br.readLine()) != null) {
                    System.out.println(line);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
