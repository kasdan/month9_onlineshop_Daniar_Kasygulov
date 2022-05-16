<#import "partials/main.ftlh" as main/>

<@main.renderWith styles=["css/styles.css"]>

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

    <div>
        <#if hasPrev>
            <a id="loadPrev" href="${prevPageLink!''}">&lt;&lt;&lt;Previous page</a>
        <#else>
            <span id="loadPrev">Previous page</span>
        </#if>

        <#if hasNext>
            <a id="loadNext" href="${nextPageLink!''}" data-default-page-size="${defaultPageSize!5}">Next page&gt;&gt;&gt;</a>
        <#else>
            <span>Next page</span>
        </#if>
    </div>
</@main.renderWith>
