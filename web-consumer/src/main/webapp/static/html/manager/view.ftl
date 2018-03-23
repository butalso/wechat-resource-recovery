<p>用户列表</p>

<ul id="userlist">
</ul>


<script type="text/javascript">
    var userlist = document.getElementById('userlist');

    <#if users??>
        <#list users as user>
            var e = document.createElement('li');
            e.innerText = "${user}";
            userlist.appendChild(e);
        </#list>
    </#if>

</script>