"use strict";
! function(a) {
    var n = a(window),
        i = a("body");
    feather.replace(),
        a(document).on("click", '[data-toggle="fullscreen"]', function() {
            return a(this).toggleClass("active-fullscreen"), document.fullscreenEnabled ? a(this).hasClass("active-fullscreen") ? document.documentElement.requestFullscreen() : document.exitFullscreen() : alert("Your browser does not support fullscreen."), !1
        }),
        a(document).on("click", ".navigation-toggler > a", function() {
            return i.hasClass("small-navigation") ? (i.removeClass("small-navigation"), a(".navigation").niceScroll(),
                a(".navigation .navigation-menu-body > ul > li").each(function() {
                    a(this).find("> a").next("ul").length ? a(this).find(".dropdown-divider").remove() : a(this).find("> a").tooltip("dispose")
                })) : i.hasClass("hidden-navigation") || n.width() < 1200 ? (a.createOverlay(), a(".navigation").addClass("open"),
                a(".navigation").on("webkitTransitionEnd otransitionend oTransitionEnd msTransitionEnd transitionend",
                    function(e) {
                        a(".navigation").niceScroll().resize()
                    }), a('[data-toggle="dropdown"]').dropdown("hide")) : (i.addClass("small-navigation"), a(".navigation").getNiceScroll().remove(),
                a(".navigation .navigation-menu-body > ul > li").each(function() {
                    a(this).find("> a").next("ul").length ? a(this).find("> a").next("ul").prepend('<li class="dropdown-divider">' + a(this).find("> a > span:not(.badge)").text() + "</li>") : (a(this).find("> a").attr("title",
                        a(this).find("> a > span:not(.badge)").text()), a(this).find("> a").tooltip({
                        placement: "right"
                    }))
                })), !1
        }), a(document).on("click", ".overlay", function() {

            a.removeOverlay(), i.hasClass("hidden-navigation") && a(".navigation").niceScroll().remove(),
                a(".navigation").removeClass("open")
        }), a.createOverlay = function() {
            a(".overlay").length < 1 && (i.addClass("no-scroll").append('<div class="overlay"></div>'), a(".overlay").addClass("show"))
        },
        a.removeOverlay = function() {
            i.removeClass("no-scroll"), a(".overlay").remove()
        },
        a("[data-backround-image]").each(function(e) {
            a(this).css("background", "url(" + a(this).data("backround-image") + ")")
        }), n.on("load", function() {
            a(".preloader").fadeOut(700, function() {
                setTimeout(function() {
                    toastr.options = {
                            timeOut: 5e3,
                            progressBar: !0,
                            showMethod: "slideDown",
                            hideMethod: "slideUp",
                            showDuration: 200,
                            hideDuration: 200
                        },
                        toastr.info("??????????????????."), a(".theme-switcher").removeClass("open")
                }, 500), a(".theme-switcher").css("opacity", 1)
            })
        }), n.on("load", function() {
            setTimeout(function() {
                a(".navigation .navigation-menu-body ul li a").each(function() {
                    var e = a(this);
                    e.next("ul").length && e.append('<i class="sub-menu-arrow ti-angle-up"></i>')
                }), a(".navigation .navigation-menu-body ul li.open>a>.sub-menu-arrow").removeClass("ti-plus").addClass("ti-minus").addClass("rotate-in")
            }, 200)
        }), a(document).on("click", ".header-toggler a", function() {

            return a(".header ul.navbar-nav").toggleClass("open"), !1;
        }), a(document).on("click", "*", function(e) {
            a(e.target).is(".header ul.navbar-nav, .header ul.navbar-nav *, .header-toggler, .header-toggler *") || a(".header ul.navbar-nav").removeClass("open")
        }), window.addEventListener("load", function() {
            var e = document.getElementsByClassName("needs-validation");
            Array.prototype.filter.call(e, function(t) {
                t.addEventListener("submit", function(e) {
                    !1 === t.checkValidity() && (e.preventDefault(), e.stopPropagation()), t.classList.add("was-validated")
                }, !1)
            })
        }, !1);
    var e = a(".table-responsive-stack");

    function t() {
        n.width() < 768 ? a(".table-responsive-stack").each(function(e) {
            a(this).find(".table-responsive-stack-thead").show(), a(this).find("thead").hide()
        }) : a(".table-responsive-stack").each(function(e) {
            a(this).find(".table-responsive-stack-thead").hide(), a(this).find("thead").show()
        })
    }
    e.find("th").each(function(e) {
            a(".table-responsive-stack td:nth-child(" + (e + 1) + ")").prepend('<span class="table-responsive-stack-thead">' + a(this).text() + ":</span> "),
                a(".table-responsive-stack-thead").hide()
        }), e.each(function() {
            var e = 100 / a(this).find("th").length + "%";
            a(this).find("th, td").css("flex-basis", e)
        }), t(), window.onresize = function(e) {
            t()
        },

        a(document).on("click", ".accordion.custom-accordion .accordion-row a.accordion-header", function() {
            var e = a(this);
            return e.closest(".accordion.custom-accordion").find(".accordion-row").not(e.parent()).removeClass("open"),
                e.parent(".accordion-row").toggleClass("open"), !1
        });
    var o, s = a(".table-responsive");
    if (s.on("show.bs.dropdown", function(e) {
            o = a(e.target).find(".dropdown-menu"), i.append(o.detach());
            var t = a(e.target).offset();
            o.css({
                display: "block",
                top: t.top + a(e.target).outerHeight(),
                left: t.left,
                width: "184px",
                "font-size": "14px"
            }), o.addClass("mobPosDropdown")
        }), s.on("hide.bs.dropdown", function(e) {
            a(e.target).append(o.detach()), o.hide()
        }), a(document).on("click", ".chat-app-wrapper .btn-chat-sidebar-open", function() {
            return a(".chat-app-wrapper .chat-sidebar").addClass("chat-sidebar-opened"), !1;
        }), a(document).on("click", "*", function(e) {
            a(e.target).is(".chat-app-wrapper .chat-sidebar, .chat-app-wrapper .chat-sidebar *, .chat-app-wrapper .btn-chat-sidebar-open, .chat-app-wrapper .btn-chat-sidebar-open *") || a(".chat-app-wrapper .chat-sidebar").removeClass("chat-sidebar-opened")
        }), a(document).on("click", ".navigation ul li a", function() {

            var e = a(this);
            if (e.next("ul").length) {
                var t = e.find(".sub-menu-arrow");
                return t.toggleClass("rotate-in"),
                    e.next("ul").toggle(200),
                    //e.parent("li").siblings().find("ul").not(e.parent("li").find("ul")).slideUp(200),
                    e.next("ul").find("li ul").slideUp(200),

                    e.next("ul").find("li>a").find(".sub-menu-arrow").removeClass("ti-minus").addClass("ti-plus"),
                    e.next("ul").find("li>a").find(".sub-menu-arrow").removeClass("rotate-in"),

                    e.parent("li").siblings().not(e.parent("li").find("ul")).find(">a").find(".sub-menu-arrow").removeClass("ti-minus").addClass("ti-plus"),
                    //e.parent("li").siblings().not(e.parent("li").find("ul")).find(">a").find(".sub-menu-arrow").removeClass("rotate-in"),

                    t.hasClass("rotate-in") ? setTimeout(function() {
                        t.removeClass("ti-plus").addClass("ti-minus")
                    }, 200) : t.removeClass("ti-minus").addClass("ti-plus"), !i.hasClass("horizontal-side-menu") && 1200 <= n.width() && setTimeout(function(e) {
                        a(".navigation").getNiceScroll().resize()
                    }, 300), !1
            }

        }), a("body.icon-side-menu .navigation").hover(function(e) {}, function(e) {
            e.stopPropagation(), a(".navigation ul").removeAttr("style"), a(".navigation ul li").not(".open").find(">a>.sub-menu-arrow").removeClass("rotate-in").removeClass("ti-minus").addClass("ti-plus")
        }), a(document).on("click", ".dropdown-menu", function(e) {
            e.stopPropagation()
        }), a("#exampleModal").on("show.bs.modal", function(e) {
            var t = a(e.relatedTarget).data("whatever"),
                n = a(this);
            n.find(".modal-title").text("New message to " + t), n.find(".modal-body input").val(t)
        }), a('[data-toggle="tooltip"]').tooltip({
            container: "body"
        }), a('[data-toggle="popover"]').popover(), a(".carousel").carousel(), 992 <= n.width()) {
        a(".card-scroll").niceScroll(), a(".table-responsive").niceScroll(), a(".app-block .app-content .app-lists").niceScroll(),
            a(".app-block .app-sidebar .app-sidebar-menu").niceScroll(), a(".chat-block .chat-sidebar .chat-sidebar-content .tab-content .tab-pane").niceScroll();
        var l = a(".chat-block .chat-content .messages");
        l.length && (l.niceScroll({
            horizrailenabled: !1
        }), l.getNiceScroll(0).doScrollTop(l.get(0).scrollHeight, -1))
    }!i.hasClass("small-navigation") && !i.hasClass("hidden-navigation") && 992 <= n.width() && i.hasClass("sticky-navigation") && a(".navigation").niceScroll(),
        a(".dropdown-menu ul.list-group").niceScroll(), a(document).on("click", ".chat-block .chat-content .mobile-chat-close-btn a",
            function() {
                return a(".chat-block .chat-content").removeClass("mobile-open"), !1;
            });
    var c = window.location.pathname.split("/").pop(),
        d = '<div class="theme-switcher open"> \n        <div class="theme-switcher-button"> \n            <i class="fa fa-cog"></i> \n        </div> \n        <div class="theme-switcher-panel"> \n            <div class="card"> \n                <div class="card-body"> \n                    <h6 class="card-title">Theme Switcher</h6> \n                    <div class="form-group mb-2"> \n                        <div class="custom-control custom-switch"> \n                            <input type="checkbox" class="custom-control-input" id="shadow-layout"> \n                            <label class="custom-control-label" for="shadow-layout">Shadow layout</label> \n                        </div> \n                    </div> \n                    <div class="form-group mb-2"> \n                        <div class="custom-control custom-switch"> \n                            <input type="checkbox" class="custom-control-input" ' + ("chat.html" === c || "inbox.html" === c || "app-todo.html" === c ? "disabled" : "") + ' id="sticky-header"> \n                            <label class="custom-control-label" for="sticky-header">Sticky header</label> \n                        </div> \n                    </div> \n                    <div class="form-group mb-2"> \n                        <div class="custom-control custom-switch"> \n                            <input type="checkbox" class="custom-control-input" id="light-header"> \n                            <label class="custom-control-label" for="light-header">Light header</label> \n                        </div> \n                    </div> \n                    <div class="form-group mb-2"> \n                        <div class="custom-control custom-switch"> \n                            <input type="checkbox" class="custom-control-input" ' + ("chat.html" === c || "inbox.html" === c || "app-todo.html" === c ? "disabled" : "") + ' id="sticky-footer"> \n                            <label class="custom-control-label" for="sticky-footer">Sticky footer</label> \n                        </div> \n                    </div> \n                </div> \n            </div> \n        </div> \n    </div>';
    a("body").append(d), a(document).on("click", '.theme-switcher input[type="checkbox"]', function() {
        var e = a(this).attr("id");
        "sticky-navigation" === e && (a(this).prop("checked") ? a(".navigation").niceScroll().resize() : a(".navigation").niceScroll().remove(),
            a("body").hasClass("small-navigation") && (a(".navigation .navigation-menu-body > ul > li").each(function() {
                a(this).find("> a").next("ul").length ? a(this).find(".dropdown-divider").remove() : a(this).find("> a").tooltip("dispose")
            }), a("body").removeClass("small-navigation"), a('.theme-switcher input[type="checkbox"][id="small-navigation"]').prop("checked", !1)), a("body").hasClass("hidden-navigation") && (CUSTOM??ZABLE, a("body").removeClass("hidden-navigation"),
                a('.theme-switcher input[type="checkbox"][id="hidden-navigation"]').prop("checked", !1))), "small-navigation" === e && (a(this).prop("checked") ? a(".navigation .navigation-menu-body > ul > li").each(function() {
            a(this).find("> a").next("ul").length ? a(this).find("> a").next("ul").prepend('<li class="dropdown-divider">' + a(this).find("> a > span:not(.badge)").text() + "</li>") : (a(this).find("> a").attr("title",
                a(this).find("> a > span:not(.badge)").text()), a(this).find("> a").tooltip({
                placement: "right"
            }))
        }) : a(".navigation .navigation-menu-body > ul > li").each(function() {

            a(this).find("> a").next("ul").length ? a(this).find(".dropdown-divider").remove() : a(this).find("> a").tooltip("dispose")

        }), a("body").hasClass("sticky-navigation") && (a("body").removeClass("sticky-navigation"), a(".navigation").niceScroll().remove(),
            a('.theme-switcher input[type="checkbox"][id="sticky-navigation"]').prop("checked", !1)), a("body").hasClass("hidden-navigation") && (a("body").removeClass("hidden-navigation"),
            a('.theme-switcher input[type="checkbox"][id="hidden-navigation"]').prop("checked", !1))), "hidden-navigation" === e && (setTimeout(function() {
                a(".navigation").niceScroll().resize(), a(".app-block .app-content .app-lists").niceScroll().resize(),
                    a(".app-block .app-sidebar .app-sidebar-menu").niceScroll().resize(), a(".chat-block .chat-sidebar .chat-sidebar-content .tab-content .tab-pane").niceScroll().resize()
            }, 200), a(this).prop("checked") || (a.removeOverlay(), a(".navigation").removeClass("open")),
            "chat.html" != c && "inbox.html" != c && "app-todo.html" != c && a("body").hasClass("sticky-navigation") && (a("body").removeClass("sticky-navigation"),
                a('.theme-switcher input[type="checkbox"][id="sticky-navigation"]').prop("checked", !1)), a("body").hasClass("small-navigation") && (a(".navigation .navigation-menu-body > ul > li").each(function() {
                a(this).find("> a").next("ul").length ? a(this).find(".dropdown-divider").remove() : a(this).find("> a").tooltip("dispose")
            }), a("body").removeClass("small-navigation"), a('.theme-switcher input[type="checkbox"][id="small-navigation"]').prop("checked", !1))), "dark" === e && a("body").hasClass("semi-dark") && (a("body").removeClass("semi-dark"),
            a('.theme-switcher input[type="checkbox"][id="semi-dark"]').prop("checked", !1)), "semi-dark" === e && a("body").hasClass("dark") && (a("body").removeClass("dark"),
            a('.theme-switcher input[type="checkbox"][id="dark"]').prop("checked", !1)), a("body").toggleClass(e)
    }), a(document).on("click", ".theme-switcher .theme-switcher-button", function() {
        a(".theme-switcher").toggleClass("open")
    })
}
(jQuery);