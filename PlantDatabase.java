//File: PlantDatabase.java
//Class: CSCI 1302
//Author: Cameron Clark, David Camp
//Created on: 11/14/2026
//Last Modified: 11/19/2026
//Description: Staging and information for plant database
import java.util.HashMap;
import java.util.Map;
import java.util.Collection;

public class PlantDatabase {

    private static Map<String, Plant> plants = new HashMap<>();

    static {
        loadPlants();
    }

    private static void loadPlants() {

        // TOMATO
        Plant tomato = new Plant("Tomato");

        tomato.addStage("Seed", new PlantStageInfo(
            "Keep seed-starting soil consistently moist, not soaked.",
            "Warm location; light is important after sprouting.",
            "6.0-6.8",
            "Seeds contain stored nutrients.",
            "Keep seeds warm and avoid overwatering."
        ));

        tomato.addStage("Seedling", new PlantStageInfo(
            "Water when the soil surface begins to dry.",
            "14-16 hours of grow light indoors.",
            "6.0-6.8",
            "Use a balanced, diluted fertilizer when true leaves develop.",
            "Develop strong roots and true leaves before transplanting."
        ));

        tomato.addStage("Mature", new PlantStageInfo(
            "Deep watering, approximately 1-2 inches weekly depending on weather.",
            "6-8+ hours of direct sunlight.",
            "6.0-6.8",
            "Balanced fertilizer with adequate potassium.",
            "Use mulch and drip irrigation to maintain consistent moisture. Support the plant as it grows."
        ));

        plants.put("Tomato", tomato);


        // PEPPER
        Plant pepper = new Plant("Pepper");

        pepper.addStage("Seed", new PlantStageInfo(
            "Keep seed-starting soil evenly moist.",
            "Warm location; provide light after sprouting.",
            "6.0-6.8",
            "Seeds contain stored nutrients.",
            "Maintain warmth and avoid waterlogged soil."
        ));

        pepper.addStage("Seedling", new PlantStageInfo(
            "Keep soil moderately moist with good drainage.",
            "14-16 hours of grow light indoors.",
            "6.0-6.8",
            "Balanced fertilizer after true leaves develop.",
            "Allow roots to establish before transplanting."
        ));

        pepper.addStage("Mature", new PlantStageInfo(
            "Water consistently, especially during fruit production.",
            "6-8+ hours of direct sunlight.",
            "6.0-6.8",
            "Balanced fertilizer with adequate potassium.",
            "Maintain even moisture and harvest peppers as they mature."
        ));

        plants.put("Pepper", pepper);


        // POTATO
        Plant potato = new Plant("Potato");

        potato.addStage("Seed", new PlantStageInfo(
            "Plant seed potatoes in moist, well-drained soil.",
            "Provide sunlight after shoots emerge.",
            "5.0-6.0",
            "Seed potatoes provide stored energy for early growth.",
            "Plant healthy seed potato pieces with at least one eye. Avoid overly wet soil."
        ));

        potato.addStage("Seedling", new PlantStageInfo(
            "Maintain consistent moisture without waterlogging.",
            "Approximately 6-8 hours of sunlight.",
            "5.0-6.0",
            "Use a balanced fertilizer based on soil test results.",
            "Keep soil loose and hill soil around stems as the plant grows."
        ));

        potato.addStage("Mature", new PlantStageInfo(
            "Maintain even moisture during tuber development.",
            "6-8 hours of sunlight.",
            "5.0-6.0",
            "Avoid excessive nitrogen; maintain balanced soil nutrients.",
            "Continue hilling as needed. Reduce watering as foliage dies back near harvest."
        ));

        plants.put("Potato", potato);


        // EGGPLANT
        Plant eggplant = new Plant("Eggplant");

        eggplant.addStage("Seed", new PlantStageInfo(
            "Keep seed-starting mix consistently moist.",
            "Warm location; provide light after sprouting.",
            "6.0-7.0",
            "Seeds contain stored nutrients.",
            "Maintain warm soil and avoid soaking the seed-starting mix."
        ));

        eggplant.addStage("Seedling", new PlantStageInfo(
            "Water regularly while allowing excess water to drain.",
            "14-16 hours of grow light indoors.",
            "6.0-7.0",
            "Balanced fertilizer after true leaves develop.",
            "Provide warmth and strong light to encourage healthy roots and leaves."
        ));

        eggplant.addStage("Mature", new PlantStageInfo(
            "Deep, consistent watering, especially during flowering and fruit production.",
            "8-10 hours of sunlight.",
            "6.0-7.0",
            "Balanced fertilizer with adequate potassium.",
            "Support heavy branches and harvest fruits while their skin is glossy."
        ));

        plants.put("Eggplant", eggplant);


        // CHILI PEPPER
        Plant chili = new Plant("Chili Pepper");

        chili.addStage("Seed", new PlantStageInfo(
            "Maintain consistent moisture without soaking the soil.",
            "Warm location; provide light after sprouting.",
            "6.0-6.8",
            "Seeds contain stored nutrients.",
            "Keep seeds warm and maintain moderate moisture."
        ));

        chili.addStage("Seedling", new PlantStageInfo(
            "Keep soil moderately moist and well-drained.",
            "14-16 hours of grow light indoors.",
            "6.0-6.8",
            "Balanced fertilizer after true leaves develop.",
            "Allow roots to establish and gradually introduce outdoor sunlight."
        ));

        chili.addStage("Mature", new PlantStageInfo(
            "Water deeply when needed; avoid letting soil dry completely.",
            "6-8+ hours of direct sunlight.",
            "6.0-6.8",
            "Balanced fertilizer with adequate potassium.",
            "Maintain consistent moisture during flowering and fruit development."
        ));

        plants.put("Chili Pepper", chili);


        // SWEET POTATO
        Plant sweetPotato = new Plant("Sweet Potato");

        sweetPotato.addStage("Seed", new PlantStageInfo(
            "Keep propagation medium moist while slips develop.",
            "Bright, warm location.",
            "5.5-6.5",
            "The parent sweet potato provides stored nutrients.",
            "Sweet potatoes are generally started from slips rather than botanical seeds."
        ));

        sweetPotato.addStage("Seedling", new PlantStageInfo(
            "Water regularly while roots and vines establish.",
            "Approximately 6-8 hours of sunlight.",
            "5.5-6.5",
            "Avoid excessive nitrogen; use balanced nutrients as needed.",
            "Transplant healthy slips into loose, well-drained soil."
        ));

        sweetPotato.addStage("Mature", new PlantStageInfo(
            "Water consistently during tuber development. Avoid waterlogged soil.",
            "6-8+ hours of direct sunlight.",
            "5.5-6.5",
            "Avoid excessive nitrogen, which encourages leaves instead of tuber development.",
            "Allow vines to spread. Reduce watering as harvest approaches."
        ));

        plants.put("Sweet Potato", sweetPotato);
    }


    public static Plant getPlant(String name) {
        return plants.get(name);
    }

    public static Collection<Plant> getAllPlants() {
        return plants.values();
    }
}
