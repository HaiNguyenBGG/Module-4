<!DOCTYPE html>
<html xmlns:th="http://www.thymeleaf.org">
<head>
  <title>Selected Condiments</title>
</head>
<body>
<h2>Your selected condiments:</h2>
<ul>
  <li th:each="condiment : ${selectedCondiments}" th:text="${condiment}"></li>
</ul>
</body>
</html>
