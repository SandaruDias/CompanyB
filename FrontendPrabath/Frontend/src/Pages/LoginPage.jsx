import React, { useState } from "react";
import "./../Styles/Login.css";
import login_image from "./../Images/Login.png";
import axios from "axios"
import { useHistory } from "react-router-dom";
import { Link } from "react-router-dom";

function LoginPage() {
  const [details, setDetails] = useState({ username: "", password: "" });
  const history = useHistory(); // Create a history object
  const handleChange = (event) => {
    setDetails((prev) => ({
      ...prev,
      [event.target.name]: event.target.value,
    }));
  };

  const handleSubmit = async (e) => {
    e.preventDefault();
    console.log(details);
    //setup vaidation
    //pass to database
    try {
      const response = await axios.put(`http://localhost:8090/companyB/manufacturing/User/adminLogin/${details.username}/${details.password}`);
      console.log(response.data); // Log the response data
      if (response.data === "Login Successful") {
        // Redirect to AdminInterface.jsx page
        history.push("/companyB/manufacturing/AdminInterface")
      } else {
        // Handle other cases if needed
        alert("Login failed: " + response.data);
      }
      // If you need to perform any action based on the response data, do it here

      // Reset the form after successful login
      setDetails({ username: "", password: "" });
    } catch (error) {
      console.error('Error logging in:', error.message);
      // You can handle errors here, such as displaying an error message to the user
    };
  };

  return (
    <div className="login-container" style={{backgroundColor : "#c5c5c5"}}>
      <div className="login">
        <div className="details">
        <div className="navigation-bar">
        <button  className="home-button"><Link to={"/companyB/manufacturing"} style={{textDecoration: "none", color: "white"}} >Selection Page</Link></button>  
            <button className="home-button"><Link to={"/home"} style={{textDecoration: "none", color: "white"}}>Home Page</Link></button>  
          </div>
          <h1 style = {{textAlign: "center"}} className="login-title">Admin Portal</h1>
          
          <div  className="username">
            <input 
              type="text"
              placeholder="Username"
              name="username"
              onChange={handleChange}
              value={details.username}
              style={{width : "100%"}}
            />
          </div>
          <div className="password">
            <input
              type="password"
              placeholder="Password"
              name="password"
              onChange={handleChange}
              value={details.password}
            />
          </div>
          <button style={{padding: "10px"}} className="login-button" onClick={handleSubmit}>
            Login
          </button>
        </div>

      </div>
    </div>
  );
}

export default LoginPage;
