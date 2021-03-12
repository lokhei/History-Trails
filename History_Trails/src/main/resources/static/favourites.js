
function fav(id){
    let y = "#" + id;
        if ($(y).hasClass("liked")){
            $(y).html('<i class="heart far fa-heart"></i>');
            $(y).removeClass("liked");
        }else{
            $(y).html('<i class="heart fas fa-heart"></i>');
            $(y).addClass("liked");
        }
}