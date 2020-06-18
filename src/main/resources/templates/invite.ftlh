Hi ${name}, <br/><br/>

<a target="_blank" href="${serverUrl}/user/show/${inviter.id?c}">${inviter.name}</a> is inviting you to be a 
<#if role=="Founder">
founder for the
<#elseif role=="Moderator">
moderator for the
<#else>
member in this
</#if> group&nbsp; - 
<a target="_blank" href="
<#if group.webAddress?starts_with("/group")>
${serverUrl}${group.webAddress}/continue/verify-invitation?token=${encrypted_key}
<#else>
${group.webAddress}/continue/verify-invitation?token=${encrypted_key}
</#if>
">${group.name}</a> on <strong>India Biodiversity Portal</strong>.
<br/><br/>

${encrypted_key}

Please <a href="
<#if group.webAddress?starts_with("/group")>
${serverUrl}${group.webAddress}/continue/verify-invitation?token=${encrypted_key}
<#else>
${group.webAddress}/continue/verify-invitation?token=${encrypted_key}
</#if>
" target="_blank">click here</a> to confirm the invitation.

<br/><br/>

Thank you,
The Portal Team