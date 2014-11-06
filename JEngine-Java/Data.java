import java.util.ArrayList;
import java.util.HashMap;

/**
 * Created by jaspar.mang on 05.11.14.
 */

public class Data {
    public HashMap<Integer, HashMap<Integer, String>> data;
    private DataObject dataObject;

    public Data(){
        data = new HashMap<Integer, HashMap<Integer, String>>();
    }
    public void init (int scenario_id){
        if (data.containsKey(scenario_id)) {
            data.put(scenario_id, new HashMap<Integer, String>());
            dataObject = new DataObject();
            ArrayList<Integer> objects = dataObject.getAllDataObejctBy(scenario_id);
            for (int object : objects) {
                data.get(scenario_id).put(object, "Init");
            }
        }
    }

    public Boolean setDataState(int scenario_id, int id, String state){
        if(!data.containsKey(scenario_id) || !data.get(scenario_id).containsKey(id)) return false;
        data.get(scenario_id).put(id, state);
        return true;
    }

    public static void main(String[] args){
        Data test = new Data();
        test.init(1);
    }

}
