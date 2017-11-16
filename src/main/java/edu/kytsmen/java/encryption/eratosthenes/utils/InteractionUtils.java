package edu.kytsmen.java.encryption.eratosthenes.utils;

import edu.kytsmen.java.encryption.eratosthenes.dto.Result;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.function.Function;


public class InteractionUtils {

    public static void provideUserInterface(Function<Integer, Result> function) {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            int choose = edu.kytsmen.java.encryption.euclidean.utils.InputUtils.getIntegerInput("Press '1' to enter value manually\nPress '2' to enter value from file", br);
            Integer n = null;
            switch (choose) {
                case 1:
                    n = InputUtils.proceedFromConsole(br);
                    break;
                case 2:
                    String filePath = edu.kytsmen.java.encryption.euclidean.utils.InputUtils.getStringInput("Please provide absolute path to file with input data", br);
                    n = InputUtils.getInputDataFromFile(filePath);
                    break;
                default:
                    System.out.println("You have choosen invalid number. The program will shutdown.");
                    break;
            }
            if (n != null) {
                System.out.println(function.apply(n));
            } else {
                System.out.println("Provided input cannot be parsed");
            }
        } catch (IOException e) {
            e.printStackTrace();
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }
}

