
function sumarNumeros(num1, num2){
    let total = num1 + num2;
    return total;
}

let resultado1 = sumarNumeros(10, 20);
console.log(resultado1);
let resultado2 = sumarNumeros(40, 70);
console.log(resultado2);
let resultadoFinal = sumarNumeros(resultado1, resultado2);
console.log(resultadoFinal);

let numerosPares = [2, 4, 6, 8, 10];
let numerosNones = [7, 9, 11, 13, 15];
let sumasTotales = [];

for(let i = 0; i < numerosNones.length; i ++){
    let total = sumarNumeros(numerosPares[i], numerosNones[i]);
    sumasTotales.push(total);
}

console.log(sumasTotales);
