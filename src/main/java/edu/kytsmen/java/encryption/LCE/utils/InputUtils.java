package edu.kytsmen.java.encryption.LCE.utils;


import edu.kytsmen.java.encryption.LCE.dto.NumberInput;

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
    public static NumberInput proceedFromConsole(BufferedReader br) throws IOException {
        int a = getIntegerInput("Enter 'a'", br);
        int b = getIntegerInput("Enter 'b'", br);
        int n = getIntegerInput("Enter 'n'", br);
        return new NumberInput(a, b, n);
    }

    public static NumberInput getInputDataFromFile(String filePath) {
        NumberInput input = null;
        if (new File(filePath).exists()) {
            try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
                String sCurrentLine;
                if ((sCurrentLine = br.readLine()) != null) {
                    List<String> values = Arrays.stream(sCurrentLine.split(" ")).map(String::trim).collect(Collectors.toList());
                    try {
                        if (values.size() >= 3) {
                            int a = parseInt(values.get(0));
                            int b = parseInt(values.get(1));
                            int n = parseInt(values.get(2));
                            input = new NumberInput(a, b, n);
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
