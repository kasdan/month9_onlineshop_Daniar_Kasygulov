<#import "/spring.ftl" as spring>
<#import "partials/main.ftlh" as main/>

<@main.renderWith scripts=["/js/advancedSearch.js"] styles=["/css/styles.css"]>

    <h1><@spring.message "nav.menu.advancedSearch" /></h1>

        <h4<@spring.message "advanced.price.range" /></h4>
        <input type="number" id="min" value=0> - <input type="number" id="max"  value=0>
        <button type="button" id="price"><@spring.message "submit" /></button>

    <h4><@spring.message "advanced.name" /></h4>
    <input type="text" value="" id="inputName" placeholder="<@spring.message "advanced.name" />">
    <button type="button" id="name"><@spring.message "submit" /></button>
    <h4><@spring.message "advanced.description" /></h4>
    <input type="text" value="" id="inputDescription" placeholder="<@spring.message "advanced.description" />">
    <button type="button" id="description"><@spring.message "submit" /></button>
    <h4><@spring.message "advanced.size" /></h4>
    <input type="text" value="" id="inputSize" placeholder="<@spring.message "advanced.size" />">
    <button type="button" id="size"><@spring.message "submit" /></button>
    <span style="color: red"><#if noInfo??>${noInfo!''}</#if></span>
    <div class="flex flex-wrap" id="itemList">
        <#if clothes??>
            <#list clothes as cloth>
                <div class="flex flex-column box flex-v-center">
                    <h3>${cloth.itemName}</h3>
                    <a href="/clothes/${cloth.id}">
                        <img src="/images/${cloth.photo}.jpg">
                    <p><@spring.message "description" />: ${cloth.description} <br>
                        <@spring.message "size" />: ${cloth.size} <br>
                        <@spring.message "price" />: ${cloth.price}
                    </p>
                        </a>
                </div>
            </#list>
        </#if>
    </div>
    <#include "partials/pagination.ftlh">
</@main.renderWith>
