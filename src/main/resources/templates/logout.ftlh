<#import "partials/main.ftlh" as main/>

<@main.renderWith>
    <form class="flex box-128" action="/logout" method="post">
        <#if _csrf??>
            <input type="hidden" name="${(_csrf.parameterName)!'csrf'}" value="${(_csrf.token)!'--no-token--'}"/>
        </#if>
        <button class="flex box-128 logout-button">Logout</button>
    </form>
<div class="bottom-box">
    <a href="/">to the main page</a>
</div>
</@main.renderWith>