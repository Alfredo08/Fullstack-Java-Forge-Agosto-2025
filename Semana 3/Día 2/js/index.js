
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

let encabezados = document.querySelectorAll(".card-header");

for(let i = 0; i < encabezados.length; i ++){
    encabezados[i].addEventListener("mouseover", function(){
        this.classList.add("extra");
    });
    
    encabezados[i].addEventListener("mouseout", function(){
        this.classList.remove("extra");
    });
}

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