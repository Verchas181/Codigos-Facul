 // Lorenzian Peak function

#ifndef LP_H
#define LP_H
#include "TF1.h"
Double_t lorentzianPeak(Double_t *x, Double_t *par) {
   return (0.5*par[0]*par[1]/TMath::Pi())/TMath::Max( 1.e-10, (x[0]-par[2])*(x[0]-par[2]) + .25*par[1]*par[1] );
}

TF1 *LP = new TF1("LP",lorentzianPeak,0,200);
#endif