 
 <#macro isActive link>
 	<#if link == '${currentPage}'>
    	 class="active"
    </#if>
</#macro>
 
 <#macro isCreate >
 	<#if '${isCraete}' == true>
    	Добавить
    <#else>
    	Изменить
    </#if>	
</#macro>
