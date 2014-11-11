package de.uni_potsdam.hpi.bpt.bp2014w1.jengine;
//package rapid-prototype.JEngine-Java;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.Console;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.*;
import java.lang.*;
import java.util.LinkedList;


/**
 * Created by jaspar.mang on 04.11.14.
 */
public class DebugClass{
    Data data;
    Task task;

    public void init(){
        data = new Data();
        task = new Task(data);
    }

    public void doGet(String scID, String toID){



        Scenario scenario = new Scenario();
        //HTML Body
        //prove for GET parameter id
        if (scID == null) {
            System.out.println("Kein Szenario ausgewälht");
        }else if (!this.isInt(scID) || scenario.getScenarioNameByID(scID)== null){
            System.out.println("Kein gültiges Szenario ausgewählt");
        }else{
            //Get scenario data
            int id = Integer.parseInt(scID);
            task.init(id);
            data.init(id);


            if(!(toID == null) && this.isInt(toID)){
                int todo = Integer.parseInt(toID);
                if(task.completeActivity(todo)){
                    System.out.println("Aktivität " + todo + " erledigt!");
                }
            }



            System.out.println("\n\n\n<h1> Szenario " + id + ": "+scenario.getScenarioNameByID(id)+"</h1>");
            Fragment fragment = new Fragment();
            LinkedList<Integer> startEvents = fragment.getAllStartEventIDByScenarioID(id);
            System.out.println("Anzahl Start Events: "+startEvents.size()+"\n\n");

            Activity activity = new Activity();
            Event event = new Event();
            SequenceFlow sequenceFlow = new SequenceFlow();
            ProcessElement processElement = new ProcessElement();
            for(int startEvent: startEvents) {
                System.out.println("StartEvent " + startEvent +"\n");



                int nextElement = startEvent;
                // TODO do it better
                while (true) {
                    nextElement = sequenceFlow.getNextProcessElement(nextElement);
                    if ((processElement.getProcessElementType(nextElement)).equals("Event") && (event.getEventType(nextElement)).equals("End")) {
                        break;
                    }
                    int nextElementID = nextElement;
                    String nextElementName = activity.getActivityLabel(nextElementID);

                    System.out.print("ID: " + nextElementID + "  ,  ");
                    System.out.print(nextElementName);
                    if (task.completedTask.contains(nextElementID)) System.out.print("   ABGEARBEITET");
                    if (task.enabledTask.contains(nextElementID)) {
                        System.out.print("   AUSWÄHLBAR");
                    }
                    System.out.print("\n");
                }
            }
        }
    }

    public void destroy(){
        // do nothing.
    }

    private boolean isInt(String value) {
        try {
            Integer.parseInt(value);
            return true;
        }
        catch(NumberFormatException e) {
            return false;
        }

    }

    public static void main(String[] args){
        DebugClass debug = new DebugClass();
        debug.init();
        InputStreamReader isr = new InputStreamReader(System.in);
        BufferedReader br = new BufferedReader(isr);
        System.out.print("Select Scenario: ");
        String scID = null;
        try {
            scID = br.readLine();
        } catch (IOException e) {
            System.out.print("ERROR: "+e);
            e.printStackTrace();
        }
        System.out.println("Scenario " + scID + " selected");
        debug.doGet(scID, "-1");

        while(true){
            String toID = null;
            System.out.println("\nSelect Activity");
            try {
                toID = br.readLine();
            } catch (IOException e) {
                e.printStackTrace();
            }
            debug.doGet(scID, toID);
        }

        

    }


}
