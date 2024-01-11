<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %> 
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>

<html>
    <body>
        <h1>Edit book</h1>
      <form:form modelAttribute="form" method="POST" action="/books/save">
        <form:errors path="" element="div" />
        <div>
            <form:hidden path="id" />
            <form:label path="title">title</form:label>
            <form:input path="title" />
            <form:errors path="title" />
        </div>
        <div>
            <input type="submit" value="Save" />
        </div>
      </form:form>
    </body>
</html>
