<#import "/spring.ftl" as spring>
<#import "partials/main.ftlh" as main/>
<@main.renderWith styles=["/css/styles.css"]>
 <h1><@spring.message "restore.title" /></h1>
 <form action="/restore" method="post">
  <#if _csrf??>
   <input type="hidden" name="${(_csrf.parameterName)!'csrf'}" value="${(_csrf.token)!'--no-token--'}"/>
  </#if>
  <input type="email" placeholder="<@spring.message "register.placeholder.email" />" name="email" id="email" />
  <input type="submit" value="<@spring.message "restore" />"/>
 </form>

 <#if uniqueLink??><a href="/restore/${uniqueLink}"><@spring.message "restore.goToLink" /></a></#if>

</@main.renderWith>
