/*
______          _   _           
| ___ \        | | (_)          
| |_/ / __ __ _| |_ _  ___ __ _ 
|  __/ '__/ _` | __| |/ __/ _` |
| |  | | | (_| | |_| | (_| (_| |
\_|  |_|  \__,_|\__|_|\___\__,_|
                                

*/


---------------------------------------------------------------------------------------------------------------------------------------------------------------------

  ---Funcionario.java---
  
package FolhaPagamento;

public class funcionario {

    protected String nome;
    protected String cpf;
    protected String telefone;
    protected String email;
    protected double planoSaude;
    protected double valeTransporte;
    protected double previdencia;
    protected double salarioBase;

  public funcionario(String nome, String cpf, String telefone, String email,
                       double planoSaude, double valeTransporte, double previdencia, double salarioBase) {
        this.nome = nome;
        this.cpf = cpf;
        this.telefone = telefone;
        this.email = email;
        this.planoSaude = planoSaude;
        this.valeTransporte = valeTransporte;
        this.previdencia = previdencia;
        this.salarioBase = salarioBase;
    }


    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
      if (cpf != null && cpf.matches("\\d{3}\\.\\d{3}-\\d{2}"){
          throw new IllegalArgumentException("CPF invalido");
      }
        this.cpf = cpf;
    }

    public String getTelefone() {
        return telefone;
    }

    // Setter para telefone
    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    // Getter para email
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public double getPlanoSaude() {
        return planoSaude;
    }

    public void setPlanoSaude(double planoSaude) {
        this.planoSaude = planoSaude;
    }

    public double getValeTransporte() {
        return valeTransporte;
    }

    public void setValeTransporte(double valeTransporte) {
        this.valeTransporte = valeTransporte;
    }

    public double getPrevidencia() {
        return previdencia;
    }

    public void setPrevidencia(double previdencia) {
        this.previdencia = previdencia;
    }

    public double getSalarioBase() {
        return salarioBase;
    }

    public void setSalarioBase(double salarioBase) {
        this.salarioBase = salarioBase;
    }
}













}




















