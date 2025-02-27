let types = document.getElementsByClassName("type");
let typearray =[];
let type1Checked
let type2Checked
let button = document.getElementById("empty-button");
let t1 = true;
for(let type of types){
    type.addEventListener("click", cambiar);
}






function cambiar(){

    if(this.getAttribute("name") === "type1") {
        let typesUnchecked = document.querySelectorAll('input[name="type1"]:not(:checked)')
        for (let tu in typesUnchecked) {
            typesUnchecked[tu].setAttribute("name", "type2");
        }
    }
    else {
        let typesUnchecked = document.querySelectorAll('input[name="type2"]:not(:checked)')
        for (let tu in typesUnchecked) {
            typesUnchecked[tu].setAttribute("name", "type1");
        }
    }
    type1Checked = document.querySelector('input[name="type1"]:checked')
    type2Checked = document.querySelector('input[name="type2"]:checked')
}

btnAddToCart.addEventListener("click", () => {
    fetch(appBasePath + "shop/shop/category/", {
        method: "POST",
        body: JSON.stringify({
            type1: type1Checked,
            type2: type2Checked

        }),
        headers: {
            "Content-type": "application/json; charset=UTF-8"
        }
    })})
