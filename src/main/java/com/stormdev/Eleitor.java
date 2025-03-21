package com.stormdev;

import java.security.*;
import java.util.concurrent.ThreadLocalRandom;

class Eleitor {
    private String cpf;
    private boolean autorizado;
    private String biometricHash;
    private String token;

    public Eleitor(String cpf, boolean autorizado, String biometricHash) {
        this.cpf = cpf;
        this.autorizado = autorizado;
        this.biometricHash = biometricHash;
        this.token = generateToken();
    }

    public boolean podeVotar() {
        return autorizado;
    }

    public boolean autenticar(String biometricInput, String inputToken) {
        return biometricHash.equals(hashBiometricData(biometricInput)) && token.equals(inputToken);
    }

    private String hashBiometricData(String data) {
        try {
            MessageDigest digest = MessageDigest.getInstance("SHA-256");
            byte[] hashBytes = digest.digest(data.getBytes());
            StringBuilder hexString = new StringBuilder();
            for (byte b : hashBytes) {
                hexString.append(String.format("%02x", b));
            }
            return hexString.toString();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    private String generateToken() {
        return String.valueOf(ThreadLocalRandom.current().nextInt(100000, 999999));
    }

    public String getToken() {
        return token;
    }
}
