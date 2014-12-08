package de.uni_potsdam.hpi.bpt.bp2014.jengine;

import de.uni_potsdam.hpi.bpt.bp2014.database.Connection;
import de.uni_potsdam.hpi.bpt.bp2014.database.DbActivityInstance;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by jaspar.mang on 24.11.14.
 */
public class debugClass {
    public static String selectScenario(){
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
        return scID;
    }

    public static void main(String args[]){
        String scenarioID = selectScenario();
        ScenarioInstance scenarioInstance = new ScenarioInstance(new Integer(scenarioID));
        DbActivityInstance dbActivityInstance = new DbActivityInstance();
        dbActivityInstance.setState(1 , "init");
    }
}
