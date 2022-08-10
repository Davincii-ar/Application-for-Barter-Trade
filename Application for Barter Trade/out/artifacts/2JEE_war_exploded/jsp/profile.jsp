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
            <form>
                <div class="form-group">
                    <div class="form-group">
                        <label for="username">Username</label>
                        </br>
                        <label>${user.username}</label>
                    </div
                    <div class="form-group">
                        <label for="lastname">Lastname</label>
                        </br>
                        <label>${user.lastname}</label>
                    </div>
                    <div class="form-group">
                        <label for="firstname">Firstname</label>
                        </br>
                        <label>${user.firstname}</label>
                    </div>
                    <div class="form-group">
                        <label for="password">Password</label>
                        </br>
                        <label>${user.password}</label>
                    </div>
                    <div class="form-group">
                        <label for="email">Email</label>
                        </br>
                        <label>${user.email}</label>
                    </div>
                    <div class="form-group">
                        <label for="zipcode">Zip code</label>
                        </br>
                        <label>${user.zipcode}</label>
                    </div>
                </div>
            </form>
        </div>
    </div>
</div>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:if test="${not empty username}">
<%@include file="template/user/scripts.jsp" %>
</c:if>
<c:if test="${empty username}">
    <%@include file="template/scripts.jsp" %>
</c:if>
</body>
</html>