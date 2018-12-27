<%--
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
  <title>Список пользователей</title>
    <style type="text/css">

        h1{
            color:yellow;
        }
        h3{
            color: red;
        }
        body{
            background: lightblue;
        }
    </style>
</head>
<body>
<h3></h3>
<br/>
<h1>Список пользователй</h1>
<h3><a href="<c:url value="/citys"/>" target="_blank">Города</a> </h3><br>
<h3><a href="<c:url value="/users"/>" target="_blank">Пользователи</a></h3>
<br/>
</body>
</html>--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
  <meta charset="UTF-8"/>
  <title>Главная страница</title>


  <%--script src="resources/js/modernizr.custom.63321.js"></script>
  <script src="resources/js/jquery-1.11.1.min.js"></script>
  <script src="resources/js/bootstrap.min.js"></script>

  <link rel="stylesheet" href="resources/css/bootstrap.min.css" />
  <link rel="stylesheet" href="resources/css/font-awesome.min.css" />
  <link rel="stylesheet" href="resources/css/menu_style.css" />
  <link rel="stylesheet" href="resources/css/table.css" />
  <link rel="stylesheet" href="resources/css/dopstyle.css" />
  <link rel="stylesheet" href="resources/css/autor_style.css" />--%>
  <!-- Раскомментировать для jsp -->
  <link rel="stylesheet" type="text/css" href="<c:url value="/resources/css/autor_style.css" />"/>
    <script src="${pageContext.request.contextPath}/resources/js/modernizr.custom.63321.js"></script>
    <script src="${pageContext.request.contextPath}/resources/js/jquery-1.11.1.min.js"></script>
    <script src="${pageContext.request.contextPath}/resources/js/bootstrap.min.js"></script>

    <link rel="stylesheet" href="<c:url value="/resources/css/bootstrap.min.css" />"/>
    <link rel="stylesheet" href="<c:url value="/resources/css/font-awesome.min.css"/>"/>
    <link rel="stylesheet" href="<c:url value="/resources/css/menu_style.css"/>"/>
    <link rel="stylesheet" href="<c:url value="/resources/css/table.css" />"/>
    <link rel="stylesheet" href="<c:url value="/resources/css/dopstyle.css" />"/>
    <link rel="shortcut icon" href="<c:url value="/resources/images/fon1.jpg"/>" type="image/png">
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

      <div class="col-md-4">

        <form class="navbar-form navbar-left" role="search">
          <div class="form-group">
            <input type="text" class="form-control" placeholder="Найти">
          </div>
          <button type="submit" class="btn btn-default">
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
        <%--<span class="sr-only">Toggle navigation</span>--%>
        <span class="icon-bar"></span>
        <span class="icon-bar"></span>
        <span class="icon-bar"></span>
        <span class="icon-bar"></span>
        <span class="icon-bar"></span>
      </button>

    </div>

    <div class="collapse navbar-collapse" id="navbar-collapse">
      <ul class="nav navbar-nav">
        <li class="">
          <a href="<c:url value="/client_note_all"/>" target="_self">Ноутбуки</a>
        </li>
        <li class="">
          <%--<!-- <a href="<c:url value="/bouquets_client"/>" target="_self">Букеты</a> -->--%>
        </li>
        <li class="">
          <%--<!-- <a href="<c:url value="/compositions_client"/>" target="_self">Копмозиции</a> -->--%>
        </li>
        <li class="">
          <%--<!-- <a href="<c:url value="/customer_bouquets"/>" target="_self">Составить букет</a> -->--%>
        </li>
      </ul>
      <ul class="nav navbar-nav navbar-right">
        <li class="dropdown">
          <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-expanded="false">Мой
            профиль<span class="caret"></span></a>
          <ul class="dropdown-menu" role="menu">
            <li class="divider"></li>
            <li><a href="<c:url value="/autorization"/>" target="_self">Вход</a></li>
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
      <div class="row">
        <div class="row otstup">
          <div class="col-md-2"></div>
          <div class="col-md-8">
            <div id="carousel-example-generic" class="carousel slide" data-ride="carousel">
              <!-- Indicators -->
              <ol class="carousel-indicators">
                <li data-target="#carousel-example-generic" data-slide-to="0" class="active"></li>
                <li data-target="#carousel-example-generic" data-slide-to="1"></li>
                <li data-target="#carousel-example-generic" data-slide-to="2"></li>
                <li data-target="#carousel-example-generic" data-slide-to="3"></li>
                <li data-target="#carousel-example-generic" data-slide-to="4"></li>
              </ol>

              <!-- Wrapper for slides -->
              <div class="carousel-inner">
                <div class="item active">
                  <img src="resources/images/img4.jpg" alt="...">
                  <div class="carousel-caption">

                    <p><em>Ноутбуки</em></p>
                  </div>
                </div>

                <div class="item">
                  <img src="resources/images/img3.jpg" alt="...">
                  <div class="carousel-caption">

                    <p><em>Мобильные телефоны</em></p>
                  </div>
                </div>



                <div class="item">
                  <img src="resources/images/img1.jpg" alt="...">
                  <div class="carousel-caption">

                    <p><em>Электронные книги</em></p>
                  </div>
                </div>

                <div class="item">
                  <img src="resources/images/img2.jpg" alt="...">
                  <div class="carousel-caption">
                    <p><em>Телевизоры</em></p>
                  </div>
                </div>

              </div>

              <!-- Controls -->
              <a class="left carousel-control" href="#carousel-example-generic" data-slide="prev">
                <span class="glyphicon glyphicon-chevron-left"></span>
              </a>
              <a class="right carousel-control" href="#carousel-example-generic" data-slide="next">
                <span class="glyphicon glyphicon-chevron-right"></span>
              </a>
            </div>
          </div>

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
<script type="text/javascript">
    $(function () {
        $(".showpassword").each(function (index, input) {
            var $input = $(input);
            $("<p class='opt'/>").append(
                $("<input type='checkbox' class='showpasswordcheckbox' id='showPassword' />").click(function () {
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

        $('#showPassword').click(function () {
            if ($("#showPassword").is(":checked")) {
                $('.icon-lock').addClass('icon-unlock');
                $('.icon-unlock').removeClass('icon-lock');
            } else {
                $('.icon-unlock').addClass('icon-lock');
                $('.icon-lock').removeClass('icon-unlock');
            }
        });
    });

</script>
<!-- Раскомментировать для jsp -->
<script src="${pageContext.request.contextPath}/resources/js/jquery.backstretch.min.js"></script>
<script>
    $.backstretch("resources/images/fon1.jpg");
</script>
<script src="https://code.jquery.com/jquery-1.10.2.min.js"></script>
</body>
</html>