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

  /**
     * Construtor da classe Dragao.
     * @param nome O nome do Dragao.
     * @param idade A idade do dragão é incrementada em 1 a cada hora passado. A partir do 5º dia o dragão pode voar. A partir do 10º dia o dragão pode soltar fogo.
     * @param acao O que o Dragao está fazendo.
     * @param fome Se o dragao esta com fome.
     * @param sono Se o dragao esta com sono.
     * @param fogo Se o dragao pode soltar fogo.
     * @param voar Se o dragao pode voar.
     * @param fazendo Se o dragão esta fazendo algo como comendo ou dormindo o jogador deve esperar.
     * @param palavraFogo É o comando para o dragão soltar fogo, algo como " Dracarys !!! "
     * @param cor É a cor do dragão, escolhida aleatoriamente.
     * Não deixe o dragão ficar com fome,sono ou irritado, ele pode fazer um estrago !!!
     
     */

public class Dragao{

  private final String nome;
  private final String cor;
  String acao;
  int idade; 
  String palavraFogo;
  bool sono;   
  bool fazendo;
  bool fogo;
  bool fome;
  bool voar;
  bool irritado;
  
 /**
  * Cada ação que o jogador toma o tempo é incrementado em 1. É de manhã quando o tempo é menor que 9 e noite quando o tempo é no período 10 a 15. Quando o contador chega a 16 ele é resetado para 0.  
  */
  
  static{
    
  String nomeJogador;
    
  int tempo = 0;

  }

  /**
  * Sorteia a cor do dragao
  */

  public static String sortearCor() {

        String[] cores = {"Vermelho", "Verde", "Preto", "Branco","Amarelo"};
        
        Random random = new Random();
        
        return cores[random.nextInt(cores.length)];
    }
/**
  * Setta o nome do jogador
  */
  public void nomeJogadorSet(){
    if (nomeJogador){
      System.out.printf("O jogador %s já possui nome. \n",nomeJogador);
    }else{
      System.out.println("Bem vindo!")
      Scanner scanner = new Scanner(System.in);
      System.out.print("Digite seu nome: ");
      String nome = scanner.nextLine(); 
  }
    
  /**
  * Construtor da classe dragão
  */
  
  Dragao(String nome){
   this.nome = nome;
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
  * A primeira interação do jogador com o dragão, da um nome para o dragão.
  * @return Retorna o dragao criado via construtor
  */
  
  public Dragao darNome_Ovo(){
    
    Scanner scanner = new Scanner(System.in);
    
    System.out.println("*** Seu ovo de dragão esta chocando !!! ***")
      
    System.out.println("Digite o nome do seu dragão: ");
    
    String name = scanner.nextLine(); 
    
    Dragao D = new Dragao(name);
    
    System.out.printf("[%s] : Seu nome será %s ! \n", nomeJogador , nome);
    
    return D;
    
  }

  public void esperar(){
    
    if(idade > 80 && !this.voar){
      System.out.printf("*** Agora o %s pode VOAR !!! \n***", this.nome);
      this.voar = true;
    }
    if(idade > 160 && !this.fogo){
      System.out.printf("*** Agora o %s pode SOLTAR FOGO !!! \n***", this.nome);
      this.fogo= true;
      System.out.printf("Digite a palavra de ataque do %s: \n", this.nome);
      Scanner scanner = new Scanner(System.in);
      String f = scanner.nextLine();
      this.palavraFogo = f;
      
    }
    
    if (!this.fazendo){
      System.out.println("O dragão não está fazendo nada...")
        return;
    }else if (this.fazendo && this.acao.equals("Dormindo")){
      System.out.println("Esperando ele dormir");
      Thread.sleep(2000);
      System.out.println("Esperando ele dormir.");
      Thread.sleep(2000);
      System.out.println("Esperando ele dormir..");
      Thread.sleep(2000);
      System.out.println("Esperando ele dormir...");
      Thread.sleep(1000);
      System.out.printf("O %s acordou! \n",this.nome); 
      tempo += 6;
      this.idade += 6;
      this.fazendo = false;
      this.acao = "Nada";
      this.sono = false;
    }else if (this.fazendo && this.acao.equals("Comendo")){
      System.out.println("Esperando ele comer");
      Thread.sleep(500);
      System.out.println("Esperando ele comer.");
      Thread.sleep(500);
      System.out.println("Esperando ele dormir..");
      Thread.sleep(500);
      System.out.println("Esperando ele dormir..");
      Thread.sleep(500);
      System.out.printf("O %s terminou de comer. \n",this.nome); 
      tempo += 2;
      this.idade += 2;
      this.fazendo = false;
      this.acao = "Nada";
      this.fome = false;
    }
    

    public void darComida(){
      if (this.fazendo && this.acao.equals("Comendo")){
        System.out.printf("O %s já está comendo... Você deve esperar \n",this.nome);
        return;
      }
      if (this.fazendo){
        System.out.printf("O %s está %s \n",this.nome,this.acao);
        return;
      }
      if (this.fome){
        System.out.printf("*** Você deu comida para o %s, agora você deve esperar ele terminar *** \n",this.nome);
        this.fazendo = true;
        this.acao = "Comendo";
        return;
}

      public void porDurmir(){
      if (this.fazendo && this.acao.equals("Dormindo")){
        System.out.printf("O %s já está dormindo... Você deve esperar \n",this.nome);
        return;
      }
      if (this.fazendo){
        System.out.printf("O %s está %s \n",this.nome,this.acao);
        return;
      }
      if (this.sono){
        System.out.printf("*** Você colocou %s para dormir, agora você deve esperar ele terminar *** \n",this.nome);
        this.fazendo = true;
        this.acao = "Dormindo";
        return;
}
      


