<#import "/spring.ftl" as spring>
<#import "partials/main.ftlh" as main/>
<@main.renderWith styles=["/css/index.css"]>
    <h2><@spring.message "UserAlreadyExistsException" /></h2>
    <a href="/register"><@spring.message "nav.menu.register" /></a>
</@main.renderWith>