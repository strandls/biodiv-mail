Hi ${name}, <br/><br/>

<a target="_blank" href="${serverUrl}/user/show/${inviter.id?c}">${inviter.name}</a> is inviting you to be a 
<#if role=="Founder">
founder for the
<#elseif role=="Moderator">
moderator for the
<#else>
member in this
</#if> group&nbsp; - 
<a target="_blank" href="${serverUrl}/group/${group.webAddress}/show">${group.name}</a> on <strong>India Biodiversity Portal</strong>.
<br/><br/>

Please <a href="${encrypted_key}" target="_blank">click here</a> to confirm the invitation.

<br/><br/>

Thank you,
The Portal Team