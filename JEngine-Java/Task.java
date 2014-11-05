import java.util.ArrayList;
import java.util.LinkedList;

/**
 * Created by jaspar.mang on 04.11.14.
 */
public class Task {
    public LinkedList<Integer> completedTask;
    public LinkedList<Integer> enabledTask;
    private SequenceFlow sequenceFlow;
    private Fragment fragment;
    private ProcessElement processElement;
    private Event event;
    private Reference reference;

    public Task(){
        completedTask = new LinkedList<Integer>();
        enabledTask = new LinkedList<Integer>();
        sequenceFlow = new SequenceFlow();
        fragment = new Fragment();
        processElement = new ProcessElement();
        event = new Event();
        reference = new Reference();
    }
    public void init(int scenarioID){
        ArrayList<Integer> startEvents = fragment.getAllStartEventIDByScenarioID(scenarioID);
        for(int startEvent: startEvents){
            int processElementID = sequenceFlow.getNextProcessElement(startEvent);
            if(!completedTask.contains(processElementID) && !enabledTask.contains(processElementID)) {
                enabledTask.add(processElementID);
            }
        }
    }
    public Boolean completeActivity(int id){
        if(!enabledTask.contains(id))return false;
        completedTask.add(id);
        //this.addReferenceToCompletedTask(id);
        int processElement = sequenceFlow.getNextProcessElement(id);
        enabledTask.removeFirstOccurrence(id);
        enabledTask.add(processElement);

      //  this.addReferenceToEnabledTask(processElement);


        //prove if there is an EndEvent
        if ((this.processElement.getProcessElementType(processElement)).equals("Event") && (event.getEventType(processElement)).equals("End")){
            ArrayList<Integer> allElements = this.processElement.getAllProcessElementIDByFragmentID(this.processElement.getFragmentID(processElement));
            for(Integer element: allElements){
                completedTask.removeFirstOccurrence(element);
                if ((this.processElement.getProcessElementType(element)).equals("Event") && (event.getEventType(element)).equals("Start")){
                    enabledTask.add(sequenceFlow.getNextProcessElement(element));
                }
            }
        }
        return true;
    }


    private void addReferenceToCompletedTask(int id){
        ArrayList<Integer> List = this.getReferenceList(id);
        for(int element: List){
            enabledTask.remove(new Integer(element));
            if(!completedTask.contains(element)){
                completedTask.add(element);
            }
        }
    }

    public void addReferenceToEnabledTask(int id){
        ArrayList<Integer> List = this.getReferenceList(id);
        for(int element: List){
            if(!enabledTask.contains(element)){
                enabledTask.add(element);
            }
        }
    }

    private ArrayList<Integer> getReferenceList(int id){
        ArrayList<Integer> List = new ArrayList<Integer>();
        List.add(id);
        int size = 0;
        while(size != List.size()){
            size = List.size();
            for(int i = 0; i < size; i++) {
                ArrayList<Integer> newElements = reference.getReference(List.get(i));
                for (int newElement : newElements) {
                    if (!List.contains(newElement)) {
                        List.add(newElement);
                    }
                }
            }
        }
        //remove object id from List
        List.remove(new Integer(id));
        return List;
    }

    public static void main(String[] args){
        Task task = new Task();
        task.init(1);
        System.out.println("enabled Task:");
        for(int t: task.enabledTask) System.out.println("task " + t);
        System.out.println("completed Task");
        for(int t: task.completedTask) System.out.println("task " + t);
        task.completeActivity(2);
        System.out.println("mache 2");
        task.init(1);
        for(int t: task.enabledTask) System.out.println("task "+t);

        task.addReferenceToEnabledTask(8);
    }
}
