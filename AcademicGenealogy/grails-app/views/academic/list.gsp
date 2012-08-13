<%@ page import="academicgenealogy.Academic" %>
<!doctype html>
<html>
	<head>
		<meta name="layout" content="main">
		<g:set var="entityName" value="${message(code: 'academic.label', default: 'Academic')}" />
		<title><g:message code="default.list.label" args="[entityName]" /></title>
	</head>
	<body>
		<a href="#list-academic" class="skip" tabindex="-1"><g:message code="default.link.skip.label" default="Skip to content&hellip;"/></a>
		<div class="nav" role="navigation">
			<ul>
				<li><a class="home" href="${createLink(uri: '/')}"><g:message code="default.home.label"/></a></li>
				<li><g:link class="create" action="create"><g:message code="default.new.label" args="[entityName]" /></g:link></li>
				<li><sec:ifLoggedIn><g:link controller="logout">Logout</g:link></sec:ifLoggedIn></li>
			</ul>
		</div>
		<div id="list-academic" class="content scaffold-list" role="main">
			<h1><g:message code="default.list.label" args="[entityName]" /></h1>
			<g:if test="${flash.message}">
			<div class="message" role="status">${flash.message}</div>
			</g:if>
			<table>
				<thead>
					<tr>
					
						<g:sortableColumn property="firstName" title="${message(code: 'academic.firstName.label', default: 'First Name')}" />
					
						<g:sortableColumn property="middleName" title="${message(code: 'academic.middleName.label', default: 'Middle Name')}" />
					
						<g:sortableColumn property="lastName" title="${message(code: 'academic.lastName.label', default: 'Last Name')}" />
					
						<th><g:message code="academic.published.label" default="Published" /></th>
					
						<th><g:message code="academic.country.label" default="Country" /></th>
					
						<th><g:message code="academic.institution.label" default="Institution" /></th>
					
					</tr>
				</thead>
				<tbody>
				<g:each in="${academicInstanceList}" status="i" var="academicInstance">
					<tr class="${(i % 2) == 0 ? 'even' : 'odd'}">
					
						<td><g:link action="show" id="${academicInstance.id}">${fieldValue(bean: academicInstance, field: "firstName")}</g:link></td>
					
						<td>${fieldValue(bean: academicInstance, field: "middleName")}</td>
					
						<td>${fieldValue(bean: academicInstance, field: "lastName")}</td>
					
						<td>${fieldValue(bean: academicInstance, field: "published")}</td>
					
						<td>${fieldValue(bean: academicInstance, field: "country")}</td>
					
						<td>${fieldValue(bean: academicInstance, field: "institution")}</td>
					
					</tr>
				</g:each>
				</tbody>
			</table>
			<div class="pagination">
				<g:paginate total="${academicInstanceTotal}" />
			</div>
		</div>
	</body>
</html>
