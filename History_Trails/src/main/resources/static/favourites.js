

function fav(id) {
    let y = "#" + id;
    let numLikes;

    if (getCookie('purecookieDismiss')) {
        if ($(y).hasClass("liked")) {
            $(y).html('<i class="heart far fa-heart"></i>');
            $(y).removeClass("liked");
            eraseCookie(id);

        } else {
            $(y).html('<i class="heart fas fa-heart"></i>');
            $(y).addClass("liked");
            setCookie(id, '1', 365);


        }
    } else {
        var modal = document.getElementById("myModal");
        modal.style.display = "block";
        setTimeout(function () {
            $(modal).hide();
        }, 5000);
    }

}

