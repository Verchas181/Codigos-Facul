/*
______          _   _           
| ___ \        | | (_)          
| |_/ / __ __ _| |_ _  ___ __ _ 
|  __/ '__/ _` | __| |/ __/ _` |
| |  | | | (_| | |_| | (_| (_| |
\_|  |_|  \__,_|\__|_|\___\__,_|

*/
----------------------------------------------
---Desconto.java---
public abstract class Desconto {
    protected Pedido pedido;

    public Desconto(Pedido pedido) {
        this.pedido = pedido;
    }

    public abstract double getDesconto();
}
----------------------------------------------
---DescontoCompreAlgunsGanheUm.java---
public final class DescontoCompreAlgunsGanheUm extends Desconto {
    private int quantidadeMinima;

    public DescontoCompreAlgunsGanheUm(Pedido pedido, int quantidadeMinima) {
        super(pedido);
        this.quantidadeMinima = quantidadeMinima;
    }

    @Override
    public double getDesconto() {
        return pedido.getQuantidade() / quantidadeMinima * pedido.getPrecoUnitario();
    }
}
----------------------------------------------
---DescontoFixo.java---
public class DescontoFixo extends Desconto {

    private double taxaDesconto;

    public DescontoFixo(Pedido pedido, double taxaDesconto) {
        super(pedido);
        this.taxaDesconto = taxaDesconto;
    }

    @Override
    public double getDesconto() {
        return pedido.getPrecoTotal() * taxaDesconto;
    }
}
----------------------------------------------
---DescontoAtacado.java---
public final class DescontoAtacado extends Desconto {
    private int minimo;
    private double taxaDesconto;

    public DescontoAtacado(Pedido pedido, int minimo, double taxaDesconto) {
        super(pedido);
        this.minimo = minimo;
        this.taxaDesconto = taxaDesconto;
    }

    @Override
    public double getDesconto() {
        return pedido.getQuantidade() >= minimo ? pedido.getPrecoTotal() * taxaDesconto : 0;
    }
}

----------------------------------------------

---Pedido.java---
  
import java.util.ArrayList;

public abstract class Pedido {
    protected int quantidade;
    protected double precoUnitario;
    protected Cliente cliente;
    protected ArrayList<Desconto> descontos;
    protected MeioPagamento pagamento;

    public enum MeioPagamento {
        DINHEIRO, CARTAO, PIX
    }

    public Pedido(int quantidade, double precoUnitario, Cliente cliente, MeioPagamento pagamento) {
        this.quantidade = quantidade;
        this.precoUnitario = precoUnitario;
        this.cliente = cliente;
        this.descontos = new ArrayList<>();
        if (cliente.isFidelidade()) {
            descontos.add(new DescontoFixo(this, 0.05));
        }
        this.pagamento = pagamento;
        if (pagamento == MeioPagamento.PIX || pagamento == MeioPagamento.CARTAO) {
            descontos.add(new DescontoFixo(this, 0.04));
        }
    }

    public final double getPrecoTotal() {
        return quantidade * precoUnitario;
    }

    public double getDescontoTotal() {
        var descontoTotal = 0.0;

        for (var desconto : descontos) {
            descontoTotal += desconto.getDesconto();
        }

        return descontoTotal;
    }

    public abstract double getAcrescimos();

    public final double getPrecoFinal() {
        return getPrecoTotal() - getDescontoTotal() + getAcrescimos();
    }

    public void addDesconto(Desconto desconto) {
        descontos.add(desconto);
    }

    public void limpaDescontos() {
        descontos.clear();
        if (cliente.isFidelidade()) {
            descontos.add(new DescontoFixo(this, 0.05));
        }
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    public double getPrecoUnitario() {
        return precoUnitario;
    }

    public void setPrecoUnitario(double precoUnitario) {
        this.precoUnitario = precoUnitario;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public void setDescontos(ArrayList<Desconto> descontos) {
        this.descontos = descontos;
    }

    @Override
    public String toString() {
        return String.format("Preço total: %.2f\n", getPrecoTotal())
                + String.format("Desconto total: %.2f\n", getDescontoTotal())
                + String.format("Preço final: %.2f\n", getPrecoFinal());
    }
    
}
----------------------------------------------
---Encomenda.java---
public class Encomenda extends Pedido {
    private double frete;
    private String endereco;

    public Encomenda(int quantidade, double precoUnitario, Cliente cliente, MeioPagamento meioPagamento, double frete, String endereco) {
        super(quantidade, precoUnitario, cliente, meioPagamento);
        this.frete = frete;
        this.endereco = endereco;
    }

    @Override
    public double getAcrescimos() {
        return frete;
    }

    public double getFrete() {
        return frete;
    }

    public String getEndereco() {
        return endereco;
    }

    
}

----------------------------------------------
---EntregaPronta.java---
public class EntregaPronta extends Pedido {

    public EntregaPronta(int quantidade, double precoUnitario, Cliente cliente, Pedido.MeioPagamento pagamento) {
        super(quantidade, precoUnitario, cliente, pagamento);
        addDesconto(new DescontoFixo(this, 0.1));
    }

    @Override
    public double getAcrescimos() {
        return 0;
    }    
}




  
