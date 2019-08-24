<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <meta name="google-signin-client_id" content="343502052313-psu5l3v39klko54udt2h4g93i5nmnb5u.apps.googleusercontent.com">
    <title>Social Media Analytics</title>
    <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.8.1/css/all.css">
    <link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Roboto:300">
    <script src="https://apis.google.com/js/platform.js" async defer></script>
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
            margin-top: 10px;
            bottom: 0;
            width: 100%;
            text-align: center;
            color: black;
        }
    </style>
<body>

<form name="searchForm" method="post" action = "tweet-search">
    <p>Wprowadź kryteria wyszukiwania: </p>
        Typ: <select name= "option">
            <option value="popular">Najpopularniejsze</option>
            <option value="recent">Najnowsze</option>
            <option value="mixed">Mieszane</option>
            <option value="all">Wszystkie</option>
        </select>
        Szukana fraza: <input name= "text" type="text">
        Data: <input name = "date" type = "date" value="${currentDate}">
        Kod języka (ISO 639-1): <input name="lang" type="text" maxlength="2" value="pl">
        <input type = "submit" value="Szukaj">
    </h5>
    </p>
</form>
<#if errorMessage??>
<span style="color: #1314ff;">${errorMessage}</span><br/><br/>
</#if>
<div>
    <ul>
        <#if tweets??>
            <#list tweets as tweetPresentationObject>
                <#include "tweet.ftlh">
            </#list>
        </#if>
    </ul>

</div>
<div><div style="margin-bottom: 20px;">
        <#if tweets??><a href="/download?option=${option}&text=${text}&lang=${lang}&date=${date}">Pobierz w formacie JSON</a></#if>
    </div>
</div>

</body>

</html>