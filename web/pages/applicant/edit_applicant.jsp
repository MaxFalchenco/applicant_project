<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title><c:out value="${title}"/></title>
    <%@include file="../include/style.jsp" %>
</head>
<body>
<%@include file="../include/template.jsp" %>
<div class="container">
    <fieldset>
        <legend><c:out value="${title}"/></legend>

        <form method="post" action="controller?command=saveApplicant">
            <c:choose>
                <c:when test="${applicant ne null}">
                    <span>First Name</span>
                    <input type="text" name="first_name"
                           value="${applicant.getFirstName()}"/><br/>
                    <span>Last Name</span>
                    <input type="text" name="last_name" value="${applicant.getLastName()}"/><br/>
                    <span>Profession id</span>
                    <input type="text" name="profession_id"
                           value="${applicant.getProfessionId()}"/><br/>
                    <span>Entrance Year</span>
                    <input type="text" name="entrance_year"
                           value="${applicant.getEntranceYear()}"/>
                    <input type="hidden" name="applicant_id" value="${applicant.getId()}"/><br/>
                </c:when>
                <c:otherwise>
                    <span>First Name</span>
                    <input type="text" name="first_name"/><br/>
                    <span>Last Name</span>
                    <input type="text" name="last_name"/><br/>
                    <span>Profession</span>
                    <input type="text" name="profession_id"/><br/>
                    <%--<select>--%>
                        <%--<c:forEach items="${professions}" var="profession">--%>
                            <%--<option value="${profession.getProfessionName()}">${profession.getProfessionName()}</option>--%>
                        <%--</c:forEach>--%>
                    <%--</select><br/>--%>
                    <span>Entrance Year</span>
                    <input type="text" name="entrance_year"/><br/>
                </c:otherwise>
            </c:choose>
            <input type="submit" value="Save"/>
        </form>
    </fieldset>
</div>
</body>
</html>
