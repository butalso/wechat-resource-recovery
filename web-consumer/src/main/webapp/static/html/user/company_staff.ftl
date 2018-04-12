<@override name="nav"></@override>
<@override name="content">
<div class="container">
    <a href="/web-consumer/user" class="btn">
        <span><<返回</span>
    </a>

    <#list collectors as collector>
        <div class="region-block">
            <div class="media">
                <div class="media-left media-middle" style="width: 20%;">
                    <a href="/web-consumer/user/details">
                        <img class="media-object" src="" alt=""
                             style="width: 80px;">
                    </a>
                </div>
                <div class="media-body">
                    <h4 class="media-heading">
                        员工姓名:${collector.name}
                    </h4>
                    <a href="/web-consumer/user/collectors/${collector.name}/orders"><span
                            class="more">>></span></a>
                    <div>员工编号：${collector.id}</div>
                    <div>联系电话：${collector.phone}</div>
                    <div>
                        负责区域：${collector.address.province+collector.address.city+collector.address.area+collector.address.detail}
                    </div>
                </div>
            </div>
        </div>
    </#list>

</div>
</@override>

<@override name="js">
<#--<script src="/web-consumer/static/index/company_staff.js"></script>-->
</@override>
<@extends name="layout.ftl"/>
