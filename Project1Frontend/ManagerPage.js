const url = 'http://localhost:8080/project-1/managers/'; //does this have to change?? employees uri right away? or...

document.getElementById("allbutton").addEventListener('click', allFunc);
document.getElementById("filterbutton").addEventListener('click', filterFunc);


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

        //I understand putting an input field won't work here, cos it only fills in the reimbursement values. 
        //But how can I emulate what I'm trying to do?

        let cell8 = document.createElement("td");
        cell8.innerHTML = console.log("hi");
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

    let response = await fetch(url+"filter", { //resp will be the result of our res.x, res.y, res.z lines in the servlet
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
      
              document.getElementById("Body2").appendChild(row);
      
              }   

            } 
    //it'll be a POST, so that second argument looks similar to the login one

    //so we should send the value of the input as json, HelloFetch shows how you can call user-inputted values
    //java takes the inputted item and sends it to a ManagersController method -> service -> DAO

    //get it back and do the same as above cell fills


    
}

async function resolveFunc(){
    let response = await fetch(url+"resolve", {credentials: 'include'});

    //should there be an input adjacent to each ticket row to change the status id? would be pretty cool
    //then if the manager submits that, it goes in and changes the status, then we can select them to check

    //if not, maybe just go to something that looks like your login/logout.
    //will have to supply the ticket in question, and the new statusid
}