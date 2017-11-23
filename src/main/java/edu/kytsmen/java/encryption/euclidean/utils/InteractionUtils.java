package edu.kytsmen.java.encryption.euclidean.utils;

import edu.kytsmen.java.encryption.euclidean.dto.NumberInput;
import edu.kytsmen.java.encryption.euclidean.dto.result.Result;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.function.Function;

import static edu.kytsmen.java.encryption.euclidean.utils.InputUtils.getInputDataFromFile;
import static edu.kytsmen.java.encryption.euclidean.utils.InputUtils.getStringInput;
import static edu.kytsmen.java.encryption.euclidean.utils.InputUtils.proceedFromConsole;

public class InteractionUtils {
    public static void provideUserInterface(Function<NumberInput, Result> function) {
            try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
                int choose = InputUtils.getIntegerInput("Press '1' to enter values manually\nPress '2' to enter values from file", br);
                NumberInput input = null;
                switch (choose) {
                    case 1:
                        input = proceedFromConsole(br);
                        break;
                    case 2:
                        String filePath = getStringInput("Please provide absolute path to file with input data", br);
                        input = getInputDataFromFile(filePath);
                        break;
                    default:
                        System.out.println("You have chosen invalid number. The program will shutdown.");
                        break;
                }
                if (input != null) {
                    System.out.println(function.apply(input));
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
