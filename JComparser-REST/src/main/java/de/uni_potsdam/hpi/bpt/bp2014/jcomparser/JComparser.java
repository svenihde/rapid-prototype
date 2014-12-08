package de.uni_potsdam.hpi.bpt.bp2014.jcomparser;

import java.util.List;

public class JComparser {
    public static void main() {

        /* Settings */
        boolean retrieval_by_url = true;
        boolean rest_option = false;
        boolean mysql_option = true;

        /* Initialization */
        String JSON_response = "";
        String Processeditor_server_url = "http://localhost:8080/processeditor-repo-api/";

        if(rest_option) {
            Connector jHandler = new Connector();
        }

        if (rest_option) {
            REST jREST = new REST();
        }
        if (retrieval_by_url) {
            Retrieval jRetrieval = new Retrieval();
            JSON_response = jRetrieval.getHTML(Processeditor_server_url);
            System.out.println(JSON_response);
        }
    }

    public static void handleFileUpload(List pcm) {

    }
}
