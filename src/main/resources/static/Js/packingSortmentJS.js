
function packingAssortmentSave() {
	$(document).ready(function() {
		let PackingCode = $("#PackingCode").val();
		let PackingName = $("#PackingName").val()
		let PackingassortmentRemark = $("#PackingassortmentRemark").val()
		/*console.log(colourmasterCode_validation(colourCode));*/
		if (PackingCode === "" || PackingName === "") {
			Swal.fire({
				title: "",
				text: "Please Enter the MandatoryFields",
				icon: "question"
			});
		} else {

			packingCodeValidation(PackingCode).then((isValid) => {
				console.log("Is the color code valid?", isValid);

				// Use the resolved value 'isValid' here
				if (isValid) {
					Swal.fire({
						title: "",
						text: "PackingCode is Already Exist",
						icon: "error"
					});
				} else {
					let object = $.ajax({
						method: "POST",
						url: "/packingassortment_save_restcontroller",
						contentType: "application/json; charset=utf-8",
						data: JSON.stringify({
							"packing_assortment_code": PackingCode,
							"packing_assortment_name": PackingName,
							"packing_assortment_remark": PackingassortmentRemark
						}),
						success: function(sucess) {
							$("#PackingCode").val("");
							$("#PackingName").val("");
							$("#PackingassortmentRemark").val("");
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

function packingAssortmentGetAll() {

	$.ajax({
		method: "GET",
		url: "/packingassortment_getAll_restcontroller",
		contentType: "application/json; charset=utf-8",
		success: function(result) {

			console.log(result);
			var informtion = "";
			result.map((data) => {
				informtion += `<tr>
						<td>${data.packing_assortment_id}</td>
						<td>${data.packing_assortment_code}</td>
						<td>${data.packing_assortment_name}</td>
						<td>${data.packing_assortment_remark}</td>
					</tr>`;
			})
			$("#packingassortment_tbody").html(informtion);
		}
	});
}

function packingCodeValidation(PackingCode) {
	// Return a Promise from the function
	return new Promise(function(resolve, reject) {
		$.ajax({
			method: "GET",
			url: "/packingassortment_getAll_restcontroller",
			contentType: "application/json; charset=utf-8",
			success: function(result) {
				console.log(result);
				let isCodeValid = result.some(function(obj) {
					return obj.packing_assortment_code.toLowerCase() === PackingCode.toLowerCase();
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
