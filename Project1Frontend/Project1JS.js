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

    let userDetails = {
        username:usern,
        password:userp
    };

    let resp = await fetch(url+"login", { //resp will be the result of our res.x, res.y, res.z lines in the servlet
        method:"POST", //sending it as a POST
        body: JSON.stringify(userDetails),
        credentials: "include"
        //credentials: "include" will ensure that the cookie is captured
        //future fetch requests will also require this value in order to send the cookie back
    });

    if(resp.status===200){
        document.getElementById("login-row").innerText="You Have Logged In!";
        let user = await resp.json(); //should return a user, and JS will decide which page to redirect to depending on role
        
        if(user.roleId === 2){
            //send to employee page
            window.location.replace('file:///C:/Users/benp3/OneDrive/Documents/PROGRAMMING/Project1/project1-benp3837/Project1Frontend/EmployeePage.html');
        }else if (user.roleId === 1){
            //send to manager page
            window.location.replace('file:///C:/Users/benp3/OneDrive/Documents/PROGRAMMING/Project1/project1-benp3837/Project1Frontend/ManagerPage.html');
        }

        //If role id = 2, send to employees page. if role id = 1, send to managers page
    } else {
        document.getElementById("login-row").innerText="Login Failed :( Reload and try again"; //anything besids 200  fails.
    }

}

