//para que salga el pop up
let canReview=true;
const openBtn = document.getElementById("open-review");
const sendBtn =document.getElementById("send-review");
const closeBtn =document.getElementById("close-review");
const review =document.getElementById("review")
const reviewtext =document.getElementById("review-area")
const pokemonJSId = document.getElementById("pokemonJSId")

openBtn.addEventListener("click",()=>{
    review.style.visibility="visible";
    document.body.style.overflow = "hidden";

})
sendBtn.addEventListener("click",()=>{
    review.style.visibility="hidden";
    document.body.style.overflow = "auto";
    canReview=false;
    sendData();
})
closeBtn.addEventListener("click",()=>{
    review.style.visibility="hidden";
    document.body.style.overflow = "auto";
})

//sistema de estrellas
let stars = document.querySelectorAll(".rating-stars span")
let rating

for(let star of stars){
    star.addEventListener("click",function (){
        let children=star.parentElement.children
        for(let child of children){
            if(child.getAttribute("data-clicked")){
                if(canReview){
                child.removeAttribute("data-clicked")}
                else{
                    return false
                }
            }
        }

        this.setAttribute("data-clicked","true")
        rating=this.dataset.rating;
    })
}

function sendData(){
    let reviewtxt = reviewtext.value
    let pokemonid=pokemonJSId.getAttribute('data-id')
    let ratingArray={rating,pokemonid,reviewtxt}
    console.log(ratingArray)
    // fetch("../templates/product-details",{
    //     method:"POST", body:ratingArray
    // })
    //     .then(text=>console.log(text))
}