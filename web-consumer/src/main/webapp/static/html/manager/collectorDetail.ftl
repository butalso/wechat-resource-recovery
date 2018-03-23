<p>回收员详情</p>

<p>user: ${user}</p>
<p>userActivations:
<#if userActivations??>
    <#list userActivations as userActivation>
    <li>${userActivation}</li>
    </#list>
</#if>
</p>
<p>orders:
<#if orders??>
    <#list orders as order>
    <li>${order}</li>
    </#list>
</#if>
</p>
<p>walletRecords:
<#if walletRecords??>
    <#list walletRecords as walletRecord>
    <li>${walletRecord}</li>
    </#list>
</#if>
</p>