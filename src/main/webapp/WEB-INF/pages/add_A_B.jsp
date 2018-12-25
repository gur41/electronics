<!-- <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib prefix="from" uri="http://www.springframework.org/tags/form" %>
<%@ page session="false" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %> -->
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
    <link rel="shortcut icon" href="<c:url value="/resources/images/fon1.jpg"/>" type="image/png">
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
                    <a href="<c:url value="/order_carrier"/>" target="_self">Заявки</a>
                </li>
                <%--<li class="">
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
                </li>--%>
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




                            <c:url var="addAction" value="/nextAB"/>

                            <form:form action="${addAction}" modelAttribute="mapsCarrier"  class="form-horizontal">

                                <c:if test="${currentMaps eq 0}">

                                <div class="form-group">
                                   <div>
                                       <label class="col-sm-2 control-label">
                                           <spring:message text="Начальная точка"/>
                                       </label>
                                       <label class="col-sm-2 control-label">
                                           <spring:message text="Конечная точка"/>
                                       </label>
                                   </div>
                                </div>
                                <div class="form-group">
                                    <label class="col-sm-2 control-label">
                                        <spring:message text="${routeCarrier.start}"/>
                                    </label>
                                    <div class="col-sm-2" class>
                                        <form:input path="endPointName" pattern="(.[a-zA-Zа-яА-Я\s,ёЁ_-]*)" title="Используйте латинские или русские символы." class="form-control"  />
                                    </div>
                                </div>

                                </c:if>


                                <c:if test="${currentMaps ne 0 && currentMaps ne routeCarrier.quantity}">

                                    <div class="form-group">
                                        <div>
                                            <label class="col-sm-2 control-label">
                                                <spring:message text="Начальная точка"/>
                                            </label>
                                            <label class="col-sm-2 control-label">
                                                <spring:message text="Конечная точка"/>
                                            </label>
                                        </div>
                                    </div>
                                    <div class="form-group">
                                        <label class="col-sm-2 control-label">
                                            <spring:message text="${start}"/>
                                        </label>
                                        <div class="col-sm-2" class>
                                            <form:input path="endPointName" pattern="(.[a-zA-Zа-яА-Я\s,ёЁ_-]*)" title="Используйте латинские или русские символы." class="form-control"  />
                                        </div>
                                    </div>

                                </c:if>

                                <c:if test="${currentMaps eq routeCarrier.quantity}">

                                    <div class="form-group">
                                        <div>
                                            <label class="col-sm-2 control-label">
                                                <spring:message text="Начальная точка"/>
                                            </label>
                                            <label class="col-sm-2 control-label">
                                                <spring:message text="Конечная точка"/>
                                            </label>
                                        </div>
                                    </div>
                                    <div class="form-group">
                                        <label class="col-sm-2 control-label">
                                            <spring:message text="${start}"/>
                                        </label>
                                        <label class="col-sm-2 control-label">
                                            <spring:message text="${routeCarrier.end}"/>
                                        </label>
                                    </div>

                                </c:if>





                                <div class="form-group">
                                    <form:label path="distance" class="col-sm-2 control-label">
                                        <spring:message text="Расстояние между точками"/>
                                    </form:label>
                                    <div class="col-sm-4">
                                        <form:input path="distance" pattern="^[+]?([0-9]*[.])?[0-9]+$" title="Введите число." class="form-control"/>
                                    </div>
                                </div>


                                <div class="form-group">
                                    <form:label path="nameOfTransport" class="col-sm-2 control-label">
                                        <spring:message text="Тип транспорта"/>
                                    </form:label>
                                    <div class="col-sm-4">
                                        <form:select path="nameOfTransport" class="form-control">
                                            <form:option value="Морской" />
                                            <form:option value="Железнодорожный" />
                                            <form:option value="Воздушный" />
                                            <form:option value="Автомобильный" />
                                        </form:select>
                                    </div>
                                </div>

                                <div class="form-group">
                                    <form:label path="speed" class="col-sm-2 control-label">
                                        <spring:message text="Скорость транспорта"/>
                                    </form:label>
                                    <div class="col-sm-4">
                                        <form:input path="speed" pattern="^[+]?([0-9]*[.])?[0-9]+$)" title="Введите число." class="form-control"/>
                                    </div>
                                </div>


                                <div class="form-group">
                                    <form:label path="maxWeight" class="col-sm-2 control-label">
                                        <spring:message text="Вместимость транспорта"/>
                                    </form:label>
                                    <div class="col-sm-4">
                                        <form:input path="maxWeight" pattern="^[+]?([0-9]*[.])?[0-9]+$)" title="Введите число." class="form-control"/>
                                    </div>
                                </div>

                                <div class="form-group">
                                    <form:label path="coefficient" class="col-sm-2 control-label">
                                        <spring:message text="Коэффициент"/>
                                    </form:label>
                                    <div class="col-sm-4">
                                        <form:input path="coefficient" pattern="^[+]?([0-9]*[.])?[0-9]+$)" title="Введите число." class="form-control"/>
                                    </div>
                                </div>

                                <div class="form-group">
                                    <form:label path="CostForHour" class="col-sm-2 control-label">
                                        <spring:message text="Цена за час использования транпорта"/>
                                    </form:label>
                                    <div class="col-sm-4">
                                        <form:input path="costForHour" pattern="^[+]?([0-9]*[.])?[0-9]+$)" title="Введите число." class="form-control"/>
                                    </div>
                                </div>



                                <c:if test="${currentMaps ne routeCarrier.quantity}">

                                <div class="form-group">
                                    <div class="col-sm-offset-2 col-sm-10">
                                        <input type="submit" class="btn btn-success"
                                               value="<spring:message text="Продолжить"/>"/>
                                    </div>
                                </div>
                                </c:if>

                                <c:if test="${currentMaps eq routeCarrier.quantity}">

                                    <div class="form-group">
                                        <div class="col-sm-offset-2 col-sm-10">
                                            <input type="submit" class="btn btn-success"
                                                   value="<spring:message text="Готово"/>"/>
                                        </div>
                                    </div>
                                </c:if>



                            </form:form>




                           <%--<table class="tg">
                               <tr>
                                   <th width="40">ID</th>
                                   <th width="120">Пункт отправления</th>
                                   <th width="170">Пункт назначения</th>
                                   <th width="40">Количество узловых точек</th>
                               </tr>
                               <c:forEach items="${listBouquets}" var="bouquet">
                                   <tr>
                                       <td>${bouquet.id}</td>
                                       <td>${bouquet.name}</td>
                                       <td>${bouquet.composition}</td>
                                       <td>${bouquet.height}</td>

                                       <td><a href="<c:url value='/editBouquet/${bouquet.id}'/>">Изменить</a></td>
                                       <td><a href="<c:url value='/removeBouquet/${bouquet.id}'/>">Удаление</a>
                                       </td>
                                   </tr>
                               </c:forEach>
                           </table>--%>


                        <%--<div class="headname">
                            <h1>Форма для данных</h1>
                        </div>--%>

                        <%--<c:url var="addAction" value="/bouquets/add"/>

                        <form:form action="${addAction}" commandName="bouquet" class="form-horizontal">

                            <c:if test="${!empty bouquet.name}">
                                <div class="form-group">
                                    <form:label path="id" class="col-sm-2 control-label">
                                        <spring:message text="ID"/>
                                    </form:label>
                                    <div class="col-sm-2">
                                        <form:input path="id" readonly="true" size="8" disabled="true"/>
                                        <form:hidden path="id" class="form-control"/>
                                    </div>
                                </div>
                            </c:if>
                            <div class="form-group">
                                <form:label path="name" class="col-sm-2 control-label">
                                    <spring:message text="Пункт отправления" />
                                </form:label>
                                <div class="col-sm-4">
                                    <form:input path="name" pattern="(.[a-zA-Zа-яА-Я\sё,Ё_-]*)" title="Используйте латинские или русские символы." class="form-control"/>
                                </div>
                            </div>
                            <div class="form-group">
                                <form:label path="composition" class="col-sm-2 control-label">
                                    <spring:message text="Пункт назначения"/>
                                </form:label>
                                <div class="col-sm-4">
                                    <form:input path="composition" pattern="(.[a-zA-Zа-яА-Я\s0-9,ёЁ_-]*)" title="Используйте латинские или русские символы." class="form-control"/>
                                </div>
                            </div>
                            <div class="form-group">
                                <form:label path="height" class="col-sm-2 control-label">
                                    <spring:message text="Количество узловых точек"/>
                                </form:label>
                                <div class="col-sm-2">
                                    <form:input path="height" pattern="^[+-]?([0-9]*[.])?[0-9]+$" title="Используйте число для ввода." class="form-control"/>
                                </div>
                            </div>
                    --%>
                      


                            <%--<div class="form-group">
                                <div class="col-sm-offset-2 col-sm-10">
                                    <c:if test="${!empty bouquet.name}">
                                        <input type="submit" class="btn btn-success"
                                               value="<spring:message text="Редактировать пукт"/>"/>
                                    </c:if>
                                    <c:if test="${empty bouquet.name}">
                                        <input type="submit" class="btn btn-success"
                                               value="<spring:message text="Добавить пункт"/>"/>
                                    </c:if>
                                </div>
                            </div>
                        </form:form>--%>
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
