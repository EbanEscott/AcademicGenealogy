<%@ page import="academicgenealogy.Academic" %>



<div class="fieldcontain ${hasErrors(bean: academicInstance, field: 'firstName', 'error')} required">
	<label for="firstName">
		<g:message code="academic.firstName.label" default="First Name" />
		<span class="required-indicator">*</span>
	</label>
	<g:textField name="firstName" maxlength="50" required="" value="${academicInstance?.firstName}"/>
</div>

<div class="fieldcontain ${hasErrors(bean: academicInstance, field: 'middleName', 'error')} ">
	<label for="middleName">
		<g:message code="academic.middleName.label" default="Middle Name" />
		
	</label>
	<g:textField name="middleName" maxlength="50" value="${academicInstance?.middleName}"/>
</div>

<div class="fieldcontain ${hasErrors(bean: academicInstance, field: 'lastName', 'error')} required">
	<label for="lastName">
		<g:message code="academic.lastName.label" default="Last Name" />
		<span class="required-indicator">*</span>
	</label>
	<g:textField name="lastName" maxlength="50" required="" value="${academicInstance?.lastName}"/>
</div>

<div class="fieldcontain ${hasErrors(bean: academicInstance, field: 'published', 'error')} ">
	<label for="published">
		<g:message code="academic.published.label" default="Published" />
		
	</label>
	<g:select id="published" name="published.id" from="${academicgenealogy.Thesis.list()}" optionKey="id" value="${academicInstance?.published?.id}" class="many-to-one" noSelection="['null': '']"/>
</div>

<div class="fieldcontain ${hasErrors(bean: academicInstance, field: 'country', 'error')} required">
	<label for="country">
		<g:message code="academic.country.label" default="Country" />
		<span class="required-indicator">*</span>
	</label>
	<g:select id="country" name="country.id" from="${academicgenealogy.Country.list()}" optionKey="id" required="" value="${academicInstance?.country?.id}" class="many-to-one"/>
</div>

<div class="fieldcontain ${hasErrors(bean: academicInstance, field: 'institution', 'error')} required">
	<label for="institution">
		<g:message code="academic.institution.label" default="Institution" />
		<span class="required-indicator">*</span>
	</label>
	<g:select id="institution" name="institution.id" from="${academicgenealogy.Institution.list()}" optionKey="id" required="" value="${academicInstance?.institution?.id}" class="many-to-one"/>
</div>

<div class="fieldcontain ${hasErrors(bean: academicInstance, field: 'supervises', 'error')} ">
	<label for="supervises">
		<g:message code="academic.supervises.label" default="Supervises" />
		
	</label>
	
<ul class="one-to-many">
<g:each in="${academicInstance?.supervises?}" var="s">
    <li><g:link controller="academic" action="show" id="${s.id}">${s?.encodeAsHTML()}</g:link></li>
</g:each>
<li class="add">
<g:link controller="academic" action="create" params="['academic.id': academicInstance?.id]">${message(code: 'default.add.label', args: [message(code: 'academic.label', default: 'Academic')])}</g:link>
</li>
</ul>

</div>

<div class="fieldcontain ${hasErrors(bean: academicInstance, field: 'supervisor', 'error')} required">
	<label for="supervisor">
		<g:message code="academic.supervisor.label" default="Supervisor" />
		<span class="required-indicator">*</span>
	</label>
	<g:select id="supervisor" name="supervisor.id" from="${academicgenealogy.Academic.list()}" optionKey="id" required="" value="${academicInstance?.supervisor?.id}" class="many-to-one"/>
</div>

