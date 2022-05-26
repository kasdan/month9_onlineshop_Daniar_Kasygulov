<#import "/spring.ftl" as spring>
<#import "partials/main.ftlh" as main/>
<@main.renderWith styles=["/css/item.css"]>
    <h1><@spring.message "basket.thisIs" /></h1>
<#--    <#list sessionAttributes as key, value>-->
<#--        <div class="border"><span class="key-cell">${key}</span>-->
<#--            <span class="value-cell">${value}</span></div>-->
<#--    </#list>-->
    <#list baskets as basket>
        <div class="flex flex-column box flex-v-center">
            <div class="item">
                <img src="/images/${basket.clothes.photo}.jpg">
            </div>
            <p><@spring.message "description" />: ${basket.clothes.itemName}<br>
                <@spring.message "price" />: ${basket.clothes.price}<br>
                <@spring.message "size" />:${basket.clothes.size}</p>
            <p><@spring.message "basket.quantity" />: ${basket.quantity}</p>
            <form action="/basket" method="get">
                <input hidden type="number" value="${basket.id}" name="basketId">
                <input type="submit" value="<@spring.message "delete" />">
            </form>
            <form action="/basket" method="get">
                <input type="number" value="${basket.quantity}" name="quantity">
                <input hidden type="number" value="${basket.id}" name="basketId">
                <input type="submit" value="<@spring.message "change" />">
            </form>
        </div>
    </#list>
    <form action="/order" method="post">
        <#if _csrf??>
            <input type="hidden" name="${(_csrf.parameterName)!'csrf'}" value="${(_csrf.token)!'--no-token--'}"/>
        </#if>
        <input type="submit" value="<@spring.message "order" />">
    </form>
</@main.renderWith>
