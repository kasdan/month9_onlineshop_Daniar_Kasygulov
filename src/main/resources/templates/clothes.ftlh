<#import "partials/main.ftlh" as main/>

<@main.renderWith>
    <h1>Clothes</h1>
    <div class="flex flex-wrap" id="itemList">
        <#list clothes as cloth>
            <div class="flex flex-column box flex-v-center">
                <h3>${cloth.itemName}</h3>
                <img src="/images/${cloth.photos[0].name}.jpg">
                <p>Description: ${cloth.description}</p>
                <p>Price: ${cloth.price}</p>
            </div>
        </#list>

    </div>
</@main.renderWith>
