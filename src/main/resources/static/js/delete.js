(function () {
    const token = document.querySelector('meta[name="_csrf"]').content;
    let deleteButtonClass = document.querySelectorAll(".delete-button");
    //

    if(deleteButtonClass !== null) {
        deleteButtonClass.forEach(button => {
            button.addEventListener("click", function(e) {
                e.preventDefault();
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
                        location.reload(true);
                    })
            })
        })

        // UNCOMMENT BELOW FOR PRODUCTION
        //
        // deleteButtonClass.forEach(button => {
        //     button.addEventListener("click", function(e) {
        //         e.preventDefault();
        //         let idSplit = this.getAttribute("id").split("-");
        //         let postType = idSplit[0] + "-" + idSplit[1];
        //         let postId = idSplit[2];
        //         fetch(`https://codeon-capstone.com/${postType}/delete?id=${postId}`, {
        //             method: 'DELETE',
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