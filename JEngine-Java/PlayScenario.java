//package rapid-prototype.JEngine-Java;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.lang.*;
import java.util.ArrayList;


/**
 * Created by jaspar.mang on 04.11.14.
 */
public class PlayScenario extends HttpServlet{
        Task task;
        Data data;
    public void init() throws ServletException{
        task = new Task();
        data = new Data();
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Set response content type
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        //HTML Head
        out.println("<html>");
        out.println("<head>");
        out.println("<title>JEngine</title>");
        out.println("</head>");
        Scenario scenario = new Scenario();
        //HTML Body
        out.println("<body>");
        //prove for GET parameter id
        if (request.getParameter("id") == null) {
            out.println("Kein Szenario ausgewälht");
        }else if (!this.isInt(request.getParameter("id")) || scenario.getScenarioNameByID(request.getParameter("id"))== null){
            out.println("Kein gültiges Szenario ausgewählt");
        }else{
            //Get scenario data
            int id = Integer.parseInt(request.getParameter("id"));
            task.init(id);
            data.init(id);


            if(!(request.getParameter("todo") == null) && this.isInt(request.getParameter("todo"))){
                int todo = Integer.parseInt(request.getParameter("todo"));
                if(task.completeActivity(todo)){
                    out.println("Aktivität " + todo + " erledigt!");
                }
            }



            out.println("<h1> Szenario " + id + ": "+scenario.getScenarioNameByID(id)+"</h1>");
            Fragment fragment = new Fragment();
            ArrayList<Integer> startEvents = fragment.getAllStartEventIDByScenarioID(id);
            out.println("Anzahl Start Events :"+startEvents.size()+"<br><br>");

            Activity activity = new Activity();
            Event event = new Event();
            SequenceFlow sequenceFlow = new SequenceFlow();
            ProcessElement processElement = new ProcessElement();


            for(int startEvent: startEvents) {
                out.println("StartEvent " + startEvent);
                out.println("<table border=\"1\">");
                out.println("<tr>");
                out.println("<th>Aktivität ID</th>");
                out.println("<th>Aktivität Name</th>");
                out.println("<th>bearbeiten</th>");
                out.println("</tr>");


                int nextElement = startEvent;
                // TODO do it better
                while (true) {
                    nextElement = sequenceFlow.getNextProcessElement(nextElement);
                    if ((processElement.getProcessElementType(nextElement)).equals("Event") && (event.getEventType(nextElement)).equals("End")) {
                        break;
                    }
                    int nextElementID = nextElement;
                    String nextElementName = activity.getActivityLabel(nextElementID);
                    out.print("<tr");
                    if (task.completedTask.contains(nextElementID)) out.print(" bgcolor=\"#58FA58\" ");
                    out.println(">");
                    out.println("<td>" + nextElementID + "</td>");
                    out.println("<td>" + nextElementName + "</td>");
                    if (task.enabledTask.contains(nextElementID)) {
                        out.println("<td><a href=\"scenario?id=" + id + "&todo=" + nextElementID + "\">auswählen</a></td>");
                    }
                    out.println("</tr>");
                }
                out.println("</table>");
                out.println("<br>");
            }
        }
        //end BODY + HTML
        out.println("</body>");
        out.println("</html");

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
        Fragment fragment = new Fragment();
        ArrayList<Integer> startEvents = fragment.getAllStartEventIDByScenarioID(1);
        Activity activity = new Activity();
        ArrayList<String> activitys = activity.getAllActivityNameByFragmentID(1);
    }


}
