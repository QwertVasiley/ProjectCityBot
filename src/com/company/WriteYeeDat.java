package com.company;

import java.io.FileWriter;
import java.io.IOException;
import java.util.List;


public class WriteYeeDat {
    private String userInputCity;

    public WriteYeeDat() {
    }

    public WriteYeeDat(String userInputCity, List<String> oldNameCity) throws IOException {
        this.userInputCity = userInputCity;

        try {
            FileWriter fileWriter = new FileWriter("src/com/company/yee.dat", true);
           //System.out.println(userInputCity + " Это введенный город");
            fileWriter.append('\n');
            fileWriter.write(userInputCity);
            fileWriter.flush();
            oldNameCity.add(userInputCity);


        } catch (IOException e) {
            System.out.println("Неверно указан путь к файлу с названными городами - yee.dat");
            e.printStackTrace();
        }
    }

    public String getUserInputCity() {
        return userInputCity;
    }

    public void setUserInputCity(String userInputCity) {
        this.userInputCity = userInputCity;

    }
}
