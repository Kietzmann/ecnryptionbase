package edu.kytsmen.java.encryption.diffie_hellman;

public class Main {
    public static void main(String[] args) {
        final Person jane = new Person();
        final Person john = new Person();

        jane.generateKeys();
        john.generateKeys();

        jane.receivePublicKeyFrom(john);
        john.receivePublicKeyFrom(jane);

        jane.generateCommonSecretKey();
        john.generateCommonSecretKey();

        jane.encryptAndSendMessage("Guess who I am?", john);

        john.whisperTheSecretMessage();
    }
}
