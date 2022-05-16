$(document).ready(function(){
    $('#price').click(function(e) {
        var inputvalueMin = $("#min").val();
        var inputvalueMax = $("#max").val();
        let data =
            {
                "min":inputvalueMin,
                "max":inputvalueMax
            }
        if(inputvalueMin!==0 && inputvalueMax!==0) {
            fetch("http://localhost:8080/advancedSearch", {
                method: 'post',
                cache: 'no-cache',
                headers: {
                    'Content-Type': 'application/json'
                },
                body: JSON.stringify(data)
            }).then(
                fetch("http://localhost:8080/advancedSearch")
            );

        }else {
            // window.location.replace("http://localhost:8080/advancedSearch");
        }
    });
});
$(document).ready(function(){
    $('#name').click(function(e) {
        var inputvalue = $("#inputName").val();
        if(inputvalue!=="") {
            console.log(inputvalue);
            window.location.replace("http://localhost:8080/name/" + inputvalue);
        }else {
            window.location.replace("http://localhost:8080/advancedSearch");
        }
    });
});
$(document).ready(function(){
    $('#description').click(function(e) {
        var inputvalue = $("#inputDescription").val();
        if(inputvalue!=="") {
            console.log(inputvalue);
            window.location.replace("http://localhost:8080/description/" + inputvalue);
        }else {
            window.location.replace("http://localhost:8080/advancedSearch");
        }
    });
}); $(document).ready(function(){
    $('#size').click(function(e) {
        var inputvalue = $("#inputSize").val();
        if(inputvalue!=="") {
            console.log(inputvalue);
            window.location.replace("http://localhost:8080/size/" + inputvalue);
        }else {
            window.location.replace("http://localhost:8080/advancedSearch");
        }
    });
});