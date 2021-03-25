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
    <title>Service List</title>
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
<body class="hold-transition sidebar-mini sidebar-collapse">
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
                <a class="nav-link" href="/?action=logout">Logout</a>
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
                        <a href="#" class="nav-link">
                            <i class="nav-icon fas fa-users"></i>
                            <p>
                                Customers
                                <i class="fas fa-angle-left right"></i>
                            </p>
                        </a>
                        <ul class="nav nav-treeview">
                            <li class="nav-item">
                                <a href="/customers" class="nav-link">
                                    <i class="far fa-circle nav-icon"></i>
                                    <p>Customer List</p>
                                </a>
                            </li>
                            <li class="nav-item">
                                <a href="#" class="nav-link" type="button" class="btn btn-primary" data-toggle="modal"
                                   data-target="#exampleModal">
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
                        <a href="#" class="nav-link active">
                            <i class="nav-icon fas fa-home"></i>
                            <p>
                                Services
                                <i class="fas fa-angle-left right"></i>
                            </p>
                        </a>
                        <ul class="nav nav-treeview">
                            <li class="nav-item">
                                <a href="/services" class="nav-link active">
                                    <i class="far fa-circle nav-icon"></i>
                                    <p>Service List</p>
                                </a>
                            </li>
                            <li class="nav-item">
                                <a href="#" class="nav-link"
                                   data-toggle="modal" data-target="#createServiceModal">
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
                        <h1>Service List</h1>
                    </div>
                    <div class="col-sm-6">
                        <ol class="breadcrumb float-sm-right">
                            <li class="breadcrumb-item"><a href="#">Home</a></li>
                            <li class="breadcrumb-item"><a href="#">Services</a></li>
                            <li class="breadcrumb-item active">Service List</li>
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
                                <h3 class="card-title">List of services at the Furama resort</h3>
                            </div>
                            <!-- /.card-header -->
                            <div class="card-body">
                                <div class="row">
                                    <div class="col-xl-6">
                                        <button type="button" class="btn btn-primary"
                                                data-toggle="modal" data-target="#createServiceModal">
                                            Add New Service
                                        </button>
                                    </div>
                                    <div class="col-xl-6">
                                        <form class="form-inline float-xl-right" method="post">
                                            <input class="form-control mr-sm-2" type="search" placeholder="Search"
                                                   aria-label="Search" name="txtSearch" id="txtSearch">
                                            <input type="hidden" name="action" value="search">
                                            <button class="btn btn-outline-success" type="submit">Search</button>
                                        </form>
                                    </div>
                                </div>
                                <table id="customer" class="table table-bordered table-hover">
                                    <thead>
                                    <tr>
                                        <th>Service Code</th>
                                        <th>Service Name</th>
                                        <th>Area</th>
                                        <th>Cost</th>
                                        <th>Max People</th>
                                        <th>Room Standard</th>
                                        <th>Description</th>
                                        <th>Pool Area</th>
                                        <th>Num Of Floor</th>
                                        <th>Rent Type</th>
                                        <th>Service Type</th>
                                        <th>Action</th>
                                    </tr>
                                    </thead>
                                    <tbody>
                                    <c:forEach items="${serviceList}" var="service">
                                        <tr>
                                            <td>${service.serviceCode}</td>
                                            <td>${service.name}</td>
                                            <td>${service.area}</td>
                                            <td>${service.cost}</td>
                                            <td>${service.maxPeople}</td>
                                            <td>${service.roomStandard}</td>
                                            <td>${service.description}</td>
                                            <td>${service.poolArea}</td>
                                            <td>${service.numberOfFloor}</td>
                                            <td>${service.rentType.rentType}</td>
                                            <td>${service.serviceType.serviceType}</td>
                                            <td>
                                                <a class="btn btn-info" title="View" href="#"><i class="far fa-eye"></i></a>
                                                <a class="btn btn-secondary" title="Edit"
                                                   href="/services?action=edit&id=${service.id}"
                                                   onclick="getServiceData('${service.id}', '${service.serviceCode}', '${service.name}',
                                                           '${service.area}', '${service.cost}', '${service.maxPeople}',
                                                           '${service.roomStandard}', '${service.description}', '${service.poolArea}',
                                                           '${service.numberOfFloor}', '${service.rentType.id}', '${service.serviceType.id}')"
                                                   data-toggle="modal" data-target="#editServiceModal">
                                                    <i class="far fa-edit"></i></a>
                                                <a class="btn btn-danger" title="Delete" href="#deleteServiceModal"
                                                   onclick="setServiceId('${service.id}','${service.name}')"
                                                   data-toggle="modal" data-target="#">
                                                    <i class="far fa-trash-alt"></i>
                                                </a>
                                            </td>
                                        </tr>
                                    </c:forEach>
                                    </tbody>
                                    <tfoot>
                                    <tr>
                                        <th>Service Code</th>
                                        <th>Service Name</th>
                                        <th>Area</th>
                                        <th>Cost</th>
                                        <th>Max People</th>
                                        <th>Room Standard</th>
                                        <th>Description</th>
                                        <th>Pool Area</th>
                                        <th>Num Of Floor</th>
                                        <th>Rent Type</th>
                                        <th>Service Type</th>
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

<!-- modal create service -->
<div class="modal fade" id="createServiceModal" tabindex="-1" aria-labelledby="exampleModalLabel" aria-hidden="true">
    <div class="modal-dialog modal-xl">
        <div class="modal-content">
            <div class="modal-header">
                <h5 class="modal-title" id="createServiceModalLabel">Add New Service</h5>
                <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                    <span aria-hidden="true">&times;</span>
                </button>
            </div>
            <div class="modal-body">
                <form method="post" action="/services?action=create">
                    <div class="row">
                        <div class="col-xl-6">
                            <div class="form-group">
                                <label for="servicecode">Service Code</label>
                                <input type="text" class="form-control" name="servicecode" id="servicecode"
                                       placeholder="Enter service code">
                            </div>
                        </div>
                        <div class="col-xl-6">
                            <div class="form-group">
                                <label for="name">Service Name</label>
                                <input type="text" class="form-control" name="name" id="name"
                                       placeholder="Enter service name">
                            </div>
                        </div>
                    </div>
                    <div class="row">
                        <div class="col-xl-6">
                            <div class="form-group">
                                <label for="area">Area</label>
                                <input type="number" class="form-control" name="area" id="area"
                                       placeholder="Enter area">
                            </div>
                        </div>
                        <div class="col-xl-6">
                            <div class="form-group">
                                <label for="cost">Cost</label>
                                <input type="number" class="form-control" name="cost" id="cost"
                                       placeholder="Enter cost">
                            </div>
                        </div>
                    </div>
                    <div class="row">
                        <div class="col-xl-6">
                            <div class="form-group">
                                <label for="maxpeople">Max People</label>
                                <input type="number" class="form-control" name="maxpeople" id="maxpeople"
                                       placeholder="Enter max people">
                            </div>
                        </div>
                        <div class="col-xl-6">
                            <div class="form-group">
                                <label for="roomstandard">Room Standard</label>
                                <input type="text" class="form-control" name="roomstandard" id="roomstandard"
                                       placeholder="Enter room standard">
                            </div>
                        </div>
                    </div>
                    <div class="row">
                        <div class="col-xl-6">
                            <div class="form-group">
                                <label for="description">Description</label>
                                <input type="text" class="form-control" name="description" id="description"
                                       placeholder="Enter description">
                            </div>
                        </div>
                        <div class="col-xl-6">
                            <div class="form-group">
                                <label for="poolarea">Pool Area</label>
                                <input type="number" class="form-control" name="poolarea" id="poolarea"
                                       placeholder="Enter pool area">
                            </div>
                        </div>
                    </div>
                    <div class="row">
                        <div class="col-xl-6">
                            <div class="form-group">
                                <label for="numberoffloor">Number of Foor</label>
                                <input type="number" class="form-control" name="numberoffloor" id="numberoffloor"
                                       placeholder="Enter number of floor">
                            </div>
                        </div>
                        <div class="col-xl-6">
                            <div class="form-group">
                                <label class="col-sm-3 control-label no-padding-right">Rent Type</label>
                                <select class="form-control" name="renttypeid" id="renttypeid">
                                    <option value="">Choose rent type</option>
                                    <c:forEach items="${rentTypeList}" var="rentType">
                                        <c:choose>
                                            <c:when test="${rentType.id.equals(service.rentType.id)}">
                                                <option value="${rentType.id}"
                                                        selected>${rentType.rentType}</option>
                                            </c:when>
                                            <c:otherwise>
                                                <option value="${rentType.id}">${rentType.rentType}</option>
                                            </c:otherwise>
                                        </c:choose>
                                    </c:forEach>
                                </select>
                            </div>
                        </div>
                    </div>
                    <div class="row">
                        <div class="col-xl-6">
                            <div class="form-group">
                                <label class="col-sm-3 control-label no-padding-right">Service Type</label>
                                <select class="form-control" name="servicetypeid" id="servicetypeid">
                                    <option value="">Choose service type</option>
                                    <c:forEach items="${serviceTypeList}" var="serviceType">
                                        <c:choose>
                                            <c:when test="${serviceType.id.equals(service.serviceType.id)}">
                                                <option value="${serviceType.id}"
                                                        selected>${serviceType.serviceType}</option>
                                            </c:when>
                                            <c:otherwise>
                                                <option value="${serviceType.id}">${serviceType.serviceType}</option>
                                            </c:otherwise>
                                        </c:choose>
                                    </c:forEach>
                                </select>
                            </div>
                        </div>
                        <div class="col-xl-6"></div>
                    </div>
                    <button type="submit" class="btn btn-primary float-xl-right">Add new</button>
                </form>
            </div>
        </div>
    </div>
</div>
<%-- end modal create service --%>

<!-- modal update service -->
<div class="modal fade" id="editServiceModal" tabindex="-1" aria-labelledby="exampleModalLabel" aria-hidden="true">
    <div class="modal-dialog modal-xl">
        <div class="modal-content">
            <div class="modal-header">
                <h5 class="modal-title" id="editServiceModalLabel">Edit Service</h5>
                <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                    <span aria-hidden="true">&times;</span>
                </button>
            </div>
            <div class="modal-body">
                <form method="post" action="/services?action=edit">
                    <div class="row">
                        <div class="col-xl-6">
                            <div class="form-group">
                                <label for="old-servicecode">Service Code</label>
                                <input type="text" class="form-control" name="old-servicecode" id="old-servicecode"
                                       placeholder="Enter service code">
                            </div>
                        </div>
                        <div class="col-xl-6">
                            <div class="form-group">
                                <label for="old-name">Service Name</label>
                                <input type="text" class="form-control" name="old-name" id="old-name"
                                       placeholder="Enter service name">
                            </div>
                        </div>
                    </div>
                    <div class="row">
                        <div class="col-xl-6">
                            <div class="form-group">
                                <label for="old-area">Area</label>
                                <input type="number" class="form-control" name="old-area" id="old-area"
                                       placeholder="Enter area">
                            </div>
                        </div>
                        <div class="col-xl-6">
                            <div class="form-group">
                                <label for="old-cost">Cost</label>
                                <input type="number" class="form-control" name="old-cost" id="old-cost"
                                       placeholder="Enter cost">
                            </div>
                        </div>
                    </div>
                    <div class="row">
                        <div class="col-xl-6">
                            <div class="form-group">
                                <label for="old-maxpeople">Max People</label>
                                <input type="number" class="form-control" name="old-maxpeople" id="old-maxpeople"
                                       placeholder="Enter max people">
                            </div>
                        </div>
                        <div class="col-xl-6">
                            <div class="form-group">
                                <label for="old-roomstandard">Room Standard</label>
                                <input type="text" class="form-control" name="old-roomstandard" id="old-roomstandard"
                                       placeholder="Enter room standard">
                            </div>
                        </div>
                    </div>
                    <div class="row">
                        <div class="col-xl-6">
                            <div class="form-group">
                                <label for="old-description">Description</label>
                                <input type="text" class="form-control" name="old-description" id="old-description"
                                       placeholder="Enter description">
                            </div>
                        </div>
                        <div class="col-xl-6">
                            <div class="form-group">
                                <label for="old-poolarea">Pool Area</label>
                                <input type="number" class="form-control" name="old-poolarea" id="old-poolarea"
                                       placeholder="Enter pool area">
                            </div>
                        </div>
                    </div>
                    <div class="row">
                        <div class="col-xl-6">
                            <div class="form-group">
                                <label for="old-numberoffloor">Number of Foor</label>
                                <input type="number" class="form-control" name="old-numberoffloor"
                                       id="old-numberoffloor"
                                       placeholder="Enter number of floor">
                            </div>
                        </div>
                        <div class="col-xl-6">
                            <div class="form-group">
                                <label class="col-sm-3 control-label no-padding-right">Rent Type</label>
                                <select class="form-control" name="old-renttypeid" id="old-renttypeid">
                                    <option value="">Choose rent type</option>
                                    <c:forEach items="${rentTypeList}" var="rentType">
                                        <c:choose>
                                            <c:when test="${rentType.id.equals(service.rentType.id)}">
                                                <option value="${rentType.id}"
                                                        selected>${rentType.rentType}</option>
                                            </c:when>
                                            <c:otherwise>
                                                <option value="${rentType.id}">${rentType.rentType}</option>
                                            </c:otherwise>
                                        </c:choose>
                                    </c:forEach>
                                </select>
                            </div>
                        </div>
                    </div>
                    <div class="row">
                        <div class="col-xl-6">
                            <div class="form-group">
                                <label class="col-sm-3 control-label no-padding-right">Service Type</label>
                                <select class="form-control" name="old-servicetypeid" id="old-servicetypeid">
                                    <option value="">Choose service type</option>
                                    <c:forEach items="${serviceTypeList}" var="serviceType">
                                        <c:choose>
                                            <c:when test="${serviceType.id.equals(service.serviceType.id)}">
                                                <option value="${serviceType.id}"
                                                        selected>${serviceType.serviceType}</option>
                                            </c:when>
                                            <c:otherwise>
                                                <option value="${serviceType.id}">${serviceType.serviceType}</option>
                                            </c:otherwise>
                                        </c:choose>
                                    </c:forEach>
                                </select>
                            </div>
                        </div>
                        <div class="col-xl-6"></div>
                    </div>
                    <input type="hidden" name="old-id" id="old-id">
                    <button type="submit" class="btn btn-secondary float-xl-right">Update</button>
                </form>
            </div>
        </div>
    </div>
</div>
<%-- end modal update service --%>

<%-- modal delete service --%>
<div class="modal fade" id="deleteServiceModal" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel"
     aria-hidden="true">
    <div class="modal-dialog" role="document">
        <div class="modal-content">
            <div class="modal-header">
                <h5 class="modal-title" id="deleteServiceModalLabel">Are you sure?</h5>
                <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                    <span aria-hidden="true">&times;</span>
                </button>
            </div>
            <div class="modal-body">
                <input type="text" id="modalId" size="50" disabled style="border: none;background: white">
            </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-secondary" data-dismiss="modal">Close</button>
                <button type="button" class="btn btn-danger" onclick="submitDelete()">Delete</button>
            </div>
        </div>
    </div>
</div>

<form action="#" method="post" id="deleteService">
    <input type="hidden" name="action" value="delete">
    <input type="hidden" name="id" id="id">
</form>
<%-- end modal delete service --%>

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
    function setServiceId(id, name) {
        // id nay tro toi form delete
        document.getElementById("id").value = id;
        document.getElementById("modalId").value = "Do you want delete service: " + name;
    }

    function submitDelete() {
        document.getElementById("deleteService").submit();
    }

    // function lấy toàn bộ data binding vào modal update
    function getServiceData(id, servicecode, name, area, cost, maxpeople, roomstandard, description, poolarea, numberoffloor, renttypeid, servicetypeid) {
        document.getElementById("old-id").value = id;
        document.getElementById("old-servicecode").value = servicecode;
        document.getElementById("old-name").value = name;
        document.getElementById("old-area").value = area;
        document.getElementById("old-cost").value = cost;
        document.getElementById("old-maxpeople").value = maxpeople;
        document.getElementById("old-roomstandard").value = roomstandard;
        document.getElementById("old-description").value = description;
        document.getElementById("old-poolarea").value = poolarea;
        document.getElementById("old-numberoffloor").value = numberoffloor;
        document.getElementById("old-renttypeid").value = renttypeid;
        document.getElementById("old-servicetypeid").value = servicetypeid;
    }
</script>

</body>
</html>
