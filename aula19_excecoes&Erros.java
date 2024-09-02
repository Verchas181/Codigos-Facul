/*

 _____                                 
|  ___|                                
| |____  _____ ___  ___ ___   ___  ___ 
|  __\ \/ / __/ _ \/ __/ _ \ / _ \/ __|
| |___>  < (_|  __/ (_| (_) |  __/\__ \
\____/_/\_\___\___|\___\___/ \___||___/


*/
------------------------------------------------------------
// Erros
  // Tarefas importantes:
     // Detectar erros
     // Reportar erros
     // Tratar erros
     // Tipos de erro de execução
  // Erros aritméticos
     // Erros de acesso a memória: segmentation fault (C), ponteiro nulo e indíce inválido(Java)
     // Erros de entrada e saída
     // Erros de conversão de tipos (casting)
     // Erros de consistência, de validação, de lógica, etc.

------------------------------------------------------------
  // Técnicas básicas para tratamentos de erros

  

  // Interrupção abrupta da execução (abort)
  System.exit(1);


  // Valores especiais de retorno
  public static int divide(int a, int b) {
  if (b == 0) return -1;
  return a / b;
  }

  // Flag de status
  public static class ArithmeticStatus {
  public enum Status { OK, DIVISION_BY_ZERO, OVERFLOW, UNDERFLOW };
  public Status status = Status.OK;
  public void failure() { status = Status.DIVISION_BY_ZERO; }
  public void success() { status = Status.OK; }
  }

  public static int divide(double a, double b, ArithmeticStatus status) {
    if (Math.abs(b) < Math.ulp(1.0)) {
        status.failure();
        return -1;
    }
    status.success();
    return (int) (a / b);
}

------------------------------------------------------------

  // Exceções
    /* 
    Processo de tratamento de exceções:
          1 Disparo da exceção
          2 Captura da exceção
          3 Tratamento da exceção
    */
    /*
    Tratamento de erros via desvio de fluxo de controle
          1 Exceção disparada numa linha, módulo, etc.
          2 Capturada e tratada em outra linha, módulo, etc
    */

// Disparo de exceções: throw
 throw new ArithmeticException("Divisão por zero");



// Captura de exceções: try
// Tratamento de exceções: catch
// O try e catch devem sempre ser usados em conjunto. Bloco try demarca uma seção crítica

try {
    int a = Integer.parseInt(args[0]);
    int b = Integer.parseInt(args[1]);

    if (b == 0) {
        throw new ArithmeticException("Divisão por zero");
    }
} catch (ArithmeticException e) {
    System.err.println("Erro de divisão por zero");
}




  // Disparo explícito: o próprio bloco try emite via throw

try {
    throw new ArithmeticException("Divisão por zero");
} catch (ArithmeticException e) {
    System.err.println("Erro de divisão por zero");
}

  // Disparo implícito: ambiente de execução ou chamada de módulo disparam a exceção

try {
    int a = Integer.parseInt(args[0]);
    int b = Integer.parseInt(args[1]);
} catch (ArrayIndexOutOfBoundsException e) {
    System.err.println("Faltam argumentos");
}



  // Podemos ter mais de um bloco catch para tratar diferentes tipos de exceções
  // Blocos mais genéricos devem aparecer por ultimo, se não os blocos expecificos nunca serão executados.
  // Por exemplo, AritmhmeticException deve aparecer antes de Exception

public class Main {
    public static void main(String[] args) {
        try {
            int a = Integer.parseInt(args[0]);
            int b = Integer.parseInt(args[1]);

            int result = a / b;

            System.out.println("Resultado: " + result);
        } catch (ArrayIndexOutOfBoundsException e) {
            System.err.println("Faltam argumentos. Por favor, forneça dois números.");
        } catch (NumberFormatException e) {
            System.err.println("Argumentos inválidos. Por favor, forneça números inteiros.");
        } catch (ArithmeticException e) {
            System.err.println("Erro: Divisão por zero.");
        }
    }
}

------------------------------------------------------------
  // Tipos de exceções

    // Unchecked (não‐verificadas): RuntimeError, Error
        // Para erros não‐recuperáveis
        // Podem ou não ser capturadas (opcional)

    // Checked (verificadas): todas as outras
        // Compilador obriga a captura e o tratamento pelo programador:


    // Exceções não‐verificadas são subtipos de RuntimeException (tratamento opcional)
------------------------------------------------------------

  // Delegação de exceções (rethrow)
    // Adequado quando não é possível tratar a exceção localmente

    public static void main(String[] args) {
    try {
        int a = Integer.parseInt(args[0]);
        int b = Integer.parseInt(args[1]);

        int c = a / b;
        System.out.printf("%d / %d = %d\n", a, b, c);
    } catch (ArithmeticException e) {
        System.out.println("Erro de divisão por zero");
        throw e; // Adicionado ponto e vírgula
    }
}


  // Encadeamento de exceções
    // Técnica mais sofisticada para delegar exceções:
      // Permite mudar o tipo de exceção sem perder a informação original
      // Preserva o traço da pilha de execução (stacktrace)

    try {
    BufferedReader reader = new BufferedReader(new FileReader("file.txt"));
    String line = reader.readLine();
} catch (IOException e) {
    throw new RuntimeException("Failed to read file", e);
}


------------------------------------------------------------

    // Exceções customizadas
      // Podemos criar exceções ao herdar de Exception ou RuntimeException


    public class MyException extends Exception {
    public MyException(String message) {
        super(message);
    }
}

    public class InvalidCoordinateException extends Exception {
    public InvalidCoordinateException(double coord) {
        super("Coordinate is invalid: " + coord);
    }
}

  public class InvalidRadiusException extends Exception {
      public InvalidRadiusException(double radius) {
          super("Radius is invalid: " + radius);
      }
  }


------------------------------------------------------------
    // Finally

      // Bloco finally é executado sempre, independentemente de exceções
      // Utilizado para liberar recursos, fechar conexões, etc.
      // Caso de uso típico: alocamos um recurso e precisamos liberar


    public static void main(String[] args) {
    Scanner scanner = null;
    try {
        scanner = new Scanner(new File(args[0]));
        // código
    } catch (FileNotFoundException e) {
        System.err.println("Arquivo não encontrado");
    } finally {
        if (scanner != null) {
            scanner.close();
        }
    }
}








