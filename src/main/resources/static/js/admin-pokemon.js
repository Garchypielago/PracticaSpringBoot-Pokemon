const resetNewPoke = document.getElementsByTagName("body")

const textName = document.getElementById("txt-name")
const textDescription = document.getElementById("txt-description")

const selectRegion = document.getElementById("select-region")
const selectType1 = document.getElementById("select-type1")
const selectType2 = document.getElementById("select-type2")

const numberStock = document.getElementById("number-stock")
const checkLegendary = document.getElementById("flexCheck-legendary")

const dataListReference = document.getElementById("dataList-reference")

const btnSendNewCategory = document.getElementById("btn-new-poke")

document.addEventListener("DOMContentLoaded", ()=>{
    // textName.removeAttribute("disabled")
    selectType2.setAttribute("disabled", "")
    dataListReference.setAttribute("disabled", "")
})

selectRegion.addEventListener("change", ()=>{
    if (selectRegion.value === ""){
        dataListReference.setAttribute("disabled", "")
        return
    }

    dataListReference.removeAttribute("disabled")

    //todo mostrar los pokemon de esa region solo
    fetch(appBasePath + "api/v1/pokemones", {
        method: "POST",
        body: JSON.stringify({
            id: parseInt(btnAddToCart.getAttribute("data-pokemonid")),
            productNumber: parseInt(pokemonQuantity.value)
        }),
        headers: {
            "Content-type": "application/json; charset=UTF-8"
        }
    })
        .then(response => {
            if (response.status == 404 || response.status == 409){
                throw response.status
            }
        })
        .then(data => {
            showToast()
        })
        .catch(error => {
            openError("ERROR", "An unexpected error occurred");
        });
//
})

selectTypeCategory.addEventListener("change", ()=>{

})

btnSendNewCategory.addEventListener("click", clearAll)

function clearAll(){
// no se limpialos, si hay un 200
}

