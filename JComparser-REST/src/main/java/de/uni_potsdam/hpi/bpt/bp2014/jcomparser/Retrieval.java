package de.uni_potsdam.hpi.bpt.bp2014.jcomparser;

import java.io.*;
import java.net.*;


/**
 * Created by Jani on 24.11.2014.
 */
public class Retrieval {
    public String getHTML(String urlToRead) {
        URL url;
        HttpURLConnection conn;
        BufferedReader rd;
        String line;
        String result = "";
        try {
            url = new URL(urlToRead);
            conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("GET");
            rd = new BufferedReader(new InputStreamReader(conn.getInputStream()));
            while ((line = rd.readLine()) != null) {
                result += line;
            }
            rd.close();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }

    public static void main(String args[])
    {
        Retrieval c = new Retrieval();
        System.out.println(c.getHTML(args[0]));
    }
}
