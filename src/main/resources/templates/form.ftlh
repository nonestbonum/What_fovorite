<!DOCTYPE html>
<#import "spring.ftl" as spring/>
<#setting classic_compatible=true>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>SignIn</title>
    <link href="/css/form.css" rel="stylesheet"/>
</head>
<body>
<div class="cont">
    <div class="logout">
        <form action="/logout">
            <button>выход</button>
        </form>
    </div>
    <br>
    <br>
    <br>
    <div class="hello">
        Здравствуйте, ${account_fio}
    </div>
    <br>
    <br>
    <br>
    <form action="/${account_id}/form" method="post">
        <table class="tbl">
            <tr>
                <td>
                    <label for="favDish">Любимое блюдо</label>
                </td>
                <td>
                    <input type="text" name="favDish"/>
                </td>
                <td>
                    <label for="favColor">Любимый цвет</label>
                </td>
                <td>
                    <input type="text" name="favColor"/>
                </td>
            </tr>
            <tr>
                <td>
                    <label for="favSong">Любимая песня</label>
                </td>
                <td>
                    <input type="text" name="favSong"/>
                </td>
                <td>
                    <label for="favDate">Любимая дата</label>
                </td>
                <td>
                    <input type="date" name="favDate"/>
                </td>
            </tr>
            <tr>
                <td>
                    <label for="favNum">Любимое число</label>
                </td>
                <td>
                    <input type="number" name="favNum"/>
                </td>
            </tr>
        </table>
        <br>
        <br>
        <br>
        <div class="btns">
            <form>
                <button type="submit">Отправить</button>
            </form>
        </div>
    </form>
</div>
<p>${fail}</p>
</body>