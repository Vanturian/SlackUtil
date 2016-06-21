package me.vanture.slackutil;

import me.vanture.slackutil.util.UtilSlack;

import java.io.IOException;

/**
 * @author vanture
 * @since 21/06/2016
 */
public class Main {
    public static void main(String[] args) {
        log("Attempting to send a message to Slack!");
        try {
            log("Message is transferred to Slack!");
            UtilSlack.postMessage("bots", "I'm a really cool bot :D");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void log(String msg) {
        System.out.println("[INFO] " + msg);
    }
}
