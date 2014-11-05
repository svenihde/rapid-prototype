import java.util.ArrayList;
import java.util.HashMap;

/**
 * Created by jaspar.mang on 05.11.14.
 */
public class Data {
    public HashMap<Integer, HashMap<Integer, String>> data;
    private DataObject dataObject;

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



}
