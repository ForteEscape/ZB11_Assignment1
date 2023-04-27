function verify(){
    var selectOption = document.getElementById("bookmark");
    var selectOptionValue = selectOption.options[selectOption.selectedIndex].value;

    if(selectOptionValue === "None"){
        alert("북마크를 선택해야 추가할 수 있습니다.");
        return;
    }

    document.getElementById("bookmarkItemForm").submit();
}