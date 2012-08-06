
<%@ page import="academicgenealogy.Academic" %>
<!doctype html>
<html>
	<head>
		<meta name="layout" content="main">
		<g:set var="entityName" value="${message(code: 'academic.label', default: 'Academic')}" />
		<title><g:message code="default.show.label" args="[entityName]" /></title>
	</head>
	<body>
		<a href="#show-academic" class="skip" tabindex="-1"><g:message code="default.link.skip.label" default="Skip to content&hellip;"/></a>
		<div class="nav" role="navigation">
			<ul>
				<li><a class="home" href="${createLink(uri: '/')}"><g:message code="default.home.label"/></a></li>
				<li><g:link class="list" action="list"><g:message code="default.list.label" args="[entityName]" /></g:link></li>
				<li><g:link class="create" action="create"><g:message code="default.new.label" args="[entityName]" /></g:link></li>
			</ul>
		</div>
		<div id="show-academic" class="content scaffold-show" role="main">
			<h1><g:message code="default.show.label" args="[entityName]" /></h1>
			<g:if test="${flash.message}">
			<div class="message" role="status">${flash.message}</div>
			</g:if>
			<ol class="property-list academic">
			
				<g:if test="${academicInstance?.firstName}">
				<li class="fieldcontain">
					<span id="firstName-label" class="property-label"><g:message code="academic.firstName.label" default="First Name" /></span>
					
						<span class="property-value" aria-labelledby="firstName-label"><g:fieldValue bean="${academicInstance}" field="firstName"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${academicInstance?.middleName}">
				<li class="fieldcontain">
					<span id="middleName-label" class="property-label"><g:message code="academic.middleName.label" default="Middle Name" /></span>
					
						<span class="property-value" aria-labelledby="middleName-label"><g:fieldValue bean="${academicInstance}" field="middleName"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${academicInstance?.lastName}">
				<li class="fieldcontain">
					<span id="lastName-label" class="property-label"><g:message code="academic.lastName.label" default="Last Name" /></span>
					
						<span class="property-value" aria-labelledby="lastName-label"><g:fieldValue bean="${academicInstance}" field="lastName"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${academicInstance?.published}">
				<li class="fieldcontain">
					<span id="published-label" class="property-label"><g:message code="academic.published.label" default="Published" /></span>
					
						<span class="property-value" aria-labelledby="published-label"><g:link controller="thesis" action="show" id="${academicInstance?.published?.id}">${academicInstance?.published?.encodeAsHTML()}</g:link></span>
					
				</li>
				</g:if>
			
				<g:if test="${academicInstance?.country}">
				<li class="fieldcontain">
					<span id="country-label" class="property-label"><g:message code="academic.country.label" default="Country" /></span>
					
						<span class="property-value" aria-labelledby="country-label"><g:link controller="country" action="show" id="${academicInstance?.country?.id}">${academicInstance?.country?.encodeAsHTML()}</g:link></span>
					
				</li>
				</g:if>
			
				<g:if test="${academicInstance?.institution}">
				<li class="fieldcontain">
					<span id="institution-label" class="property-label"><g:message code="academic.institution.label" default="Institution" /></span>
					
						<span class="property-value" aria-labelledby="institution-label"><g:link controller="institution" action="show" id="${academicInstance?.institution?.id}">${academicInstance?.institution?.encodeAsHTML()}</g:link></span>
					
				</li>
				</g:if>
			
				<g:if test="${academicInstance?.supervises}">
				<li class="fieldcontain">
					<span id="supervises-label" class="property-label"><g:message code="academic.supervises.label" default="Supervises" /></span>
					
						<g:each in="${academicInstance.supervises}" var="s">
						<span class="property-value" aria-labelledby="supervises-label"><g:link controller="academic" action="show" id="${s.id}">${s?.encodeAsHTML()}</g:link></span>
						</g:each>
					
				</li>
				</g:if>
			
				<g:if test="${academicInstance?.supervisor}">
				<li class="fieldcontain">
					<span id="supervisor-label" class="property-label"><g:message code="academic.supervisor.label" default="Supervisor" /></span>
					
						<span class="property-value" aria-labelledby="supervisor-label"><g:link controller="academic" action="show" id="${academicInstance?.supervisor?.id}">${academicInstance?.supervisor?.encodeAsHTML()}</g:link></span>
					
				</li>
				</g:if>
				
				<li class="fieldcontain">
					<span id="tree-label" class="property-label">Create Tree</span>
						<span class="property-value" aria-labelledby="tree-label"><g:link controller="academic" action="find" params="[name: academicInstance.lastName, depth:'5']">Generate</g:link></span>
					
				</li>
			
			</ol>
			<g:form>
				<fieldset class="buttons">
					<g:hiddenField name="id" value="${academicInstance?.id}" />
					<g:link class="edit" action="edit" id="${academicInstance?.id}"><g:message code="default.button.edit.label" default="Edit" /></g:link>
					<g:actionSubmit class="delete" action="delete" value="${message(code: 'default.button.delete.label', default: 'Delete')}" onclick="return confirm('${message(code: 'default.button.delete.confirm.message', default: 'Are you sure?')}');" />
				</fieldset>
			</g:form>
		</div>
	</body>
</html>
