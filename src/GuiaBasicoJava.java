/*
 * ============================================================
 *  GUIA Basico Do Java — Arquivo De Referência
 *  Autor: Eduardo Lopes
 *  Cobertura: Tipos, Operadores, Condicionais, Loops,
 *             Casting, Arrays, Collections e POO
 * ============================================================
 *
 * Como Executar:
 *   1. Salve Como GuiaBasicoJava.Java
 *   2. Compile:  Javac GuiaBasicoJava.java
 *   3. Rode:     Java GuiaBasicoJava
 *
 * Obs: O Nome do Arquivo Deve Ser Igual ao da Classe Pública.
 */

// ----------------------------------------------------------------
// Imports.
// Trazem Classes de Outros Pacotes para o Nosso Código.
// Só Importe o Que Realmente Usa (O Import do MediaSizeName Foi Removido).
// ----------------------------------------------------------------

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class GuiaBasicoJava {

    /*
     * Metodo Main — Ponto De Entrada Do Programa
     *
     * Assinatura Obrigatória: Public Static void main(String[] args)
     *  - public : Acessível de Fora da Classe
     *  - static : a JVM chama sem precisar criar um objeto
     *  - void   : Não Retorna Nada
     *  - String[] args : Argumentos Passados Pela Linha de Comando
     */

    public static void main(String[] args) {

        // ========================================================
        // 1. Variaveis E Tipos Primitivos
        // ========================================================
        // Java é de Tipagem Estatica: o Tipo é Declarado e Não Muda.

        byte idadeByte = 25;              // 8 bits  (-128 a 127)
        short ano = 2026;                 // 16 bits
        int idade = 25;                   // 32 bits — o inteiro padrão
        long populacao = 8_000_000_000L;  // 64 bits — precisa do sufixo L
        float precoFloat = 19.99f;        // 32 bits — precisa do sufixo f
        double preco = 19.99;             // 64 bits — decimal padrão
        char letra = 'A';                 // 1 caractere — ASPAS SIMPLES
        boolean ativo = true;             // true ou false

        // String Nao é Primitivo: é Uma Classe (Objeto). Aspas Duplas.
        String nome = "Eduardo";

        System.out.println("=== 1. VARIÁVEIS ===");
        System.out.println("Nome: " + nome + " | Idade: " + idade + " | Ativo: " + ativo);


        // ========================================================
        // 2. Operadores
        // ========================================================
        // Aritméticos:  +  -  *  /  %   (% é o Resto da Divisão)
        // Comparação :  ==  !=  >  <  >=  <=   (Retornam Boolean)
        // Lógicos    :  &&  (E)   ||  (Ou)   !  (Nao)

        int soma = 10 + 3;      // 13
        int resto = 10 % 3;     // 1  (Resto de 10 Dividido Por 3)
        boolean maiorDeIdade = idade >= 18 && ativo; // E Lógico

        System.out.println("\n=== 2. OPERADORES ===");
        System.out.println("10 + 3 = " + soma + " | 10 % 3 = " + resto);
        System.out.println("Maior de idade E ativo? " + maiorDeIdade);


        // ========================================================
        // 3. Condicionais — Toamda De Decisao
        // ========================================================
        System.out.println("\n=== 3. CONDICIONAIS ===");

        if (idade >= 18) {
            System.out.println("Maior De Idade");
        } else if (idade >= 12) {
            System.out.println("Adolescente");
        } else {
            System.out.println("Crianca");
        }

        // Importante!: Para Comparar Texto (String) Use ' .equals() ' Nunca ' == '
        // O == Compara Referência de Memória, Não o Conteúdo.
        if (nome.equals("Eduardo")) {
            System.out.println("O nome é Eduardo (comparado com .equals)");
        }

        // Switch Moderno (Java 14+) — Alternativa Limpa Ao if/else Encadeado
        String faseDaVida = switch (idade / 10) {
            case 0, 1 -> "Jovem";
            case 2, 3 -> "Adulto";
            default   -> "Experiente";
        };
        System.out.println("Fase da vida: " + faseDaVida);


        // ========================================================
        // 4. Arrays (Vetores) — Tamanho Fixo
        // ========================================================
        System.out.println("\n=== 4. ARRAYS ===");

        String[] frutas = {"Banana", "Maca", "Laranja", "Pessego", "Limao"};
        System.out.println("Primeira fruta: " + frutas[0]); // índice começa em 0
        System.out.println("Total de frutas: " + frutas.length); // .length (Sem Parênteses)


        // ========================================================
        // 5. Collections — Lista (Tmanho Dinamico)
        // ========================================================
        // ArrayList Cresce Conforme Você Adiciona Itens.
        System.out.println("\n=== 5. LISTA (ArrayList) ===");

        List<String> emails = new ArrayList<>();
        emails.add("eduardo@email.com");
        emails.add("agatha@email.com");
        emails.add("joao@email.com");


        // ========================================================
        // 6. Loops - Repeticao
        // ========================================================
        System.out.println("\n=== 6. LOOPS ===");

        // -- For: Quando Você Sabe Quantas Vezes / Precisa do Indice --
        // Cuidado: Nao Coloque ; Logo Após o for(...) — Encerra o Loop Vazio!
        List<Double> precos = new ArrayList<>();
        precos.add(19.99);
        precos.add(5.50);
        precos.add(30.00);

        double totalDoCarrinho = 0.0;
        for (int i = 0; i < precos.size(); i++) {
            totalDoCarrinho += precos.get(i);
        }
        System.out.println("Total do carrinho: R$ " + totalDoCarrinho);

        // -- For-Each: Percorrer Coleção sem Precisar do Indice (Mais Idiomático) --
        for (String email : emails) {
            System.out.println("Enviando e-mail para: " + email);
        }

        // -- WHILE: repete ENQUANTO a condição for verdadeira --
        // (condição < , não > — senão o loop nunca executa)
        int contador = 0;
        while (contador < 3) {
            System.out.println("Iteração do while nº " + contador);
            contador++; // sem isso, vira loop infinito
        }


        // ========================================================
        // 7. Casting — Conversao Entre Tipos
        // ========================================================
        System.out.println("\n=== 7. CASTING ===");

        double pi = 3.14159;
        int piArredondado = (int) pi; // Narrowing: Descrata a Parte Decimal (Vira 3)
        System.out.println("(int) 3.14159 = " + piArredondado);

        int numero = 10;
        double numeroComoDouble = numero; // Widening: automático, sem Perda
        System.out.println("int 10 vira double = " + numeroComoDouble);


        // ========================================================
        // 8. Poo — Criando e Usando Objetos
        // ========================================================
        System.out.println("\n=== 8. POO ===");

        // Instanciando Objetos a Partir do Molde (classe) Pessoa
        Pessoa pessoa1 = new Pessoa("Eduardo", 25);
        Pessoa pessoa2 = new Pessoa("Agatha", 30);

        pessoa1.apresentar();
        pessoa2.apresentar();


        // ========================================================
        // 9. Leitura DO Teclado (Scanner) — Opcional
        // ========================================================
        // Descomente o Bloco Abaixo para Testar Entrada do Usuário.
        /*
        Scanner leitor = new Scanner(System.in);
        String comando = "";
        while (!comando.equals("Sair")) {
            System.out.println("Digite Um Comando (Ou 'Sair'):");
            comando = leitor.nextLine();
            System.out.println("Voce Digitou: " + Comando);
        }
        System.out.println("Programa Encerrado.");
        leitor.close(); // Sempre Feche o Scanner
        */
    }
}


/*
 * ============================================================
 *  Poo — A Classe Pessoa
 * ============================================================
 * Uma Classe é um Molde. Um Objeto é uma Instância Desse Molde.
 *
 * Demonstra o Pilar do Encapsulamento:
 *  - Atributos São "private" (Protegidos do Acesso Externo Direto)
 *  - O Acesso Acontece por Getters e Setters (Métodos Públicos)
 */
class Pessoa {

    // ATRIBUTOS (private = encapsulados)
    private String nome;
    private int idade;

    //  Construtor: Define Como o Objeto Nasce.
    // "this.nome" = Atributo da Classe; "nome" = Parâmetro Recebido.
    public Pessoa(String nome, int idade) {
        this.nome = nome;
        this.idade = idade;
    }

    // Getters E Setters: Acesso Controlado Aos Atributos
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getIdade() {
        return idade;
    }

    public void setIdade(int idade) {
        this.idade = idade;
    }

    // Metodo de Comportamento
    public void apresentar() {
        System.out.println("Olá, meu nome é " + nome + " e tenho " + idade + " anos.");
    }
}