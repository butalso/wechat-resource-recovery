<p>钱包：${wallet}</p>

<ul>
    钱包交易记录：
    <#list walletRecords as walletRecord>
        <li>${walletRecord}</li>
    </#list>
</ul>