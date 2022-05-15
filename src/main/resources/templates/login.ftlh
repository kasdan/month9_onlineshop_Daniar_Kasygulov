<!DOCTYPE html>
<html lang="en">

<head>
    <title>Login page</title>
</head>

<body>
<h2>Please login into Kids' store.</h2>
<div>
    <#if error!false >
        <p style="color:red">Неверные имя пользователя или пароль !</p>
    </#if>
</div>
<form action="/login" method="post">
    <#if _csrf??>
        <input type="hidden" name="${(_csrf.parameterName)!'csrf'}" value="${(_csrf.token)!'--no-token--'}"/>
    </#if>

    <input type="text" placeholder="Enter username" name="username" value="<#if user??>${user.username!''}</#if>">
    <span style="color: red"><#if errorUsername??> ${errorUsername.defaultMessage!'-- no message --'}</#if></span>
    <br>
    <input type="password" placeholder="Enter password" name="password" value="">
    <span style="color: red"><#if errorPassword??> ${errorPassword.defaultMessage!'-- no message --'}</#if></span>
    <br>
    <input type="submit" value="Enter">
</form>
<form action="/register">
<input type="submit" value="Register" >
</form>

<#--<#if errors??>-->
<#--    <#list errors as fieldError>-->
<#--        <p>${fieldError.field}- ${fieldError.defaultMessage!'-- no message --'}</p>-->
<#--    </#list>-->
<#--</#if>-->
</body>

</html>