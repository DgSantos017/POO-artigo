public class Main {
    public static void main(String[] args) {

        ContaSantander contaDiogo = new ContaSantander(123, "Diogo Santos Ferreira", "Corrente", 500);
        ContaSantander contaSaphira = new ContaSantander(124, "Saphira", "Poupança", 500);
    
        contaDiogo.depositar(850.00);

        System.out.println("\nApós o primeiro depósito, Diogo ficou com: " + contaDiogo.exibirSaldo());
        System.out.println("E Saphira atualmente tem: " + contaSaphira.exibirSaldo() + "\n");

        contaDiogo.transferir(500, contaSaphira);

        System.out.println("Após a transferencia, Diogo ficou com: " + contaDiogo.exibirSaldo());
        System.out.println("E Saphira agora tem: " + contaSaphira.exibirSaldo()+ "\n");

        contaSaphira.sacar(300);

        System.out.println("Ao final, Diogo permaneceu com: " + contaDiogo.exibirSaldo());
        System.out.println("E Saphira depois do saque ficou com: " + contaSaphira.exibirSaldo());

    }
}

public class ContaBancaria {
    private int numeroConta;
    private String nomeTitular;
    private double saldo;
    private String tipoConta;

    // Construtor
    public ContaBancaria(int numeroConta, String nomeTitular, String tipoConta) {
        this.numeroConta = numeroConta;
        this.nomeTitular = nomeTitular;
        this.saldo = 0;
        this.tipoConta = tipoConta;
    }

    // Métodos 
    public double transferir(double valorTransferencia, ContaBancaria contaDestino) {

         if (valorTransferencia > 0 && this.saldo >= valorTransferencia) {
            this.saldo = this.saldo - valorTransferencia;                    
            contaDestino.depositar(valorTransferencia);     
            return valorTransferencia;
        } else {
            System.out.println("Transferência não permitida. Verifique o valor ou saldo insuficiente.");
            return 0.0;
        }
    }

    public double exibirSaldo() {
        return this.saldo;
    }

    public double sacar(double valorSaque) {
        if (valorSaque > 0 && this.saldo >= valorSaque) {
            this.saldo =  this.saldo - valorSaque;                    
            return valorSaque;
        } else {
            System.out.println("Saque não permitido. Verifique o valor ou saldo insuficiente.");
            return 0.0;
        }
    }

    public double depositar(double valorDeposito) {
         if (valorDeposito > 0) {
            this.saldo = this.saldo + valorDeposito;                      
            return valorDeposito;
        } else {
            System.out.println("Depósito não permitido. Verifique o valor inserido.");
            return 0.0;
        }
    }

    // Getters
    public int getNumeroConta() {
        return numeroConta;
    }

    public String getNomeTitular() {

        String[] palavras = nomeTitular.split(" ");
        StringBuilder iniciaisComEspaco = new StringBuilder();

        for (String palavra : palavras) {
            if (!palavra.isEmpty()) {
                iniciaisComEspaco.append(palavra.charAt(0)).append(" ");
            }
        }

        return iniciaisComEspaco.toString().trim();
    }

    public double getSaldo() {
        return saldo;
    }

    public String getTipoConta() {
        return tipoConta;
    }


    // Setters
    public void setNumeroConta(int numeroConta) {
        this.numeroConta = numeroConta;
    }

    public void setNomeTitular(String nomeTitular) {
        this.nomeTitular = nomeTitular;
    }

    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }

    public void setTipoConta(String tipoConta) {
        this.tipoConta = tipoConta;
    }
}


public class ContaSantander extends ContaBancaria {

    // Atributo adicional
    private double limiteCredito;

    // Construtor
    public ContaSantander(int numeroConta, String nomeTitular, String tipoConta, double limiteCredito) {
        super(numeroConta, nomeTitular, tipoConta);
        this.limiteCredito = limiteCredito;
        ajustarSaldoComLimiteCredito();  // Chama o método para ajustar o saldo com o limite de crédito
    }

    // metodo para ajusar o saldo somando com o limite
    private void ajustarSaldoComLimiteCredito() {
        setSaldo(getSaldo() + limiteCredito);
    }

    // getters e setters
    public double getLimiteCredito() {
        return limiteCredito;
    }
    public void setLimiteCredito(double limiteCredito) {
        this.limiteCredito = limiteCredito;
        ajustarSaldoComLimiteCredito();  // Chama o método para ajustar o saldo com o novo limite de crédito
    }
}


