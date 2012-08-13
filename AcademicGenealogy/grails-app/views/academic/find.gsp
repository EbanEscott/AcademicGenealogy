<%@ page import="academicgenealogy.Academic" %>
<!doctype html>
<html>
	<head>
	    <resource:treeView />
	    <resource:autoComplete skin="default" />
		<meta name="layout" content="main">
		<title>Genealogy Tree</title>
	</head>
	<body>
		<div class="nav" role="navigation">
			<ul>
				<li><a class="home" href="${createLink(uri: '/')}"><g:message code="default.home.label"/></a></li>
				<li><g:link class="list" action="list">Academic List</g:link></li>
				<li><sec:ifLoggedIn><g:link controller="logout">Logout</g:link></sec:ifLoggedIn></li>
			</ul>
		</div>
		
		<div id="show-academic" class="content scaffold-show" role="main">
			<h1>Genealogy Tree</h1>
			
			<ol type="none">
			
				<g:form name="searchForm" action="find">
				<li class="fieldcontain">
					<span id="searchForm" class="property-label">Name:</span>
						    <span class="property-value" aria-labelledby="label">
						        <g:if test="${!params.name}">
            					    <richui:autoComplete name="name" action="${createLinkTo('dir': 'academic/autoSearch')}" forceSelection="true"/>
        					    </g:if>
        					    <g:else>
						    	    <richui:autoComplete name="name" action="${createLinkTo('dir': 'academic/autoSearch')}" forceSelection="true" value="$params.name" />
        					    </g:else>
						    </span>
			    </li>
			    <li class="fieldcontain">
					<span id="searchForm" class="property-label">Depth:</span>
						    <span class="property-value" aria-labelledby="label">
						        <g:if test="${!params.depth}">
						            <g:select name="depth" from="${1..5}" value='5' />
						        </g:if>
						        <g:else>
						    	    <g:select name="depth" from="${1..5}" value="$params.depth" />
						    	</g:else>
						    </span>
				</li>
				<li class="fieldcontain">
					<span id="searchForm" class="property-label"></span>
						    <span class="property-value" aria-labelledby="label">
                            	<input type="submit" value="Show Academic Genealogy" />
                            </span>
				</li>
             	</g:form>
             	
             	<li class="fieldcontain">
					<span id="searchForm" class="property-label">Tree:</span>
						<span class="property-value" aria-labelledby="label">
				        	<g:if test="${data!=''}">
            					<richui:treeView xml="${data}" onLabelClick="document.location.href = '${createLinkTo(dir: 'academic/show')}/' + id;"/>
        					</g:if>
        					<g:else>
        						NA
        					</g:else>
        				</span>
				</li>
			</ol>
		</div>
    </body>
</html>