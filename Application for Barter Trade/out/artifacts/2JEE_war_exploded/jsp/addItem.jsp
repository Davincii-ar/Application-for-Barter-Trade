<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:if test="${not empty username}">
    <%@include file="template/user/head.jsp" %>
</c:if>
<c:if test="${empty username}">
    <%@include file="template/head.jsp" %>
</c:if>

<div class="container">
    <div class="row">
        <div class="col-mg-4 form-div">
            <form method="POST" enctype="multipart/form-data" >
                <div class="form-group">
                    <input type="text" class="form-control" name="title" placeholder="Title">
                    <textarea class="form-control" name="description" placeholder="Description"></textarea>
                    <input type="text" class="form-control" name="typeof" placeholder="Type of">
                    <input type="number" class="form-control" name="price" placeholder="Price">
                    <input type="file" class="form-control" name="fileChooser">
                </div>

                <div class="form-group">
                    <button type="submit" class="btn btn-primary submit-btn">Add item</button>
                </div>
            </form>
        </div>
    </div>
</div>

<c:if test="${not empty username}">
<%@include file="template/user/scripts.jsp" %>
</c:if>
<c:if test="${empty username}">
<%@include file="template/scripts.jsp" %>
</c:if>
</body>
</html>
