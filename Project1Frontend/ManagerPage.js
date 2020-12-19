const url = 'http://localhost:8080/project-1/managers/'; //does this have to change?? employees uri right away? or...

document.getElementById("allbutton").addEventListener('click', allFunc);
document.getElementById("filterbutton").addEventListener('click', filterFunc);
document.getElementById("resolvebutton").addEventListener('click', resolveFunc);


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

        let cell8 = document.createElement("td");
        cell8.innerHTML = reimbursement.reimbursementId;
        row.appendChild(cell8);

        document.getElementById("Body").appendChild(row);

        }
    }
}

async function filterFunc(){

    let input = document.getElementById("dataInput").value;

    let userInput = {
        statusId:input
    };

    let response = await fetch(url+"filter", { 
        method:"POST", //sending it as a POST
        body: JSON.stringify(userInput),
        credentials: "include"

        });

    if(response.status===200){
        console.log(response);
        let data = await response.json(); //this SHOULD send back a list of all past reimbursements

        for(let reimbursement of data){
            console.log(reimbursement);
            let row = document.createElement("tr");
        
            let cell = document.createElement("td");
            cell.innerHTML = reimbursement.amount;
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

            let cell8 = document.createElement("td");
            cell8.innerHTML = reimbursement.reimbursementId;
            row.appendChild(cell8);
      
            document.getElementById("Body2").appendChild(row);
      
        }   
    }  
}

async function resolveFunc(){

    let inputId = document.getElementById("ticketInput").value;
    let inputNewStatus = document.getElementById("statusInput").value;

    let userInput = {
        reimbursementId:inputId,
        statusId:inputNewStatus
    };

    let response = await fetch(url+"resolve", { 
        method:"POST", //sending it as a POST
        body: JSON.stringify(userInput),
        credentials: "include"
        });

    if(response.status=200){
        document.getElementById("hiddenMessage").style.display = "block";
    }

}