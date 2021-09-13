<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<nav class="navbar navbar-expand-sm bg-dark navbar-dark justify-content-center">
    <ul class="navbar-nav " type="none">
      <li class="nav-item active">
        <a class="nav-link" href="${pageContext.request.contextPath}/home">Home</a>
      </li>
      <!-- <li class="nav-item ">
        <a class="nav-link" href="${pageContext.request.contextPath}/teacherpage">Teacher Page</a>
      </li>
      <li class="nav-item ">
        <a class="nav-link" href="${pageContext.request.contextPath}/studentpage">Student Page</a>
      </li> -->
      <c:choose>
        <c:when test="${flag==true}">
          <li class="nav-item ">
            <div class="dropdown">
              <a class="nav-link dropdown-toggle">${uname}
                <i class="fa fa-caret-down"></i></a>
                <div class="dropdown-content">
                  <a href="${pageContext.request.contextPath}/logout">Log Out</a>
                </div>
            </div> 
          </li>
          </c:when>
          <c:when test="${flag==false}">
            <li><a href="${pageContext.request.contextPath}/signin" ><button type="button" class="btn btn-link">Sign In</button></a></li>
            <li><a href="${pageContext.request.contextPath}/signup" ><button type="button" class="btn btn-link">Sign Up</button></a></li>
          </c:when>
      </c:choose>
     
    </ul>
  </nav>