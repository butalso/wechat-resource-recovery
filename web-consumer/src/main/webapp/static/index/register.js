$(function() {
  $("#registerBtn").click(function() {
    register();
  });

});

function register() {
  var registerData = {};

  var t = $("#registerForm").serializeArray();
  $.each(t, function() {
    registerData[this.name] = this.value;
  });

  console.log(registerData);

  if (registerData.password == registerData.confirmPassword) {
    // $.ajax({
    //   type: 'post',
    //   url: "http://localhost:8080/web-consumer/login",
    //   dataType: 'json',
    //   data: loginData,
    //   complete: function(XMLHttpRequest, textStatus) {},
    //   success: function(data) {
    //     console.log(data);
    //   },
    //   error: function(err) {
    //     console.log(err);
    //   }
    // });
  } else {
    console.log();
  };

}
