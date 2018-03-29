jQuery(function($) {
    var updateData={};
    //editables on first profile page
    $.fn.editable.defaults.mode = 'inline';
    $.fn.editableform.loading = "<div class='editableform-loading'><i class='light-blue icon-2x icon-spinner icon-spin'></i></div>";
    $.fn.editableform.buttons = '<button type="submit" class="btn btn-info editable-submit"><i class="icon-ok icon-white"></i></button>'+
        '<button type="button" class="btn editable-cancel"><i class="icon-remove"></i></button>';

    function modify() {
        //editables
        $('#username').editable({
            type: 'text',
            placeholder:'请输入用户名',
            name: 'username',
            validate:function (value) {
                if(value == ''){
                    return '不能为空';
                }
            }
        });

        $('#tellphone').editable({
            type: 'text',
            placeholder:'请输入手机号码',
            name: 'tellphone',
            validate:function (value) {
                alert(value)
                if(value == ''){
                    return '不能为空';
                }
            },
        });



        var cities=[];


        var currentValue = "NL";
        $('#province').editable({
            type: 'select2',
            value : 'NL',
            source: function () {
                var provinces=[];
                $.ajax({
                    type: "GET",
                    url: HOST,
                    dataType: "json",
                    complete: function(XMLHttpRequest,textStatus){

                    } ,
                    success: function(data){
                       $.each(data,function (i,value) {
                           provinces.push({id:value ,text:value});
                       })
                    },
                    error: function(error){
                        console.log(error);
                    }
                })
                return provinces;
            },
            success: function(response, newValue) {
                if(currentValue == newValue) return;
                currentValue = newValue;

                $.get(HOST,{"province":newValue},function (data,status) {
                    if(status=="success"){
                        $.each(data,function (n,value) {
                            cities.push({id:value ,text:value});
                        });
                    }
                    else {
                        console.log(data)
                    }
                },"json")

                var new_source = (!newValue || newValue == "") ? [] : cities;

                //the destroy method is causing errors in x-editable v1.4.6
                //it worked fine in v1.4.5
                /**
                 $('#city').editable('destroy').editable({
							type: 'select2',
							source: new_source
						}).editable('setValue', null);
                 */

                    //so we remove it altogether and create a new element
                var city = $('#city').removeAttr('id').get(0);
                $(city).clone().attr('id', 'city').text('选择城市').editable({
                    type: 'select2',
                    value : null,
                    source: new_source
                }).insertAfter(city);//insert it after previous instance
                $(city).remove();//remove previous instance

            },
            url: function (parmas) {
                updateData[parmas.name]=parmas.value;
                console.log(updateData)
            }
        });

        var areas=[];

        $('#city').editable({
            type: 'select2',
            value:'NL',
            source: cities,
            success: function(response, newValue) {
                if(currentValue == newValue) return;
                currentValue = newValue;
                alert(newValue)

                $.get(HOST,{"city":newValue},function (data,status) {
                    if(status=="success"){
                        console.log(data)
                        $.each(data,function (n,value) {
                            areas.push({id:value ,text:value});
                        });
                    }
                    else {
                        console.log(data)
                    }
                },"json")

                var new_source = (!newValue || newValue == "") ? [] : areas;

                //so we remove it altogether and create a new element
                var area = $('#area').removeAttr('id').get(0);
                $(area).clone().attr('id', 'area').text('选择区域').editable({
                    type: 'select2',
                    value : null,
                    source: new_source
                }).insertAfter(area);//insert it after previous instance
                $(area).remove();//remove previous instance

            },
            validate:function (value) {
                if(value == ''){
                    return '值不为空';
                }
            }
        });


        $('#area').editable({
            type: 'select2',
            value : 'NL',
            source:areas
            // source: function () {
            //     $.get(HOST,{"city":newValue},function (data,status) {
            //         if(status=="success"){
            //             $.each(data,function (n,value) {
            //                 cities.push({id:value ,text:value});
            //             });
            //         }
            //         else {
            //             console.log(data)
            //         }
            //     },"json")
            // }
        });

        $('#community').editable({
            type: 'select2',
            value:'NL',
            // source: cities[currentValue]
        });



        $('#signup').editable({
            type: 'date',
            format: 'yyyy-mm-dd',
            viewformat: 'yyyy/mm/dd',
            datepicker: {
                weekStart: 1
            }
        });

        $('#age').editable({
            type: 'spinner',
            name : 'age',
            spinner : {
                min : 16, max:99, step:1
            }
        });

        //var $range = document.createElement("INPUT");
        //$range.type = 'range';
        $('#login').editable({
            type: 'slider',//$range.type == 'range' ? 'range' : 'slider',
            name : 'login',
            slider : {
                min : 1, max:50, width:100
            },
            success: function(response, newValue) {
                if(parseInt(newValue) == 1)
                    $(this).html(newValue + " hour ago");
                else $(this).html(newValue + " hours ago");
            }
        });

        $('#about').editable({
            mode: 'inline',
            type: 'wysiwyg',
            name : 'about',
            wysiwyg : {
                //css : {'max-width':'300px'}
            },
            success: function(response, newValue) {
            }
        });


        // *** editable avatar *** //
        try {//ie8 throws some harmless exception, so let's catch it

            //it seems that editable plugin calls appendChild, and as Image doesn't have it, it causes errors on IE at unpredicted points
            //so let's have a fake appendChild for it!
            if( /msie\s*(8|7|6)/.test(navigator.userAgent.toLowerCase()) ) Image.prototype.appendChild = function(el){}

            var last_gritter
            $('#avatar').editable({
                type: 'image',
                name: 'avatar',
                value: null,
                image: {
                    //specify ace file input plugin's options here
                    btn_choose: 'Change Avatar',
                    droppable: true,
                    /**
                     //this will override the default before_change that only accepts image files
                     before_change: function(files, dropped) {
								return true;
							},
                     */

                    //and a few extra ones here
                    name: 'avatar',//put the field name here as well, will be used inside the custom plugin
                    max_size: 110000,//~100Kb
                    on_error : function(code) {//on_error function will be called when the selected file has a problem
                        if(last_gritter) $.gritter.remove(last_gritter);
                        if(code == 1) {//file format error
                            last_gritter = $.gritter.add({
                                title: 'File is not an image!',
                                text: 'Please choose a jpg|gif|png image!',
                                class_name: 'gritter-error gritter-center'
                            });
                        } else if(code == 2) {//file size rror
                            last_gritter = $.gritter.add({
                                title: 'File too big!',
                                text: 'Image size should not exceed 100Kb!',
                                class_name: 'gritter-error gritter-center'
                            });
                        }
                        else {//other error
                        }
                    },
                    on_success : function() {
                        $.gritter.removeAll();
                    }
                },
                url: function(params) {
                    // ***UPDATE AVATAR HERE*** //
                    //You can replace the contents of this function with examples/profile-avatar-update.js for actual upload


                    var deferred = new $.Deferred

                    //if value is empty, means no valid files were selected
                    //but it may still be submitted by the plugin, because "" (empty string) is different from previous non-empty value whatever it was
                    //so we return just here to prevent problems
                    var value = $('#avatar').next().find('input[type=hidden]:eq(0)').val();
                    if(!value || value.length == 0) {
                        deferred.resolve();
                        return deferred.promise();
                    }


                    //dummy upload
                    setTimeout(function(){
                        if("FileReader" in window) {
                            //for browsers that have a thumbnail of selected image
                            var thumb = $('#avatar').next().find('img').data('thumb');
                            if(thumb) $('#avatar').get(0).src = thumb;
                        }

                        deferred.resolve({'status':'OK'});

                        if(last_gritter) $.gritter.remove(last_gritter);
                        last_gritter = $.gritter.add({
                            title: 'Avatar Updated!',
                            text: 'Uploading to server can be easily implemented. A working example is included with the template.',
                            class_name: 'gritter-info gritter-center'
                        });

                    } , parseInt(Math.random() * 800 + 800))

                    return deferred.promise();
                },

                success: function(response, newValue) {
                }
            })
        }catch(e) {}



        //another option is using modals
        $('#avatar2').on('click', function(){
            var modal =
                '<div class="modal hide fade">\
                    <div class="modal-header">\
                        <button type="button" class="close" data-dismiss="modal">&times;</button>\
                        <h4 class="blue">更改头像</h4>\
                    </div>\
                    \
                    <form class="no-margin">\
                    <div class="modal-body">\
                        <div class="space-4"></div>\
                        <div style="width:75%;margin-left:12%;"><input type="file" name="file-input" /></div>\
                    </div>\
                    \
                    <div class="modal-footer center">\
                        <button type="submit" class="btn btn-small btn-success"><i class="icon-ok"></i> Submit</button>\
                        <button type="button" class="btn btn-small" data-dismiss="modal"><i class="icon-remove"></i> Cancel</button>\
                    </div>\
                    </form>\
                </div>';


            var modal = $(modal);
            modal.modal("show").on("hidden", function(){
                modal.remove();
            });

            var working = false;

            var form = modal.find('form:eq(0)');
            var file = form.find('input[type=file]').eq(0);
            file.ace_file_input({
                style:'well',
                btn_choose:'Click to choose new avatar',
                btn_change:null,
                no_icon:'icon-picture',
                thumbnail:'small',
                before_remove: function() {
                    //don't remove/reset files while being uploaded
                    return !working;
                },
                before_change: function(files, dropped) {
                    var file = files[0];
                    if(typeof file === "string") {
                        //file is just a file name here (in browsers that don't support FileReader API)
                        if(! (/\.(jpe?g|png|gif)$/i).test(file) ) return false;
                    }
                    else {//file is a File object
                        var type = $.trim(file.type);
                        if( ( type.length > 0 && ! (/^image\/(jpe?g|png|gif)$/i).test(type) )
                            || ( type.length == 0 && ! (/\.(jpe?g|png|gif)$/i).test(file.name) )//for android default browser!
                        ) return false;

                        if( file.size > 110000 ) {//~100Kb
                            return false;
                        }
                    }

                    return true;
                }
            });

            form.on('submit', function(){
                if(!file.data('ace_input_files')) return false;

                file.ace_file_input('disable');
                form.find('button').attr('disabled', 'disabled');
                form.find('.modal-body').append("<div class='center'><i class='icon-spinner icon-spin bigger-150 orange'></i></div>");

                var deferred = new $.Deferred;
                working = true;
                deferred.done(function() {
                    form.find('button').removeAttr('disabled');
                    form.find('input[type=file]').ace_file_input('enable');
                    form.find('.modal-body > :last-child').remove();

                    modal.modal("hide");

                    var thumb = file.next().find('img').data('thumb');
                    if(thumb) $('#avatar2').get(0).src = thumb;

                    working = false;
                });


                setTimeout(function(){
                    deferred.resolve();
                } , parseInt(Math.random() * 800 + 800));

                return false;
            });

        });





    }

    modify();
    console.log(updateData)






    //////////////////////////////
    $('#profile-feed-1').slimScroll({
        height: '250px',
        alwaysVisible : true
    });

    $('.profile-social-links > a').tooltip();

    $('.easy-pie-chart.percentage').each(function(){
        var barColor = $(this).data('color') || '#555';
        var trackColor = '#E2E2E2';
        var size = parseInt($(this).data('size')) || 72;
        $(this).easyPieChart({
            barColor: barColor,
            trackColor: trackColor,
            scaleColor: false,
            lineCap: 'butt',
            lineWidth: parseInt(size/10),
            animate:false,
            size: size
        }).css('color', barColor);
    });

    ///////////////////////////////////////////

    //show the user info on right or left depending on its position
    $('#user-profile-2 .memberdiv').on('mouseenter', function(){
        var $this = $(this);
        var $parent = $this.closest('.tab-pane');

        var off1 = $parent.offset();
        var w1 = $parent.width();

        var off2 = $this.offset();
        var w2 = $this.width();

        var place = 'left';
        if( parseInt(off2.left) < parseInt(off1.left) + parseInt(w1 / 2) ) place = 'right';

        $this.find('.popover').removeClass('right left').addClass(place);
    }).on('click', function() {
        return false;
    });


    ///////////////////////////////////////////
    $('#user-profile-3')
        .find('input[type=file]').ace_file_input({
        style:'well',
        btn_choose:'Change avatar',
        btn_change:null,
        no_icon:'icon-picture',
        thumbnail:'large',
        droppable:true,
        before_change: function(files, dropped) {
            var file = files[0];
            if(typeof file === "string") {//files is just a file name here (in browsers that don't support FileReader API)
                if(! (/\.(jpe?g|png|gif)$/i).test(file) ) return false;
            }
            else {//file is a File object
                var type = $.trim(file.type);
                if( ( type.length > 0 && ! (/^image\/(jpe?g|png|gif)$/i).test(type) )
                    || ( type.length == 0 && ! (/\.(jpe?g|png|gif)$/i).test(file.name) )//for android default browser!
                ) return false;

                if( file.size > 110000 ) {//~100Kb
                    return false;
                }
            }

            return true;
        }
    })
        .end().find('button[type=reset]').on(ace.click_event, function(){
        $('#user-profile-3 input[type=file]').ace_file_input('reset_input');
    })
        .end().find('.date-picker').datepicker().next().on(ace.click_event, function(){
        $(this).prev().focus();
    })
    $('.input-mask-phone').mask('(999) 999-9999');



    ////////////////////
    //change box

    $('[data-toggle="buttons"] .btn').on('click', function(e){
        var target = $(this).find('input[type=radio]');
        var which = parseInt(target.val());
        $('.user-profile').parent().addClass('hide');
        $('#user-profile-'+which).parent().removeClass('hide');
    });
});