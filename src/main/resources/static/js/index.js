

$(function () {
    // 4. 导航处理
    var allLis = $("#wd_nav li");

    $(allLis[1]).on("click", function () {
        $("html,body").animate({ scrollTop: $("#wd_hot").offset().top }, 1000);
     });

    $(allLis[2]).on("click", function () {
        $("html,body").animate({ scrollTop: $("#wd_cf").offset().top }, 1000);
    });
});
