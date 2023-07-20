<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="ko">
<head>
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<meta http-equiv="refresh" content="6;url=/main.jsp">
<link rel="shortcut icon" href="resources/img/mlogo.svg"">
<style>
*{
margin: 0;
padding: 0;
width: 100%;
}
</style>
    <title>MATFLIX</title>
</head>

  <body>
    <div id="wrapper" data-spy="scroll" data-target="#navbar-example2" data-offset="0"></div>

    <script src="https://code.jquery.com/jquery-3.5.1.slim.min.js" integrity="sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj"  crossorigin="anonymous" ></script>
    <script src="resources/index/javascript/jquery.tubular.1.0.js"></script>
<script>
    $('document').ready(function(){
        var options = {
                videoId : 'DSOUpFK8yNA',
                // mute는 동영상 실행 시 음소거 설정 기능입니다!
                mute : true
            };
            $('#wrapper').tubular(options);
    });
</script>
  </body>
</html>