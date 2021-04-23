<%--
  Created by IntelliJ IDEA.
  User: Nguyen Huu Nghia
  Date: 03/18/2021
  Time: 7:26 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <title>Customer List</title>
    <!-- Tell the browser to be responsive to screen width -->
    <meta name="viewport" content="width=device-width, initial-scale=1">

    <!-- Font Awesome -->
    <link rel="stylesheet" href="../../plugins/fontawesome-free/css/all.min.css">
    <!-- Ionicons -->
    <link rel="stylesheet" href="https://code.ionicframework.com/ionicons/2.0.1/css/ionicons.min.css">
    <!-- DataTables -->
    <link rel="stylesheet" href="../../plugins/datatables-bs4/css/dataTables.bootstrap4.min.css">
    <link rel="stylesheet" href="../../plugins/datatables-responsive/css/responsive.bootstrap4.min.css">
    <!-- Theme style -->
    <link rel="stylesheet" href="../../dist/css/adminlte.min.css">
    <!-- Google Font: Source Sans Pro -->
    <link href="https://fonts.googleapis.com/css?family=Source+Sans+Pro:300,400,400i,700" rel="stylesheet">
</head>

<%--onload ho tro viec validate sai thi modal show len lai--%>
<body class="hold-transition sidebar-mini sidebar-collapse" onload="funcCreateCustomerModal('${messages}')">
<!-- Site wrapper -->
<div class="wrapper">

    <nav class="main-header navbar navbar-expand navbar-white navbar-light">
        <!-- Left navbar links -->
        <ul class="navbar-nav">
            <li class="nav-item">
                <a class="nav-link" data-widget="pushmenu" href="#" role="button"><i class="fas fa-bars"></i></a>
            </li>
        </ul>

        <!-- Right navbar links -->
        <ul class="navbar-nav ml-auto">
            <!-- Messages Dropdown Menu -->
            <li class="nav-item dropdown">
                <a class="nav-link" data-toggle="dropdown" href="#">
                    <i class="far fa-comments"></i>
                    <span class="badge badge-danger navbar-badge">3</span>
                </a>
            </li>
            <!-- Notifications Dropdown Menu -->
            <li class="nav-item dropdown">
                <a class="nav-link" data-toggle="dropdown" href="#">
                    <i class="far fa-bell"></i>
                    <span class="badge badge-warning navbar-badge">15</span>
                </a>
            </li>
            <li class="nav-item">
                <a class="nav-link" href="/?action=logout&logout=ok">Logout</a>
            </li>
        </ul>
    </nav>
    <!-- /.navbar -->

    <!-- Main Sidebar Container -->
    <aside class="main-sidebar sidebar-dark-primary elevation-4">
        <!-- Brand Logo -->
        <a href="#" class="brand-link">
            <img src="../../dist/img/Furama.png"
                 alt="AdminLTE Logo"
                 class="brand-image img-circle elevation-3"
                 style="opacity: .8">
            <span class="brand-text font-weight-light">Furama Danang</span>
        </a>

        <!-- Sidebar -->
        <div class="sidebar">
            <!-- Sidebar user (optional) -->
            <div class="user-panel mt-3 pb-3 mb-3 d-flex">
                <div class="image">
                    <img src="../../dist/img/mario.png" class="img-circle elevation-2" alt="User Image">
                </div>
                <div class="info">
                    <a href="#" class="d-block">Nguyen Huu Nghia</a>
                </div>
            </div>

            <!-- Sidebar Menu -->
            <nav class="mt-2">
                <ul class="nav nav-pills nav-sidebar flex-column" data-widget="treeview" role="menu"
                    data-accordion="false">
                    <!-- Add icons to the links using the .nav-icon class
                         with font-awesome or any other icon font library -->

                    <li class="nav-item has-treeview">
                        <a href="#" class="nav-link active">
                            <i class="nav-icon fas fa-users"></i>
                            <p>
                                Customers
                                <i class="fas fa-angle-left right"></i>
                            </p>
                        </a>
                        <ul class="nav nav-treeview">
                            <li class="nav-item">
                                <a href="/customers" class="nav-link active">
                                    <i class="far fa-circle nav-icon"></i>
                                    <p>Customer List</p>
                                </a>
                            </li>
                            <li class="nav-item">
                                <a href="#" class="nav-link" type="button" class="btn btn-primary"
                                   data-toggle="modal" data-target="#createCustomerModal">
                                    <i class="far fa-circle nav-icon"></i>
                                    <p>Create Customer</p>
                                </a>
                            </li>
                        </ul>
                    </li>

                    <li class="nav-item has-treeview">
                        <a href="#" class="nav-link">
                            <i class="nav-icon fas fa-table"></i>
                            <p>
                                Employees
                                <i class="fas fa-angle-left right"></i>
                            </p>
                        </a>
                        <ul class="nav nav-treeview">
                            <li class="nav-item">
                                <a href="/employees" class="nav-link">
                                    <i class="far fa-circle nav-icon"></i>
                                    <p>Employee List</p>
                                </a>
                            </li>
                            <li class="nav-item">
                                <a href="#" class="nav-link">
                                    <i class="far fa-circle nav-icon"></i>
                                    <p>Create Employee</p>
                                </a>
                            </li>
                        </ul>
                    </li>

                    <li class="nav-item has-treeview">
                        <a href="#" class="nav-link">
                            <i class="nav-icon fas fa-home"></i>
                            <p>
                                Services
                                <i class="fas fa-angle-left right"></i>
                            </p>
                        </a>
                        <ul class="nav nav-treeview">
                            <li class="nav-item">
                                <a href="/services" class="nav-link">
                                    <i class="far fa-circle nav-icon"></i>
                                    <p>Service List</p>
                                </a>
                            </li>
                            <li class="nav-item">
                                <a href="#" class="nav-link">
                                    <i class="far fa-circle nav-icon"></i>
                                    <p>Create Service</p>
                                </a>
                            </li>
                        </ul>
                    </li>

                    <li class="nav-item has-treeview">
                        <a href="#" class="nav-link">
                            <i class="nav-icon fas fa-file-signature"></i>
                            <p>
                                Contracts
                                <i class="fas fa-angle-left right"></i>
                            </p>
                        </a>
                        <ul class="nav nav-treeview">
                            <li class="nav-item">
                                <a href="/contracts" class="nav-link">
                                    <i class="far fa-circle nav-icon"></i>
                                    <p>Contract List</p>
                                </a>
                            </li>
                            <li class="nav-item">
                                <a href="#" class="nav-link">
                                    <i class="far fa-circle nav-icon"></i>
                                    <p>Create Contract</p>
                                </a>
                            </li>
                        </ul>
                    </li>

                    <li class="nav-item has-treeview">
                        <a href="#" class="nav-link">
                            <i class="nav-icon fas fa-file-contract"></i>
                            <p>
                                Contract Details
                                <i class="fas fa-angle-left right"></i>
                            </p>
                        </a>
                        <ul class="nav nav-treeview">
                            <li class="nav-item">
                                <a href="/contractdetails" class="nav-link">
                                    <i class="far fa-circle nav-icon"></i>
                                    <p>Contract Detail List</p>
                                </a>
                            </li>
                            <li class="nav-item">
                                <a href="#" class="nav-link">
                                    <i class="far fa-circle nav-icon"></i>
                                    <p>Create Contract Detail</p>
                                </a>
                            </li>
                        </ul>
                    </li>

                </ul>
            </nav>
            <!-- /.sidebar-menu -->
        </div>
        <!-- /.sidebar -->
    </aside>

    <!-- Content Wrapper. Contains page content -->
    <div class="content-wrapper">
        <!-- Content Header (Page header) -->
        <section class="content-header">
            <div class="container-fluid">
                <div class="row mb-2">
                    <div class="col-sm-6">
                        <h1>Customer List</h1>
                    </div>
                    <div class="col-sm-6">
                        <ol class="breadcrumb float-sm-right">
                            <li class="breadcrumb-item"><a href="#">Home</a></li>
                            <li class="breadcrumb-item"><a href="#">Customers</a></li>
                            <li class="breadcrumb-item active">Customer List</li>
                        </ol>
                    </div>
                </div>
            </div><!-- /.container-fluid -->
        </section>

        <!-- Main content -->
        <section class="content">
            <div class="container-fluid">
                <div class="row">
                    <div class="col-12">
                        <div class="card">
                            <div class="card-header">
                                <h3 class="card-title">List of customers at the Furama resort</h3>
                            </div>
                            <!-- /.card-header -->
                            <div class="card-body">
                                <div class="row">
                                    <div class="col-xl-6">
                                        <button type="button" class="btn btn-primary"
                                                data-toggle="modal" data-target="#createCustomerModal">
                                            Add New Customer
                                        </button>
                                    </div>
                                    <div class="col-xl-6">
                                        <form class="form-inline float-xl-right">
                                            <input type="hidden" name="action" value="search">
                                            <input class="form-control mr-sm-2" type="search" placeholder="Search"
                                                   aria-label="Search" name="txtSearch" id="txtSearch">
                                            <button class="btn btn-outline-success" type="submit">Search</button>
                                        </form>
                                    </div>
                                </div>
                                <table id="customer" class="table table-bordered table-hover">
                                    <thead>
                                    <tr>
                                        <th>Customer Code</th>
                                        <th>Full Name</th>
                                        <th>Birthday</th>
                                        <th>Gender</th>
                                        <th>ID Card</th>
                                        <th>Phone Number</th>
                                        <th>Email</th>
                                        <th>Address</th>
                                        <th>Customer Type</th>
                                        <th>Action</th>
                                    </tr>
                                    </thead>
                                    <tbody>
                                    <c:forEach items="${customerList}" var="customer">
                                        <tr>
                                            <td>${customer.customerCode}</td>
                                            <td>${customer.fullName}</td>
                                            <td>${customer.birthday}</td>
                                            <td>
                                                <c:choose>
                                                    <c:when test="${customer.gender == 0}">Female</c:when>
                                                    <c:when test="${customer.gender == 1}">Male</c:when>
                                                    <c:otherwise>3D</c:otherwise>
                                                </c:choose>
                                            </td>
                                            <td>${customer.idNumber}</td>
                                            <td>${customer.phoneNumber}</td>
                                            <td>${customer.email}</td>
                                            <td>${customer.address}</td>
                                            <td>${customer.customerType.customerType}</td>
                                            <td>
                                                <a class="btn btn-info" title="View" href="#"><i class="far fa-eye"></i></a>
                                                <a class="btn btn-secondary" title="Edit"
                                                   href="/customers?action=edit&id=${customer.id}"
                                                   onclick="getCustomerData('${customer.id}','${customer.customerCode}',
                                                           '${customer.fullName}','${customer.birthday}','${customer.gender}',
                                                           '${customer.idNumber}','${customer.phoneNumber}','${customer.email}',
                                                           '${customer.address}','${customer.customerType.id}')"
                                                   data-toggle="modal" data-target="#editCustomerModal">
                                                    <i class="far fa-edit"></i></a>
                                                <a class="btn btn-danger" title="Delete" href="#"
                                                   onclick="setCustomerId('${customer.id}','${customer.fullName}')"
                                                   data-toggle="modal" data-target="#deleteCustomerModal">
                                                    <i class="far fa-trash-alt"></i>
                                                </a>
                                            </td>
                                        </tr>
                                    </c:forEach>
                                    </tbody>
                                    <tfoot>
                                    <tr>
                                        <th>Customer Code</th>
                                        <th>Full Name</th>
                                        <th>Birthday</th>
                                        <th>Gender</th>
                                        <th>ID Card</th>
                                        <th>Phone Number</th>
                                        <th>Email</th>
                                        <th>Address</th>
                                        <th>Customer Type</th>
                                        <th>Action</th>
                                    </tr>
                                    </tfoot>
                                </table>
                            </div>
                            <!-- /.card-body -->
                        </div>
                        <!-- /.card -->
                    </div>
                </div>
            </div>
        </section>
        <!-- /.content -->
    </div>
    <!-- /.content-wrapper -->

    <footer class="main-footer">
        <div class="float-right d-none d-sm-block">
            Designed by<b> Nguyen Huu Nghia</b>
        </div>
        <strong>Copyright &copy; 2021 <a href="/" target="_blank">Furama Danang</a>.</strong>
        All rights
        reserved.
    </footer>

    <!-- Control Sidebar -->
    <aside class="control-sidebar control-sidebar-dark">
        <!-- Control sidebar content goes here -->
    </aside>
    <!-- /.control-sidebar -->
</div>
<!-- ./wrapper -->

<!-- modal create customer -->
<div class="modal fade" id="createCustomerModal" tabindex="-1" aria-labelledby="exampleModalLabel" aria-hidden="true">
    <div class="modal-dialog modal-xl">
        <div class="modal-content">
            <div class="modal-header">
                <h5 class="modal-title" id="createCustomerModalLabel">Add New Customer</h5>
                <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                    <span aria-hidden="true">&times;</span>
                </button>
            </div>
            <div class="modal-body">
                <form method="post" action="/customers">
                    <div class="row">
                        <div class="col-xl-6">
                            <div class="form-group">
                                <label for="customercode">Customer Code</label>
                                <input type="text" class="form-control" name="customercode" id="customercode"
                                       placeholder="Enter customer code" value="${customer.customerCode}">
                                <p>
                                    <c:if test='${messages.get(0) ne null}'>
                                        <span style="color: red" class="message">${messages.get(0)}</span>
                                    </c:if>
                                </p>
                            </div>
                        </div>
                        <div class="col-xl-6">
                            <div class="form-group">
                                <label for="fullname">Full Name</label>
                                <input type="text" class="form-control" name="fullname" id="fullname"
                                       placeholder="Enter full name" value="${customer.fullName}">
                                <p>
                                    <c:if test='${messages.get(1) ne null}'>
                                        <span style="color: red" class="message">${messages.get(1)}</span>
                                    </c:if>
                                </p>
                            </div>
                        </div>
                    </div>
                    <div class="row">
                        <div class="col-xl-6">
                            <div class="form-group">
                                <label for="birthday">Birthday</label><br>
                                <input type="date" class="form-control" id="birthday" name="birthday" value="${customer.birthday}">
                            </div>
                        </div>
                        <div class="col-xl-6">
                            <div class="form-group">
                                <label>Gender</label>
                                <%--xử lý lấy lại giá trị cũ khi validate sai--%>
                                <c:choose>
                                    <c:when test="${messages.size() > 0}">
                                        <select class="form-control" name="gender" id="gender">
                                            <option value="">Choose gender</option>
                                            <c:if test="${customer.gender eq 0}">
                                                <option value="0" selected>Female</option>
                                            </c:if>
                                            <option value="0">Female</option>
                                            <c:if test="${customer.gender eq 1}">
                                                <option value="1" selected>Male</option>
                                            </c:if>
                                            <option value="1">Male</option>
                                            <c:if test="${customer.gender eq -1}">
                                                <option value="-1" selected>Other</option>
                                            </c:if>
                                            <option value="-1">Other</option>
                                        </select>
                                    </c:when>
                                    <c:otherwise>
                                        <select class="form-control" name="gender" id="gender">
                                            <option value="">Choose gender</option>
                                            <option value="0">Female</option>
                                            <option value="1">Male</option>
                                            <option value="-1">Other</option>
                                        </select>
                                    </c:otherwise>
                                </c:choose>
                            </div>
                        </div>
                    </div>
                    <div class="row">
                        <div class="col-xl-6">
                            <div class="form-group">
                                <label for="idnumber">ID Card</label>
                                <input type="text" class="form-control" name="idnumber" id="idnumber"
                                       placeholder="Enter id card" value="${customer.idNumber}">
                                <p>
                                    <c:if test='${messages.get(4) ne null}'>
                                        <span style="color: red" class="message">${messages.get(4)}</span>
                                    </c:if>
                                </p>
                            </div>
                        </div>
                        <div class="col-xl-6">
                            <div class="form-group">
                                <label for="phonenumber">Phone Number</label>
                                <input type="text" class="form-control" name="phonenumber" id="phonenumber"
                                       placeholder="Enter phone number" value="${customer.phoneNumber}">
                            </div>
                        </div>
                    </div>
                    <div class="row">
                        <div class="col-xl-6">
                            <div class="form-group">
                                <label for="email">Email</label>
                                <input type="text" class="form-control" name="email" id="email"
                                       placeholder="Enter email" value="${customer.email}">
                                <p>
                                    <c:if test='${messages.get(6) ne null}'>
                                        <span style="color: red" class="message">${messages.get(6)}</span>
                                    </c:if>
                                </p>
                            </div>
                        </div>
                        <div class="col-xl-6">
                            <div class="form-group">
                                <label for="address">Address</label>
                                <input type="text" class="form-control" name="address" id="address"
                                       placeholder="Enter address" value="${customer.address}">
                                <p>
                                    <c:if test='${messages.get(7) ne null}'>
                                        <span style="color: red" class="message">${messages.get(7)}</span>
                                    </c:if>
                                </p>
                            </div>
                        </div>
                    </div>
                    <div class="row">
                        <div class="col-xl-6">
                            <div class="form-group">
                                <label>Category</label>
                                <select class="form-control" name="customerTypeId" id="customerTypeId">
                                    <option value="">Choose customer type</option>
                                    <c:forEach items="${customerTypeList}" var="customerType">
                                        <c:choose>
                                            <c:when test="${customerType.id.equals(customer.customerType.id)}">
                                                <option value="${customerType.id}"
                                                        selected>${customerType.customerType}</option>
                                            </c:when>
                                            <c:otherwise>
                                                <option value="${customerType.id}">${customerType.customerType}</option>
                                            </c:otherwise>
                                        </c:choose>
                                    </c:forEach>
                                </select>
                            </div>
                        </div>
                        <div class="col-xl-6"></div>
                    </div>
                    <input type="hidden" name="action" value="create">
                    <button type="submit" class="btn btn-primary float-xl-right">Add new</button>
                </form>
            </div>
        </div>
    </div>
</div>
<%-- end modal create customer --%>

<!-- modal edit customer -->
<div class="modal fade" id="editCustomerModal" tabindex="-1" aria-labelledby="exampleModalLabel" aria-hidden="true">
    <div class="modal-dialog modal-xl">
        <div class="modal-content">
            <div class="modal-header">
                <h5 class="modal-title" id="editCustomerLabel">Edit Customer</h5>
                <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                    <span aria-hidden="true">&times;</span>
                </button>
            </div>
            <div class="modal-body">
                <form method="post" action="/customers">
                    <div class="row">
                        <div class="col-xl-6">
                            <div class="form-group">
                                <label for="old-customercode">Customer Code</label>
                                <input type="text" class="form-control" name="old-customercode" id="old-customercode"
                                       placeholder="Enter customer code">
                            </div>
                        </div>
                        <div class="col-xl-6">
                            <div class="form-group">
                                <label for="old-fullname">Full Name</label>
                                <input type="text" class="form-control" name="old-fullname" id="old-fullname"
                                       placeholder="Enter full name">
                            </div>
                        </div>
                    </div>
                    <div class="row">
                        <div class="col-xl-6">
                            <div class="form-group">
                                <label for="old-birthday">Birthday</label><br>
                                <input type="date" class="form-control" id="old-birthday" name="old-birthday">
                            </div>
                        </div>
                        <div class="col-xl-6">
                            <div class="form-group">
                                <label>Gender</label>
                                <select class="form-control" name="old-gender" id="old-gender">
                                    <option value="">Choose gender</option>
                                    <option value="0">Female</option>
                                    <option value="1">Male</option>
                                    <option value="-1">Other</option>
                                </select>
                            </div>
                        </div>
                    </div>
                    <div class="row">
                        <div class="col-xl-6">
                            <div class="form-group">
                                <label for="old-idnumber">ID Card</label>
                                <input type="text" class="form-control" name="old-idnumber" id="old-idnumber"
                                       placeholder="Enter id card">
                            </div>
                        </div>
                        <div class="col-xl-6">
                            <div class="form-group">
                                <label for="old-phonenumber">Phone Number</label>
                                <input type="text" class="form-control" name="old-phonenumber" id="old-phonenumber"
                                       placeholder="Enter phone number">
                            </div>
                        </div>
                    </div>
                    <div class="row">
                        <div class="col-xl-6">
                            <div class="form-group">
                                <label for="old-email">Email</label>
                                <input type="text" class="form-control" name="old-email" id="old-email"
                                       placeholder="Enter email">
                            </div>
                        </div>
                        <div class="col-xl-6">
                            <div class="form-group">
                                <label for="old-address">Address</label>
                                <input type="text" class="form-control" name="old-address" id="old-address"
                                       placeholder="Enter address">
                            </div>
                        </div>
                    </div>
                    <div class="row">
                        <div class="col-xl-6">
                            <div class="form-group">
                                <label>Category</label>
                                <select class="form-control" name="old-customertypeid" id="old-customertypeid">
                                    <option value="">Choose customer type</option>
                                    <c:forEach items="${customerTypeList}" var="customerType">
                                        <option value="${customerType.id}">${customerType.customerType}</option>
                                    </c:forEach>
                                </select>
                            </div>
                        </div>
                        <div class="col-xl-6"></div>
                    </div>
                    <input type="hidden" name="action" value="edit">
                    <input type="hidden" name="old-id" id="old-id">
                    <button type="submit" class="btn btn-secondary float-xl-right">Update</button>
                </form>
            </div>
        </div>
    </div>
</div>
<%-- end modal edit customer--%>

<%-- modal delete customer --%>
<div class="modal fade" id="deleteCustomerModal" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel"
     aria-hidden="true">
    <div class="modal-dialog" role="document">
        <div class="modal-content">
            <div class="modal-header">
                <h5 class="modal-title" id="deleteCustomerModalLabel">Are you sure?</h5>
                <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                    <span aria-hidden="true">&times;</span>
                </button>
            </div>
            <div class="modal-body">
                <input type="text" id="modelId" size="50" disabled style="border: none;background: white">
            </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-secondary" data-dismiss="modal">Close</button>
                <button type="button" class="btn btn-danger" onclick="submitDelete()">Delete</button>
            </div>
        </div>
    </div>
</div>

<form action="#" method="post" id="deleteCustomer">
    <input type="hidden" name="action" value="delete">
    <input type="hidden" name="id" id="id">
</form>
<%-- end modal delete customer --%>

<!-- jQuery -->
<script src="../../plugins/jquery/jquery.min.js"></script>
<!-- Bootstrap 4 -->
<script src="../../plugins/bootstrap/js/bootstrap.bundle.min.js"></script>
<!-- DataTables -->
<script src="../../plugins/datatables/jquery.dataTables.min.js"></script>
<script src="../../plugins/datatables-bs4/js/dataTables.bootstrap4.min.js"></script>
<script src="../../plugins/datatables-responsive/js/dataTables.responsive.min.js"></script>
<script src="../../plugins/datatables-responsive/js/responsive.bootstrap4.min.js"></script>
<!-- AdminLTE App -->
<script src="../../dist/js/adminlte.min.js"></script>
<!-- AdminLTE for demo purposes -->
<script src="../../dist/js/demo.js"></script>

<script>
    $(function () {
        $('#customer').DataTable({
            "paging": true,
            "lengthChange": false,
            "searching": false,
            "ordering": true,
            "info": true,
            "autoWidth": false,
            "responsive": true,
            "pageLength": 9,
        });
    });
</script>

<script>
    function setCustomerId(id, name) {
        // id nay tro toi form delete
        document.getElementById("id").value = id;
        document.getElementById("modelId").value = "Do you want delete customer: " + name;
    }

    function submitDelete() {
        document.getElementById("deleteCustomer").submit();
    }

    // function lấy toàn bộ data binding vào modal update
    function getCustomerData(id, code, name, birthday, gender, idnumber, phonenumber, email, address, customertype) {
        document.getElementById("old-id").value = id;
        document.getElementById("old-customercode").value = code;
        document.getElementById("old-fullname").value = name;
        document.getElementById("old-birthday").value = birthday;
        document.getElementById("old-gender").value = gender;
        document.getElementById("old-idnumber").value = idnumber;
        document.getElementById("old-phonenumber").value = phonenumber;
        document.getElementById("old-email").value = email;
        document.getElementById("old-address").value = address;
        document.getElementById("old-customertypeid").value = customertype;
    }

    // function xử lý khi validate sai thì show lại modal kèm message
    // List bên java gửi qua là một chuỗi dạng [value, value, ...] nên phải xử lý chuỗi cắt hai dấu [] và xử lý bên trong
    function funcCreateCustomerModal(messages) {
        let check = true;
        let str = messages.substring(1, messages.length - 1);
        str = str.split(",");
        console.log(str);
        if (str[0] !== "") {
            for (let i = 0; i < str.length; i++) {
                console.log(str[i].trim());
                if (str[i].trim() !== 'null') {
                    check = false;
                    break;
                }
            }
        }
        check ? "" : $('#createCustomerModal').modal('show');
    }

    function funcEditCustomerModal(messages) {
        if (messages) {
            $('#editCustomerModal').modal('show');
        }
    }
</script>

</body>
</html>
