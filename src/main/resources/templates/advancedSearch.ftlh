<#import "partials/main.ftlh" as main/>

<@main.renderWith scripts=["/js/advancedSearch.js"] styles=["/css/styles.css"]>

    <h1>Advanced search</h1>

        <h4>Please enter the price range</h4>
        <input type="number" id="min" value=0> - <input type="number" id="max"  value=0>
        <button type="button" id="price">Submit</button>

    <h4>Please enter the name of item.</h4>
    <input type="text" value="" id="inputName" placeholder="Please enter item name">
    <button type="button" id="name">Submit</button>
    <h4>Please enter the description of item.</h4>
    <input type="text" value="" id="inputDescription" placeholder="Please enter item description">
    <button type="button" id="description">Submit</button>
    <h4>Please enter the size</h4>
    <input type="text" value="" id="inputSize" placeholder="Please enter item size">
    <button type="button" id="size">Submit</button>
    <span style="color: red"><#if noInfo??>${noInfo!''}</#if></span>
    <div class="flex flex-wrap" id="itemList">
        <#if clothes??>
            <#list clothes as cloth>
                <div class="flex flex-column box flex-v-center">
                    <h3>${cloth.itemName}</h3>
                    <a href="/clothes/${cloth.id}">
                        <img src="/images/${cloth.photo}.jpg">
                    <p>Description: ${cloth.description} <br>
                        Size: ${cloth.size} <br>
                        Price: ${cloth.price}
                    </p>
                        </a>
                </div>
            </#list>
        </#if>
    </div>

    <div>
        <#if hasPrev??>
            <a id="loadPrev" href="${prevPageLink!''}">&lt;&lt;&lt;Previous page</a>
        <#else>
            <span id="loadPrev">Previous page</span>
        </#if>

        <#if hasNext??>
            <a id="loadNext" href="${nextPageLink!''}" data-default-page-size="${defaultPageSize!5}">Next page&gt;&gt;&gt;</a>
        <#else>
            <span>Next page</span>
        </#if>
    </div>
</@main.renderWith>
