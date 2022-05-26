<#import "partials/main.ftlh" as main/>

<@main.renderWith styles=["/css/styles.css"] scripts=["/js/search.js"]>
    <input type="text" value="" id="inputName" placeholder="Please enter item name">
    <button type="button" id="name">Search</button>
<#--    <#list sessionAttributes as key, value>-->
<#--        <div class="border"><span class="key-cell">${key}</span>-->
<#--            <span class="value-cell">${value}</span></div>-->
<#--    </#list>-->
    <div class="flex flex-wrap" id="itemList">
            <#list clothes as cloth>
                <div class="flex flex-column box flex-v-center">
                    <a href="/clothes/${cloth.id}"><h3>${cloth.itemName}</h3>
                    <img src="/images/${cloth.photo}.jpg">
                    <p>Description: ${cloth.description}</p>
                    <p>Price: ${cloth.price}</p>
                    </a>
                </div>
            </#list>
    </div>
<#include "partials/pagination.ftlh">
</@main.renderWith>
