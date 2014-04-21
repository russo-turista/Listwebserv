<#macro formCheckbox path attributes="">
    <@spring.bind path />
    <input type="hidden" name="_${spring.status.expression}" value="true"/>
    <input type="checkbox" id="${spring.status.expression}" name="${spring.status.expression}"
           <#if spring.status.value?? && spring.status.value?string=="true">checked="true"</#if>
    ${attributes}
    <@spring.closeTag/>
</#macro>