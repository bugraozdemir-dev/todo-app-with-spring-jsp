<%@ include file="common/header.jspf"  %>
<%@ include file="common/navigation.jspf"  %>
<div class="container">
    <h1>Todo Details</h1>
    <form:form method="post" modelAttribute="todo">
        <form:hidden path="id"/>
        <form:hidden path="done"/>
        <form:hidden path="username"/>

        <fieldset class="mb-3">
           <form:label path="description">Description</form:label>
           <form:input path="description" type="text" name="description" required="required" />
           <form:errors path="description" cssClass="text-warning" />
        </fieldset>

        <fieldset class="mb-3">
           <form:label path="targetDate">Target Date</form:label>
           <form:input class="datepicker" path="targetDate" type="text" name="targetDate" required="required" />
           <form:errors path="targetDate" cssClass="text-warning" />
        </fieldset>

        <input type="submit" class="btn btn-success" />
    </form:form>
</div>
<%@ include file="common/footer.jspf"  %>
<script type="text/javascript">
    $('#targetDate').datepicker({
        format: 'yyyy-mm-dd'
    });
</script>
