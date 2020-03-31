let deleteButtonClass = document.querySelectorAll(".delete-button");
deleteButtonClass.forEach(button => {
    button.addEventListener("click", function() {
        let idSplit = this.getAttribute("id").split("-");
        let postType = idSplit[0];
        let postId = idSplit[1];
        fetch(`http://localhost:8080/${postType}/delete?id=${postId}`, {
            method: 'DELETE',
        })
            .then(res => {
                location.reload(true);
            })
    })
})