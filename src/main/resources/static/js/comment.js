(function () {
    const token = document.querySelector('meta[name="_csrf"]').content;
    if (document.querySelectorAll(".add-comment-button") !== null) {
        const token = document.querySelector('meta[name="_csrf"]').content;
        let i = 0;
        document.querySelectorAll(".add-comment-button").forEach(button => button.addEventListener("click", function (e) {
            e.preventDefault();
            document.querySelector(`#create-comment-div-${this.getAttribute("id").split("-")[3]}`).innerHTML = `<input type="text" id="comment-${this.getAttribute("id").split("-")[3]}" name="body" placeholder="Comment."><button class="post-comment-button" id="post-comment-button-${this.getAttribute("id").split("-")[3]}">Submit.</button>`;
            document.querySelector(`#post-comment-button-${this.getAttribute("id").split("-")[3]}`).addEventListener("click", function (e) {
                e.preventDefault();
                let body = document.querySelector(`#comment-${this.getAttribute("id").split("-")[3]}`).value;
                let idSplit = this.getAttribute("id").split("-");
                let postId = idSplit[3];
                // fetch(`http://localhost:8080/comments/create/${postId}?body=${body}`, {
                //     method: 'POST',
                //     headers: {
                //         'X-CSRF-TOKEN': token
                //     }
                // })
                //     .then(res => {
                //         location.reload(true);
                //     })
                //change this for production
                fetch(`https://codeon-capstone.com/comments/create/${postId}?body=${body}`, {
                    method: 'POST',
                    headers: {
                        'X-CSRF-TOKEN': token
                    }
                })
                    .then(res => {
                        location.reload(true);
                    })
            })

        }))
    }

})();