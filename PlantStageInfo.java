public class PlantStageInfo {

    private String hydration;
    private String sunlight;
    private String soilPH;
    private String nutrients;
    private String careInstructions;

    public PlantStageInfo(String hydration,
                          String sunlight,
                          String soilPH,
                          String nutrients,
                          String careInstructions) {

        this.hydration = hydration;
        this.sunlight = sunlight;
        this.soilPH = soilPH;
        this.nutrients = nutrients;
        this.careInstructions = careInstructions;
    }

    public String getHydration() {
        return hydration;
    }

    public String getSunlight() {
        return sunlight;
    }

    public String getSoilPH() {
        return soilPH;
    }

    public String getNutrients() {
        return nutrients;
    }

    public String getCareInstructions() {
        return careInstructions;
    }
}