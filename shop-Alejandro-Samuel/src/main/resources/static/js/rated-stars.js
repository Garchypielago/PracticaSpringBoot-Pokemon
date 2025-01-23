let starrated = document.querySelectorAll(".ratings span")
let rated = document.getElementById("avgRating").innerText
if (rated<=0){

}
else if(rated<=0.5){
    starrated[9].setAttribute("data-clicked","true")
}
else if(rated<=1){
    starrated[8].setAttribute("data-clicked","true")
}
else if(rated<=1.5){
    starrated[7].setAttribute("data-clicked","true")
}
else if(rated<=2){
    starrated[6].setAttribute("data-clicked","true")
}
else if(rated<=2.5){
    starrated[5].setAttribute("data-clicked","true")
}
else if(rated<=3){
    starrated[4].setAttribute("data-clicked","true")
}
else if(rated<=3.5){
    starrated[3].setAttribute("data-clicked","true")

}else if(rated<=4){
    starrated[2].setAttribute("data-clicked","true")

}else if(rated<=4.5){
    starrated[1].setAttribute("data-clicked","true")

}
else if(rated<=5){
    starrated[0].setAttribute("data-clicked","true")

}


