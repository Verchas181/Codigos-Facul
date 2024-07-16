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
        this.acervo = new ArrayList<>();
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































  
