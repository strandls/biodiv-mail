<table bgcolor="#ECE9B7" style="margin: 0;padding: 0;font-family: &quot;Helvetica Neue&quot;, &quot;Helvetica&quot;, Helvetica, Arial, sans-serif;width: 100%; border-top: 1px solid #A1A376; border-left: 1px solid #A1A376; border-right: 1px solid #A1A376; width:610px;">
   <tr style="display: flex; justify-content: center;">
      <td style="margin: 0 auto;padding: 0;display: block;max-width: 600px;clear: both;">
         <div style="margin: 0 auto;padding: 2px;max-width: 600px;">
            <a style="line-height: 1;color: #000;font-weight: 200;font-size: 20px; text-decoration:none;">${siteName}</a>
         </div>
      </td>
      <td style="margin: 0;padding: 0;"></td>
   </tr>
</table>
<table style="margin:0;padding:0;width:100%;border:1px solid #a1a376;width:610px;font-family: &quot;Helvetica Neue&quot;, &quot;Helvetica&quot;, Helvetica, Arial, sans-serif;">
   <tbody>
      <tr style="margin:0;padding:0;">
         <td style="margin:0;padding:0;"></td>
         <td bgcolor="#FFFFFF" style="margin:0 auto;padding:0;display:block;max-width:600px;clear:both">
            <div style="margin:0 auto;padding:2px;max-width:610px;display:block">
               <table style="margin:0;padding:0;width:100%">
                  <tbody>
                     <tr style="margin:0;padding:0;">
                        <td style="margin:0;padding:0;">
                           <p style="margin:0;padding:0;margin-bottom:10px;font-weight:normal;font-size:14px;line-height:1">
                              <#if type=="COMMENT_POST">
                          		  Hi ${follower.name},<br><br>
	                              <a href="${serverUrl}/user/show/${whoPosted.id?c}" ><img src="${serverUrl}/biodiv/users/${whoPosted.icon}" style="margin:0;padding:0;max-width:30px;max-height:30px;display:inline-block;vertical-align:middle"></a>					
	                              <a href="${serverUrl}/user/show/${whoPosted.id?c}" > ${whoPosted.name}</a>		
	                              added a comment to the page listed below.
	                          <#elseif type=="FACT_UPDATED">
                          		  Hi ${follower.name},<br><br>
	                              <a href="${serverUrl}/user/show/${whoPosted.id?c}" ><img src="${serverUrl}/biodiv/users/${whoPosted.icon}" style="margin:0;padding:0;max-width:30px;max-height:30px;display:inline-block;vertical-align:middle"></a>					
	                              <a href="${serverUrl}/user/show/${whoPosted.id?c}" > ${whoPosted.name}</a>		
	                              updated a fact.
	                          <#elseif type=="TAG_UPDATED">
                          		  Hi ${follower.name},<br><br>
	                              <a href="${serverUrl}/user/show/${whoPosted.id?c}" ><img src="${serverUrl}/biodiv/users/${whoPosted.icon}" style="margin:0;padding:0;max-width:30px;max-height:30px;display:inline-block;vertical-align:middle"></a>					
	                              <a href="${serverUrl}/user/show/${whoPosted.id?c}" > ${whoPosted.name}</a>
	                              edited tags in the observation listed below
	                          <#elseif type=="CUSTOM_FIELD_UPDATED">
                          		  Hi ${follower.name},<br><br>
	                              <a href="${serverUrl}/user/show/${whoPosted.id?c}" ><img src="${serverUrl}/biodiv/users/${whoPosted.icon}" style="margin:0;padding:0;max-width:30px;max-height:30px;display:inline-block;vertical-align:middle"></a>					
	                              <a href="${serverUrl}/user/show/${whoPosted.id?c}" > ${whoPosted.name}</a>
	                              edited a custom field in the observation listed below
	                          <#elseif type=="OBSERVATION_ADDED">
                          		  Hi ${follower.name},<br><br>
	                              <a href="${serverUrl}/user/show/${whoPosted.id?c}" ><img src="${serverUrl}/biodiv/users/${whoPosted.icon}" style="margin:0;padding:0;max-width:30px;max-height:30px;display:inline-block;vertical-align:middle"></a>					
	                              <a href="${serverUrl}/user/show/${whoPosted.id?c}" > ${whoPosted.name}</a>
	                              added the following observation:
	                          <#elseif type=="OBSERVATION_UPDATED">
                          		  Hi ${follower.name},<br><br>
	                              <a href="${serverUrl}/user/show/${whoPosted.id?c}" ><img src="${serverUrl}/biodiv/users/${whoPosted.icon}" style="margin:0;padding:0;max-width:30px;max-height:30px;display:inline-block;vertical-align:middle"></a>					
	                              <a href="${serverUrl}/user/show/${whoPosted.id?c}" > ${whoPosted.name}</a>
	                              updated the following observation
	                          <#elseif type=="OBSERVATION_LOCKED">
                          		  Hi ${follower.name},<br><br>
	                              <a href="${serverUrl}/user/show/${whoPosted.id?c}" ><img src="${serverUrl}/biodiv/users/${whoPosted.icon}" style="margin:0;padding:0;max-width:30px;max-height:30px;display:inline-block;vertical-align:middle"></a>					
	                              <a href="${serverUrl}/user/show/${whoPosted.id?c}" > ${whoPosted.name}</a>
	                              validated and locked species name
		                          <#if givenName.isScientificName == true>
			                          <#if givenName.id != 0>
			                          	<a href="${serverUrl}/species/show/${givenName.id?c}" > <i> ${givenName.name} </i></a>
			                          <#else>
			                          	<i> ${givenName.name} </i>	
			                          </#if> 
		                          <#else>
		                          	${givenName.name}
		                          </#if>     
	                          <#elseif type=="OBSERVATION_UNLOCKED">
                          		  Hi ${follower.name},<br><br>
	                              <a href="${serverUrl}/user/show/${whoPosted.id?c}" ><img src="${serverUrl}/biodiv/users/${whoPosted.icon}" style="margin:0;padding:0;max-width:30px;max-height:30px;display:inline-block;vertical-align:middle"></a>					
	                              <a href="${serverUrl}/user/show/${whoPosted.id?c}" > ${whoPosted.name}</a>
	                              unlocked species name 
		                          <#if givenName.isScientificName == true>
			                          <#if givenName.id != 0>
			                          	<a href="${serverUrl}/species/show/${givenName.id?c}" > <i> ${givenName.name} </i></a>
			                          <#else>
			                          	<i> ${givenName.name} </i>	
			                          </#if> 
		                          <#else>
		                          	${givenName.name}
		                          </#if>          
	                          <#elseif type=="FEATURED_POST">
                          		  Hi ${follower.name},<br><br>
	                              <a href="${serverUrl}/user/show/${whoPosted.id?c}" ><img src="${serverUrl}/biodiv/users/${whoPosted.icon}" style="margin:0;padding:0;max-width:30px;max-height:30px;display:inline-block;vertical-align:middle"></a>					
	                              <a href="${serverUrl}/user/show/${whoPosted.id?c}" > ${whoPosted.name}</a>
	                              featured observation in: <a href="${serverUrl}/group/${where.webAddress}/show" ><i>${where.userGroupName}</i></a>             
	                          <#elseif type=="FEATURED_POST_IBP">
                          		  Hi ${follower.name},<br><br>
	                              <a href="${serverUrl}/user/show/${whoPosted.id?c}" ><img src="${serverUrl}/biodiv/users/${whoPosted.icon}" style="margin:0;padding:0;max-width:30px;max-height:30px;display:inline-block;vertical-align:middle"></a>					
	                              <a href="${serverUrl}/user/show/${whoPosted.id?c}" > ${whoPosted.name}</a>
	                              featured observation in: India Biodiversity Portal             
	                          <#elseif type=="OBSERVATION_FLAGGED">
                          		  Hi ${follower.name},<br><br>
	                              <a href="${serverUrl}/user/show/${whoPosted.id?c}" ><img src="${serverUrl}/biodiv/users/${whoPosted.icon}" style="margin:0;padding:0;max-width:30px;max-height:30px;display:inline-block;vertical-align:middle"></a>					
	                              <a href="${serverUrl}/user/show/${whoPosted.id?c}" > ${whoPosted.name}</a>
	                              flagged your observation             
	                          <#elseif type=="AGREED_SPECIES">
                          		  Hi ${follower.name},<br><br>
	                              <a href="${serverUrl}/user/show/${whoPosted.id?c}" ><img src="${serverUrl}/biodiv/users/${whoPosted.icon}" style="margin:0;padding:0;max-width:30px;max-height:30px;display:inline-block;vertical-align:middle"></a>					
	                              <a href="${serverUrl}/user/show/${whoPosted.id?c}" > ${whoPosted.name}</a>
	                              agreed on species name
	                          <#elseif type=="REMOVED_SPECIES">
                          		  Hi ${follower.name},<br><br>
	                              <a href="${serverUrl}/user/show/${whoPosted.id?c}" ><img src="${serverUrl}/biodiv/users/${whoPosted.icon}" style="margin:0;padding:0;max-width:30px;max-height:30px;display:inline-block;vertical-align:middle"></a>					
	                              <a href="${serverUrl}/user/show/${whoPosted.id?c}" > ${whoPosted.name}</a>
	                              removed species name
                              <#elseif type=="POST_TO_GROUP">
                              	  Hi ${follower.name},<br><br>
	                              <a href="${serverUrl}/user/show/${whoPosted.id?c}" ><img src="${serverUrl}/biodiv/users/${whoPosted.icon}" style="margin:0;padding:0;max-width:30px;max-height:30px;display:inline-block;vertical-align:middle"></a>					
	                              <a href="${serverUrl}/user/show/${whoPosted.id?c}" > ${whoPosted.name}</a>		
	                              <#if submitType == "post">posted<#else>removed </#if> observation <#if submitType == "post">to<#else>from </#if> group
	                              &nbsp;<a href="${serverUrl}/group/${where.webAddress}/show" ><i>${where.userGroupName}</i></a>
                              <#elseif type=="SUGGEST_MAIL">
                              	  Hi ${follower.name},<br><br>
	                              <a href="${serverUrl}/user/show/${whoPosted.id?c}" ><img src="${serverUrl}/biodiv/users/${whoPosted.icon}" style="margin:0;padding:0;max-width:30px;max-height:30px;display:inline-block;vertical-align:middle"></a>					
	                              <a href="${serverUrl}/user/show/${whoPosted.id?c}" > ${whoPosted.name}</a>		
	                              suggested species name <span>${recoVote}</span>
	                          <#elseif type=="TAGGED_MAIL">	                          	  
                              	  Hi ${follower.name},<br><br>                         	
	                              <a href="${serverUrl}/user/show/${whoPosted.id?c}" ><img src="${serverUrl}/biodiv/users/${whoPosted.icon}" style="margin:0;padding:0;max-width:30px;max-height:30px;display:inline-block;vertical-align:middle"></a>					
	                              <a href="${serverUrl}/user/show/${whoPosted.id?c}" > ${whoPosted.name}</a>		
	                              has tagged you in a comment on the page listed below.
	                          <#elseif type=="DOWNLOAD_MAIL">
	                              Hi ${downloadMail.name},<br><br>
	                              <a>
	                              <img style="margin:0;padding:0;max-width:30px;max-height:30px;display:inline-block;vertical-align:middle">
	                              </a>
	                              Your  data download request has been processed. The download link will be visible once you log in to your profile.  
                              </#if>
                           </p>
                           <#if type=="COMMENT_POST" || type=="FACT_UPDATED" || type=="TAG_UPDATED" || type=="CUSTOM_FIELD_UPDATED" || type=="FEATURED_POST" || type=="FEATURED_POST_IBP" || type=="OBSERVATION_FLAGGED">
	                           <p  style="margin:0;padding:0;margin-bottom:10px;font-weight:normal;font-size:14px;line-height:1">
	                              ${commentBody}
	                           </p>
                           </#if>
                           <#if type=="SUGGEST_MAIL" || type=="OBSERVATION_ADDED" || type=="AGREED_SPECIES" || type=="REMOVED_SPECIES">
                                <#if (givenName.isScientificName)?? && (givenName.name)?? && (givenName.id)??>
		                       <p  style="margin:0;padding:5px;margin-bottom:2px;font-weight:normal;font-size:14px;line-height:1">					
		                          Given name is : 
		                          <#if givenName.isScientificName == true>
			                          <#if givenName.id != 0>
			                          	<a href="${serverUrl}/species/show/${givenName.id?c}" > <i> ${givenName.name} </i></a>
			                          <#else>
			                          	<i> ${givenName.name} </i>	
			                          </#if> 
		                          <#else>
		                          	${givenName.name}
		                          </#if> 
		                       </p>
		                       <p></p>
                                </#if>
                           </#if>
                           <#if type=="TAGGED_MAIL">
	                           <p  style="margin:0;padding:0;margin-bottom:10px;font-weight:normal;font-size:14px;line-height:1">
	                              ${commentBody}
	                           </p>
                           </#if>
                        </td>
                     </tr>
                  </tbody>
               </table>
            </div>
            <#if type=="DOWNLOAD_MAIL">
	            <div style="margin:0 auto;padding:10px 0px;max-width:600px;display:block;background-color:#d4ece3;clear:both">
	               <p style="margin:0;padding:0 5px;margin-bottom:2px;font-weight:normal;font-size:14px;line-height:1;background-color:#d4ece3">						
	                  You can log into your profile <a href="${serverUrl}/user/show/${downloadMail.id?c}" style="margin:0;padding:0;color:#2ba6cb;font-weight:bold" > here »</a>
	               </p>
	            </div>
	        <#else>	        
	            <span>
	               <span>
	                  <div style="margin:0 auto;padding:0;max-width:600px;background-color:#d4ece3">
	                     <div style="margin:0;padding:0;width:135px;float:left">
	                        <table align="left" style="margin:0;padding:0;width:100%">
	                           <tbody>
	                              <tr style="margin:0;padding:0;">
	                                 <td style="margin:0;padding:2px;">				
	                                    <a href="${serverUrl}/observation/show/${whatPosted.id?c}" ><img src="${serverUrl}/files-api/api/get/observations${whatPosted.icon}?t=1" style="margin:0;padding:0;max-width:130px;max-height:130px;display:inline-block;vertical-align:middle"></a>
	                                 </td>
	                              </tr>
	                           </tbody>
	                        </table>
	                     </div>
	                     <div style="margin:0;padding:0;width:450px;float:left;background-color:#d4ece3">
	                        <table align="right" style="margin:0;padding:0;width:100%">
	                           <tbody>
	                              <tr style="margin:0;padding:0;">
	                                 <td style="margin:0;padding:2px;">
	                                    <p style="margin:0;padding:0;margin-bottom:0px;font-weight:normal;font-size:14px;line-height:1.4">
	                                       <b>Name:</b> ${whatPosted.name}<br>
	                                       <b>Location: </b> ${whatPosted.location}<br>
	                                       <b>Observed On:</b> ${whatPosted.observedOn}<br>
	                                    </p>
	                                 </td>
	                              </tr>
	                           </tbody>
	                        </table>
	                     </div>
	                     <div style="margin:0 auto;padding:10px 0px;max-width:600px;display:block;background-color:#d4ece3;clear:both">
	                        <p style="margin:0;padding:0 5px;margin-bottom:2px;font-weight:normal;font-size:14px;line-height:1;background-color:#d4ece3">
	                           For more information, please visit the page <a href="${serverUrl}/observation/show/${whatPosted.id?c}" style="margin:0;padding:0;color:#2ba6cb;font-weight:bold" target="_blank" data-saferedirecturl="https://www.google.com/url?hl=en&amp;q=http://${serverUrl}/observation/show/1770256&amp;source=gmail&amp;ust=1521876944507000&amp;usg=AFQjCNHfSiPtayrlu3f6rjTjXtG-1Hr4eg">here »</a>							
	                        </p>
	                     </div>
	                  </div>
	                  <div style="margin:0;padding:0;clear:both;background-color:#d4ece3">
	                     <a style="padding:0 2px">The above observation is a member of the following groups: </a><a><br>
	                     </a>
	                     <#list whatPosted.userGroups as memberOf>
	                     <div style="height:30px;width:186px;border:1px solid #a1a376;background-color:#d4ece3;float:left;margin:2px 6px">
	                        <a href="${serverUrl}/group/${memberOf.webAddress}/show" style="text-decoration:none;color:#222222"> 
	                        <img src="${serverUrl}/biodiv/userGroups/${memberOf.icon}" style="width:30px;height:30px;vertical-align:middle">
	                        ${memberOf.name} <br>
	                        </a>   
	                     </div>
	                     </#list>
	                  </div>
	               </span>
	            </span>
            </#if>
         </td>
         <td style="margin:0;padding:0;"></td>
      </tr>
   </tbody>
</table>
<table  style="margin: 0;padding: 0;width: 100%;clear: both;border-left: 1px solid #A1A376; border-right: 1px solid #A1A376; border-bottom: 1px solid #A1A376; width:610px;">
   <tr style="margin: 0;padding: 0;">
      <td style="margin: 0;padding: 0;"></td>
      <td style="margin: 0 auto;padding: 0;display: block;max-width: 600px;clear: both;">
      </td>
      <td style="margin: 0;padding: 0;"></td>
   </tr>
   <tr style="margin: 0;padding: 0;">
      <td style="margin: 0;padding: 0;"></td>
      <td style="margin: 0 auto;padding: 0;display: block;max-width: 600px;clear: both;">
         <!-- content -->
         <div style="margin: 0 auto;padding: 0px;max-width: 600px;display: block;">
            <table style="margin: 0;padding: 0;width: 100%;">
               <tr style="margin: 0;padding: 0;">
                  <td align="left" style="margin: 0;padding: 0;">
                     <p style="margin: 0;padding: 0;font-family: &quot;Helvetica Neue&quot;, &quot;Helvetica&quot;, Helvetica, Arial, sans-serif;margin-bottom: 10px;font-weight: normal;font-size: 12px;line-height: 1;">
                        If you don't want to recieve notifications from our portal, please unsubscribe by logging into 
                        <a href='${serverUrl}/user/show/<#if type=="DOWNLOAD_MAIL">${downloadMail.id?c}<#else>${follower.id?c}</#if>' style="margin: 0;padding: 0;font-family: &quot;Helvetica Neue&quot;, &quot;Helvetica&quot;, Helvetica, Arial, sans-serif;color: #2BA6CB;">
                           <unsubscribe style="margin: 0;padding: 0;font-family: &quot;Helvetica Neue&quot;, &quot;Helvetica&quot;, Helvetica, Arial, sans-serif;"> your profile</unsubscribe>
                        </a>
                     </p>
                  </td>
               </tr>
            </table>
         </div>
         <!-- /content -->
      </td>
      <td style="margin: 0;padding: 0;font-family: &quot;Helvetica Neue&quot;, &quot;Helvetica&quot;, Helvetica, Arial, sans-serif;"></td>
   </tr>
</table>
