package de.uni_potsdam.hpi.bpt.bp2014.jengine;

import de.uni_potsdam.hpi.bpt.bp2014.database.DbActivityInstance;

/**
 * Created by jaspar.mang on 24.11.14.
 */
public class ActivityStateMachine extends StateMachine {
    private DbActivityInstance dbActivityInstance = new DbActivityInstance();


    public ActivityStateMachine(int activityInstance_id, ScenarioInstance scenarioInstance){
        super();
        this.scenarioInstance = scenarioInstance;
        this.controlNodeInstance_id = activityInstance_id;
        state = getDBState();
    }

    private String getDBState(){
        return dbActivityInstance.getState(controlNodeInstance_id);
    }

    public Boolean enableControlFlow(){
        //String state = this.getState();
        if(state.equals("init")) {
            this.setState("ready(ControlFlow)");
            return true;
        }else if(state.equals("ready(Data)")){
            this.setState("ready");
            return true;
        }else if(this.isReady(state)){
            return true;
        }
        return false;
    }

    public Boolean enableData(){
        //String state = this.getState();
        if(state.equals("init")) {
            this.setState("ready(Data)");
            return true;
        }else if(state.equals("ready(ControlFlow)")){
            this.setState("ready");
            return true;
        }else if(this.isReady(state)){
            return true;
        }
        return false;
    }

    public Boolean begin(){
        //String state = this.getState();
        if(state.equals("ready")){
            this.setState("running");
            return true;
        }
        return false;
    }

    public Boolean terminate(){
        //String state = this.getState();
        if(state.equals("running")){
            this.setState("terminated");
            return true;
        }
        return false;
    }

    public Boolean skip(){
        //String state = this.getState();
        if(state.equals("init") || this.isReady(state)){
            this.setState("skipped");
            return true;
        }
        return false;
    }


    private Boolean isReady(String state){
        if(state.equals("ready") || state.equals("ready(ControlFlow)") || state.equals("ready(Data)")){
            return true;
        }
        return false;
    }
    private void setState(String state){
        this.state = state;
        dbActivityInstance.setState(controlNodeInstance_id, state);
    }
}
