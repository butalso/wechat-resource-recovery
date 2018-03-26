var HOST = "http://localhost:8080/web-consumer/address/linkage";
$(function () {
    var prov;
    var city;
    init();
    $("select[name='province']").change(function () {
       prov=$(this).val();
       $.get(HOST,{"province":prov},function (data,status) {
           if(status=="success"){
               var result="<option>选择城市</option>";
               $.each(data,function (n,value) {
                   result+="<option value='"+value+"'>"+value+"</option>"
               });
              $("select[name='city']").html("");
              $("select[name='city']").append(result);

           }
           else {
               console.log(data)
           }
       },"json")
   })
    $("select[name='city']").change(function () {
        city=$(this).val();
        $.get(HOST,{"city":city},function (data,status) {
            if(status=="success"){
                var result="<option>选择区域</option>";
                $.each(data,function (n,value) {
                    result+="<option value='"+value+"'>"+value+"</option>"
                });
                $("select[name='area']").html("");
                $("select[name='area']").append(result);
            }
            else {
                console.log(data)
            }
        },"json")
    })
});
function init() {
    $.ajax({
        type: "GET",
        url: HOST,
        dataType: "json",
        complete: function(XMLHttpRequest,textStatus){

        } ,
        success: function(data){
            var result="<option>选择省份</option>";
            $.each(data,function (index,value) {
                result+="<option value='"+value+"'>"+value+"</option>";
            });
            $("select[name='province']").html("");
            $("select[name='province']").append(result);
        },
        error: function(error){
            console.log(error);
        }
    })
}
