
<nav class="navbar navbar-expand-sm bg-dark navbar-dark">
    <ul class="navbar-nav" type="none">
      <li class="nav-item active">
        <a class="nav-link" href="${pageContext.request.contextPath}/home">Home</a>
      </li>
      <li class="nav-item">
        <a class="nav-link" href="${pageContext.request.contextPath}/studentpage/examlist">Exam List</a>
      </li>
      
      <li class="nav-item">
        <a class="nav-link" href="${pageContext.request.contextPath}/studentpage/resultlist">Exam Results</a>
      </li>
      <li class="nav-item">
        <a class="nav-link" href="#">My Profile</a>
      </li>
      <li class="nav-item">
        <a class="nav-link" href="#">Change password</a>
      </li>
    &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
    &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
    &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
    &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
    &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
    &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
    &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
    &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
    &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
    &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
    &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
    &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
    &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
      <li class="nav-item ">
        <div class="dropdown">
          <a class="nav-link dropdown-toggle"><%= session.getAttribute("uname")%>
            <i class="fa fa-caret-down"></i></a>
            <div class="dropdown-content">
              <a href="${pageContext.request.contextPath}/logout">Log Out</a>
            </div>
        </div> 
      </li>
    </ul>
  </nav>