<#import "/spring.ftl" as spring>
<#import "partials/main.ftlh" as main/>
<@main.renderWith>
    <h2><@spring.message "register.enter.details" /></h2>
<form action="/register" method="post">
    <#if _csrf??>
        <input type="hidden" name="${(_csrf.parameterName)!'csrf'}" value="${(_csrf.token)!'--no-token--'}"/>
    </#if>
    <input type="text" placeholder="<@spring.message "login.placeholder.username" />" name="username">
    <span style="color: red"><#if errorUsername??> ${errorUsername.defaultMessage!'-- no message --'}</#if></span>
    <br>
    <input type="text" placeholder="<@spring.message "register.placeholder.fullName" />" name="fullName">
    <span style="color: red"><#if errorFullName??> ${errorFullName.defaultMessage!'-- no message --'}</#if></span>
    <br>
    <input type="email" placeholder="<@spring.message "register.placeholder.email" />" name="email">
    <span style="color: red"><#if errorEmail??> ${errorEmail.defaultMessage!'-- no message --'}</#if></span>
    <br>
    <input type="password" placeholder="<@spring.message "login.placeholder.password" />" name="password">
    <span style="color: red"><#if errorPassword??> ${errorPassword.defaultMessage!'-- no message --'}</#if></span>
    <br>
    <#if capcha??> Capcha: ${capcha}</#if>
    <br>
    <input type="text" placeholder="<@spring.message "captcha.placeholder" />" name="capcha">
    <span style="color: red"><#if errorCapcha??> ${errorCapcha!'-- no message --'}</#if></span>
    <br>
    <input type="submit" value="<@spring.message "enter" />">

</form>
</@main.renderWith>