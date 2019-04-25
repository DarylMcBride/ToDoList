"use strict";

function openSidebar() {
	let x = document.getElementById("sidebar");
	if (x.style.display === "none") {
		x.style.display = "block";
	} else {
		x.style.display = "none";
	}

}
/*
function openLogin() {
	let x = document.getElementById("formContent");
	if (x.style.display === "none") {
		x.style.display = "inherit";
		x.style.zIndex = 1;
	} else {
		x.style.display = "none";
	}
}
*/
function addTaskButton() {
	let x = document.getElementById("addTaskCard");
	let y = document.getElementById("addTaskButton");

	if (x.style.display === "none") {
		x.style.display = "flex";
		y.style.display = "none";
	}
}

function cancelAddTask() {
	let x = document.getElementById("addTaskCard");
	let y = document.getElementById("addTaskButton");

	x.style.display = "none";
	y.style.display = "flex";
}
let data
let url = "http://localhost:8181/demo/task";
let request = new XMLHttpRequest();
request.open('GET', url);
request.responseType = "json";
request.onload = function () {
    data = request.response;
    console.log(data);
	addTaskList(data);
}
request.send();

function addTaskList(data) {
	let ele;
	let x =1;

	for (let item in data) {
		let a = data[item];
		ele = document.createElement("div")
		ele.setAttribute("id","cardBody" + x);
		ele.setAttribute("class", "card-body");
		x++;

		var openD = new Date(a.openDate);
		ele.innerHTML = "<div id='date'>"+
		" <p>Open Date : "+openD+"</p>" +
		" <p>Due Date : "+a.dueDate+"</p> "+
		"<a id='cardButtons' href='#' class='btn btn-primary'>Delete</a>" +
		"<a id='cardButtons' href='#' class='btn btn-primary'>Edit</a>" +
		"</div>" +
		"<div id='cardContent'>" +
			"<h5 class='card-title'>Title - "+a.name+"</h5>" +
			"<p class='card-text'><b>Description : </b></p>" +
			"<p id='descriptText' class='card-text'>"+a.descript+"</p>"
			"</div>" +
			"</div>";
		document.getElementById("v").append(ele);
}
	}

	