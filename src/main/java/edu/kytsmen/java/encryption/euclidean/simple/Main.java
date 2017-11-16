package edu.kytsmen.java.encryption.euclidean.simple;

import edu.kytsmen.java.encryption.euclidean.simple.core.GCD;
import edu.kytsmen.java.encryption.euclidean.utils.InteractionUtils;

public class Main {
    public static void main(String[] args) {
        InteractionUtils.provideUserInterface(GCD::calculate);
    }
}
