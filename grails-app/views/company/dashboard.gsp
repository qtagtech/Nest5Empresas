<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
    <head>
    <meta name="layout" content="dashboardLayout"/>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <title>Nest5 Admin</title>
    <meta name="author" content="Nest5.com" />
    <meta name="description" content="" />
    <meta name="keywords" content="" />
    <meta name="application-name" content="Nest5" />

    <!-- Mobile Specific Metas -->
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <!-- Force IE9 to render in normal mode -->
    <meta http-equiv="X-UA-Compatible" content="IE=edge" />


        <r:require modules="dashboard,uniform"/>
    </head>
      
    <body>


        <!--Body content-->
        <div id="content" class="clearfix">
            <div class="contentwrapper"><!--Content wrapper-->

                <div class="heading">

                    <h3>Dashboard</h3>                    

                    <div class="resBtnSearch">
                        <a href="#"><span class="icon16 icomoon-icon-search-3"></span></a>
                    </div>

                    <div class="search">

                        <form id="searchform" action="search.html">
                            <input type="text" id="tipue_search_input" class="top-search" placeholder="Search here ..." />
                            <input type="submit" id="tipue_search_button" class="search-btn" value=""/>
                        </form>
                
                    </div><!-- End search -->
                    
                    <ul class="breadcrumb">
                        <li>Te encuentras en:</li>
                        <li>
                            <a href="#" class="tip" title="back to dashboard">
                                <span class="icon16 icomoon-icon-screen-2"></span>
                            </a> 
                            <span class="divider">
                                <span class="icon16 icomoon-icon-arrow-right-3"></span>
                            </span>
                        </li>
                        <li class="active">${youarehere}</li>
                    </ul>

                </div><!-- End .heading-->
                <div id="mainDashboard" >
                <!-- Build page from here: -->
                <div class="row">

                    <div class="col-lg-8">
                        <div class="centerContent">
                  
                            <ul class="bigBtnIcon">
                                <li>
                                    <a href="#" title="I`m with gradient" class="tipB">
                                        <span class="icon icomoon-icon-users"></span>
                                        <span class="txt">Users</span>
                                        <span class="notification">5</span>
                                    </a>
                                </li>
                                <li>
                                    <a href="#">
                                        <span class="icon icomoon-icon-support"></span>
                                        <span class="txt">Support tickets</span>
                                        <span class="notification blue">12</span>
                                    </a>
                                </li>
                                <li>
                                    <a href="#" title="I`m with pattern" class="pattern tipB">
                                        <span class="icon icomoon-icon-bubbles-2"></span>
                                        <span class="txt">New Comments</span>
                                        <span class="notification green">23</span>
                                    </a>
                                </li>
                                <li>
                                    <a href="#">
                                        <span class="icon icomoon-icon-basket"></span>
                                        <span class="txt">Orders</span>
                                        <span class="notification">+5</span>
                                    </a>
                                </li>
                                <li>
                                    <a href="#">
                                        <span class="icon icomoon-icon-history"></span>
                                        <span class="txt">Backups</span>
                                    </a>
                                </li>
                                <li>
                                    <a href="#">
                                        <span class="icon icomoon-icon-meter-fast"></span>
                                        <span class="txt">Site Usage</span>
                                    </a>
                                </li>
                            </ul>
                        </div>
                    </div><!-- End .span8 -->

                    <div class="col-lg-4">
                        <div class="centerContent">
                            <div dir="ltr" class="circle-stats">
                                
                                <div class="circular-item tipB" title="Site overload">
                                    <span class="icon icomoon-icon-fire"></span>
                                    <input type="text" value="62" class="redCircle" />
                                </div>

                                <div class="circular-item tipB" title="Site average load time">
                                    <span class="icon icomoon-icon-busy"></span>
                                    <input type="text" value="12" class="blueCircle" />
                                </div>

                                <div class="circular-item tipB" title="Target complete">
                                    <span class="icon icomoon-icon-target-2"></span>
                                    <input type="text" value="94" class="greenCircle" />
                                </div>

                            </div>
                        </div>

                    </div><!-- End .span4 -->

                </div><!-- End .row -->

                <div class="row">

                    <div class="col-lg-8">

                        <div class="panel panel-default chart gradient">
                            <div class="panel-heading">
                                <h4>
                                    <span class="icon16 icomoon-icon-bars"></span>
                                    <span>Visitors Chart</span>
                                </h4>
                                <a href="#" class="minimize">Minimize</a>
                            </div>
                            <div class="panel-body" style="padding-bottom:0;">
                               <div class="visitors-chart" style="height: 230px;width:100%;margin-top:15px; margin-bottom:15px;"></div>
                               <ul class="chartShortcuts">
                                    <li>
                                        <a href="#">
                                            <span class="head">Total Visits</span>
                                            <span class="number">509</span>
                                        </a>
                                    </li>
                                    <li>
                                        <a href="#">
                                            <span class="head">Uniqiue Visits</span>
                                            <span class="number">309</span>
                                        </a>
                                    </li>
                                    <li>
                                        <a href="#">
                                            <span class="head">External Visits</span>
                                            <span class="number">109</span>
                                        </a>
                                    </li>
                                    <li>
                                        <a href="#">
                                            <span class="head">Impressions</span>
                                            <span class="number">325</span>
                                        </a>
                                    </li>
                                </ul>
                               
                            </div>

                        </div><!-- End .panel -->

                    </div><!-- End .span8 -->

                    <div class="col-lg-4">

                        <div class="sparkStats">
                            <h4>389 people visited this site <a href="#" class="icon tip" title="Configure"><span class="icon16 icomoon-icon-cog-2"></span></a></h4>
                            <ul class="list-unstyled">
                                <li><span class="sparkLine1 "></span> Visits: <span class="number">509</span></li>
                                <li>
                                    <span class="sparkLine2"></span>
                                    Unique Visitors: 
                                    <span class="number">389</span>
                                </li>
                                <li><span class="sparkLine3"></span> 
                                    Pageviews: 
                                    <span class="number">731</span>
                                </li>
                                <li><span class="sparkLine4"></span>
                                    Pages / Visit: 
                                    <span class="number">1.44</span>
                                </li>
                                <li><span class="sparkLine5"></span>
                                    Avg. Visit Duration: 
                                    <span class="number">00:01:21</span>
                                </li>
                                <li><span class="sparkLine6"></span>
                                    Bounce Rate: <span class="number">68.37%</span>
                                </li>
                                <li><span class="sparkLine7"></span>
                                    % New Visits: 
                                    <span class="number">76.23%</span>
                                </li>

                            </ul>
                            <div class="right" style="padding: 15px 0">
                                <a href="charts.html" class="btn btn-info">View full statistic <span class="icon16 icomoon-icon-arrow-right-3 white"></span></a>
                            </div>
                        </div><!-- End .sparkStats -->
                        

                    </div><!-- End .span4 -->

                </div><!-- End .row -->

                <div class="row">

                    <div class="col-lg-4">

                        <div class="panel panel-default gradient">

                            <div class="panel-heading">
                                <h4>
                                    <span class="icon16 icomoon-icon-pie"></span>
                                    <span>Visitors overview</span>
                                </h4>
                                <a href="#" class="minimize">Minimize</a>
                            </div>
                            <div class="panel-body">
                               <div class="pieStats" style="height: 240px; width:100%;">

                                </div>
                            </div>

                        </div><!-- End .panel -->

                     
                    </div><!-- End .span4 -->

                    <div class="col-lg-4">
                        <div class="panel panel-default gradient">

                            <div class="panel-heading">
                                <h4>
                                    <span class="icon16 icomoon-icon-thumbs-up"></span>
                                    <span>Vital Stats  <span class="label label-success"><span class="icomoon-icon-arrow-up-2 white"></span>1268</span></span>
                                </h4>
                                <a href="#" class="minimize">Minimize</a>
                            </div>
                            <div class="panel-body">
                              
                                <div class="vital-stats" style="padding-bottom:23px">
                                    <ul class="list-unstyled">
                                        <li>
                                            <span class="icon24 icomoon-icon-arrow-up-2 green"></span> 81% Clicks
                                            <span class="pull-right strong">567</span>
                                            <div class="progress progress-striped">
                                                <div class="progress-bar" style="width: 81%;"></div>
                                            </div>
                                        </li>
                                        <li>
                                            <span class="icon24 icomoon-icon-arrow-up-2 green"></span> 72% Uniquie Clicks
                                            <span class="pull-right strong">507</span>
                                            <div class="progress progress-striped ">
                                                <div class="progress-bar progress-bar-success" style="width: 72%;"></div>
                                            </div>
                                        </li>
                                        <li>
                                            <span class="icon24 icomoon-icon-arrow-down-2 red"></span> 53% Impressions
                                            <span class="pull-right strong">457</span>
                                            <div class="progress progress-striped ">
                                                <div class="progress-bar progress-bar-warning" style="width: 53%;"></div>
                                            </div>
                                        </li>
                                        <li>
                                            <span class="icon24 icomoon-icon-arrow-up-2 green"></span> 3% Online Users
                                            <span class="pull-right strong">8</span>
                                            <div class="progress progress-striped ">
                                                <div class="progress-bar progress-bar-danger" style="width: 3%;"></div>
                                            </div>
                                        </li>

                                    </ul>
                                </div>

                            </div>

                        </div><!-- End .panel -->  
                    </div><!-- End .span4 -->

                    <div class="col-lg-4">

                        <div class="reminder">
                            <h4>Things you need to do 
                                <a href="#" class="icon tip" title="Configure"><span class="icon16 icomoon-icon-cog-2"></span></a>
                            </h4>
                            <ul>
                                <li class="clearfix">
                                    <div class="icon">
                                        <span class="icon32 icomoon-icon-basket gray"></span>
                                    </div>
                                    <span class="number">7</span> 
                                    <span class="txt">Pending Orders</span>
                                    <a class="btn btn-warning">go</a>
                                </li>
                                <li class="clearfix">
                                    <div class="icon">
                                        <span class="icon32 icomoon-icon-support red"></span>
                                    </div>
                                    <span class="number">3</span> 
                                    <span class="txt">Support Tickets </span>
                                    <a class="btn btn-warning">go</a>
                                </li>
                                <li class="clearfix">
                                    <div class="icon">
                                        <span class="icon32 icomoon-icon-new green"></span>
                                    </div>
                                    <span class="number">5</span> 
                                    <span class="txt">New Invoices </span>
                                    <a class="btn btn-warning">go</a>
                                </li>
                                <li class="clearfix">
                                    <div class="icon">
                                        <span class="icon32 icomoon-icon-bubbles-2 blue"></span>
                                    </div>
                                    <span class="number">13</span> 
                                    <span class="txt">Review Comments</span> 
                                    <a class="btn btn-warning">go</a>
                                </li>
                                <li class="clearfix">
                                    <div class="icon">
                                        <span class="icon32 icomoon-icon-cog dark"></span>
                                    </div>
                                    <span class="number">2</span> 
                                    <span class="txt">Settings to Change </span>
                                    <a class="btn btn-warning">go</a>
                                </li>                                   
                            </ul>
                        </div><!-- End .reminder -->

                    </div><!-- End .span4 -->

                </div><!-- End .row -->

                <div class="row">

                    <div class="col-lg-8">
                        <div class="panel panel-default calendar gradient">
                            <div class="panel-heading">
                                <h4>
                                    <span class="icon16 icomoon-icon-calendar"></span>
                                    <span>Calendar</span>
                                </h4>
                                <!-- <a href="#" class="minimize">Minimize</a> -->
                            </div>
                            <div class="panel-body noPad"> 
                                <div id="calendar">
                                </div>
                            </div>

                        </div><!-- End .panel -->  
                    </div><!-- End .span8 --> 

                    <div class="col-lg-4">

                        <div class="todo">
                            <h4>To Do List <a href="#" class="icon tip" title="Add task"><span class="icon16 icomoon-icon-plus"></span></a></h4>
                            <ul>
                                <li class="clearfix">
                                    <div class="txt">
                                        Fix some bugs
                                        <span class="by badge">Admin</span>
                                        <span class="date label label-danger">Today</span>
                                    </div>
                                    <div class="controls">
                                        <a href="#" title="Edit task" class="tip"><span class="icon12 icomoon-icon-pencil"></span></a>
                                        <a href="#" title="Remove task" class="tip"><span class="icon12 icomoon-icon-remove"></span></a>
                                    </div>
                                </li>
                                <li class="clearfix">
                                    <div class="txt">
                                        Add post about birds
                                        <span class="by badge">Julia</span>
                                        <span class="date label label-success">Tomorrow</span>
                                    </div>
                                    <div class="controls">
                                        <a href="#" title="Edit task" class="tip"><span class="icon12 icomoon-icon-pencil"></span></a>
                                        <a href="#" title="Remove task" class="tip"><span class="icon12 icomoon-icon-remove"></span></a>
                                    </div>
                                </li>
                                <li class="clearfix">
                                    <div class="txt">
                                        Remove some items
                                        <span class="by badge">Admin</span>
                                        <span class="date label label-success">Tomorrow</span>
                                    </div>
                                    <div class="controls">
                                        <a href="#" title="Edit task" class="tip"><span class="icon12 icomoon-icon-pencil"></span></a>
                                        <a href="#" title="Remove task" class="tip"><span class="icon12 icomoon-icon-remove"></span></a>
                                    </div>
                                </li>
                                <li class="clearfix">
                                    <div class="txt">
                                        Staff party
                                        <span class="by badge">Admin</span>
                                        <span class="date label label-info">08.08.2012</span>
                                    </div>
                                    <div class="controls">
                                        <a href="#" title="Edit task" class="tip"><span class="icon12 icomoon-icon-pencil"></span></a>
                                        <a href="#" title="Remove task" class="tip"><span class="icon12 icomoon-icon-remove"></span></a>
                                    </div>
                                </li>
                                <li class="clearfix">
                                    <div class="txt">
                                        Shedule backup
                                        <span class="by badge">Steve</span>
                                        <span class="date label label-info">08.08.2012</span>
                                    </div>
                                    <div class="controls">
                                        <a href="#" title="Edit task" class="tip"><span class="icon12 icomoon-icon-pencil"></span></a>
                                        <a href="#" title="Remove task" class="tip"><span class="icon12 icomoon-icon-remove"></span></a>
                                    </div>
                                </li>
                            </ul>
                        </div>

                    </div><!-- End .span4 -->

                    <div class="col-lg-4">

                        <div class="panel panel-default gradient">
                            <div class="panel-heading">
                                <h4>
                                    <span class="icon16 icomoon-icon-bubbles-6"></span>
                                    <span>Messages layout</span>
                                </h4>
                            </div>
                            <div class="panel-body noPad">

                                <ul class="messages">
                                    <li class="user clearfix">
                                        <a href="#" class="avatar">
                                            <img src="${resource(dir:'dashboard/images',file: 'avatar2.jpeg')}" alt="user" />
                                        </a>
                                        <div class="message">
                                            <div class="head clearfix">
                                                <span class="name"><strong>Lazar</strong> says:</span>
                                                <span class="time">25 seconds ago</span>
                                            </div>
                                            <p>
                                                Time to go i call you tomorrow.
                                            </p>
                                        </div>
                                    </li>
                                    <li class="admin clearfix">
                                        <a href="#" class="avatar">
                                            <img src="${resource(dir:'dashboard/images',file: 'avatar3.jpeg')}" alt="user" />
                                        </a>
                                        <div class="message">
                                            <div class="head clearfix">
                                                <span class="name"><strong>Sugge</strong> says:</span>
                                                <span class="time">just now</span>
                                            </div>
                                            <p>
                                                OK, have a nice day.
                                            </p>
                                        </div>
                                    </li>

                                    <li class="sendMsg">
                                        <form class="form-horizontal" action="#">
                                            <textarea class="elastic" id="textarea" rows="1" placeholder="Enter your message ..." style="width:98%;"></textarea>
                                            <button type="submit" class="btn btn-info marginT10">Send message</button>
                                        </form>
                                    </li>
                                    
                                </ul>

                            </div>

                        </div><!-- End .panel -->


                    </div><!-- End .span4 -->

                </div><!-- End .row -->
                </div>
            </div><!-- End contentwrapper -->
        </div><!-- End #content -->
    <r:script>
    $(document).ready(function(){
        var vague = $("#mainDashboard").Vague({intensity:7});
        vague.blur();
    });
    </r:script>



    </body>
</html>
