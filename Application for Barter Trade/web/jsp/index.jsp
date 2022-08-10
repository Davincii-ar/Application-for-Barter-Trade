<%@include file="template/head.jsp" %>
    <div class="container">
        <div class="row">
            <div class="col-md-6">
                <div class="jumbotron">
                    <h3>Web site description</h3>
                    LOREM TAMERE IPSUM
                </div>
            </div>
            <div class="col-md-5 stats">
                <div class="jumbotron">
                    <h3>Statistics</h3>
                    Number of Users : ${countUsers}
                    <br/>
                    Number of Objects : ${countObjects}
                    
                </div>
            </div>
        </div>
        <div class="row">
            <div class="col-md-12">
                <div class="jumbotron clearfix">
                    <h3>Objects collection</h3>
                    
                    <c:forEach items="${listItems}" var="obj">
                        <div class="col-md-3">
                            <img src="${pageContext.request.contextPath}/images/${obj.picture}" alt="image"  class="obj-image"/>
                            <p class="title">${obj.title}</p>
                            <p class="price">${obj.price}</p>
                            <p class="description">${obj.description}</p>

                            
                            <c:url value="/user/item/remove" var="deleteItem">
                                <c:param name="id" value="${obj.id}"/>
                            </c:url>
                            
                            <a href="${deleteItem}">Delete</a>
                        </div>
                    </c:forEach>
                    
                    <!--
                    <c:if test="${not empty username}">
                        <p>Hello ${username}</p>
                        <a href="/4JVA/updateUser"><input type="button" value="Update user" name="updateUser"/></a>
                        <a href="/4JVA/addItem"><input type="button" value="Add item" name="addItem"/></a>
                        <a href="/4JVA/logout"><input type="button" value="LogOut" name="lougout"/></a>

                    </c:if>

                    <a href="/4JVA/addUser"><input type="button" value="Register" name="addUser"/></a>
                    <a href="/4JVA/login"><input type="button" value="Login" name="Login"/></a>
                    -->
                </div>
            </div>
        </div>
    </div>
                        
    <%@ include file="template/scripts.jsp" %>
    </body>
</html>