function sizeCategory_save() {

	$(document).ready(function() {

		var SizeCode = $("#SizeCode").val();
		var SizeName = $("#SizeName").val();
		var SizeCategoryRemark = $("#SizeCategoryRemark").val();
		console.log(SizeCode);


		if (SizeCode === "" || SizeName === "") {
			Swal.fire({
				title: "",
				text: "Please Enter the MandatoryFields",
				icon: "question"
			});
		} else {

			SizeCodeValidation(SizeCode).then((isValid) => {
				console.log("Is the color code valid?", isValid);

				// Use the resolved value 'isValid' here
				if (isValid) {
					Swal.fire({
						title: "",
						text: "SizeCode is Already Exist",
						icon: "error"
					});
				} else {
					let obj = $.ajax({
						method: "POST",
						url: "/sizeCategory_Save",
						contentType: "application/json; charset=utf-8",
						data: JSON.stringify({
							"size_category_code": SizeCode,
							"size_category_name": SizeName,
							"size_category_remark": SizeCategoryRemark
						}),
						success: function(sucess) {
							$("#SizeCode").val("");
							$("#SizeName").val("");
							$("#SizeCategoryRemark").val("");
							Swal.fire({
								title: "Save Successfully",
								text: "",
								icon: "success"
							}).then(function() {
								window.location.reload();
							});;

						}
					});
				}
			}).catch((error) => {
				console.error("Error:", error);
			});
		}
	})

}
function sizeCategoryGetAll() {

	$.ajax({
		method: "GET",
		url: "/sizeCategory_getAll_RestController",
		contentType: "application/json; charset=utf-8",
		success: function(result) {

			console.log(result);
			var informtion = "";
			result.map((data) => {
				informtion += `<tr>
						<td>${data.id}</td>
						<td>${data.size_category_code}</td>
						<td>${data.size_category_name}</td>
						<td>${data.size_category_remark}</td>
					</tr>`;
			})
			$("#sizeCategory_tablebody").html(informtion);
		}
	});
}

function SizeCodeValidation(SizeCode) {
	// Return a Promise from the function
	return new Promise(function(resolve, reject) {
		$.ajax({
			method: "GET",
			url: "/sizeCategory_getAll_RestController",
			contentType: "application/json; charset=utf-8",
			success: function(result) {
				console.log(result);
				let isCodeValid = result.some(function(obj) {
					return obj.size_category_code.toLowerCase() === SizeCode.toLowerCase();
				});
				resolve(isCodeValid); // Resolve the Promise with the validation result
			},
			error: function(error) {
				reject(error); // Reject the Promise if there's an error
			}
		});
	});
}
