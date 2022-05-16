<#import "partials/main.ftlh" as main/>

<@main.renderWith styles=["/css/item.css"]>

                <div class="item">
                    <h3>${cloth.itemName}</h3>
                    <img src="/images/${cloth.photo}.jpg">
                    <p>Description: ${cloth.description}<br>
                     Price: ${cloth.price}<br>
                     Size:${cloth.size}</p>
                </div>
    <form action="/addtobasket" method="post">
        <#if _csrf??>
            <input type="hidden" name="${(_csrf.parameterName)!'csrf'}" value="${(_csrf.token)!'--no-token--'}"/>
        </#if>
        <input type="submit" value="Add to basket">
    </form>
</@main.renderWith>
