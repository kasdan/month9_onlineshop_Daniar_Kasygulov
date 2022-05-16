<#import "partials/main.ftlh" as main/>

<@main.renderWith styles=["css/index.css"]>

                <div class="flex flex-column box flex-v-center">
                    <h3>${cloth.itemName}</h3>
                    <img src="/images/${cloth.photo}.jpg">
                    <p>Description: ${cloth.description}
                     Price: ${cloth.price}
                     Size:${cloth.size}</p>
                </div>
</@main.renderWith>
