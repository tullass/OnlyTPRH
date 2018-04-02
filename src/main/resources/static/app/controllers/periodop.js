angular.module("JWTDemoApp").controller(
		"periodopController",
		function($scope, $http, $filter) {

			var urlb = 'http://localhost:8080/prestaa';
			$scope.periodolistap = function() {
				$http({
					method : 'GET',
					url : urlb + '/listar',
				}).then(function successCallback(response) {
					$scope.listap = response.data;
				}, function errorCallback(response) {
				});
			};
			$scope.periodolistap();

			$scope.exportToPdf = function() {
				html2canvas(document.getElementById('customers'), {
					onrendered : function(canvas) {
						var data = canvas.toDataURL();
						var docDefinition = {

							content : [ {
								image : data,
								width : 400,
							} ]
						};

						pdfMake.createPdf(docDefinition)
								.download("periodo.pdf");
					}
				});
			}

			$scope.CalDate = function(date1, date2) {
				var diff = Math.floor(date1.getTime() - date2.getTime());
				var secs = Math.floor(diff / 1000);
				var mins = Math.floor(secs / 60);
				var hours = Math.floor(mins / 60);
				var days = Math.floor(hours / 24);
				var months = Math.floor(days / 31);
				var years = Math.floor(months / 12);
				months = Math.floor(months % 12);

				days = Math.floor(days % 31);
				hours = Math.floor(hours % 24);
				mins = Math.floor(mins % 60);
				secs = Math.floor(secs % 60);

				var message = "";

				var item = {};
				var index = $scope.listap.indexOf(item);

				if (months <= 0) {
					// return message += days + " dias " + months +" Meses";
					return "presente " + days + " diAS";

				} else if (days >= 0) {
					return "futuro " + days + " dias " + months + " Meses";

				} else if (months < 3) {
					return "passado " + days + " dias " + months + " Meses";
				}

				return message;

			};

			$scope.getExp = function(date) {
				date = new Date($filter('date')(date, "yyyy/MM/dd"));
				var currdate = new Date($filter('date')(new Date(),
						"yyyy/MM/dd"));
				new Date().getFullYear()
				var exp = $scope.CalDate(date, currdate);

				return exp;
			}
		});