<!DOCTYPE html>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %> 
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>${name}</title>

    <script src="${pageContext.request.contextPath}/jquery/jquery-3.3.1.min.js"></script>

    <link rel="stylesheet" href="https://cdn.datatables.net/1.10.2/css/jquery.dataTables.min.css">
<script type="text/javascript" src="https://cdn.datatables.net/1.10.2/js/jquery.dataTables.min.js"></script>

    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-beta.2/css/bootstrap.min.css">

    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.6/umd/popper.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-beta.2/js/bootstrap.min.js"></script>
    <script type="text/javascript" src="https://cdnjs.cloudflare.com/ajax/libs/bootstrap-datepicker/1.4.1/js/bootstrap-datepicker.min.js"></script>

    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/home.css">
    <script src="${pageContext.request.contextPath}/jquery/myjquery.js"></script>
</head>
<body>
    <jsp:include page="common views/header.jsp"/>
        <jsp:include page="common views/teacher_navbar.jsp"/>
        <div id="name">${name}</div>
        <table id="myTable" class="table table-striped table-bordered dataTables" style="width:100%">
            <thead>
                <tr>
                    <th>Student Name</th>
                    <th>Exam Name</th>
                    <th>Exam Date</th>
                    <th>Marks Obtained</th>
                    <th>Total Marks</th>
                    <th>Result Status</th>
                </tr>
            </thead>
            <tbody>
                <c:forEach items="${resultlist}" var="result" varStatus="status">
                <tr>
                    <td>${studentlist[status.index].name.fname} ${studentlist[status.index].name.lname}</td>
                    <td>${examlist[status.index].examname}</td>
                    <c:set var="examdate">
                    <fmt:formatDate pattern="dd-MM-yyyy" value="${examlist[status.index].examdate}" />
                    </c:set>
                    <td>${examdate}</td>
                    <td>${result.gotMarks}</td>
                    <td>${examlist[status.index].totalMarks}</td>
                    <c:choose>
                    <c:when test="${ (result.gotMarks/examlist[status.index].totalMarks)>=0.4}">
                        <td>Pass</td>
                    </c:when>
                    <c:otherwise>
                        <td>Fail</td>
                    </c:otherwise>
                </c:choose>  
                </tr>
                </c:forEach>
                    </tbody>
        </table>
</body>
</html>