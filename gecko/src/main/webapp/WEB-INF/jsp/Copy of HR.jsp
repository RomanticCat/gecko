<!DOCTYPE html>
<html ng-app="myapp">
<head>
	<meta charset="ISO-8859-1">
	<title>CRUD in AngularJS</title>
	<script type="text/javascript" src="js/angular.min.js"></script>
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
			<th>HireDate</th>
			<th>Salary</th>
			<th>Comm</th>
			<th>Dept</th>
			<th> </th>
		</tr>
		<tr ng-repeat="emp in empList">
			<td>{{$index+1}}</td>
			<td>{{emp.empno}}</td>
			<td>{{emp.ename}}</td>
			<td>{{emp.job}}</td>
			<td>{{emp.mgr}}</td>
			<td>{{emp.hiredate}}</td>
			<td>{{emp.sal}}</td>
			<td>{{emp.comm}}</td>
			<td>{{emp.deptno}}</td>
			<td>
				<a href="#" ng-click="del(emp.empno)">Delete</a>
				<a href="#" ng-click="selectEdit(emp.empno)">Edit</a>
			</td>
		</tr>
	</table>
	
	<br />
	<h3>Employee Information</h3>
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
			<div class="col-md-2">Comm</div>
			<div class="col-md-4"><input type="text" name="comm" ng-model="comm" class="form-control"></div>
		</div>	
		<div class="form-group">
			<div class="col-md-2">Dept</div>
			<div class="col-md-4"><input type="text" name="deptno" ng-model="deptno" class="form-control"></div>
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
		myapp.controller('empController', function($scope){
			$scope.empList = [
								{empno:'7369', ename:'SMITH', job:'CLERK', mgr:'7902', hiredate:'1980-12-17', sal:'800', comm:'', deptno:'20'},
								{empno:'7499', ename:'ALLEN', job:'SALESMAN', mgr:'7698', hiredate:'1981-02-20', sal:'1600', comm:'300', deptno:'30'},
								{empno:'7521', ename:'WARD', job:'SALESMAN', mgr:'7698', hiredate:'1981-02-22', sal:'1250', comm:'500', deptno:'30'},
								{empno:'7566', ename:'JONES', job:'MANAGER', mgr:'7839', hiredate:'1981-04-20', sal:'2975', comm:'', deptno:'20'},
								{empno:'7654', ename:'MARTIN', job:'SALESMAN', mgr:'7698', hiredate:'1981-09-28', sal:'1250', comm:'1400', deptno:'30'}
			                  
			                       
                  ];
			
			$scope.add = function(){
				$scope.empList.push({
					empno:$scope.empno, ename:$scope.ename, job:$scope.job, mgr:$scope.mgr, hiredate:$scope.hiredate, sal:$scope.sal, comm:$scope.comm, deptno:$scope.deptno
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
			
			
			
			$scope.edit = function(){
				var index = getSelectedIndex($scope.empno);
				
				$scope.empList[index].empno = $scope.empno;
				$scope.empList[index].ename = $scope.ename;
				$scope.empList[index].job = $scope.job;
				$scope.empList[index].mgr = $scope.mgr;
				$scope.empList[index].hiredate = $scope.hiredate;
				$scope.empList[index].sal = $scope.sal;
				$scope.empList[index].comm = $scope.comm;
				$scope.empList[index].deptno = $scope.deptno;	
				
				
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
				
				
			};
			$scope.del = function(empno){
				var result = confirm('Are you sure?');
				if(result == true) {
					var index = getSelectedIndex(empno);
					$scope.empList.splice(index, 1);
				}
			};
			
			
			
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