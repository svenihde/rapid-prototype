package de.uni_potsdam.hpi.bpt.bp2014.jengine;

/**
 * Created by jaspar.mang on 24.11.14.
 */
public class NodeInstance {
    private OutgoingBehavior outgoingBehavior;
    private IncomingBehavior incomingBehavior;
    private StateMachine stateMachine;
    private int id;

    public NodeInstance(int id){
        this.id = id;
    }
}
