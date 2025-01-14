const openBtn = document.getElementById("open-review");
const closeBtn =document.getElementById("close-review");
const review =document.getElementById("review")
const reviewinner =document.getElementById("inner-review")
openBtn.addEventListener("click",()=>{
    review.style.visibility="visible";
})
closeBtn.addEventListener("click",()=>{
    review.style.visibility="hidden";
})