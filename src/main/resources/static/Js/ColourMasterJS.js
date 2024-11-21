
function colourMasterSave() {
	$(document).ready(function() {
		let colourCode = $("#ColourCode").val();
		let colourName = $("#ColourName").val()
		let colourMasterRemark = $("#ColourMasterRemark").val()
		/*console.log(colourmasterCode_validation(colourCode));*/
		if (colourCode === "" || colourName === "") {
			Swal.fire({
				title: "",
				text: "Please Enter the MandatoryFields",
				icon: "question"
			});
		} else {

			colourCodeValidation(colourCode).then((isValid) => {
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
						url: "/ColourMastersave",
						contentType: "application/json; charset=utf-8",
						data: JSON.stringify({
							"colourcode": colourCode,
							"colourname": colourName,
							"remark": colourMasterRemark
						}),
						success: function(sucess) {
							$("#ColourCode").val("");
							$("#ColourName").val("");
							$("#ColourMasterRemark").val("");
							Swal.fire({
								title: "Save Successfully",
								text: "",
								icon: "success"
							}).then(function() {
								window.location.reload();
							});
							/*window.location.reload();*/

						}
					})
				}
			}).catch((error) => {
				console.error("Error:", error);
			});
		}
	})
}

function colourMasterGetAll() {

	$.ajax({
		method: "GET",
		url: "/ColourMaster_getAll",
		contentType: "application/json; charset=utf-8",
		success: function(result) {

			console.log(result);
			var informtion = "";
			result.map((data) => {
				informtion += `<tr>
						<td>${data.id}</td>
						<td>${data.colourcode}</td>
						<td>${data.colourname}</td>
						<td>${data.remark}</td>
					</tr>`;
			})
			$("#colourMasterTable_tbody").html(informtion);
		}
	});
}

function colourCodeValidation(colourCode) {
	// Return a Promise from the function
	return new Promise(function(resolve, reject) {
		$.ajax({
			method: "GET",
			url: "/ColourMaster_getAll",
			contentType: "application/json; charset=utf-8",
			success: function(result) {
				console.log(result);
				let isCodeValid = result.some(function(obj) {
					return obj.colourcode.toLowerCase() === colourCode.toLowerCase();
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
