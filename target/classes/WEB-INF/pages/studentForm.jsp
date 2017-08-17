<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Student Information</title>

<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap.min.css">
    <style type="text/css">
        .myrow-container{
            margin: 20px;
        }
    </style>
</head>
<body class=".container-fluid">

	<div class="container myrow-container">
        <div class="panel panel-success">
            <div class="panel-heading">
                <h3 class="panel-title">
                    Student Details
                </h3>
            </div>
            <div class="panel-body">
            
            	<form:errors path="student.*"></form:errors>
            	
                <form:form id="studentRegisterForm" cssClass="form-horizontal" modelAttribute="student" method="post" action="saveStudent">
    
                    <div class="form-group">
                        <div class="control-label col-xs-3"> <form:label path="name" >Name</form:label> </div>
                        <div class="col-xs-6">
                            <form:hidden path="id" value="${studentObject.id}"/>
                            <form:input cssClass="form-control" path="name" value="${studentObject.name}"/>
                        </div>
                    </div>
    
                    <div class="form-group">
                        <form:label path="dob" cssClass="control-label col-xs-3">DOB</form:label>
                        <div class="col-xs-6">
                            <form:input cssClass="form-control" placeholder="yyyy-mm-dd" path="dob" value="${studentObject.dob}"/>
                        </div>
                    </div>
    
                    <div class="form-group">
                        <div class="control-label col-xs-3"><form:label path="stream">Stream</form:label></div>
                        <div class="col-xs-6">
                            <form:input cssClass="form-control" path="stream" value="${studentObject.stream}"/>
                        </div>
                    </div>
                    
                    <div class="form-group">
                        <div class="control-label col-xs-3"><form:label path="clg">College</form:label></div>
                        <div class="col-xs-6">
                            <form:input cssClass="form-control" path="clg" value="${studentObject.clg}"/>
                        </div>
                    </div>
    
                    <div class="form-group">
                        <div class="row">
                            <div class="col-xs-4">
                            </div>
                            <div class="col-xs-4">
                                <input type="submit" id="saveStudent" class="btn btn-primary" value="Save" onclick="return submitStudentForm();"/>
                            </div>
                            <div class="col-xs-4">
                            </div>
                        </div>
                    </div>
    
                </form:form>
            </div>
        </div>
    </div>
	
	
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/2.1.3/jquery.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/js/bootstrap.min.js"></script>
    
    <script type="text/javascript">
        function submitStudentForm() { 
        	
            var name = $('#name').val().trim();
            var dob = $('#dob').val();
            var stream = $('#stream').val();
            var clg = $('#clg').val();
            
            if(name.length ==0) {
                alert('Please enter name');
                $('#name').focus();
                return false;
            }
    
            if(dob == null) {
                alert('Please enter proper dob');
                $('#dob').focus();
                return false;
            }
    
            if(stream == null) {
                alert('Please enter proper stream');
                $('#stream').focus();
                return false;
            }
            
            if(clg == null) {
                alert('Please enter proper college');
                $('#clg').focus();
                return false;
            }
            return true;
        };  
    </script>
	
</body>
</html>