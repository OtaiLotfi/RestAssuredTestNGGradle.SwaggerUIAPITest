package endpoints;
import java.util.HashMap;
import java.util.Map;

public class ScenarioContext {
    private Map<String, Object> scenarioContext;

    private ScenarioContext() {
        scenarioContext = new HashMap<>();
    }

    private static class Holder {
        private static final ScenarioContext INSTANCE = new ScenarioContext();
    }

    public static ScenarioContext getInstance() {
        return Holder.INSTANCE;
    }

    public void setScenarioContext(String key, Object value) {
        scenarioContext.put(key, value);
    }

    public Object getScenarioContext(String key) {
        return scenarioContext.get(key);
    }
}
