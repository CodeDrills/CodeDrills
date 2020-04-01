(function () {
    const token = document.querySelector('meta[name="_csrf"]').content;
    let upvoteButtonClass = document.querySelectorAll(".upvote-button");
    upvoteButtonClass.forEach(button => {
        button.addEventListener("click", function() {
            let idSplit = this.getAttribute("id").split("-");
            let postId = idSplit[1];
            fetch(`https://codeon-capstone.com/upvote/${postId}`, {
                method: 'GET',
                redirect: 'follow',
                headers: {
                    'X-CSRF-TOKEN': token
                }
            })
                .then(res => {
                    console.log("then");
                })
        })
    })
    let downvoteButtonClass = document.querySelectorAll(".downvote-button");
    downvoteButtonClass.forEach(button => {
        button.addEventListener("click", function() {
            let idSplit = this.getAttribute("id").split("-");
            let postId = idSplit[1];
            fetch(`https://codeon-capstone.com/downvote/${postId}`, {
                method: 'GET',
                redirect: 'follow',
                headers: {
                    'X-CSRF-TOKEN': token
                }
            })
                .then(res => {
                    console.log("then");
                })
        })
    })
})();