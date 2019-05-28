<!doctype html>
<html lang="pl">
<head xmlns="http://www.w3.org/1999/html">
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>Document</title>
    <style>
        * {
            background-color: azure;
        }

        h1 {
            text-align: center;


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
            background-color: yellow;
            font-size: 40px;
        }

    </style>
</head>
<body>
<h1>
    Twitter Trends by City (Gdansk)
</h1>
<h2>
    List Of Option:</h2>

<#list trendList as trend>

    <li><a = href"${trend}">${trend}</a></li>
</#list>

</body>
</html>