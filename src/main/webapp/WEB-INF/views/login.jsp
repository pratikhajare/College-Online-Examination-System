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

    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/home.css">
</head>
<body>
    <section class="vh-100" style="background-color: #bbcae6e3;" action>

      <c:choose>
        <c:when test="${flag==true}">
          <div class="alert alert-success container text-center" style="width: 600px;">${success}</div>
          </c:when>
          <c:when test="${flag==false}">
          <div class="alert alert-danger container text-center" style="width: 600px;">${error}</div>
          </c:when>
      </c:choose>  

        <div class="container py-5 h-100">
          <div class="row d-flex justify-content-center align-items-center h-100">
            <div class="col-12 col-md-8 col-lg-6 col-xl-5">
              <div class="card shadow-2-strong" style="border-radius: 1rem;">
                <div class="card-body p-5 text-center">
                  
                  <h3 class="mb-5">Sign in</h3>
                  <hr class="my-4">
                  <form class="form-horizontal" role="form" action="${pageContext.request.contextPath}/signin" method="POST">
                    <div class="form-group">  
                  <div class="form-outline mb-4">
                    <input type="text" id="username" name="username" placeholder="Enter Registration ID" class="form-control form-control-lg" required/>
                  </div>
                  </div>
                  
                  <div class="form-group">
                  <div class="form-outline mb-4">
                    <input type="password" id="password" name="password" placeholder="Enter Password" class="form-control form-control-lg" required/>
                  </div>
                  </div>
                
                  <button class="btn btn-primary btn-lg btn-block" type="submit">Login</button>
                </form>
                  <hr class="my-4">
                  <p>If forgot password, <a href="#">Click me</a> to reset password</p>
                  
                  <p>If not registered, then <a href="${pageContext.request.contextPath}/signup">Register</a></p>

                  <a href="${pageContext.request.contextPath}/home">Go to Home</a>

                  <hr class="my-4">
                </div>
                  </div>
                </div>
              </div>
            </div>
      </section>
</body>
</html>