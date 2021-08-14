// 选中文件夹
$("a[name = 'material_folder']").click(function () {
    $.ajax({
        url : "/getMessage/",
        type : "post",
        data : {
            isFile : false,
            id : this.id,
        },
        dataType : "json",
        success : function(data) {
            if (data.flag == true) {
                setBar({
                    absolutePath : virtual_file_absolute,
                    name : data.data.folderName,
                    type : "文件夹",
                    size : "尚未统计",
                    date : data.data.folderCreateDate.substring(0,10),
                    remark : data.data.folderRemark
                });
                setOperate({
                    canDownload : false,
                    canFavour : false,
                    canDelete : false
                })
                switchFileIcon('.folder');
                if($("#file_view").css("display") == 'none') {
                    $("#file_view").css("display",'block');
                }
                select_id = data.data.id;
                is_file = false;
            } else {
                swal("请求失败,请稍后再试", {
                    icon: "warning",
                })
            }
        },
        error: function () {
            swal("请求失败,请稍后再试", {
                icon: "warning",
            })
        }
    });
});

// 文件备注确认控制
$("#remark_verify").click(function (e) {
    $.ajax({
        url : "/updateRemark/",
        type : "post",
        data : {
            isFile : is_file,
            id : select_id,
            newRemark : $('#remark_edit').val(),
        },
        dataType : "json",
        success : function(data) {
            if (data.flag == true) {
                $("#newRemarkModal").modal('hide');
                swal("编辑成功", {
                    icon: "success",
                }).then((isOk)=>{
                    location.reload();
                });
            } else {
                swal("请求失败,请稍后再试", {
                    icon: "warning",
                })
            }
        },
        error: function () {
            swal("请求失败,请稍后再试", {
                icon: "warning",
            })
        }
    });
});

// 文件重命名的控制选项
$("#file_rename").click(function () {
    swal("输入新名称",{
        content: {
            element: "input",
            attributes: {
                value: $("#file_name").html(),
                type: "text",
            },
        },
    })
        .then((value) => {
            if(value != null){
                $.ajax({
                    url : "/updateName/",
                    type : "post",
                    data : {
                        isFile : is_file,
                        id : select_id,
                        newName : value,
                    },
                    dataType : "json",
                    success : function(data) {
                        if (data.flag == true) {
                            swal("修改成功", {
                                icon: "success",
                            }).then((isOk)=>{
                                location.reload();
                            });
                        } else {
                            swal("请求失败,请稍后再试", {
                                icon: "warning",
                            })
                        }
                    }
                })
            }
        });
});

// 删除素材控制
$("#file_delete").click(function () {
    swal({
        title: "确定删除?",
        text: "确认删除后，可能无法再找回文件",
        icon: "warning",
        buttons: true,
        dangerMode: true,
    }).then((willDelete) => {
        if (willDelete) {
            $.ajax({
                url : "/delete/",
                type : "post",
                data : {
                    isFile : is_file,
                    id : select_id,
                },
                dataType : "json",
                success : function(data) {
                    if(data.flag == true) {
                        swal("删除成功", {
                            icon: "success",
                        }).then((isOk)=>{
                            location.reload();
                        });
                    }else {
                        swal("请求失败,请稍后再试", {
                            icon: "warning",
                        })
                    }
                },
                error : function () {
                    swal("请求失败,请稍后再试", {
                        icon: "warning",
                    })
                }
            });
        } else {
            swal("取消删除", {
                icon: "warning",
            })
        }
    });
});


// 文件收藏选项的控制
$("#file_favour").click(function () {
    $.ajax({
        url : "/updateFavour/",
        type : "post",
        data : {
            isFile : is_file,
            id : select_id,
            isFavour : $("#favour_ico").css("display") == 'none' ? false : true,
        },
        dataType : "json",
        success : function(data) {
            if (data.flag == true) {
                if($("#favour_ico").css("display") == 'none') {
                    $("#favour_ico").toggle(200);
                    $("#file_favour").html("取消收藏");
                    swal("收藏成功", {
                        icon: "success",
                    }).then((isOk)=>{
                        location.reload();
                    });
                }else {
                    $("#favour_ico").toggle(200);
                    $("#file_favour").html("收藏");
                    swal("已取消", {
                        icon: "info",
                    }).then((isOk)=>{
                        location.reload();
                    });
                }
            } else {
                swal("请求失败,请稍后再试", {
                    icon: "warning",
                })
            }
        }
    })
});

$("#upload").click(function() {
    $("#uploadInput").slideToggle(400);
});

function setBar(msg) {
    alert("asdasdasd");
    $("#file_path").html(msg.absolutePath);         // 素材内容的绝对路径
    $("#file_content").attr("src",msg.content);     // 素材内容显示
    $("#file_name").html(msg.name);                 // 素材名字
    $("#file_type").html(msg.type);                 // 素材后缀
    $("#file_size").html(msg.size);                 // 素材 (图片) 大小
    $("#file_wh").html(msg.wh);
    $("#file_create_date").html(msg.date);          // 素材创建日期
    $("#remark").html(msg.remark);                  // 备注
    $("#file_download").attr("href", msg.content);  // 素材下载路径
    $("#file_download").attr("download", msg.name+msg.type); // 素材下载名称
    $("#remark_edit").val(msg.remark);              // 备注编辑栏写入默认备注内容
}

function setOperate(msg) {
    msg.canDownload == null || msg.canDownload == true ? $("#file_download").removeClass("disabled") : $("#file_download").addClass("disabled");
    msg.canFavour == null || msg.canFavour == true ? $("#file_favour").removeClass("disabled") : $("#file_favour").addClass("disabled");
    msg.canRemark == null || msg.canRemark == true ? $("#file_remark").removeClass("disabled") : $("#file_remark").addClass("disabled");
    msg.canRename == null || msg.canRename == true ? $("#file_rename").removeClass("disabled") : $("#file_rename").addClass("disabled");
    msg.canCopyTo == null || msg.canCopyTo == true ? $("#file_copy_to").removeClass("disabled") : $("#file_copy_to").addClass("disabled");
    msg.canMoveTo == null || msg.canMoveTo == true ? $("#file_move_to").removeClass("disabled") : $("#file_move_to").addClass("disabled");
    msg.canDelete == null || msg.canDelete == true ? $("#file_delete").removeClass("disabled") : $("#file_delete").addClass("disabled");
}

function switchFileIcon(fileType) {
    $("#image_view").css("display", "none");
    $("#file_view").css("display", "block");
    $("#file_icon").removeClass();
    switch(fileType) {
        case ".folder" :
            $("#file_icon").addClass("fa fa-folder-open text-warning");
            break;
        case ".pdf" :
            $("#file_icon").addClass("fa fa-file-pdf-o text-danger");
            break;
        case ".xlsx":
            $("#file_icon").addClass("fa fa-file-excel-o text-success");
            break;
        case ".pptx":
            $("#file_icon").addClass("fa fa-file-powerpoint-o text-warning");
            break;
        case "docx":
            $("#file_icon").addClass("fa fa-file-word-o text-info");
            break;
        case ".txt" :
            $("#file_icon").addClass("fa fa-file-text-o text-secondary");
            break;
        case ".zip" :
            $("#file_icon").addClass("fa fa-file-zip-o text-d");
            break;
        case ".png" :
        case ".jpg" :
        case ".jpeg" :
        case ".gif" :
            $("#file_icon").addClass("fa fa-file-image-o text-primary");
            break;
        case ".mp3" :
        case ".wav" :
            $("#file_icon").addClass("fa fa-file-sound-o ");
            break;
        case ".mp4" :
        case ".avi" :
        case ".mov" :
            $("#file_icon").addClass("fa fa-file-video-o");
            break;
        case ".js" :
        case ".py" :
            $("#file_icon").addClass("fa fa-file-code-o");
            break;
        default :
            $("#file_icon").addClass("fa fa-file-o");
    }
}

/*  刷新后锁定选择的功能后续再完成
    $(document).ready(function () {
        let selectId = $.cookie("selectId");
        if(selectId != null) {
            $.ajax({
                url : "/getMessage/",
                type : "post",
                data : {
                    isFile : is_file,
                    id : selectId,
                },
                dataType : "json",
                success : function(data) {
                    if (data.flag == true) {
                        $("#remark").html(data.data.remark);
                        $("#file_path").html(virtual_file_absolute+data.data.pictureName);
                        $("#file_name").html(data.data.pictureName);
                        $("#file_type").html(data.data.pictureType);
                        $("#file_size").html(data.data.pictureSize);
                        $("#file_create_date").html(data.data.pictureCreateDate.substring(0,10));
                        if($("#file_view").css("display") != 'none') {
                            $("#file_view").css("display",'none');
                        }
                        $("#image_view").css("display","inline")
                        $("#file_content").attr("src", data.data.picturePath);
                        $("#file_download").attr("href", data.data.picturePath);
                        $("#file_download").attr("download", data.data.pictureName);
                        $("#file_download").removeClass("disabled");
                    } else {
                        swal("请求失败,请稍后再试", {
                            icon: "warning",
                        })
                    }
                },
                error: function () {
                    swal("请求失败,请稍后再试", {
                        icon: "warning",
                    })
                }
            });
        }
    });*/