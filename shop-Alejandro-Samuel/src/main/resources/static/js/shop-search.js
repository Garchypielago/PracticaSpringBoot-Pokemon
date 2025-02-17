let types = document.getElementsByClassName("type");
let typearray =[];
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
    let type1Checked = document.querySelector('input[name="type1"]:checked')
    let type2Checked = document.querySelector('input[name="type2"]:checked')

    
    if (type2Checked !=null){

    }
}