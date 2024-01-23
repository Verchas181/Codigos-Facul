#include <iostream> //input/oupat class
#include <vector> // Vectors are sequence containers representing arrays that can change in size.
#include <fstream> // Input/output stream class to operate on files.
#include "TMath.h"
#include <math.h>
using namespace std;

int termistor1()
{
  vector <double> lnr, t, elnr, et;
  double m, n ,o ,p;
  ifstream leitura; //cria um input
  leitura.open("termistor1.txt");
  if(leitura.is_open())
  {
    while(!leitura.eof())//True non zero
    {
      leitura >> m >> n >> o >> p; //por que adicionar esses elementos aos vetores?
      lnr.push_back(m);
      t.push_back(n);
      elnr.push_back(o);
      et.push_back(p);
    }
  }
/*push_back() é uma função da biblioteca <vector>, é usada para inserir 
um elemento ao final do vetor, aceita eleentos do mesmo tipo
e adiciona o novo elemento ao final do vetor*/
  double *plnresistencia= &lnr[0];
  double *ptemperatura = &t[0];
  double *pelnresistencia = &elnr[0];
  double *petemperatura = &et[0];

  int size = (t.size()-1);

  TCanvas tela("Tela");
  tela.SetGrid();

  TGraphErrors *points = new TGraphErrors(size, plnresistencia, ptemperatura, pelnresistencia, petemperatura);
  points->SetTitle("Grafico 1/T(ln(R/R0); ln(R/R0); 1/T [1/k]");

  points->SetMarkerStyle(3);
  points->SetMarkerSize(1.4);
  points->Draw("ap");
 	
  TF1 g("g", "([0]+[1]*x)");
  g.SetParameters(0.003,0.0003);  
  points->Fit(&g);

  TPaveText *formula = new TPaveText(0.4, 0.85, 0.55, 0.80, "brNDC");//TBox 
  formula->SetTextSize(.03);
  formula->SetTextColor(kBlack);
  formula->SetFillColor(0);
  char legenda[200];
  //criamos um array para alocar os paramêtros, já que é impossível pelo método AddText
  //sprintf retorna uma string, diferente do printf que faz a função de output
  sprintf(legenda, "Y = (%.3e #pm %.0e) + (%.2e #pm %.0e)*x", g.GetParameter(0), g.GetParError(0),g.GetParameter(1), g.GetParError(1));
  formula->AddText(legenda);
  formula->Draw("SAME");

  tela.Print("linearfitterm.pdf");
  tela.SaveAs("fiterm.C");
  return 0;
}
