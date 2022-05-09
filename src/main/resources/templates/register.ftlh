<!DOCTYPE html>
<html lang="en">
<head>
    <title>Registration</title>
</head>
<body>
<form action="/registration" method="post">
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
    <input type="submit" value="Enter">
</form>
<#--<#if errors??>-->
<#--    <#list errors as fieldError>-->
<#--        <p>${fieldError.field}- ${fieldError.defaultMessage!'-- no message --'}</p>-->
<#--    </#list>-->
<#--</#if>-->
</body>
</html>