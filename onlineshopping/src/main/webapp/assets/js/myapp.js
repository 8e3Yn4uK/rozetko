$(function() {

	// for adding a loader
	$(window).load(function () {
		setTimeout(function () {
			$(".se-pre-con").fadeOut("slow");
		}, 500);
	});

	// for handling CSRF token
	var token = $('meta[name="_csrf"]').attr('content');
	var header = $('meta[name="_csrf_header"]').attr('content');

	if ((token != undefined && header != undefined) && (token.length > 0 && header.length > 0)) {
		// set the token header for the ajax request
		$(document).ajaxSend(function (e, xhr, options) {
			xhr.setRequestHeader(header, token);
		});
	}


	// solving the active menu problem
	switch (menu) {

		case 'About Us':
			$('#about').addClass('active');
			break;
		case 'Contact Us':
			$('#contact').addClass('active');
			break;
		case 'All Products':
			$('#listProducts').addClass('active');
			break;
		case 'Product Management':
			$('#manageProduct').addClass('active');
			break;
		case 'Shopping Cart':
			$('#userModel').addClass('active');
			break;
		default:
			if (menu == "Home")
				break;
			$('#listProducts').addClass('active');
			$('#a_' + menu).addClass('active');
			break;
	}

	// code for jquery dataTable
	var $table = $('#productListTable');

	// execute the below code only where we have this table
	if ($table.length) {
		// console.log('Inside the table!');

		var jsonUrl = '';
		if (window.categoryId == '') {
			jsonUrl = window.contextRoot + '/json/data/all/products';
		} else {
			jsonUrl = window.contextRoot + '/json/data/category/' + window.categoryId + '/products';
		}

		$table.DataTable({

			lenghtMenu: [[3, 5, 10, -1], ['3 Products', '5 Products', '10 Products', 'ALL']],
			pageLength: 5,
			ajax: {
				url: jsonUrl,
				dataSrc: ''
			},
			columns: [
				{
					data: 'name'
				},
				{
					data: 'brand'
				},
				{
					data: 'unitPrice'
				},
				{
					data: 'quantity'
				}


			]


		});

	}
}
