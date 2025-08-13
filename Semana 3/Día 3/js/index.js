
let cities = document.querySelectorAll('.city');

for(let i = 0; i < cities.length; i ++){
    cities[i].addEventListener("click", function(){
        alert("Loading weather report...");
    });
}

let cookieAccept = document.querySelector('.cookie-accept');

cookieAccept.addEventListener("click", function(){
    this.closest('.cookie').remove();
});

let temperatureSelect = document.querySelector("#temperature"); 

temperatureSelect.addEventListener("change", function(){
    let temperatures = document.querySelectorAll('.max, .min');
    for(let i = 0; i < temperatures.length; i ++){
        let current = temperatures[i].textContent;
        if(this.value === "farenheit"){
            let newTemp = (current * 9 / 5) + 32;
            temperatures[i].textContent = Math.round(newTemp);
        }
        else{
            let newTemp = (current - 32) * 5 / 9;
            temperatures[i].textContent = Math.round(newTemp);
        }
    }
  
});
