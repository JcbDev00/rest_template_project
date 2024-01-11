<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
    <body>
        <h1>Add new expense</h1>

        <form:form modelAttribute="form" action="/expenses/save" >
            <form:errors path="" element="div" />
            <div>
                <form:label path="title">Title</form:label>
                <form:input path="title"/>
                <form:errors path="title" />
            </div>
            <div>
                <form:label path="amount">Amount</form:label>
                <form:input type="number" path="amount"/>
                <form:errors path="amount" />
            </div>
            <div>
                <input type="submit" />
            </div>
        </form:form>
    </body>
</html>