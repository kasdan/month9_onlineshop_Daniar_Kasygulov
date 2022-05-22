<#import "partials/main.ftlh" as main/>
<@main.renderWith styles=["/css/item.css"]>
    <h1>This is a basket</h1>
    <#list baskets as basket>
        <div class="flex flex-column box flex-v-center">
            <div class="item">
                <img src="/images/${basket.clothes.photo}.jpg">
            </div>
            <p>Description: ${basket.clothes.itemName}<br>
                Price: ${basket.clothes.price}<br>
                Size:${basket.clothes.size}</p>
            <p> Clothes quantity: ${basket.quantity}</p>
            <form action="/basket" method="get">
                <input hidden type="number" value="${basket.id}" name="basketId">
                <input type="submit" value="Delete">
            </form>
            <form action="/basket" method="get">
                <input type="number" value="${basket.quantity}" name="quantity">
                <input hidden type="number" value="${basket.id}" name="basketId">
                <input type="submit" value="Change">
            </form>
        </div>

    </#list>
</@main.renderWith>
