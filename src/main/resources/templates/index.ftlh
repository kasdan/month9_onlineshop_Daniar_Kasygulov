<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <title>Login page</title>
</head>

<body>
<form action="/login">
    <input type="text" placeholder="Enter username" name="username">
    <input type="password" placeholder="Enter password" name="password">
    <input type="submit" value="Enter">
</form>
<input type="button" value="Register">


<#--<p>${user.userName} has ${user.email}% of all votes</p>-->
<#--    <div class="container flex flex-col align-center">-->
<#--      <h1>Who's winning?</h1>-->
<#--      <main class="flex flex-wrap align-center">-->
<#--      <#list candidates as person>-->
<#--        <div class="card <#if person?is_first && person.votes != 0>winner</#if>">-->
<#--          <div class="flex flex-col align-center">-->
<#--            <img src="/images/${person.photo}">-->
<#--            <p>${person.name} has ${person.votes}% of all votes</p>-->
<#--          </div>-->
<#--        </div>-->
<#--      </#list>-->
<#--      <a class="back flex align-center" href="/">back to main</a>-->
<#--      </main>-->
<#--    </div>-->
</body>

</html>