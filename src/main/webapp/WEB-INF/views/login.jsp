<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2019/5/6
  Time: 21:38
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<!doctype html>
<html>
<head>
    <meta charset="utf-8">
    <title>登录</title>
    <meta name="viewport" content="width=device-width, initial-scale=1" />
    <!-- jQuery 3 -->
    <script src="https://cdn.bootcss.com/jquery/3.4.0/jquery.min.js"></script>
    <style>
        /* 主体框定 */
        body{
            /*background-image:url(../images/2.jpg);*/
            background: #f8f8f8;
            background-size:cover;
            /*background-repeat: no-repeat;*/
            margin:0;
        }
        .box{
            margin-left:auto;
            margin-right:auto;
            width:350px;
            padding:20px;
            border-radius: 14px;
            background-color: #fff;
            box-shadow:5px 5px 10px #abafba;
        }
        .box1{
            margin-right:100px;
            float:right;
            width:80px;
            padding:10px;
            border-width:3px;
            border-style:solid;
            border-color:#fa911e;
            border-radius: 14px;
        }
        .box1:hover{
            width:80px;
            padding:8px;
            border-width:5px;
            border-style:solid;
            border-color:#fa911e;
            border-radius: 14px;
        }

        h1{
            color:#fa9111;
        }
        /* 选择框美化 */
        .input{
            border: 1px solid #e6e6e6;
            padding:10px;
            width:300px;
            height:25px;
            border-radius:15px;
        }
        .submit{
            padding:10px;
            width:300px;
            height:40px;
            font-size:16px;
            border-radius:100px;
            background-color:#fa911e;
            box-shadow:none;
            border:0;
        }
        .a{
            text-align:center;
            font-size:20px;
            color:#fa911e;
            text-decoration:none;
        }
        .a1{
            color:#000000;
        }
        .a2{
            color:#fa911e;
            font-size:20px;
            text-decoration:none;
        }

        /* 媒体查询 */
        @media screen and (max-width: 600px){
            .box{
                width:auto;
            }
            .box1{
                margin-right:2px;
            }
            .input{
                width:80%;
            }
            .submit{
                width:80%;
            }
        }
    </style>
</head>
<body>
<br>
<article>
    <br><br><br>
    <div class="box">
        <h1>登录</h1>
        <div align="center">
                <input id="name" type="text" name="user-name" placeholder="账号\邮箱\手机登录" class="input"><br><br>
                <input  id="password" type="password" name="password" placeholder="账号密码" class="input"><br><br>

                <br><br>
                <button class="submit">提交</button>
            <br>
            <a href="/register" class="a2">立即注册</a>
            <br><br>
        </div>
    </div>

</article>
<script>
    $(".submit").click(function () {
        $.ajax({
            url:"/M-login",
            type:"post",
            data:{name:$("#name").val(),password:$("#password").val()},
            success:function (data) {
                alert(data);
            }
        });
    })
</script>
</body>
</html>
