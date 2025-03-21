package com.stormdev;

import java.util.*;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class UrnaEletronicaBlockchain {
    private static Map<String, Eleitor> eleitores;
    private static Blockchain blockchain;

    public static void main(String[] args) {
    	SpringApplication.run(UrnaEletronicaBlockchain.class, args);
        blockchain = new Blockchain();
        eleitores = new HashMap<>();
        eleitores.put("12345678900", new Eleitor("12345678900", true, "biometric_hash_123"));
        eleitores.put("98765432100", new Eleitor("98765432100", false, "biometric_hash_987"));
        
        Scanner scanner = new Scanner(System.in);
        System.out.print("Digite seu CPF: ");
        String cpf = scanner.nextLine();
        
        if (!eleitores.containsKey(cpf) || !eleitores.get(cpf).podeVotar()) {
            System.out.println("Voto negado! Eleitor não autorizado.");
            return;
        }
        
        System.out.print("Digite a autenticação biométrica: ");
        String biometricInput = scanner.nextLine();
        
        System.out.println("Seu token de autenticação foi enviado. Digite o token: ");
        String inputToken = scanner.nextLine();
        
        if (!eleitores.get(cpf).autenticar(biometricInput, inputToken)) {
            System.out.println("Autenticação falhou! Voto não permitido.");
            return;
        }
        
        System.out.print("Digite seu voto: ");
        String voto = scanner.nextLine();
        blockchain.addBlock(voto);
        
        System.out.println("Voto registrado com sucesso!");
        
        if (!blockchain.isChainValid()) {
            System.out.println("Erro de integridade detectado! Sistema pode estar comprometido.");
            return;
        }
        
        blockchain.displayChain();
    }
}
