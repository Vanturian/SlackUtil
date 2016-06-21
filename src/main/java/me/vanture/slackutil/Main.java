package me.vanture.slackutil;

import me.vanture.slackutil.util.UtilSlack;

import java.io.IOException;
import java.util.logging.Level;

/**
 * @author vanture
 * @since 21/06/2016
 */
public class Main {
    public static void main(String[] args) {
        System.out.println(Level.INFO + "Attempting to send a message to Slack!");
        try {
            System.out.println(Level.INFO + " Message is transferred to Slack!");
            UtilSlack.postMessage("bots", "I'm a really cool bot :D");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
