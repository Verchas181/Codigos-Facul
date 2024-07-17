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
    

    
  



