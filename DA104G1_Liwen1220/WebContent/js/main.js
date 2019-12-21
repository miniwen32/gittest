$(document).ready(function () {
    //自動取得footer年份
    (function () {
        let year = new Date().getFullYear();
        $('#year').text(year);
    }());
    //navbar 動畫
    let win = $(window);
    let nav = $('.navbar-header');
    let prePos = window.pageYOffset;
    win.on('scroll', function () {
        let pos = window.pageYOffset;
        if (pos > prePos) {
            nav.addClass('hide');

        } else if (pos <= prePos) {
            nav.removeClass('hide');

        }
        prePos = pos;
    })


})