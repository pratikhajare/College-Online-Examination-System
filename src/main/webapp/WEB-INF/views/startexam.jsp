<!DOCTYPE html>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>${exam.examname}</title>
    <input type="hidden" value="${exam.duration}" id="duration"/>
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
    <jsp:include page="common views/examnavbar.jsp"/>
    <hr style=" background-color:grey">

    <c:choose>
        <c:when test="${flag==true}">
          <div class="alert alert-success container text-center" style="width: 600px;">${success}</div>
          </c:when>
          <c:when test="${flag==false}">
          <div class="alert alert-danger container text-center" style="width: 600px;">${error}</div>
          </c:when>
      </c:choose>
    <div id="timer" class="flex-wrap d-flex justify-content-center">
        <div id="hours" class="align-items-center flex-column d-flex justify-content-center"></div>
        <div id="minutes" class="align-items-center flex-column d-flex justify-content-center"></div>
        <div id="seconds" class="align-items-center flex-column d-flex justify-content-center"></div>
    </div>

    <div class="container mt-sm-5 my-1">
        <form action="${pageContext.request.contextPath}/startexam/submitquestion/${question.que_id}" method="POST">
        <p id="queNo">Questions : <span id="queno">${queNo}</span> / ${exam.noOfQuestions}</p>
        <p >Marks : ${question.marks}</p>
        <div class="question ml-sm-5 pl-sm-5 pt-2">
            <div class="py-2 h5"><b>${queNo}. ${question.question}</b>
            </div>
            <div class="ml-md-3 ml-sm-3 pl-md-5 pt-sm-0 pt-3" id="options"> 
                <label class="options">${question.ans1}<input type="radio" value="${question.ans1}" name="answer"> 
                    <span class="checkmark"></span> </label> 
                <label class="options">${question.ans2}<input type="radio" value="${question.ans2}" name="answer"> 
                    <span class="checkmark"></span> </label> 
                <label class="options">${question.ans3}<input type="radio" value="${question.ans3}" name="answer"> 
                    <span class="checkmark"></span> </label> 
                <label class="options">${question.ans4}<input type="radio" value="${question.ans4}" name="answer"> 
                    <span class="checkmark"></span> </label> 
            </div>
        </div>
        <div class="d-flex align-items-center pt-3">
            <c:choose>  
                <c:when test="${queNo==1}">  
                    <div id="prev"><a href="${pageContext.request.contextPath}/startexam/previous" class="btn btn-success disabled" id="prevlink">Previous</a></div>
            
                    <div class="ml-auto mr-sm-5"> <button type="submit" class="btn btn-success">Submit</button>
                        <a id="nextlink" href="${pageContext.request.contextPath}/startexam/next" class="btn btn-success">Next</a> </div>
                </c:when>  
                <c:when test="${queNo==exam.noOfQuestions}">  
                    <div id="prev"><a href="${pageContext.request.contextPath}/startexam/previous" class="btn btn-success" id="prevlink">Previous</a></div>
            
            <div class="ml-auto mr-sm-5"> <button type="submit" class="btn btn-success">Submit</button>
                <a id="nextlink" href="${pageContext.request.contextPath}/startexam/next" class="btn btn-success disabled">Next</a> </div>
                </c:when>  
                <c:otherwise>  
                    <div id="prev"><a href="${pageContext.request.contextPath}/startexam/previous" class="btn btn-success" id="prevlink">Previous</a></div>
            
                    <div class="ml-auto mr-sm-5"> <button type="submit" class="btn btn-success">Submit</button>
                        <a id="nextlink" href="${pageContext.request.contextPath}/startexam/next" class="btn btn-success">Next</a> </div>  
                </c:otherwise>  
            </c:choose>  
        </div>
        </form>
    </div>

    <div>        
        <div id="submittest" class="text-right"><a href="${pageContext.request.contextPath}/startexam/submittest"><button id="submitexam" class="btn btn-success" type="submit">Submit Test</button></a>
            <hr style=" background-color:grey; width:100%">
    </div>
</body>
</html>