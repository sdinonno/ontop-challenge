package context;

import java.util.HashMap;
import java.util.Map;
public class ScenarioContext {

    private Map<String, Object> scenarioContext;

    /**
     * ScenarioContext store information in a HashMap in order to reuse them in the different steps of an scenario.
     */
    public ScenarioContext(){
        scenarioContext = new HashMap<String, Object>();
    }

    /**
     * Method to save a value in the context.
     * @param key
     * @param value
     */
    public void setContext(Context key, Object value) {
        scenarioContext.put(key.toString(), value);
    }

    /**
     * Method to get a value from the context.
     * @param key
     * @return
     */
    public Object getContext(Context key){
        return scenarioContext.get(key.toString());
    }
}
