package com.stormdev;

import java.util.*;

class Blockchain {
    private List<Block> chain;

    public Blockchain() {
        chain = new ArrayList<>();
        chain.add(new Block("0", "Genesis Block"));
    }

    public void addBlock(String vote) {
        Block newBlock = new Block(chain.get(chain.size() - 1).getHash(), vote);
        chain.add(newBlock);
    }

    public boolean isChainValid() {
        for (int i = 1; i < chain.size(); i++) {
            Block currentBlock = chain.get(i);
            Block previousBlock = chain.get(i - 1);
            
            if (!currentBlock.getHash().equals(currentBlock.calculateHash())) {
                return false;
            }
            
            if (!currentBlock.getPreviousHash().equals(previousBlock.getHash())) {
                return false;
            }
        }
        return true;
    }

    public void displayChain() {
        for (Block block : chain) {
            System.out.println("Hash: " + block.getHash());
            System.out.println("Previous Hash: " + block.getPreviousHash());
            System.out.println("======================");
        }
    }
}

