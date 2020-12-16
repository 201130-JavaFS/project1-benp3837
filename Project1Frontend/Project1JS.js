const url = 'http://localhost:8080/project-1/';

document.getElementById("loginbtn").addEventListener('click', loginFunc);

//document.getElementById("getAvButton").addEventListener('click', pastReimbursements);
//this^^^ amongst other buttons will show up upon login, and that's when the user chooses what they wanna do 

//EMPLOYEES need a buttons to view past tickets and pending tickets, and a form to add new tickets

//MANAGERS need a button to view all tickets, an input bar (and search button) to filter tickets by status,
//and (button or text box) to aprove/reject


async function loginFunc(){
    let usern = document.getElementById("username").value;
    let userp = document.getElementById("password").value;

    let user = {
        username:usern,
        password:userp
    };

    let resp = await fetch(url+"login", { //resp will be the result of our res.x, res.y, res.z lines in the servlet
        method:"POST", //sending it as a POST
        body: JSON.stringify(user),
        credentials: "include"
        //credentials: "include" will ensure that the cookie is captured
        //future fetch requests will also require this value in order to send the cookie back
    });
    //if you recall the parameters a fetch request takes, you'll understand what's goin on here

    if(resp.status===200){
        document.getElementById("login-row").innerText="You Have Logged In!";
        //THEN SEND THEM EITHER TO THE EMPLOYEE OR MANAGER HTML PAGE
        //Realistic goal: try to get the "You Have Logged In" text. you can work from here down.
    } else {
        document.getElementById("login-row").innerText="Login Failed :( Reload and try again"; //anything besids 200  fails.
    }

}

async function assembleFunc(){
    let response = await fetch(url+"avengers", {credentials: 'include'});
  
    if(response.status===200){
      console.log(response);
      let data = await response.json(); //data = the result of our fetch request aka the response object
  
      for(let avenger of data){
        console.log(avenger);
        let row = document.createElement("tr");
  
        let cell = document.createElement("td");
        cell.innerHTML = avenger.aveId;
        row.appendChild(cell);
  
        let cell2 = document.createElement("td");
        cell2.innerHTML = avenger.aveName;
        row.appendChild(cell2);
  
        let cell3 = document.createElement("td");
        cell3.innerHTML = avenger.power;
        row.appendChild(cell3);
  
        let cell4 = document.createElement("td");
        cell4.innerHTML = avenger.firstName;
        row.appendChild(cell4);
  
        let cell5 = document.createElement("td");
        cell5.innerHTML = avenger.lastName;
        row.appendChild(cell5);
  
        let cell6 = document.createElement("td");
        cell6.innerHTML = avenger.powerLevel;
        row.appendChild(cell6);
  
        if(avenger.home != null){
          let cell7 = document.createElement("td");
          cell7.innerHTML = avenger.home.homeName;
          row.appendChild(cell7);
        }else {
          let cell7 = document.createElement("td");
          row.appendChild(cell7);
        }
  
        document.getElementById("avBody").appendChild(row);

        }
    }
}