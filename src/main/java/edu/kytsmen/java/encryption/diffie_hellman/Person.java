//package edu.kytsmen.java.encryption.diffie_hellman;
//
//import javax.crypto.Cipher;
//import javax.crypto.KeyAgreement;
//import javax.crypto.spec.SecretKeySpec;
//import java.security.KeyPairGenerator;
//import java.security.PrivateKey;
//import java.security.PublicKey;
//
//public class Person {
//    private PrivateKey privateKey;
//    private PublicKey publicKey;
//    private PrivateKey recievedPublicKey;
//    private byte[] secretKey;
//    private String secretMessage;
//
//    public void encryptAndSendMEssage(final String message, final Person person) {
//        try {
//            final SecretKeySpec keySpec = new SecretKeySpec(secretKey, "DES");
//            final Cipher cipher = Cipher.getInstance("DES/ECB/PKS5Padding");
//
//            cipher.init(Cipher.ENCRYPT_MODE, keySpec);
//            final byte[] encryptedMessage = cipher.doFinal(message.getBytes());
//
//        } catch ()
//    }
//
//    public void generateCommonSecretKey() {
//        try {
//            final KeyAgreement keyAgreement = KeyAgreement.getInstance("DH");
//            keyAgreement.init(privateKey);
//            keyAgreement.doPhase(recievedPublicKey, true);
//
//            secretKey = shortenSecretKey(keyAgreement.generateSecret());
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//    }
//
//    public void generateKeys() {
//        try {
//            final KeyPairGenerator keyPairGenerator = KeyPairGenerator.getInstance("DH");
//            keyPairGenerator.initialize(1024);
//
//        }
//    }
//
//    private byte[] shortenSecretKey(final byte[] longKey) {
//        try {
//            final byte[] shortenedKey = new byte[8];
//
//            System.arraycopy(longKey, 0, shortenedKey, 0, shortenedKey.length);
//
//            return shortenedKey;
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//    }
//}
