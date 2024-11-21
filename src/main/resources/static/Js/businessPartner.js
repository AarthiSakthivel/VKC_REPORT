function validation() {
	var type = getSelectedTextAndValue("#type");
	var state = getSelectedTextAndValue("#state")
	var code = $("#code").val();
	var name = $("#name").val();
	var mobile = $("#mobile").val();
	var email = $("#email").val();
	var address = $("#address").val();



	if (code !== "" && name !== "") {
		let customerObj = {
			"state": state.val,
			"type": type.val,
			"code": code,
			"name": name,
			"mobile": mobile,
			"email": email,
			"address": address
		};
		console.log(customerObj);

		$.ajax({
			method: "POST",
			url: "savebusinesspartner",
			contentType: "application/json; charset=utf-8",
			data: JSON.stringify(customerObj),
			success: function(result) {
				if (result) {
					Swal.fire({
						title: "Success",
						text: "",
						icon: "success"
					}).then(function() {
						window.location.reload();
					});
				}
			}
		});



	} else {

		if (code === "") {
			Swal.fire({
				icon: "error",
				title: "Oops...",
				text: "Please Fill Code Field",
			});
		} else if (name === "") {
			Swal.fire({
				icon: "error",
				title: "Oops...",
				text: "Please Fill Name Field",
			});
		}

	}

	//console.log(state);
	//console.log(code);
	//console.log(name);
	//console.log(email);
	//console.log(mobile);
	//console.log(address);

}
const setCode = () => {
	var type = getSelectedTextAndValue("#type");
	console.log(type);
	var state = getSelectedTextAndValue("#state");
	if (state.val !== "" && type.val !== "") {

		$.ajax({
			method: "GET",
			url: "/businessPartner/businesspartner_getAll",
			contentType: "application/json; charset=utf-8",
			success: function(result) {

				console.log(result);
				var filterData = result.filter(function(obj) {
					return state.val === obj.state && type.val === obj.type;
				}).map((obj) => {
					return obj.code.split("-")[2];
				}).sort();

				console.log(filterData);
				console.log(filterData.length);
				if (filterData.length === 0) {
					$("#code").val(type.val + "-" + state.val + "-" + "0001");
				} else {
					var lastCode = filterData[filterData.length - 1];
					let number = parseInt(lastCode, 10); // Parse the string to an integer
					number++; // Increment the number
					let incrementedNumberStr = number.toString().padStart(4, '0');
					$("#code").val(type.val + "-" + state.val + "-" + incrementedNumberStr);

				}

			}
		});




		//	$("#code").val(type.val + " - " + state.val + " - ");
	} else {
		$("#code").val("");
	}
}

const getSelectedTextAndValue = (selector) => {
	const selectedOption = $(selector + " option:selected");
	return {
		text: selectedOption.text(),
		val: selectedOption.val()
	};
};

const viewAllBusinessPartner = () => {
	$.ajax({
		method: "GET",
		url: "/businessPartner/businessPartnerViewAll",
		contentType: "application/json; charset=utf-8",
		success: function(result) {

			console.log(result);
			/*var informtion = "";
			result.map((data) => {
				informtion += `<tr>
						<td>${data.id}</td>
						<td>${data.type}</td>
						<td>${data.state}</td>
						<td>${data.code}</td>
						<td>${data.name}</td>
						<td>${data.mobile}</td>
						<td>${data.email}</td>
						<td>${data.address}</td>
						<td>${data.syncStatus}</td>
						<td>${data.syncOn}</td>
					</tr>`;
			})
			$("#businessMaster_tbody").html(informtion);*/
		}
	});



}
