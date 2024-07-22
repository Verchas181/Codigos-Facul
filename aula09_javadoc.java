/*
   ___                 ______           
  |_  |                |  _  \          
    | | __ ___   ____ _| | | |___   ___ 
    | |/ _` \ \ / / _` | | | / _ \ / __|
/\__/ / (_| |\ V / (_| | |/ / (_) | (__ 
\____/ \__,_| \_/ \__,_|___/ \___/ \___|
                                        
*/
-----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
// Linguagem de marcação. O Javadoc define uma linguagem de marcação para documentar código Java, que inclui tags especiais para documentar classes, métodos, parâmetros, valores de retorno, exceções, etc. 
// A sintaxe dessa linguagem é embutida em comentários regulares do Java, o que facilita a documentação do código.

// Geração automática de documentação. A ferramenta javadoc gera automaticamente documentação a partir dos comentários do código-fonte, seguindo um formato padronizado. 
// A documentação gerada pelo Javadoc é apresentada em formato HTML, o que facilita a leitura e a navegação.

// Aplica-se somente à interface pública. O Javadoc é usado principalmente para documentar a interface pública de uma classe, ou seja, os métodos públicos que a classe define. 
// Os elementos privados não precisam ser documentados, pois não são acessíveis por outras classes.

// Deve-se "explicar" o que cada bloco de código realiza.

-----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------

  ---Estudante.java---

  package universidade;

/**
 * Classe que representa um estudante.
 */
public class Estudante {
    private String nome;
    private int idade;
    private double[] notas;

    /**
     * Construtor da classe Estudante.
     * @param nome O nome do estudante.
     * @param idade A idade do estudante.
     * @param notas As notas do estudante.
     */
    public Estudante(String nome, int idade, double[] notas) {
        this.nome = nome;
        this.idade = idade;
        this.notas = notas;
    }

    /**
     * Retorna o nome do estudante.
     * @return O nome do estudante.
     */
    public String getNome() {
        return nome;
    }

    /**
     * Define o nome do estudante.
     * @param nome O nome do estudante.
     */
    public void setNome(String nome) {
        this.nome = nome;
    }

    /**
     * Retorna a idade do estudante.
     * @return A idade do estudante.
     */
    public int getIdade() {
        return idade;
    }

    /**
     * Define a idade do estudante.
     * @param idade A idade do estudante.
     */
    public void setIdade(int idade) {
        this.idade = idade;
    }

    /**
     * Retorna as notas do estudante.
     * @return As notas do estudante.
     */
    public double[] getNotas() {
        return notas;
    }

    /**
     * Define as notas do estudante.
     * @param notas As notas do estudante.
     */
    public void setNotas(double[] notas) {
        this.notas = notas;
    }

    private double calcularMedia() {
        // Implementação do cálculo da média das notas
        return 0.0;  // exemplo fictício, a implementação real está ausente
    }
}


-----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------

---SINTAXE JAVADOC---
// De início, notamos uma característica peculiar dos comentários Javadoc: eles são precedidos por /** e terminados por */. Além disso, os comentários Javadoc incluem uma ou mais tags, que são palavras-chave precedidas por @. 
// As tags Javadoc são usadas para documentar diferentes partes do código, como classes, métodos, parâmetros, valores de retorno, exceções, etc. 
// Por exemplo, a tag @return é usada para documentar o valor de retorno de um método, a tag @param é usada para documentar os parâmetros de um método, etc.  

/**
 * @param: Descreve um parâmetro de um método.
 * @return: Descreve o valor de retorno de um método.
 * @throws: Descreve as exceções que um método pode lançar.
 * @see: Referência a outras classes ou métodos relacionados.
 * @since: Indica desde qual versão do software a classe ou método está disponível.
 * @deprecated: Marca um método ou classe como obsoleto e fornece uma explicação sobre alternativas.
 */

  
---INTERFACE PÚBLICA E JAVADOC--- 
  
// Outra característica importante que podemos notar no programa é que a documentação Javadoc é aplicada somente nos elementos públicos. 
// Isso é uma prática comum, pois a documentação Javadoc é usada principalmente para documentar a interface pública de uma classe, ou seja, os métodos públicos que a classe define. 
// Os elementos privados, por outro lado, não precisam ser documentados, pois não são acessíveis por outras classes. No entanto, é útil documentar também os métodos privados para facilitar a manutenção da classe pelos desenvolvedores.

  
---DOCUMENTAÇÃO EM HTML--- 
// Uma característica poderosa do Javadoc é a possibilidade de gerar uma página web em HTML com a documentação do código--fonte. 
// Ou melhor, o Javadoc gera uma página HTML para cada classe, que inclui a documentação dos métodos da classe, incluindo a descrição da classe, a descrição dos métodos, os parâmetros dos métodos, os valores de retorno dos métodos, etc.
// A documentação gerada pelo Javadoc é bastante útil para entender como usar uma classe, quais métodos ela define, quais parâmetros eles aceitam, etc.
// Para isso, basta executar a ferramenta Javadoc passando como argumento o arquivo Java que contém os comentários Javadoc. Por exemplo, para gerar a documentação da classe Estudante, podemos executar o seguinte comando:

  $ javadoc universidade/Estudante.java

-----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------














