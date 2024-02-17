// começando um formulário

const form = document.querySelector('#perguntas');

form.addEventListener('submit', function(e){
e.preventDefault();
const InputPeso = form.querySelector('#Peso')
const InputAltura = form.querySelector('#Altura')

const peso = Number(InputPeso.value)
const altura = Number(InputAltura.value)

const IMC = getIMC(peso , altura)

function getIMC(peso,altura){
    const valor = peso/(altura**2);
    return valor.toFixed(2)
}

if (!peso || !altura){
    set_resultado("Valores inválidos. Coloque em Kilogramas e Metros",false)
    return;
}
set_resultado(`Seu IMC é ${IMC}`,true);
return
});



function set_resultado(mensagem,validez){
    const res = document.querySelector("#resultado");
    if (validez) {
        res.classList.add('resultado')} else{
            res.classList.add('bad')
        } 
    res.innerHTML = `<p>${mensagem}<p/>`;
    
}

