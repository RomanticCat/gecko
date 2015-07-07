<!DOCTYPE html>
<html ng-app="myapp">
<head>
	<meta charset="ISO-8859-1">
	<title>SpringMVC / JPA(Hibernate) / JSON / AngularJS</title>
	<script type="text/javascript" src="js/angular.min.js"></script>
	<!-- <script src="js/ui-bootstrap-tpls-0.13.0.min.js"></script> -->
	<link rel="stylesheet" href="bootstrap/css/bootstrap.min.css">
</head>

<body ng-controller="empController">
<div class="container">
	<br /><br />
	<table class="table table-striped">
		<tr>
			<th> </th>
			<th>EMP No.</th>
			<th>Name</th>
			<th>Job</th>
			<th>Manager</th>
			<th>Hire Date</th>
			<th>Salary</th>
			<th>Comm</th>
			<th>Dept</th>
			<th> </th>
		</tr>
		<tr ng-repeat="emp in empList | orderBy:'ename'">
			<td>{{$index+1}}</td>
			<td>    
				<a id="empDetail" ng-href="getEmpByEmpNoJSONJpa.do?empno={{emp.empno}}">{{emp.empno}}</a>
			</td>
			<td>{{emp.ename}}</td>
			<td>{{emp.job}}</td>
			<td>{{emp.mgr}}</td>
			<td>{{emp.hiredate}}</td>
			<td>{{emp.sal | currency:"$":0}}</td>
			<td>{{emp.comm | number:0}}</td>
			<td>{{emp.deptname}}<input type="hidden" name="deptno" ng-value="{{deptno}}" /></td>
			<td>
				<a href="#" ng-click="del(emp.empno)">Delete</a>
				<a href="#" ng-click="selectEdit(emp.empno)">Edit</a>
			</td>
		</tr>
	</table>
	
	<br />
	<h3>Employee Information4</h3>
	<form name="empForm" class="form-horizontal">
		<div class="form-group">
			<div class="col-md-2">Employee No</div>
			<div class="col-md-4"><input type="text" name="empno" ng-model="empno" class="form-control"></div>
		</div>
		<div class="form-group">
			<div class="col-md-2">Name</div>
			<div class="col-md-4"><input type="text" name="ename" ng-model="ename" class="form-control"></div>
		</div>
		<div class="form-group">
			<div class="col-md-2">Job</div>
			<div class="col-md-4"><input type="text" name="job" ng-model="job" class="form-control"></div>
		</div>	
		<div class="form-group">
			<div class="col-md-2">Manager</div>
<!-- 			
			
			<div class="col-md-4"><input type="text" name="mgr" ng-model="mgr" class="form-control" typeahead="emp.empno as emp.ename for emp in empList| filter:$viewValue | limitTo:8"></div>
 -->
			<div class="col-md-4"><input type="text" name="mgr" ng-model="mgr" class="form-control"></div>
		</div>	
		<div class="form-group">
			<div class="col-md-2">Hire Date</div>
			<div class="col-md-4"><input type="text" name="hiredate" ng-model="hiredate" class="form-control"></div>
		</div>	
		<div class="form-group">
			<div class="col-md-2">Salary</div>
			<div class="col-md-4"><input type="text" name="sal" ng-model="sal" class="form-control"></div>
		</div>	
		<div class="form-group">
			<div class="col-md-2">Commission</div>
			<div class="col-md-4"><input type="text" name="comm" ng-model="comm" class="form-control"></div>
		</div>	
		<div class="form-group">
			<div class="col-md-2">Dept</div>
			<div class="col-md-4">
				<select ng-model="deptno" ng-options="dept.deptno as dept.dname for dept in deptList" ng-required="true">
					<option value="">Dept</option>
				</select>
			</div>
		</div>	
		

		<div class="form-group">
			<div class="col-md-1"> </div>
			<div class="col-md-1"><input type="button" value="Add" ng-click="add()" class="btn btn-success btn-sm"></div>
			<div class="col-md-1"><input type="button" value="Save" ng-click="edit()" class="btn btn-info btn-sm"></div>
			<div class="col-md-3"> </div>
		</div>	

	</form>
	
	<script type="text/javascript">
		var myapp = angular.module('myapp', []);
		
		myapp.controller('empController', function($scope, $http){
			/* Sample Data Lists
				$scope.empList = [
						{empno:'7369', ename:'SMITH', job:'CLERK', mgr:'7902', hiredate:'1980-12-17', sal:'800', comm:'', deptno:'20'},
						{empno:'7566', ename:'JONES', job:'MANAGER', mgr:'7839', hiredate:'1981-04-20', sal:'2975', comm:'', deptno:'20'},
						{empno:'7654', ename:'MARTIN', job:'SALESMAN', mgr:'7698', hiredate:'1981-09-28', sal:'1250', comm:'1400', deptno:'30'}
                ];
			*/
			$http.get("getEmpListJSONJpa.do")
				.success(function(data){
					$scope.empList = data;
				});
			$http.get("getDeptListJSONJpa.do")
			.success(function(data){
				$scope.deptList = data;
				
			});
			$scope.add = function(){
				var hireDateChar = $scope.hiredate
				
				
				var dataObj = {
					//	"empno" 	 : $scope.empno,
						"ename" 	 : $scope.ename,
						"job"   	 : $scope.job,
						"mgr"   	 : $scope.mgr,
						"hiredate"	 : getDateFromString(hireDateChar),
						"sal" 	 	 : $scope.sal,
						"comm" 		 : $scope.comm,
						"deptno"	 : $scope.deptno
				}

				var res = $http.post('saveEmployeeJpa.do', dataObj);
				res.success(function (data, status, headers,config){
					$scope.empList = data;
				});
				res.error(function (data, status, headers,config){
					alert('failure msg:'+ JSON.stringify({data:data}));
				});
				
				/* alert('empno:' + $scope.empno + ', ename:'+$scope.ename + ', job:'+$scope.job
						+', manager:'+$scope.mgr+', hiredate:'+getDateFromString(hireDateChar)
						+', sal:'+$scope.sal+', comm:'+$scope.comm+', deptno:'+$scope.deptno); */
				
				$scope.empno = '';
				$scope.ename= '';
				$scope.job = '';
				$scope.mgr = '';
				$scope.hiredate = '';
				$scope.sal = '';
				$scope.comm = '';
				$scope.deptno = '';
			}			
			
			
			
			$scope.edit = function(){
				/*
				var index = getSelectedIndex($scope.empno);
				
				
				$scope.empList[index].empno = $scope.empno;
				$scope.empList[index].ename = $scope.ename;
				$scope.empList[index].job = $scope.job;
				$scope.empList[index].mgr = $scope.mgr;
				$scope.empList[index].hiredate = $scope.hiredate;
				$scope.empList[index].sal = $scope.sal;
				$scope.empList[index].comm = $scope.comm;
				$scope.empList[index].deptno = $scope.deptno;	
				*/
				
				var hireDateChar = $scope.hiredate
				
				
				var dataObj = {
						"empno" 	 : $scope.empno,
						"ename" 	 : $scope.ename,
						"job"   	 : $scope.job,
						"mgr"   	 : $scope.mgr,
						"hiredate"	 : getDateFromString(hireDateChar),
						"sal" 	 	 : $scope.sal,
						"comm" 		 : $scope.comm,
						"deptno"	 : $scope.deptno
				}

				var res = $http.post('saveEmployeeJpa.do', dataObj);
				
				res.success(function (data, status, headers,config){
					$scope.empList = data;
				});
				res.error(function (data, status, headers,config){
					alert('failure msg:'+ JSON.stringify({data:data}));
				});
				
				$scope.empno = '';
				$scope.ename= '';
				$scope.job = '';
				$scope.mgr = '';
				$scope.hiredate = '';
				$scope.sal = '';
				$scope.comm = '';
				$scope.deptno = '';				
			}
			$scope.selectEdit = function(empno){
				
				
				var index = getSelectedIndex(empno);
				var emp = $scope.empList[index];
				$scope.empno = emp.empno;
				$scope.ename= emp.ename;
				$scope.job = emp.job;
				$scope.mgr = emp.mgr;
				$scope.hiredate = emp.hiredate;
				$scope.sal = emp.sal;
				$scope.comm = emp.comm;
				$scope.deptno = emp.deptno;	
				
				//$scope.deptList = emp.deptno;	
				
			};
			$scope.del = function(empno){
				var result = confirm('Are you sure?');
				if(result == true) {
					$http.get("deleteEmployeeJpa.do", {
							params: {empno:empno}
						}		
					)
					.success(function(data){
						$scope.empList = data;
					});
					/*
					var index = getSelectedIndex(empno);
					$scope.empList.splice(index, 1);
					*/
				}
			};
			
			
			function getDateFromString(dateString){
				var day = dateString.substring(0, 2);
				var month = dateString.substring(3, 5);
				var year = dateString.substring(6, 10);
				
				
				return new Date(year + "-" + month + "-" + day);
				
				
			}
			function getSelectedIndex(empno){
				for (var i=0;i<$scope.empList.length;i++){
				
					if($scope.empList[i].empno==empno){
						return i;
					}
				}
				return -1;
			};
		});
	</script>
</div>	
</body>
</html>