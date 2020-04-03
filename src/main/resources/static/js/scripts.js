const token = document.querySelector('meta[name="_csrf"]').content;

//used in many places
const attachDeletePostEventListener = function () {
    let deleteButtonClass = document.querySelectorAll(".delete-button");
    if(deleteButtonClass !== null) {
        deleteButtonClass.forEach(button => {
            button.addEventListener("click", function(e) {
                e.preventDefault();
                let idSplit = this.getAttribute("id").split("-");
                let postType = idSplit[0] + "-" + idSplit[1];
                let postId = idSplit[2];
                fetch(`/${postType}/delete?id=${postId}`, {
                    method: 'DELETE',
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
};
//used many places
const attachAddCommentEventListener = function() {
    if (document.querySelectorAll(".add-comment-button") !== null) {
        let i = 0;
        document.querySelectorAll(".add-comment-button").forEach(button => button.addEventListener("click", function (e) {
            e.preventDefault();
            document.querySelector(`#create-comment-div-${this.getAttribute("id").split("-")[3]}`).innerHTML = `<input type="text" id="comment-${this.getAttribute("id").split("-")[3]}" name="body" placeholder="Comment."><button class="post-comment-button" id="post-comment-button-${this.getAttribute("id").split("-")[3]}">Submit.</button>`;
            document.querySelector(`#post-comment-button-${this.getAttribute("id").split("-")[3]}`).addEventListener("click", function (e) {
                e.preventDefault();
                let body = document.querySelector(`#comment-${this.getAttribute("id").split("-")[3]}`).value;
                let idSplit = this.getAttribute("id").split("-");
                let postId = idSplit[3];
                fetch(`/comments/create/${postId}?body=${body}`, {
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
};
//used alot
const attachRatingsEventListener = function() {
    let upvoteButtonClass = document.querySelectorAll(".upvote-button");
    let downvoteButtonClass = document.querySelectorAll(".downvote-button");
    let upvoteCommentButtonClass = document.querySelectorAll(".upvote-comment-button");
    let downvoteCommentButtonClass = document.querySelectorAll(".downvote-comment-button");
    if(upvoteButtonClass && downvoteButtonClass !== null) {
        upvoteButtonClass.forEach(button => {
            button.addEventListener("click", function(e) {
                e.preventDefault();
                let idSplit = this.getAttribute("id").split("-");
                let postId = idSplit[1];
                fetch(`/upvote/${postId}`, {
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
                fetch(`/downvote/${postId}`, {
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
                fetch(`/upvote/comment/${commentId}`, {
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
                fetch(`/downvote/comment/${commentId}`, {
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
}
//
//used in api/questions
const attachGetQuestionEventListener = function() {
    if(document.getElementById("start-button") != null) {
        document.getElementById("start-button").addEventListener("click", function() {
            attachGetQuestionEventListener();
        });
        let fill = document.getElementById("fill-this");

        fetch(`/api/questions/show-one`, {
            method: 'GET'
        })
        .then(response => {
            return response.json()
        })
        .then(res => {
            if (document.getElementById("start-button") !== null) {
                document.getElementById("start-button").parentNode.removeChild(document.getElementById("start-button"));
            }
            fill.innerHTML = "";
            fill.innerHTML = `
                    <div id="question-${res.id}">
                        <p>Question Title: ${res.title}</p>
                        <p>Rating Total: ${res.ratingTotal}</p>
                        <p>Question: ${res.body}</p>
                        <div id="answer-${res.id}">
                        <p>Answer: ${res.answer}</p>
                        <button class="upvote-button" id="upvote-${res.id}">Upvote JS</button>
                        <button class="downvote-button" id="downvote-${res.id}">Downvote JS</button>
                        <div class="create-comment-div" id="create-comment-div-${res.id}"></div>
                        <button class="add-comment-button" id="add-comment-button-${res.id}">Comment</button>
                        </div>
                        <button id="answer-button-${res.id}">Show Answer</button>
                        <button id="question-button-${res.id}">Get Another Question</button>
                    </div>`;
            document.getElementById(`answer-${res.id}`).style.display = "none";
            document.getElementById(`answer-button-${res.id}`).addEventListener("click", function () {
                document.getElementById(`answer-${res.id}`).style.display = "block";
            });
            document.getElementById(`question-button-${res.id}`).addEventListener("click", function () {
                attachGetQuestionEventListener();
            })
            attachAddCommentEventListener();
            attachRatingsEventListener();
        })
    }
};
const attachAddSkillEventListener = function() {
    if (document.getElementById("add-skill-button") !== null) {
        let i = 0;
        document.getElementById("add-skill-button").addEventListener("click", function (e) {
            e.preventDefault();
            let newDiv = document.createElement("div");
            // and give it some content
            newDiv.innerHTML = `<input type="text" id="skills-param-${i}" name="skills-param" placeholder="Please input a skill.">`
            // add the text node to the newly created div
            document.querySelector("#skills-div").appendChild(newDiv);
            i++;
        })
    }
}
const attachFilestack = function() {
    if (document.querySelector('meta.filestackKey') !== null && document.querySelector('meta.filestackKey').content !== "") {
        // Set up the picker
        const client1 = filestack.init(document.querySelector('meta.filestackKey').content);
        const client2 = filestack.init(document.querySelector('meta.filestackKey').content);
        const photoOptions = {
            onUploadDone: updatePhotoForm,
            maxSize: 10 * 1024 * 1024,
            accept: 'image/*',
            uploadInBackground: false,
        };
        const resumeOptions = {
            onUploadDone: updateResumeForm,
            maxSize: 10 * 1024 * 1024,
            accept: ['image/*', 'application/pdf'],
            uploadInBackground: false,
        };
        const photoPicker = client1.picker(photoOptions);
        const resumePicker = client2.picker(resumeOptions);

        // Get references to the DOM elements
        const photoInput = document.getElementById('photo-upload');
        const photoBtn = document.getElementById('photo-picker');
        const resumeInput = document.getElementById('resume-upload');
        const resumeBtn = document.getElementById('resume-picker');


        // Add our event listeners

        if (photoBtn !== null) {
            photoBtn.addEventListener('click', function (e) {
                e.preventDefault();
                photoPicker.open();
            });
        }
        if (resumeBtn !== null) {
            resumeBtn.addEventListener('click', function (e) {
                e.preventDefault();
                resumePicker.open();
            });
        }

        function updatePhotoForm(result) {
            const fileData = result.filesUploaded[0];
            photoInput.value = fileData.url; //this is the good part
            console.log(fileData.url);
            console.log(photoInput.value);
        };

        function updateResumeForm(result) {
            const fileData = result.filesUploaded[0];
            resumeInput.value = fileData.url; //this is the good part
            console.log(fileData.url);
            console.log(resumeInput.value);
        };
    }
}

//begin main
attachAddCommentEventListener();
attachAddSkillEventListener();
attachDeletePostEventListener();
attachFilestack();
attachRatingsEventListener();
attachGetQuestionEventListener();