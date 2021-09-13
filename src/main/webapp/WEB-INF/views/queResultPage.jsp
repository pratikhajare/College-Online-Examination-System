<!DOCTYPE html>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>${exam.examname}</title>

    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.0/jquery.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"></script>
    <script type="text/javascript" src="https://cdnjs.cloudflare.com/ajax/libs/twitter-bootstrap/4.0.0/js/bootstrap.bundle.min.js"></script>

    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/startexam.css">
    <script type="text/javascript" src="${pageContext.request.contextPath}/js/examtimer.js"></script>
</head>
<body>
    <hr style=" background-color:grey">
    <div id="examnavbar" class="page-header">
        <h6>Result Status : Pass</h6>
        <h6>Marks Obtained : ${result.gotMarks} / ${exam.totalMarks}</h6>
        <h4>Exam Name : ${exam.examname}</h4>
       </div>
    <hr style=" background-color:grey">
    <c:set var="queNo" scope="session" value="${0}"/>  
    <div class="container mt-sm-5 my-1">
        <p id="queNo">Total Questions : ${exam.noOfQuestions}</p>
        <c:forEach items="${questionlist}" var="question" varStatus="status">      
        <div class="question ml-sm-5 pl-sm-5 pt-2">
            <div class="py-2 h5"><b>${queNo=queNo+1}. ${question.question}</b>
            </div>
            <div class="ml-md-3 ml-sm-3 pl-md-5 pt-sm-0 pt-3" id="options"> 
                <label class="options">${question.ans1}<input type="radio" id="ans1" value="${question.ans1}" name="answer"> 
                    <span class="checkmark"></span> </label> 
                <label class="options">${question.ans2}<input type="radio" id="ans2" value="${question.ans2}" name="answer"> 
                    <span class="checkmark"></span> </label> 
                <label class="options">${question.ans3}<input type="radio" id="ans3" value="${question.ans3}" name="answer"> 
                    <span class="checkmark"></span> </label> 
                <label class="options">${question.ans4}<input type="radio" id="ans4" value="${question.ans4}" name="answer"> 
                    <span class="checkmark"></span> </label>
            </div>
            <p>Selected Answer : <span style="color: rgb(102, 236, 102); font-size: 20px;">${resultlist[status.index].selAns}</span></p>
            <p>Correct Answer : <span style="color: rgb(102, 236, 102); font-size: 20px;">${question.correctAns}</span></p>
        </div>

        <div class="d-flex align-items-center pt-3">
            <div id="prev"></div>
            
            <div class="ml-auto mr-sm-5"></div>
        </div>
    </c:forEach>
    </div>

    <div>        
        <div  style="text-align: center;"><a href="${pageContext.request.contextPath}/studentpage/resultlist"><button id="submitexam" class="btn btn-success" type="button">Go Back</button></a>
            <hr style=" background-color:grey; width:100%">
    </div>
</body>
</html>