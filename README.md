# Project 2

<p align="center">
  <a href="#">
    <img src="./img/logo.png" alt="Foodie logo" width="72" height="82">
  </a>
</p>

<h3 align="center">Foodie (Back-End REST API)</h3>

<p align="center">
  Foodie is an a discussion forum where people post and comment on a food recipe. 
  <br>
    
  <br>
  ·
  <a href="https://www.pivotaltracker.com/n/projects/2407495">User Stories</a>
   ·
</p>

## Table of contents

- [User Stories](#user-stories)
- [Timeline](#timeline)
- [ERD](#erd)
- [Diagrams](#class-diagrams)
- [API](#api)
- [API Responses](#responses)
- [Objects](#objects)
- [Testing](#testing)
- [Test Results](#results)
- [What's Included](#whats-included)
- [Creators](#developers)


## User Stories

[Pivotal Tracker (Back-End REST API)](https://www.pivotaltracker.com/n/projects/2407495)

Application Goals from User Stories are:
    
* Sign-up and Create Profile Foodie User
* Anyone can See Posts and Comments
* Signed-in user able to post a Post and comment
* Signed-in user able to delete it's own Posts and Comments



## Timeline

1. Requirement Analysis
    * Monday(Oct 21, 2019) - user stories
        
        We give our user stories points, so that we could prioritize our development steps. 
 
            https://www.pivotaltracker.com/n/projects/2407495
    
    * Monday(Oct 21, 2019) - ERD
        
            Pair mapped ERD to include 5 tables and various foreign keys to connect the tables.
            
         [ERD](#erd)
         
    * Tuesday(Oct 22, 2019) - User, comment, and post routes mapped.
    
            Added user, comment, and post creation functionality.
            
    * Wednesday(Oct 23, 2019) - User security functionality added.
    
            Added User/JWT functionality and connection between comment and post.
        
    * Thursday(Oct 24, 2019) - Tested all route functionality and began testing.
    
            All route functionality is working. Recorded results to ReadMe file.
            
    * Friday(Oct 25, 2019) - Tested all route functionality.
    
            *-*-*-*-*-*-*
        
      

  

## ERD
##### Rough Sketch of ERD.
![ERD](./img/ERD.jpg)

##### Soft Representation of ERD.
![ERD](./img/ERD_2.png)
    
    * Visualization Generated by DataGrip.
     

## API
```text
Base URL: /, Version: 1.1

Default request content-types: application/json

Default response content-types: application/json

Schemes: http 
```
### Summary

<table style="
    width: 100%;
    max-width: 100%;
    margin-bottom: 20px;
    border: 1px solid #ddd;
    border-collapse: collapse;
    border-spacing: 0;
    background-color: transparent;
    display: table;
">
    <thead>
    <tr>
        <th>Path</th>
        <th>Operation</th>
        <th>Description</th>
        <th>Controller#Method</th>
    </tr>
    </thead>
    <tbody>
    <tr>
        <td style="border: 1px solid #ddd;padding: 5px;" rowspan="2" style="border: 1px solid #ddd;padding: 5px;">
            <a href="#summary">/user/signup</a>
        </td>
    </tr>
    <tr>
        <td style="border: 1px solid #ddd;padding: 5px;">
            <a href="#post-usersignup">POST</a>
        </td>
        <td style="border: 1px solid #ddd;padding: 5px;">
            <p>Create a User (Sign-up)</p>
        </td>
        <td style="border: 1px solid #ddd;padding: 5px;">
            <p>UserController#signup</p>
        </td>
    </tr>
    <tr>
        <td style="border: 1px solid #ddd;padding: 5px;" rowspan="2" style="border: 1px solid #ddd;padding: 5px;">
            <a href="#summary">/user/login</a>
        </td>
    </tr>
    <tr>
        <td style="border: 1px solid #ddd;padding: 5px;">
            <a href="#post-userlogin">POST</a>
        </td>
        <td style="border: 1px solid #ddd;padding: 5px;">
            <p>Create a login session.</p>
        </td>
        <td style="border: 1px solid #ddd;padding: 5px;">
            <p>UserController#login</p>
        </td>
    </tr>
    <tr>
        <td style="border: 1px solid #ddd;padding: 5px;" rowspan="2" style="border: 1px solid #ddd;padding: 5px;">
            <a href="#summary">/user/reset</a>
        </td>
    </tr>
    <tr>
        <td style="border: 1px solid #ddd;padding: 5px;">
            <a href="#put-userreset">PUT</a>
        </td>
        <td style="border: 1px solid #ddd;padding: 5px;">
            <p>Reset User Password.</p>
        </td>
        <td style="border: 1px solid #ddd;padding: 5px;">
            <p>UserController#reset</p>
        </td>
    </tr>
    <tr>
        <td style="border: 1px solid #ddd;padding: 5px;" rowspan="3">
            <a href="#summary">/profile</a>
        </td>
        <td style="border: 1px solid #ddd;padding: 5px;">
            <a href="#get-profile">GET</a>
        </td>
        <td style="border: 1px solid #ddd;padding: 5px;">
            <p>Retrieve the profile of the User. (Auth Token Required)</p>
        </td>
        <td style="border: 1px solid #ddd;padding: 5px;">
            <p>ProfileController#getProfile</p>
        </td>
    </tr>
    <tr>
        <td style="border: 1px solid #ddd;padding: 5px;">
            <a href="#post-profile">POST</a>
        </td>
        <td style="border: 1px solid #ddd;padding: 5px;">
            <p>Create the profile of the User. (Auth Token Required)</p>
        </td>
        <td style="border: 1px solid #ddd;padding: 5px;">
            <p>ProfileController#createProfile</p>
        </td>
    </tr>
    <tr>
        <td style="border: 1px solid #ddd;padding: 5px;">
            <a href="#put-profile">PUT</a>
        </td>
        <td style="border: 1px solid #ddd;padding: 5px;">
            <p>Update profile of the User. (Auth Token Required)</p>
        </td>
        <td style="border: 1px solid #ddd;padding: 5px;">
            <p>ProfileController#updateProfile</p>
        </td>
    </tr>
    <tr>
        <td style="border: 1px solid #ddd;padding: 5px;" rowspan="2">
            <a href="#summary">/post</a>
        </td>
        <td style="border: 1px solid #ddd;padding: 5px;">
            <a href="#get-post">GET</a>
        </td>
        <td style="border: 1px solid #ddd;padding: 5px;">
            <p>Getting the Posts of the User (Auth Token Required).</p>
        </td>
        <td style="border: 1px solid #ddd;padding: 5px;">
            <p>PostController#listPostByUser</p>
        </td>
    </tr>
    <tr>
        <td style="border: 1px solid #ddd;padding: 5px;">
            <a href="#post-post">POST</a>
        </td>
        <td style="border: 1px solid #ddd;padding: 5px;">
            <p>Create a Posts of the User (Auth Token Required).</p>
        </td>
        <td style="border: 1px solid #ddd;padding: 5px;">
            <p>PostController#addPost</p>
        </td>
    </tr>
    <tr>
        <td style="border: 1px solid #ddd;padding: 5px;" rowspan="2" style="border: 1px solid #ddd;padding: 5px;">
            <a href="#summary">/post/list</a>
        </td>
    </tr>
    <tr>
        <td style="border: 1px solid #ddd;padding: 5px;">
            <a href="#get-postlist">GET</a>
        </td>
        <td style="border: 1px solid #ddd;padding: 5px;">
            <p>Retrieve all the posts.</p>
        </td>
        <td style="border: 1px solid #ddd;padding: 5px;">
            <p>PostController#listPost</p>
        </td>
    </tr>
    <tr>
        <td style="border: 1px solid #ddd;padding: 5px;" rowspan="2">
            <a href="#">/post/{postId}</a>
        </td>
        <td style="border: 1px solid #ddd;padding: 5px;">
            <a href="#put-postid">PUT</a>
        </td>
        <td style="border: 1px solid #ddd;padding: 5px;">
            <p>Updating a Post. (Auth Token Required).</p>
        </td>
        <td style="border: 1px solid #ddd;padding: 5px;">
            <p>PostController#updatePost</p>
        </td>
    </tr>
    <tr>
        <td style="border: 1px solid #ddd;padding: 5px;">
            <a href="#delete-postid">DELETE</a>
        </td>
        <td style="border: 1px solid #ddd;padding: 5px;">
            <p>Deleting a Post. (Auth Token Required).</p>
        </td>
        <td style="border: 1px solid #ddd;padding: 5px;">
            <p>PostController#deletePost</p>
        </td>
    </tr>
    <tr>
        <td style="border: 1px solid #ddd;padding: 5px;" rowspan="1">
            <a href="#">/post/{postId}/comment/</a>
        </td>
        <td style="border: 1px solid #ddd;padding: 5px;">
            <a href="#get-postpostidcomment">GET</a>
        </td>
        <td style="border: 1px solid #ddd;padding: 5px;">
            <p>Retrieve all the comments of the a Post. </p>
        </td>
        <td style="border: 1px solid #ddd;padding: 5px;">
            <p>PostController#listCommentsByPost</p>
        </td>
    </tr>
    <tr>
        <td style="border: 1px solid #ddd;padding: 5px;" rowspan="1">
            <a href="#summary">/comment</a>
        </td>
        <td style="border: 1px solid #ddd;padding: 5px;">
            <a href="#get-comment">GET</a>
        </td>
        <td style="border: 1px solid #ddd;padding: 5px;">
            <p>Retrieve all the comments. </p>
        </td>
        <td style="border: 1px solid #ddd;padding: 5px;">
            <p>CommentController#listComments</p>
        </td>
    </tr>
    <tr>
        <td style="border: 1px solid #ddd;padding: 5px;" rowspan="1">
            <a href="#summary">/comment/list</a>
        </td>
        <td style="border: 1px solid #ddd;padding: 5px;">
            <a href="#get-commentlist">GET</a>
        </td>
        <td style="border: 1px solid #ddd;padding: 5px;">
            <p>Retrieve all the comments of a User. (Auth Token Required). </p>
        </td>
        <td style="border: 1px solid #ddd;padding: 5px;">
            <p>CommentController#listCommentsByUser</p>
        </td>
    </tr>
    <tr>
        <td style="border: 1px solid #ddd;padding: 5px;" rowspan="1">
            <a href="#">/comment/{postId}</a>
        </td>
        <td style="border: 1px solid #ddd;padding: 5px;">
            <a href="#post-commentpostid">POST</a>
        </td>
        <td style="border: 1px solid #ddd;padding: 5px;">
            <p>Creating a comment on a post. (Auth Token Required). </p>
        </td>
        <td style="border: 1px solid #ddd;padding: 5px;">
            <p>CommentController#addComment</p>
        </td>
    </tr>
    <tr>
        <td style="border: 1px solid #ddd;padding: 5px;" rowspan="2">
            <a href="#summary">/comment/{commentId}</a>
        </td>
        <td style="border: 1px solid #ddd;padding: 5px;">
            <a href="#put-commentcommentid">PUT</a>
        </td>
        <td style="border: 1px solid #ddd;padding: 5px;">
            <p>Updating a comment. (Auth Token Required).</p>
        </td>
        <td style="border: 1px solid #ddd;padding: 5px;">
            <p>PostController#updateComment</p>
        </td>
    </tr>
    <tr>
        <td style="border: 1px solid #ddd;padding: 5px;">
            <a href="#delete-commentcommentid">DELETE</a>
        </td>
        <td style="border: 1px solid #ddd;padding: 5px;">
            <p>Deleting a Comment. (Auth Token Required).</p>
        </td>
        <td style="border: 1px solid #ddd;padding: 5px;">
            <p>PostController#deleteComment</p>
        </td>
    </tr>
    </tbody>
</table>
    
### Security

```text
tokenBasedAuth
type: Bearer Token

Description:

Basic HTTP authorization with Bearer Token.


* Bearer Token will be returned after login using 'username' and 'password'.
```
 
### Responses

#### POST /user/signup
Request Body 
```json5
{
	"username" : "myUser",
	"password" : "myPassword9"
}
```
Response Header
```text
    Status: 200 OK
```
Response Body 
```json5
{
    "username": "myUser",
    "token": "eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJteVVzZXIiLCJleHAiOjE1NzIwMTkxMzAsImlhdCI6MTU3MTkzMjczMH0.3j4YpkvdiAkLBpW5PI1aBYZw1Uhf97gm67BwcNFFN0_pWIoZgrMt9xga1ximg1Xt-fMq5-v2ifE8B8sWTMP0EA"
}
```

#### POST /user/login
Authorization
```text
    token: Bearer Token
```
Request Body 
```json5
    {
    	"username" : "myUser",
    	"password" : "myPassword9"
    }
```
Response Header
```text
    Status: 200 OK
```
Response Body 
```json5
{
    "username": "myUser",
    "token": "eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJteVVzZXIiLCJleHAiOjE1NzIwMTkyMjcsImlhdCI6MTU3MTkzMjgyN30.Z9fh-cPXaVLAD9_I3k2w9JYn69lup6PrjtuxRIbUCkwUBHmzsIzhKKaO0sF8hkFJM1tWN61KrkQLl3fYhV9ZZQ"
}
```

#### PUT /user/reset
Authorization
```text
    token: Bearer Token
```
Request Body 
```json5
{
	"password" : "123"
}
```
Response Header
```text
    Status: 200 OK
```
Response Body 
```json5
    {
        "username": "myUser",
        "token": "eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJteVVzZXIiLCJleHAiOjE1NzIwMTkyMjcsImlhdCI6MTU3MTkzMjgyN30.Z9fh-cPXaVLAD9_I3k2w9JYn69lup6PrjtuxRIbUCkwUBHmzsIzhKKaO0sF8hkFJM1tWN61KrkQLl3fYhV9ZZQ"
    }
```

#### GET /profile
Authorization
```text
    token: Bearer Token
```
Response Header
```text
    Status: 200 OK
```
Response Body 
```json5
{
    "email": "myfake@email.com",
    "mobile": "123-123-1234",
    "address": "123 Fake Street"
}
```

#### POST /profile
Authorization
```text
    token: Bearer Token
```
Response Header
```text
    Status: 200 OK
```

Request Body 
```json5
{
    	"address": "123 Fake Street",
    	"email": "myfake@email.com",
    	"mobile": "123-123-1234"
}
```
Response Body 
```json5
{
	"address": "123 Fake Street",
	"email": "myfake@email.com",
	"mobile": "123-123-1234"
}
```

#### PUT /profile
Authorization
```text
    token: Bearer Token
```
Response Header
```text
    Status: 200 OK
```

Request Body 
```json5
{
	"address": "456 Fake Street",
	"email": "myfake@editedemail.com",
	"mobile": "456-123-1234"
}
```
Response Body 
```json5
{
    "email": "myfake@editedemail.com",
    "mobile": "456-123-1234",
    "address": "456 Fake Street"
}
```

#### GET /post/list
Response Header
```text
    Status: 200 OK
```

Response Body 
```json5
[
    {
        "postId": 1,
        "title": "1 title for my post",
        "postText": "1 My super important post.",
        "userName": "might"
    },
    {
        "postId": 2,
        "title": "1 title for my post",
        "postText": "1 My super important post.",
        "userName": "fright"
    },
    {
        "postId": 3,
        "title": "1 title for my post",
        "postText": "1 My super important post.",
        "userName": "fright"
    },
    {
        "postId": 5,
        "title": "my post title",
        "postText": "my post text",
        "userName": "might"
    },
    {
        "postId": 4,
        "title": "1 title for my post",
        "postText": "my edited post text",
        "userName": "fright"
    }
]
```

#### GET /post/
Authorization
```text
    token: Bearer Token
```
Response Header
```text
    Status: 200 OK
```
Response Body 
```json5
[
    {
        "postId": 6,
        "title": "myUser Post Title",
        "postText": "myUser Post Text",
        "userName": "myUser"
    }
]
```

#### POST /post
Authorization
```text
    token: Bearer Token
```
Response Header
```text
    Status: 200 OK
```
Request Body 
```json5
{
	"title" : "myUser Post Title",
	"postText" : "myUser Post Text"
}
```
Response Body 
```json5
{
    "postId": 6,
    "title": "myUser Post Title",
    "postText": "myUser Post Text",
    "userName": "myUser"
}
```
#### PUT /{postId}
Authorization
```text
    token: Bearer Token
```
Response Header
```text
    Status: 200 OK
```

Request Body 
```json5
{
	"postText" : "my edited post text for might"
}
```
Response Body 
```json5
{
    "postId": 5,
    "title": "my post title",
    "postText": "my edited post text for might",
    "userName": "might"
}
```
#### DELETE /post/{postId}
Authorization
```text
    token: Bearer Token
```
Response Header
```text
    Status: 200 OK
```
Response Body 
```json5
5
```

#### GET /post/{postId}/comment/
Response Header
```text
    Status: 200 OK
```
Response Body 
```json5
[
    {
        "commentId": 1,
        "commentText": "Super Post Comment",
        "username": "might",
        "postTitle": "1 title for my post",
        "postid": "1"
    },
    {
        "commentId": 4,
        "commentText": "Super Fright Post Comment",
        "username": "fright",
        "postTitle": "1 title for my post",
        "postid": "1"
    },
    {
        "commentId": 2,
        "commentText": "Super Re-Edited Comment",
        "username": "fright",
        "postTitle": "1 title for my post",
        "postid": "1"
    }
]
```
#### POST /post/{postId}/comment/
Authorization
```text
    token: Bearer Token
```

Response Header
```text
    Status: 200 OK
```
Request Body 
```json5
{
	"commentText" : "Might comment on post"
}
```
Response Body 
```json5
{
    "commentId": 5,
    "commentText": "Might comment on post",
    "username": "might",
    "postTitle": "1 title for my post",
    "postid": "1"
}
```
#### GET /comment
Response Header
```text
    Status: 200 OK
```

Response Body 
```json5
[
    {
        "commentId": 5,
        "commentText": "Might comment on post",
        "username": "might",
        "postTitle": "1 title for my post",
        "postid": "1"
    },
    {
        "commentId": 6,
        "commentText": "Lorem ipsum",
        "username": "might",
        "postTitle": "1 title for my post",
        "postid": "1"
    },
]
```
#### GET /comment/list
Authorization
```text
    token: Bearer Token
```

Response Header
```text
    Status: 200 OK
```
Response Body 
```json5
[
    {
        "commentId": 1,
        "commentText": "Some edited text by might",
        "username": "might",
        "postTitle": "1 title for my post",
        "postid": "1"
    }
]
```
#### POST /comment/{postId}
Authorization
```text
    token: Bearer Token
```

Response Header
```text
    Status: 200 OK
```
Request Body 
```json5
{
	"commentText" : "Some edited text by might"
}
```
Response Body 
```json5
{
    "commentId": 1,
    "commentText": "Some edited text by might",
    "username": "might",
    "postTitle": "1 title for my post",
    "postid": "1"
}
```
#### PUT /comment/{commentId}
Authorization
```text
    token: Bearer Token
```

Response Header
```text
    Status: 200 OK
```
Request Body 
```json5
{
	"commentText" : "Some edited text by might"
}
```
Response Body 
```json5
{
    "commentId": 1,
    "commentText": "Some edited text by might",
    "username": "might",
    "postTitle": "1 title for my post",
    "postid": "1"
}
```
#### DELETE /comment/{commentId}
Authorization
```text
    token: Bearer Token
```

Response Header
```text
    Status: 200 OK
```
Response Body 
```json5
1
```


    
### Objects

```text
User
 * Properties 
    -> userId : integer
    -> username : string
    -> passsword : string
    -> roles : List<Role>
    -> profile : UserProfile
    -> posts : List<Post>
    -> comments : List<Comment>
```

```text
Role
 * Properties 
    -> roleId : integer
    -> name : string
    -> users : List<User>
```

```text
Profile
 * Properties 
    -> profileId : integer
    -> email : string
    -> mobile : string
    -> address : string
    -> user : User
```

```text
Post
 * Properties 
    -> postId : integer
    -> title : string
    -> postText : string
    -> user : User
```

```text
Comment
 * Properties 
    -> commentId : integer
    -> commentText : string
    -> user : User
    -> post : Post
```

```text
JwtResponse
 * Properties 
    -> username : string
    -> jwt : string
```

## Class Diagrams

### Package Diagram
![package](./img/package_diagram.png)  

### Package dao
![package](./img/package_dao.png)  
     
### Package service
![package](./img/package_service.png) 
     
### Package config
![package](./img/config_package.png) 

### Package entity
![package](./img/package_entity.png) 

### Package controller
![package](./img/controller_package.png) 


### Full Class Diagram
![class-diagram](./img/full_class_diagram.png)

## Testing

Packages


    
```text
    com.ga.controller
        - CommentController
        - PostController
        - ProfileController
        - UserController
    com.ga.dao
        - CommentDao
        - PostDao
        - UserDao
        - UserProfileDao
    com.ga.service
        - CommentService
        - PostService
        - UserProfileService
        - UserService
```

### Results

<html id="htmlId">

<body>

<h4>Overall Coverage Summary </h4>
<table class="coverageStats">
  <tr>
    <th class="name">Package</th>
<th class="coverageStat 
">
  Class, %
</th>
<th class="coverageStat 
">
  Method, %
</th>
<th class="coverageStat 
">
  Line, %
</th>
  </tr>
  <tr>
    <td class="name">all classes</td>
<td class="coverageStat">
  <span class="percent">
    95%
  </span>
  <span class="absValue">
    (19/ 20)
  </span>
</td>
<td class="coverageStat">
  <span class="percent">
    75.3%
  </span>
  <span class="absValue">
    (113/ 150)
  </span>
</td>
<td class="coverageStat">
  <span class="percent">
    73.9%
  </span>
  <span class="absValue">
    (322/ 436)
  </span>
</td>
  </tr>
</table>

<br/>
<h4>Coverage Breakdown</h4>

<table class="coverageStats">
  <tr>
    <th class="name  sortedAsc
">
<a href="#">Package</a>    </th>
<th class="coverageStat 
">
  <a href="#">Class, %</a>
</th>
<th class="coverageStat 
">
  <a href="#">Method, %</a>
</th>
<th class="coverageStat 
">
  <a href="#">Line, %</a>
</th>
  </tr>
  <tr>
    <td class="name"><a href="#">com.ga.controller</a></td>
<td class="coverageStat">
  <span class="percent">
    100%
  </span>
  <span class="absValue">
    (4/ 4)
  </span>
</td>
<td class="coverageStat">
  <span class="percent">
    100%
  </span>
  <span class="absValue">
    (21/ 21)
  </span>
</td>
<td class="coverageStat">
  <span class="percent">
    100%
  </span>
  <span class="absValue">
    (32/ 32)
  </span>
</td>
  </tr>
  <tr>
    <td class="name"><a href="#">com.ga.dao</a></td>
<td class="coverageStat">
  <span class="percent">
    100%
  </span>
  <span class="absValue">
    (5/ 5)
  </span>
</td>
<td class="coverageStat">
  <span class="percent">
    66.7%
  </span>
  <span class="absValue">
    (20/ 30)
  </span>
</td>
<td class="coverageStat">
  <span class="percent">
    68.4%
  </span>
  <span class="absValue">
    (134/ 196)
  </span>
</td>
  </tr>
  <tr>
    <td class="name"><a href="#">com.ga.entity</a></td>
<td class="coverageStat">
  <span class="percent">
    100%
  </span>
  <span class="absValue">
    (6/ 6)
  </span>
</td>
<td class="coverageStat">
  <span class="percent">
    87.3%
  </span>
  <span class="absValue">
    (62/ 71)
  </span>
</td>
<td class="coverageStat">
  <span class="percent">
    88.4%
  </span>
  <span class="absValue">
    (130/ 147)
  </span>
</td>
  </tr>
  <tr>
    <td class="name"><a href="#">com.ga.service</a></td>
<td class="coverageStat">
  <span class="percent">
    80%
  </span>
  <span class="absValue">
    (4/ 5)
  </span>
</td>
<td class="coverageStat">
  <span class="percent">
    35.7%
  </span>
  <span class="absValue">
    (10/ 28)
  </span>
</td>
<td class="coverageStat">
  <span class="percent">
    42.6%
  </span>
  <span class="absValue">
    (26/ 61)
  </span>
</td>
  </tr>
</table>
</div>

<div class="footer">
    </div>
</body>
</html>


## What's included

Within the download you'll find the following directories and files, logically grouping common assets and providing both compiled and minified variations. You'll see something like this:

```text
cognizant-p2/
├── README.md
├── pom.xml
├── src
│   ├── com
│   │   └── ga
│   │       ├── config
│   │       │   ├── AppConfig.java
│   │       │   ├── AppDispatcherServlet.java
│   │       │   ├── JwtRequestFilter.java
│   │       │   ├── JwtUtil.java
│   │       │   ├── SecurityConfig.java
│   │       │   └── SecurityConfigInitializer.java
│   │       ├── controller
│   │       │   ├── CommentController.java
│   │       │   ├── PostController.java
│   │       │   ├── ProfileController.java
│   │       │   └── UserController.java
│   │       ├── dao
│   │       │   ├── CommentDao.java
│   │       │   ├── CommentDaoImpl.java
│   │       │   ├── PostDao.java
│   │       │   ├── PostDaoImpl.java
│   │       │   ├── UserDao.java
│   │       │   ├── UserDaoImpl.java
│   │       │   ├── UserProfileDao.java
│   │       │   ├── UserProfileDaoImpl.java
│   │       │   ├── UserRoleDao.java
│   │       │   └── UserRoleDaoImpl.java
│   │       ├── entity
│   │       │   ├── Comment.java
│   │       │   ├── JwtResponse.java
│   │       │   ├── Post.java
│   │       │   ├── User.java
│   │       │   ├── UserProfile.java
│   │       │   └── UserRole.java
│   │       └── service
│   │           ├── CommentService.java
│   │           ├── CommentServiceImpl.java
│   │           ├── PostService.java
│   │           ├── PostServiceImpl.java
│   │           ├── UserProfileService.java
│   │           ├── UserProfileServiceImpl.java
│   │           ├── UserRoleService.java
│   │           ├── UserRoleServiceImpl.java
│   │           ├── UserService.java
│   │           └── UserServiceImpl.java
│   ├── main
│   │   └── webapp
│   │       ├── WEB-INF
│   │       │   └── web.xml
│   │       └── index.jsp
│   └── resources
│       ├── application-dev.properties
│       └── application.properties
└── test
    └── com
        └── ga
            ├── controller
            │   ├── CommentControllerTest.java
            │   ├── PostControllerTest.java
            │   ├── ProfileControllerTest.java
            │   └── UserControllerTest.java
            ├── dao
            │   ├── CommentDaoTest.java
            │   ├── PostDaoTest.java
            │   ├── UserDaoTest.java
            │   ├── UserProfileDaoTest.java
            │   └── UserRoleDaoTest.java
            └── service
                ├── CommentServiceTest.java
                ├── PostServiceTest.java
                ├── UserProfileServiceTest.java
                ├── UserRoleServiceTest.java
                └── UserServiceTest.java



```
    
## Developers

**Marcus Sauceda**

- <https://github.com/ScottSauceda>

**Mohammad Javed**

- <https://github.com/gajjuCoderBoi>