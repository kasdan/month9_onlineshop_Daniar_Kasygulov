<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.5.0/font/bootstrap-icons.css">
    <link rel="stylesheet" href="css/styles.css">
    <title>Kids' clothes shop</title>
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

            <p>-------------------------------------------------------</p>
        </#list>
      </main>

    </div>
</body>

</html>