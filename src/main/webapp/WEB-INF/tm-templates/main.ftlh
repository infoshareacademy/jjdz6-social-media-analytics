<html xmlns="http://www.w3.org/1999/html">
<head>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <link href="https://fonts.googleapis.com/css?family=Lato&display=swap" rel="stylesheet">
    <title>TwitterApp</title>
    <style>
        * {
            margin: 0;
            padding: 0;
            background-color: #3aabef;
            font-family: 'Lato', sans-serif;
        }

        h1 {
            text-align: center;
            font-size: 40px;
            color: whitesmoke;
        }


        .container {
            margin: 0 auto;
            padding: 0 40px;
        }

        .navbar {
            padding: 20px 0;
            margin-bottom: 20px;
            width: 100%;
            height: auto;

        }

        .logo, .nav {
            display: inline-block;
            margin: 0;
        }

        .nav {
            padding: 0;
            margin: 0;
            list-style: none;
        }

        .nav li {
            display: inline-block;
            margin-left: 40px;
        }

        .navbar a {
            color: #FFF;
            text-decoration: none;
        }
        .nav-right {
            float: right;
            line-height: 39px;
        }

        .navbar a:hover {
            color: #DDD;
        }


        img {
            display: block;
            margin: 0 auto;
            height: 200px;
            width: 200px;

        }


        .footer {
            background-color: #FFF;
            position: fixed;
            bottom: 0;
            width: 100%;
            text-align: center;
            color: white;

        }


    </style>
</head>
<body>
<header>
    <h1>The Social Media Analitycs Application by #Twitter </h1>
</header>
<img src="https://aderouler.net/wp-content/uploads/2017/08/aderouler.net-twitterdev-gear.png"/>
<nav class="navbar">
    <div class="container">
        <h1 class="logo"><a href="https://twitter.com">#Go to Twitter</a></h1>
        <ul class="nav nav-right">
            <li><a href="find-trend">Find Trend By Country/City</a></li>
            <li><a href="search-user">Find User</a></li>
            <li><a href="tweet-search">Tweet Finder</a></li>
        </ul>
    </div>
</nav>
<div class="footer">
    <#include "footer.ftlh">
</body>
</html>