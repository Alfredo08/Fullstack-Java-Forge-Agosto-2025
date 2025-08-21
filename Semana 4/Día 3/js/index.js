
let botonCerrarSesion = document.querySelector(".cerrarSesion");

botonCerrarSesion.addEventListener("click", function(){
    alert("Estás por cerrar sesión.");
});

let botonEliminar = document.querySelectorAll(".cerrar");

for(let i = 0; i < botonEliminar.length; i ++){
    botonEliminar[i].addEventListener("click", function(event){
        // Remover el elemento contenedor
        event.target.closest(".card-list-item").remove();
        // this.closest(".card-list-item").remove();

        // Actualizar el número de conexiones en la página
        let connectionRequestNumber = document.querySelector("#connectionRequestNumber");
        let valorActual = connectionRequestNumber.textContent;
        valorActual --;
        connectionRequestNumber.textContent = valorActual;
    });
}

/*
let encabezados = document.querySelectorAll(".card-header");

for(let i = 0; i < encabezados.length; i ++){
    encabezados[i].addEventListener("mouseover", function(){
        this.classList.add("extra");
    });
    
    encabezados[i].addEventListener("mouseout", function(){
        this.classList.remove("extra");
    });
}
*/
let buscar = document.querySelector(".buscar");
// Añadir el evento
buscar.addEventListener("click", function(){
    // Guardar el input en una variable
    let busqueda = document.querySelector("#busqueda");
    alert(busqueda.value);
});

let busqueda = document.querySelector("#busqueda");

busqueda.addEventListener("change", function(){
    console.log(this.value);
});

let mostrarEditarPerfil = document.querySelector("#mostrarEditarPerfil");
let contenedorModal = document.querySelector(".contenedorModal");
let userName = document.querySelector("#userName");
let city = document.querySelector("#city");
let nombre = document.querySelector("#nombre");
let ciudad = document.querySelector("#ciudad");
let contenidoPagina = document.querySelectorAll(".nav, .main");

mostrarEditarPerfil.addEventListener("click", function(){
    contenedorModal.classList.remove("oculta");
    nombre.value = userName.textContent;
    ciudad.value = city.textContent;
    for(let i = 0; i < contenidoPagina.length; i ++){
        contenidoPagina[i].classList.add("overlay");
    }
});

let editarPerfil = document.querySelector(".editarPerfil");
editarPerfil.addEventListener("submit", function(event){
    event.preventDefault();
    contenedorModal.classList.add("oculta");
    userName.textContent = nombre.value;
    city.textContent = ciudad.value;
    for(let i = 0; i < contenidoPagina.length; i ++){
        contenidoPagina[i].classList.remove("overlay");
    }
});