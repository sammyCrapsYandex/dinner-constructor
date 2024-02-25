package ru.practicum.dinner;

import java.util.*;

public class DinnerConstructor {

    private static final String COMBO_NAME = "Комбо ";
    HashMap<String, ArrayList<String>> menuMap = new HashMap<>();

    boolean checkType(String type) {
        return !menuMap.isEmpty() && menuMap.containsKey(type);
    }

    boolean checkMap() {
        return !menuMap.isEmpty();
    }

    void printType() {
        for (String type : menuMap.keySet()) {
            System.out.println(type);
        }
    }

    void saveDish(String dishType, String dishName) {
        if (checkType(dishType)) {
            ArrayList<String> dishes = menuMap.get(dishType);
            dishes.add(dishName);
        } else {
            ArrayList<String> dishes = new ArrayList<>();
            dishes.add(dishName);
            menuMap.put(dishType, dishes);
        }
    }

    void generateCombos(int numberOfCombos, ArrayList<String> typeList) {
        Map<String, ArrayList<String>> comboMap = new TreeMap<>();
        Random rnd = new Random();
        for (int i = 0; i < numberOfCombos; i++) {
            ArrayList<String> dishesCombo = new ArrayList<>();

            for (String type : typeList) {
                ArrayList<String> dishes = menuMap.get(type);
                int numberOfDish = rnd.nextInt(dishes.size());
                dishesCombo.add(dishes.get(numberOfDish));
            }
            comboMap.put(COMBO_NAME + i + 1, dishesCombo);
        }
        printCombo(comboMap);
    }

    void printCombo(Map<String, ArrayList<String>> comboMap) {
        for (Map.Entry<String, ArrayList<String>> entry : comboMap.entrySet()) {
            System.out.println(entry.getKey());
            System.out.println(entry.getValue());
        }
    }
}
