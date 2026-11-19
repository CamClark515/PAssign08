//File: PlantStageInfo
//Class: CSCI 1302
//Author: Cameron Clark, David Camp
//Created on: 11/14/2026
//Last Modified: 11/19/2026
//Description: Getters and setters for Plant Stage
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
