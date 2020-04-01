
// const token = $("meta[name='_csrf']").attr("content");
// const header = $("meta[name='_csrf_header']").attr("content");
const token = document.querySelector('meta[name="_csrf"]').content;
// const header = document.querySelector('meta[name="_csrf_header"]').content;
let deleteButtonClass = document.querySelectorAll(".delete-button");
deleteButtonClass.forEach(button => {
    button.addEventListener("click", function() {
        console.log("clicked")
        let idSplit = this.getAttribute("id").split("-");
        let postType = idSplit[0] + "-" + idSplit[1];
        let postId = idSplit[2];
        fetch(`http://localhost:8080/${postType}/delete?id=${postId}`, {
            method: 'DELETE',
            headers: {
                'X-CSRF-TOKEN': token
            }
        })
            .then(res => {
                console.log(postType)
                console.log(postId)
                // location.reload(true);
            })
    })
})