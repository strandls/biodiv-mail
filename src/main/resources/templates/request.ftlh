Hi ${name},<br/><br/>

<a href="${serverUrl}/user/show/${requestor.id?c}" target="_blank">${requestor.name}</a> is requesting 
to be a member of the group <a href="
<#if group.webAddress?starts_with("/group")>
${serverUrl}${group.webAddress}/show
<#else>
${group.webAddress}
</#if>
" target="_blank">${group.name}</a>
which you are an administrator of on the India Biodiversity Portal.<br/><br/>

Please <a href="
<#if group.webAddress?starts_with("/group")>
${serverUrl}${group.webAddress}/continue/verify-request?token=${encrypted_key}
<#else>
${group.webAddress}/continue/verify-request?token=${encrypted_key}
</#if>
" target="_blank">click here</a> to approve the request. 
To deny, you need not perform any action.

<br/><br/>

Thank you,<br/>
The Portal Team