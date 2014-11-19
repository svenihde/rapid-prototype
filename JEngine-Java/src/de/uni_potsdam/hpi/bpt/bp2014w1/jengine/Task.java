package de.uni_potsdam.hpi.bpt.bp2014w1.jengine;

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
    private Data data;
    private Association association;

    public Task(Data d){
        completedTask = new LinkedList<Integer>();
        enabledTask = new LinkedList<Integer>();
        sequenceFlow = new SequenceFlow();
        fragment = new Fragment();
        processElement = new ProcessElement();
        event = new Event();
        reference = new Reference();
        association = new Association();
        data = d;
    }

    public void init(int scenarioID){
        LinkedList<Integer> startEvents = fragment.getAllStartEventIDByScenarioID(scenarioID);
        //get Startevents and the first Activities
        for(int startEvent: startEvents){
            int processElementID = sequenceFlow.getNextProcessElement(startEvent);
            if(!completedTask.contains(processElementID) && !enabledTask.contains(processElementID) && !data.lll(scenarioID, processElementID)) {
                if(this.proveAssociation(scenarioID, processElementID)) {
                    enabledTask.add(processElementID);
                }
            }
        }
    }

    private Boolean proveAssociation(int scenario_id, int processElementID){
        LinkedList<Integer> associations = association.getInDataObjectIDByProcessElementID(processElementID);
        Boolean hasAllObjectsInTheRightState = true;
        if(!associations.isEmpty()){
            LinkedList<String> states = association.getInDataObjectStateByProcessElementID(processElementID);
            //TODO do it better!!!
            for(int i = 0; i < associations.size(); i++){
                //System.out.println(states.get(i)+" = "+ data.getState(scenario_id, associations.get(i)));
                if(!(states.get(i).equals(data.getState(scenario_id, associations.get(i))))){
                    hasAllObjectsInTheRightState = false;
                    data.addWaitingActivities(scenario_id, associations.get(i), processElementID);
                }
            }
        }
        return hasAllObjectsInTheRightState;
    }

    public Boolean completeActivity(int id){
        if(!enabledTask.contains(id))return false;
        LinkedList<Integer> List = this.getReferenceList(id);
        for(int element: List){
            if(enabledTask.contains(element)){
               this.setDataObjectsOutputState(element);
            }
        }
        this.setDataObjectsOutputState(id);
        for(int element: List){
            if(enabledTask.contains(element)){
                this.updateTasks(element);
            }
        }
        this.updateTasks(id);
        return true;
    }



    private void updateTasks(int id){
        completedTask.add(id);
        enabledTask.removeFirstOccurrence(id);
        int processElement = sequenceFlow.getNextProcessElement(id);
        int scenario_id = this.getScenarioIDByProcessElement(processElement);
        if(this.proveAssociation(scenario_id, processElement)) {
            enabledTask.add(processElement);
        }

        //prove if there is an EndEvent
        if ((this.processElement.getProcessElementType(processElement)).equals("Event") && (event.getEventType(processElement)).equals("End")){
            LinkedList<Integer> allElements = this.processElement.getAllProcessElementIDByFragmentID(this.processElement.getFragmentID(processElement));
            for(Integer element: allElements){
                while(completedTask.contains(element)) completedTask.removeFirstOccurrence(element);
                if ((this.processElement.getProcessElementType(element)).equals("Event") && (event.getEventType(element)).equals("Start")){
                    int nextProcessElement = sequenceFlow.getNextProcessElement(element);
                    if(this.proveAssociation(this.getScenarioIDByProcessElement(processElement), nextProcessElement)) {
                        enabledTask.add(nextProcessElement);
                    }
                }
            }
        }
    }

    private void setDataObjectsOutputState(int processElement_id){
        LinkedList <Integer> associations = association.getOutDataObjectIDByProcessElementID(processElement_id);
        LinkedList <String> states = association.getOutDataObjectStateByProcessElementID(processElement_id);
        int scenario_id = this.getScenarioIDByProcessElement(processElement_id);
        for(int i = 0; i < associations.size(); i++){
            data.setDataState(scenario_id, associations.get(i), states.get(i));
            //prove Waiting Activities
            LinkedList<Integer> waitingActivities = data.getWaitingActivities(scenario_id, associations.get(i));
            LinkedList<Integer> copy = new LinkedList<Integer>(waitingActivities);
            for(int waitingActivity: copy){
                String state = association.getStateByObjectIDAndByProcessElementID(associations.get(i), waitingActivity);
                //System.out.println("outputstate: "+state+ " = " + data.getState(scenario_id, associations.get(i)));
                if(state.equals(data.getState(scenario_id, associations.get(i)))){
                    enabledTask.add(waitingActivity);
                    data.removeWaitingActivities(scenario_id, associations.get(i), waitingActivity);
                }
            }

        }
    }

    private int getScenarioIDByProcessElement(int id){
        int scenario_id;
        int fragment_id = processElement.getFragmentID(id);
        scenario_id = fragment.getScenarioID(fragment_id);
        return scenario_id;
    }



    public void addReferenceToEnabledTask(int id){
        LinkedList<Integer> List = this.getReferenceList(id);
        for(int element: List){
            if(!enabledTask.contains(element)){
                enabledTask.add(element);
            }
        }
    }

    private LinkedList<Integer> getReferenceList(int id){
        LinkedList<Integer> List = new LinkedList<Integer>();
        List.add(id);
        int size = 0;
        while(size != List.size()){
            size = List.size();
            for(int i = 0; i < size; i++) {
                LinkedList<Integer> newElements = reference.getReference(List.get(i));
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

        Task task = new Task(new Data());
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
