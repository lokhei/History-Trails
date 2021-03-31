
function fav(id){
    let y = "#" + id;
    if  (getCookie('purecookieDismiss')){
        if ($(y).hasClass("liked")) {
            $(y).html('<i class="heart far fa-heart"></i>');
            $(y).removeClass("liked");
        } else {
            $(y).html('<i class="heart fas fa-heart"></i>');
            $(y).addClass("liked");
        }
    }else{
        var modal = document.getElementById("myModal");
        modal.style.display = "block";
        setTimeout(function(){
            $(modal).hide();
        }, 5000);
    }
}