<#import "partials/main.ftlh" as main/>

<@main.renderWith>
    <h1>Advanced search</h1>
    <div name="price_range">
        <h4>Please enter the price range</h4>
        <form id="price_range">
        <input type="number" id="min" min = "50" max="400" value=""> - <input type="number" id="max" min = "450" max="6000" value="">
        <input type="button" value="Submit">
        </form>
    </div>
    <h4>Please enter the name of item.</h4>
    <input type="text" value="" id="input" placeholder="Please enter item name">
    <button type="button" id="button">Submit</button>
    <span style="color: red"><#if noInfo??>${noInfo!''}</#if></span>
    <div class="flex flex-wrap" id="itemList">
        <#if clothes??>
            <#list clothes as cloth>
                <div class="flex flex-column box flex-v-center">
                    <h3>${cloth.itemName}</h3>
                    <img src="/images/${cloth.photo}.jpg">
                    <p>Description: ${cloth.description}</p>
                    <p>Price: ${cloth.price}</p>
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
