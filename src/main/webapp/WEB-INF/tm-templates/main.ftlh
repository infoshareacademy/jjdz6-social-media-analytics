<html>

<head>
    <meta charset="UTF-8">
    <title>Navigation Bar</title>
    <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.8.1/css/all.css">
    <link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Roboto:300">
    <style>
        body {
            background: #3aabef;
            font: normal 300 18px "Roboto", sans-serif;
        }

        #menu-nav {
            max-width: 1000px;
            margin: 130px auto;
            background-color: #ecf0f1;
            border-radius: 4px;
            box-shadow: 0 2px 5px rgba(0, 0, 0, 0.3);
        }

        #navigation-bar ul {
            border-radius: 4px;
            overflow: hidden;
        }

        #navigation-bar li {
            float: left;
            width: 20%;
        }

        #navigation-bar li:hover a::before {
            right: 0;
            left: 0;
        }

        #navigation-bar a {
            color: #848484;
            font-size: 20px;
            text-decoration: none;
            text-align: center;
            padding: 20px 0;
            display: block;
            position: relative;
            transition: all 0.3s ease;
        }

        #navigation-bar a:hover {
            color: #e74c3c;
        }

        #navigation-bar a::before {
            content: "";
            transition: all 0.4s ease-in-out;
            position: absolute;
            right: 50%;
            left: 50%;
            bottom: 0;
            height: 2px;
            background-color: #e74c3c;
        }

        #navigation-bar a:hover::before {
            right: 0;
            left: 0;
        }

        li {
            list-style: none;
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

<div id="menu-nav">
    <div id="navigation-bar">
        <ul>
            <li><a href="find-trend"><i class="fas fa-poll"></i><span>Trend</span></a></li>
            <li><a href="map-trends"><i class="fas fa-globe-americas"></i><span>Trend Map</span></a></li>
            <li><a href="tweet-search"><i class="fab fa-twitter-square"></i><span>Tearch Tweet</span></a></li>
            <li><a href="search-user"><i class="fa fa-user"></i><span>Search User</span></a></li>
            <li><a href="stream-map"><i class="fas fa-stream"></i> <span>Tweet stream</span></a></li>
        </ul>
    </div>

</div>

</body>
<div class="footer">
    <#include "footer.ftlh">
</div>
</html>