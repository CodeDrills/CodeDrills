(function () {
    const token = document.querySelector('meta[name="_csrf"]').content;

    let upvoteButtonClass = document.querySelectorAll(".upvote-button");
    let downvoteButtonClass = document.querySelectorAll(".downvote-button");
    //

    if(upvoteButtonClass && downvoteButtonClass !== null) {
        // upvoteButtonClass.forEach(button => {
        //     button.addEventListener("click", function(e) {
        //         e.preventDefault();
        //         let idSplit = this.getAttribute("id").split("-");
        //         let postId = idSplit[1];
        //         fetch(`http://localhost:8080/upvote/${postId}`, {
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
        //
        // downvoteButtonClass.forEach(button => {
        //     button.addEventListener("click", function(e) {
        //         e.preventDefault();
        //         let idSplit = this.getAttribute("id").split("-");
        //         let postId = idSplit[1];
        //         fetch(`http://localhost:8080/downvote/${postId}`, {
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
        // UNCOMMENT BELOW FOR PRODUCTION PUSH

        upvoteButtonClass.forEach(button => {
            button.addEventListener("click", function(e) {
                e.preventDefault();
                let idSplit = this.getAttribute("id").split("-");
                let postId = idSplit[1];
                fetch(`https://codeon-capstone.com/upvote/${postId}`, {
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
            button.addEventListener("click", function(e) {
                e.preventDefault();
                let idSplit = this.getAttribute("id").split("-");
                let postId = idSplit[1];
                fetch(`https://codeon-capstone.com/downvote/${postId}`, {
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

})();