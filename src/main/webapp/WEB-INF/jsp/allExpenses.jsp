<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<h1>All Expenses</h1>

<table>
    <tr>
        <th>Title</th>
        <th>Edit</th>
        <th>Delete</th>
    </tr>
    
        <c:forEach items="${expenses}" var="expense">
           <tr>
            <td>${expense.title}</td>
            <td><a href="/expenses/edit/${expense.id}">Edit</a></td>
            <td><a href="/expenses/delete/${expense.id}">Delete</a></td>
           </tr>
        </c:forEach>
    
</table>