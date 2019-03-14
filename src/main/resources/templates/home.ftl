<!DOCTYPE html>
<html>
<head lang="en">
    <meta charset="UTF-8" />
    <title></title>
    <link rel="stylesheet" type="text/css" href="/static.css/home.css">
</head>
<body>
<h1>${name}</h1>
<table>
    <thead>
    <tr>
        <th>ID</th>
        <th>Name</th>
        <th>Description</th>
        <th>Age</th>
    </tr>
    </thead>
    <tbody>
    <#list users as u>
        <tr>
            <td>${u.userCardId}</td>
            <td>${u.userName}</td>
         <!--   <td><#if u.userDesc??>${u.userDesc}</#if></td>  -->
            <td>${(u.userDesc)!}</td>
            <td>${u.userAge}</td>
        </tr>
    </#list>
    </tbody>
</table>
</body>
</html>