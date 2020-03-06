Hi ${username},<br/><br/>
You (or someone pretending to be you) 
<#if type=="RESET_PASSWORD">
	requested that your password be reset.<br/><br/>
	OTP: <b>${otp}</b><br/><br/>
	If you didn't make this request then ignore the email; no changes have been made.<br/><br/>
	If you did make the request, enter the otp to reset your password.<br/><br/>
<#else>
	created an account with this email address.<br/><br/>
	OTP: <b>${otp}</b><br/><br/>
	If you made the request, please enter the otp to finish the registration and activate your account.<br/><br/>
</#if>
Regards,<br/>
The portal team.