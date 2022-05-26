<#import "/spring.ftl" as spring>
<div>
    <#if hasPrev>
        <a id="loadPrev" href="${prevPageLink!''}">&lt;&lt;&lt;<@spring.message "body.previousPage" /></a>
    <#else>
        <span id="loadPrev"><@spring.message "body.previousPage" /></span>
    </#if>

    <#if hasNext>
        <a id="loadNext" href="${nextPageLink!''}" data-default-page-size="${defaultPageSize!5}"><@spring.message "body.nextPage" />&gt;&gt;&gt;</a>
    <#else>
        <span><@spring.message "body.nextPage" /></span>
    </#if>
</div>