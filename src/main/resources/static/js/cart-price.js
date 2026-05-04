let prices = document.querySelectorAll(".total-price")
let cartTotalPrice=0.0;
for (let i = 0; i < prices.length; i++) {
    cartTotalPrice+=parseFloat(prices[i].innerText)
}
document.getElementById("subtotal").innerText="P¥"+cartTotalPrice
document.getElementById("total").innerText="P¥"+cartTotalPrice