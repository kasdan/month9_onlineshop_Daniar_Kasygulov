<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <title>Vote for us!</title>
    <link rel="stylesheet" href="/css/clothes.css">
</head>

<body>
    <div class="container flex flex-col align-center">
      <h1>Clothes</h1>
      <main class="flex flex-wrap align-evenly">
        <#list clothes as cloth>
       <#--            <img src="/images/${cloth.photo}.jpg">-->
            <h3>${cloth.itemName}</h3>
            <#list cloth.photos as photo>
                <img src="images/${photo.name}.jpg" style="width: 200px;height: 200px">
            </#list>
            <p>Description: ${cloth.description}</p>
            <p>Price: ${cloth.price}</p>

<#--            <p>${cloth.photos.get(0)}</p>-->
<#--            <input name="clothesId" type="hidden" value="${cloth.id}">-->


        </#list>
      </main>
      <p>-------------------------------------------------------</p>
    </div>
</body>

</html>