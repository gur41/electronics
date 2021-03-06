<!-- Раскомментировать для jsp -->
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib prefix="from" uri="http://www.springframework.org/tags/form" %>
<%@ page session="false" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Регистрация</title>
    
  <%--<script src="../../resources/js/modernizr.custom.63321.js"></script>
  <script src="../../resources/js/jquery-1.11.1.min.js"></script>
  <script src="../../resources/js/bootstrap.min.js"></script>

   <link rel="stylesheet" href="../../resources/css/bootstrap.min.css" />
<link rel="stylesheet" href="../../resources/css/font-awesome.min.css" />
<link rel="stylesheet" href="../../resources/css/menu_style.css" />
<link rel="stylesheet" href="../../resources/css/table.css" />
<link rel="stylesheet" href="../../resources/css/dopstyle.css" />
<link rel="stylesheet" href="../../resources/css/autor_style.css" />--%>
<!-- Раскомментировать для jsp -->
    <link rel="stylesheet" type="text/css" href="<c:url value="/resources/css/autor_style.css" />"/>
    <script  src="${pageContext.request.contextPath}/resources/js/modernizr.custom.63321.js"></script>
    <script src="${pageContext.request.contextPath}/resources/js/jquery-1.11.1.min.js"></script>
    <script src="${pageContext.request.contextPath}/resources/js/bootstrap.min.js"></script>
    <script src="${pageContext.request.contextPath}/resources/js/search.js"></script>
    <link rel="stylesheet" href="<c:url value="/resources/css/bootstrap.min.css" />"/>
    <link rel="stylesheet" href="<c:url value="/resources/css/font-awesome.min.css"/>"/>
    <link rel="stylesheet" href="<c:url value="/resources/css/menu_style.css"/>"/>
    <link rel="stylesheet" href="<c:url value="/resources/css/table.css" />" />
    <link rel="stylesheet" href="<c:url value="/resources/css/modal.css" />" />
    <link rel="shortcut icon" href="<c:url value="/resources/images/fon1.jpg" />" type="image/png">
</head>
<body>
<!-- ///////////////////////////////////////////////// -->
<div class="container">
    <div class="header">
        <div class="row">
            <div class="col-md-7">
                <div class="name">
                    TECHNOLAND
                </div>
            </div>

            <div class="col-md-5">
                <form class="navbar-form navbar-left" role="search">
                    <input type="text" id="text-to-find" value="" class="form-control" placeholder="Найти">
                    <button type="submit" class="btn btn-default" onclick="javascript: FindOnPage('text-to-find'); return false;">
                        <i class="fa fa-search" aria-hidden="true"></i>
                    </button>
                </form>
            </div>
        </div>
    </div>
</div>
<!-- ///////////////////////////////////////////////// -->
<nav class="navbar navbar-default ">
    <div class="container">
        <div class="navbar-header">
            <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#navbar-collapse">
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
                <span class="sr-only"></span>
            </button>

        </div>

        <div class="collapse navbar-collapse" id="navbar-collapse">
            <ul class="nav navbar-nav">
               <%--<li class="">
                    <a href="<c:url value="/flowers_client"/>" target="_self">Цветы</a>
                </li>
                <li class="">
                    <a href="<c:url value="/bouquets_client"/>" target="_self">Букеты</a>
                </li>
                <li class="">
                    <a href="<c:url value="/compositions_client"/>" target="_self">Копмозиции</a>
                </li>
                <li class="">
                    <a href="<c:url value="/customer_bouquets"/>" target="_self">Составить букет</a>
                </li>
 --%>
            </ul>
            <ul class="nav navbar-nav navbar-right">
                <li class="dropdown">
                    <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-expanded="false">Мой
                        профиль<span class="caret"></span></a>
                    <ul class="dropdown-menu" role="menu">
                        <li class="divider"></li>
                        <c:choose>
                            <c:when test="${user.login ne null}">
                                <li><a href="<c:url value="/exit"/>" target="_self">Выход</a></li>
                            </c:when>
                            <c:otherwise>
                                <li><a href="<c:url value="/autorization"/>" target="_self">Вход</a></li>
                            </c:otherwise>
                        </c:choose>
                        <li class="divider"></li>
                        <li><a href="<c:url value="/users"/>" target="_self">Регистрация</a></li>
                    </ul>
                </li>
            </ul>
        </div>
    </div>
</nav>

<!-- <%--//////////////////////////////////////////////////////////////////////////--%> -->

<br>
<div class="mybody">
    <div class="container">
        <div class="article container">
            <div class="row otstup">
                <div class="col-md-8">
                    <h1 class="h2 page-header"
                        style="color:#8d1645; font-family: 'Lobster', cursive; margin-top: -1px;
                        text-align: center;">Добро пожаловать на страницу регистрации</h1>
                    <section class="main">
                           <c:url var="addAction" value="/users/add"/>
                            <form:form action="${addAction}" commandName="user" class="form-2">
                                <table>
                                    <c:if test="${!empty user.login}">
                                        <tr>
                                            <td>
                                                <form:label path="id">
                                                    <spring:message text="ID"/>
                                                </form:label>
                                            </td>
                                            <td>
                                                <form:input path="id" readonly="true" size="8" disabled="true"/>
                                                <form:hidden path="id"/>
                                            </td>
                                        </tr>
                                    </c:if>
                                    <tr>
                                            <p class="field">
                                            <form:label for="login" path="login">
                                                <spring:message text="Логин"/>
                                            </form:label>
                                            <form:input path="login" type="text" name="login" pattern="[a-zA-Z](.[a-zA-Z0-9_-]*)" title="Используйте латинские буквы для логина." placeholder="Логин или email" />
                                            <i class="icon-user icon-large"></i>

                                        </p>
                                    </tr>

                                    <%--<tr>
                                        <p class="field">
                                            <form:label for="role" path="role">
                                                <spring:message text="Роль"/>
                                            </form:label>
                                            <form:select path="role" class="form-control">
                                                <form:option value="Грузоперевозчик" />
                                                <form:option value="Грузовладелец" />
                                            </form:select>
                                        </p>




                                    </tr>--%>

                                    <tr>
                                        <p class="field">
                                            <form:label for="password" path="password">
                                                <spring:message text="Пароль"/>
                                            </form:label>
                                            <form:input path="password" type="password" id="password" name="password" pattern="^[a-zA-Z][a-zA-Z0-9-_\.]{3,12}$" title="Введите от 4 до 12 латинских символов!" placeholder="Пароль" />
                                            <i class="icon-lock icon-large"></i>
                                        </p>
                                    </tr>

                                    <tr>
                                            <p class="field">
                                            <label>
                                                <spring:message text="Пароль"/>
                                            </label>
                                            <input  type="password" id="password2" name="password2" placeholder="Подтверждения пароля" pattern="^[a-zA-Z][a-zA-Z0-9-_\.]{3,12}$" title="Введите от 4 до 12 латинских символов!" class="showpassword"/>
                                                <i class="icon-lock icon-large"></i>
                                            </p>
                                    </tr>


                                    <tr>
                                        <c:if test="${empty user.login}">
                                            <button onclick="return check()" type="submit" name="submit"
                                                    value="<spring:message text="Add User"/>">
                                                <i class="icon-arrow-right"></i>
                                                <span>Регистрация</span>
                                            </button>
                                        </c:if>

                                    </tr>
                                </table>
                            </form:form>
                    </section>

                </div>

            </div>
        </div>
    </div>

    <footer>
        <div class="container">
            <div style="padding: 10px 0pt 0pt 30px; clear: both; color: #8d1645; font-size: 15px;">Все права защищены &copy; <?=date ('Y')?></div>
        </div>
    </footer>
</div>
<script type="text/javascript">
    $(function(){
        $(".showpassword").each(function(index,input) {
            var $input = $(input);
            $("<p class='opt'/>").append(
                $("<input type='checkbox' class='showpasswordcheckbox' id='showPassword' />").click(function() {
                    var change = $(this).is(":checked") ? "text" : "password";
                    var rep = $("<input placeholder='Пароль' type='" + change + "' />")
                        .attr("id", $input.attr("id"))
                        .attr("name", $input.attr("name"))
                        .attr('class', $input.attr('class'))
                        .val($input.val())
                        .insertBefore($input);
                    $input.remove();
                    $input = rep;
                })
            ).append($("<label for='showPassword'/>").text("Показать пароль")).insertAfter($input.parent());
        });

        $('#showPassword').click(function(){
            if($("#showPassword").is(":checked")) {
                $('.icon-lock').addClass('icon-unlock');
                $('.icon-unlock').removeClass('icon-lock');
            } else {
                $('.icon-unlock').addClass('icon-lock');
                $('.icon-lock').removeClass('icon-unlock');
            }
        });
    });

    function checkPassword () {
        var pass = document.getElementById("password").value;
        var pass2 = document.getElementById("password2").value;
        if(pass !== pass2 ){
            alert('Ваши пароли не совпадают. Пожалуйста, повторите подтверждение пароля.');
            return false;
        }
        return true;
    }

    function loginTest() {
        var login = document.getElementById('loginField').value;
        <c:forEach items="${loginList}" var="loginFromList">
        if (login === '${loginFromList}'){
            var text = document.getElementById('info');
            text.innerHTML = "Введённый Вами логин уже используется. Пожалуйста, введите другой логин.";
            var a = document.createElement('a');
            a.href = "#modal";
            a.click();
            return false;
        }
        </c:forEach>
        return true;
    }

    function check() {
        if (loginTest() === true){
            if (checkPassword() === true)
                return true;
        }
        return false;
    }
</script>

<!-- Раскомментировать для jsp -->
<script src="${pageContext.request.contextPath}/resources/js/jquery.backstretch.min.js"></script>
<script>
    $.backstretch("${pageContext.request.contextPath}/resources/images/fon1.jpg");
</script>
<div id="modal" class="modalDialog">
    <div>
        <a href="#close" title="Закрыть" class="close">x</a>
        <h2>Оповещение</h2>
        <p></p>
        <p id="info"></p>
    </div>
</div>
</body>
</html>