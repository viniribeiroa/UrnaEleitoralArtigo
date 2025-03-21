package com.stormdev;

import java.security.*;

class Block {
    private String previousHash;
    private String vote;
    private long timestamp;
    private String hash;
    private int nonce;

    public Block(String previousHash, String vote) {
        this.previousHash = previousHash;
        this.vote = vote;
        this.timestamp = System.currentTimeMillis();
        mineBlock(4);
    }

    public String calculateHash() {
        try {
            MessageDigest digest = MessageDigest.getInstance("SHA-256");
            String input = previousHash + vote + timestamp + nonce;
            byte[] hashBytes = digest.digest(input.getBytes());
            StringBuilder hexString = new StringBuilder();
            for (byte b : hashBytes) {
                hexString.append(String.format("%02x", b));
            }
            return hexString.toString();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public void mineBlock(int difficulty) {
        String target = new String(new char[difficulty]).replace('\0', '0');
        do {
            nonce++;
            hash = calculateHash();
        } while (!hash.substring(0, difficulty).equals(target));
    }

    public String getHash() { return hash; }
    public String getPreviousHash() { return previousHash; }
}

