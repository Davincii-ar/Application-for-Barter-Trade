<%@include file="template/head.jsp" %>
<title>Bartering - Login page</title>

<div class="container">
    <div class="row">
        <div class="col-mg-4 form-div">
            <h1>Login</h1>
            <form method="POST">
                <div class="form-group">
                    <input type="text" class="form-control" name="username" id="username" placeholder="Username">
                    <input type="password" class="form-control" name="password" id="password" placeholder="Password">
                </div>

                <div class="form-group">
                    <button type="submit" class="btn btn-primary submit-btn">Login</button>
                </div>
            </form>
        </div>
    </div>
</div>

<%@include file="template/scripts.jsp" %>
</body>
</html>
