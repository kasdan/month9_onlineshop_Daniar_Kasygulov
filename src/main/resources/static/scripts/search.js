
$(document).ready(function(){
    $('#name').click(function(e) {
        let inputValue = $("#inputName").val();
        const link = window.location.origin;
        if(inputValue!=="") {
            window.location.replace(link +"/name/" + inputValue);
        }else {
            window.location.replace(link);
        }
    });
});
