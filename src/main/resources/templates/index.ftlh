<#import "/spring.ftl" as spring>
<#import "partials/main.ftlh" as main/>

<@main.renderWith scripts=["/js/search.js"] styles=["/css/index.css"]>
    <input type="text" value="" id="inputName" placeholder="<@spring.message "index.body.search.placeholder"/>">
    <button type="button" id="name"><@spring.message "search"/></button>
    <br>
    <hr>
<#--    <#list sessionAttributes as key, value>-->
<#--        <div class="border"><span class="key-cell">${key}</span>-->
<#--            <span class="value-cell">${value}</span></div>-->
<#--    </#list>-->
    <#import "partials/cardPlacement.ftlh" as c/>
    <@c.card>
        <#list clothes as cloth>
<div class="col-sm-3">
                <div class="card" >
                    <a href="/clothes/${cloth.id}" style="text-decoration: none">
                    <img src="/images/${cloth.photo}.jpg" class="card-img-top">
                    </a>
                    <div class="card-body">
                        <div class="card-title">${cloth.itemName?cap_first} </div>
                        <div class="card-text"><@spring.message "index.price" />: ${cloth.price}</div>
                        <form action="/clothes/${cloth.id}" method="post">
                            <#if _csrf??>
                                <input type="hidden" name="${(_csrf.parameterName)!'csrf'}" value="${(_csrf.token)!'--no-token--'}"/>
                            </#if>
                            <input type="number" name="clothesId" hidden value="${cloth.id}">
                            <input type="number" name="username" hidden value="<#if user??>${user}</#if>">
                            <input type="number" min = 0 placeholder="please enter quantity" name="quantity" value=1>
                            <input type="submit" value="<@spring.message "item.basketAdd" />">
                        </form>
                    </div>
                </div>

</div>
        </#list>
    </@c.card>


    <#include "partials/pagination.ftlh">
</@main.renderWith>
