<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>${name}</title>

    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-beta.2/css/bootstrap.min.css">
    <script src="${pageContext.request.contextPath}/jquery/jquery-3.3.1.min.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.6/umd/popper.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-beta.2/js/bootstrap.min.js"></script>

    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/home.css">

</head>
<body>
    <jsp:include page="common views/header.jsp"/>
    <jsp:include page="common views/teacher_navbar.jsp"/>
    <div id="name">${name}<span style="float: right; padding-right: 20px;" id="examname">Exam Name:${examname}</span> </div><br>

    <div class="container">    
        <form class="form-horizontal" role="form" style="width: 75%;" action="${pageContext.request.contextPath}/addquestion/save" method="POST">   
          
          <div class="form-group">  
            <label class="control-label col-sm-2" for="question">Question:</label>  
            <div class="col-sm-10">            
              <input type="text" class="form-control" name="question" id="question" placeholder="Enter question">  
            </div>  
          </div>
          
          <div class="form-group">  
            <label class="control-label col-sm-2" for="ans1">Option 1:</label>  
            <div class="col-sm-10">            
              <input type="text" class="form-control" name="ans1" id="ans1" placeholder="Enter answer 1">  
            </div>  
          </div>

          <div class="form-group">  
            <label class="control-label col-sm-2" for="ans2">Option 2:</label>  
            <div class="col-sm-10">            
              <input type="text" class="form-control" name="ans2" id="ans2" placeholder="Enter answer 2">  
            </div>  
          </div>

          <div class="form-group">  
            <label class="control-label col-sm-2" for="ans1">Option 3:</label>  
            <div class="col-sm-10">            
              <input type="text" class="form-control" name="ans3" id="ans3" placeholder="Enter answer 3">  
            </div>  
          </div>

          <div class="form-group">  
            <label class="control-label col-sm-2" for="ans4">Option 4:</label>  
            <div class="col-sm-10">            
              <input type="text" class="form-control" name="ans4" id="ans4" placeholder="Enter answer 4">  
            </div>  
          </div>
          
          <div class="form-group">  
            <label class="control-label col-sm-2" for="correctAns">Correct Answer:</label>  
            <div class="col-sm-10">            
              <input type="text" class="form-control" name="correctAns" id="correctAns" placeholder="Enter Correct Answer">  
            </div>  
          </div>
          <div class="form-group">  
            <label class="control-label col-sm-2" for="marks">Enter Marks:</label>  
            <div class="col-sm-10">            
              <input type="text" class="form-control" name="marks" id="marks" placeholder="Enter Marks">  
            </div>  
          </div>
        <div class="form-group">          
            <div class="col-sm-offset-2 col-sm-10">  
              <button type="submit" class="btn btn-secondary">Save</button> &nbsp;
            </div>
          </div>  
          </div>
        </form>  
        <div class="col-sm-offset-2 col-sm-10">
        <a href="${pageContext.request.contextPath}/addquestion/addAllQuestions" style="padding-left: 75px;"><button type="button" class="btn btn-primary">Add Questions</button></a>
        <a href="${pageContext.request.contextPath}/addquestion/viewAllQuestions" style="padding-left: 75px;"><button type="button" class="btn btn-primary">View All Questions</button></a>
        </div>
      </div>  
    
</body>
</html>