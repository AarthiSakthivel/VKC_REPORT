
function setItemMasteValues() {
	$(document).ready(function() {
		SetcolorCodevalue();
		setSizeCategoryCodevalue();
		setMrpIndicatorCodevalue();
		setSizeCombinationCodevalue();
		setPackingAssortmentCodevalue();
		setNumberofPairsvalue();
	})

}

function SetcolorCodevalue() {

	$.ajax({
		method: "GET",
		url: "/ColourMaster_getAll",
		contentType: "application/json; charset=utf-8",
		success: function(result) {

			//console.log(result);
			var informtion = "<option selected value=''> Select the Color Details</option>";
			result.map((data) => {
				console.log(data)
				informtion += `
						<option value=${data.id}>${data.colourcode} - ${data.colourname}</option>`;
			})
			$("#colourcode").html(informtion);
		}
	});
}

function setSizeCombinationCodevalue() {

	$.ajax({
		method: "GET",
		url: "/sizecombination_getAll_restController",
		contentType: "application/json; charset=utf-8",
		success: function(result) {

			console.log(result);
			var informtion = "<option selected value=''>Select the Size Combination Details</option>";
			result.map((data) => {
				informtion += `
						<option value="${data.size_combination_id}">${data.size_combination_code} - ${data.size_combination_name}</option>
				`;
			})
			$("#sizeCombination").html(informtion);
		}
	});
}

function setSizeCategoryCodevalue() {

	$.ajax({
		method: "GET",
		url: "/sizeCategory_getAll_RestController",
		contentType: "application/json; charset=utf-8",
		success: function(result) {
			console.log(result);
			var informtion = "<option selected value=''>Select the Size Category Details</option>";
			result.map((data) => {
				informtion += `<option value="${data.id}">${data.size_category_code} - ${data.size_category_name}</option>`;
			})
			$("#sizecategory").html(informtion);
		}
	});
}


function setMrpIndicatorCodevalue() {

	$.ajax({
		method: "GET",
		url: "/mrpindicator_getAll_restController",
		contentType: "application/json; charset=utf-8",
		success: function(result) {
			console.log(result);
			var informtion = "<option selected value=''>Select the MRP Indicator Details</option>";
			result.map((data) => {
				informtion += `<option value="${data.id}">${data.mrp_indicator_code} - ${data.mrp_indicator_name}</option>`;
			})
			$("#MRPindicator").html(informtion);
		}
	});
}

function setPackingAssortmentCodevalue() {

	$.ajax({
		method: "GET",
		url: "/packingassortment_getAll_restcontroller",
		contentType: "application/json; charset=utf-8",
		success: function(result) {
			console.log(result);
			var informtion = "<option selected value=''>Select the Packing Assortment Details</option>";
			result.map((data) => {
				informtion += `<option value="${data.packing_assortment_id}">${data.packing_assortment_code} - ${data.packing_assortment_name}</option>`;
			})
			$("#packingassortment").html(informtion);
		}
	});
}

function setNumberofPairsvalue() {

	$.ajax({
		method: "GET",
		url: "/numberofPairs_getAll_restController",
		contentType: "application/json; charset=utf-8",
		success: function(result) {
			console.log(result);
			var informtion = "<option selected value=''>Select the Number of Pairs Details</option>";
			result.map((data) => {
				informtion += `<option value="${data.numberofpairs_id}">${data.numberofpairs_code} - ${data.numberofpairs_name}</option>`;
			})
			$("#Numberofpairs").html(informtion);
		}
	});
}

function generateMaterial() {

	var MaterialTypeOptions = $("#MaterialtypeClassification option:selected").text();
	var Articlenumber = $("#Articlenumber option:selected").text();
	var colourcode = $("#colourcode option:selected").text();
	var sizeCombination = $("#sizeCombination option:selected").text();
	var sizecategory = $("#sizecategory option:selected").text();
	var MRPindicator = $("#MRPindicator option:selected").text();
	var packingassortment = $("#packingassortment option:selected").text();
	var Numberofpairs = $("#Numberofpairs option:selected").text();
	var domestic = $("#Numberofpairs option:selected").text();


	var MaterialTypeOptionsVal = $("#MaterialtypeClassification").val();
	var ArticlenumberVal = $("#Articlenumber").val();
	var colourcodeVal = $("#colourcode option:selected").val();
	var sizeCombinationVal = $("#sizeCombination option:selected").val();
	var sizecategoryVal = $("#sizecategory option:selected").val();
	var MRPindicatorVal = $("#MRPindicator option:selected").val();
	var packingassortmentVal = $("#packingassortment option:selected").val();
	var NumberofpairsVal = $("#Numberofpairs option:selected").val();

	if (ArticlenumberVal != "" && MaterialTypeOptionsVal != "" && colourcodeVal != "" && sizeCombinationVal != "" && sizecategoryVal != "" && MRPindicatorVal != "" && packingassortmentVal != "" && NumberofpairsVal != "") {

		console.log(MaterialTypeOptions.split(" "));
		console.log(Articlenumber.split(" ")[0]);
		console.log(colourcode.split(" ")[0]);
		console.log(sizeCombination.split(" ")[0]);
		console.log(sizecategory.split(" ")[0]);
		console.log(MRPindicator.split(" ")[0]);
		console.log(packingassortment.split(" ")[0]);
		console.log(Numberofpairs.split(" ")[0]);
		console.log(domestic);
		$("#MaterialNumber").val(MaterialTypeOptions.split(" ") + " - " + Articlenumber.split(" ")[0] + " - " + colourcode.split(" ")[0] + " - " + sizecategory.split(" ")[0] + " - " + MRPindicator.split(" ")[0] + " - " + domestic.split(" ")[0] + " - " + sizeCombination.split(" ")[0] + " - " + packingassortment.split(" ")[0] + " - " + Numberofpairs.split(" ")[0]);



	} else {
		Swal.fire({
			title: "",
			text: "Please Enter All the value",
			icon: "error"
		});
	}

}
// Function to get the selected text and value of a dropdown
const getSelectedTextAndValue = (selector) => {
	const selectedOption = $(selector + " option:selected");
	return {
		text: selectedOption.text(),
		val: selectedOption.val()
	};
};



function sumbitTotalValue() {

	console.log("Enter");
	if ($("#Materialtype").val() != "" && $("#MaterialNumber").val() != "") {
		$.ajax({
			method: "POST",
			url: "/submitAll",
			contentType: "application/json; charset=utf-8",
			data: JSON.stringify({
				"materialType": $("#Materialtype").val(),
				"materialNumber": $("#MaterialNumber").val(),
				"materialTypeClassification": getSelectedTextAndValue("#MaterialtypeClassification").val,
				"articlenumber": getSelectedTextAndValue("#Articlenumber").val,
				"colourcode": getSelectedTextAndValue("#colourcode").val,
				"sizeCategory": getSelectedTextAndValue("#sizecategory").val,
				"mrpindicator": getSelectedTextAndValue("#MRPindicator").val,
				"domesticExportIndication": getSelectedTextAndValue("#domestic").val,
				"sizeCombination": getSelectedTextAndValue("#sizeCombination").val,
				"packingassortment": getSelectedTextAndValue("#packingassortment").val,
				"numberofpairs": getSelectedTextAndValue("#Numberofpairs").val
			}),
			success: function(result) {
				if (result) {
					Swal.fire({
						title: "Success",
						text: "",
						icon: "success"
					});

					$("#Materialtype").val("")
					$("#MaterialNumber").val("")
					$("#MaterialtypeClassification").val("")
					$("#Articlenumber").val("")
					$("#colourcode").val("")
					$("#sizecategory").val("")

					$("#MRPindicator").val("")
					$("#sizeCombination").val("")
					$("#domestic").val("")
					$("#packingassortment").val("")
					$("#Numberofpairs").val("")
				}
			}
		});
	} else {
		Swal.fire({
			title: "",
			text: "Plese Generate Material Code and Remark",
			icon: "error"
		});
	}
}


