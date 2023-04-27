function verify(){
    var bookmarkName = document.getElementById("bookmarkName").value;
    var seqNo = document.getElementById("seqNo").value;

    if (bookmarkName === "" || bookmarkName === null || seqNo === "" || seqNo === null){
        alert("잘못된 입력입니다. 다시 입력해주세요");
        return;
    }
    document.getElementById("modifyForm").submit();
}