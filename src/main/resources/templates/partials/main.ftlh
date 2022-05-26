<#--
 объявляем макро-функцию используя которую мы создадим шаблон страницы
 https://freemarker.apache.org/docs/dgui_misc_userdefdir.html
 -->
<#macro renderWith title="Kids clothes" scripts=[] styles=[]>
    <!doctype html>
    <html lang="en">
    <head>
        <meta charset="UTF-8">
        <meta name="viewport"
              content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
        <meta http-equiv="X-UA-Compatible" content="ie=edge">

        <title>${title}</title>
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
    <nav class="navbar navbar-light bg-light">
        <a href="/"><h1>Clothes for kids</h1></a>
        <a href="/advancedSearch">Advanced search</a>
        <div id="<#if login??>${login!''}</#if>"><a href="/login">Login</a></div>
        <div id="logout"><a href="/logout">Logout</a></div>
        <div id="homepage"><a href="/">Home page</a></div>
        <div id="basket"><a href="/basket"> Basket </a></div>
        <div id="profile"><#if user??>Welcome: <a href="/profile">${user}</a> </#if> </div>
    </nav>
    <div class="container">
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