
function sizeCombination_save() {

	$(document).ready(function() {

		var SizeCombinationCode = $("#SizeCombinationCode").val();
		var SizeCombinationName = $("#SizeCombinationName").val();
		var SizeCombinationRemark = $("#SizeCombinationRemark").val();

		if (SizeCombinationCode === "" || SizeCombinationName === "") {//vaidate the mandatory fields
			Swal.fire({
				title: "",
				text: "Please Enter the MandatoryFields",
				icon: "question"
			});
		} else {

			SizeCombinationCodeValidation(SizeCombinationCode).then((isValid) => {
				console.log("Is the color code valid?", isValid);
				// Use the resolved value 'isValid' here
				if (isValid) {
					Swal.fire({
						title: "",
						text: "SizeCombinationCode is Already Exist",
						icon: "error"
					});
				} else {
					let obj = $.ajax({//post SizeCombination data to the DB
						method: "POST",
						url: "/sizecombination_save",
						contentType: "application/json; charset=utf-8",
						data: JSON.stringify({
							"size_combination_code": SizeCombinationCode,
							"size_combination_name": SizeCombinationName,
							"size_combination_remark": SizeCombinationRemark
						}),
						success: function(sucess) {
							$("#SizeCombinationCode").val("");
							$("#SizeCombinationName").val("");
							$("#SizeCombinationRemark").val("");
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



function sizeCombination_getAll() {

	$.ajax({
		method: "GET",
		url: "/sizecombination_getAll_restController",
		contentType: "application/json; charset=utf-8",
		success: function(result) {

			console.log(result);
			var informtion = "";
			result.map((data) => {
				informtion += `<tr>
						<td>${data.size_combination_id}</td>
						<td>${data.size_combination_code}</td>
						<td>${data.size_combination_name}</td>
						<td>${data.size_combination_remark}</td>
					</tr>`;
			})
			$("#sizecombination_tbody").html(informtion);
		}
	});
}

function SizeCombinationCodeValidation(SizeCombinationCode) {
	// Return a Promise from the function
	return new Promise(function(resolve, reject) {
		$.ajax({
			method: "GET",
			url: "/sizecombination_getAll_restController",
			contentType: "application/json; charset=utf-8",
			success: function(result) {
				console.log(result);
				let isCodeValid = result.some(function(obj) {
					return obj.size_combination_code.toLowerCase() === SizeCombinationCode.toLowerCase();
				});
				resolve(isCodeValid); // Resolve the Promise with the validation result
			},
			error: function(error) {
				reject(error); // Reject the Promise if there's an error
			}
		});
	});
}
