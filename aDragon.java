import java.util.Random;
import java.util.Scanner;


/*
         ,     \    /      ,        
       / \    )\__/(     / \       
      /   \  (_\  /_)   /   \      
 ____/_____\__\@  @/___/_____\____ 
|             |\../|              |
|              \VV/               |
|       ------aDragon------       |
|_________________________________|
 |    /\ /      \\       \ /\    | 
 |  /   V        ))       V   \  | 
 |/     `       //        '     \| 
 `              V       

*/

/**
 * Este é um micro projeto pessoal para treino de orientação à objeto. Este projeto consiste em um joguinho textual de pet virtual de um dragão.

 import java.util.Random;
import java.util.Scanner;

/**
 * Classe que representa um jogador no jogo.
 * Contém informações sobre o nome do jogador e sua pontuação.
 */
public class Jogador {
    private String nome;
    private int pontuacao;

    /**
     * Construtor da classe Jogador. Inicializa a pontuação como zero.
     */
    public Jogador() {
        this.pontuacao = 0;
    }

    /**
     * Obtém o nome do jogador.
     * 
     * @return O nome do jogador.
     */
    public String getNome() {
        return nome;
    }

    /**
     * Define o nome do jogador.
     * 
     * @param nome O nome a ser definido para o jogador.
     */
 public void nomeJogadorSet() {
        if (jogador.getNome() != null) {
            System.out.printf("O jogador %s já possui nome.\n", jogador.getNome());
        } else {
            System.out.println("Bem-vindo!");
            Scanner scanner = new Scanner(System.in);
            System.out.print("Digite seu nome: ");
            String nome = scanner.nextLine();
            jogador.setNome(nome);
        }
    }

  

/**
 * Classe que representa o tempo no jogo.
 * Mantém o controle do contador de horas e do estado do dia.
 */
public class Tempo {
    private int contador;

    /**
     * Construtor da classe Tempo. Inicializa o contador como zero.
     */
    public Tempo() {
        this.contador = 0;
    }

    /**
     * Passa o tempo em horas.
     * 
     * @param horas O número de horas a serem avançadas.
     */
    public void passarTempo(int horas) {
        contador = (contador + horas) % 24; // 24 horas em um dia
    }

    /**
     * Verifica se é de manhã.
     * 
     * @return true se for de manhã, caso contrário, false.
     */
    public boolean isManha() {
        return contador < 9;
    }

    /**
     * Verifica se é de noite.
     * 
     * @return true se for de noite, caso contrário, false.
     */
    public boolean isNoite() {
        return contador >= 10 && contador <= 15;
    }

    /**
     * Obtém o contador atual de horas.
     * 
     * @return O contador de horas.
     */
    public int getContador() {
        return contador;
    }
}

/**
 * Classe que representa um dragão no jogo.
 * Contém informações sobre o estado do dragão, como nome, cor, ações e estado.
 */
public class Dragao {
    private final String nome;
    private final String cor;
    private String acao;
    private int idade;
    private String palavraFogo;
    private boolean sono;
    private boolean fazendo;
    private boolean fogo;
    private boolean fome;
    private boolean voar;
    private boolean irritado;

    private Jogador jogador;
    private Tempo tempo;

    /**
     * Construtor da classe Dragão.
     * 
     * @param nome    O nome do dragão.
     * @param jogador O objeto Jogador associado ao dragão.
     * @param tempo   O objeto Tempo associado ao dragão.
     */
    public Dragao(String nome, Jogador jogador, Tempo tempo) {
        this.nome = nome;
        this.jogador = jogador;
        this.tempo = tempo;
        this.sono = false;
        this.acao = "fazendo nada";
        this.fome = true;
        this.idade = 0;
        this.fazendo = false;
        this.palavraFogo = "Nada";
        this.fogo = false;
        this.voar = false;
        this.cor = sortearCor();
    }

    /**
     * Método para sortear a cor do dragão.
     * 
     * @return A cor sorteada para o dragão.
     */
    public static String sortearCor() {
        String[] cores = {"Vermelho", "Verde", "Preto", "Branco", "Amarelo"};
        Random random = new Random();
        return cores[random.nextInt(cores.length)];
    }

    /**
     * Método para o jogador definir seu nome.
     */
   

    /**
     * Método para dar um nome ao ovo do dragão.
     * 
     * @return O objeto Dragão criado com o nome fornecido.
     */
    public Dragao darNome_Ovo() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("*** Seu ovo de dragão está chocando !!! ***");
        System.out.println("Digite o nome do seu dragão: ");
        String name = scanner.nextLine();
        Dragao D = new Dragao(name, jogador, tempo);
        System.out.printf("[%s]: Seu nome será %s !\n", jogador.getNome(), name);
        return D;
    }

    /**
     * Método para esperar o dragão realizar uma ação.
     * 
     * @throws InterruptedException Se a thread for interrompida durante o sono ou a espera.
     */
    public void esperar() throws InterruptedException {
        if (idade > 80 && !this.voar) {
            System.out.printf("*** Agora o %s pode VOAR !!!\n***", this.nome);
            this.voar = true;
        }
        if (idade > 160 && !this.fogo) {
            System.out.printf("*** Agora o %s pode SOLTAR FOGO !!!\n***", this.nome);
            this.fogo = true;
            System.out.printf("Digite a palavra de ataque do %s: \n", this.nome);
            Scanner scanner = new Scanner(System.in);
            String f = scanner.nextLine();
            this.palavraFogo = f;
        }

        if (!this.fazendo) {
            System.out.println("O dragão não está fazendo nada...");
            return;
        } else if (this.fazendo && this.acao.equals("Dormindo")) {
            System.out.println("Esperando ele dormir");
            Thread.sleep(2000);
            System.out.println("Esperando ele dormir.");
            Thread.sleep(2000);
            System.out.println("Esperando ele dormir..");
            Thread.sleep(2000);
            System.out.println("Esperando ele dormir...");
            Thread.sleep(1000);
            System.out.printf("O %s acordou! \n", this.nome);
            tempo.passarTempo(6);
            this.idade += 6;
            this.fazendo = false;
            this.acao = "Nada";
            this.sono = false;
        } else if (this.fazendo && this.acao.equals("Comendo")) {
            System.out.println("Esperando ele comer");
            Thread.sleep(500);
            System.out.println("Esperando ele comer.");
            Thread.sleep(500);
            System.out.println("Esperando ele comer..");
            Thread.sleep(500);
            System.out.printf("O %s terminou de comer. \n", this.nome);
            tempo.passarTempo(2);
            this.idade += 2;
            this.fazendo = false;
            this.acao = "Nada";
            this.fome = false;
        }
    }

    /**
     * Método para dar comida ao dragão.
     */
    public void darComida() {
        if (this.fazendo && this.acao.equals("Comendo")) {
            System.out.printf("O %s já está comendo... Você deve esperar\n", this.nome);
            return;
        }
        if (this.fazendo) {
            System.out.printf("O %s está %s\n", this.nome, this.acao);
            return;
        }
        if (this.fome) {
            System.out.printf("*** Você deu comida para o %s, agora você deve esperar ele terminar ***\n", this.nome);
            this.fazendo = true;
            this.acao = "Comendo";
            return;
        }
    }

    /**
     * Método para colocar o dragão para dormir.
     */
    public void porDormir() {
        if (this.fazendo && this.acao.equals("Dormindo")) {
            System.out.printf("O %s já está dormindo... Você deve esperar\n", this.nome);
            return;
        }
        if (this.fazendo) {
            System.out.printf("O %s está %s\n", this.nome, this.acao);
            return;
        }
        if (this.sono) {
            System.out.printf("*** Você colocou %s para dormir, agora você deve esperar ele terminar ***\n", this.nome);
            this.fazendo = true;
            this.acao = "Dormindo";
            return;
        }
    }
}


