const url = 'http://localhost:8080/project-1/employees/'; //does this have to change?? employees uri right away? or...

document.getElementById("pastbutton").addEventListener('click', pastFunc);
document.getElementById("pendingbutton").addEventListener('click', pendingFunc);
document.getElementById("submitbutton").addEventListener('click', submitFunc);
document.getElementById("logoutbutton").addEventListener('click', logoutFunc);

async function pastFunc(){
    let response = await fetch(url+"past", {credentials: 'include'});
  
    if(response.status===200){
      document.getElementById("r_table").style.display = "block";
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
        row.appendChild(cell3)

        let cell4 = document.createElement("td");
        cell4.innerHTML = reimbursement.author;
        row.appendChild(cell4);
  
        let cell5 = document.createElement("td");
        cell5.innerHTML = reimbursement.resolver;
        row.appendChild(cell5);
  
        if(reimbursement.statusId == 2){
            let cell6 = document.createElement("td");
            cell6.innerHTML = "Accepted";
            row.appendChild(cell6);
        } else {
            let cell6 = document.createElement("td");
            cell6.innerHTML = "Rejected";
            row.appendChild(cell6);
        }

        let cell7 = document.createElement("td");
        switch(reimbursement.typeId){
        case 1:
            cell7.innerHTML = "Lodging";
            break;
        case 2:
            cell7.innerHTML = "Travel";
            break;
        case 3:
            cell7.innerHTML = "Food";
            break;
        case 4:
            cell7.innerHTML = "Other";
            break;
        }
        row.appendChild(cell7);

        let cell8 = document.createElement("td");
        cell8.innerHTML = reimbursement.reimbursementId;
        row.appendChild(cell8);
  
        document.getElementById("Body").appendChild(row);

        }
    }
}

async function pendingFunc(){
    let response = await fetch(url+"pending", {credentials: 'include'});

    if(response.status===200){
        document.getElementById("r_table2").style.display = "block";
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
          switch(reimbursement.typeId){
          case 1:
              cell6.innerHTML = "Lodging";
              break;
          case 2:
              cell6.innerHTML = "Travel";
              break;
          case 3:
              cell6.innerHTML = "Food";
              break;
          case 4:
              cell6.innerHTML = "Other";
              break;
          }
          row.appendChild(cell6);
  
          let cell7 = document.createElement("td");
          cell7.innerHTML = reimbursement.reimbursementId;
          row.appendChild(cell7);
    
          document.getElementById("Body2").appendChild(row);

        }
    }
}    

async function submitFunc(){

    let inputTypeId = document.getElementById("typeIdInput").value;
    let inputDescription = document.getElementById("descriptionInput").value;
    let inputAmount = document.getElementById("amountInput").value;

    let userInput = {
        typeId:inputTypeId,
        description:inputDescription,
        amount:inputAmount
    };

    let response = await fetch(url+"add", { 
        method:"POST", //sending it as a POST
        body: JSON.stringify(userInput),
        credentials: "include"
        });

    if(inputTypeId > 0 && inputTypeId < 5){
        document.getElementById("hiddenMessage").style.display = "block";
    } else document.getElementById("failureMessage").style.display = "block";

}

function logoutFunc(){
    window.location.replace('file:///C:/Users/benp3/OneDrive/Documents/PROGRAMMING/Project1/project1-benp3837/Project1Frontend/Project1HTML.html');
}