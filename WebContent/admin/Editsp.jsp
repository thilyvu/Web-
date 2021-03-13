<%@page import="org.apache.jasper.tagplugins.jstl.core.ForEach"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
       <%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>

<!DOCTYPE html>
<html lang="en">
<c:if test="${them!=null}">
	<script type="text/javascript">
		alert("thêm sản phẩm thành công");
	</script>
</c:if>
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
                        <h3 class="text-themecolor">Edit Product</h3>
                        <ol class="breadcrumb">
                            <li class="breadcrumb-item"><a href="javascript:void(0)">Home</a></li>
                            <li class="breadcrumb-item active">Products</li>
                             <li class="breadcrumb-item active">Edit Product</li>
                        </ol>
                    </div>
                   
                </div>
                <!-- ============================================================== -->
                <!-- End Bread crumb and right sidebar toggle -->
                <!-- ============================================================== -->
                <!-- ============================================================== -->
                <!-- Start Page Content -->
                <!-- ============================================================== -->
                <!-- Row -->
                <div class="row">
                    <!-- Column -->
                    <div class="col-lg-4 col-xlg-3 col-md-5">
                        <div class="card">
                            <div class="card-body">
                                <center class="m-t-30"> <img src='<c:out value="${sanpham.getImagesrc().trim()}"></c:out>'  width="100%" />
                                </center>
                            </div>
                              <div class="form-group">
                                        <label class="col-md-12">Link sản phẩm</label>
                                        <div class="col-md-12">
                                            <input type="text" form="form1" name="link" value="<c:out value="${sanpham.getImagesrc().trim()}"></c:out>" class="form-control form-control-line">
                                        </div>
                        </div>
                        </div>
                    </div>
                    <!-- Column -->
                    <!-- Column -->
                    <div class="col-lg-8 col-xlg-9 col-md-7">
                        <div class="card">
                            <!-- Tab panes -->
                        
                            <div class="card-body">
                                <form class="form-horizontal form-material" 
                                action="<c:choose><c:when test="${sanpham!=null}"><c:out value="${pageContext.request.contextPath}/Updateproduct"></c:out></c:when><c:otherwise><c:out value="${pageContext.request.contextPath}/Addproduct"></c:out></c:otherwise></c:choose>" 
                              
                                id="form1">
                                    <div class="form-group">
                                        <label class="col-md-12">Tên sản phẩm</label>
                                        <div class="col-md-12">
                                            <input type="text" name="ten" value="<c:out value="${sanpham.getTen_sp().trim()}"></c:out>" class="form-control form-control-line" required="required">
                                        </div>
                        </div>
                                    <div class="form-group">
                                        <label class="col-md-12">Giá</label>
                                        <div class="col-md-12">
                                            <input type="text" name="gia" value="<c:out value="${sanpham.getPrice()}"></c:out>" class="form-control form-control-line" required="required">
                                        </div>
                                    </div>
                                    <div class="form-group">
                                        <label for="example-email" class="col-md-12">Số lượng cỏn</label>
                                        <div class="col-md-12">
                                            <input type="number" name="soluong" value="<c:out value="${sanpham.getSl_con()}"></c:out>" class="form-control form-control-line" name="example-email" id="example-email" required="required">
                                        </div>
                                    </div>
                                    <div class="form-group">
                                        <label class="col-md-12">Nhà sản xuất</label>
                                        <div class="col-md-12">
                                            <input type="text" name="nsx" value="<c:out value="${sanpham.getNha_sx().trim()}"></c:out>" class="form-control form-control-line">
                                        </div>
                                    </div>
                                    <div class="form-group">
                                        <label class="col-md-12">Màu</label>
                                        <div class="col-md-12">
                                            <input type="text" name="mau" value="<c:out value="${sanpham.getMau().trim()}"></c:out>" class="form-control form-control-line">
                                        </div>
                                    </div>
                                    <div class="form-group">
                                        <label class="col-md-12">Mô tả</label>
                                        <div class="col-md-12">
                                            <textarea rows="5"  name="mota" class="form-control form-control-line"><c:out value="${sanpham.getMota().trim()}"></c:out></textarea>
                                        </div>
                                    </div>
                                    <div class="form-group">
                                        <label class="col-sm-12">Loại</label>
                                        <div class="col-sm-12">
                                            <select class="form-control form-control-line" name="loai">
	                                            <c:forEach var="i" begin="1" end="4">
	                                           		<option <c:if test="${i==sanpham.getId_loai()}"><c:out value="${' selected'}"></c:out></c:if> value="${i}"> 
	                                           			<c:out value="${loai[i-1]}"></c:out>
	                                           		</option>
	                                            	
	                                            </c:forEach>
                                               
                                            </select>
                                        </div>
                                    </div>
                                   	<input type="hidden" name="id" value='<c:out value="${sanpham.getCurrentSlide()}"></c:out>'>
                                </form>
                                  <div class="form-group">
                                        <div class="col-sm-12">
                                            <button class="btn btn-success" form="form1" value="1">Lưu</button>
                                        </div>
                                    </div>
                            </div>
                        </div>
                    </div>
                    <!-- Column -->
                </div>
                <!-- Row -->
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
</body>

</html>