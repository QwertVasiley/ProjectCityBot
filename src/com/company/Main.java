package com.company;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws IOException {

        List<String> nameCity = new ArrayList<>();  //мой список городов

        FileReader readTxt = null; //получаю доступ к списку городов
        try {
            readTxt = new FileReader("src/com/company/city.dat");
        } catch (FileNotFoundException e) {
            System.out.println("Отсутствует файл списка городов");
            e.printStackTrace();
        }
        Scanner scanner = new Scanner(readTxt); //читаю сканером список
        String oneCity; // завел переменнуюб куда со сканера будет ложиться город

        while (scanner.hasNext()) {  // загоняю весь список городов в List nameCity
            oneCity = scanner.nextLine();
            nameCity.add(oneCity);
        }

        //работаю со списком городов, которые уже были названы
        List<String> oldNameCity = new ArrayList<>();
        FileReader readOldTxt = null;
        try {
            readOldTxt = new FileReader("src/com/company/yee.dat");

        } catch (FileNotFoundException e) {
            System.out.println("Отсутствует файл хранения названных городов");
            e.printStackTrace();
        }

        Scanner scanner1 = new Scanner(readOldTxt);
        String oneOldCity;

        while (scanner1.hasNext()){
            oneOldCity = scanner1.nextLine();
            oldNameCity.add(oneOldCity);
        }
       // readOldTxt.close();  // наверное не обязательно
        LogicBot logicBot = new LogicBot(nameCity,oldNameCity);



    }
}
