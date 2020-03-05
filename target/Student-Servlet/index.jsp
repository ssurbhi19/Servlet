<html>
<body>

<form action="addStudents" method="post">
    Enter roll number : <input type="text" name="roll_no">
    Enter name : <input type="text" name="name">
    Enter University : <input type="text" name="univ" >
    <input type="submit">
</form>

<form action= "searchStudents" method="get">
Enter roll no to check : <input type="text" name="check" required>
<input type="submit" name="GetDataFromDoGet">

</form>
</form>

<form action= "searchStudentsFromProperties" method="get">
Enter roll no to check : <input type="text" name="check" required>
<input type="submit" name="GetDataFromProperty">

</form>
</body>
</html>
