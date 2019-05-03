"use strict";


let data
let url = "http://localhost:8181/demo/task";

let request = new XMLHttpRequest();
let postRequest = new XMLHttpRequest();

request.open('GET', url);
request.responseType = "json";
request.onload = function () {
	data = request.response;
	console.log(data);
	addTaskList(data);
}
request.send();




function openSidebar() {
	let x = document.getElementById("sidebar");
	if (x.style.display === "none") {
		x.style.display = "block";
	} else {
		x.style.display = "none";
	}

}

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



//display tasks to html
function addTaskList(data) {
	let ele;
	let x =1;

	for (let item in data) {
		let a = data[item];
		ele = document.createElement("div")
		ele.setAttribute("id","cardBody" + x);
		ele.setAttribute("class", "card-body");
		let id = a.taskId;
		x++;
		console.log(id);
		
		ele.innerHTML = "<div id='date'>"+
		" <p>Open Date : "+a.openDate+"</p>" +
		" <p>Due Date : "+a.dueDate+"</p> "+
		"<a id='cardButtons' onclick='deleteTask("+id+");' class='btn btn-primary'>Delete</a>" +
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

function deleteTask(taskId) {
	let deleteURL =  "http://localhost:8181/demo/task/"+taskId+"";
	let id = taskId
	console.log(id);
	request.open('DELETE', deleteURL);
	request.send();
}

//add task to db
function createTask() {
	let name = document.getElementById("addTask1").value;
	let descript = document.getElementById("addTask2").value;
	let dueDate = document.getElementById("dateInput").value;

	let postTask = {
		"name": name,
		"descript":descript,
		"dueDate": dueDate,
		"openDate":getCurrentDate()
	}
	let final = JSON.stringify(postTask);
	console.log(postTask);


	postRequest.open('POST', url);
	postRequest.setRequestHeader('Content-type','application/json');
	postRequest.send(final);

}

//get current date
function getCurrentDate () {
	let openDate = new Date ();
	let day = String(openDate.getDate()).padStart(2,'0');
	let month = String(openDate.getMonth() +1).padStart(2,'0');
	let year = openDate.getFullYear();
	let result = year +'-'+month+'-'+day;
	return result;
}

