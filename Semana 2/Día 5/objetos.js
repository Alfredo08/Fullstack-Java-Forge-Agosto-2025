
let libro = {
    titulo: "El principito",
    autores: ["Antoine de Saint", "Pablo Neruda"],
    genero: "Novela",
    capitulos: 20,
    fechaDePublicacion: 1943,
    reimpreso: true,
    imprimeInfo: function(){
        console.log(libro.titulo);
        console.log(libro.autores);
        console.log(libro.genero);
        console.log(libro.capitulos);
        console.log(libro.fechaDePublicacion);
    },
    idiomas: {
        nombre1: "español",
        nombre2: "ingles"
    }
};

console.log(libro.idiomas.nombre2);

/*
for(let i = 0; i < libro.autores.length; i ++){
    console.log(i+1, libro.autores[i]);
}

libro.imprimeInfo();


console.log(libro);

let prop = "autores";

console.log(libro[prop]);
console.log(libro.titulo, libro["titulo"]);
console.log(libro.capitulos, libro["capitulos"]);

libro.capitulos = 23;

console.log(libro); */

let estudiantes = [{
    nombre: "Alejandro",
    apellido: "Miller"
},
{
    nombre: "Martha",
    apellido: "Gómez"
},
{
    nombre: "Roger",
    apellido: "Anderson"
},
{
    nombre: "Julieta",
    apellido: "Garza"
}];

console.log(estudiantes);

for(let i = 0; i < estudiantes.length; i ++){
    console.log(estudiantes[i].nombre, estudiantes[i].apellido);
}