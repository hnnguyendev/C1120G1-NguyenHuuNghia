<%--
  Created by IntelliJ IDEA.
  User: Nguyen Huu Nghia
  Date: 03/23/2021
  Time: 7:07 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Final Exam</title>
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="../../plugins/bootstrap/css/bootstrap.css">

    <!-- DataTables -->
    <link rel="stylesheet" href="../../plugins/datatables-bs4/css/dataTables.bootstrap4.min.css">
    <link rel="stylesheet" href="../../plugins/datatables-responsive/css/responsive.bootstrap4.min.css">
</head>
<body onload="myFunction('${message2}')">
<div class="container">
    <div class="row my-5">
        <div class="col-xl-6">
            <button type="button" class="btn btn-primary"
                    data-toggle="modal" data-target="#createModal">
                Add New
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

    <table id="finalexam" class="table table-bordered table-hover">
        <thead>
        <tr>
            <th>Room Id</th>
            <th>Full Name</th>
            <th>Phone</th>
            <th>Start Day</th>
            <th>Payment Method</th>
            <th>Note</th>
            <th>Action</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach items="${rentRoomList}" var="rentRoom">
            <tr>
                <td>${rentRoom.id}</td>
                <td>${rentRoom.fullName}</td>
                <td>${rentRoom.phone}</td>
                <td>${rentRoom.startDay}</td>
                <td>${rentRoom.paymentMethod.name}</td>
                <td>${rentRoom.note}</td>
                <td><a href=""
                       onclick="setId('${rentRoom.id}','${rentRoom.fullName}')"
                       data-toggle="modal" data-target="#deleteModal">Delete</a></td>
            </tr>
        </c:forEach>
        </tbody>

    </table>

</div>

<!-- modal create -->
<div class="modal fade" id="createModal" tabindex="-1" aria-labelledby="exampleModalLabel"
     aria-hidden="true">
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-header">
                <h5 class="modal-title" id="createModalLabel">Add New</h5>
                <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                    <span aria-hidden="true">&times;</span>
                </button>
            </div>
            <div class="modal-body">
                <form method="post" action="">
                    <div class="form-group">
                        <label for="fullName">Fullname</label>
                        <input type="text" class="form-control" name="fullName" id="fullName"
                               placeholder="Enter full name" value="${rentRoom.fullName}" required>
                    </div>
                    <div class="form-group">
                        <label for="phone">Phone</label>
                        <input type="text" class="form-control" name="phone" id="phone"
                               placeholder="Enter phone" value="${rentRoom.phone}" required>
                        <p>
                            <c:if test='${message2!= null}'>
                                <span style="color: red" class="message">${message2}</span>
                            </c:if>
                        </p>
                    </div>
                    <div class="form-group">
                        <label for="startDay">Start Day</label>
                        <input type="text" class="form-control" name="startDay" id="startDay"
                               placeholder="Enter start day" value="${rentRoom.startDay}" required>
                    </div>
                    <div class="form-group">
                        <label>Payment Method</label>
                        <select class="form-control" name="paymentMethodId" id="paymentMethodId">
                            <option value="">Choose payment method</option>
                            <c:forEach items="${paymentMethodList}" var="paymentMethod">
                                <c:choose>
                                    <c:when test="${paymentMethod.id.equals(rentRoom.paymentMethod.name)}">
                                        <option value="${paymentMethod.id}"
                                                selected>${paymentMethod.name}</option>
                                    </c:when>
                                    <c:otherwise>
                                        <option value="${paymentMethod.id}">${paymentMethod.name}</option>
                                    </c:otherwise>
                                </c:choose>
                            </c:forEach>
                        </select>
                    </div>
                    <div class="form-group">
                        <label for="note">Note</label>
                        <textarea type="text" class="form-control" name="note" id="note"
                                  placeholder="Enter note" value="${rentRoom.note}"></textarea>
                    </div>
                    <input type="hidden" name="action" value="create">
                    <button type="button" class="btn btn-secondary" data-dismiss="modal">Close</button>
                    <button type="submit" class="btn btn-primary float-xl-right">Add new</button>
                </form>
            </div>
        </div>
    </div>
</div>
<%-- end modal create --%>

<%-- modal delete --%>
<div class="modal fade" id="deleteModal" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel"
     aria-hidden="true">
    <div class="modal-dialog" role="document">
        <div class="modal-content">
            <div class="modal-header">
                <h5 class="modal-title" id="deleteModalLabel">Are you sure?</h5>
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

<form action="#" method="post" id="delete">
    <input type="hidden" name="action" value="delete">
    <input type="hidden" name="id" id="id">
</form>
<%-- end modal delete --%>

<!-- jQuery -->
<script src="../../plugins/jquery/jquery.min.js"></script>
<!-- Bootstrap 4 -->
<script src="../../plugins/bootstrap/js/bootstrap.bundle.min.js"></script>
<!-- DataTables -->
<script src="../../plugins/datatables/jquery.dataTables.min.js"></script>
<script src="../../plugins/datatables-bs4/js/dataTables.bootstrap4.min.js"></script>
<script src="../../plugins/datatables-responsive/js/dataTables.responsive.min.js"></script>
<script src="../../plugins/datatables-responsive/js/responsive.bootstrap4.min.js"></script>

<script>
    $(function () {
        $('#finalexam').DataTable({
            "paging": true,
            "lengthChange": false,
            "searching": false,
            "ordering": true,
            "info": true,
            "autoWidth": false,
            "responsive": true,
            "pageLength": 2,
        });
    });
</script>

<script>
    function setId(id, name) {
        // id nay tro toi form delete
        document.getElementById("id").value = id;
        document.getElementById("modalId").value = "Do you want delete customer: " + name;
    }

    function submitDelete() {
        document.getElementById("delete").submit();
    }
</script>

<script type="text/javascript">
    function myFunction(message2) {
        if (message2) {
            $('#createModal').modal('show');
        }
    }
</script>

</body>
</html>
