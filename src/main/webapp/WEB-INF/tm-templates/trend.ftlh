<!doctype html>
<html lang="pl">
<head xmlns="http://www.w3.org/1999/html">
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <link href="https://fonts.googleapis.com/css?family=Lato&display=swap" rel="stylesheet">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>Document</title>
    <style>
        * {
            background-color: #3aabef;
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
            font-size: 20px;
            color: whitesmoke;


        }


        h1 {
            text-align: center;
            font-size: 35px;
            color: whitesmoke;


        }

        h2 {
            text-align: center;
            color: whitesmoke;
        }

        li {
            font-size: 21px;
            text-align: center;
            list-style: none;
        }

        a {

            text-decoration: none;
            color: black;

        }

        a:hover {
            background-color: mintcream;
            font-size: 20px;
            color: black;
        }

        button:hover {
            font-size: 15px;
            color: black;

        }

    </style>
</head>
<body>
<div class="image">
    <img src="https://spur.innovware.net/wp-content/uploads/2017/04/PairOfButtocks-Uganda-Twitter-Trending-Spur-Magazine-1.jpg"/>
</div>
<h1>#Twitter Trends by Country/City</h1>
<div class="form">
    <form method="post" action="find-trend">
        Country/City: <input type="text" name="NAME"/><br/><br/>
        <input class="button" type="submit" name="Submit" value="Submit"/><br/><br/>
    </form>
</div>

<h2>#List Of Trends</h2>
<#list trendList as trend>
    <li><ol><a href="${trend}">${trend}</a></ol></li>
</#list>
</body>
</html>