<!DOCTYPE html>
<html lang="en">

<head>
    <title>Login page</title>
</head>

<body>
<h2>Please login into Kids' store.</h2>
<form action="/login" method="post">
    <input type="text" placeholder="Enter username" name="username" value="<#if form??>${form.username!''}</#if>">
    <span style="color: red"><#if errorUsername??> ${errorUsername.defaultMessage!'-- no message --'}</#if></span>
    <br>
    <input type="password" placeholder="Enter password" name="password" value="<#if form??>${form.password!''}</#if>">
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