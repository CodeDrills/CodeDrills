(function () {
    const token = document.querySelector('meta[name="_csrf"]').content;

    //

    let commentButtonClass = document.querySelectorAll(".comment-button");
    commentButtonClass.forEach(button => {
        button.addEventListener("click", function(e) {
            e.preventDefault();
            let idSplit = this.getAttribute("id").split("-");
            let postType = idSplit[0] + "-" + idSplit[1];
            let postId = idSplit[2];
            fetch(`http://localhost:8080/comment/create/${postId}`, {
                method: 'POST',
                headers: {
                    'X-CSRF-TOKEN': token
                }
            })
                .then(res => {
                    location.reload(true);
                })
        })
    })

    // UNCOMMENT BELOW FOR PRODUCTION
    //
    // let commentButtonClass = document.querySelectorAll(".comment-button");
    // commentButtonClass.forEach(button => {
    //     button.addEventListener("click", function(e) {
    //         e.preventDefault();
    //         let idSplit = this.getAttribute("id").split("-");
    //         let postType = idSplit[0] + "-" + idSplit[1];
    //         let postId = idSplit[2];
    //         fetch(`https://codeon-capstone.com/comment/create/${postId}`, {
    //             method: 'POST',
    //             headers: {
    //                 'X-CSRF-TOKEN': token
    //             }
    //         })
    //             .then(res => {
    //                 location.reload(true);
    //             })
    //     })
    // })
})();