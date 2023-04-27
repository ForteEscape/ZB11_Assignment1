function success(position){
    document.getElementById("LNT").value = position.coords.longitude;
    document.getElementById("LAT").value = position.coords.latitude;
}

function error(){
    console.log("error detected");
}

function getLocation(){
    navigator.geolocation.getCurrentPosition(success, error);
}

function verify(){
    var lat = document.getElementById("LAT").value;
    var lnt = document.getElementById("LNT").value;

    if (lat === "" || lat === null || lnt === "" || lnt === null){
        alert("잘못된 위치 입력입니다. 다시 입력해주세요");
        return;
    }

    document.getElementById("locationForm").submit();
}