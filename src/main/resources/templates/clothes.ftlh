<#import "partials/main.ftlh" as main/>

<@main.renderWith styles=["/css/item.css"]>

                <div class="item">
                    <h3>${cloth.itemName}</h3>
                    <img src="/images/${cloth.photo}.jpg">
                    <p>Description: ${cloth.description}<br>
                     Price: ${cloth.price}<br>
                     Size:${cloth.size}</p>
                </div>
</@main.renderWith>
