# Urna Eletrônica Baseada em Blockchain

## Introdução

A segurança dos sistemas eleitorais tem sido um dos maiores desafios enfrentados pela democracia moderna. A urna eletrônica tradicional, como a utilizada no Brasil, enfrenta questionamentos quanto à transparência e à possibilidade de manipulação. Uma solução inovadora para esses problemas é a aplicação da tecnologia blockchain, garantindo integridade, imutabilidade e auditabilidade do processo eleitoral.

Este repositório apresenta uma implementação de urna eletrônica baseada em blockchain, com autenticação robusta por biometria e autenticação de dois fatores (2FA) via token.

## Funcionamento da Urna Blockchain

A urna blockchain funciona registrando cada voto como um bloco dentro de uma cadeia imutável de blocos. Cada bloco contém:
- O hash do bloco anterior;
- O voto registrado;
- Um timestamp;
- Um hash criptográfico garantindo a autenticidade dos dados.

Para garantir que apenas eleitores autorizados possam votar, o sistema implementa:
1. **Autenticação biométrica**: Comparação de um hash biométrico armazenado.
2. **Autenticação de dois fatores (2FA)**: Um token é gerado e enviado ao eleitor, garantindo que ele está autorizado a votar.

## Comparativo com a Urna Eletrônica Brasileira

| Característica         | Urna Eletrônica Tradicional | Urna Blockchain |
|------------------------|---------------------------|----------------|
| Registro de votos     | Armazenado localmente     | Distribuído e imutável |
| Transparência         | Código fechado            | Código aberto e auditável |
| Segurança contra fraudes | Proteção limitada        | Hashing e mineração |
| Autenticação do eleitor | Apenas biometria         | Biometria + 2FA |
| Auditoria             | Limitada                  | Possível em tempo real |

A urna blockchain oferece maior segurança e transparência, pois elimina a necessidade de confiança em uma única entidade central. Como cada voto é armazenado de forma imutável, qualquer tentativa de manipulação pode ser detectada e invalidada.

## Requisitos

- Java 8+
- Biblioteca `java.security`

## Como Executar

1. Clone o repositório:
   ```sh
   git clone https://github.com/seu-usuario/urna-blockchain.git
   ```
2. Compile e execute o programa:
   ```sh
   javac UrnaEletronicaBlockchain.java
   java UrnaEletronicaBlockchain
   ```

## Contribuição

Contribuições são bem-vindas! Sinta-se à vontade para abrir issues e enviar pull requests.

## Licença

Este projeto está licenciado sob a MIT License.

## Autor

Vinícius Alves Ribeiro

## Referências

- Benaloh, J., Rivest, R., Ryan, P.Y.A., Stark, P., Teague, V., & Vora, P. (2015). "End-to-End Verifiable Elections". *Communications of the ACM, 58*(3), 40-50. DOI: [10.1145/2656445](https://doi.org/10.1145/2656445)
- Narayanan, A., Bonneau, J., Felten, E., Miller, A., & Goldfeder, S. (2016). *Bitcoin and Cryptocurrency Technologies: A Comprehensive Introduction.* Princeton University Press.
- Kshetri, N., & Voas, J. (2018). "Blockchain-Enabled E-Voting". *IEEE Software, 35*(4), 95-99. DOI: [10.1109/MS.2018.2801546](https://doi.org/10.1109/MS.2018.2801546)
- Hardwick, F., Akram, R.N., & Markantonakis, K. (2018). "E-Voting with Blockchain: An E-Voting Protocol with Decentralisation and Voter Privacy". *2018 IEEE 32nd International Conference on Advanced Information Networking and Applications (AINA)*, 438-445. DOI: [10.1109/AINA.2018.00082](https://doi.org/10.1109/AINA.2018.00082)

