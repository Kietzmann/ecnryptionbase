package edu.kytsmen.java.encryption.LCE.core;

import edu.kytsmen.java.encryption.LCE.dto.Result;
import edu.kytsmen.java.encryption.LCE.exception.InverseNotExistException;
import edu.kytsmen.java.encryption.euclidean.dto.NumberInput;
import edu.kytsmen.java.encryption.euclidean.dto.result.ExtendedResult;
import edu.kytsmen.java.encryption.euclidean.extended.core.GCDExtended;

public class EquasionSolver {
    public static Result solve(edu.kytsmen.java.encryption.LCE.dto.NumberInput input) throws InverseNotExistException {
        NumberInput inputForGCD = new NumberInput(input.getA(), input.getN());
        ExtendedResult result = GCDExtended.calculate(inputForGCD);
        if (result.getGCD() != 1) {
            throw new InverseNotExistException("Inverse doesn't exist");
        }
        int res = (result.getX() % input.getN() + input.getN()) % input.getN();
        int x = res * input.getB() % input.getN();
        return new Result(x);
    }
}
