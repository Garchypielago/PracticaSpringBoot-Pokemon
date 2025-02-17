
const btnAddToCart = document.getElementById("btnAddToCart");
const pokemonQuantity = document.getElementById("pokemonQuantity")

// btnAddToCart.removeEventListener()
btnAddToCart.addEventListener("click", () => {
    fetch("/contextpath/api/v1/pokemones", {
        method: "POST",
        body: JSON.stringify({
            id: parseInt(btnAddToCart.getAttribute("data-pokemonid")) ,
            productNumber: parseInt(pokemonQuantity.value)
            // id: btnAddToCart.getAttribute("data-pokemonId") ,
            // productNumber: pokemonQuantity.value
        }),
        headers: {
            "Content-type": "application/json; charset=UTF-8"
        }
    })
        .then(response => {

            response.ok

            // fetch("/contextpath/api/v1/pokemones")
            //     .then(response => {
            //         response.text().then(text => {
            //                 const productos = JSON.parse(text);
            //                 console.table(productos);
            //             }
            //         );
            //
            //     });
            // console.log("ok")

        })
        .catch(reason => alert("Error"))
})
