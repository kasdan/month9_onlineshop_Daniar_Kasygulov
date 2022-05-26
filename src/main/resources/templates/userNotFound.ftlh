<#import "/spring.ftl" as spring>
<#import "partials/main.ftlh" as main/>
<@main.renderWith styles=["/css/index.css"]>
    <h2><@spring.message "UserNotFoundException" /></h2>
    <a href="/logout"><@spring.message "nav.menu.login" /></a>
</@main.renderWith>