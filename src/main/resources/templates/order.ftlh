<#import "partials/main.ftlh" as main/>
<@main.renderWith styles=["/css/item.css"]>
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
    </#list>
    <form>
        <input type="submit" value="Buy">
    </form>

</@main.renderWith>