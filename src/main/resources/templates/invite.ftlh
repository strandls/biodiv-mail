Hi ${name}, <br/><br/>

<a target="_blank" href="${serverUrl}/user/show/${inviter.id?c}">${inviter.name}</a> is inviting you to be a founder for the group - 
<a target="_blank" href="${serverUrl}/group/${group.webAddress}/show">${group.name}</a> on <strong>India Biodiversity Portal</strong>.
<br/><br/>

<i>
You are invited to be a&nbsp;
<#if role=="Founder">
founder for the
<#elseif role=="Moderator">
moderator for the
<#else>
member in this
</#if>
&nbsp;group. Please click on the link to accept. (Due to some error while updating the group, we have to re-send this invite).
</i>
<br/><br/>

Please click here to confirm the invitation.
<br/><br/>
Thank you,
The Portal Team