<#import "partials/main.ftlh" as main/>
<@main.renderWith>
<h2>Please login into Kids' store.</h2>
<div>
    <#if error!false >
        <p style="color:red">Wrong username or password!</p>
    </#if>
</div>
<form action="/login" method="post">
    <#if _csrf??>
        <input type="hidden" name="${(_csrf.parameterName)!'csrf'}" value="${(_csrf.token)!'--no-token--'}"/>
    </#if>
    <p>Temp password for user: ${username} is ${password}</p>

    <input type="text" placeholder="Enter username" name="username" value="<#if user??>${user.username!''}</#if>">
    <span style="color: red"><#if errorUsername??> ${errorUsername.defaultMessage!'-- no message --'}</#if></span>
    <br>
    <input type="password" placeholder="Enter password" name="password" value="">
    <span style="color: red"><#if errorPassword??> ${errorPassword.defaultMessage!'-- no message --'}</#if></span>
    <br>
    <input type="submit" value="Enter">
</form>
</@main.renderWith>