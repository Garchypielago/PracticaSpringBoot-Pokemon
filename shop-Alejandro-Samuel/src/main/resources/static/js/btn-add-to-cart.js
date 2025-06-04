const errorCloseBtn = document.getElementById("errorCloseBtn");
const error = document.getElementById("error")
const errorDesc = document.getElementById("errorDesc")
const errorTitle = document.getElementById("errorTitle")


errorCloseBtn.addEventListener("click", () => {
    error.style.visibility = "hidden";
    document.body.style.overflow = "auto";
})

function openError(titleStatus, descriptionStatus) {
    errorTitle.innerHTML = titleStatus
    errorDesc.innerHTML = descriptionStatus
    error.style.visibility = "visible";
    document.body.style.overflow = "hidden";
}


const btnAddToCart = document.getElementById("btnAddToCart");
const pokemonQuantity = document.getElementById("pokemonQuantity")

// btnAddToCart.removeEventListener()
btnAddToCart.addEventListener("click", () => {
    fetch(appBasePath + "cart/api/add", {
        method: "POST",
        body: JSON.stringify({
            id: parseInt(btnAddToCart.getAttribute("data-pokemonid")),
            productNumber: parseInt(pokemonQuantity.value)
            // id: btnAddToCart.getAttribute("data-pokemonId") ,
            // productNumber: pokemonQuantity.value
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
            //     toast
            showToast()
        })
        .catch(error => {
            if (error === 409) {
                openError("ERROR 409: Insufficient Stock", "You have requested too many pokemons of this type and we don't have enough stock");
            } else if (error === 404) {
                openError("ERROR 404: Pokemon not Found", "This pokemon does not exist");
            } else {
                openError("ERROR", "An unexpected error occurred");
            }
        });
});