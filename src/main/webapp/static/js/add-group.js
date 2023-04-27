function verify(){
    var bookmarkName = document.getElementById("bookmarkName").value;
    var seqNo = document.getElementById("seqNo").value;

    if (bookmarkName === "" || bookmarkName === null || seqNo === "" || seqNo === null){
        alert("잘못된 형식입니다. 다시 입력해주세요");
        return;
    }

    alert("북마크 그룹 정보를 추가하였습니다.");

    document.getElementById("groupDeleteForm").submit();
}