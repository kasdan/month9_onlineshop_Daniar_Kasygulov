<#import "partials/main.ftlh" as main/>
<@main.renderWith>
<p>${user.username}</p>
<p>${user.fullName}</p>
<p>${user.email}</p>
</@main.renderWith>