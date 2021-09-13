<!DOCTYPE html>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Successfully Submitted</title>

    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.0/jquery.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"></script>
    <script type="text/javascript" src="https://cdnjs.cloudflare.com/ajax/libs/twitter-bootstrap/4.0.0/js/bootstrap.bundle.min.js"></script>

    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/startexam.css">
</head>
<body>

    <div class="container mt-sm-5 my-1">
        <div>
        <p style="text-align: center;">Exam Submitted Successfully !!</p>
        </div>
        <div class="d-flex align-items-center pt-3">
            <div class="ml-auto mr-sm-5" ><a href="${pageContext.request.contextPath}/studentpage/resultlist"><button style="align-content:center;" class="btn btn-success">Go To Results</button></a></div>
        </div>
    </div>
</body>
</html>