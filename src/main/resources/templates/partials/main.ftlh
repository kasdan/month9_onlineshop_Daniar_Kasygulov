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
            $(document).ready(function(){
                $('#name').click(function(e) {
                    var inputvalue = $("#inputName").val();
                    if(inputvalue!=="") {
                        console.log(inputvalue);
                        window.location.replace("http://localhost:8080/name/" + inputvalue);
                    }else {
                        window.location.replace("http://localhost:8080");
                    }
                });
            });
            $(document).ready(function(){
                $('#description').click(function(e) {
                    var inputvalue = $("#inputDescription").val();
                    if(inputvalue!=="") {
                        console.log(inputvalue);
                        window.location.replace("http://localhost:8080/description/" + inputvalue);
                    }else {
                        window.location.replace("http://localhost:8080");
                    }
                });
            }); $(document).ready(function(){
                $('#size').click(function(e) {
                    var inputvalue = $("#inputSize").val();
                    if(inputvalue!=="") {
                        console.log(inputvalue);
                        window.location.replace("http://localhost:8080/size/" + inputvalue);
                    }else {
                        window.location.replace("http://localhost:8080");
                    }
                });
            });
        </script>
        <link rel="stylesheet" href="/css/styles.css">
        <#list styles as styleSource>
            <link rel="stylesheet" href="${styleSource}">
        </#list>
    </head>
    <body>

    <#--
    например если бы у нашего сайта было какое-то верхнее меню,
    то мы могли бы его тут указать
    и оно появится сразу на всех страницах которые используют
    этот шаблон
    -->

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