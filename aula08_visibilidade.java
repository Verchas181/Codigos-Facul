/*

 _   _ _     _ _     _ _ _     _           _      
| | | (_)   (_) |   (_) (_)   | |         | |     
| | | |_ ___ _| |__  _| |_  __| | __ _  __| | ___ 
| | | | / __| | '_ \| | | |/ _` |/ _` |/ _` |/ _ \
\ \_/ / \__ \ | |_) | | | | (_| | (_| | (_| |  __/
 \___/|_|___/_|_.__/|_|_|_|\__,_|\__,_|\__,_|\___|                                                                      
                                                                                              
*/

-------------------------------------------------------------------------------------------------------------------------------------------------------------------
// Ocultar informação significa que o estado interno de um componente de software não deve ser acessível diretamente por outros componentes de software. 
// Em vez disso, o acesso a esse estado deve ser feito por meio de uma interface pública, que visa garantir a consistência do estado do componente.
// A interface deve ser minimalista, dando acesso apenas o necessário para o usuário.

-------------------------------------------------------------------------------------------------------------------------------------------------------------------

  // Encapsulamento


// Modularização: O encapsulamento permite que os dados e métodos de uma classe sejam agrupados em uma única unidade de software, facilitando a compreensão e a manutenção do código.
// Abstração. O encapsulamento permite que os detalhes de implementação de uma classe sejam ocultados, permitindo que os usuários da classe se concentrem apenas na interface pública da classe.
// Restrição de acesso. O encapsulamento restringe o acesso direto ao estado interno de um objeto, garantindo que a consistência dos dados seja mantida.

-------------------------------------------------------------------------------------------------------------------------------------------------------------------
  
  // Separação de preocupações

  /*

No contexto da orientação a objetos, a separação de preocupações é concretizada por meio da definição de classes que encapsulam um conjunto de dados
e métodos relacionados a uma única preocupação. Por exemplo, no domínio de
instituições financeiras, podemos ter sistemas que lidam com diferentes aspectos
do negócio como, por exemplo, contas correntes, poupança, investimentos, seguros, etc. Naturalmente, seria contrapoducente criar um único módulo que lidasse
com todos esses aspectos, os quais possuem requisitos bastante díspares.

*/
  
// Alta coesão. Um componente coeso é aquele que agrupa funcionalidades relacionadas a uma única preocupação.
  
// Baixo acoplamento. Um componente com baixo acoplamento é aquele que tem poucas dependências sobre o funcionamento interno de outros componentes. As dependências, quando houver, devem ser explícitas e providas por meio de interfaces bem definidas

//Facilidade de manutenção. Quando mudanças são necessárias, é mais fácil isolar e modificar as partes do código que são afetadas, sem afetar o código dos outros componentes do sistema.

// Facilidade de reutilização. Componentes bem separados tendem a ser mais reutilizáveis, pois podem ser usados em diferentes contextos sem a necessidade de alterações.

// Evolução e escalabilidade. A separação de preocupações facilita a adição de novas funcionalidades ao sistema, pois novos componentes podem ser adicionados sem afetar o funcionamento dos componentes existentes.


-------------------------------------------------------------------------------------------------------------------------------------------------------------------

  // Para esta criação de interface temos os seguinte operadores:

   - default // A classe, o atributo ou o método é acessível apenas pelas classes do mesmo pacote. Esse é o modificador aplicado implicitamente quando nenhum modificador é especificado.

   - public // A classe, o atributo ou o método é acessível por qualquer classe, de qualquer pacote.

 - protected // A classe, o atributo ou o método é acessível apenas pela classe em que foi definido e por suas subclasses. Esse modificador é relevante apenas quando se fala de herança. 

   - private // A classe, o atributo ou o método é acessível exclusivamente pela classe em que foi definido.

 ********* Java permite a definição de classes internas, ou inner classes, que são classes definidas dentro de outras classes. 
 // Nesse caso, é possível aplicar o modificador private à classe interna, o que restringe o acesso a ela apenas pela classe externa

---------------------------------------------------------------------------------------------------------------------------------------------------------------------

  // Já em quesito de métodos devemos ter sempre os getters e setters, que serão funções capazes de obter e modificar os valores de cada propriedade do objeto:

  public Estudante(String nome, int anoNascimento, double[] notas)
{
 this.nome = nome;
 this.anoNascimento = anoNascimento;
 this.notas = notas;
 }

public float[] getNotas() {
 return notas;
}

 public void setNotas(float[] notas) {
 this.notas = notas;
 }



  
















  

 
