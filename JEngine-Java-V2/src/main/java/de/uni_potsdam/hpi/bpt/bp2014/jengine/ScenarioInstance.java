package de.uni_potsdam.hpi.bpt.bp2014.jengine;

import java.util.LinkedList;

/**
 * Created by jaspar.mang on 24.11.14.
 */
public class ScenarioInstance {
    private LinkedList<NodeInstance> enabledNodes = new LinkedList<NodeInstance>();
    private LinkedList<FragmentInstance> fragmentInstances = new LinkedList<FragmentInstance>();
    private LinkedList<DataObject> dataObjects = new LinkedList<DataObject>();
    private int id;
    private String name;

    public ScenarioInstance(int id){
        this.id = id;
    }
}
