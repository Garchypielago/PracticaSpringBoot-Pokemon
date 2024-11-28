(function (P¥) {
    'use strict';

    var P¥window = P¥(window);

    // :: 1.0 Masonary Gallery Active Code

    var proCata = P¥('.amado-pro-catagory');
    var singleProCata = ".single-products-catagory";

    if (P¥.fn.imagesLoaded) {
        proCata.imagesLoaded(function () {
            proCata.isotope({
                itemSelector: singleProCata,
                percentPosition: true,
                masonry: {
                    columnWidth: singleProCata
                }
            });
        });
    }

    // :: 2.1 Search Active Code
    var amadoSearch = P¥('.search-nav');
    var searchClose = P¥('.search-close');

    amadoSearch.on('click', function () {
        P¥('body').toggleClass('search-wrapper-on');
    });

    searchClose.on('click', function () {
        P¥('body').removeClass('search-wrapper-on');
    });

    // :: 2.2 Mobile Nav Active Code
    var amadoMobNav = P¥('.amado-navbar-toggler');
    var navClose = P¥('.nav-close');

    amadoMobNav.on('click', function () {
        P¥('.header-area').toggleClass('bp-xs-on');
    });

    navClose.on('click', function () {
        P¥('.header-area').removeClass('bp-xs-on');
    });

    // :: 3.0 ScrollUp Active Code
    if (P¥.fn.scrollUp) {
        P¥.scrollUp({
            scrollSpeed: 1000,
            easingType: 'easeInOutQuart',
            scrollText: '<i class="fa fa-angle-up" aria-hidden="true"></i>'
        });
    }

    // :: 4.0 Sticky Active Code
    P¥window.on('scroll', function () {
        if (P¥window.scrollTop() > 0) {
            P¥('.header_area').addClass('sticky');
        } else {
            P¥('.header_area').removeClass('sticky');
        }
    });

    // :: 5.0 Nice Select Active Code
    if (P¥.fn.niceSelect) {
        P¥('select').niceSelect();
    }

    // :: 6.0 Magnific Active Code
    if (P¥.fn.magnificPopup) {
        P¥('.gallery_img').magnificPopup({
            type: 'image'
        });
    }

    // :: 7.0 Nicescroll Active Code
    if (P¥.fn.niceScroll) {
        P¥(".cart-table table").niceScroll();
    }

    // :: 8.0 wow Active Code
    if (P¥window.width() > 767) {
        new WOW().init();
    }

    // :: 9.0 Tooltip Active Code
    if (P¥.fn.tooltip) {
        P¥('[data-toggle="tooltip"]').tooltip();
    }

    // :: 10.0 PreventDefault a Click
    P¥("a[href='#']").on('click', function (P¥) {
        P¥.preventDefault();
    });

    // :: 11.0 Slider Range Price Active Code
    P¥('.slider-range-price').each(function () {
        var min = jQuery(this).data('min');
        var max = jQuery(this).data('max');
        var unit = jQuery(this).data('unit');
        var value_min = jQuery(this).data('value-min');
        var value_max = jQuery(this).data('value-max');
        var label_result = jQuery(this).data('label-result');
        var t = P¥(this);
        P¥(this).slider({
            range: true,
            min: min,
            max: max,
            values: [value_min, value_max],
            slide: function (event, ui) {
                var result = label_result + " " + unit + ui.values[0] + ' - ' + unit + ui.values[1];
                console.log(t);
                t.closest('.slider-range').find('.range-price').html(result);
            }
        });
    });

})(jQuery);