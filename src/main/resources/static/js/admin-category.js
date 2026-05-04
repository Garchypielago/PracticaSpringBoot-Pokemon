const selectTypeCategory = document.getElementById("select-type")
const textName = document.getElementById("txt-name")
const textBackground = document.getElementById("txt-background")
const btnSendNewCategory = document.getElementById("btn-new-category")

document.addEventListener("DOMContentLoaded", ()=>{
    // textName.setAttribute("disabled", "")
    textBackground.setAttribute("disabled", "")
    btnSendNewCategory.setAttribute("disabled", "")
})

selectTypeCategory.addEventListener("change", ()=>{
    if(selectTypeCategory.value == "1"){
        btnSendNewCategory.removeAttribute("disabled")
        textBackground.setAttribute("disabled", "")
        // textName.removeAttribute("disabled")
        clearAll()
    }
    if(selectTypeCategory.value == "2"){
        btnSendNewCategory.removeAttribute("disabled")
        textBackground.removeAttribute("disabled")
        // textName.removeAttribute("disabled")
        clearAll()
    }
    if(selectTypeCategory.value == ""){
        // textName.setAttribute("disabled", "")
        textBackground.setAttribute("disabled", "")
        btnSendNewCategory.setAttribute("disabled", "")
        clearAll()
    }
})

function clearAll(){
    // textName.value = ""
    textBackground.value = ""
}

