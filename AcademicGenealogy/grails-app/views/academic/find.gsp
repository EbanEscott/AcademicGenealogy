<%@ page import="academicgenealogy.Academic" %>
<!doctype html>
<html>
	<head>
		<meta name="layout" content="main">
		<title>Search</title>
	</head>
	<body>
        <g:form name="searchForm" action="tree">
        ${fieldValue(bean: academicInstance, field: "middleName")}
            Surname:<g:textField name="lastName"/>
            Depth:<g:select name="depth" from="${1..5}" />
            <input type="submit" value="Go" />
        </g:form>
        
        <g:each in="${ academics }" var="academic">
            <li>${ academic.firstName }</li>
        </g:each>
    </body>
</html> 