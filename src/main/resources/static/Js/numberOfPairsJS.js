
function numberOfPairSave() {
	$(document).ready(function() {
		let NumberOfPair = $("#NumberOfPair").val();
		let Pair = $("#Pair").val()
		let NumberOfPairRemark = $("#NumberOfPairRemark").val()
		/*console.log(colourmasterCode_validation(colourCode));*/
		if (NumberOfPair === "" || Pair === "") {
			Swal.fire({
				title: "",
				text: "Please Enter the MandatoryFields",
				icon: "question"
			});
		} else {

			numberOfPair_code_Validation(NumberOfPair).then((isValid) => {
				console.log("Is the numberOfPair_code valid?", isValid);

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
						url: "/numberOfPairs_save",
						contentType: "application/json; charset=utf-8",
						data: JSON.stringify({
							"numberofpairs_code": NumberOfPair,
							"numberofpairs_name": Pair,
							"numberofpairs_remark": NumberOfPairRemark
						}),
						success: function(sucess) {
							$("#NumberOfPair").val("");
							$("#Pair").val("");
							$("#NumberOfPairRemark").val("");
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

function numberOfPairGetAll() {

	$.ajax({
		method: "GET",
		url: "/numberofPairs_getAll_restController",
		contentType: "application/json; charset=utf-8",
		success: function(result) {

			console.log(result);
			var informtion = "";
			result.map((data) => {
				informtion += `<tr>
						<td>${data.numberofpairs_id}</td>
						<td>${data.numberofpairs_code}</td>
						<td>${data.numberofpairs_name}</td>
						<td>${data.numberofpairs_remark}</td>
					</tr>`;
			})
			$("#numberOfPairs_tbody").html(informtion);
		}
	});
}

function numberOfPair_code_Validation(NumberOfPair) {
	// Return a Promise from the function
	return new Promise(function(resolve, reject) {
		$.ajax({
			method: "GET",
			url: "/numberofPairs_getAll_restController",
			contentType: "application/json; charset=utf-8",
			success: function(result) {
				console.log(result);
				let isCodeValid = result.some(function(obj) {
					return obj.numberofpairs_code.toLowerCase() === NumberOfPair.toLowerCase();
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
