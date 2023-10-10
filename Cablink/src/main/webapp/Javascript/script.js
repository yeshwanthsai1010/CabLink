/**
 * 
 */		
       	function clicklogin(){
       		console.log(20);
           const username = document.getElementById("uname").value;
           const password = document.getElementById("upwd").value;

           if (username === "" && password === "") {
               alert("Username and password are required.");
               event.preventDefault();
           } else if(username === ""){
			   alert("Username is required.");
			   event.preventDefault();
           }else if(password === ""){
			   alert("Password is required.");
			   event.preventDefault();
           }
           
           
       }
   
    		function clickregister(){
			const fullname = document.getElementById("name").value;
			const mobile = document.getElementById("umob").value;
			const gender1 = document.getElementsByName("gender");
			
            const username = document.getElementById("uname").value;
            const email = document.getElementById("uemail").value;
            const password = document.getElementById("upwd").value;
            const usernameRegex = /^[a-zA-Z0-9_]{3,20}$/; 
            const emailRegex = /^[a-zA-Z0-9._-]+@[a-zA-Z0-9.-]+\.[a-zA-Z]{2,4}$/; 
            const passwordRegex = /^(?=.*[A-Za-z])(?=.*\d)[A-Za-z\d]{8,}$/;
             
			if (fullname === "") {
                alert("Enter FullName");
                event.preventDefault();
            }
            if (mobile === "") {
                alert("Enter Mobile Number");
                event.preventDefault();
            }
            if (!gender1[0].checked && !gender1[1].checked ) {
                alert("Select Gender");
                event.preventDefault();
            }
            if (!usernameRegex.test(username)) {
                alert("Username must be alphanumeric and between 3-20 characters.");
                event.preventDefault();
            }

            if (!emailRegex.test(email)) {
                alert("Please enter a valid email address.");
                event.preventDefault();
            }

            if (!passwordRegex.test(password)) {
                alert("Password must be at least 8 characters and contain at least one letter and one number.");
                event.preventDefault();
            }

        }
        
        function clickedit(){
			const fullname = document.getElementById("name").value;
			const mobile = document.getElementById("umob").value;
			const gender1 = document.getElementsByName("gender");
			
            const email = document.getElementById("uemail").value;
            const emailRegex = /^[a-zA-Z0-9._-]+@[a-zA-Z0-9.-]+\.[a-zA-Z]{2,4}$/; 
             
			if (fullname === "") {
                alert("Enter FullName");
                event.preventDefault();
            }
            if (mobile === "") {
                alert("Enter Mobile Number");
                event.preventDefault();
            }
            if (!gender1[0].checked || !gender1[1].checked ) {
                alert("Select Gender");
                event.preventDefault();
            }
     
            if (!emailRegex.test(email)) {
                alert("Please enter a valid email address.");
                event.preventDefault();
            }

     
        }
		function clickhome(){
			const from = document.getElementById("From").value;
			const to = document.getElementById("To").value;
			  
			if (from === to) {
                alert("Select Different From and To");
                event.preventDefault();
            }
        }
  		function clickhomed(){
			const from = document.getElementById("From").value;
			const to = document.getElementById("To").value;
			const max_people = document.getElementById("max_people").value;
			if (from === to) {
                alert("Select Different From and To");
                event.preventDefault();
            }
            if(max_people === ""){
				alert("Enter Max Number People");
                event.preventDefault();
			}
        }

