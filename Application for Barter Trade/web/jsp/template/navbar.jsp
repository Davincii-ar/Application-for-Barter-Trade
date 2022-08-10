<nav class="navbar navbar-default">
    <div class="container-fluid">
      <!-- Brand and toggle get grouped for better mobile display -->
      <div class="navbar-header">
        <a class="navbar-brand" href="../4JVA/index">Bartering</a>
      </div>

      <!-- Collect the nav links, forms, and other content for toggling -->
      <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
          <c:if test="${not empty username}">
            <ul class="nav navbar-nav">
              <li><a href="../4JVA/user/addItem">Add object</a></li>
            </ul>
          </c:if>  
        <form class="navbar-form navbar-left" role="search">
        <div class="form-group">
          <input type="text" class="form-control" placeholder="Type an object title">
        </div>
        <button type="submit" class="btn btn-default search-btn">Search</button>
        </form>
        <ul class="nav navbar-nav navbar-right">
            <c:if test="${empty username}">
                <li><a href="../4JVA/login">Login</a></li>
                <li><a href="../4JVA/register">Register</a></li>
            </c:if>        
            <c:if test="${not empty username}">
                <li class="dropdown">
                    <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false">${username}<span class="caret"></span></a>
                    <ul class="dropdown-menu">
                      <li><a href="../4JVA/user/profile">View profile</a></li>
                      <li><a href="../4JVA/user/editProfile">Edit profile</a></li>
                      <li role="separator" class="divider"></li>
                      <li><a href="../4JVA/user/logout">Logout</a></li>
                    </ul>
                </li>
            </c:if>
        </ul>
      </div><!-- /.navbar-collapse -->
    </div><!-- /.container-fluid -->
</nav>