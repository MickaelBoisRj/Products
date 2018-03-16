

    angular.module('app', [])
      .controller('ProductController', function($http) {
		var self = this;
		self.message = "";
		
		self.products = [];
		self.items = [];
		
		self.addItem = function(product) {
			self.items.push({ id: product.id, qty: 1 }); 
		};
		self.send = function(){
			$http.post("/order",self.items).then(function(resp){
				self.message = "Ok : "+resp.data.transactionId;
			});
			
		}
		
		function onInit(){
			$http.get("/products").then(function (resp){
			  self.products = resp.data;
			});
			
		}
        onInit();
      });

