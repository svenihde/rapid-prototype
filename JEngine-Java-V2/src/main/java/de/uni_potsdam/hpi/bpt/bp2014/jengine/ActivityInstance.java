package de.uni_potsdam.hpi.bpt.bp2014.jengine;

import de.uni_potsdam.hpi.bpt.bp2014.database.DbActivityInstance;
import de.uni_potsdam.hpi.bpt.bp2014.database.DbControlNodeInstance;

/**
 * Created by jaspar.mang on 24.11.14.
 */
public class ActivityInstance extends ControlNodeInstance {
    int fragmentInstance_id;
    int controlNodeInstance_id;
    int controlNode_id;
    ScenarioInstance scenarioInstance;
    DbControlNodeInstance dbControlNodeInstance = new DbControlNodeInstance();
    DbActivityInstance dbActivityInstance = new DbActivityInstance();

    public ActivityInstance(int controlNode_id, int fragmentInstance_id, ScenarioInstance scenarioInstance){
        this.scenarioInstance = scenarioInstance;
        this.controlNode_id = controlNode_id;
        this.fragmentInstance_id = fragmentInstance_id;
        if(dbControlNodeInstance.existControlNodeInstance(controlNode_id)){
            //TODO: Activity already exists
        }else {
            dbControlNodeInstance.createNewControlNodeInstance(controlNode_id, "Activity", fragmentInstance_id);
            controlNodeInstance_id = dbControlNodeInstance.getControlNodeInstanceID(controlNode_id);
            dbActivityInstance.createNewActivityInstance(controlNodeInstance_id, "HumanTask", "init");
            stateMachine = new ActivityStateMachine(controlNodeInstance_id, scenarioInstance);
        }
    }
}
