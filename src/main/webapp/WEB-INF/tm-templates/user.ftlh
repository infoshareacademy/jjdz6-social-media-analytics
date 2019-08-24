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

            font-family: 'Lato', sans-serif;
        }

        html {
            background-color: #3aabef;
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

        .button {
            padding: 25px 25px;
            color: white;
            font-size: 18px;
            border: 4px solid white;
            border-radius: 10px;
            background-color: deepskyblue;

        }


        .button:hover {
            font-size: 20px;
            color: black;
            background-color: white;

        }

        .nameUser {
            padding: 10px 10px;
            font-size: 25px;
            border-radius: 20px;
        }


        .status {
            background-color: white;
            color: black;
            text-align: justify;
            display: block;
            margin: 15px auto;
            max-height: 400px;
            width: 400px;
            padding: 20px 20px;
            border: 2px solid darkblue;
        }

        a {
            text-align: center;
            position: absolute;
            right: 200px;
            text-decoration: none;
            font-size: 20px;
            color: white;

        }

        .textOfname {
            font-size: 25px;
            border-radius: 20px;

        }


    </style>
</head>
<body>
<h1>@Znajdź użytkownika</h1>
<img src="http://aux4.iconspalace.com/uploads/7425575651630862538.0-twitter-256"/>
<div class="main-menu"><a href="/main">Menu</a></div>
<div class="form">
    <form method="post" action="search-user">
       Wpisz nazwę użytownika:  <input class="textOfname" type="text" name="nameOfUser"/><br/><br/>
        <input class="button" type="submit" name="Submit" value="Zatwierdź"/><br/><br/>
    </form>
</div>


<#list users as user>
    <li class="nameUser"> @Użytkownik: ${user.name}</li>
    <li class="countFollow">Liczba followersów: ${user.followers}</li>
    <li class="status">${user.status}</li>
</#list>


<div class="footer">
    <#include "footer.ftlh">
</div>
</body>
</html>