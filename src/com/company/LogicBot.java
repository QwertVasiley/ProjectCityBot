package com.company;

import java.io.IOException;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class LogicBot {

    private List<String> arrayCityBase;
    private List<String> oldArrayCity;
    String myCity; //загаданый или введенный город
    char charLastLeter; //последняя буква названии города
    String cityByUser;


    public LogicBot(List<String> arrayCityBase, List<String> oldArrayCity) throws IOException {
        this.arrayCityBase = arrayCityBase;
        this.oldArrayCity = oldArrayCity;

        Random rnd = new Random();
        int number = arrayCityBase.size() - 1;
        System.out.println("В базе " + number + " городов");
        int rndNum = rnd.nextInt(number);
       // System.out.println(rndNum + " Номер случайного города из базы");
        myCity = arrayCityBase.get(rndNum); // выбранный город -> String
        System.out.println("Старт игры, я начну первым и мой город: " + myCity.toUpperCase()); //поднял в верхний регистр название города

        findBeadLastLiter(myCity);

        boolean cicle = true;
        while ( cicle = true) {
            System.out.println("Вспоминаем город на букву " + Character.toUpperCase(charLastLeter));
            inputCityByUser();
            compareCityWithOld(oldArrayCity, cityByUser);
            //compareCityWithBase(arrayCityBase,  cityByUser);
            findBeadLastLiter(myCity);
        }
    }

    public char findBeadLastLiter (String myCity){
        int indexLastGoogLiter = 1; //для индекса последней буквы завел переменную
        int last = myCity.length() - indexLastGoogLiter;  //нахожу последний символ в названии города
        charLastLeter = myCity.charAt(last); //присваиваю его charLastLeter
        //ПРОВЕРКА НА ПОСЛЕДНЮЮ БУКВУ, КОТОРАЯ ВНЕ ИГРЫ "Ы" "Ъ" "Ё" "Й" "Ь"
        boolean goodLiter = false;
        while (goodLiter == false) {
            if (charLastLeter == 'ы' || charLastLeter == 'ъ' || charLastLeter == 'ё' || charLastLeter == 'й' || charLastLeter == 'ь') {
                indexLastGoogLiter++;
                last = myCity.length() - indexLastGoogLiter;
                charLastLeter = myCity.charAt(last);
                goodLiter = false;
            } else {
                goodLiter = true;
            }
        }
        return charLastLeter;
    }

    public void compareCityWithOld (List<String> oldArrayCity, String cityByUser) throws IOException {
        //проверка городов, которые называли
        for (Object old : oldArrayCity) {
            String oldCity = old.toString();
            if (oldCity.equalsIgnoreCase(cityByUser)) {
                System.out.println("Такой город уже называли");
                return;
            }
        }
        compareCityWithBase(arrayCityBase, cityByUser);
    }
        public void compareCityWithBase (List<String> arrayCityBase, String name) throws IOException {
    //сравнение введенного города с базой городов
                for (Object oCity : arrayCityBase) {
                    String aCity = oCity.toString(); //создал переменную типа String
                    if (aCity.equalsIgnoreCase(cityByUser)) { //сравнил без учета регистра
                        System.out.println("Молодец, есть город " + oCity);

                        // вызываю метод для записи в список названных городов
                        WriteYeeDat writeYeeDat = new WriteYeeDat((String) oCity, oldArrayCity);
                        myCity = cityByUser;
                        return;
                    }
                }
        System.out.println("Города " + name.toUpperCase() + " я не знаю, попробуй другой");
    }

    public String inputCityByUser (){
        Scanner inputUserCity = new Scanner(System.in);
        //System.out.println("Введи свой город: ");
        cityByUser = inputUserCity.nextLine();
        return cityByUser;
    }
}
