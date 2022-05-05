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
        <div class="card">
          <form action="/vote" method="post" class="flex flex-col align-center">
            <img src="/images/${clothes.photo}">
            <p>${clothes.name}</p>
            <input name="clothesId" type="hidden" value="${clothes.id}">
            <button type="submit" class="vote flex align-center">Vote</button>
          </form>
        </div>
        </#list>
      </main>
      <p>-------------------------------------------------------</p>
      <a class="back flex align-center" href="/votes">Show total votes</a>
    </div>
</body>

</html>