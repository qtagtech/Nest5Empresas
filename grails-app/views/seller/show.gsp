
<%@ page import="com.nest5.Nest5Client.Seller" %>
<!DOCTYPE html>
<html>
	<head>
		<meta name="layout" content="main_users_new">
		<g:set var="entityName" value="${message(code: 'seller.label', default: 'Seller')}" />
		<title><g:message code="default.show.label" args="[entityName]" /></title>
	</head>
	<body>
		<a href="#show-seller" class="skip" tabindex="-1"><g:message code="default.link.skip.label" default="Skip to content&hellip;"/></a>
		<div class="nav" role="navigation">
			<ul>
				<li><a class="home" href="${createLink(uri: '/')}"><g:message code="default.home.label"/></a></li>
				<li><g:link class="list" action="index"><g:message code="default.list.label" args="[entityName]" /></g:link></li>
				<li><g:link class="create" action="create"><g:message code="default.new.label" args="[entityName]" /></g:link></li>
			</ul>
		</div>
		<div id="show-seller" class="content scaffold-show" role="main">
			<h1><g:message code="default.show.label" args="[entityName]" /></h1>
			<g:if test="${flash.message}">
			<div class="message" role="status">${flash.message}</div>
			</g:if>
			<ol class="property-list seller">
			
				<g:if test="${sellerInstance?.username}">
				<li class="fieldcontain">
					<span id="username-label" class="property-label"><g:message code="seller.username.label" default="Username" /></span>
					
						<span class="property-value" aria-labelledby="username-label"><g:fieldValue bean="${sellerInstance}" field="username"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${sellerInstance?.password}">
				<li class="fieldcontain">
					<span id="password-label" class="property-label"><g:message code="seller.password.label" default="Password" /></span>
					
						<span class="property-value" aria-labelledby="password-label"><g:fieldValue bean="${sellerInstance}" field="password"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${sellerInstance?.accountExpired}">
				<li class="fieldcontain">
					<span id="accountExpired-label" class="property-label"><g:message code="seller.accountExpired.label" default="Account Expired" /></span>
					
						<span class="property-value" aria-labelledby="accountExpired-label"><g:formatBoolean boolean="${sellerInstance?.accountExpired}" /></span>
					
				</li>
				</g:if>
			
				<g:if test="${sellerInstance?.accountLocked}">
				<li class="fieldcontain">
					<span id="accountLocked-label" class="property-label"><g:message code="seller.accountLocked.label" default="Account Locked" /></span>
					
						<span class="property-value" aria-labelledby="accountLocked-label"><g:formatBoolean boolean="${sellerInstance?.accountLocked}" /></span>
					
				</li>
				</g:if>
			
				<g:if test="${sellerInstance?.active}">
				<li class="fieldcontain">
					<span id="active-label" class="property-label"><g:message code="seller.active.label" default="Active" /></span>
					
						<span class="property-value" aria-labelledby="active-label"><g:formatBoolean boolean="${sellerInstance?.active}" /></span>
					
				</li>
				</g:if>
			
				<g:if test="${sellerInstance?.company}">
				<li class="fieldcontain">
					<span id="company-label" class="property-label"><g:message code="seller.company.label" default="Company" /></span>
					
						<span class="property-value" aria-labelledby="company-label"><g:link controller="company" action="show" id="${sellerInstance?.company?.id}">${sellerInstance?.company?.encodeAsHTML()}</g:link></span>
					
				</li>
				</g:if>
			
				<g:if test="${sellerInstance?.email}">
				<li class="fieldcontain">
					<span id="email-label" class="property-label"><g:message code="seller.email.label" default="Email" /></span>
					
						<span class="property-value" aria-labelledby="email-label"><g:fieldValue bean="${sellerInstance}" field="email"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${sellerInstance?.enabled}">
				<li class="fieldcontain">
					<span id="enabled-label" class="property-label"><g:message code="seller.enabled.label" default="Enabled" /></span>
					
						<span class="property-value" aria-labelledby="enabled-label"><g:formatBoolean boolean="${sellerInstance?.enabled}" /></span>
					
				</li>
				</g:if>
			
				<g:if test="${sellerInstance?.identification}">
				<li class="fieldcontain">
					<span id="identification-label" class="property-label"><g:message code="seller.identification.label" default="Identification" /></span>
					
						<span class="property-value" aria-labelledby="identification-label"><g:fieldValue bean="${sellerInstance}" field="identification"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${sellerInstance?.name}">
				<li class="fieldcontain">
					<span id="name-label" class="property-label"><g:message code="seller.name.label" default="Name" /></span>
					
						<span class="property-value" aria-labelledby="name-label"><g:fieldValue bean="${sellerInstance}" field="name"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${sellerInstance?.passwordExpired}">
				<li class="fieldcontain">
					<span id="passwordExpired-label" class="property-label"><g:message code="seller.passwordExpired.label" default="Password Expired" /></span>
					
						<span class="property-value" aria-labelledby="passwordExpired-label"><g:formatBoolean boolean="${sellerInstance?.passwordExpired}" /></span>
					
				</li>
				</g:if>
			
				<g:if test="${sellerInstance?.registerDate}">
				<li class="fieldcontain">
					<span id="registerDate-label" class="property-label"><g:message code="seller.registerDate.label" default="Register Date" /></span>
					
						<span class="property-value" aria-labelledby="registerDate-label"><g:formatDate date="${sellerInstance?.registerDate}" /></span>
					
				</li>
				</g:if>
			
				<g:if test="${sellerInstance?.telephone}">
				<li class="fieldcontain">
					<span id="telephone-label" class="property-label"><g:message code="seller.telephone.label" default="Telephone" /></span>
					
						<span class="property-value" aria-labelledby="telephone-label"><g:fieldValue bean="${sellerInstance}" field="telephone"/></span>
					
				</li>
				</g:if>
			
			</ol>
			<g:form url="[resource:sellerInstance, action:'delete']" method="DELETE">
				<fieldset class="buttons">
					<g:link class="edit" action="edit" resource="${sellerInstance}"><g:message code="default.button.edit.label" default="Edit" /></g:link>
					<g:actionSubmit class="delete" action="delete" value="${message(code: 'default.button.delete.label', default: 'Delete')}" onclick="return confirm('${message(code: 'default.button.delete.confirm.message', default: 'Are you sure?')}');" />
				</fieldset>
			</g:form>
		</div>
	</body>
</html>
