<!doctype html>
<html lang="pl-Pl" xmlns="http://www.w3.org/1999/html">
<head>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>#Find User</title>
    <style>
        * {
            margin: 0;
            padding: 0;
            background-color: #3aabef;
            font-family: 'Lato', sans-serif;
        }

        li {
            font-size: 21px;
            text-align: center;
            list-style: none;
            color: whitesmoke;
        }


        h1 {
            margin: 20px;
            text-align: center;
            font-size: 40px;
            color: whitesmoke;
        }

        .nameList {
            font-size: 20px;
        }

        img {
            display: block;
            margin: 0 auto;
            height: 200px;
            width: 200px;

        }

        .form {

            text-align: center;
            font-size: 20px;
            color: whitesmoke;


        }

        .footer {
            background-color: #FFF;
            position: fixed;
            bottom: 0;
            width: 100%;
            text-align: center;
            color: white;


        }


        button:hover {
            font-size: 15px;
            color: black;

        }

    </style>
</head>
<body>
<h1>#Find User</h1>
<img src="http://aux4.iconspalace.com/uploads/7425575651630862538.0-twitter-256"/>
<div class="form">
    <form method="post" action="search-user">
        #Twitter User: <input type="text" name="user"/><br/><br/>
        <input class="button" type="submit" name="Submit" value="Submit"/><br/><br/>
    </form>
</div>
<#list users as user>
    <li>${user}</li>
</#list>


<div class="footer">
    <#include "footer.ftlh">
</div>
</body>
</html>