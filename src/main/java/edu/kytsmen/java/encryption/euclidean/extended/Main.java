package edu.kytsmen.java.encryption.euclidean.extended;

import edu.kytsmen.java.encryption.euclidean.extended.core.GCDExtended;
import edu.kytsmen.java.encryption.euclidean.utils.InteractionUtils;

public class Main {
    public static void main(String[] args) {
        InteractionUtils.provideUserInterface(GCDExtended::calculate);
    }
}
