<!DOCTYPE html>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-beta.2/css/bootstrap.min.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.6/umd/popper.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-beta.2/js/bootstrap.min.js"></script>

    <style>
        .gradient-custom {
  /* fallback for old browsers */
  background: #f093fb;

  /* Chrome 10-25, Safari 5.1-6 */
  background: -webkit-linear-gradient(to bottom right, rgba(240, 147, 251, 1), rgba(245, 87, 108, 1));

  /* W3C, IE 10+/ Edge, Firefox 16+, Chrome 26+, Opera 12+, Safari 7+ */
  background: linear-gradient(to bottom right, rgba(240, 147, 251, 1), rgba(245, 87, 108, 1))
}

.card-registration .select-input.form-control[readonly]:not([disabled]) {
  font-size: 1rem;
  line-height: 2.15;
  padding-left: .75em;
  padding-right: .75em;
}
.card-registration .select-arrow {
  top: 13px;
}
    </style>
    <title>Registration Page</title>
</head>
<body class="vh-100 gradient-custom">
    <section class="vh-100 gradient-custom">

        <c:choose>
        <c:when test="${err==true}">
          <div class="alert alert-success container text-center" style="width: 600px;">${success}</div>
          </c:when>
          <c:when test="${err==false}">
          <div class="alert alert-danger container text-center" style="width: 600px;">${error}</div>
          </c:when>
      </c:choose>

        <div class="container py-5 h-100">
          <div class="row justify-content-center align-items-center h-100">
            <div class="col-12 col-lg-9 col-xl-7">
              <div class="card shadow-2-strong card-registration" style="border-radius: 15px;">
                <div class="card-body p-4 p-md-5">
                  <h3 class="mb-4 pb-2 pb-md-0 mb-md-5">Registration Form</h3>
                  <c:choose>
                    <c:when test="${isVerified==true}">
                        <form action="${pageContext.request.contextPath}/signup" method="POST">
                    </c:when>
                    <c:otherwise>
                        <form action="${pageContext.request.contextPath}/signup/verify" method="GET">
                    </c:otherwise>
                </c:choose>
                  
                    
                    <div class="row">      
                        <div class="col-md-6 mb-4">
                            <div class="form-outline">
                              <input type="text" id="regID" value="${regid}" name="regid" class="form-control form-control-lg" placeholder="Enter Registration ID:" required />                              
                            </div>
                        </div>
                        <div class="col-md-6 mb-4">
                            <div class="form-outline">
                                <c:choose>
                                <c:when test="${isVerified==true}">
                                    <button class="btn btn-primary btn-lg disabled" type="submit">Verify</button>
                                </c:when>
                                <c:otherwise>
                                    <button class="btn btn-primary btn-lg" type="submit">Verify</button>
                                </c:otherwise>
                            </c:choose>
                            </div>
                        </div>
                    </div>

                    <c:if test="${isVerified==true}">
                        <c:if test="${flag==true}">
                    <div class="row">
                      <div class="col-md-6 mb-4">
                        <div class="form-outline"> 
                          <input type="text" value="${student.name.fname}" name="firstname" placeholder="First Name" class="form-control form-control-lg" readonly/>  
                        </div>
                      </div>
                      <div class="col-md-6 mb-4">
      
                        <div class="form-outline">
                          <input type="text" name="lastname" value="${student.name.lname}" placeholder="Last Name" class="form-control form-control-lg"  readonly/>
                        </div>
      
                      </div>
                    </div>

                    <div class="row">
                        <div class="col mb-4">
                          <div class="form-outline"> 
                            <input type="text" id="year" value="${student.year}" placeholder="Current Year" name="year" class="form-control form-control-lg" readonly/>  
                          </div>
                        </div>

                        <div class="col mb-4">
                          <div class="form-outline">
                            <input type="text" id="div" value="${student.division}" placeholder="Division"  name="division" class="form-control form-control-lg" readonly/>
                          </div>
                        </div>
                        <div class="col mb-4">
                        <div class="form-outline">
                            <input type="text" id="rollno" value="${student.rollno}" placeholder="Roll No."  name="rollno" class="form-control form-control-lg" readonly/>
                          </div>
                        </div>
                    </div>

                    <div class="row">
                        <div class="col-md-6 mb-4 pb-2">
        
                          <div class="form-outline">
                            <input type="email" id="emailAddress" value="${student.email}" name="email" placeholder="Email" class="form-control form-control-lg" readonly/>
                          </div>
        
                        </div>
                        <div class="col-md-6 mb-4 pb-2">
                          <c:choose>
                            <c:when test="${student.dept_id==101}">
                                <c:set var="deptname" value="ENTC"></c:set>
                            </c:when>
                            <c:when test="${student.dept_id==102}">
                                <c:set var="deptname" value="IT"></c:set>
                            </c:when>
                            <c:when test="${student.dept_id==103}">
                                <c:set var="deptname" value="CS"></c:set>
                            </c:when>
                            </c:choose>
                          <div class="form-outline">
                            <input type="tel" id="deptname" value="${deptname}" placeholder="Department Name" name="deptname" class="form-control form-control-lg" readonly/>
                          </div>
        
                        </div>
                      </div>
                </c:if>
                
                <c:if test="${flag==false}">
                    <div class="row">
                      <div class="col-md-6 mb-4">
                        <div class="form-outline"> 
                          <input type="text" value="${employee.name.fname}" name="firstname" placeholder="First Name" class="form-control form-control-lg" readonly/>  
                        </div>
                      </div>
                      <div class="col-md-6 mb-4">
      
                        <div class="form-outline">
                          <input type="text" name="lastname" value="${employee.name.lname}" placeholder="Last Name" class="form-control form-control-lg"  readonly/>
                        </div>
      
                      </div>
                    </div>

                    <div class="row">
                        <div class="col-md-6 mb-4 pb-2">
        
                          <div class="form-outline">
                            <input type="email" id="emailAddress" name="email" value="${employee.email}" placeholder="Email" class="form-control form-control-lg" readonly/>
                          </div>
        
                        </div>
                        <div class="col-md-6 mb-4 pb-2">
                          <c:choose>
                          <c:when test="${employee.dept_id==1}">
                              <c:set var="deptname" value="ENTC"></c:set>
                          </c:when>
                          <c:when test="${employee.dept_id==2}">
                              <c:set var="deptname" value="IT"></c:set>
                          </c:when>
                          <c:when test="${employee.dept_id==3}">
                              <c:set var="deptname" value="CS"></c:set>
                          </c:when>
                          </c:choose>
                          <div class="form-outline">
                            <input type="text" id="deptname" value="{deptname}" placeholder="Department Name" name="deptname" class="form-control form-control-lg" readonly/>
                          </div>
        
                        </div>
                      </div>
                    </c:if>
      
                    <div class="row">
                        <div class="col-md-6 mb-4">
                          <div class="form-outline"> 
                            <input type="password" id="password" name="password" placeholder="Password" class="form-control form-control-lg" required/>  
                          </div>
                        </div>
                        <div class="col-md-6 mb-4">
                            <div class="form-outline"> 
                              <input type="password" id="conpassword" name="conpassword" placeholder="Confirm Password" class="form-control form-control-lg" required/>  
                            </div>
                          </div>
                      </div>

                      <c:if test="${flag==false}">
                    <div class="row">
                      <div class="col-12">
                        <div class="dropdown">  
                            <button type="button" class="btn btn-basic dropdown-toggle" data-toggle="dropdown">  
                              Teaching Subjects
                            </button>  
                            <div class="dropdown-menu"> 
                              <p class="dropdown-item">${course1}</p>  
                              <p class="dropdown-item">${course2}</p>     
                            </div>  
                          </div>
                      </div>
                    </div>
                    </c:if>
                    <div class="mt-4 pt-2">
                      <button class="btn btn-primary btn-lg" type="submit" value="Submit">Submit</button>
                    </div>
    
                    </c:if>
                    <div class="mt-4 pt-2 text-center">
                      <p>If already registered, click to <a href="${pageContext.request.contextPath}/signin">Sign In</a></p>
                      <a href="${pageContext.request.contextPath}/home">Go to Home</a>
                    </div>
                  </form>
                </div>
              </div>
            </div>
          </div>
        </div>
      </section>
</body>
</html>