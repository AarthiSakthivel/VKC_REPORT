
function MrpIndicatorSave() {
	$(document).ready(function() {
		let MRP_Code = $("#MRPcode").val();
		let MRP_Name = $("#MRPname").val()
		let MRP_Remark = $("#MRPRemark").val()
		/*console.log(colourmasterCode_validation(colourCode));*/
		if (MRP_Code === "" || MRP_Name === "") {
			Swal.fire({
				title: "",
				text: "Please Enter the MandatoryFields",
				icon: "question"
			});
		} else {

			MrpIndicatorValidation(MRP_Code).then((isValid) => {
				console.log("Is the color code valid?", isValid);

				// Use the resolved value 'isValid' here
				if (isValid) {
					Swal.fire({
						title: "",
						text: "ColourCode is Already Exist",
						icon: "error"
					});
				} else {
					let object = $.ajax({
						method: "POST",
						url: "/mrpindicator_save",
						contentType: "application/json; charset=utf-8",
						data: JSON.stringify({
							"mrp_indicator_code": MRP_Code,
							"mrp_indicator_name": MRP_Name,
							"mrp_indicator_remark": MRP_Remark
						}),
						success: function(sucess) {
							$("#MRPcode").val("");
							$("#MRPname").val("");
							$("#MRPRemark").val("");
							Swal.fire({
								title: "Save Successfully",
								text: "",
								icon: "success"
							}).then(function() {
								window.location.reload();
							});;

						}
					})
				}
			}).catch((error) => {
					console.error("Error:", error);
				});
		}
	})
}

function MrpIndicatorGetAll() {

	$.ajax({
		method: "GET",
		url: "/mrpindicator_getAll_restController",
		contentType: "application/json; charset=utf-8",
		success: function(result) {

			console.log(result);
			var informtion = "";
			result.map((data) => {
				informtion += `<tr>
						<td>${data.id}</td>
						<td>${data.mrp_indicator_code}</td>
						<td>${data.mrp_indicator_name}</td>
						<td>${data.mrp_indicator_remark}</td>
					</tr>`;
			})
			$("#MRPIncidator_tbody").html(informtion);
		}
	});
}

function MrpIndicatorValidation(MRP_Code) {
	// Return a Promise from the function
	return new Promise(function(resolve, reject) {
		$.ajax({
			method: "GET",
			url: "/mrpindicator_getAll_restController",
			contentType: "application/json; charset=utf-8",
			success: function(result) {
				console.log(result);
				let isCodeValid = result.some(function(obj) {
					return obj.mrp_indicator_code.toLowerCase() === MRP_Code.toLowerCase();
				});
				resolve(isCodeValid); // Resolve the Promise with the validation result
			},
			error: function(error) {
				reject(error); // Reject the Promise if there's an error
			}
		});
	});
}

// Usage example:
