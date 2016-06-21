package me.vanture.slackutil.util;

import javax.net.ssl.HttpsURLConnection;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.URL;

/**
 * @author vanture
 * @since 21/06/2016
 */
public class UtilSlack {

    private static String ADDRESS = "";

    public static void postMessage(String channel, String message) throws IOException {

        HttpsURLConnection con = (HttpsURLConnection) new URL(ADDRESS).openConnection();

        con.setRequestMethod("POST");
        con.setRequestProperty("User-Agent", "Mozilla/5.0");
        con.setRequestProperty("Accept-Language", "en-US,en;q=0.5");
        con.setDoOutput(true);

        String parameters = "payload={";

        parameters += "\"username\":\"THE MAGICAL UNICORN\", ";
        parameters += "\"channel\":\"" + channel + "\", ";
        parameters += "\"text\":\"" + message + "\", ";
        parameters += "\"icon_url\":\"http://i.imgur.com/psiVh7i.png?1\"";
        parameters += "}";

        DataOutputStream wr = new DataOutputStream(con.getOutputStream());

        wr.writeBytes(parameters);
        wr.flush();
        wr.close();

        con.getResponseCode();

    }
}

