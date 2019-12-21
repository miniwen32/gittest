let blurNum = 0;
let brightnessNum = 1;
let contrastNum = 1;
let grayscaleNum = 0;
let hueRotateNum = 0;
let invertNum = 0;
let opacityNum = 1;
let saturateNum = 1;
let sepiaNum = 0;
let blur = $('#blur');
let brightness = $('#brightness');
let contrast = $('#contrast');
let grayscale = $('#grayscale');
let hueRotate = $('#hue-rotate');
let invert = $('#invert');
let opacity = $('#opacity');
let saturate = $('#saturate');
let sepia = $('#sepia');
let pic = $('.picInfo img');
$(document).ready(function () {

    //input range event start
    blur.on("change", function () {
        let val = blur.val();
        let blurVal = $('#blurVal');
        blurNum = val;
        blurVal.text(val);
        change();
    });
    brightness.on('change', function () {
        let val = Math.abs((brightness.val()) - 100) / 100;
        let brightnessVal = $('#brightnessVal');
        brightnessNum = val;
        brightnessVal.text(val);
        change();
    });
    contrast.on('change', function () {
        let val = Math.abs((contrast.val()) - 100) / 100;
        let contrastVal = $('#contrastVal');
        contrastNum = val;
        contrastVal.text(val);
        change();
    });
    grayscale.on('change', function () {
        let val = grayscale.val() / 100;
        let grayscaleVal = $('#grayscaleVal');
        grayscaleVal.text(val);
        change();
        grayscaleNum = val;
    });
    hueRotate.on('change', function () {
        let val = hueRotate.val() * 3.6;
        let hueRotateVal = $('#hue-rotateVal');
        let str = 'hue-rotate(' + val + 'deg)';
        hueRotateNum = val;
        hueRotateVal.text(Math.round(val / 3.6));
        change();
    });
    invert.on('change', function () {
        let val = invert.val() / 100;
        let invertVal = $('#invertVal');
        invertNum = val;
        invertVal.text(val);
        change();
    });
    opacity.on('change', function () {
        let val = Math.abs((opacity.val()) - 100) / 100; //數字反轉為解決
        let opacityVal = $('#opacityVal');
        opacityNum = val;
        opacityVal.text(val);
        change();
    });
    saturate.on('change', function () {
        let val = Math.abs((saturate.val() - 100)) / 100; //數字反轉為解決
        let saturateVal = $('#saturateVal');
        saturateNum = val;
        saturateVal.text(val);
        change();
    });
    sepia.on('change', function () {
        let val = sepia.val() / 100;
        let sepiaVal = $('#sepiaVal');
        sepiaNum = val;
        sepiaVal.text(val);
        change();
    });
    //input range event end
    //change all filter start
    function change() {
        $('#banana').css({
            filter: `blur(${blurNum}px) brightness(${brightnessNum}) contrast(${contrastNum}) grayscale(${grayscaleNum}) hue-rotate(${hueRotateNum}deg ) invert(${invertNum}) opacity(${opacityNum}) saturate(${saturateNum}) sepia(${sepiaNum})`
        });
    }
    //change all filter end
    //input range style start

    blur.on('mouseenter', function () {
        var p = blur.val();
        blur.on('click', function () {
            p = blur.val();
            bg(p);
        });
        blur.on('mousemove', function () {
            p = blur.val();
            bg(p);
        });
    });


    function bg(n) {
        blur.css({
            'background-image': '-webkit-linear-gradient(left ,#f22 0%,#f22 ' + n + '%,#fff ' + n + '%, #fff 100%)'
        });
    }

    //input range style end

});