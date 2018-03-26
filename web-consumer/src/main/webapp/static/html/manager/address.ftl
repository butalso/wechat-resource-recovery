<h1>小区信息</h1>

<p>已分配小区</p>
<#assign collectorNames=disAddresses?keys>
<#list collectorNames as collectorName>
    <ul>${collectorName}
        <#assign addresses=disAddresses[collectorName]>
        <#list addresses as address>
            <li>${address}</li>
        </#list>
    </ul>
</#list>

<p>未分配小区</p>
<#list undisAddresses as undisAddress>
    <li>${undisAddress}</li>
</#list>
