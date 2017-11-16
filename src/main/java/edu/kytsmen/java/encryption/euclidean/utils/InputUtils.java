package edu.kytsmen.java.encryption.euclidean.utils;

import edu.kytsmen.java.encryption.euclidean.dto.NumberInput;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public final class InputUtils {
    private InputUtils() {
    }

    public static int getIntegerInput(String message, BufferedReader reader) throws IOException {
        System.out.println(message);
        String line = reader.readLine();
        return parseInt(line);
    }

    public static int parseInt(String line) {
        try {
            return Integer.parseInt(line);
        }catch (NumberFormatException e) {
            System.err.println("Invalid format for integer");
            throw new IllegalArgumentException("Provided input is not of type int");
        }
    }

    public static String getStringInput(String message, BufferedReader reader) throws IOException {
        System.out.println(message);
        return reader.readLine();
    }

    public static NumberInput proceedFromConsole(BufferedReader br) throws IOException{
        int a = getIntegerInput("Enter 'a'", br);
        int b = getIntegerInput("Enter 'b'", br);
        return new NumberInput(a, b);
    }

    public static NumberInput getInputDataFromFile(String filePath) {
        NumberInput input = null;
        if (new File(filePath).exists()) {
            try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
                String sCurrentLine;
                if ((sCurrentLine = br.readLine()) != null) {
                    List<String> values = Arrays.stream(sCurrentLine.split(" ")).map(String::trim).collect(Collectors.toList());
                    try {
                        if (values.size()>= 2) {
                            int a = parseInt(values.get(0));
                            int b = parseInt(values.get(1));
                            input = new NumberInput(a, b);
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
        }
        if (input == null) {
            throw new IllegalArgumentException("File doesn't exist");
        }
        return input;
    }
}
