/*
___  ___          _      _                            
|  \/  |         | |    | |                           
| .  . | ___   __| | ___| | __ _  __ _  ___ _ __ ___  
| |\/| |/ _ \ / _` |/ _ \ |/ _` |/ _` |/ _ \ '_ ` _ \ 
| |  | | (_) | (_| |  __/ | (_| | (_| |  __/ | | | | |
\_|  |_/\___/ \__,_|\___|_|\__,_|\__, |\___|_| |_| |_|
                                  __/ |               
                                 |___/                
*/
// Este código será reservado para uma prática de modelagem. (Biblioteca, Datas e Retangulos)
--------------------------------------------------------------------------------------------------------------------------------------------------------------------
// Biblioteca

--- Livro.java ---
package Biblioteca;

public class Livro {   
    private String titulo;
    private String autor;
    private String isbn;
    private int anoPublicacao;
    private boolean emprestado;

    public Livro(String titulo, String autor, String isbn, int anoPublicacao, boolean emprestado) {
        this.titulo = titulo;
        this.autor = autor;
        this.isbn = isbn;
        this.anoPublicacao = anoPublicacao;
        this.emprestado = emprestado;
    }

    public void emprestar() {
        if (this.emprestado) {
            throw new IllegalStateException("Livro já está emprestado.");
        } else {
            this.emprestado = true;
        }         
    }

    public void devolver() {
        if (!this.emprestado) {
            throw new IllegalStateException("Livro já está na biblioteca.");
        } else {
            this.emprestado = false;
        }         
    }

    public boolean estaEmprestado() {
        return this.emprestado;
    }

    public static Livro cadastrar(String titulo, String autor, String isbn, int anoPublicacao, boolean emprestado) {
        return new Livro(titulo, autor, isbn, anoPublicacao, emprestado);
    }

    public String getIsbn() {
        return isbn;
    }
}

XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX
--- Biblioteca.java ---
package Biblioteca;

import java.util.ArrayList;

public class Biblioteca {

    private ArrayList<Livro> acervo;

    public Biblioteca() {
        this.acervo = new ArrayList<Livro>();
    }

    public void adicionaLivro(Livro livro) {
        this.acervo.add(livro);
    }

    public void removeLivroByIsbn(String isbn) {
        for (Livro livro : this.acervo) {
            if (isbn.equals(livro.getIsbn())) {
                this.acervo.remove(livro);
                break;
            }
        }
    }

    public ArrayList<Livro> getEmprestados() {
        ArrayList<Livro> emprestados = new ArrayList<>();
        for (Livro livro : acervo) {
            if (livro.estaEmprestado()) {
                emprestados.add(livro);
            }
        }
        return emprestados;
    }

    public ArrayList<Livro> getDisponiveis() {
        ArrayList<Livro> disponiveis = new ArrayList<>();
        for (Livro livro : acervo) {
            if (!livro.estaEmprestado()) {
                disponiveis.add(livro);
            }
        }
        return disponiveis;
    }
}


--------------------------------------------------------------------------------------------------------------------------------------------------------------------
// Datas
---data.java---
package calendario;
import java.util.ArrayList;

public class data{

private static final int[] MESES_COM_31_DIAS = {1, 3, 5, 7, 8, 10, 12};
private static final int[] MESES_COM_30_DIAS = {4, 6, 9, 11};

  
  int dia;
  int mes;
  int ano;

      data(int d, int m, int a){
      
          if (m < 1 || m > 12) {
              throw new IllegalArgumentException("Data inválida");
          }
          if (d < 1 || d > 31) {
              throw new IllegalArgumentException("Data inválida"); 
          }
          if (MESES_COM_31_DIAS.contains(m) && d > 31) {
              throw new IllegalArgumentException("Data inválida");
          }
          if (MESES_COM_30_DIAS.contains(m) && d > 30) {
              throw new IllegalArgumentException("Data inválida"); 
          }
          if (m == 2) {
              if ((a % 4 == 0 && a % 100 != 0) || (a % 400 == 0) && d > 29) {
                  throw new IllegalArgumentException("Data inválida"); 
              } else if ((a % 4 == 0 && a % 100 != 0) || (a % 400 == 0) && d > 28) {
                  throw new IllegalArgumentException("Data inválida");
              }
          }

      boolean eBissexto(){
        if (a % 4 == 0 && a % 100 != 0) || (a % 400 == 0) && d > 28){
          return true;
        }else{
          return false;
        }

      boolean eAnterior(Data x){
         if(this.dia < x.dia && this.mes <= x.mes){
              return true;
      }else{
        return false;
      }

      boolean eDepois(Data x){
         if(this.dia > x.dia && this.mes >= x.mes){
              return true;
      }else{
        return false;
      }

      String toString(){
          String s = String.format("%d/%d/%d",this.dia,this.mes,this.ano);
          return s;
  }
        
--------------------------------------------------------------------------------------------------------------------------------------------------------------------
// Retangulos
  
---retangulo.java---
  
package retangulo;

import java.util.ArrayList;

public class Retangulo {

    private ArrayList<Float> centro;
    private float altura;
    private float largura;

    public Retangulo(float altura, float largura) {
        if (altura < 0 || largura < 0) {
            throw new IllegalArgumentException("Distâncias não podem ser negativas...");
        }
        this.altura = altura;
        this.largura = largura;

        this.centro = new ArrayList<>();
        this.centro.add(largura / 2);
        this.centro.add(altura / 2);
    }

    public float area() {
        return this.altura * this.largura;
    }

    public float perimetro() {
        return 2 * (this.altura + this.largura);
    }

    public boolean pontoDentro(ArrayList<Float> ponto) {
        if (ponto.get(0) < this.centro.get(0) + this.largura / 2 &&
            ponto.get(0) > this.centro.get(0) - this.largura / 2 &&
            ponto.get(1) < this.centro.get(1) + this.altura / 2 &&
            ponto.get(1) > this.centro.get(1) - this.altura / 2) {
            return true;
        } else {
            return false;
        }
    }

    public boolean contemRetangulo(Retangulo r) {
        if ((this.centro.get(0) + this.largura / 2 > r.centro.get(0) + r.largura / 2) &&
            (this.centro.get(0) - this.largura / 2 < r.centro.get(0) - r.largura / 2) &&
            (this.centro.get(1) + this.altura / 2 > r.centro.get(1) + r.altura / 2) &&
            (this.centro.get(1) - this.altura / 2 < r.centro.get(1) - r.altura / 2)) {
            return true;
        } else {
            return false;
        }
    }

    public boolean interseciona(Retangulo b) {
        boolean aEsquerdaDeB = this.centro.get(0) + this.largura / 2 < b.centro.get(0) - b.largura / 2;
        boolean aDireitaDeB = this.centro.get(0) - this.largura / 2 > b.centro.get(0) + b.largura / 2;
        boolean aAbaixoDeB = this.centro.get(1) + this.altura / 2 < b.centro.get(1) - b.altura / 2;
        boolean aAcimaDeB = this.centro.get(1) - this.altura / 2 > b.centro.get(1) + b.altura / 2;

        return !aEsquerdaDeB && !aDireitaDeB && !aAcimaDeB && !aAbaixoDeB;
    }
}



}

--------------------------------------------------------------------------------------------------------------------------------------------------------------------
// Tocador de musicas e playlists




---Playlist.java---
  
package MediaPlayer
  
import java.util.ArrayList; 

public class Playlist(){
    ArrayList<Music> queue;
    String nome;

    Playlist(String nome){
      this.queue = new ArrayList<>();
      this.nome = nome;
}
    public void addMusic(Music x){
        this.queue.add(x)
      }

    public void removeMusic(Music x){
        this.queue.remove(x);
    }

}  
    public String getNome(){
      return this.nome
}
    public void setNome(String nome){
      this.nome = nome;
}

public int getSize() {
        return queue.size();
  }
public String toString() {
        // DEVE-SE UTILIZA O STRING BUILDER já que ele é mais eficiente que o operador '+'
        StringBuilder sb = new StringBuilder();
        int i = 1;

        sb.append(this.title);
       
        for (Music x : this.queue) {
            sb.append(i++ + ". ").append(x).append("\n");
        }

        return sb.toString();
    }

public Music[] getMusics() {
      
        return this.queue.toArray(new Music[0]);
    }
}




XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX
  
---Music.java---
  
package MediaPlayer
  
import java.util.ArrayList; 

public class Music{
  
    String titulo;
    String artista;
    String album;
    int ano;
    int tempo; // em segundos
}

public String converte(){
      String retorno;
    
      int total = this.tempo;
    
      int horas = total / 3600;
      int minutos = (total % 3600) / 60;
      int segundosRestantes = total % 60;

      retorno =  String.format("%02d:%02d:%02d", horas, minutos, segundosRestantes);
      
      return retorno;

      
  }


public String getTitle() {
        return this.titulo;
    }

    public String getArtist() {
        return this.artista;
    }

    public Duration getDuration() {
        return this.tempo.converte();
    }

    public String getAlbum() {
        return this.album;
    }

    public int getYear() {
        return this.ano;
    }

    public String toString() {
        return this.titulo + " - " + this.artista + " (" + this.album + ", " + this.ano + ") " + this.tempo;
    }
}

XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX  
  
---MediaPlayer.java---
  
package MediaPlayer;

import java.util.ArrayList; 

public class MediaPlayer{

    private ArrayList<Track> queue;
    private boolean playing;
    private int volume;
    private Music currentTrack;


    public Player() {
        this.queue = new ArrayList<>();
        this.playing = false;
        this.volume = 50;
        this.currentTrack = null;
    }

    public void addTrack(Music x) {
        this.queue.add(x);
    }

    public void addPlaylist(Playlist playlist) {
        for (Music x : playlist.getMusic()) {
            addTrack(x);
        }
    }

    public void removeTrack(Music x) {
        this.queue.remove(x);
    }
     public void play() {
        if (queue.size() == 0) {
            throw new IllegalStateException("Nenhuma faixa na playlist");
        }
        if (currentTrack == null) {
            currentTrack = queue.get(0);
        }
        playing = true;
    }

     public void pause() {
        stop();
    }

    public void stop() {
        playing = false;
    }

    public boolean isPlaying() {
        return playing;
    }

     public Track getCurrentTrack() {
        return currentTrack;
    }

    public void next() {
        if (queue.size() == 0) {
            throw new IllegalStateException("Nenhuma faixa na playlist");
        }
        int index = queue.indexOf(currentTrack);
        index++;

        if (index >= queue.size()) {
            index = 0;
            stop();
        }
        currentTrack = queue.get(index);
    }


    public void previous() {
        if (queue.size() == 0) {
            throw new IllegalStateException("Nenhuma faixa na playlist");
        }
        int index = queue.indexOf(currentTrack);
        index--;

        if (index < 0) {
            index = 0;
        }
        currentTrack = queue.get(index);
    }

   
    public void shuffle() {
        if (queue.size() == 0) {
            return;
        }
        int index = queue.indexOf(currentTrack);
        ArrayList<Track> remainingQueue = new ArrayList<>(queue.subList(index, queue.size()));
        Collections.shuffle(remainingQueue);
        
        queue.subList(index, queue.size()).clear();
        queue.addAll(remainingQueue);
    }
}

  






















}





  

  
