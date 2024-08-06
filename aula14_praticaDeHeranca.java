/*
______          _   _           
| ___ \        | | (_)          
| |_/ / __ __ _| |_ _  ___ __ _ 
|  __/ '__/ _` | __| |/ __/ _` |
| |  | | | (_| | |_| | (_| (_| |
\_|  |_|  \__,_|\__|_|\___\__,_|
                                

*/
---------------------------------------------------------------------------------------------------------------------------------------------------------------------
/*
• Uma empresa emprega diferentes tipos de profissionais, entre eles estão os vendedores e
os assistentes administrativos.
• De cada funcionário, a empresa precisa manter um cadastro com o nome completo,
endereço, CPF, telefone e email.
• Os funcionários contam com vale-transporte, seguro-saúde, e previdência, todos descontados em folha.
• Os funcionários contam com vale-alimentação, pago pela empresa.
• Os vendedores podem ter rendimentos adicionais por comissão. Cada vendedor trabalha
com um tipo específico de produto, ao qual associa-se uma taxa de comissão sobre o valor
bruto das vendas.
• Os assistentes administrativos podem fazer horas-extras, inclusive frações de horas
• O valor de cada hora-extra corresponde 1/220 do rendimento líquido, acrescido de 50%.
• O salário bruto de cada funcionário é a soma do salário-base com os adicionais.
• O salário líquido é o salário bruto menos os descontos.
• Todo mês a empresa precisa emitir dois relatórios:
– Relatório de folha de pagamento, contendo, para cada funcionário:
* Dados pessoais (CPF e nome completo)
* Salário base
* Valor total de descontos
* Valor total de adicionais
* Rendimento bruto
* Rendimento líquido
Exemplo de relatório de folha de pagamento (com 4 funcionários):
1
Folha de Pagamento
CPF Nome Cargo Base Descontos Adicionais Bruto Líquido
797.253.381-30 Klara Mills Vendedor 4976,91 1757,64 1654,83 6631,74 4874,10
483.729.404-62 Darryl Stiedemann Ass. Adm. 6847,55 1710,66 738,20 7585,75 5875,09
082.245.748-87 Fawn McGlynn Outro 3266,91 1867,86 655,25 3922,16 2054,30
321.681.653-55 Claud Gleichner Ass. Adm. 4851,73 1860,31 786,75 5638,48 3778,17
• Um contra-cheque para cada funcionário, contendo:
– Dados pessoais: nome completo, endereço, CPF, telefone, email
– Salário-base
– Descontos
* Vale-transporte
* Seguro-saúde
* Previdência
– Adicionais
* Vale-alimentação
* Comissão (somente para vendedores)
* Horas-extras (somente para assistentes administrativos)
– Salário bruto
– Salário líquido
Exemplo de contracheques:
Contracheque 1
Dados Pessoais:
Nome: Kellee Huels III
CPF: 398.262.931-26
Telefone: (13)97786-1976
Email: brenton.mcdermott@hotmail.com
Cargo: Assistente Administrativo
Salario Base: 5510,23
Descontos: 1902,74
Plano de Saude: 655,04
Vale Transporte: 664,33
Previdencia: 583,37
Adicionais: 601,41
Vale Alimentacao: 593,52
Rendimento hora-extra: 7,89
Horas Extras: 0,21
Valor hora-extra: 37,57
Salário Bruto: 6111,64
Salário Líquido: 4208,90

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

   public void setTelefone(String telefone) {
        if (telefone == null || telefone.isEmpty() 
            || !telefone.matches("\\(\\d\\d\\)\\d{4,5}-\\d{4}")) {
            throw new IllegalArgumentException("Telefone inválido: " + telefone);
        }
        this.telefone = telefone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        if (email == null || email.isEmpty() || !email.contains("@")) {
            throw new IllegalArgumentException("Email inválido");
        }
        this.email = email;
    }

        public double getPlanoSaude() {
        return planoSaude;
    }
    
      public void setPlanoSaude(double planoSaude) {
        if (planoSaude < 0) {
            throw new IllegalArgumentException("Plano de saúde não pode ser negativo");
        }
        this.planoSaude = planoSaude;
    }

    public double getValeTransporte() {
        return valeTransporte;
    }

    public void setValeTransporte(double valeTransporte) {
        if (valeTransporte < 0) {
            throw new IllegalArgumentException("Vale transporte não pode ser negativo");
        }
        this.valeTransporte = valeTransporte;
    }

    public double getValeAlimentacao() {
        return valeAlimentacao;
    }

    public void setValeAlimentacao(double valeAlimentacao) {
        if (valeAlimentacao < 0) {
            throw new IllegalArgumentException("Vale alimentação não pode ser negativo");
        }
        this.valeAlimentacao = valeAlimentacao;
    }

    public double getPrevidencia() {
        return previdencia;
    }

    public void setPrevidencia(double previdencia) {
        if (previdencia < 0) {
            throw new IllegalArgumentException("Previdência não pode ser negativo");
        }
        this.previdencia = previdencia;
    }

    public double getSalarioBase() {
        return salarioBase;
    }

    public void setSalarioBase(double salarioBase) {
        if (salarioBase < 0) {
            throw new IllegalArgumentException("Salário base não pode ser negativo");
        }
        this.salarioBase = salarioBase;
    }

    protected double getDescontos() {
        return getValeTransporte() + getPlanoSaude() + getPrevidencia();
    }

    protected double getAdicionais() {
        return getValeAlimentacao();
    }

    protected double getSalarioBruto() {
        return getSalarioBase() + getAdicionais();
    }

    protected double getSalarioLiquido() {
        return getSalarioBruto() - getDescontos();
    }
}


---------------------------------------------------------------------------------------------------------------------------------------------------------------------


  ---TA.java---

  public class TA extends Funcionario {

  private double horasExtras;

    public TA(
            String nomeCompleto,
            String cpf,
            String telefone,
            String email,
            double planoSaude,
            double valeTransporte,
            double valeAlimentacao,
            double previdencia,
            double salarioBase,
            double horasExtras) {
        super(nomeCompleto, cpf, telefone, email, planoSaude, valeTransporte, valeAlimentacao, previdencia,
                salarioBase);
        setHorasExtras(horasExtras);
    }
  
     public double getHorasExtras() {
        return horasExtras;
    }

    public double getValorHoraExtra() {
        return getSalarioBase() / 220 * 1.5;
    }

    public double getRendimentoHorasExtras() {
        return getValorHoraExtra() * getHorasExtras();
    }

    public void setHorasExtras(double horasExtras) {
        if (horasExtras < 0) {
            throw new IllegalArgumentException("Horas extras nao pode ser negativo");
        }
        this.horasExtras = horasExtras;
    }

    @Override
    public double getAdicionais() {
        return super.getAdicionais() + getSalarioBase() / 220 * getHorasExtras() * 1.5;
    }
}


---------------------------------------------------------------------------------------------------------------------------------------------------------------------

public class Vendedor extends Funcionario {
    private double vendasBrutas;
    private double taxaComissao;

    public Vendedor(
        String nomeCompleto, 
        String cpf, 
        String telefone, 
        String email,
        double planoSaude,
        double valeTransporte, 
        double valeAlimentacao, 
        double previdencia,
        double salarioBase,
        double vendasBrutas,
        double taxaComissao
        ) {
        super(
            nomeCompleto, 
            cpf, 
            telefone, 
            email, 
            planoSaude, 
            valeTransporte, 
            valeAlimentacao, 
            previdencia, 
            salarioBase
        );
        setVendasBrutas(vendasBrutas);
        setTaxaComissao(taxaComissao);
    }

    public final double getVendasBrutas() {
        return vendasBrutas;
    }

    public final void setVendasBrutas(double vendasBrutas) {
        if (vendasBrutas < 0.0) {
            throw new IllegalArgumentException("Gross sales cannot be negative");
        }
        this.vendasBrutas = vendasBrutas;
    }

    public final double getTaxaComissao() {
        return taxaComissao;
    }

    public final void setTaxaComissao(double taxaComissao) {
        if (taxaComissao < 0.0 || taxaComissao > 1.0) {
            throw new IllegalArgumentException("Comission rate must a percentage --- [0,1]");
        }
        this.taxaComissao = taxaComissao;
    }

    public double getComissao() {
        return vendasBrutas * taxaComissao;
    }

    @Override
    public double getAdicionais() {
        return super.getAdicionais() + getComissao();
    }
}


---------------------------------------------------------------------------------------------------------------------------------------------------------------------

    ---RelatorioFolhaPagamento.java---

  public class RelatorioFolhaPagamento {
    public static void main(String[] args) {
        RepositorioFuncionarios repositorio = new RepositorioFuncionarios(20);

        System.out.println("Folha de Pagamento");
        System.out.printf("%-20s %-25s %-10s %10s %10s %10s %10s %10s\n", "CPF", "Nome", "Cargo", "Base", "Descontos", "Adicionais", "Bruto", "Líquido");
        for (var funcionario : repositorio.getFuncionarios()) {
            String cargo = "";

            if (funcionario instanceof AssistenteAdministrativo) {
                cargo = "Ass. Adm.";
            } else if (funcionario instanceof Vendedor) {
                cargo = "Vendedor";
            } else {
                cargo = "Outro";
            }
            System.out.printf(
                "%-20s %-25s %-10s %10.2f %10.2f %10.2f %10.2f %10.2f\n",
                funcionario.getCpf(),
                funcionario.getNomeCompleto(),
                cargo,
                funcionario.getSalarioBase(),
                funcionario.getDescontos(),
                funcionario.getAdicionais(),
                funcionario.getSalarioBruto(),
                funcionario.getSalarioLiquido()
            );
        }
    }
}

---------------------------------------------------------------------------------------------------------------------------------------------------------------------

    ---RelatorioHolerite.java---


  public class RelatorioHolerite {

    private static String getCargo(Funcionario funcionario) {
        if (funcionario instanceof Vendedor) {
            return "Vendedor";
        } else if (funcionario instanceof AssistenteAdministrativo) {
            return "Assistente Administrativo";
        } else {
            return "Funcionario";
        }
    }
    public static void main(String[] args) {
        RepositorioFuncionarios repositorio = new RepositorioFuncionarios(20);
        int contador = 0;
        for (var funcionario : repositorio.getFuncionarios()) {
            System.out.println("Contracheque " + ++contador);

            System.out.printf("Dados Pessoais: \n\tNome: %s\n\tCPF: %s\n\tTelefone: %s\n\tEmail: %s\n",
                    funcionario.getNomeCompleto(), funcionario.getCpf(), funcionario.getTelefone(),
                    funcionario.getEmail());
            System.out.println("Cargo: " + getCargo(funcionario));
            System.out.printf("Salario Base: %.2f\n", funcionario.getSalarioBase());
            System.out.printf("Descontos: %.2f\n", funcionario.getDescontos());
            System.out.printf("\tPlano de Saude: %.2f\n", funcionario.getPlanoSaude());
            System.out.printf("\tVale Transporte: %.2f\n", funcionario.getValeTransporte());
            System.out.printf("\tPrevidencia: %.2f\n", funcionario.getPrevidencia());
            System.out.printf("Adicionais: %.2f\n", funcionario.getAdicionais());
            System.out.printf("\tVale Alimentacao: %.2f\n", funcionario.getValeAlimentacao());

            if (funcionario instanceof AssistenteAdministrativo) {
                AssistenteAdministrativo assistente = (AssistenteAdministrativo) funcionario;

                System.out.printf("\tRendimento hora-extra: %.2f\n", assistente.getRendimentoHorasExtras());
                System.out.printf("\t\tHoras Extras: %.2f\n", assistente.getHorasExtras());
                System.out.printf("\t\tValor hora-extra: %.2f\n", assistente.getValorHoraExtra());                
            } else if (funcionario instanceof Vendedor) {
                Vendedor vendedor = (Vendedor) funcionario;
                
                System.out.printf("\tComissão: %.2f\n", vendedor.getComissao());
                System.out.printf("\t\tVendas brutas: %.2f\n", vendedor.getVendasBrutas());
                System.out.printf("\t\tTaxa comissão: %.2f\n", vendedor.getTaxaComissao());
                
            }

            System.out.printf("Salário Bruto: %.2f\n", funcionario.getSalarioBruto());
            System.out.printf("Salário Líquido: %.2f\n", funcionario.getSalarioLiquido());
            System.out.println();

        }
    }
}

