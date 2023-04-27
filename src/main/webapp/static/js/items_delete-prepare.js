function del(idx){
    alert("북마크 정보를 삭제하였습니다.");
    location.href="/bookmark/items/delete?id=" + idx;
}