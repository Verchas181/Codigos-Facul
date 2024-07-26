/*

 _____    _              _                            _____                         _           
|  ___|  | |            | |                          |  ___|                       | |          
| |__ ___| |_ _ __ _   _| |_ _   _ _ __ __ _    ___  | |____  _____ _ __ ___  _ __ | | ___  ___ 
|  __/ __| __| '__| | | | __| | | | '__/ _` |  / _ \ |  __\ \/ / _ \ '_ ` _ \| '_ \| |/ _ \/ __|
| |__\__ \ |_| |  | |_| | |_| |_| | | | (_| | |  __/ | |___>  <  __/ | | | | | |_) | | (_) \__ \
\____/___/\__|_|   \__,_|\__|\__,_|_|  \__,_|  \___| \____/_/\_\___|_| |_| |_| .__/|_|\___/|___/
                                                                             | |                
                                                                             |_|               


  */
------------------------------------------------------------------------------------------------------------
// A entidade de um projeto é composta sempre pela entrada e saída do projeto.
// Já a parte de arquitetura será a montagem do circuito em sí.
// Arquiteturas podem atuar de forma hierárquica, já que uma arquitetura pode chamar outra arquitetura.

 // Uma entity pode ter mais de uma architecture associada a ela, mas durante a simulação apenas uma delas estará ativa
 // A decisão será feita pelo simulador baseada numa declaração no final do arquivo, chamada configuration.

// Podemos usar diferentes softwares para simulação de projetos, temos o ModelSim, GTKWave, Quartus
------------------------------------------------------------------------------------------------------------
  ---Entity---
  
// A entity é formada principalmente por 2 estruturas, a generic() e a port(). A generic() atua analogamente à uma constante (#define do C), já a port() atua como entrada e saída. 
// Tipos de port: Podem ser in, out, buffer(saída que pode ser lida) e inout (entrada/saida).

------------------------------------------------------------------------------------------------------------
  ---Architecture---

//Declarações feitas:
  ---Constantes
  ---Componentes
  ---Subprogramas
  ---Novos tipos
  ---Outros

------------------------------------------------------------------------------------------------------------

  ---SomadorCompleto.vhd---

  // podemos utilizar a biblioteca STD do IEE


  ---Entity---
  entity CompleteSum is
    port(
      a,b : in bit ;
      x   : in bit ;
      s   : out bit;
      s2  : out bit;
    );
  end CompleteSum;

  ---Architecture---
  architecture Circuito of CompleteSum is
    begin
      s <= a xor b xor x;
      s2 <= (a and b) or (a and x) or (b and x);

      end Circuito;
    
------------------------------------------------------------------------------------------------------------

---Comparador de 1 Bit---
   
   library ieee;
use ieee.std_logic_1164.all;
entity eq1 is
   port(
      i0, i1: in std_logic;
      eq: out std_logic
   );
end eq1;

architecture sop_arch of eq1 is
   signal p0, p1: std_logic;
begin
   
   eq <= p0 or p1;
   
   p0 <= (not i0) and (not i1);
   p1 <= i0 and i1;
end sop_arch;

------------------------------------------------------------------------------------------------------------

 ---Testbench do Comparador de 1Bit---

 library ieee;
use ieee.std_logic_1164.all;
entity eq1_testbench is
end eq1_testbench;

architecture tb_arch of eq1_testbench is
   signal test_in0, test_in1: std_logic;
   signal test_out: std_logic;
begin
   
   uut: entity work.eq1(sop_arch)
      port map(i0=>test_in0, i1=>test_in1, eq=>test_out);
   
   process
   begin
      
      test_in0 <= '0';
      test_in1 <= '0';
      wait for 200 ns;

      test_in0 <= '0';
      test_in1 <= '1';
      wait for 200 ns;
      
      test_in0 <= '1';
      test_in1 <= '0';
      wait for 200 ns;
      
      test_in0 <= '1';
      test_in1 <= '1';
      wait for 200 ns;
      wait;
end process;
end tb_arch;

------------------------------------------------------------------------------------------------------------
---Exemplo de um MUX (n-1 = 3)---

library IEEE;
use IEEE.STD_LOGIC_1164.ALL;
use IEEE.NUMERIC_STD.ALL;
use IEEE.STD_LOGIC_UNSIGNED.ALL;

entity mux8x1 is
  port(

    a : in STD_LOGIC_VECTOR (7 downto 0);
    d : in STD_LOGIC ;
    Y : out STD_LOGIC
   
   );
 end mux8x1;

 architecture circuito of mux8x1 is
  process(a,d,Y)
   begin
    case a is 
      when "000" =>
        Y <= d;
      when "001" =>
        Y <= 0;
      when "010" =>
        Y <= d;
      when "011" =>
        Y <= 0;
     when "100" =>
        Y <= 1;
     when "101" =>
        Y <= 0;
     when "110" =>
        Y <= not d;
     when "111" =>
        Y <= D;
   end case;
    end process;
     end circuito;
   

------------------------------------------------------------------------------------------------------------
---Exemplo de uma ULA ---

    library IEEE;
use IEEE.STD_LOGIC_1164.ALL;
use IEEE.NUMERIC_STD.ALL;

entity ULA is
    Port (
        A       : in  STD_LOGIC_VECTOR(7 downto 0); -- Operando A
        B       : in  STD_LOGIC_VECTOR(7 downto 0); -- Operando B
        Opcode  : in  STD_LOGIC_VECTOR(3 downto 0); -- Código da operação
        Result  : out STD_LOGIC_VECTOR(7 downto 0); -- Resultado da operação
        Zero    : out STD_LOGIC                     -- Sinal de zero
    );
end ULA;

architecture Behavioral of ULA is
begin
    process (A, B, Opcode)
    begin
        case Opcode is
            when "0000" =>   -- Operação de Adição
                Result <= std_logic_vector(unsigned(A) + unsigned(B));
            when "0001" =>   -- Operação de Subtração
                Result <= std_logic_vector(unsigned(A) - unsigned(B));
            when "0010" =>   -- Operação E Lógico
                Result <= A and B;
            when "0011" =>   -- Operação OU Lógico
                Result <= A or B;
            when "0100" =>   -- Operação XOR
                Result <= A xor B;
            when others =>
                Result <= (others => '0'); 
        end case;
        if Result = "00000000" then
            Zero <= '1';
        else
            Zero <= '0';
        end if;
    end process;
end Behavioral;















   
    
  



