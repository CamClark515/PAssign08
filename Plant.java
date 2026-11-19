
import java.util.HashMap;
import java.util.Map;

public class Plant {

    private String name;
    private Map<String, PlantStageInfo> stages;

    public Plant(String name) {
        this.name = name;
        stages = new HashMap<>();
    }

    public String getName() {
        return name;
    }

    public void addStage(String stage, PlantStageInfo info) {
        stages.put(stage, info);
    }

    public PlantStageInfo getStageInfo(String stage) {
        return stages.get(stage);
    }
}
