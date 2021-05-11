


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
    let toSend;
    let numLikes;

    let token = $("meta[name='_csrf']").attr("content");

    if (getCookie('purecookieDismiss')) {
        if (document.getElementById(id).classList.contains("fas")){
            document.getElementById(id).className = "heart far fa-heart";
            eraseCookie(id);


            numLikes = (await fetchLikes(id));

            toSend = {
                recordid: id,
                likes: numLikes - 1,
                "X-CSRF-TOKEN": token
            };

            $.ajax({
                type: 'PUT',
                url: "/objects?id=" + id,
                data: JSON.stringify(toSend),
                dataType: "json",
                headers: {
                    'Accept': 'application/json',
                    'Content-Type': 'application/json',
                    "X-CSRF-TOKEN": token

                },
                success: function (data) {
                    console.log("Success", data);
                },
                error: function (data) {
                    console.log("Failure", data);

                },
            });

        } else {
            document.getElementById(id).className = "heart fas fa-heart";
            setCookie(id, '1', 365);

            numLikes = (await fetchLikes(id));

            toSend = {
                recordid: id,
                likes: numLikes + 1
            };

            $.ajax({
                type: 'PUT',
                url: "/objects?id=" + id,
                data: JSON.stringify(toSend),
                dataType: "json",
                headers: {
                    'Accept': 'application/json',
                    'Content-Type': 'application/json',
                    "X-CSRF-TOKEN": token
                },
                success: function (data) {
                    console.log("Success", data);
                },
                error: function (data) {
                    console.log("Failure", data);
                },
            });


        }
    } else {
        const modal = document.getElementById("myModal");
        modal.style.display = "block";
        setTimeout(function () {
            $(modal).hide();
        }, 5000);
    }

}

