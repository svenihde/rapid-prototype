package de.uni_potsdam.hpi.bpt.bp2014w1.jengine;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.LinkedList;


/**
 * Created by jaspar.mang on 04.11.14.
 */
public class Index extends HttpServlet{

    public void init() throws ServletException{

    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        // Set response content type
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        //HTML Head
        out.println("<html>");
        out.println("<head>");
        out.println("<title>JEngine</title>");
        out.println("</head>");

        //HTML Body
        out.println("<body>");
        out.println("<h1> JEngine </h1>");

        //Get scenario data
        Scenario scenario = new Scenario();
        LinkedList<Integer> ids = scenario.getAllScenariosId();
        LinkedList<String> names = scenario.getAllScenariosName();



        //table with scenario data
        out.println("<table border=\"1\">");
        out.println("<tr>");
        out.println("<th>Szenario ID</th>");
        out.println("<th>Szenario Name</th>");
        out.println("</tr>");
        for(int i=0; i < ids.size(); i++ ) {
            out.println("<tr>");
            out.println("<td>"+ids.get(i)+"</td>");
            out.println("<td>"+names.get(i)+"</td>");
            out.println("<td><a href=\"scenario?id="+ids.get(i)+"\">auswählen</a></td>");
            out.println("</tr>");
        }

        out.println("</table>");
        //end BODY + HTML
        out.println("</body>");
        out.println("</html");

    }

    public void destroy(){
        // do nothing.
    }
    public static void main(String[] args){
        Scenario scenario = new Scenario();
        LinkedList<Integer> ids = scenario.getAllScenariosId();
        LinkedList<String> names = scenario.getAllScenariosName();




        for(int i=0; i < ids.size(); i++ ){
            System.out.println("ID: " + ids.get(i) + " Name: " + names.get(i));
        }
    }

}
