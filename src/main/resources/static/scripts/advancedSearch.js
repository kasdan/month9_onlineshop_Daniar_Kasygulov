const link = window.location.origin;
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
            window.location.replace(link+"/advancedSearch/price/" + "p"+data.min+"and"+data.max);
        }else {
             window.location.replace(link+"/advancedSearch");
        }
    });
});
$(document).ready(function(){
    $('#name').click(function(e) {
        var inputvalue = $("#inputName").val();
        if(inputvalue!=="") {

            window.location.replace(link+"/advancedSearch/name/" + inputvalue);
        }else {
            window.location.replace(link+"/advancedSearch");
        }
    });
});
$(document).ready(function(){
    $('#description').click(function(e) {
        var inputvalue = $("#inputDescription").val();
        if(inputvalue!=="") {
            console.log(inputvalue);
            window.location.replace(link+"/advancedSearch/description/" + inputvalue);
        }else {
            window.location.replace(link+"/advancedSearch");
        }
    });
}); $(document).ready(function(){
    $('#size').click(function(e) {
        var inputvalue = $("#inputSize").val();
        if(inputvalue!=="") {
            console.log(inputvalue);
            window.location.replace(link+"/advancedSearch/size/" + inputvalue);
        }else {
            window.location.replace(link+"/advancedSearch");
        }
    });
});