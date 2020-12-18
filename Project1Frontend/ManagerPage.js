const url = 'http://localhost:8080/project-1/managers/'; //does this have to change?? employees uri right away? or...

document.getElementById("allbutton").addEventListener('click', allFunc);


async function allFunc(){
    let response = await fetch(url+"all", {credentials: 'include'});
  
    if(response.status===200){
      console.log(response);
      let data = await response.json(); //this SHOULD send back a list of all past reimbursements
  
      for(let reimbursement of data){
        console.log(reimbursement);
        let row = document.createElement("tr");
  
        let cell = document.createElement("td");
        cell.innerHTML = reimbursement.amount; //SWITCH THESE AVENGERS THINGS WITH REIMBURSEMENT THINGS. look at the demo to see how
        row.appendChild(cell);
  
        let cell2 = document.createElement("td");
        cell2.innerHTML = reimbursement.timeSubmitted;
        row.appendChild(cell2);
  
        let cell3 = document.createElement("td");
        cell3.innerHTML = reimbursement.description;
        row.appendChild(cell3);
  
        let cell4 = document.createElement("td");
        cell4.innerHTML = reimbursement.author;
        row.appendChild(cell4);
  
        let cell5 = document.createElement("td");
        cell5.innerHTML = reimbursement.resolver;
        row.appendChild(cell5);
  
        let cell6 = document.createElement("td");
        cell6.innerHTML = reimbursement.statusId;
        row.appendChild(cell6);

        let cell7 = document.createElement("td");
        cell7.innerHTML = reimbursement.typeId;
        row.appendChild(cell7);

  
        document.getElementById("Body").appendChild(row);

        }
    }
}