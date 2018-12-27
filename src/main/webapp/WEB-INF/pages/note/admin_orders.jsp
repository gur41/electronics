<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib prefix="from" uri="http://www.springframework.org/tags/form" %>
<%@ page session="false" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Пункт прибытия/назначения</title>
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
    <link rel="stylesheet" href="<c:url value="/resources/css/order.css" />" />
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
                <li class="">
                    <a href="<c:url value="/note_all"/>" target="_self">Ноутбуки</a>
                </li>

                <li class="">
                    <a href="<c:url value="/note_admin"/>" target="_self">Добавить ноутбук</a>
                </li>

                <li class="">
                    <a href="<c:url value="/admin_orders"/>" target="_self">Заявки</a>
                </li>
                <%-- <li class="">
                    <a href="<c:url value="/flowers_admin"/>" target="_self">Цветы</a>
                </li>
                <li class="">
                    <a href="<c:url value="/bouquets_admin"/>" target="_self">Букеты</a>
                </li>
                <li class="">
                    <a href="<c:url value="/compositions_admin"/>" target="_self">Копмозиции</a>
                </li>
                <li class="">
                    <a href="<c:url value="/packs_admin"/>" target="_self">Упаковки</a>
                </li>
                <li class="">
                    <a href="<c:url value="/decorations_admin"/>" target="_self">Украшения</a>
                </li> --%>
            </ul>
            <ul class="nav navbar-nav navbar-right">
                 <li class="dropdown">
                    <a href="<c:url value="/users/currentUser"/>" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-expanded="false">
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
                        text-align: center;">Пункт прибытия/назначения</h1>
                    <section class="main">


                        <div class="headname">
                            <h1>Список заявок</h1>
                        </div>

                        <c:if test="${!empty listOrderUserElectronics}">
                            <table class="tg">
                                <tr>
                                    <th width="40">ID</th>
                                    <th width="80">Фамилия</th>
                                    <th width="80">Имя</th>
                                    <th width="80">Номер телефона</th>
                                    <th width="80">E-mail</th>
                                    <th width="120">Цена</th>
                                    <th width="120">Название товара</th>
                                    <th width="120">Статус</th>
                                </tr>
                                <c:forEach items="${listOrderUserElectronics}" var="order">
                                    <tr>
                                        <td>${order.idOrder}</td>
                                        <td>${order.secondName}</td>
                                        <td>${order.firstName}</td>
                                        <td>${order.phone}</td>
                                        <td>${order.eMail}</td>
                                        <td>${order.price}</td>
                                        <td>${order.name}</td>
                                        <td>
                                            <div class="fir2">
                                            <li class="dropdown show">
                                                <a href="<c:url value="/users/currentUser"/>" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-expanded="false">
                                                            ${order.status}
                                                    <span class="caret"></span>
                                                </a>
                                                <ul class="dropdown-menu" role="menu">
                                                    <li class="divider"></li>
                                                    <c:choose>
                                                        <c:when test="${order.status eq 'Оформлена'}">
                                                            <li><a href="<c:url value="/changeStatusForElectronnicOrder/${order.idOrder}${'_Принята'}"/>" target="_self">Принята</a></li>
                                                            <li><a href="<c:url value="/changeStatusForElectronnicOrder/${order.idOrder}${'_ Выполняется'}"/>" target="_self">Выполняется</a></li>
                                                            <li><a href="<c:url value="/changeStatusForElectronnicOrder/${order.idOrder}${'_Выполнена'}"/>" target="_self">Выполнена</a></li>
                                                        </c:when>
                                                        <c:when test="${order.status eq 'Принята'}">
                                                            <li><a href="<c:url value="/changeStatusForElectronnicOrder/${order.idOrder}${'_Выполняется'}"/>" target="_self">Выполянется</a></li>
                                                            <li><a href="<c:url value="/changeStatusForElectronnicOrder/${order.idOrder}${'_Выполнена'}"/>" target="_self">Выполнена</a></li>
                                                        </c:when>
                                                        <c:when test="${order.status eq 'Выполняется'}">
                                                            <li><a href="<c:url value="/changeStatusForElectronnicOrder/${order.idOrder}${'_Выполнена'}"/>" target="_self">Выполнена</a></li>
                                                        </c:when>
                                                    </c:choose>
                                                </ul>
                                            </li>
                                            </div>
                                        </td>
                                    </tr>
                                </c:forEach>
                            </table>
                        </c:if>

                        <c:if test="${empty listOrderUserElectronics}">
                            <div class="headname">
                                <h1>Список заявок пуст</h1>
                            </div>
                        </c:if>

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
<<!-- Раскомментировать для jsp -->
<script src="${pageContext.request.contextPath}/resources/js/jquery.backstretch.min.js"></script>
<script>
    $.backstretch("resources/images/fon1.jpg");
</script>
</body>
</html>