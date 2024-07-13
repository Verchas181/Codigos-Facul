/*

_   _ _   _______ _     
| | | | | | |  _  \ |    
| | | | |_| | | | | |    
| | | |  _  | | | | |    
\ \_/ / | | | |/ /| |____
 \___/\_| |_/___/ \_____/
                         
                        
*/
---------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
// Uma linguagem para descrição de hardware
// O código VHDL é dividido em 3 partes, bibliotecas e pacotes, Entidade, Arquitetura.
// A entidade deve ter o MESMO nome do arquivo.

// exemplo de código de porta "AND"

---Bibliotecas e Pacotes----
---Entidade---
  entity and_gate is
      port(
        a,b : in bit; 
        c : out bit
      );
    end and_gate;
---Arquitetura---
  architecture e of and_gate is
    begin
      c <= a and b;
    end e;

---------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------

  // Somador de 4 bits

---Bibliotecas e Pacotes----
---Entidade---
  entity bit_sum is
    port(
      x,y : in integer range 0 to 15;
      alfa : out range 0 to 30
    );
    end bit_sum;
    
---Arquitetura---
  architecture sum of bit_sum is
    alfa <= x + y;
    end sum;

  ---------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------

    // Decodificador de 7 segmentos:

    /*
                  ___  
     1001 =>     |___|     
                 |___|        
    */


---Bibliotecas e Pacotes----
    library IEEE;
use IEEE.STD_LOGIC_1164.ALL; ---Define os tipos de dados fundamentais utilizados em VHDL, como STD_LOGIC e STD_LOGIC_VECTOR. (Respectivamente um bit ou uma coleção/vetor de bits) ---
use IEEE.STD_LOGIC_UNSIGNED.ALL; --- Esta biblioteca fornece operações aritméticas e de comparação para vetores do tipo STD_LOGIC_VECTOR ---


---Entidade---
entity vetores is
    port (
        bin_in : in STD_LOGIC_VECTOR(3 downto 0); --- Um vetor de bits de 4 posições "0000". ---
        seg_out : out STD_LOGIC_VECTOR(6 downto 0) --- Um vetor de bits de 6 posições "000000". ---
    );
end vetores;

---Arquitetura---
  architecture decoder of vetores is
begin
    process(bin_in)
    begin
        case bin_in is
            when "0000" => seg_out <= "0000001"; -- 0
            when "0001" => seg_out <= "1001111"; -- 1
            when "0010" => seg_out <= "0010010"; -- 2
            when "0011" => seg_out <= "0000110"; -- 3
            when "0100" => seg_out <= "1001100"; -- 4
            when "0101" => seg_out <= "0100100"; -- 5
            when "0110" => seg_out <= "0100000"; -- 6
            when "0111" => seg_out <= "0001111"; -- 7
            when "1000" => seg_out <= "0000000"; -- 8
            when "1001" => seg_out <= "0000100"; -- 9
            when others => seg_out <= "1111111"; -- Off
        end case;
    end process;
end decoder;

-----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
  // A função process() permite que você defina um bloco de código que é executado sempre que um ou mais sinais de entrada especificados mudam.

  // Lógica básica da função process
  process(sinal1, sinal2, ...)
    begin
    --- Lógica que será executada quando os sinais mudarem ---
end process;

  // A lista de sinais entre os parênteses indica quais sinais devem ser monitorados.
  // Quando um sinal muda, o bloco de código dentro do process é executado novamente













    
    


