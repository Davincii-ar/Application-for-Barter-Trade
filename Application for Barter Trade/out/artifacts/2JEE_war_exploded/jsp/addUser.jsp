<%@include file="template/head.jsp" %>

<div class="container">
    <div class="row">
        <div class="col-mg-4 form-div">
            <form method="POST">
                <div class="form-group">
                    <input type="text" class="form-control" name="username" id="username" placeholder="Username">
                    <input type="text" class="form-control" name="lastname" id="lastname" placeholder="Lastname">
                    <input type="text" class="form-control" name="firstname" id="firstname" placeholder="Firstname">
                    <input type="password" class="form-control" name="password" id="password" placeholder="Password">
                    <input type="email" class="form-control" name="email" id="email" placeholder="Email">
                    <input type="number" class="form-control" name="zipcode" id="zipcode" placeholder="Zip code">
                </div>

                <div class="form-group">
                    <button type="submit" class="btn btn-primary submit-btn">Register</button>
                </div>
            </form>
        </div>
    </div>
</div>


<%@include file="template/scripts.jsp" %>
</body>
</html>
