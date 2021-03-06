<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib prefix="from" uri="http://www.springframework.org/tags/form" %>
<%@ page session="false" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Пункт прибытия/назначения</title>
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
    <script src="${pageContext.request.contextPath}/resources/js/modernizr.custom.63321.js"></script>
    <script src="${pageContext.request.contextPath}/resources/js/jquery-1.11.1.min.js"></script>
    <script src="${pageContext.request.contextPath}/resources/js/bootstrap.min.js"></script>
    <script src="${pageContext.request.contextPath}/resources/js/search.js"></script>
    <script src="${pageContext.request.contextPath}/resources/js/download.js"></script>
    <link rel="stylesheet" href="<c:url value="/resources/css/bootstrap.min.css" />"/>
    <link rel="stylesheet" href="<c:url value="/resources/css/font-awesome.min.css"/>"/>
    <link rel="stylesheet" href="<c:url value="/resources/css/menu_style.css"/>"/>
    <link rel="stylesheet" href="<c:url value="/resources/css/table.css" />"/>
    <link rel="stylesheet" href="<c:url value="/resources/css/modal.css" />"/>
    <link rel="shortcut icon" href="<c:url value="/resources/images/fon1.jpg"/>" type="image/png">
    <%--<link rel="stylesheet" href="<c:url value="/resources/css/form.css" />"/>
    <link rel="stylesheet" href="<c:url value="/resources/css/client.css" />"/>
    <link rel="stylesheet" href="<c:url value="/resources/css/modal.css" />"/>--%>

</head>
<body>

<!-- ///////////////////////////////////////////////// -->
<div class="container">
    <div class="header">
        <div class="row">
            <div class="col-md-8">
                <div class="name">
                    TECHNOLAND
                </div>
            </div>

            <div class="col-md-4">
                <form class="navbar-form navbar-left" role="search">
                    <input type="text" id="text-to-find" value="" class="form-control" placeholder="Найти">
                    <button type="submit" class="btn btn-default"
                            onclick="javascript: FindOnPage('text-to-find'); return false;">
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
                <li class="">
                    <a href="<c:url value="/"/>" target="_self">Главная</a>
                </li>
                <c:choose>
                    <c:when test="${user.login ne null}">
                        <li class="">
                            <a href="<c:url value="/show_my_orders"/>" target="_self">Мои заявки</a>
                        </li>
                    </c:when>
                    <c:otherwise>
                    </c:otherwise>
                </c:choose>

            </ul>
            <ul class="nav navbar-nav navbar-right">
                <li class="dropdown">
                    <a href="<c:url value="/users/currentUser"/>" class="dropdown-toggle" data-toggle="dropdown"
                       role="button" aria-expanded="false">
                        <c:choose>
                            <c:when test="${user.login ne null}">
                                ${user.login}
                            </c:when>
                            <c:otherwise>
                                Мой профиль
                            </c:otherwise>
                        </c:choose>
                        <span class="caret"></span>
                    </a>
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

<br>
<div class="mybody">
    <div class="container">
        <div class="article container">
            <div class="row otstup">
                <div class="col-md-12">
                    <h1 class="h2 page-header"
                        style="color:#8d1645; font-family: 'Lobster', cursive; margin-top: -1px;
                        text-align: center;">Ноутбуки</h1>
                    <section class="main">


                        <%--<div class="headname">
                            <h1>Ноутбуки</h1>
                        </div>--%>


                        <c:if test="${!empty listNote}">
                            <table class="tg">
                                <%--<tr>
                                    <th width="240">Картинка</th>
                                    <th width="120">Название</th>
                                    <th width="120">Описание</th>
                                    <th width="120">Цена</th>
                                    <th width="60">Удалить</th>
                                    <th width="240">Удалить</th>
                                </tr>--%>
                                <c:set var="j" value="0"/>
                                <c:forEach items="${listNote}" var="note">
                                    <tr>
                                        <c:set var="nm" value="getPicture${j=j+1}"/>
                                        <c:choose>
                                            <c:when test="${user.login ne null}">
                                                <td><a href="<c:url value='/noteOne/${note.id}'/>">${note.name}</a></td>
                                            </c:when>
                                            <c:otherwise>
                                                <td><a href="<c:url value='/noteOneAdmin/${note.id}'/>">${note.name}</a></td>
                                            </c:otherwise>
                                        </c:choose>
                                        <td><c:set var="nm" value="getPicture${j=j+1}"/>
                                            <div class="col-md-2" id="${nm}">
                                                <script>
                                                    var adress = "/resources/images/";
                                                    var img = document.createElement('img');
                                                    img.setAttribute('src', adress + "${note.photo}");
                                                    img.height = 150;
                                                    document.getElementById("${nm}").appendChild(img);
                                                </script>
                                            </div>
                                        </td>
                                        <td>${note.info}</td>
                                        <td>${note.price}</td>

                                    </tr>
                                </c:forEach>
                            </table>
                        </c:if>

                        <c:if test="${empty listNote}">
                            <div class="headname">
                                <h1>Список ноутбуков пуст</h1>
                            </div>
                        </c:if>

                    </section>

                </div>
            </div>
        </div>
    </div>

    <footer>
        <div class="container">
            <div style="padding: 10px 0pt 0pt 30px; clear: both; color: #8d1645; font-size: 15px;">Все права защищены
                &copy; <?=date ('Y')?></div>
        </div>
    </footer>
</div>
<<!-- Раскомментировать для jsp -->
<script src="${pageContext.request.contextPath}/resources/js/jquery.backstretch.min.js"></script>
<script>
    $.backstretch("resources/images/fon1.jpg");
</script>
</body>
</html>
