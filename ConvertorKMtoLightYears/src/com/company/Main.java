package com.company;

import java.io.IOException;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Scanner;
import java.util.logging.LogManager;
import java.util.logging.Logger;

public class Main {
        public static void main(String[] args) {
            Logger log = Logger.getLogger(Main.class.getName());
        try {
            LogManager.getLogManager().readConfiguration(
                    Main.class.getResourceAsStream("/logging.properties"));
        } catch (IOException e) {
           log.info("Could not setup logger configuration: " + e.toString());
        }
        log.info("Запуск программы");
        double mul1 = 9460730472580.8;
        BigDecimal mul = BigDecimal.valueOf(mul1);
        Scanner in = new Scanner(System.in);
        System.out.println("Что вы хотите перевести? 1) Если километры в световые года, 2) Если наоборот");
        log.info("Выдан запрос на ввод действия");
        String choice = in.nextLine();
        if (choice.equals("1")) {
            log.info("Выбран перевод километров в световые года");
            System.out.print("Введите значение километров: ");
            log.info("Запрос на ввод километров");
            try {String skm = in.nextLine();
            BigDecimal Kilometres = BigDecimal.valueOf(Double.parseDouble(skm));
            KMtoLY(Kilometres, mul);}
            catch (Exception e) {
                log.severe("Неправильный перевод данных " + e);
            }
        } else if (choice.equals("2")) {
            log.info("Выбран перевод световых лет в километры");
            System.out.print("Введите значение световых лет: ");
            log.info("Запрос на ввод световых лет");
            try {
                String sly = in.nextLine();
            BigDecimal LightYears = BigDecimal.valueOf(Double.parseDouble(sly));
            LYtoKM(LightYears, mul);
            }
            catch (Exception e){
                log.severe("Не удалось создать BigDecimal из String " + e);
            }
        }
    }

    public static void KMtoLY(BigDecimal km, BigDecimal mul){
        BigDecimal answer;
        answer = km.divide(mul, RoundingMode.UNNECESSARY);
        System.out.println(km + " километров равно " + answer + " световых лет");
    }
    public static void LYtoKM(BigDecimal ly, BigDecimal mul){
        BigDecimal answer;
            answer = ly.multiply(mul);
            System.out.println(ly + " световых лет равно " + answer + " километров");
        }
    }


