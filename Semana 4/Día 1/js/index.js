
let formularioImagenes = document.querySelector(".formularioImagenes");

formularioImagenes.addEventListener("submit", async function(event){
    event.preventDefault();
    let numeroDeImagenes = document.querySelector("#numeroDeImagenes");

    let url = "https://dog.ceo/api/breeds/image/random/" + numeroDeImagenes.value;
    let config = {
        method: "GET"
        /*
        body : {},
        headers: {}
        */
    };

    let respuesta = await fetch(url, config);
    let datosJSON = await respuesta.json();

    let contenedorImagenes = document.querySelector(".imagenes"); 
    contenedorImagenes.innerHTML = "";
    for(let i = 0; i < datosJSON.message.length; i ++){
        contenedorImagenes.innerHTML += `<img class="imagenPerrito" src="${datosJSON.message[i]}" alt="Perrito" >`;
    }
});