<p>企业详情</p>

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
<li>${walletRecord}</li>
</#list>
</#if>    <#list walletRecords as walletRecord>

</p>