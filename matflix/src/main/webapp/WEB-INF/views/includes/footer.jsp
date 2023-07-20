<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

</div>
        <!-- /#page-wrapper -->

    </div>
    <!-- /#wrapper -->

    <!-- jQuery -->
    <script src="/resources/vendor/jquery/jquery.min.js"></script>

    <!-- Bootstrap Core JavaScript -->
    <script src="/resources/vendor/bootstrap/js/bootstrap.min.js"></script>

    <!-- Metis Menu Plugin JavaScript -->
    <script src="/resources/vendor/metisMenu/metisMenu.min.js"></script>

    <!-- DataTables JavaScript -->
    <script src="/resources/vendor/datatables/js/jquery.dataTables.min.js"></script>
    <script src="/resources/vendor/datatables-plugins/dataTables.bootstrap.min.js"></script>
    <script src="/resources/vendor/datatables-responsive/dataTables.responsive.js"></script>

    <!-- Custom Theme JavaScript -->
    <script src="/resources/dist/js/sb-admin-2.js"></script>

    <!-- Page-Level Demo Scripts - Tables - Use for reference -->
    <script>
    $(document).ready(function() {
        // 기존에 아이디가 dataTables-example에 적용된 데이터 테이블 해제
    	// $('#dataTables-example').DataTable({
           // responsive: true
        // });
        
        
        // jQuery의 최신 버전을 사용한 상태에서 모바일 크기에서
        // '새로고침'시 메뉴가 펼쳐지는 문제 해결을 위해서 다음의 3줄 코딩을 추가해 줍니다.
        $('.sidebar-nav')
        	.attr("class", "sidebar-nav navbar-collapse collapse")
        	.attr("aria-expanded", 'false')
        	.attr("style", "height:1px");
    });
    </script>
</body>
</html>