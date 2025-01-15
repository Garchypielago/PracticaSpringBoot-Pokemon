let types = document.querySelectorAll(".type")
let typearray =[]
let button = document.getElementById("search-button")

button.addEventListener("click",buscar)
function buscar(){
for(type in types){
        console.log("hoal")
        if (this.checked) {
            typearray.push(this.id)
            console.log(this.id)
            console.log("si")
        }
    for (a in typearray){
        console.log(a)
    }

}}