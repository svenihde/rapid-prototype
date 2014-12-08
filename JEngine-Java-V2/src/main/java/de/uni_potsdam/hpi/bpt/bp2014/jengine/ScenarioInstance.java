package de.uni_potsdam.hpi.bpt.bp2014.jengine;

import de.uni_potsdam.hpi.bpt.bp2014.database.DbFragment;
import de.uni_potsdam.hpi.bpt.bp2014.database.DbScenarioInstance;

import java.util.LinkedList;

/**
 * Created by jaspar.mang on 24.11.14.
 */
public class ScenarioInstance {
    public LinkedList<ControlNodeInstance> controlNodeInstances = new LinkedList<ControlNodeInstance>();
    public LinkedList<ControlNodeInstance> enabledControlNodeInstances = new LinkedList<ControlNodeInstance>();
    public LinkedList<ControlNodeInstance> controlFlowEnabledControlNodeInstances = new LinkedList<ControlNodeInstance>();
    public LinkedList<ControlNodeInstance> dataEnabledControlNodeInstances = new LinkedList<ControlNodeInstance>();
    private LinkedList<FragmentInstance> fragmentInstances = new LinkedList<FragmentInstance>();
    private LinkedList<DataObject> dataObjects = new LinkedList<DataObject>();
    private int scenarioInstance_id;
    private int scenario_id;
    private String name;
    private DbScenarioInstance dbScenarioInstance = new DbScenarioInstance();
    private DbFragment dbFragment = new DbFragment();

    public ScenarioInstance(int scenario_id){
        this.scenario_id = scenario_id;
        if (dbScenarioInstance.existScenario(scenario_id)){
            scenarioInstance_id = dbScenarioInstance.getScenarioInstanceID(scenario_id);
            System.out.println("exist");
            this.initializeFragments();
        }else {
            System.out.println("exist not");
            dbScenarioInstance.createNewScenarioInstance(scenario_id);
            scenarioInstance_id = dbScenarioInstance.getScenarioInstanceID(scenario_id);
            this.initializeFragments();
        }
    }

    private void initializeFragments(){
        LinkedList<Integer> fragment_ids = dbFragment.getFragmentsForScenario(scenario_id);
        for(int fragment_id: fragment_ids){
            FragmentInstance fragmentInstance = new FragmentInstance(fragment_id, scenarioInstance_id, this);
            fragmentInstances.add(fragmentInstance);
        }
    }
}
