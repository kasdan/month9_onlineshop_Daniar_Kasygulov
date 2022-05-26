<#import "/spring.ftl" as spring>
<#import "partials/main.ftlh" as main/>

<@main.renderWith styles=["/css/item.css","/css/index.css"]>

    <h3>${cloth.itemName}</h3>
                <div class="item">
                    <img src="/images/${cloth.photo}.jpg">
                </div>
    <p>Description: ${cloth.description}<br>
        Price: ${cloth.price}<br>
        Size:${cloth.size}</p>
    <form action="/clothes/${cloth.id}" method="post">
        <#if _csrf??>
            <input type="hidden" name="${(_csrf.parameterName)!'csrf'}" value="${(_csrf.token)!'--no-token--'}"/>
        </#if>
        <input type="number" name="clothesId" hidden value="${cloth.id}">
        <input type="number" name="username" hidden value="<#if user??>${user}</#if>">
        <input type="number" min = 0 placeholder="<@spring.message "item.basketAdd" />" name="quantity" value=1>
        <input type="submit" value="<@spring.message "item.basketAdd" />">
    </form>
</@main.renderWith>
