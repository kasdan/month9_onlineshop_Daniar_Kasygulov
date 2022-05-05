//this function gets post add event requests

function postHandler(e) {
    e.preventDefault();
    const form = e.target;
    let data = new FormData(form);
    const file = data.get('file');
    let post = addPost(file, data.get('description'), data.get('id'));
    sendPostToServer(post);
}
async function getComments(pubId) {
    fetch('http://localhost:8080/comments/get?pubId=' + pubId)
        .then(response => response.json())
        .then(data => {
            showCommentsForPost(data);
        });
}

function getPosts() {
    fetch('http://localhost:8080/posts', {
        method: 'GET',
    })
        .then(response => response.json())
        .then(data => {
            addPostFromJson(data)
        });
}

//this functions handles all submit requests then separates them
function submitHadler(e) {
    let form = e.target;
    if (form.matches('#add-post')) {
        postHandler(e);
    } else {
        commentsHandler(e);
    }
}

const container = document.getElementsByClassName("container")[0];
container.addEventListener('dblclick', dblClickFunction, false);
container.addEventListener('click', oneClickFunction, false);
container.addEventListener('submit', submitHadler, false);

//function taking event of one click in the particular place bottom of the card
function oneClickFunction(e) {
    let element = e.target;
    let target;
    if (element.matches("i")) {
        if (element.id.includes('_bottom')) {
            target = element;
        } else if (element.id.includes('_bookmark')) {
            target = element;
        } else if (element.id.includes('_comment_icon')) {
            target = element;
        } else {
            element = null;
        }
    } else {
        element = null;
    }

    if (target) {
        if (target.id.includes('_bottom')) {
            heartChangeBottom(target);
        } else if (target.id.includes('_comment_icon')) {
            commentPopOut(target);
        } else {
            makeBookmarkRed(target);
        }

    } else {
        console.log("That wasn't a i in the container table");
    }
}

let toggleComments = false;
let currentPubId = -1;

function commentPopOut(target) {
    let id = target.id.replace('_comment_icon', '_comment_div');
    let commenDiv = document.getElementById(id);
    let pubId = id.replace('_comment_div', '');
    pubId = pubId.replace('picture', '');
    if (toggleComments) {
        commenDiv.hidden = true;
    } else {
        commenDiv.hidden = false
        if (currentPubId == -1) {
            getComments(pubId);
            currentPubId = pubId;
        } else if (currentPubId == pubId) {
            currentPubId = pubId;
        } else {
            getComments(pubId);
            currentPubId = pubId;
        }

    }
    toggleComments = !toggleComments;
}

function dblClickFunction(e) {
    let element = e.target;
    let target;
    if (element.matches("i")) {
        if (element.id.includes('top')) {
            target = element;
        } else {
            element = null;
        }
    } else {
        element = null;
    }
    if (target) {
        makeHeartFullIcon(target);
        console.log("You clicked " + target.id);
    } else {
        console.log("That wasn't a i in the container table");
    }
}

const loginForm = document.querySelector('#login');
const splash = document.querySelector('.splash');
const registerPage = document.querySelector('#registerPage');
const register = document.querySelector('.register');
const registerUser = document.querySelector('#add-user');
const logout = document.querySelector('#logout');
const h1element = splash.querySelector('.fade-in');
register.hidden = true;
//splashRemove.addEventListener("submit", getPosts, false);

loginForm.addEventListener('submit', onLoginHandler);
logout.addEventListener('click',onLogoutHandler);
window.onload = userInStorage;

function userInStorage() {
    if (restoreUser() !== null) {
        userInformation(restoreUser());
        splash.hidden = true;
        getPosts();
    } else {
        splash.hidden = false;
    }
}

function onLogoutHandler(e){
    clearUser();
    loginNormal();
    splash.hidden = false;
}
function onLoginHandler(e) {
    e.preventDefault();
    const form = e.target;
    const userFormData = new FormData(form);
    const user = Object.fromEntries(userFormData);
    loginUser(user).then(login => {
        if(login === false){
            loginIncorrect();
        }
    });
}
async function loginUser(user) {
    let headers = new Headers();
    let loginState = false;
    headers.set('Authorization', 'Basic ' + window.btoa(user.username + ':' + user.password));
    try {
        await fetch('http://localhost:8080/login', {
            method: 'GET',
            mode: 'cors',
            headers: headers,
        })
            .then(response => response.json())
            .then(data => {
                if (data === true) {
                    saveUser(user);
                    splash.hidden = true;
                    userInformation(restoreUser());
                    getPosts();
                    loginState = true;
                }
            });
        return loginState;
    }catch(e){
        return loginState;
    }

}

function loginIncorrect() {
    h1element.style.color = "red";
    h1element.innerHTML = 'Login incorrect please login again.';
}

function loginNormal(){
    h1element.style.color = "white";
    h1element.innerHTML = 'Welcome to the Microgram!';
    registerPage.hidden = false;
    document.location.reload()
}
function loginAfterRegister(){
    register.hidden = true;
    h1element.innerHTML = 'You are registered login please.';
    h1element.style.color = 'white';
    splash.hidden = false;
    registerPage.hidden = true;
}

function userInformation(user){
    const userInfo = document.querySelector('#userInfo');
    userInfo.innerHTML = user.username;
}

function saveUser(user) {
    const userAsJSON = JSON.stringify(user)
    localStorage.setItem('user', userAsJSON);
}

function restoreUser() {
    const userAsJSON = localStorage.getItem('user');
    const user = JSON.parse(userAsJSON);
    return user;
}

function clearUser(){
    localStorage.clear();
}

registerPage.addEventListener("click", function () {
    splash.hidden = true;
    register.hidden = false;
});

registerUser.addEventListener("submit", addUser, false);

function addUser(e) {
    e.preventDefault();
    let form = e.target;
    let data = new FormData(form);
    console.log(data);
    let url = 'http://localhost:8080/add_user';
    let userReg = {
        'username': data.get('username'),
        'email': data.get('email'),
        'fullName': data.get('fullname'),
        'password': data.get('password')
    };
    console.log(userReg)
    postData(url, userReg)
        .then(data1 => {
            console.log(data1);
        });
    loginAfterRegister();
}

async function postData(url, data) {
    // Default options are marked with *
    const response = await fetch(url, {
        method: 'POST',
        mode: 'cors',
        cache: 'no-cache',
        headers: {
            'Content-Type': 'application/json'
        },
        body: JSON.stringify(data)
    });
    return response; // parses JSON response into native JavaScript objects
}

let toggle = false;

function makeHeartFullIcon(target) {
    let id = target.id.replace('_top', '_bottom');
    let icon = document.getElementById(target.id);
    let iconBottom = document.getElementById(id).parentElement;
    if (toggle) {
        icon.setAttribute('class', 'bi bi-heart');
        iconBottom.setAttribute('class', "h1 mx-2 muted");
    } else {
        icon.setAttribute('class', 'bi bi-heart-fill');
        iconBottom.setAttribute('class', "h1 mx-2 text-danger");
    }
    toggle = !toggle;
}

let toggleBookmark = false;

function makeBookmarkRed(target) {
    let bm = document.getElementById(target.id).parentElement
    if (toggleBookmark) {
        bm.setAttribute('class', 'h1 mx-2 muted');
    } else {
        bm.setAttribute('class', 'h1 mx-2 text-danger');
    }
    toggleBookmark = !toggleBookmark;
}

function heartChangeBottom(target) {
    let id = target.id.replace('_bottom', '_top');
    let icon = document.getElementById(target.id).parentElement;
    let iconTop = document.getElementById(id)
    if (toggle) {
        icon.setAttribute('class', "h1 mx-2 muted");
        iconTop.setAttribute('class', 'bi bi-heart');

    } else {
        icon.setAttribute('class', "h1 mx-2 text-danger");
        iconTop.setAttribute('class', 'bi bi-heart-fill');
    }

    toggle = !toggle;
}

const posts = [];

function showPosts(posts) {
    posts.forEach(element => {
        createPostJson(element);
    });
}

function addPostFromJson(data) {
    for (let i = 0; i < data.length; i++) {
        let post1 = {
            postId: data[i].id,
            post: data[i].picture,
            description: data[i].description,
            postTime: data[i].dateAdded,
            userId: data[i].userId,
        };
        posts.push(post1);

    }
    showPosts(posts);
}

function createPostJson(somePost) {

    const contParent = document.querySelector('#form-input').parentElement;
    const contForm = document.querySelector('#form-input');
    const createId = 'picture' + somePost.postId;
    const createHeartId = 'picture' + somePost.postId + 'heart';

    const newPost = document.createElement("div");
    newPost.setAttribute("class", "card  text-left");
    newPost.setAttribute("style", "width: 30rem;");
    contParent.insertBefore(newPost, contForm);

    const newImg = document.createElement('img');
    newImg.setAttribute('src', '#');
    newImg.setAttribute('class', 'card-img-top');
    newImg.setAttribute('id', createId)
    newImg.setAttribute('alt', somePost.description);
    newPost.append(newImg);

    const newHeartTop = document.createElement('span');
    newHeartTop.setAttribute('class', 'h1 mx-2 text-danger');
    newHeartTop.setAttribute('id', createHeartId);
    newPost.append(newHeartTop);

    const heartIcon = document.createElement('i');
    heartIcon.setAttribute('class', 'bi bi-heart');
    heartIcon.setAttribute('id', createHeartId + '_top')
    newHeartTop.append(heartIcon);

    const cardBody = document.createElement('div');
    cardBody.setAttribute('class', 'card-body');
    newPost.append(cardBody);

    const heartBottom = document.createElement('span');
    heartBottom.setAttribute('class', 'h1 mx-2 muted');
    cardBody.append(heartBottom);

    const heartFilledIcon = document.createElement('i');
    heartFilledIcon.setAttribute('class', 'bi bi-heart-fill');
    heartFilledIcon.setAttribute('id', createHeartId + '_bottom')
    heartBottom.append(heartFilledIcon);

    const commentSpan = document.createElement('span');
    commentSpan.setAttribute('class', 'h1 mx-2 muted');
    cardBody.append(commentSpan);

    const commentItem = document.createElement('i');
    commentItem.setAttribute('class', 'bi bi-chat-left-dots-fill');
    commentItem.setAttribute('id', createId + '_comment_icon');
    commentSpan.append(commentItem);

    const bookmark = document.createElement('span');
    bookmark.setAttribute('class', 'h1 mx-2 muted');
    cardBody.append(bookmark);

    const bookmarItem = document.createElement('i');
    bookmarItem.setAttribute('class', 'bi bi-bookmark-fill');
    bookmarItem.setAttribute('id', createId + '_bookmark');
    bookmark.append(bookmarItem);

    const commentFormDiv = document.createElement('div');
    commentFormDiv.setAttribute('class', 'input-group mb-3');
    commentFormDiv.setAttribute('id', createId + '_comment_div')
    commentFormDiv.hidden = true;
    commentFormDiv.innerHTML = '<form id=' + (createId + "_comment") + ' class = "form">' +
        '<input type = "text" name="id" hidden value="1">' +
        '<input type = "text" name="postId" hidden value=' + somePost.postId + '>' +
        '<textarea class="col-md-20" placeholder="Please write comments" ng-model="myTextarea" required data-error="Please enter comments" name="text-area"></textarea>' +
        '<input type = "submit" class = "btn btn-primary">' +
        '</form>';
    newPost.append(commentFormDiv);

    const preview = document.querySelector('#' + createId);
    const file = somePost.post.pictureData;
    preview.src = "data:image/jpg;base64," + file;

    let elem = document.getElementById(createHeartId);
    elem.style.position = 'absolute';
    elem.style.top = '150px';
    elem.style.left = '220px';

    let bm = document.getElementById(createId + '_bookmark').parentElement;
    bm.style.position = 'absolute';
    bm.style.right = '20px';
}

function addComment(commentText, postId, userId) {
    // let today = new Date();
    // let date = today.getFullYear() + '-' + (today.getMonth() + 1) + '-' + today.getDate();
    // let time = today.getHours() + ":" + today.getMinutes() + ":" + today.getSeconds();
    // let dateTime = date + ' ' + time;
    const comment = {
        commText: commentText,
        postId: postId,
        userId: userId
    };
    // posts[postId - 1].comments.push(comment);
    // return posts[postId - 1];
    return comment;
}

function commentsHandler(e) {
    e.preventDefault();
    let form = e.target;
    let data = new FormData(form);
    let commentForPost = addComment(data.get('text-area'), data.get('postId'), data.get('id'));

    createCommentForPost(commentForPost);
    //sendPostToServer(postWithComment);
}

function showCommentsForPost(comments) {
    comments.forEach(element => {
        createCommentForPost(element);
    });
}

function createCommentForPost(comment) {
    const createId = 'picture' + comment.pubId;
    let postCommentFormDiv = document.getElementById(createId + '_comment_div');
    let contParent = postCommentFormDiv.parentElement;
    const newComment = document.createElement("p");
    newComment.setAttribute("class", "text-left");
    newComment.innerHTML = comment.text + ' ' + comment.dateAdded + ' ' + comment.userId + ' id:' + comment.pubId;
    contParent.insertBefore(newComment, postCommentFormDiv);
}