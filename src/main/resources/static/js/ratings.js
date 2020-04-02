(function () {
    const token = document.querySelector('meta[name="_csrf"]').content;

    let upvoteButtonClass = document.querySelectorAll(".upvote-button");
    let downvoteButtonClass = document.querySelectorAll(".downvote-button");
    let upvoteCommentButtonClass = document.querySelectorAll(".upvote-comment-button");
    let downvoteCommentButtonClass = document.querySelectorAll(".downvote-comment-button");
    //

    if(upvoteButtonClass && downvoteButtonClass !== null) {
        upvoteButtonClass.forEach(button => {
            button.addEventListener("click", function (e) {
                e.preventDefault();
                let idSplit = this.getAttribute("id").split("-");
                let postId = idSplit[1];
                fetch(`http://localhost:8080/upvote/${postId}`, {
                    method: 'POST',
                    headers: {
                        'X-CSRF-TOKEN': token
                    }
                })
                    .then(res => {
                        location.reload(true);
                    })
            })
        });

        downvoteButtonClass.forEach(button => {
            button.addEventListener("click", function (e) {
                e.preventDefault();
                let idSplit = this.getAttribute("id").split("-");
                let postId = idSplit[1];
                fetch(`http://localhost:8080/downvote/${postId}`, {
                    method: 'POST',
                    headers: {
                        'X-CSRF-TOKEN': token
                    }
                })
                    .then(res => {
                        location.reload(true);
                    })
            })
        });
    }

    if(upvoteCommentButtonClass && downvoteCommentButtonClass !== null) {
        upvoteCommentButtonClass.forEach(button => {
            button.addEventListener("click", function(e) {
                e.preventDefault();
                let idSplit = this.getAttribute("id").split("-");
                let commentId = idSplit[2];
                fetch(`http://localhost:8080/upvote/comment/${commentId}`, {
                    method: 'POST',
                    headers: {
                        'X-CSRF-TOKEN': token
                    }
                })
                    .then(res => {
                        location.reload(true);
                    })
            })
        });

        downvoteCommentButtonClass.forEach(button => {
            button.addEventListener("click", function(e) {
                e.preventDefault();
                let idSplit = this.getAttribute("id").split("-");
                let commentId = idSplit[2];
                fetch(`http://localhost:8080/downvote/comment/${commentId}`, {
                    method: 'POST',
                    headers: {
                        'X-CSRF-TOKEN': token
                    }
                })
                    .then(res => {
                        location.reload(true);
                    })
            })
        });
        // UNCOMMENT BELOW FOR PRODUCTION PUSH

        // upvoteButtonClass.forEach(button => {
        //     button.addEventListener("click", function(e) {
        //         e.preventDefault();
        //         let idSplit = this.getAttribute("id").split("-");
        //         let postId = idSplit[1];
        //         fetch(`https://codeon-capstone.com/upvote/${postId}`, {
        //             method: 'POST',
        //             headers: {
        //                 'X-CSRF-TOKEN': token
        //             }
        //         })
        //             .then(res => {
        //                 location.reload(true);
        //             })
        //     })
        // });
        //
        // downvoteButtonClass.forEach(button => {
        //     button.addEventListener("click", function(e) {
        //         e.preventDefault();
        //         let idSplit = this.getAttribute("id").split("-");
        //         let postId = idSplit[1];
        //         fetch(`https://codeon-capstone.com/downvote/${postId}`, {
        //             method: 'POST',
        //             headers: {
        //                 'X-CSRF-TOKEN': token
        //             }
        //         })
        //             .then(res => {
        //                 location.reload(true);
        //             })
        //     })
        // });
    }

})();