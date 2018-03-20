<ul id="userlist">
</ul>
<#list myusers as myuser>
    <p>${myuser}</p>
</#list>

<script type="text/javascript">
    var userlist = document.getElementById('userlist');
    <#--var contactInfoListSize = '${users?size}';-->
    // console.log(contactInfoListSize);
    <#--<#if users??>-->
        <#--console.log(${users.size()})-->
    <#--</#if>-->

    <#--var usersize = '${users?size}';-->
    <#--console.log(usersize);-->
    <#--if (usersize) {-->
        <#--<#list users as user>-->
            <#--var e = document.createElement('li');-->
            <#--e.innerText = '${user.name}';-->
            <#--userlist.appendChild(e);-->
        <#--</#list>-->
    <#--}-->



</script>