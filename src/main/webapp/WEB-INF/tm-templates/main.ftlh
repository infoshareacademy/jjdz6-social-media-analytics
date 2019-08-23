<!doctype html>
<html lang="pl-PL">
<head>
    <meta charset="UTF-8">
    <meta name="google-signin-client_id"
          content="343502052313-psu5l3v39klko54udt2h4g93i5nmnb5u.apps.googleusercontent.com">
    <title>Social Meida Analytics</title>
    <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.8.1/css/all.css">
    <link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Roboto:300">
    <script src="https://apis.google.com/js/platform.js" async defer></script>
    <style>
        * {
            margin: 0;
            padding: 0;
            box-sizing: border-box;
        }

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
            display: block;
            margin: 0 auto;
            background-color: #FFF;
            position: fixed;
            bottom: 0;
            width: 100%;
            text-align: center;
            color: #848484;
        }

        .google-name {
            margin: 0 auto;
            text-align: center;
            padding: 20px 20px;
            width: 500px;
            background-color:white;
            color:#848484;

        }
    </style>
</head>

<body>

<div id="menu-nav">
    <div id="navigation-bar">
        <ul>
            <li><a href="find-trend"><i class="fas fa-poll"></i><span>Trend</span></a></li>
            <li><a href="map-trends"><i class="fas fa-globe-americas"></i><span>Trend Map</span></a></li>
            <li><a href="search-user"><i class="fa fa-user"></i><span>Search User</span></a></li>
            <#--<li><a href="cookie-reader"><i class="fa fa-user"></i><span>Cookie-reader</span></a></li>-->

            <#if name??>
                <li class="nav-item">
                    <a href="https://www.google.com/accounts/Logout?continue=https://appengine.google.com/_ah/logout?continue=http://localhost:8080/logout">Wyloguj</a>
                </li>
            <#else>
                <li><a href="http://localhost:8080/googlelogin">Zaloguj</a>
                </li>
            </#if>

        </ul>
    </div>

</div>
<div class="google-name">Zalogowany jako: ${name}</div>

</body>
<div class="footer">
    <#include "footer.ftlh">
</div>
</html>