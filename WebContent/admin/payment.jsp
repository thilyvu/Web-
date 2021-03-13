<%@page import="DAO.Csanpham"%>
<%@page import="java.util.ArrayList"%>
<%@page import="MODEL.Sanpham"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
       <%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
       
<!DOCTYPE html>
<html lang="en">

<head>
     <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <!-- Tell the browser to be responsive to screen width -->
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="description" content="">
    <meta name="author" content="">
    <!-- Favicon icon -->
    <link rel="icon" type="image/png" sizes="16x16" href="${pageContext.request.contextPath}/admin/ad.png">
    <title>STVL Shop</title>
    <!-- Bootstrap Core CSS -->
    <link href="${pageContext.request.contextPath}/admin/assets/node_modules/bootstrap/css/bootstrap.min.css" rel="stylesheet">
    <!-- Custom CSS -->
    <link href="${pageContext.request.contextPath}/admin/css/style.css" rel="stylesheet">
    <!-- You can change the theme colors from here -->
    <link href="${pageContext.request.contextPath}/admin/css/colors/default.css" id="theme" rel="stylesheet">
     <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.1/css/all.min.css" />
    <!-- HTML5 Shim and Respond.js IE8 support of HTML5 elements and media queries -->
    <!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
    <!--[if lt IE 9]>
    <script src="https://oss.maxcdn.com/libs/html5shiv/3.7.0/html5shiv.js"></script>
    <script src="https://oss.maxcdn.com/libs/respond.js/1.4.2/respond.min.js"></script>
<![endif]-->
</head>
<script type="text/javascript">
	function chitiet(iddh)
	{
		window.location.href="${pageContext.request.contextPath}/quanli/Loadproductpayment?iddh="+iddh;
	}

</script>
<body class="fix-header card-no-border fix-sidebar">
    <!-- ============================================================== -->
    <!-- Preloader - style you can find in spinners.css -->
    <!-- ============================================================== -->
    <div class="preloader">
        <div class="loader">
            <div class="loader__figure"></div>
            <p class="loader__label">Admin Wrap</p>
        </div>
    </div>
    <!-- ============================================================== -->
    <!-- Main wrapper - style you can find in pages.scss -->
    <!-- ============================================================== -->
    <div id="main-wrapper">
        <!-- ============================================================== -->
        <!-- Topbar header - style you can find in pages.scss -->
        <!-- ============================================================== -->
        <header class="topbar">
            <nav class="navbar top-navbar navbar-expand-md navbar-light">
                <!-- ============================================================== -->
                <!-- Logo -->
                <!-- ============================================================== -->
                <div class="navbar-header">
                     <a class="navbar-brand" href="${pageContext.request.contextPath}/quanli">
                        <!-- Logo icon --><b>
                            <!--You can put here icon as well // <i class="wi wi-sunset"></i> //-->
                            <!-- Dark Logo icon -->
                            <img src="${pageContext.request.contextPath}/admin/ad.png" alt="homepage" class="dark-logo"  width="120px"/>
                            <!-- Light Logo icon -->
                            <img src="${pageContext.request.contextPath}/admin/ad.png" alt="homepage" class="light-logo"width="120px" />
                        </b>
                        <!--End Logo icon -->
                        <!-- Logo text -->
                         </a>
                </div>
                <!-- ============================================================== -->
                <!-- End Logo -->
                <!-- ============================================================== -->
                <div class="navbar-collapse">
                    <!-- ============================================================== -->
                    <!-- toggle and nav items -->
                    <!-- ============================================================== -->
                    <ul class="navbar-nav mr-auto">
                        <li class="nav-item"> <a class="nav-link nav-toggler hidden-md-up waves-effect waves-dark" href="javascript:void(0)"><i class="fa fa-bars"></i></a> </li>
                        <!-- ============================================================== -->
                        <!-- Search -->
                        <!-- ============================================================== -->
                        <li class="nav-item hidden-xs-down search-box"> <a class="nav-link hidden-sm-down waves-effect waves-dark" href="javascript:void(0)"><i class="fa fa-search"></i></a>
                            <form class="app-search">
                                <input type="text" class="form-control" placeholder="Search & enter"> <a class="srh-btn"><i class="fa fa-times"></i></a> </form>
                        </li>
                    </ul>
                    <!-- ============================================================== -->
                    <!-- User profile and search -->
                    <!-- ============================================================== -->
                     <ul class="navbar-nav float-right">
                        <!-- ============================================================== -->
                        <!-- Search -->
                        <!-- ============================================================== -->
                      
                        <!-- ============================================================== -->
                        <!-- User profile and search -->
                        <!-- ============================================================== -->
                        <li class="nav-item dropdown">
                            <a class="nav-link dropdown-toggle" href="javascript:void(0)" data-toggle="dropdown"
                                aria-haspopup="true" aria-expanded="false">
                                <img src="${admin.getAvatar()}"
                                    width="40">
                                <span class="ml-2 d-none d-lg-inline-block"><span>Hello,</span> <span
                                        class="text-dark"><c:out value="${admin.getTenhienthi()}"></c:out></span> <i data-feather="chevron-down"
                                        class="svg-icon"></i></span>
                            </a>
                            <div class="dropdown-menu dropdown-menu-right user-dd animated flipInY">
                                <a class="dropdown-item" href="${pageContext.request.contextPath}/quanli/profile"><i data-feather="user"
                                        class="svg-icon mr-2 ml-1"></i>
                                    My Profile</a>
                               
                                <div class="dropdown-divider"></div>
                                <a class="dropdown-item" href="${pageContext.request.contextPath}/logout"><i data-feather="power"
                                        class="svg-icon mr-2 ml-1"></i>
                                    Logout</a>
                                <div class="dropdown-divider"></div>
                               
                            </div>
                        </li>
                        <!-- ============================================================== -->
                        <!-- User profile and search -->
                        <!-- ============================================================== -->
                    </ul>
                </div>
            </nav>
        </header>
        <!-- ============================================================== -->
        <!-- End Topbar header -->
        <!-- ============================================================== -->
        <!-- ============================================================== -->
        <!-- Left Sidebar - style you can find in sidebar.scss  -->
        <!-- ============================================================== -->
        <aside class="left-sidebar">
            <!-- Sidebar scroll-->
            <div class="scroll-sidebar">
                <!-- Sidebar navigation-->
                <nav class="sidebar-nav">
                    <ul id="sidebarnav">
                         <li> <a class="waves-effect waves-dark" href="${pageContext.request.contextPath}/quanli/Chart" aria-expanded="false"><i class="fas fa-chart-bar"></i><span class="hide-menu">Chart</span></a>
                       
                        <li> <a class="waves-effect waves-dark" href="${pageContext.request.contextPath}/quanli" aria-expanded="false"><i class="fa fa-table"></i><span class="hide-menu">Products</span></a>
                        </li>
                         <li> <a class="waves-effect waves-dark" href="${pageContext.request.contextPath}/quanli/dsuser" aria-expanded="false"><i class="fa fa-users"></i><span class="hide-menu">Users</span></a>
                        </li>
                         <li> <a class="waves-effect waves-dark" href="${pageContext.request.contextPath}/quanli/dsdonhang" aria-expanded="false"><i class="fas fa-money-bill-wave-alt"></i><span class="hide-menu">Payments</span></a>
                        </li>
                    </ul>
                   
                </nav>
                <!-- End Sidebar navigation -->
            </div>
            <!-- End Sidebar scroll-->
        </aside>
        <!-- ============================================================== -->
        <!-- End Left Sidebar - style you can find in sidebar.scss  -->
        <!-- ============================================================== -->
        <!-- ============================================================== -->
        <!-- Page wrapper  -->
        <!-- ============================================================== -->
        <div class="page-wrapper">
            <!-- ============================================================== -->
            <!-- Container fluid  -->
            <!-- ============================================================== -->
            <div class="container-fluid">
                <!-- ============================================================== -->
                <!-- Bread crumb and right sidebar toggle -->
                <!-- ============================================================== -->
                <div class="row page-titles">
                    <div class="col-md-5 align-self-center">
                        <h3 class="text-themecolor">Payments</h3>
                        <ol class="breadcrumb">
                            <li class="breadcrumb-item"><a href="javascript:void(0)">Home</a></li>
                            <li class="breadcrumb-item active">Payments</li>
                            
                        </ol>
                    </div>
                   
                </div>
                <!-- ============================================================== -->
                <!-- End Bread crumb and right sidebar toggle -->
                <!-- ============================================================== -->
                <!-- ============================================================== -->
                <!-- Start Page Content -->
                <!-- ============================================================== -->
                <div class="row">
                    <!-- column -->
                    <div class="col-12">
                        <div class="card">
                            <div class="card-body">
                                <h4 class="card-title">Danh sách sản phẩm</h4>
                                <h6 class="card-subtitle">
                              
                                </h6>
                                
      <div class="row">
      
        <div class="col-sm-12 col-md-6">
         
        </div>
      
    </div>
                                
      <div class="col-sm-12 col-md-7">
        <div class="dataTables_paginate paging_simple_numbers" id="zero_config_paginate">
            <ul class="pagination">
                <li class="paginate_button page-item previous " id="zero_config_previous"><a href="?page=${so-1}" class="page-link">Previous</a></li>
               
           		<c:forEach var="i" begin="1" end="${trang}">
           		
                        <li class="paginate_button page-item  <c:if test="${so==i}"><c:out value="${' active'}"></c:out></c:if>"><a href="?page=${i}" class="page-link"><c:out value="${i}"></c:out></a></li>
                </c:forEach>
                
                <li class="paginate_button page-item next" id="zero_config_next"><a href="?page=${so+1}"  class="page-link">Next</a></li>
            </ul>
        </div>
    </div>
                                <div class="table-responsive" >
                                    <table class="table">
                                        <thead>
                                            <tr>

                                                <th>#</th>
                                                <th>User</th>
                                                <th>Tổng thanh toán</th>
                                                <th>Sdt</th>
                                                <th>Địa chỉ </th>
                                                <th>Tình trạng</th>
                                                <th>Voucher </th>
                                                
                                                 <th >Thời gian</th>
                                                 <th>Chi tiết</th>
                                            </tr>
                                        </thead>
                                        <tbody>
                                           
                                            <c:forEach items="${list}" var="i">
	                                            <tr>
		                                                <td> <c:out value="${i.getId_donhang()}"></c:out> </td>
		                                                <td><c:out value="${i.getId_user()}"></c:out></td>
		                                                <td><c:out value="${i.getTong_thanh_toan()}"></c:out></td>
		                                                <td><c:out value="${i.getSdt()}"></c:out></td>
		                                                <td><c:out value="${i.getDiachi()}"></c:out></td>
		                                                <td>
															<c:choose>
																<c:when test="${i.getTinhtrang().equals('0')}"> <c:out value="${'Đang xử lí'}"></c:out></c:when>
																<c:when test="${i.getTinhtrang().equals('2')}"> <c:out value="${'Đang giao'}"></c:out></c:when>
																<c:when test="${i.getTinhtrang().equals('1')}"> <c:out value="${'Đã thanh toán'}"></c:out></c:when>
																<c:otherwise> <c:out value="${'Đơn hàng đã bị hủy'}"></c:out></c:otherwise>
															</c:choose>
		                                               		
		                                                </td>
		                                                 <td> </td>
		                                                <td><input type="datetime-local" value="<c:out value="${i.getThoigian()}"></c:out>">  </td>
		                                                 <td><a href="#" onclick='chitiet("${i.getId_donhang()}");'>Chi tiết</a>  </td>
	                                            </tr>
                                            </c:forEach>
                                           
                                        </tbody>
                                    </table>
                                </div>
                            </div>
                        </div>
                    </div>
                  
                </div>
                <!-- ============================================================== -->
                <!-- End PAge Content -->
                <!-- ============================================================== -->
            </div>
            <!-- ============================================================== -->
            <!-- End Container fluid  -->
            <!-- ============================================================== -->
            <!-- ============================================================== -->
            <!-- footer -->
            <!-- ============================================================== -->
            <!-- Project Lightboxes -->
    
              <!-- Lightbox -->
   
    <!-- end of lightbox -->
            <footer class="footer">
                © 2020 Linh Nguyễn Văn
            </footer>
            <!-- ============================================================== -->
            <!-- End footer -->
            <!-- ============================================================== -->
        </div>
        <!-- ============================================================== -->
        <!-- End Page wrapper  -->
        <!-- ============================================================== -->
    </div>
    <!-- ============================================================== -->
    <!-- End Wrapper -->
    <!-- ============================================================== -->
    <!-- ============================================================== -->
    <!-- All Jquery -->
    <!-- ============================================================== -->
    <script src="${pageContext.request.contextPath}/admin/assets/node_modules/jquery/jquery.min.js"></script>
    <!-- Bootstrap tether Core JavaScript -->
    <script src="${pageContext.request.contextPath}/admin/assets/node_modules/bootstrap/js/popper.min.js"></script>
    <script src="${pageContext.request.contextPath}/admin/assets/node_modules/bootstrap/js/bootstrap.min.js"></script>
    <!-- slimscrollbar scrollbar JavaScript -->
    <script src="${pageContext.request.contextPath}/admin/js/perfect-scrollbar.jquery.min.js"></script>
    <!--Wave Effects -->
    <script src="${pageContext.request.contextPath}/admin/js/waves.js"></script>
    <!--Menu sidebar -->
    <script src="${pageContext.request.contextPath}/admin/js/sidebarmenu.js"></script>
    <!--Custom JavaScript -->
    <script src="${pageContext.request.contextPath}/admin/js/custom.min.js"></script>
    <!-- jQuery peity -->
    <script src="${pageContext.request.contextPath}/admin/assets/node_modules/peity/jquery.peity.min.js"></script>
    <script src="${pageContext.request.contextPath}/admin/assets/node_modules/peity/jquery.peity.init.js"></script>
</body>

</html>