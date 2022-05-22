<#import "partials/main.ftlh" as main/>

<@main.renderWith styles=["/css/styles.css"]>
 <h1>Please restore password</h1>
 <form action="/restore" method="post">
  <#if _csrf??>
   <input type="hidden" name="${(_csrf.parameterName)!'csrf'}" value="${(_csrf.token)!'--no-token--'}"/>
  </#if>
  <input type="email" placeholder="Enter email" name="email" id="email" />
  <input type="submit" value="Restore"/>
 </form>

 <#if uniqueLink??><a href="/restore/${uniqueLink}"> Go to the link</a></#if>

</@main.renderWith>
