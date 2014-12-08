package de.uni_potsdam.hpi.bpt.bp2014w1.jengine;

import java.util.Collection;
import java.util.LinkedList;
import java.util.HashMap;

/**
 * Created by jaspar.mang on 05.11.14.
 */

public class Data {
    public HashMap<Integer, HashMap<Integer, String>> data;
    private DataObject dataObject;
    public HashMap<Integer, HashMap<Integer, LinkedList<Integer>>> waitingActivities;

    public Data(){
        data = new HashMap<Integer, HashMap<Integer, String>>();
        waitingActivities = new HashMap<Integer, HashMap<Integer, LinkedList<Integer>>>();
    }

    public void init (int scenario_id){
        if (!data.containsKey(scenario_id)) {
            data.put(scenario_id, new HashMap<Integer, String>());
            waitingActivities.put(scenario_id, new HashMap<Integer, LinkedList<Integer>>());
            dataObject = new DataObject();


            LinkedList<Integer> objects = dataObject.getAllDataObejctBy(scenario_id);
            System.out.println(objects.isEmpty());
            for (int object : objects) {
                data.get(scenario_id).put(object, "Init");
                waitingActivities.get(scenario_id).put(object, new LinkedList<Integer>());
            }
        }
    }

    public void addWaitingActivities(int scenario_id, int dataObject_id, int processElement_id){
        waitingActivities.get(scenario_id).get(dataObject_id).add(processElement_id);
    }

    public void setWaitingActivities(int scenario_id, int dataObject_id, LinkedList<Integer> List){
        waitingActivities.get(scenario_id).put(dataObject_id, List);
    }

    public LinkedList<Integer> getWaitingActivities(int scenario_id, int dataObject_id){
        return waitingActivities.get(scenario_id).get(dataObject_id);
    }

    public Boolean removeWaitingActivities(int scenario_id, int dataObject_id, int processElement_id){
        return waitingActivities.get(scenario_id).get(dataObject_id).remove(new Integer(processElement_id));
    }


    public String getState(int scenario_id, int id){
        return data.get(scenario_id).get(id);
    }

    public Boolean setDataState(int scenario_id, int id, String state){
        if(!data.containsKey(scenario_id) || !data.get(scenario_id).containsKey(id)) return false;
        data.get(scenario_id).put(id, state);
        return true;
    }

    public Boolean lll(int scenario_id, int id){
        Collection<LinkedList<Integer>> activities = waitingActivities.get(scenario_id).values();
        Boolean back = false;
        for(LinkedList<Integer> list: activities){
            back = list.contains(new Integer(id));
            if(back == true) break;
        }
        return back;
    }

    public static void main(String[] args){
        Data test = new Data();
        test.init(1);
    }

}
