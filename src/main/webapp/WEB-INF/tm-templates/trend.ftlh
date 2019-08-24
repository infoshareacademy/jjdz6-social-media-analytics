<!doctype html>
<html lang="pl">
<head xmlns="http://www.w3.org/1999/html">
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <link href="https://fonts.googleapis.com/css?family=Lato&display=swap" rel="stylesheet">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>Find By Trend</title>
    <style>

        html {
            background-color: #3aabef;
        }
        * {

            font-family: 'Lato', sans-serif;
        }

        img {
            height: 300px;
            width: 600px;
        }

        .image {
            text-align: center;
        }

        .form {

            text-align: center;
            font-size: 25px;
            color: whitesmoke;
            padding: 20px 20px;


        }


        h1 {
            text-align: justify;
            font-size: 35px;
            color: whitesmoke;


        }

        h2 {
            text-align: center;
            color: whitesmoke;
        }

        ol>a{
            display: block;
            margin:  5px auto;
            font-size: 21px;
            text-align: center;
            list-style: none;
            width: 250px;
            padding: 10px 10px;
            background-color: white;
            border: 3px solid deepskyblue;
            color: black;
            text-decoration: none;

        }

        a {

            text-decoration: none;
            color: black;

        }


        .button {
            width: 150px;
        }

        .main-menu>a{
            text-align: center;
            position: absolute;
            padding: 20px;
            font-size: 25px;
            right: 200px;
            text-decoration: none;
            text-underline: none;


        }


        img {
            border: 2px solid skyblue;
        }

        .param {
             font-size: 20px;
             border-radius: 20px;
        }

        .button {
            font-size: 20px;
            padding: 10px 10px;
            border-radius: 20px;
        }





    </style>
</head>
<body>
<div class="image">
    <img src="https://spur.innovware.net/wp-content/uploads/2017/04/PairOfButtocks-Uganda-Twitter-Trending-Spur-Magazine-1.jpg"/>
</div>
<div class="form">
    <form method="post" action="find-trend">
        Place: <input class="param" type="text" name="param"/><br/><br/>
        <input class="button" type="submit" name="Submit" value="Submit"/><br/><br/>
    </form>
</div>
<div class="main-menu"><a href="/main">Menu</a></div>

<h2>Trends: </h2>

<#list trendList as trend>
    <ol><a href="${trend.URL}">${trend.name}</a></ol>
</#list>
</body>
</html>