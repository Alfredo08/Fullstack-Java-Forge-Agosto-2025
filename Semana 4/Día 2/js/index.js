let config = {
    method: "GET"
};

async function desplegarDetallePokemon(url){
    let respuesta = await fetch(url, config);
    let datosJSON = await respuesta.json();
    let contenedorDetalle = document.querySelector(".detalle");

    let tipos = "";
    for(let i = 0; i < datosJSON.types.length; i ++){
        tipos += `<p> ${datosJSON.types[i].type.name} </p>`;
    }

    contenedorDetalle.innerHTML = `
        <h2> ${datosJSON.name} </h2>
        <img src="${datosJSON.sprites.other.dream_world.front_default}" alt="${datosJSON.name}">
        <h3> Types </h3>
        <div class="tipos">
            ${tipos}
        </div>
    `;
    console.log(datosJSON);
}

async function cargarListadoDePokemones(URL){
    let respuesta = await fetch(URL, config);
    let datosJSON = await respuesta.json();

    let contenedorListado = document.querySelector(".listado");
    contenedorListado.innerHTML = "";

    for(let i = 0; i < datosJSON.results.length; i ++){
        let botonPokemon = document.createElement("button");
        botonPokemon.classList.add("botonPokemon")
        botonPokemon.textContent = datosJSON.results[i].name;
        botonPokemon.addEventListener("click", () => desplegarDetallePokemon(datosJSON.results[i].url));
        contenedorListado.appendChild(botonPokemon);
    }

    let contenedorPaginacion = document.querySelector(".paginacion");
    contenedorPaginacion.innerHTML = "";

    if(datosJSON.previous !== null){
        let botonPaginaPrevia = document.createElement("button");
        botonPaginaPrevia.classList.add("botonPaginacion");
        botonPaginaPrevia.textContent = "Página previa";
        botonPaginaPrevia.addEventListener("click", () => cargarListadoDePokemones(datosJSON.previous));
        contenedorPaginacion.appendChild(botonPaginaPrevia);
    }

    if(datosJSON.next !== null){
        let botonPaginaSiguiente = document.createElement("button");
        botonPaginaSiguiente.classList.add("botonPaginacion");
        botonPaginaSiguiente.textContent = "Página siguiente";
        botonPaginaSiguiente.addEventListener("click", () => cargarListadoDePokemones(datosJSON.next));
        contenedorPaginacion.appendChild(botonPaginaSiguiente);
    }
}

cargarListadoDePokemones("https://pokeapi.co/api/v2/pokemon/");