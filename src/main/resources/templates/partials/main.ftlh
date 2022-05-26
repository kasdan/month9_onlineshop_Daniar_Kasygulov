<#--
 объявляем макро-функцию используя которую мы создадим шаблон страницы
 https://freemarker.apache.org/docs/dgui_misc_userdefdir.html
 -->

<#macro renderWith scripts=[] styles=[]>
    <#import "/spring.ftl" as spring>
    <!doctype html>
    <html lang="${.locale}">
    <head>
        <meta charset="UTF-8">
        <meta name="viewport"
              content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
        <meta http-equiv="X-UA-Compatible" content="ie=edge">
        <title><@spring.message "title" /></title>
        <script type="text/javascript" src="http://code.jquery.com/jquery-1.11.0.min.js"></script>
        <script type="text/javascript">
        </script>
        <#--        <link rel="stylesheet" href="/css/styles.css">-->
        <!-- CSS only -->
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0-beta1/dist/css/bootstrap.min.css" rel="stylesheet"
              integrity="sha384-0evHe/X+R7YkIZDRvuzKMRqM+OrBnVFBL6DOitfPri4tjfHxaWutUpFmBp4vmVor"
              crossorigin="anonymous">
        <#list styles as styleSource>
            <link rel="stylesheet" href="${styleSource}">
        </#list>
    </head>
    <body>
    <div class="container">
        <nav class="navbar navbar-light bg-light" >
            <a href="/"><h1><@spring.message "title"/></h1></a>
            <a href="/advancedSearch"><@spring.message "nav.menu.advancedSearch"/></a>
            <#if user??>
                <div id="login" style="display: none"><a href="/login"> <@spring.message "nav.menu.login" /></a></div>
            <#else>
                    <div id="login" ><a href="/login"> <@spring.message "nav.menu.login" /></a></div>
            </#if>
            <#if user??>
                <div id="logout" ><a href="/logout"> <@spring.message "nav.menu.logout" /></a></div>
            <#else>
                <div id="logout" ><a href="/logout" style="display: none"> <@spring.message "nav.menu.logout" /></a></div>
            </#if>

            <#if user??>
                <div id="register"><a href="/register" style="display: none"><@spring.message "nav.menu.register"/></a></div>
            <#else>
                <div id="register" ><a href="/register"><@spring.message "nav.menu.register"/></a></div>
            </#if>
            <div id="basket"><a href="/basket"> <@spring.message "nav.menu.basket"/> </a></div>
            <div id="profile"><#if user??><@spring.message "nav.menu.welcome"/> <a href="/profile">${user}</a> </#if>
            </div>
            <form action="" method="get">
                <label for="lang_select"><@spring.message "label.language" /></label>
                <select name="lang" id="lang_select">
                    <option value="en">Default</option>
                    <option value="" disabled>-------------</option>
                    <option value="en-US">American English</option>
                    <option value="ru-RU">Русский</option>
                </select>
                <button type="submit">
                    <@spring.message "button.language-change.text" />
                </button>
            </form>
        </nav>

        <#--
         элемент nested указывает что в этом место
         будет подставлено некоторое содержимое,
         которое передаётся как тело макро-функции при её вызове
        -->
        <#nested>

    </div>

    <#list scripts as scriptSource>
        <script src="${scriptSource}"></script>
    </#list>

    </body>
    </html>
</#macro>