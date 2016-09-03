/**
 * Created by zhouweitao on 16/9/3.
 */

(function ($) {
    $.fn.address = function (opt) {
        var opts = $.extend({
                url: '../data/Area.xml',
                pn: 'province',
                cin: 'city',
                con: 'country',
                attrName: 'name',
                attrValue: 'value',
                countryChange: function () {
                    console.log(this);
                }
            },opt ||{});

        var target = this;
        opts.prs = $("<select id='province'><option>请选择省份</option></select>");
        opts.cis = $("<select id='city'><option>请选择市区</option></select>");
        opts.cos = $("<select id='country'><option>请选择区县</option></select>");
        $.get(opts.url, function (data) {
            init(data);
        });

        function init(data) {
            // $(data).find(opts.pn).each(function () {
            //     opts.prs.append(createNode(this));
            // });
            setupNode(data, opts.pn, opts.prs);
            opts.prs.change(function () {
                opts.cos.find('option:gt(0)').remove();
                opts.cis.find('option:gt(0)').remove();
                // $(data).find(opts.pn + "[value="+ $(this).attr(opts.attrValue) +"] "+opts.cin).each(function () {
                //     opts.cis.append(createNode(this));
                // });
                setupNode(data, opts.pn + "[value=" + $(this).attr(opts.attrValue) + "] " + opts.cin, opts.cis);
            });
            opts.cis.change(function () {
                opts.cos.find('option:gt(0)').remove();
                setupNode(data, opts.cin + "[value=" + $(this).attr(opts.attrValue) + "] " + opts.con, opts.cos);
            });

            opts.cos.change(opts.countryChange);
            target.append($("<span class='address_c'></span>").append(opts.prs));
            target.append($("<span class='address_c'></span>").append(opts.cis));
            target.append($("<span class='address_c'></span>").append(opts.cos));
        }

        function setupNode(data, path, node) {
            $(data).find(path).each(function () {
                node.append(createNode(this));
            });
        }

        function createNode(obj) {
            return "<option value='" + $(obj).attr(opts.attrValue) + "'>" + $(obj).attr(opts.attrName) + "</option>"
        }

        return this;
    }
})(jQuery);