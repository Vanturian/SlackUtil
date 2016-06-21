/*
* MIT License
*
* Copyright (c) 2016 Vanture
*
* Permission is hereby granted, free of charge, to any person obtaining a copy
* of this software and associated documentation files (the "Software"), to deal
* in the Software without restriction, including without limitation the rights
* to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
* copies of the Software, and to permit persons to whom the Software is
* furnished to do so, subject to the following conditions:
*
* The above copyright notice and this permission notice shall be included in all
* copies or substantial portions of the Software.
*
* THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
* IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
* FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
* AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
* LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
* OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
* SOFTWARE.
*/
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

