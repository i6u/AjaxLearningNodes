# AjaxLearningNodes （Ajax学习笔记）
> - [Ajax学习网站](http://www.runoob.com/ajax/ajax-tutorial.html)
- [Ajax中的同步和异步](http://www.cnmiss.cn/?p=84)
- [Ajax代码思路](http://www.cnblogs.com/venoral/p/5136508.html)
- [你真的会使用XMLHttpRequest吗](https://segmentfault.com/a/1190000004322487)

1. JavaScript处理Ajax的4个基本步骤
    - XMLHttpRequest的创建(不同浏览器创建XHR的区别)
    - open('get/post','url','true/false')参数的设置!(get/post请求的区别,参数的设置;true/false异步同步问题深究)
    - send(null/post参数);发送请求
    - onreadystatechange设置回调函数;回调函数设置在不同位置,有什么区别;readyState/status状态;
    - 响应数据的格式,设置响应数据注意的问题
    - Http header的设置;Http头是什么,http头的作用
    - 扩展:深入了解XMLHttpRequest对象;get、post区别;onreadystatechange深究
2. JQuery中的Ajax
    * load
    * get
    * post
    * getJSON、getScript
    * ajax
    * jQuery.ajaxSetup
    * 全局事件处理:ajaxComplete()、ajaxError()、ajaxSend()、ajaxStart()、ajaxStop()、ajaxSuccess()
    * 辅助函数serialize、serializeArray、jQuery.param
    