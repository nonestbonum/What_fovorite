<!DOCTYPE html>
<#import "spring.ftl" as spring/>
<#setting classic_compatible=true>
<html lang="en">
<head>
    <title>SignUp</title>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <link href="/css/signUp.css" rel="stylesheet"/>
</head>
<body>

<div class="cont">
    <div class="reg">
        РЕГИСТРАЦИЯ
    </div>
    <form action="/signUp" method="post">
        <table class="tbl">
            <@spring.bind path='signUpForm'/>
            <p class="error">${spring.status.errorMessage}</p>

            <tr>
                <td>
                    <label for="FIO">ФИО</label>
                </td>
                <td>
                    <@spring.formInput "signUpForm.FIO"/>
                    <@spring.showErrors "<br>" "error"/>
                </td>
                <td>
                    <label for="lastName">ДР</label>
                </td>
                <td>
                    <@spring.formInput fieldType="Date" path="signUpForm.birthday"/>
                    <@spring.showErrors "<br>" "error"/>
                </td>
            </tr>
            <tr>
                <td>
                    <label for="email">Email</label>
                </td>
                <td>
                    <@spring.formInput "signUpForm.email"/>
                    <@spring.showErrors "<br>" "error"/>
                </td>
                <td>
                    <label for="password">Пароль</label>
                </td>
                <td>
                    <@spring.formPasswordInput "signUpForm.password"/>
                    <@spring.showErrors "<br>" "error"/>
                </td>
            </tr>
        </table>
        <div class="btns">
            <form>
                <button type="submit">Sign Up</button>
            </form>
            <form action="/">
                <button>back</button>
            </form>
        </div>
    </form>
</div>
<p>${fail}</p>
</body>
</html>
