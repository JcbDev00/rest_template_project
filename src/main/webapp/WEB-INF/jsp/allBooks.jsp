<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<h1>All Books</h1>
<table>
    <tr>
        <th>Title</th>
        <th>Edit</th>
        <th>Delete</th>
    </tr>
    
        <c:forEach items="${books}" var="book">
           <tr>
            <td>${book.title}</td>
            <td><a href="/books/edit/${book.id}">Edit</a></td>
            <td><a href="/books/delete/${book.id}">Delete</a></td>
           </tr>
        </c:forEach>
    
</table>