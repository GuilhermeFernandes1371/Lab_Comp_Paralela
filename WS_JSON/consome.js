var url = "http://localhost/PHP/aula07/getAll.php";

var httpRequest = new XMLHttpRequest();
httpRequest.open("GET", url);
httpRequest.responseType = "json";
httpRequest.addEventListener("readystatechange", function () {
  if (httpRequest.readyState == 4){
    if (httpRequest.status == 200){
      console.log(httpRequest.response);
      //console.log(httpRequest.response.registros);
      console.log(httpRequest.response.registros[0].id);
      console.log(httpRequest.response.registros[0].nome);

      
     
    } else {
    
    }
  }
});

httpRequest.send();