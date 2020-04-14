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
            document.querySelector(`#create-comment-div-${this.getAttribute("id").split("-")[3]}`).innerHTML = `<textarea class="form-control" cols="10" rows="5" maxlength="250" type="text" id="comment-${this.getAttribute("id").split("-")[3]}" name="body" placeholder="add your comment"></textarea><button class="post-comment-button" id="post-comment-button-${this.getAttribute("id").split("-")[3]}">Submit.</button>`;
            document.querySelector(`#post-comment-button-${this.getAttribute("id").split("-")[3]}`).addEventListener("click", function (e) {
                e.preventDefault();
                let commentInput = document.querySelector(`#comment-${this.getAttribute("id").split("-")[3]}`);
                let body = commentInput.value;
                let idSplit = this.getAttribute("id").split("-");
                let postId = idSplit[3];
                fetch(`/comments/create/${postId}?body=${body}`, {
                    method: 'POST',
                    headers: {
                        'X-CSRF-TOKEN': token
                    }
                })
                    .then(res => {
                        if(!window.location.href.includes("/api")) {
                            location.reload(true);
                            return res;
                        }
                        // commentInput.parent.parent.appendChild(document.createElement("div").innerHTML = body);
                        let newDiv = document.createElement("div").innerHTML = `<p>Comment Added:</p><p>${body}</p>`;
                        this.style.display = "none";
                        commentInput.style.display = "none";
                        this.parentElement.innerHTML = this.parentElement.innerHTML + newDiv;
                        attachGetQuestionEventListener();
                    })
            })
        }))
    }
};

const attachEditCommentEventListener = function() {
    if (document.querySelectorAll(".edit-comment-button") !== null) {
        let i = 0;
        document.querySelectorAll(".edit-comment-button").forEach(button => button.addEventListener("click", function (e) {
            e.preventDefault();
            let currentBody = document.querySelector(`#comment-body-${this.getAttribute("id").split("-")[3]}`).innerText;
            document.querySelector(`#comment-body-${this.getAttribute("id").split("-")[3]}`).style.display = "none";
            document.querySelector(`#edit-comment-div-${this.getAttribute("id").split("-")[3]}`).innerHTML = `<textarea class="form-control" cols="10" rows="5" maxlength="250" type="text" id="edit-${this.getAttribute("id").split("-")[3]}" name="body"></textarea><button class="post-comment-button" id="submit-edit-comment-button-${this.getAttribute("id").split("-")[3]}">Submit.</button>`;
            let editInput = document.getElementById(`edit-${this.getAttribute("id").split("-")[3]}`);
            editInput.value = currentBody;
            document.querySelector(`#submit-edit-comment-button-${this.getAttribute("id").split("-")[3]}`).addEventListener("click", function (e) {
                e.preventDefault();
                let body = editInput.value;
                let idSplit = this.getAttribute("id").split("-");
                let commentId = idSplit[4];
                fetch(`/comments/edit/${commentId}?body=${body}`, {
                    method: 'POST',
                    headers: {
                        'X-CSRF-TOKEN': token
                    }
                })
                    .then(res => {
                        if(!window.location.href.includes("/api")) {
                            location.reload(true);
                            return res;
                        }
                        this.style.display = "none";
                        editInput.style.display = "none";
                        document.querySelector(`#comment-body-${this.getAttribute("id").split("-")[3]}`).value = body;
                        attachGetQuestionEventListener();
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
                    .then(response => {
                        return response.text();
                    })
                    .then(res => {
                        if(!window.location.href.includes("/api")) {
                            location.reload(true);
                            return res;
                        }
                        document.getElementById("total-rating").innerHTML = `${res}`;
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
                    .then(response => {
                        return response.text();
                    })
                    .then(res => {
                        if(!window.location.href.includes("/api")) {
                            location.reload(true);
                            return res;
                        }
                        document.getElementById("total-rating").innerHTML = `${res}`;
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
};
//
//used in api/questions
const attachGetQuestionEventListener = function() {
    if(document.getElementById("start-button") !== null) {
        document.getElementById("start-button").addEventListener("click", function(e) {
            e.preventDefault();
            getQuestion();
        });
    }
};
const attachAddSkillEventListener = function() {
    if (document.getElementById("add-skill-button") !== null) {
        let i = 0;
        document.getElementById("add-skill-button").addEventListener("click", function (e) {
            e.preventDefault();
            let newDiv = document.createElement("div");
            // and give it some content
            newDiv.innerHTML = `<input class = "form-control" type="text" id="skills-param-${i}" name="skills-param" placeholder="Please input a skill.">`
            // add the text node to the newly created div
            document.querySelector("#skills-div").appendChild(newDiv);
            i++;
        })
    }
};
const getQuestion = function() {
    let fill = document.getElementById("fill-this");
    fetch(`/api/interview-questions/show-one`, {
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
                    <div class="container question-round-container" id="question-${res.id}">
                        <div class="d-flex justify-content-center">
                            <button class="show-answer-button" id="answer-button-${res.id}">Show Answer</button>
                            <button class="next-question-button" id="question-button-${res.id}">Get Another Question</button>
                        </div>
                        <div class="row">
                            <div class="card col-12">
                                <div class="row">
                                    <div class="col-1 p-4">
                                        <i class="upvote-button fas fa-arrow-up btn btn-link" id="upvote-${res.id}"></i>
                                        <p class="mb-0 ml-3">  <span id="total-rating">${res.ratingTotal}</span></p>
                                        <i class="downvote-button fas fa-arrow-down btn btn-link" id="downvote-${res.id}"></i>
                                    </div>
                                    <div class="col-11 p-4">
                                        <h3>${res.title}</h3>
                                        <!-- <p id="total-rating">Rating Total: ${res.ratingTotal}</p> -->
                                        <h5>${res.body}</h5>
                                        <div id="answer-${res.id}">
                                        <br>
                                        <h5><b>Answer:</b>   ${res.answer}</h5>
                                        <!--
                                        <button class="upvote-button" id="upvote-${res.id}">Upvote JS</button>
                                        <button class="downvote-button" id="downvote-${res.id}">Downvote JS</button>
                                        -->
                                        <div class="create-comment-div" id="create-comment-div-${res.id}"></div>
                                        <button class="add-comment-button" id="add-comment-button-${res.id}">Comment</button>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>`;
            document.getElementById(`answer-${res.id}`).style.display = "none";
            document.getElementById(`answer-button-${res.id}`).addEventListener("click", function (e) {
                e.preventDefault();
                document.getElementById(`answer-${res.id}`).style.display = "block";
            });
            document.getElementById(`question-button-${res.id}`).addEventListener("click", function (e) {
                e.preventDefault();
                getQuestion();
            })
            attachAddCommentEventListener();
            attachRatingsEventListener();
        })
};
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
};
const attachCreatePostSubmitButtonListener = function() {
    if(document.querySelectorAll(".submit-button") !== null) {
        document.querySelectorAll(".submit-button").forEach(button => {
            button.addEventListener("click", function(e) {
                e.preventDefault();
                let idSplit = this.getAttribute("id").split("-");
                let type = `${idSplit[0]}-${idSplit[1]}`;
                let title = document.querySelector(`#${type}-title`).value;
                let body = document.querySelector(`#${type}-body`).value;
                let answer = document.querySelector(`#${type}-answer`) ? document.querySelector(`#${type}-answer`).value : null;
                let employer = document.querySelector(`#${type}-employer`) ? document.querySelector(`#${type}-employer`).value : null;
                let photoURL = document.querySelector(`.${type}-photo-url`) ? document.querySelector(`.${type}-photo-url`).value : null;
                let addParams;
                switch(`${type}`) {
                    case "interview-questions":
                        addParams = `answer=${answer}&employer=${employer}`;
                        break;
                    case "mentorship-posts":
                        addParams = `photoURL=${photoURL}`;
                        break;
                    case "job-postings":
                        addParams = `employer=${employer}`;
                        break;
                    case "whiteboard-questions":
                        addParams = `answer=${answer}&employer=${employer}`;
                        break;
                    default:
                        break;
                }
                fetch(`/${type}/create?title=${title}&body=${body}&${addParams}`, {
                    method: 'POST',
                    headers: {
                        'X-CSRF-TOKEN': token
                    }
                })
                    .then(response => {
                        location.reload(true);
                    })
            })
        })
    }
};
const attachCreateModalEventListener = function() {
    document.querySelectorAll(".nav-create-button").forEach(button => {
        button.addEventListener("click", attachCreatePostSubmitButtonListener, attachFilestack);
    })
};
//begin main
attachAddCommentEventListener();
attachEditCommentEventListener();
attachAddSkillEventListener();
attachDeletePostEventListener();
attachFilestack();
attachRatingsEventListener();
attachGetQuestionEventListener();
attachCreateModalEventListener();
