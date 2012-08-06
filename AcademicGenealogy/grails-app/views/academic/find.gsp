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
			</ul>
		</div>
		
		<div id="show-academic" class="content scaffold-show" role="main">
			<h1>Genealogy Tree</h1>
			
			<ol type="none">
			
				<g:form name="searchForm" action="find">
				<li class="fieldcontain">
					<span id="searchForm" class="property-label">Name:</span>
						    <span class="property-value" aria-labelledby="label">
						    	<richui:autoComplete name="name" action="${createLinkTo('dir': 'academic/autoSearch')}" forceSelection="true" value="$params.name" />
						    </span>
			    </li>
			    <li class="fieldcontain">
					<span id="searchForm" class="property-label">Depth:</span>
						    <span class="property-value" aria-labelledby="label">
						    	<g:select name="depth" from="${1..5}" value="$params.depth" />
						    </span>
				</li>
				<li class="fieldcontain">
					<span id="searchForm" class="property-label"></span>
						    <span class="property-value" aria-labelledby="label">
                            	<input type="submit" value="Create Tree" />
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