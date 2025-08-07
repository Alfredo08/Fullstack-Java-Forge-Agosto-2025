            //   0        1         2          3 
let nombres = ["Alex", "Martha", "Julieta", "Roger"];
console.log(nombres, nombres.length);
console.log(nombres[3]);

nombres[3] = "Maria";
console.log(nombres);

// Agrega elemento al final
nombres.push("Miguel");
console.log(nombres, nombres.length);

// Agrega elemento al principio
nombres.unshift("Aldo");
console.log(nombres, nombres.length);

// Eliminar elemento del final
nombres.pop();
nombres.pop();
console.log(nombres, nombres.length);

// Eliminar element0 del principio
nombres.shift();
nombres.shift();
console.log(nombres, nombres.length);