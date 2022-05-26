<#import "/spring.ftl" as spring>
<#import "partials/main.ftlh" as main />
<@main.renderWith styles=["/css/index.css"]>
    <h2><@spring.message "login.page.title" /></h2>
    <div>
        <#if error!false >
            <p style="color:red"><@spring.message "login.wrong.username.password" />!</p>
        </#if>
    </div>
    <form action="/login" method="post">
        <#if _csrf??>
            <input type="hidden" name="${(_csrf.parameterName)!'csrf'}" value="${(_csrf.token)!'--no-token--'}"/>
        </#if>

        <input type="text" placeholder='<@spring.message "login.placeholder.username" />' name="username" value="<#if user??>${user.username!''}</#if>">
        <span style="color: red"><#if errorUsername??> ${errorUsername.defaultMessage!'-- no message --'}</#if></span>
        <br>
        <input type="password" placeholder="<@spring.message "login.placeholder.password" />" name="password" value="">
        <span style="color: red"><#if errorPassword??> ${errorPassword.defaultMessage!'-- no message --'}</#if></span>
        <br>
        <input type="submit" value='<@spring.message "enter" />'>
    </form>
    <form action="/register">
        <input type="submit" value='<@spring.message "nav.menu.register"/>'>
    </form>
    <form action="/restore">
        <input type="submit" value="<@spring.message "login.restore" />">
    </form>
</@main.renderWith>