$(function() {
    forMobileApps();
});

// <!-- for-mobile-apps -->
function forMobileApps() {
    addEventListener("load", function() {
        setTimeout(hideURLbar, 0);
    }, false);

    function hideURLbar() {
        window.scrollTo(0, 1);
    }
}
