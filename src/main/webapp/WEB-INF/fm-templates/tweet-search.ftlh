<!DOCTYPE html>
<html lang="pl-PL" xmlns="http://java.sun.com/jsf/html">
<meta charset="UTF-8">
<head>
    <title>Tweets</title>
</head>
<body>

<form name="searchForm" method="post" action = "tweet-search">
    <h5>Szukaj po:
        Typ: <select name= "option">
            <option value="popular">Wszystkie</option>
            <option value="popular">Najpopularniejsze</option>
            <option value="recent">Nanowsze</option>
            <option value="mixed">Mieszane</option>
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
<#if tweets??><button>Pobierz w formacie JSON</button></#if>

</body>
</html>