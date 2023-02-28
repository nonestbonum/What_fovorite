<!DOCTYPE html>
<#import "spring.ftl" as spring/>
<#setting classic_compatible=true>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>Admin</title>
    <link href="/css/admin.css" rel="stylesheet"/>
</head>
<body>
<div class="cont">
    <div class="logout">
        <form action="/logout">
            <button>выход</button>
        </form>
    </div>
    <div class="hello">
        Здравствуйте, ADMIN ${account_fio}
    </div>
    <br>
    <div class="all">
        <table style="width: 100%">
            <tr>
                <td>id</td>
                <td>email</td>
                <td>ФИО</td>
                <td>role</td>
            </tr>
            <#list accounts as account>
            <tr>
                <td>${account.id}</td>
                <td>${account.email}</td>
                <td>${account.FIO}</td>
                <td>${account.role}</td>
                </#list>
        </table>
    </div>
</body>