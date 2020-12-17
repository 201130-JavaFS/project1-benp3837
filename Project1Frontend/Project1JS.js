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
        let user = await resp.json(); //should return a user?? and JS will decide which page to redirect to depending on role
        //how do I get a user object (with all its values) from java into a json object?
        if(user.role === "Employee"){
            //send to employee page
        }else if (user.role === "Manager"){
            //send to manager page
        }

        //If role id = 2, send to employees page. if role id = 1, send to managers page
    } else {
        document.getElementById("login-row").innerText="Login Failed :( Reload and try again"; //anything besids 200  fails.
    }

}

