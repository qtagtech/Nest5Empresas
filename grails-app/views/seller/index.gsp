
<%@ page import="com.nest5.Nest5Client.Seller" %>
<!DOCTYPE html>
<html>
	<head>
		<meta name="layout" content="main_users_new">
		<g:set var="entityName" value="${message(code: 'seller.label', default: 'Seller')}" />
		<title><g:message code="default.list.label" args="[entityName]" /></title>
	</head>
	<body>
		<a href="#list-seller" class="skip" tabindex="-1"><g:message code="default.link.skip.label" default="Skip to content&hellip;"/></a>
		<div class="nav" role="navigation">
			<ul>
				<li><a class="home" href="${createLink(uri: '/')}"><g:message code="default.home.label"/></a></li>
				<li><g:link class="create" action="create"><g:message code="default.new.label" args="[entityName]" /></g:link></li>
			</ul>
		</div>
		<div id="list-seller" class="content scaffold-list" role="main">
			<h1><g:message code="default.list.label" args="[entityName]" /></h1>
			<g:if test="${flash.message}">
				<div class="message" role="status">${flash.message}</div>
			</g:if>
			<table>
			<thead>
					<tr>
					
						<g:sortableColumn property="username" title="${message(code: 'seller.username.label', default: 'Username')}" />
					
						<g:sortableColumn property="password" title="${message(code: 'seller.password.label', default: 'Password')}" />
					
						<g:sortableColumn property="accountExpired" title="${message(code: 'seller.accountExpired.label', default: 'Account Expired')}" />
					
						<g:sortableColumn property="accountLocked" title="${message(code: 'seller.accountLocked.label', default: 'Account Locked')}" />
					
						<g:sortableColumn property="active" title="${message(code: 'seller.active.label', default: 'Active')}" />
					
						<th><g:message code="seller.company.label" default="Company" /></th>
					
					</tr>
				</thead>
				<tbody>
				<g:each in="${sellerInstanceList}" status="i" var="sellerInstance">
					<tr class="${(i % 2) == 0 ? 'even' : 'odd'}">
					
						<td><g:link action="show" id="${sellerInstance.id}">${fieldValue(bean: sellerInstance, field: "username")}</g:link></td>
					
						<td>${fieldValue(bean: sellerInstance, field: "password")}</td>
					
						<td><g:formatBoolean boolean="${sellerInstance.accountExpired}" /></td>
					
						<td><g:formatBoolean boolean="${sellerInstance.accountLocked}" /></td>
					
						<td><g:formatBoolean boolean="${sellerInstance.active}" /></td>
					
						<td>${fieldValue(bean: sellerInstance, field: "company")}</td>
					
					</tr>
				</g:each>
				</tbody>
			</table>
			<div class="pagination">
				<g:paginate total="${sellerInstanceCount ?: 0}" />
			</div>
		</div>
	</body>
</html>
