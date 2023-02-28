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
    <link href="/css/signIn.css" rel="stylesheet"/>
</head>
<body>
<div class="cont">
    <div class="reg">
        ВХОД
    </div>
    <form action="/signIn" method="post">
        <table class="tbl">
            <@spring.bind path='signInForm'/>
            <p class="error">${spring.status.errorMessage}</p>

            <tr>
                <td class="l">
                    <label for="email">E-mail</label>
                </td>
                <td class="r">
                    <@spring.formInput "signInForm.email"/>
                    <@spring.showErrors "<br>" "error"/>
                </td>
            </tr>
            <tr>
                <td class="l">
                    <label for="password">Пароль:</label>
                </td>
                <td class="r">
                    <@spring.formPasswordInput "signInForm.password"/>
                    <@spring.showErrors "<br>" "error"/>
                </td>
            </tr>
        </table>
        <div class="btns">
            <form>
                <button type="submit">Sign In</button>
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
