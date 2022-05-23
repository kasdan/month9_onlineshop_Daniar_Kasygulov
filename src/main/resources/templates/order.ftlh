<#import "partials/main.ftlh" as main/>
<@main.renderWith styles=["/css/item.css"]>
    <h1>This is order page</h1>
    <#list baskets as basket>
        <div class="flex flex-column box flex-v-center">
            <div class="item">
                <img src="/images/${basket.clothes.photo}.jpg">
            </div>
            <p>Description: ${basket.clothes.itemName}<br>
                Price: ${basket.clothes.price}<br>
                Size:${basket.clothes.size}</p>
            <p> Clothes quantity: ${basket.quantity}</p>
             </div>
        <#list basket.clothes.commentsList as comment>
            <p> ${comment.commentText}: made by ${comment.user.userName}</p>
        </#list>
        <form action="/comments" method="post">
            <#if _csrf??>
                <input type="hidden" name="${(_csrf.parameterName)!'csrf'}" value="${(_csrf.token)!'--no-token--'}"/>
            </#if>
            <input hidden type="number" name="clothes_id" value="${basket.clothes.id}">
            <label for="comments">Please enter comments</label>
            <textarea name="comments">
        </textarea>
            <input type="submit" value="Submit">
        </form>
    </#list>
       <form action="order/buy" method="post">
        <#if _csrf??>
            <input type="hidden" name="${(_csrf.parameterName)!'csrf'}" value="${(_csrf.token)!'--no-token--'}"/>
        </#if>
        <input type="submit" value="Buy">
    </form>
    <form method="post" action="order/delete">
        <#if _csrf??>
            <input type="hidden" name="${(_csrf.parameterName)!'csrf'}" value="${(_csrf.token)!'--no-token--'}"/>
        </#if>
        <input type="submit" value="Delete">
    </form>

</@main.renderWith>