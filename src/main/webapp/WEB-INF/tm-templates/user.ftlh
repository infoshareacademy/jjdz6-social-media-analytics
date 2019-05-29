<!doctype html>
<html lang="pl-Pl" xmlns="http://www.w3.org/1999/html">
<head>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>Document</title>
</head>
<body>
<form method="post" action="search-user">
    Take User form #Twitter: <input type="text" name="user"/><br/><br/>
    <input type="submit" name="Submit" value="Submit"/><br/><br/>
</form>
<#list users as user>
    <li>${user}</li>
</#list>
</body>
</html>