<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Students List</title>

<%-- <link href="<c:url value="/resources/css/bootstrap.min.css" />" rel="stylesheet"> --%>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap.min.css">
    <style type="text/css">
        .myrow-container {
            margin: 20px;
        }
    </style>
</head>
<body class=".container-fluid">

<div class="container myrow-container">
    <div class="panel panel-success">
        <div class="panel-heading">
            <h3 class="panel-title">
                <div align="left"><b>Students List</b> </div>
                <div align="right"><a href="createStudent">Add New Student</a></div>
            </h3>
        </div>
        <div class="panel-body">
            <c:if test="${empty studentsList}">
                There are no Students
            </c:if>
            <c:if test="${not empty studentsList}">   
            
                <form action="searchStudent">
                    <div class="row">
                      <div class="col-md-6"><div class="col-md-6">Search Students:</div><div class="col-md-6"> <input type="text" name="searchName" id="searchName"> </div></div>
                      <div class="col-md-4"><input class="btn btn-success" type='submit' value='Search'/></div>
                    </div>
                </form>             
                                
                <table class="table table-hover table-bordered">
                    <thead style="background-color: #bce8f1;">
                    <tr>
                        <th>Id</th>
                        <th>Name</th>
                        <th>DOB</th>
                        <th>Stream</th>
                        <th>College</th>
                        <th>Edit</th> 
                        <th>Delete</th>
                    </tr>
                    </thead>
                    <tbody>
                    <c:forEach items="${studentsList}" var="stud">
                        <tr>
                            <th><c:out value="${stud.id}"/></th>
                            <th><c:out value="${stud.name}"/></th>
                            <th><c:out value="${stud.dob}"/></th>
                            <th><c:out value="${stud.stream}"/></th> 
                            <th><c:out value="${stud.clg}"/></th> 
                            <th><a href="updateStudent?id=<c:out value='${stud.id}'/>">Edit</a></th>
                            <th><a href="deleteStudent?id=<c:out value='${stud.id}'/>">Delete</a></th>                          
                        </tr>
                    </c:forEach>
                    </tbody>
                </table>
            </c:if>
        </div>
    </div>
</div>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/2.1.3/jquery.min.js"></script>    
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/js/bootstrap.min.js"></script>
<script type="text/javascript">
    	$(function(){
        	$( "#draggable" ).draggable();
        });
</script>    
<%--<script src="<c:url value="/resources/js/jquery-2.1.3.js"/>"></script>
    <script src="<c:url value="/resources/js/bootstrap.min.js"/>"></script>--%>
</body>
</html>