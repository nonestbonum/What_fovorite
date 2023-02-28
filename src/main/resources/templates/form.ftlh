<!DOCTYPE html>
<#import "spring.ftl" as spring/>
<#setting classic_compatible=true>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>Form</title>
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
            <@spring.bind path='formDto'/>
            <p class="error">${spring.status.errorMessage}</p>
            <tr>
                <td>
                    <label for="favDish">Любимое блюдо</label>
                </td>
                <td>
                    <@spring.formInput "formDto.favDish"/>
                    <@spring.showErrors "<br>" "error"/>
                </td>
                <td>
                    <label for="favColor">Любимый цвет</label>
                </td>
                <td>
                    <@spring.formInput "formDto.favColor"/>
                    <@spring.showErrors "<br>" "error"/>
                </td>
            </tr>
            <tr>
                <td>
                    <label for="favSong">Любимая песня</label>
                </td>
                <td>
                    <@spring.formInput "formDto.favSong"/>
                    <@spring.showErrors "<br>" "error"/>
                </td>
                <td>
                    <label for="favDate">Любимая дата</label>
                </td>
                <td>
                    <@spring.formInput fieldType="Date" path="formDto.favDate"/>
                    <@spring.showErrors "<br>" "error"/>
                </td>
            </tr>
            <tr>
                <td>
                    <label for="favNum">Любимое число</label>
                </td>
                <td>
                    <@spring.formInput fieldType="Integer" path="formDto.favNum"/>
                    <@spring.showErrors "<br>" "error"/>
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