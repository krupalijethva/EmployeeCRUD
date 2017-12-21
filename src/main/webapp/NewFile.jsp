<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html ng-app="helloApp">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Hello AngularJS - Hello World</title>
<link rel="stylesheet"
	href="//netdna.bootstrapcdn.com/bootstrap/3.1.1/css/bootstrap.min.css">
<script
	src="//ajax.googleapis.com/ajax/libs/jquery/1.11.1/jquery.min.js"></script>
<script
	src="//netdna.bootstrapcdn.com/bootstrap/3.1.1/js/bootstrap.min.js"></script>
<script
	src="//ajax.googleapis.com/ajax/libs/angularjs/1.2.17/angular.min.js"></script>

<script>
	var helloApp = angular.module("helloApp", []);
	helloApp.controller("HelloCtrl", function($scope,$http) {
		$scope.name = "Calvin Hobbes";
		
		/* $scope.submitCountry = function() {
			$scope.myTxt = "You clicked submit!";
		} */
		$scope.countries = [];
		$scope.countryForm = {
			id : -1,
			countryName : "",
			population : ""
		};
		
		_refreshCountryData();
		$scope.submitCountry = function() {

			var method = "";
			var url = "";
			if ($scope.countryForm.id == -1) {
				//Id is absent in form data, it is create new country operation
				method = "POST";
				url = '/countries';
			} else {
				//Id is present in form data, it is edit country operation
				method = "PUT";
				url = '/AngularjsSpringRestExample/countries';
			}

			$http({
				method : method,
				url : url,
				data : angular.toJson($scope.countryForm),
				headers : {
					'Content-Type' : 'application/json'
				}
			}).then(_success, _error);
		};
		
		/* Private Methods */
		//HTTP GET- get all countries collection
		function _refreshCountryData() {
			$http(
					{
						method : 'GET',
						url : 'http://localhost:8080/EmpController'
					}).then(function successCallback(response) {
				$scope.countries = response.data;
			}, function errorCallback(response) {
				console.log(response.statusText);
			});
		}
		
		function _success(response) {
			_refreshCountryData();
			_clearFormData()
		}

		function _error(response) {
			console.log(response.statusText);
		}
	});
</script>
</head>
<body ng-controller="HelloCtrl">
	<header class="navbar navbar-static-top" id="top" role="banner">
	<div class="container">
		<div class="navbar-header">
			<button class="navbar-toggle" type="button" data-toggle="collapse"
				data-target=".bs-navbar-collapse">
				<span class="sr-only">Toggle navigation</span> <span
					class="icon-bar"></span> <span class="icon-bar"></span> <span
					class="icon-bar"></span>
			</button>
			<a href="/" class="navbar-brand">Hello-AngularJS</a>
		</div>
	</div>
	</header>
	<div class="container">
		<div class="page-header" style="margin: 0">
			<h1>Hello World</h1>
		</div>
		<div style="padding-top: 15px"></div>
		<div style="padding-top: 30px">
			<div style="padding: 0px 0px 20px 30px">
				<h4>Hello Calvin Hobbes! How are you doing today</h4>
			</div>
			<form class="form-horizontal" role="form" method="post"
				ng-submit="submitCountry()">
				<table>
					<tr>
						<th colspan="2">Add/Edit country</th>
					</tr>
					<tr>
						<td><label class="col-md-1 control-label">Name</label></td>
						<td><input type="text" ng-model="countryForm.countryName" /></td>
					</tr>
					<tr>
						<td><label class="col-md-1 control-label">Population</label></td>
						<td><input type="text" ng-model="countryForm.population" /></td>
					</tr>
					<tr>
						<td colspan="2"><input type="submit" value="Submit"
							class="blue-button" /></td>
					</tr>

				</table>
			</form>
			<p>{{myTxt}}</p>
		</div>
		<div class="panel panel-default">
			<div class="panel-heading">
				<h3 class="panel-title">Notes</h3>
			</div>
			<div class="panel-body">Pay attention to ng-model="name" and
				the template Calvin Hobbes</div>
		</div>
	</div>
</body>
<!-- <script>
	var helloApp = angular.module("CountryManagement", []);
	helloApp
			.controller(
					"CountryController",
					function($scope, $http) {

						$scope.countries = [];
						$scope.countryForm = {
							id : -1,
							countryName : "",
							population : ""
						};

						//Now load the data from server
						_refreshCountryData();

						$scope.submitCountry = function() {

							var method = "";
							var url = "";
							if ($scope.countryForm.id == -1) {
								//Id is absent in form data, it is create new country operation
								method = "POST";
								url = '/AngularjsSpringRestExample/countries';
							} else {
								//Id is present in form data, it is edit country operation
								method = "PUT";
								url = '/AngularjsSpringRestExample/countries';
							}

							$http({
								method : method,
								url : url,
								data : angular.toJson($scope.countryForm),
								headers : {
									'Content-Type' : 'application/json'
								}
							}).then(_success, _error);
						};
						/* Private Methods */
						//HTTP GET- get all countries collection
						function _refreshCountryData() {
							$http(
									{
										method : 'GET',
										url : 'http://localhost:8080/AngularjsSpringRestExample/countries'
									}).then(function successCallback(response) {
								$scope.countries = response.data;
							}, function errorCallback(response) {
								console.log(response.statusText);
							});
						}
						function _success(response) {
							_refreshCountryData();
							_clearFormData()
						}

						function _error(response) {
							console.log(response.statusText);
						}

						//Clear the form
						function _clearFormData() {
							$scope.countryForm.id = -1;
							$scope.countryForm.countryName = "";
							$scope.countryForm.population = "";
						}
						;
					});
</script>
<style>
.blue-button {
	background: #25A6E1;
	filter: progid: DXImageTransform.Microsoft.gradient( startColorstr='#25A6E1',
		endColorstr='#188BC0', GradientType=0);
	padding: 3px 5px;
	color: #fff;
	font-family: 'Helvetica Neue', sans-serif;
	font-size: 12px;
	border-radius: 2px;
	-moz-border-radius: 2px;
	-webkit-border-radius: 4px;
	border: 1px solid #1A87B9
}

.red-button {
	background: #CD5C5C;
	padding: 3px 5px;
	color: #fff;
	font-family: 'Helvetica Neue', sans-serif;
	font-size: 12px;
	border-radius: 2px;
	-moz-border-radius: 2px;
	-webkit-border-radius: 4px;
	border: 1px solid #CD5C5C
}

table {
	font-family: "Helvetica Neue", Helvetica, sans-serif;
	width: 50%;
}

caption {
	text-align: left;
	color: silver;
	font-weight: bold;
	text-transform: uppercase;
	padding: 5px;
}

th {
	background: SteelBlue;
	color: white;
}

tbody tr:nth-child(even) {
	background: WhiteSmoke;
}

tbody tr td:nth-child(2) {
	text-align: center;
}

tbody tr td:nth-child(3), tbody tr td:nth-child(4) {
	text-align: center;
	font-family: monospace;
}

tfoot {
	background: SeaGreen;
	color: white;
	text-align: right;
}

tfoot tr th:last-child {
	font-family: monospace;
}

td, th {
	border: 1px solid gray;
	width: 25%;
	text-align: left;
	padding: 5px 10px;
}
</style>
</head>
<body ng-app="CountryManagement" ng-controller="CountryController">
	<h1>AngularJS Restful web services example using $http</h1>
	<form ng-submit="submitCountry()">
		<table>
			<tr>
				<th colspan="2">Add/Edit country</th>
			</tr>
			<tr>
				<td>Country</td>
				<td><input type="text" ng-model="countryForm.countryName" /></td>
			</tr>
			<tr>
				<td>Population</td>
				<td><input type="text" ng-model="countryForm.population" /></td>
			</tr>
			<tr>
				<td colspan="2"><input type="submit" value="Submit"
					class="blue-button" /></td>
			</tr>
		</table>
	</form>
	<table>
		<tr>
			<th>CountryName</th>
			<th>Population</th>
			<th>Operations</th>
		</tr>
		<tr ng-repeat="country in countries">
			<td>{{ country.countryName }}</td>
			<td>{{ country.population }}</td>
			<td><a ng-click="editCountry(country)" class="blue-button">Edit</a>
				| <a ng-click="deleteCountry(country)" class="red-button">Delete</a></td>
		</tr>

	</table>
</body> -->
<!-- <body ng-controller="HelloCtrl">
	<header class="navbar navbar-static-top" id="top" role="banner">
	<div class="container">
		<div class="navbar-header">
			<button class="navbar-toggle" type="button" data-toggle="collapse"
				data-target=".bs-navbar-collapse">
				<span class="sr-only">Toggle navigation</span> <span
					class="icon-bar"></span> <span class="icon-bar"></span> <span
					class="icon-bar"></span>
			</button>
			<a href="/" class="navbar-brand">Hello-AngularJS</a>
		</div>		
	</div>
	</header>
	<div class="container">
		<div class="page-header" style="margin: 0">
			<h1>Hello World</h1>
		</div>
		<div style="padding-top: 15px">This example demonstrate the code
			sample for Hello World program. Type your name in the text field
			below</div>
		<div style="padding-top: 30px">
			<div style="padding: 0px 0px 20px 30px">
				<h4>Hello Calvin Hobbes! How are you doing today</h4></div>
			<form class="form-horizontal" role="form" method="post" action="#">
				<div class="form-group">
					<label class="col-md-1 control-label">Name</label>
					<div class="col-md-3">
						<input type="text" class="form-control" name="firstname"
							ng-model="name">
					</div>
				</div>
			</form>
		</div>
		<div class="panel panel-default">
			<div class="panel-heading">
				<h3 class="panel-title">Notes</h3>
			</div>
			<div class="panel-body">Pay attention to ng-model="name" and the template Calvin Hobbes</div>
		</div>		
	</div>
</body> -->
</html>
<!-- <html>
   
   <head>
      <title>AngularJS First Application</title>
   </head>
   
   <body>
      <h1>Sample Application</h1>
      
      <div ng-app = "">
         <p>Enter your Name: <input type = "text" ng-model = "name"></p>
         <p>Hello <span ng-bind = "name"></span>!</p>
      </div>
      
      <script src = "https://ajax.googleapis.com/ajax/libs/angularjs/1.3.14/angular.min.js"></script>
      
   </body>
</html> -->