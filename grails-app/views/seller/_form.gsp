<%@ page import="com.nest5.Nest5Client.Seller" %>



<div class="fieldcontain ${hasErrors(bean: sellerInstance, field: 'username', 'error')} required">
	<label for="username">
		<g:message code="seller.username.label" default="Username" />
		<span class="required-indicator">*</span>
	</label>
	<g:textField name="username" required="" value="${sellerInstance?.username}"/>

</div>

<div class="fieldcontain ${hasErrors(bean: sellerInstance, field: 'password', 'error')} required">
	<label for="password">
		<g:message code="seller.password.label" default="Password" />
		<span class="required-indicator">*</span>
	</label>
	<g:textField name="password" required="" value="${sellerInstance?.password}"/>

</div>

<div class="fieldcontain ${hasErrors(bean: sellerInstance, field: 'accountExpired', 'error')} ">
	<label for="accountExpired">
		<g:message code="seller.accountExpired.label" default="Account Expired" />
		
	</label>
	<g:checkBox name="accountExpired" value="${sellerInstance?.accountExpired}" />

</div>

<div class="fieldcontain ${hasErrors(bean: sellerInstance, field: 'accountLocked', 'error')} ">
	<label for="accountLocked">
		<g:message code="seller.accountLocked.label" default="Account Locked" />
		
	</label>
	<g:checkBox name="accountLocked" value="${sellerInstance?.accountLocked}" />

</div>

<div class="fieldcontain ${hasErrors(bean: sellerInstance, field: 'active', 'error')} ">
	<label for="active">
		<g:message code="seller.active.label" default="Active" />
		
	</label>
	<g:checkBox name="active" value="${sellerInstance?.active}" />

</div>

<div class="fieldcontain ${hasErrors(bean: sellerInstance, field: 'company', 'error')} required">
	<label for="company">
		<g:message code="seller.company.label" default="Company" />
		<span class="required-indicator">*</span>
	</label>
	<g:select id="company" name="company.id" from="${com.nest5.Nest5Client.Company.list()}" optionKey="id" required="" value="${sellerInstance?.company?.id}" class="many-to-one"/>

</div>

<div class="fieldcontain ${hasErrors(bean: sellerInstance, field: 'email', 'error')} required">
	<label for="email">
		<g:message code="seller.email.label" default="Email" />
		<span class="required-indicator">*</span>
	</label>
	<g:textField name="email" required="" value="${sellerInstance?.email}"/>

</div>

<div class="fieldcontain ${hasErrors(bean: sellerInstance, field: 'enabled', 'error')} ">
	<label for="enabled">
		<g:message code="seller.enabled.label" default="Enabled" />
		
	</label>
	<g:checkBox name="enabled" value="${sellerInstance?.enabled}" />

</div>

<div class="fieldcontain ${hasErrors(bean: sellerInstance, field: 'identification', 'error')} required">
	<label for="identification">
		<g:message code="seller.identification.label" default="Identification" />
		<span class="required-indicator">*</span>
	</label>
	<g:textField name="identification" required="" value="${sellerInstance?.identification}"/>

</div>

<div class="fieldcontain ${hasErrors(bean: sellerInstance, field: 'name', 'error')} required">
	<label for="name">
		<g:message code="seller.name.label" default="Name" />
		<span class="required-indicator">*</span>
	</label>
	<g:textField name="name" required="" value="${sellerInstance?.name}"/>

</div>

<div class="fieldcontain ${hasErrors(bean: sellerInstance, field: 'passwordExpired', 'error')} ">
	<label for="passwordExpired">
		<g:message code="seller.passwordExpired.label" default="Password Expired" />
		
	</label>
	<g:checkBox name="passwordExpired" value="${sellerInstance?.passwordExpired}" />

</div>

<div class="fieldcontain ${hasErrors(bean: sellerInstance, field: 'registerDate', 'error')} required">
	<label for="registerDate">
		<g:message code="seller.registerDate.label" default="Register Date" />
		<span class="required-indicator">*</span>
	</label>
	<g:datePicker name="registerDate" precision="day"  value="${sellerInstance?.registerDate}"  />

</div>

<div class="fieldcontain ${hasErrors(bean: sellerInstance, field: 'telephone', 'error')} required">
	<label for="telephone">
		<g:message code="seller.telephone.label" default="Telephone" />
		<span class="required-indicator">*</span>
	</label>
	<g:textField name="telephone" required="" value="${sellerInstance?.telephone}"/>

</div>

