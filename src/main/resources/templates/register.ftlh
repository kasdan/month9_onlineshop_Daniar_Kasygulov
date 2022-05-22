<#import "partials/main.ftlh" as main/>
<@main.renderWith>
<form action="/register" method="post">
    <#if _csrf??>
        <input type="hidden" name="${(_csrf.parameterName)!'csrf'}" value="${(_csrf.token)!'--no-token--'}"/>
    </#if>
    <input type="text" placeholder="Enter username" name="username">
    <span style="color: red"><#if errorUsername??> ${errorUsername.defaultMessage!'-- no message --'}</#if></span>
    <br>
    <input type="text" placeholder="Enter full name" name="fullName">
    <span style="color: red"><#if errorFullName??> ${errorFullName.defaultMessage!'-- no message --'}</#if></span>
    <br>
    <input type="email" placeholder="Enter email" name="email">
    <span style="color: red"><#if errorEmail??> ${errorEmail.defaultMessage!'-- no message --'}</#if></span>
    <br>
    <input type="password" placeholder="Enter password" name="password">
    <span style="color: red"><#if errorPassword??> ${errorPassword.defaultMessage!'-- no message --'}</#if></span>
    <br>
    <#if capcha??> Capcha: ${capcha}</#if>
    <br>
    <input type="text" placeholder="input capcha" name="capcha">
    <span style="color: red"><#if errorCapcha??> ${errorCapcha!'-- no message --'}</#if></span>
    <br>
    <input type="submit" value="Enter">

</form>
</@main.renderWith>