<!DOCTYPE html>
<html lang="en">
<head>
    <title>Registration</title>
</head>
<body>
<form action="/registration" method="post">
    <input type="text" placeholder="Enter username" name="username">
    <br>
    <input type="text" placeholder="Enter full name" name="fullName">
    <br>
    <input type="email" placeholder="Enter email" name="email">
    <br>
    <input type="password" placeholder="Enter password" name="password">
    <br>
    <input type="submit" value="Enter">
</form>
<#if errors??>
    <#list errors as fieldError>
        <p>${fieldError.field}- ${fieldError.defaultMessage!'-- no message --'}</p>
    </#list>
</#if>
</body>
</html>