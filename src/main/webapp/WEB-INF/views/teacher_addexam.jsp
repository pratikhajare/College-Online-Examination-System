<!DOCTYPE html>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %> 
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>${name}</title>

    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-beta.2/css/bootstrap.min.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.6/umd/popper.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-beta.2/js/bootstrap.min.js"></script>
    <script type="text/javascript" src="https://cdnjs.cloudflare.com/ajax/libs/bootstrap-datepicker/1.4.1/js/bootstrap-datepicker.min.js"></script>

    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/home.css">
    <script >
      $(document).ready( function () {
      $('.datepicker').datepicker({
          format: 'dd-mm-yyyy'
        });
    } );
    </script>

  </head>
<body>
        <jsp:include page="common views/header.jsp"/>
        <jsp:include page="common views/teacher_navbar.jsp"/>
        <div id="name">${name}</div>
      <br>
      
  <c:choose>  
    <c:when test="${flag==true}">  
      <div class="alert alert-success">  
        ${success}
      </div>
    </c:when>  
    <c:when test="${flag==false}">  
      <div class="alert alert-warning">  
        ${error}
      </div>  
    </c:when>  
</c:choose>  

        <div class="container">    
            <form class="form-horizontal" role="form" style="width: 75%;" action="${pageContext.request.contextPath}/teacherpage/addexam" method="POST">  
              <div class="form-group">   
                <div class="col-sm-10">  
                  <select class="browser-default custom-select required" name="selExam" required>
                    <option selected value="0">Select Exam</option>
                    <option value="${c1}" >${course1}</option>
                    <option value="${c2}">${course2}</option>
                  </select> 
                </div> 
              
              </div>

              <div class="form-group">  
                <label class="control-label col-sm-2" for="examdate">Exam Date:</label>  
                <div class="col-sm-10"> 
                  <input type="date" class="form-control bootstrap-datepicker " value="${exam.examdate}" name="examdate" id="examdate" placeholder="Select Exam Date" required/>  
                </div>  
              </div>  

              <div class="form-group">  
                <label class="control-label col-sm-2" for="validdate">Valid Till Date:</label>  
                <div class="col-sm-10">  
                  <input type="date" class="form-control bootstrap-datepicker" value="${exam.dateValid}" name="validdate" id="validdate" placeholder="Select Exam End Date" required>  
                </div>  
              </div>  

              <div class="form-group">  
                <label class="control-label col-sm-2" for="starttime">Start Time:</label>  
                <div class="col-sm-10">  
                  <input type="time" class="form-control time" name="starttime" value="${exam.starttime}" id="starttime" placeholder="Enter start time" required>  
                </div>  
              </div>  

              <div class="form-group">  
                <label class="control-label col-sm-2" for="endtime">End Time:</label>  
                <div class="col-sm-10">  
                  <input type="time" class="form-control time" name="endtime" value="${exam.endTime}" id="endtime" placeholder="Enter end time" required>  
                </div>  
              </div>  
              
              <div class="form-group">  
                <label class="control-label col-sm-2" for="duration">Exam Duration:</label>  
                <div class="col-sm-10">            
                  <input type="text" class="form-control" name="duration" value="${exam.duration}" id="duration" placeholder="Enter hrs" required>  
                </div>  
              </div>
              
            <div class="form-group">          
                <div class="col-sm-offset-2 col-sm-10">  
                  <button type="submit" class="btn btn-primary" >Submit</button>&nbsp;
                  <button type="reset" class="btn btn-primary">Reset</button>    
                </div>
              </div>  
            </form>  
          </div>  

</body>
</html>