<%@ taglib prefix="c" uri="jakarta.tags.core" %>

<html>
    <head>
        <link href="webjars/bootstrap/5.1.3/css/bootstrap.min.css" rel="stylesheet" >
        <title>To Do List</title>
    </head>
    <body>
        <div class="container">
            <div>Welcome ${name}</div>
            <hr>
            <h1>Your todos are</h1>
            <table class="table">
                <thead>
                    <tr>
                        <th>Description</th>
                        <th>Target Date</th>
                        <th>Is Done?</th>
                        <th></th>
                        <th></th>
                    </tr>
                </thead>
                <tbody>
                    <c:forEach items="${todos}" var="todo">
                        <tr>
                            <td>${todo.description}</td>
                            <td>${todo.targetDate}</td>
                            <td>${todo.done}</td>
                            <td>
                                <a href="delete-todo?id=${todo.id}" class="btn btn-warning">Delete</a>
                            </td>
                            <td>
                                <a href="update-todo?id=${todo.id}" class="btn btn-success">Update</a>
                            </td>
                        </tr>
                    </c:forEach>
                </tbody>
           </table>
           <a href="add-todo" class="btn btn-success">Add Todo</a>
        </div>
        <script src="webjars/bootstrap/5.1.3/js/bootstrap.min.js"></script>
        <script src="webjars/jquery/3.6.0/jquery.min.js"></script>
    </body>
</html>