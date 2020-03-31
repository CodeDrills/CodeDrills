
let deleteButtonClass = document.querySelectorAll(".delete-button");
deleteButtonClass.forEach(button => {
    button.addEventListener("click", function() {
        console.log("clicked")
        let idSplit = this.getAttribute("id").split("-");
        let postType = idSplit[0];
        let postId = idSplit[1];
        fetch(`http://localhost:8080/mentorship/delete?id=7`, {
            method: 'DELETE',
        })
            .then(res => {
                console.log(postType)
                console.log(postId)
                // location.reload(true);
            })
    })
})