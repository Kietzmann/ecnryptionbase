package edu.kytsmen.java.encryption.eratosthenes.utils;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static edu.kytsmen.java.encryption.euclidean.utils.InputUtils.getIntegerInput;
import static edu.kytsmen.java.encryption.euclidean.utils.InputUtils.parseInt;

public class InputUtils {
    public static int proceedFromConsole(BufferedReader br) throws IOException {
        int input = getIntegerInput("Enter 'n'", br);
        validateN(input);
        return input;
    }

    public static int getInputDataFromFile(String filePath) {
        Integer input = null;
        if (new File(filePath).exists()) {
            try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
                String sCurrentLine;
                if ((sCurrentLine = br.readLine()) != null) {
                    List<String> values = Arrays.stream(sCurrentLine.split(" ")).map(String::trim).collect(Collectors.toList());
                    try {
                        if (values.size() >= 1) {
                            int n =  parseInt(values.get(0));
                            validateN(n);
                            input = n;
                        } else {
                            throw new IllegalArgumentException("Provided file doesn't contain necessary data");
                        }
                    } catch (IllegalArgumentException e) {
                        throw new IllegalArgumentException(e.getMessage());
                    }
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        } else {
            throw new IllegalArgumentException("File doesn't exist");
        }
        return input;
    }

    public static void validateN(int n) {
        if (n <= 1) {
            throw new IllegalArgumentException("There is no prime numbers less than provided number");
        }
    }

}
