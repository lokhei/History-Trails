// When the user scrolls the page, execute myFunction
window.onscroll = function() {myFunction()
scrollFunction()};

// Get the navbar
const navbar = document.getElementById("navbar");

// Get the offset position of the navbar
const sticky = navbar.offsetTop;
mybutton = document.getElementById("myBtn");

// Add the sticky class to the navbar when you reach its scroll position. Remove "sticky" when you leave the scroll position
function myFunction() {
    if (window.pageYOffset > sticky) {
        navbar.classList.add("sticky")
    } else {
        navbar.classList.remove("sticky");
    }
}

// When the user scrolls down 20px from the top of the document, show the button
function scrollFunction() {
    if (document.body.scrollTop > 20 || document.documentElement.scrollTop > 20) {
        mybutton.style.top = navbar.offsetHeight + 20 +"px";
            mybutton.style.display = "block";
    } else {
        mybutton.style.display = "none";
    }
}

// When the user clicks on the button, scroll to the top of the document
function topFunction() {
    document.body.scrollTop = 0; // For Safari
    document.documentElement.scrollTop = 0; // For Chrome, Firefox, IE and Opera
}


$(document).on('ready', function() {
    if (document.cookie.indexOf("accepted_cookies=") < 0) {
        $('.cookie-overlay').removeClass('d-none').addClass('d-block');
    }

    $('.accept-cookies').on('click', function() {
        document.cookie = "accepted_cookies=yes;"
        $('.cookie-overlay').removeClass('d-block').addClass('d-none');
    })

    // expand depending on your needs
    $('.close-cookies').on('click', function() {
        $('.cookie-overlay').removeClass('d-block').addClass('d-none');
    })
})

function GetCookie(name) {
    var arg=name+"=";
    var alen=arg.length;
    var clen=document.cookie.length;
    var i=0;
    while (i<clen) {
        var j=i+alen;
        if (document.cookie.substring(i,j)==arg)
            return "here";
        i=document.cookie.indexOf(" ",i)+1;
        if (i==0) break;
    }
    return null;
}