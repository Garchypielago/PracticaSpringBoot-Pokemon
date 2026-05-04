
const toast = document.getElementById('myToast');

function showToast() {
    toast.classList.add('show');
    setTimeout(() => {
        toast.classList.remove('show');
    }, 5000);
}

document.getElementById("closeToast").addEventListener("click",()=>{
    toast.classList.remove('show');
})