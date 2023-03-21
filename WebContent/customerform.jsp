<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
        <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="a"%>
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Customer Form</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
   <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM" crossorigin="anonymous"></script>
</head>
<body>

 <header style="color:white">
		<nav class="navbar navbar-expand-lg navbar-dark bg-primary">
  <div class="container-fluid">
    <a class="navbar-brand" href="customerlist">Customer Management</a>
    <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
      <span class="navbar-toggler-icon"></span>
    </button>
    <div class="collapse navbar-collapse" id="navbarSupportedContent">
      <ul class="navbar-nav me-auto mb-2 mb-lg-0">
        <li class="nav-item">
          <a class="nav-link active" aria-current="page" href="customerlist">Customer</a>
        </li>
      </ul>
    </div>
  </div>
</nav>
	</header>
	 <br/>
 <br/>
 <a:if test="${customer==null}">
 
 <form action="insertForm"  method="post">
 
  <h2>Add Customer</h2>
  
 </a:if>
 
  
  <a:if test="${customer!=null}">
 
   <form action ="edit" method="post">
 
 <h2>Edit Customer</h2>
 
 </a:if>
 
  <div class="mb-3 container" hidden>
  <input value="<a:out value="${customer.id}"></a:out>" type="text" class="form-control" id="exampleFormControlInput" name="tbId" style="width:300px">
     </div> 
     
     <div class="mb-3 container">
  <label for="exampleFormControlInput1" class="form-label">NAME</label>
  <input value="<a:out value="${customer.name}"></a:out>" type="text" class="form-control" id="exampleFormControlInput1"  placeholder="Enter your name" name="tbName" required="required" style="width:300px">
     </div> 
   
      <div class="mb-3 container">
     <label for="exampleFormControlInput2" class="form-label">EMAIL</label>
  <input value="<a:out value="${customer.email}"></a:out>" type="email" class="form-control" id="exampleFormControlInput2"   placeholder="Enter your email"  name="tbEmail" required="required" style="width:300px">
    </div>
    
   <div class="mb-3 container">
   <label for="exampleFormControlInput3" class="form-label">MOBILE</label>
  <input value="<a:out value="${customer.mobile}"></a:out>" type="number" class="form-control" id="exampleFormControlInput3"   placeholder="Enter your mobile" name="tbMobile" required="required" style="width:300px">
   </div>
   
    <div class="mb-3 container">
    <input type="submit" value="save" class="btn btn-success" style="width:150px"/>
 </div>
</form>
    
</body>
</html>