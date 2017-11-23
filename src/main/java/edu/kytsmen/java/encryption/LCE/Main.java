package edu.kytsmen.java.encryption.LCE;

import edu.kytsmen.java.encryption.LCE.core.EquasionSolver;
import edu.kytsmen.java.encryption.LCE.utils.InteractionUtils;

public class Main {
    public static void main(String[] args) {
        InteractionUtils.provideUserInterface(EquasionSolver::solve);
    }
}
