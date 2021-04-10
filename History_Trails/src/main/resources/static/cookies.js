// --- Config --- //
const purecookieTitle = "Cookies"; // Title
const purecookieDesc = "This website uses cookies to ensure you get the best experience on our website"; // Description
const purecookieLink = '<a href="more" target="_blank">Learn More</a>'; // Cookiepolicy link
const purecookieButton = "Accept"; // Button text
// ---        --- //


function pureFadeIn(elem, display){
    const el = document.getElementById(elem);
    el.style.opacity = 0;
    el.style.display = display || "block";

    (function fade() {
        let val = parseFloat(el.style.opacity);
        if (!((val += .02) > 1)) {
            el.style.opacity = val;
            requestAnimationFrame(fade);
        }
    })();
}

function pureFadeOut(elem){
    const el = document.getElementById(elem);
    el.style.opacity = 1;

    (function fade() {
        if ((el.style.opacity -= 0.02) < 0) {
            el.style.display = "none";
        } else {
            requestAnimationFrame(fade);
        }
    })();
}

function setCookie(name,value,days) {
    let expires = "";
    if (days) {
        const date = new Date();
        date.setTime(date.getTime() + (days*24*60*60*1000));
        expires = "; expires=" + date.toUTCString();
    }
    document.cookie = name + "=" + (value || "")  + expires + "; path=/; SameSite=Lax";
}

function getCookie(name) {
    const nameEQ = name + "=";
    const ca = document.cookie.split(';');
    for(let i=0; i < ca.length; i++) {
        let c = ca[i];
        while (c.charAt(0)===' ') c = c.substring(1,c.length);
        if (c.indexOf(nameEQ) === 0) return c.substring(nameEQ.length,c.length);
    }
    return null;
}
function eraseCookie(name) {
    document.cookie = name+'=; Max-Age=-99999999;';
}

function cookieConsent() {
    if (!getCookie('purecookieDismiss')) {
        document.body.innerHTML += '<div class="cookieConsentContainer" id="cookieConsentContainer">' +
            '<div class="cookieTitle"><a>' + purecookieTitle + '</a></div>' +
            '<div class="cookieDesc"><p>' + purecookieDesc + '</p></div>' +
            '<div class="cookieButton"><a onClick="purecookieDismiss();">' + purecookieButton + '</a></div>'+
            '<div class="cookieLink">' + purecookieLink + '</div></div>';
        pureFadeIn("cookieConsentContainer");
    }
}

function purecookieDismiss() {
    setCookie('purecookieDismiss','1',365);
    pureFadeOut("cookieConsentContainer");
}