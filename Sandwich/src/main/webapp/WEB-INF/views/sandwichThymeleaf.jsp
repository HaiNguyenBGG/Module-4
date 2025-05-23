<!DOCTYPE html>
<html xmlns:th="http://www.thymeleaf.org">
<head>
    <title>Sandwich Selection</title>
</head>
<body>
<h2>Choose your condiments:</h2>
<form action="#" th:action="@{/save}" method="post">
    <label><input type="checkbox" name="condiment" value="Lettuce"> Lettuce</label>
    <label><input type="checkbox" name="condiment" value="Tomato"> Tomato</label>
    <label><input type="checkbox" name="condiment" value="Mustard"> Mustard</label>
    <label><input type="checkbox" name="condiment" value="Sprouts"> Sprouts</label>
    <br><br>
    <input type="submit" value="Submit">
</form>
</body>
</html>
