


async function fetchLikes(id) {
    let url = "/objects?id=" + id;
    try {
        let res = await fetch(url);
        return (await res.json()).likes;
    } catch (error) {
        console.log(error);
    }
}



async function fav(id) {
    let y = "#" + id;
    let numLikes;

    if (getCookie('purecookieDismiss')) {
        // if ($(y).hasClass("liked")) {
        if (document.getElementById(id).classList.contains("fas")){
            document.getElementById(id).className = "heart far fa-heart";
            // $(y).html('class="heart far fa-heart"');
            // $(y).removeClass("liked");
            eraseCookie(id);


            numLikes = (await fetchLikes(id));

            var toSend = {
                recordid: id,
                likes: numLikes - 1
            };

            $.ajax({
                type: 'POST',
                url: "/objects?id=" + id,
                data: toSend,
                dataType: "json",
                success: function (data) {
                    console.log("Success", data);
                },
                error: function (data) {
                    console.log("Failure", data);
                },
            });

        } else {
            document.getElementById(id).className = "heart fas fa-heart";

            // $(y).html('<i class="heart fas fa-heart"></i>');
            // $(y).addClass("liked");
            setCookie(id, '1', 365);



            numLikes = (await fetchLikes(id));



            var toSend = {
                recordid: id,
                likes: numLikes + 1
            };

            $.ajax({
                type: 'POST',
                url: "/objects?id=" + id,
                data: toSend,
                dataType: "json",
                success: function (data) {
                    console.log("Success", data);
                },
                error: function (data) {
                    console.log("Failure", data);
                },
            });


        }
    } else {
        var modal = document.getElementById("myModal");
        modal.style.display = "block";
        setTimeout(function () {
            $(modal).hide();
        }, 5000);
    }

}

