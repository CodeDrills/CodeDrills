
let deleteButtonClass = document.querySelectorAll(".delete-button");
deleteButtonClass.forEach(button => {
    button.addEventListener("click", function() {
        console.log("clicked")
        let idSplit = this.getAttribute("id").split("-");
        let postType = idSplit[0] + "-" + idSplit[1];
        let postId = idSplit[2];
        fetch(`http://localhost:8080/${postType}/delete?id=${postId}`, {
            method: 'DELETE',
        })
            .then(res => {
                console.log(postType)
                console.log(postId)
                // location.reload(true);
            })
    })
})